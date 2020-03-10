package roteador.service.command;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.chain.Context;
import org.springframework.beans.factory.annotation.Autowired;

import roteador.core.constants.ContextKey;
import roteador.service.dao.MongoDBDAO;
import roteador.service.mongo.model.MembroOrganizacao;

public class GravarOrganizacoesCommand extends AbstractMongodbConnectionCommand {

	private static String API_PRECO = "Preco";
	private static String API_PRODUTO = "Produto";
	private static String API_OFERTA = "Oferta";
	private static String API_PAGAMENTO = "Pagamento";
	private static String API_GEOLOCALIZACAO = "Geolocalizacao";
	private static String API_FAQ = "Faq";
	
	@Override
	public boolean execute(Context context) throws Exception {
//		MembroOrganizacao eliel = new MembroOrganizacao("eliel@ciandt.com", "Eliel Serrao", "Baccio de Latte");
//		List<String> apisEliel = new LinkedList<String>();
//		apisEliel.add(API_PRECO);
//		apisEliel.add(API_PRODUTO);
//		apisEliel.add(API_OFERTA);
//		eliel.setApis(apisEliel);
//		
//		MembroOrganizacao fabi = new MembroOrganizacao("fmendes@ciandt.com", "Fabiana Mendes", "Boticario");
//		List<String>  apisFabi = new LinkedList<String>();
//		apisFabi.add(API_PRECO);
//		apisFabi.add(API_PRODUTO);
//		fabi.setApis(apisFabi);
//		
//		MembroOrganizacao brenof = new MembroOrganizacao("brenof@ciandt.com", "Breno Dias", "Danone");
//		List<String>  apisBreno = new LinkedList<String>();
//		apisBreno.add(API_PRECO);
//		apisBreno.add(API_PRODUTO);
//		apisBreno.add(API_OFERTA);
//		apisBreno.add(API_PAGAMENTO);
//		apisBreno.add(API_GEOLOCALIZACAO);
//		brenof.setApis(apisBreno);	
//		
//		MembroOrganizacao pri = new MembroOrganizacao("priscilab@ciandt.com", "Priscila Salomao ", "Mary Kay");
//		List<String>  apisPri = new LinkedList<String>();
//		apisPri.add(API_GEOLOCALIZACAO);
//		apisPri.add(API_FAQ);
//		pri.setApis(apisPri);	
//
//		MembroOrganizacao tico = new MembroOrganizacao("tiago@ciandt.com", "Tico ", "Tico Pet");
//		List<String>  apisTico = new LinkedList<String>();
//		apisTico.add(API_PAGAMENTO);
//		tico.setApis(apisTico);	
//		
//		MembroOrganizacao ze = new MembroOrganizacao("willianp@ciandt.com", "Ze", "Padaria Seu Ze");
//		List<String>  apisZe = new LinkedList<String>();
//		apisZe.add(API_GEOLOCALIZACAO);
//		apisZe.add(API_FAQ);
//		ze.setApis(apisZe);	
//		
//		
//		// Insert is used to initially store the object into the database.
//		mongoDBDAO.insert(eliel);
//		mongoDBDAO.insert(fabi);
//		mongoDBDAO.insert(brenof);
//		mongoDBDAO.insert(pri);
//		mongoDBDAO.insert(tico);
//		mongoDBDAO.insert(ze);
//		
//		MembroOrganizacao[] list = new MembroOrganizacao[6];
//		list[0] = eliel;
//		list[1] = fabi;
//		list[2] = brenof;
//		list[3] = pri;
//		list[4] = tico;
//		list[5] = ze;
//		context.put(ContextKey.JSON_PARSE_FROM_OBJECT, ContextKey.MEMBRO_ORGANIZACAO);
//		context.put(ContextKey.MEMBRO_ORGANIZACAO, list);
//
//		// Find
////		p = mongoDBDAO.findById(MembroOrganizacao.class, p.getId());
//
//
//		// Check that deletion worked
//		List<MembroOrganizacao> people = getMongoTemplate().findAll(MembroOrganizacao.class);
//		System.out.println("Number of people = : " + people.size());
//
//		//mongoDBDAO.dropCollection(MembroOrganizacao.class);
		return true;
	}

}
