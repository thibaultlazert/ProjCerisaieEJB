package meserreurs;

public class MonException extends Exception{

	private static final long serialVersionUID = 1L;

	public MonException(String message, String string) {
		super(message + " \ndans "+string);
	}

}

