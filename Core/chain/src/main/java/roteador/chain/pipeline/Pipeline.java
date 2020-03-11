package roteador.chain.pipeline;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Configurable;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import roteador.chain.processo.pipeline.CommandConfiguration;
import roteador.chain.processo.pipeline.PipelineConfiguration;
import roteador.core.constants.ContextKey;
import roteador.core.exception.command.CommandException;
import roteador.core.exception.command.TransactionNotFoundException;
import roteador.core.exception.service.ServiceException;
import roteador.core.exception.service.TransactionExecutionException;


public class Pipeline implements Command, BeanFactoryAware {

	private static final Logger LOG = Logger.getLogger(Pipeline.class);

	private final Map<String, PipelineConfiguration> pipelineMap = new HashMap<String, PipelineConfiguration>();

	private BeanFactory beanFactory = null;

	public Pipeline() {
		processConfiguration();
	}

	public void processConfiguration() {
		File folder = new File("/pipeline");

		File[] listOfFiles = folder.listFiles();
		Gson gson = new Gson();

		for (File file : listOfFiles) {
			if (file.isFile()) {
				try {
					JsonReader reader = new JsonReader(new FileReader(file));
					PipelineConfiguration pipelineConfiguration = gson.fromJson(reader, PipelineConfiguration.class);
					List<CommandConfiguration> pipelineCommands = pipelineConfiguration
							.getCommandsConfiguration();
					Iterator<CommandConfiguration> iterator = pipelineCommands.iterator();
					while (iterator.hasNext()) {
						CommandConfiguration commandConfiguration = iterator.next();
						
						if (!commandConfiguration.getComponentJSONFilename().isEmpty()) {
							loadCommandConfigurationFromComponentFile(commandConfiguration);
						}
					}
					pipelineMap.put(pipelineConfiguration.getName(), pipelineConfiguration);
					System.out.println("Pipeline Configuration --> " + gson.toJson(pipelineConfiguration));
					reader.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void loadCommandConfigurationFromComponentFile(CommandConfiguration commandConfiguration) {
		File commandsConfigFolder = new File("/command/");
		File[] listOfFiles = commandsConfigFolder.listFiles();
		
		for (File file : listOfFiles) {
			if (file.isFile() && commandConfiguration.getComponentJSONFilename().equals(file.getName())) {
				try {
					Gson gson = new Gson();
					JsonReader reader = new JsonReader(new FileReader(file));
					CommandConfiguration commandComponentConfiguration = gson.fromJson(reader, CommandConfiguration.class);
					commandConfiguration.setId(commandComponentConfiguration.getId());
					commandConfiguration.setExecuteComponent(commandComponentConfiguration.getExecuteComponent());
					commandConfiguration.setParams(commandComponentConfiguration.getParams());
					commandConfiguration.setForwardParams(commandComponentConfiguration.getForwardParams());
					commandConfiguration.setProximo(commandComponentConfiguration.getProximo());
					commandConfiguration.setResultados(commandComponentConfiguration.getResultados());
					commandConfiguration.setContextTransform(commandComponentConfiguration.getContextTransform());
					commandConfiguration.setParameterConstructor(commandComponentConfiguration.getParameterConstructor());
					reader.close();
					break;
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
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

			retorno = executarPipeline(ctx);
//            transactionManager.commit(status);

		} catch (RuntimeException e) {
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
	private boolean executarPipeline(final Context ctx)
			throws TransactionNotFoundException, CommandException, Exception {
		String transacao = (String) ctx.get(ContextKey.TRANSACTION.getChave());
		try {
			ctx.remove(ContextKey.EXCEPTION.getChave());
		} catch (final Exception e) {
			LOG.error("ERRO AO REMOVER A CHAVE EXCECAO DO CONTEXTO >>>> " + transacao + " NO SERVIDOR.");
		}
		LOG.info("EXECUTANDO A TRANSACAO >>>> " + transacao + " NO SERVIDOR.");
		final PipelineEngine executor = new PipelineEngine(ctx, null, beanFactory, pipelineMap);

		final PipelineConfiguration pipelineConfiguration = pipelineMap.get(transacao);
		if (pipelineConfiguration == null) {
			throw new TransactionNotFoundException("Transacao nao encontrada: " + transacao);
		}

		try {
			executor.executarProcesso(pipelineConfiguration);
		} catch (final TransactionExecutionException e) {
			ctx.put(ContextKey.EXCEPTION.getChave(), e);
		} catch (final CommandException e) {
			ctx.remove(ContextKey.COMMAND_EXCEPTION.getChave());
			throw e;
		} catch (final ServiceException e) {
			ctx.remove(ContextKey.SERVICE_EXCEPTION.getChave());
			throw e;
		} catch (final Exception e) {
			LOG.error("ERRO NA EXECUCAO DE COMMAND NO PROCESSO (" + pipelineConfiguration.getName() + ")", e);
			throw e;
		} finally {
		}
		return true;
	}

	public void setBeanFactory(final BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

}
