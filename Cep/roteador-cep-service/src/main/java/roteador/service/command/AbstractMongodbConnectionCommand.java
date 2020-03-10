package roteador.service.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import roteador.service.ServiceMain;
import roteador.service.dao.MongoDBDAO;
import roteador.service.mongo.model.MembroOrganizacao;

public abstract class AbstractMongodbConnectionCommand implements Command {
	
//	@Autowired
//	protected MongoDBDAO<MembroOrganizacao> mongoDBDAO;
//	
//	public MongoTemplate getMongoTemplate() {
//		return (MongoTemplate)ServiceMain.getApplicationContext().getBean("mongoTemplate");
//	}

	@Override
	public abstract boolean execute(Context context) throws Exception;

}
