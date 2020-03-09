package roteador.chain.processo.pipeline;

import java.util.LinkedList;
import java.util.List;


public class PipelineConfiguration {

	private String name;

	private List<CommandConfiguration> commandsConfiguration = new LinkedList<CommandConfiguration>();
	
	public PipelineConfiguration() {
	}

	public PipelineConfiguration(final String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public List<CommandConfiguration> getCommandsConfiguration() {
		return commandsConfiguration;
	}

	public void setCommandsConfiguration(List<CommandConfiguration> commandsConfiguration) {
		this.commandsConfiguration = commandsConfiguration;
	}
}