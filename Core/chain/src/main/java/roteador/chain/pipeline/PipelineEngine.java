package roteador.chain.pipeline;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;

import roteador.chain.processo.Resultado;
import roteador.chain.processo.pipeline.CommandConfiguration;
import roteador.chain.processo.pipeline.PipelineConfiguration;
import roteador.core.constants.ContextKey;

public class PipelineEngine {

	private final BeanFactory beanContext;

	private final AbstractPlatformTransactionManager transactionManager;

	private final Context context;

	private Map<String, PipelineConfiguration> pipelineMapConfiguration;

	private PipelineConfiguration pipelineConfiguration;

	private static final Logger LOG = Logger.getLogger(PipelineEngine.class);

	public PipelineEngine(final Context context, final AbstractPlatformTransactionManager txManager,
			final BeanFactory beanFactory, final Map<String, PipelineConfiguration> pipelineMapConfiguration) {
		this.context = context;
		this.transactionManager = txManager;
		this.beanContext = beanFactory;
		this.pipelineMapConfiguration = pipelineMapConfiguration;
	}

	public void executarProcesso(final PipelineConfiguration pipelineConfiguration) throws Exception {
		this.pipelineConfiguration = pipelineConfiguration;
//        final Transacao transacaoInicio = pipeline.getMapTransacoes().get(pipeline.getInicio());
		final CommandConfiguration commandConfigurationInicio = pipelineConfiguration.getCommandsConfiguration().get(0);

		// Procurar primeiro na lista de transacoes
//        if(transacaoInicio!=null){
//            executarTransacao(transacaoInicio);
//        }else if(sequenciaInicio!=null){
		executarCommand(null, commandConfigurationInicio);
//        }

	}

//    private void executarTransacao(final Transacao transacao) throws Exception {
//        LOG.info("INICIANDO UMA NOVA TRANSACAO");
//        final DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
//        definition.setName(transacao.getNome());
//        definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
//        final TransactionStatus status = transactionManager.getTransaction(definition);
//
//        final String sequenciaInicio = transacao.getMapSequencias().keySet().iterator().next();
//        try {
//            executarSequenciaTransacao(transacao, transacao.getMapSequencias().get(sequenciaInicio));
//            transactionManager.commit(status);
//            tratarRetornoTransacao(transacao);
//        } catch (final TransactionExecutionException e) {
//            transactionManager.rollback(status);
//            LOG.error("FAZENDO ROLLBACK NA TRANSACAO. EXCEPTION: " + e, e);
//            throw e;
//        } catch (final CommandException e) {
//            LOG.error("FAZENDO ROLLBACK NA TRANSACAO. EXCEPTION: " + e, e);
//            transactionManager.rollback(status);
//            throw e;
//        } catch (final Exception e) {
//            LOG.error("FAZENDO ROLLBACK NA TRANSACAO. EXCEPTION: " + e, e);
//            transactionManager.rollback(status);
//            throw new Exception("Problema no processo", e);
//        } finally {
//            LOG.info("FINALIZANDO TRANSACAO");
//        }
//    }

	/**
	 * 
	 * @param transacao
	 * @throws Exception
	 */
//    private void tratarRetornoTransacao(final Transacao transacao) throws Exception {
//        final Sucesso sucesso = transacao.getSucesso();
//
//        if (sucesso != null && sucesso.getTipoRetorno() !=null) {
//            if (sucesso.getTipoRetorno().equals("sequencia")) {
//                if (sucesso.getNomeRetorno() !=null) {
//                    final Sequencia sequencia = pipeline.getMapSequencias().get(sucesso.getNomeRetorno());
//                    try {
//                        executarSequencia(sequencia);
//                    } catch (final Exception e) {
//                        LOG.error(e, e);
//                    }
//                }
//            } else if (sucesso.getTipoRetorno().equals("transacao")) {
//                final Transacao transacaoRetorno = pipeline.getMapTransacoes().get(sucesso.getNomeRetorno());
//                if (transacaoRetorno !=null) {
//                    executarTransacao(transacaoRetorno);
//                }
//            }
//        }
//    }
//    
//    /**
//     * 
//     * @param transacao
//     * @param sequencia
//     * @throws Exception
//     */
//    private void executarSequenciaTransacao(final Transacao transacao, final Sequencia sequencia) throws Exception {
//        if (sequencia.getExecuta() != null) {
//            final boolean execucao = executarCommand(sequencia.getExecuta(), this.context);
//
//            if(sequencia.getMapResultados()!=null){
//                for (final Resultado resultado : sequencia.getMapResultados().values()) {
//                    if (resultado != null && execucao == resultado.getTipo().booleanValue()) {
//                        if (resultado.getIncluir() != null) {
//                            final Processo processoInc = pipelineMap.get(resultado.getIncluir());
//                            if (processoInc == null) {
//                                throw new IllegalStateException("Processo não está " + "mapeado, possivelmente o seu xml não" + " foi processado.");
//                            } else {
//                                final Processo processoAnterior = pipeline;
//                                executarProcesso(processoInc);
//                                pipeline = processoAnterior;
//                            }
//                        }
//                        if (resultado.getProximo() != null) {
//                            final Sequencia proximo = transacao.getMapSequencias().get(resultado.getProximo());
//                            executarSequenciaTransacao(transacao, proximo);
//                        }
//
//                        if (resultado.getExcecao() != null) {
//                            resultado.getExcecao().lancar();
//                        }
//                    }
//                }//for resultado
//            }
//        }
//
//        if (sequencia.getIncluir() != null) {
//            final Processo processoInc = pipelineMap.get(sequencia.getIncluir());
//            if (processoInc == null) {
//                throw new IllegalStateException("Processo não está mapeado, possivelmente" + " o seu xml não foi processado.");
//            }
//            final Processo processoPai = pipeline;
//            executarProcesso(processoInc);
//            this.pipeline = processoPai;
//        }
//
//        if (sequencia.getProximo() != null) {
//            executarSequenciaTransacao(transacao, transacao.getMapSequencias().get(sequencia.getProximo()));
//        }
//    }

