package roteador.core.constants;

/**
 * Created with IntelliJ IDEA.
 * User: eliel
 * Date: 07/05/13
 * Time: 16:11
 * To change this template use File | Settings | File Templates.
 */
public enum LoyaltyProgramStatus {

    ACTIVE('A'),
    INACTIVE('I'),
    SUSPENDED('S');

    private char value;

    private LoyaltyProgramStatus(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
