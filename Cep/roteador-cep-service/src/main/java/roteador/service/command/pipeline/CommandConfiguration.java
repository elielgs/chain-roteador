package roteador.service.command.pipeline;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandConfiguration {

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
	
}
