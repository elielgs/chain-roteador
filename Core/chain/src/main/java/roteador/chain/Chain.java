package roteador.chain;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.google.gson.Gson;

import roteador.chain.processo.Processo;
import roteador.chain.processo.ProcessoParser;
import roteador.core.constants.ContextKey;
import roteador.core.exception.command.CommandException;
import roteador.core.exception.command.TransactionNotFoundException;
import roteador.core.exception.service.ServiceException;
import roteador.core.exception.service.TransactionExecutionException;

public class Chain implements Command, BeanFactoryAware {

    private static final Logger LOG = Logger.getLogger(Chain.class);

    private final Map<String, Processo> processoMap = new HashMap<String, Processo>();

    private AbstractPlatformTransactionManager transactionManager;

    private BeanFactory beanFactory = null;

    public Chain() {
        // Construtor 
    }

    
    public Chain(final List<String> xmlNames) {
       processConfiguration(xmlNames);
    }

    public void processConfiguration(final List<String> xmlNames){
    	 LOG.info(":::::::: Iniciando o processo de parseamento dos xml's de " + "processos ");
         try {
             final XMLReader parser = XMLReaderFactory.createXMLReader();
             for (final String xmlName : xmlNames) {
                 final ProcessoParser chainParser = new ProcessoParser();
                 parser.setContentHandler(chainParser);
                 LOG.info("Parseando o xml:" + xmlName);
                 final InputSource is = new InputSource(Thread.currentThread().getContextClassLoader().getResourceAsStream(xmlName.trim()));

                 try {
                     parser.parse(is);
                     Processo processo = chainParser.getProcesso();
                     processoMap.put(processo.getNome(), processo);
                 } catch (IOException e) {
                     LOG.error("Erro no parseamento do xml de processo", e);
                 }
             }
         } catch (final SAXException e) {
             LOG.error("Erro no parseamento do xml de processo", e);
         }
         LOG.info(":::::::: Finalizando o processo de parseamento dos xml's de " + "processos ");
    	
    }
    
  
    /**
     * 
     */
    public boolean execute(final Context ctx) throws Exception {
        boolean retorno = false;
//        TransactionStatus status = null;
        try {
//            DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
//            definition.setName("chain" + UUID.randomUUID());
//            definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);

//            status = transactionManager.getTransaction(definition);

            retorno = executarProcesso(ctx);
//            transactionManager.commit(status);

        } catch(RuntimeException e) {
            LOG.error(e, e);

            throw e;
        } catch (Exception e) {
            LOG.error(e, e);
//            transactionManager.rollback(status);
            throw e;
        }

        return retorno;

    }

    /**
     * 
     * @param ctx
     * @return
     * @throws TransactionNotFoundException
     * @throws CommandException
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    private boolean executarProcesso(final Context ctx) throws TransactionNotFoundException, CommandException, Exception {
        String transacao = (String) ctx.get(ContextKey.TRANSACTION.getChave());
        try{
            ctx.remove(ContextKey.EXCEPTION.getChave());
        }catch (final Exception e) {
            LOG.error("ERRO AO REMOVER A CHAVE EXCECAO DO CONTEXTO >>>> " + transacao + " NO SERVIDOR.");
        }
        LOG.info("EXECUTANDO A TRANSACAO >>>> " + transacao + " NO SERVIDOR.");
        final ProcessoEngine executor = new ProcessoEngine(ctx, transactionManager, beanFactory, processoMap);

        final Processo processo = processoMap.get(transacao);
        if (processo == null) {
            throw new TransactionNotFoundException("Transacao nao encontrada: " + transacao);
        }

        try {
        	executor.executarProcesso(processo);
        } catch (final TransactionExecutionException e) {
            ctx.put(ContextKey.EXCEPTION.getChave(), e);
        } catch (final CommandException e) {
            ctx.remove(ContextKey.COMMAND_EXCEPTION.getChave());
            throw e;
        } catch (final ServiceException e) {
            ctx.remove(ContextKey.SERVICE_EXCEPTION.getChave());
            throw e;
        } catch (final Exception e) {
            LOG.error("ERRO NA EXECUCAO DE COMMAND NO PROCESSO (" + processo.getNome() + ")", e);
            throw e;
        } finally {
        }
        return true;
    }

    
    public void setBeanFactory(final BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public void setTransactionManager(final AbstractPlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

}
