package roteador.service.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.springframework.data.mongodb.core.MongoTemplate;

import roteador.service.ServiceMain;

public abstract class AbstractMongodbConnectionCommand implements Command {
	
	public MongoTemplate getMongoTemplate() {
		return (MongoTemplate)ServiceMain.getApplicationContext().getBean("mongoTemplate");
	}

	@Override
	public abstract boolean execute(Context context) throws Exception;

}
