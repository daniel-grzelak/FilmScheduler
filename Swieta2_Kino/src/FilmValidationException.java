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
