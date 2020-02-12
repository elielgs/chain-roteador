package roteador.core.constants;



public enum ProgramAuthenticationType {

	INTERNAL("I"),
    EXTERNAL("E"),
    ;
    
    private String type;

    private ProgramAuthenticationType(final String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
    
    public static ProgramAuthenticationType forValue(String type){
    	for(ProgramAuthenticationType programAuthenticationType: ProgramAuthenticationType.values()){
    		if(type.equals(programAuthenticationType.getType())){
    			return programAuthenticationType;
    		}
    	}
    	return null;
    }
    
   

}
