package customException;

@SuppressWarnings("serial")
public final class CustomException extends Exception {
    public CustomException(String message) {
		super(message);
	}
	
	public CustomException(String message ,Throwable throwableCause) {
		super(message,throwableCause);
	}
}