	/**
	 * 
	 * @param nextCommandConfiguration
	 * @throws Exception
	 */
	private void executarCommand(final CommandConfiguration previousCommand,
			final CommandConfiguration nextCommandConfiguration) throws Exception {
		configureNextCommand(previousCommand, nextCommandConfiguration);

		if (nextCommandConfiguration.getExecuteComponent() != null) {
			final boolean execucao = executarCommand(nextCommandConfiguration, this.context);

			if (nextCommandConfiguration.getResultados() != null) {
				for (final Resultado resultado : nextCommandConfiguration.getResultados().values()) {
					if (resultado != null && execucao == resultado.getTipo().booleanValue()) {
//                        if (resultado.getIncluir() != null) {
//                            final Processo processoInc = pipelineMap.get(resultado.getIncluir());
//                            if (processoInc == null) {
//                                throw new IllegalStateException("Processo não está " + "mapeado, possivelmente o seu xml não" + " foi processado.");
//                            } else {
//                                final Processo processoAnterior = pipelineConfiguration;
//                                executarProcesso(processoInc);
//                                pipelineConfiguration = processoAnterior;
//                            }
//                        }
						if (resultado.getProximo() != null) {
							executeNextCommand(resultado.getProximo(), nextCommandConfiguration);

						}

						if (resultado.getExcecao() != null) {
							resultado.getExcecao().lancar();
						}
					}
				} // for resultado
			}
		}
//        if (commandConfiguration.getIncluir() != null) {
//            final Processo processoInc = pipelineMap.get(commandConfiguration.getIncluir());
//            if (processoInc == null) {
//                throw new IllegalStateException("Processo não está mapeado, possivelmente" + " o seu xml não foi processado.");
//            }
//            final Processo processoPai = pipelineConfiguration;
//            executarProcesso(processoInc);
//            this.pipelineConfiguration = processoPai;
//        }
		if (nextCommandConfiguration.getProximo() != null) {
			executeNextCommand(nextCommandConfiguration.getProximo(), nextCommandConfiguration);
		}
//        if (commandConfiguration.getTransacao() != null) {
//            executarTransacao(pipelineConfiguration.getMapTransacoes().get(commandConfiguration.getTransacao()));
//        }
	}

	@SuppressWarnings("unchecked")
	private void configureNextCommand(final CommandConfiguration previousCommand,
			final CommandConfiguration nextCommandConfiguration) {
		this.context.put(ContextKey.PARAMS, nextCommandConfiguration.getParams());
		if (nextCommandConfiguration.getParameterConstructor() != null) {
			nextCommandConfiguration.getParameterConstructor().setObject(this.context);
		}
		if (previousCommand != null) {
			if (previousCommand.getForwardParams() != null) {
				Map<String, String> params = (Map<String, String>) this.context.get(ContextKey.PARAMS);
				if (params != null) {
					params.putAll(previousCommand.getForwardParams());
				} else {
					this.context.put(ContextKey.PARAMS, previousCommand.getForwardParams());
				}
			}
		}
	}

	private void executeNextCommand(final String nextId, final CommandConfiguration actualCommand) throws Exception {
		List<CommandConfiguration> commandsList = pipelineConfiguration.getCommandsConfiguration();
		Iterator<CommandConfiguration> iterator = commandsList.iterator();
		CommandConfiguration nextCommand = null;
		while (iterator.hasNext()) {
			CommandConfiguration commandPipeline = iterator.next();
			if (commandPipeline.getId().equals(nextId)) {
				nextCommand = commandPipeline;
			}
		}
		if (nextCommand != null) {
			executarCommand(actualCommand, nextCommand);
		} else {
			throw new IllegalStateException("Problemas para encontrar a command id --> " + nextId);
		}
	}

	/**
	 * 
	 * @param commandName
	 * @param ctx
	 * @return
	 * @throws Exception
	 */
	private boolean executarCommand(final CommandConfiguration commandConfiguration, final Context ctx)
			throws Exception {
		boolean retorno = ((Command) beanContext.getBean(commandConfiguration.getExecuteComponent())).execute(ctx);

		if (commandConfiguration.getContextTransform() != null) {
			Object objetoContexto = context
					.get(ContextKey.valueOf(commandConfiguration.getContextTransform().getSourceContextKey()));

			Object objetoRetorno = getObject(commandConfiguration, ctx, objetoContexto);
			ctx.put(ContextKey.valueOf(commandConfiguration.getContextTransform().getDestinationContextKey()), objetoRetorno);
		}
		return retorno;
	}

	private Object getObject(CommandConfiguration commandConfiguration, final Context ctx, Object objetoContexto)
			throws IllegalAccessException, InvocationTargetException {
		Method[] methods = objetoContexto.getClass().getMethods();

		Object objetoRetorno = objetoContexto;

		Iterator<String> methodDesc = commandConfiguration.getContextTransform().getTransformationObject().iterator();
		while (methodDesc.hasNext()) {
			String wishedMethod = methodDesc.next();
			for (int i = 0; i < methods.length; i++) {
				Method method = methods[i];
				if (method.getName().equals(wishedMethod)) {
					objetoRetorno = method.invoke(objetoContexto);
					break;
				}
			}
		}
		return objetoRetorno;
	}

}