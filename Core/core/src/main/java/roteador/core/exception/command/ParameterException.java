package roteador.core.exception.command;

public class ParameterException extends Exception {
	
	private static final long serialVersionUID = -8895066276579596437L;

	private String paramName;
	
	public ParameterException(String paramName) {
		super(paramName);
		this.paramName = paramName;
	}
	
    @Override
    public String getMessage() {
    	StringBuffer buffer = new StringBuffer();
    	buffer.append("Parâmetro faltando: ");
    	buffer.append(paramName);
        return buffer.toString();
    }
}