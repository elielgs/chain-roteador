package roteador.service.command;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.chain.Context;
import org.springframework.beans.factory.annotation.Autowired;

import roteador.core.constants.ECatalogueContextKey;
import roteador.service.dao.MongoDBDAO;
import roteador.service.mongo.model.MembroOrganizacao;

public class GravarOrganizacoesCommand extends AbstractMongodbConnectionCommand {

	@Autowired
	private MongoDBDAO<MembroOrganizacao> mongoDBDAO;

	private static String API_PRECO = "Preco";
	private static String API_PRODUTO = "Produto";
	private static String API_OFERTA = "Oferta";
	private static String API_PAGAMENTO = "Pagamento";
	private static String API_GEOLOCALIZACAO = "Geolocalizacao";
	private static String API_FAQ = "Faq";
	
	@Override
	public boolean execute(Context context) throws Exception {
		MembroOrganizacao eliel = new MembroOrganizacao("eliel@ciandt.com", "Eliel Serrao", "Baccio de Latte");
		String[] apisEliel = new String[3];
		apisEliel[0] = API_PRECO;
		apisEliel[1] = API_PRODUTO;
		apisEliel[2] = API_OFERTA;
		eliel.setApis(apisEliel);
		
		MembroOrganizacao fabi = new MembroOrganizacao("fmendes@ciandt.com", "Fabiana Mendes", "Boticario");
		String[] apisFabi = new String[2];
		apisFabi[0] = API_PRECO;
		apisFabi[1] = API_PRODUTO;
		fabi.setApis(apisFabi);
		
		MembroOrganizacao brenof = new MembroOrganizacao("brenof@ciandt.com", "Breno Dias", "Danone");
		String[] apisBreno = new String[5];
		apisBreno[0] = API_PRECO;
		apisBreno[1] = API_PRODUTO;
		apisBreno[2] = API_OFERTA;
		apisBreno[3] = API_PAGAMENTO;
		apisBreno[4] = API_GEOLOCALIZACAO;
		brenof.setApis(apisBreno);	
		
		MembroOrganizacao pri = new MembroOrganizacao("priscilab@ciandt.com", "Priscila Salomao ", "Mary Kay");
		String[] apisPri = new String[2];
		apisPri[0] = API_GEOLOCALIZACAO;
		apisPri[1] = API_FAQ;
		pri.setApis(apisPri);	
		

		MembroOrganizacao tico = new MembroOrganizacao("tiago@ciandt.com", "Tico ", "Tico Pet");
		String[] apisTico = new String[1];
		apisTico[0] = API_PAGAMENTO;
		tico.setApis(apisTico);	
		
		MembroOrganizacao ze = new MembroOrganizacao("willianp@ciandt.com", "Ze", "Padaria Seu Ze");
		String[] apisZe = new String[2];
		apisZe[0] = API_GEOLOCALIZACAO;
		apisZe[1] = API_FAQ;
		ze.setApis(apisZe);	
		
		
		// Insert is used to initially store the object into the database.
		mongoDBDAO.insert(eliel);
		mongoDBDAO.insert(fabi);
		mongoDBDAO.insert(brenof);
		mongoDBDAO.insert(pri);
		mongoDBDAO.insert(tico);
		mongoDBDAO.insert(ze);
		
		MembroOrganizacao[] list = new MembroOrganizacao[6];
		list[0] = eliel;
		list[1] = fabi;
		list[2] = brenof;
		list[3] = pri;
		list[4] = tico;
		list[5] = ze;
		context.put(ECatalogueContextKey.JSON_PARSE_FROM_OBJECT, ECatalogueContextKey.ORGANIZACOES);
		context.put(ECatalogueContextKey.ORGANIZACOES, list);

		// Find
//		p = mongoDBDAO.findById(MembroOrganizacao.class, p.getId());


		// Check that deletion worked
		List<MembroOrganizacao> people = getMongoTemplate().findAll(MembroOrganizacao.class);
		System.out.println("Number of people = : " + people.size());

		//mongoDBDAO.dropCollection(MembroOrganizacao.class);
		return true;
	}

}
