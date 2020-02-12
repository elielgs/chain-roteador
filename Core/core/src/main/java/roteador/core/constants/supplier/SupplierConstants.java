package roteador.core.constants.supplier;

import roteador.core.constants.ComponentQueueNameEnum;

public enum SupplierConstants {
	ECATALOGUE_DIRECTORY("///opt/eCatalogue/"),
	ZIP_FILE_DIRECTORY(ECATALOGUE_DIRECTORY.getValor() + "dir_zip/"),
	
	//CENTAURO
	CENTAURO_JMS("jms:queue:" + ComponentQueueNameEnum.SUPPLIER_CENTAURO.getQueueName()),
	CENTAURO_URL_QUERY("IdParceiro=18"),
    
	//COMPRAFACIL
	COMPRAFACIL_JMS("jms:queue:" + ComponentQueueNameEnum.SUPPLIER_COMPRAFACIL.getQueueName()),
	COMPRAFACIL_URL_QUERY("IdParceiro=710"),
	
	//NOVAPONTOCOM
	NOVAPONTOCOM_JMS("jms:queue:" + ComponentQueueNameEnum.SUPPLIER_NOVAPONTOCOM.getQueueName()),
	NOVAPONTOCOM_URL_QUERY("IdParceiro=710"),
	
	//POLISHOP
	POLISHOP_JMS("jms:queue:" + ComponentQueueNameEnum.SUPPLIER_POLISHOP.getQueueName()),
	POLISHOP_URL_QUERY("IdParceiro=710"),
	
	//WALMART
	WALMART_JMS("jms:queue:" + ComponentQueueNameEnum.SUPPLIER_WALMART.getQueueName()),
	WALMART_URL_QUERY("IdParceiro=710"),
	;
	
	public String valor;
	
	private SupplierConstants(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}
}