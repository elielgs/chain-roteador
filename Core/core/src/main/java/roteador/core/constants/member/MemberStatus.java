package roteador.core.constants.member;

/**
 * @author Marcos.Pestana
 *
 */
public enum MemberStatus {

    ACTIVE('A'),
    OUTDATED('O'),
    INACTIVE('I');

    private char value;

    private MemberStatus(char value) {
        this.value = value;
    }

    public Character getValue() {
        return value;
    }
    
	public MemberStatus forValue(final char value){
		 for(final MemberStatus memberStatus : MemberStatus.values()) {
	            if(memberStatus.getValue() == value) {
	                return memberStatus;
	            }
	     }
		 return null;
	}
}
