package roteador.core;

import org.apache.commons.chain.Context;

import java.io.Serializable;
import java.util.Map;

/**
 * Project: eCatalogue
 * <p/>
 * Developer: Rodrigo Del Cistia Andrade
 * Created in:
 * - Date: 5/10/13
 * - Time: 3:42 PM
 */
public class ContextWrapper<T extends Throwable> implements Serializable {
	
	private static final long serialVersionUID = 505175096982847049L;
	
	private Map<String, Object> context;
	private T exception;
	private boolean exceptionOccurred = false;

	public ContextWrapper(Context context) {
		this(context, null);
	}

	@SuppressWarnings("unchecked")
	public ContextWrapper(Context context, T exception) {
		this.context = context;
		setException(exception);
		this.exception = exception;
	}

	public T getException() {
		return exception;
	}

	public void setException(T exception) {
		this.exception = exception;
        this.exceptionOccurred = exception != null;
	}

	public boolean isExceptionOccurred() {
		return exceptionOccurred;
	}

	public void setExceptionOccurred(boolean exceptionOccurred) {
		this.exceptionOccurred = exceptionOccurred;
	}

	@SuppressWarnings("rawtypes")
	public Map getContext() {
		return context;
	}

	@SuppressWarnings("unchecked")
	public void setContext(Context context) {
		this.context = context;
	}

}
