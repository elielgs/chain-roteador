package roteador.core.exception.service;

import roteador.core.constants.SystemMessage;

/**
 * User: eliel
 * Date: 02/05/13
 * Time: 13:55
 */
public class ServiceException extends Exception {

	private static final long serialVersionUID = -5715032686582843286L;

	private String errorCode;

    private String errorMessage;

    private SystemMessage systemMessage;

    public ServiceException(String errorCode, String errorMessage, SystemMessage systemMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.systemMessage = systemMessage;
    }

    public ServiceException(SystemMessage systemMessage) {
        this.systemMessage = systemMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public SystemMessage getSystemMessage() {
        return systemMessage;
    }

	@Override
	public String toString() {
		return "ServiceException{" +
				"errorCode='" + errorCode + '\'' +
				", errorMessage='" + errorMessage + '\'' +
				", systemMessage=" + systemMessage +
				'}';
	}
}
