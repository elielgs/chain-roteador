package roteador.core.constants;

/**
 * Created with IntelliJ IDEA.
 * User: eliel
 * Date: 07/05/13
 * Time: 16:11
 * To change this template use File | Settings | File Templates.
 */
public enum PricingOfferStatus {

    ACTIVE('1'),
    INACTIVE('0');

    private char value;

    private PricingOfferStatus(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
