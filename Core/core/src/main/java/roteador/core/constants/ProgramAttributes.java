package roteador.core.constants;



/**
 * @author Marcos Pestana
 *
 */
public enum ProgramAttributes {
	
	MENU_TOPO(1),
    BTN_INSCREVA_SE(2),
    BTN_LOGIN(3),
    BTN_PREMIOS(4),
    BTN_REGRAS_MECANICA(5),
    BTN_REGULAMENTO(6),
    BTN_DUVIDAS(7),
    BTN_FALE_CONOSCO(8),
    GLOBAL_CONFIG(9),
    BTN_PERFIL(10),
    BTN_HOME(11),
    FACEBOOK(12),
    TWITTER(13),
    YOUTUBE(14),
    GOOGLEPLUS(15)
    ;
    
    private Integer code;

    private ProgramAttributes(final Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
    
    public static ProgramAttributes getProgramAttribute(final Integer code){
    	for(ProgramAttributes attribute : ProgramAttributes.values()){
    		if(attribute.getCode().equals(code)){
    			return attribute;
    		}
    	}
    	return null;
    }
    
   

}
