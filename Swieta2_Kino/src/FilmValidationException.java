<<<<<<< HEAD
import java.time.LocalDateTime;

public class FilmValidationException extends CustomException{
	
	private String nazwaZmiennej;

	
	
	public FilmValidationException(String nazwaZmiennej) {
		super();
		this.nazwaZmiennej = nazwaZmiennej;
	}

	

	@Override
	public String getMessage() {
		return "FILM VALIDATION, " + nazwaZmiennej + ", " + LocalDateTime.now(); 
	}

}
=======
import java.time.LocalDateTime;

public class FilmValidationException extends CustomException{
	
	private String nazwaZmiennej;

	
	
	public FilmValidationException(String nazwaZmiennej) {
		super();
		this.nazwaZmiennej = nazwaZmiennej;
	}

	

	@Override
	public String getMessage() {
		return "FILM VALIDATION, " + nazwaZmiennej + ", " + LocalDateTime.now(); 
	}

}
>>>>>>> fca0daedfb015b5611b3481145542a6d4984402b
