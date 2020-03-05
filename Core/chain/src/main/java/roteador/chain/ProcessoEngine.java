package roteador.chain;

import java.util.Map;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import roteador.chain.processo.Processo;
import roteador.chain.processo.Resultado;
import roteador.chain.processo.Sequencia;
import roteador.chain.processo.Sucesso;
import roteador.chain.processo.Transacao;
import roteador.core.exception.command.CommandException;
import roteador.core.exception.service.TransactionExecutionException;

public class ProcessoEngine {

    private final BeanFactory beanContext;

    private final AbstractPlatformTransactionManager transactionManager;

    private final Context context;

    private final Map<String, Processo> processoMap;

    private Processo processo;

    private static final Logger LOG = Logger.getLogger(ProcessoEngine.class);

    public ProcessoEngine(final Context context, final AbstractPlatformTransactionManager txManager, final BeanFactory beanFactory, final Map<String, Processo> processoMap) {
        this.context = context;
        this.transactionManager = txManager;
        this.beanContext = beanFactory;
        this.processoMap = processoMap;
    }

    public void executarProcesso(final Processo processo) throws Exception {
        this.processo = processo;
        final Transacao transacaoInicio = processo.getMapTransacoes().get(processo.getInicio());
        final Sequencia sequenciaInicio = processo.getMapSequencias().get(processo.getInicio());

        // Procurar primeiro na lista de transacoes
        if(transacaoInicio!=null){
            executarTransacao(transacaoInicio);
        }else if(sequenciaInicio!=null){
            executarSequencia(sequenciaInicio);
        }

    }

    private void executarTransacao(final Transacao transacao) throws Exception {
        LOG.info("INICIANDO UMA NOVA TRANSACAO");
        final DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        definition.setName(transacao.getNome());
        definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        final TransactionStatus status = transactionManager.getTransaction(definition);

        final String sequenciaInicio = transacao.getMapSequencias().keySet().iterator().next();
        try {
            executarSequenciaTransacao(transacao, transacao.getMapSequencias().get(sequenciaInicio));
            transactionManager.commit(status);
            tratarRetornoTransacao(transacao);
        } catch (final TransactionExecutionException e) {
            transactionManager.rollback(status);
            LOG.error("FAZENDO ROLLBACK NA TRANSACAO. EXCEPTION: " + e, e);
            throw e;
        } catch (final CommandException e) {
            LOG.error("FAZENDO ROLLBACK NA TRANSACAO. EXCEPTION: " + e, e);
            transactionManager.rollback(status);
            throw e;
        } catch (final Exception e) {
            LOG.error("FAZENDO ROLLBACK NA TRANSACAO. EXCEPTION: " + e, e);
            transactionManager.rollback(status);
            throw new Exception("Problema no processo", e);
        } finally {
            LOG.info("FINALIZANDO TRANSACAO");
        }
    }

    /**
     * 
     * @param transacao
     * @throws Exception
     */
    private void tratarRetornoTransacao(final Transacao transacao) throws Exception {
        final Sucesso sucesso = transacao.getSucesso();

        if (sucesso != null && sucesso.getTipoRetorno() !=null) {
            if (sucesso.getTipoRetorno().equals("sequencia")) {
                if (sucesso.getNomeRetorno() !=null) {
                    final Sequencia sequencia = processo.getMapSequencias().get(sucesso.getNomeRetorno());
                    try {
                        executarSequencia(sequencia);
                    } catch (final Exception e) {
                        LOG.error(e, e);
                    }
                }
            } else if (sucesso.getTipoRetorno().equals("transacao")) {
                final Transacao transacaoRetorno = processo.getMapTransacoes().get(sucesso.getNomeRetorno());
                if (transacaoRetorno !=null) {
                    executarTransacao(transacaoRetorno);
                }
            }
        }
    }
    
