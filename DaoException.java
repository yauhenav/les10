package les10;

public class DaoException extends Exception {
	
	public DaoException () {
	}
		
	public DaoException (String message, Throwable exc) {
		super (message, exc);
	}
		
	public DaoException (String message) {
		super(message);
	}
	
	public DaoException (Throwable exc) {
		super(exc);
	}
	
	public String toString() {
		return "DaoException";
 	}
}
