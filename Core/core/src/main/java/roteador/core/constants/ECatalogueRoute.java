package roteador.core.constants;

/**
 * Created with IntelliJ IDEA.
 * User: eliel
 * Date: 25/04/13
 * Time: 15:10
 * To change this template use File | Settings | File Templates.
 */
public enum ECatalogueRoute {

    FULL("FULL"),
    PARTIAL("PARTIAL"),
    CATEGORIES("CATEGORIES"),
    FREIGHT("FREIGHT"),
    AVAILABILITY("AVAILABILITY"),
    DESTINATION("destination"),
    TYPE("type"),

    INCREMENTAL("INCREMENTAL"),
    PRODUTO("PRODUTO"),
    LIGHT("LIGHT"),
    DOWNLOAD("DOWNLOAD"),

    JMS_PREFIX("jms:queue:")

    ;

    public String value;

    private ECatalogueRoute(String value) {
        this.value = value;
    }
}
