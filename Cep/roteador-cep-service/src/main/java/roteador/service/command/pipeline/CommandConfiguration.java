package roteador.service.command.pipeline;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandConfiguration {

	@Bean(name = "sendMessageAPIAXWAY")
	public SendMessageAXWAYAPICommand getSendMessageAXWAYAPICommand() {
		return new SendMessageAXWAYAPICommand();
	}
	
	@Bean(name = "parseJSONToObject")
	public ParseJSONToObjectCommand getParseJSONToObjectCommand() {
		return new ParseJSONToObjectCommand();
	}
	
	@Bean(name = "membroOrganizacaoData")
	public MembroOrganizacaoDataCommand getMembroOrganizacaoDataCommand() {
		return new MembroOrganizacaoDataCommand();
	}
	
}
