<<<<<<< HEAD
import java.time.LocalDateTime;

public class ShowingValidationException extends CustomException{

	private String nazwaFilmu;
	private String nazwaZmiennej;

	
	
	public ShowingValidationException(String nazwaZmiennej, String nazwaFilmu) {
		super();
		this.nazwaZmiennej = nazwaZmiennej;
		this.nazwaFilmu = nazwaFilmu;
	}

	

	@Override
	public String getMessage() {
		return "SHOWING VALIDATION, " + nazwaFilmu + ", " + nazwaZmiennej + ", " + LocalDateTime.now(); 
	}
}
=======
import java.time.LocalDateTime;

public class ShowingValidationException extends CustomException{

	private String nazwaFilmu;
	private String nazwaZmiennej;

	
	
	public ShowingValidationException(String nazwaZmiennej, String nazwaFilmu) {
		super();
		this.nazwaZmiennej = nazwaZmiennej;
		this.nazwaFilmu = nazwaFilmu;
	}

	

	@Override
	public String getMessage() {
		return "SHOWING VALIDATION, " + nazwaFilmu + ", " + nazwaZmiennej + ", " + LocalDateTime.now(); 
	}
}
>>>>>>> fca0daedfb015b5611b3481145542a6d4984402b