    /**
     * 
     * @param transacao
     * @param sequencia
     * @throws Exception
     */
    private void executarSequenciaTransacao(final Transacao transacao, final Sequencia sequencia) throws Exception {
        if (sequencia.getExecuta() != null) {
            final boolean execucao = executarCommand(sequencia.getExecuta(), this.context);

            if(sequencia.getMapResultados()!=null){
                for (final Resultado resultado : sequencia.getMapResultados().values()) {
                    if (resultado != null && execucao == resultado.getTipo().booleanValue()) {
                        if (resultado.getIncluir() != null) {
                            final Processo processoInc = processoMap.get(resultado.getIncluir());
                            if (processoInc == null) {
                                throw new IllegalStateException("Processo não está " + "mapeado, possivelmente o seu xml não" + " foi processado.");
                            } else {
                                final Processo processoAnterior = processo;
                                executarProcesso(processoInc);
                                processo = processoAnterior;
                            }
                        }
                        if (resultado.getProximo() != null) {
                            final Sequencia proximo = transacao.getMapSequencias().get(resultado.getProximo());
                            executarSequenciaTransacao(transacao, proximo);
                        }

                        if (resultado.getExcecao() != null) {
                            resultado.getExcecao().lancar();
                        }
                    }
                }//for resultado
            }
        }

        if (sequencia.getIncluir() != null) {
            final Processo processoInc = processoMap.get(sequencia.getIncluir());
            if (processoInc == null) {
                throw new IllegalStateException("Processo não está mapeado, possivelmente" + " o seu xml não foi processado.");
            }
            final Processo processoPai = processo;
            executarProcesso(processoInc);
            this.processo = processoPai;
        }

        if (sequencia.getProximo() != null) {
            executarSequenciaTransacao(transacao, transacao.getMapSequencias().get(sequencia.getProximo()));
        }
    }

    /**
     * 
     * @param sequencia
     * @throws Exception
     */
    private void executarSequencia(final Sequencia sequencia) throws Exception {
        if (sequencia.getExecuta() != null) {
            final boolean execucao = executarCommand(sequencia.getExecuta(), this.context);

            if(sequencia.getMapResultados()!=null){
                for (final Resultado resultado : sequencia.getMapResultados().values()) {
                    if (resultado != null && execucao == resultado.getTipo().booleanValue()) {
                        if (resultado.getIncluir() != null) {
                            final Processo processoInc = processoMap.get(resultado.getIncluir());
                            if (processoInc == null) {
                                throw new IllegalStateException("Processo não está " + "mapeado, possivelmente o seu xml não" + " foi processado.");
                            } else {
                                final Processo processoAnterior = processo;
                                executarProcesso(processoInc);
                                processo = processoAnterior;
                            }
                        }
                        if (resultado.getProximo() != null) {
                            final Sequencia proximo = processo.getMapSequencias().get(resultado.getProximo());
                            executarSequencia(proximo);
                        }

                        if (resultado.getExcecao() != null) {
                            resultado.getExcecao().lancar();
                        }
                    }
                }//for resultado
            }
        }
        if (sequencia.getIncluir() != null) {
            final Processo processoInc = processoMap.get(sequencia.getIncluir());
            if (processoInc == null) {
                throw new IllegalStateException("Processo não está mapeado, possivelmente" + " o seu xml não foi processado.");
            }
            final Processo processoPai = processo;
            executarProcesso(processoInc);
            this.processo = processoPai;
        }
        if (sequencia.getProximo() != null) {
            executarSequencia(processo.getMapSequencias().get(sequencia.getProximo()));
        }
        if (sequencia.getTransacao() != null) {
            executarTransacao(processo.getMapTransacoes().get(sequencia.getTransacao()));
        }
    }

    
    /**
     * 
     * @param commandName
     * @param ctx
     * @return
     * @throws Exception
     */
    private boolean executarCommand(final String commandName, final Context ctx) throws Exception {
        return ((Command) beanContext.getBean(commandName)).execute(ctx);
    }

}