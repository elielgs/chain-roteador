package roteador.service.command.pipeline;

import org.springframework.beans.factory.annotation.Value;

public class SendMessageAXWAYAPICommand extends AbstractAPIConnectionCommand {

	@Value("${axway.url}")
	private String domain;
	@Value("${axway.port}")
	private String port;
	
	@Override
	protected String getDomain() {
		return domain;
	}
	@Override
	protected String getPort() {
		// TODO Auto-generated method stub
		return port;
	}

	
	
}
