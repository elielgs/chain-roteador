package roteador.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import roteador.chain.pipeline.Pipeline;
import roteador.service.command.pipeline.APIConnectorCommand;
import roteador.service.command.pipeline.NOSQLDataConnectorCommand;
import roteador.service.command.pipeline.ParseJSONToObjectCommand;
import roteador.service.dao.MongoDBDAO;

@Configuration
public class ServiceConfiguration {

	@Bean(name = "sendMassageAPI")
	public APIConnectorCommand get() {
		return new APIConnectorCommand();
	}
	
	@Bean(name = "parseJSONToObject")
	public ParseJSONToObjectCommand getParseJSONToObjectCommand() {
		return new ParseJSONToObjectCommand();
	}
	
	@Bean(name = "noSQLDataConnector")
	public NOSQLDataConnectorCommand getNOSQLDataConnectorCommand() {
		return new NOSQLDataConnectorCommand();
	}
	
	@Bean(name = "MongoDBDAO")
	public MongoDBDAO getMongoDBDAO() {
		return new MongoDBDAO();
	}
	
	@Bean(name = "Pipeline")
	public Pipeline getPipeline() {
		return new Pipeline();
	}
}
