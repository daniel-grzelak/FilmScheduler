<<<<<<< HEAD
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;


public class Film {

	private String filmName;
	private String filmGenre;
	private String director;


	public Film(String filmName, String filmGenre, String director) throws FilmValidationException{
		super();
		setFilmName(filmName);
		setFilmGenre(filmGenre);
		setDirector(director);
	}


	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		if (!filmName.matches("[A-Z| ]*"))
		{
			throw new FilmValidationException("Film name");
		}
		this.filmName = filmName;
	}

	public String getFilmGenre() {
		return filmGenre;
	}

	public void setFilmGenre(String filmGenre) {
		Properties prop = new Properties();
		String propFileName = "genres.properties";

		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName)) 
		{

			if (inputStream != null) 
			{
				prop.load(inputStream);
			} 
			else 
			{
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}

		} 
		catch (Exception e) {
				
		}
		
		if (!prop.getProperty("genres").contains(filmGenre)) {
			throw new FilmValidationException("Film genre");
		}
		this.filmGenre = filmGenre;

	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		if (!director.matches("[A-Z]{1}[a-z]* [A-Z]{1}[a-z]*")) {
			throw new FilmValidationException("director");
		}else {
			this.director = director;
		}

	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filmGenre == null) ? 0 : filmGenre.hashCode());
		result = prime * result + ((filmName == null) ? 0 : filmName.hashCode());
		result = prime * result + ((director == null) ? 0 : director.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (filmGenre == null) {
			if (other.filmGenre != null)
				return false;
		} else if (!filmGenre.equals(other.filmGenre))
			return false;
		if (filmName == null) {
			if (other.filmName != null)
				return false;
		} else if (!filmName.equals(other.filmName))
			return false;
		if (director == null) {
			if (other.director != null)
				return false;
		} else if (!director.equals(other.director))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return  filmName + ";" + filmGenre + ";" + director;
	}

}
=======
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;


public class Film {

	private String filmName;
	private String filmGenre;
	private String director;


	public Film(String filmName, String filmGenre, String director) throws FilmValidationException{
		super();
		setFilmName(filmName);
		setFilmGenre(filmGenre);
		setDirector(director);
	}


	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		if (!filmName.matches("[A-Z| ]*"))
		{
			throw new FilmValidationException("Film name");
		}
		this.filmName = filmName;
	}

	public String getFilmGenre() {
		return filmGenre;
	}

	public void setFilmGenre(String filmGenre) {
		Properties prop = new Properties();
		String propFileName = "genres.properties";

		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName)) 
		{

			if (inputStream != null) 
			{
				prop.load(inputStream);
			} 
			else 
			{
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}

		} 
		catch (Exception e) {
				
		}
		
		if (!prop.getProperty("genres").contains(filmGenre)) {
			throw new FilmValidationException("Film genre");
		}
		this.filmGenre = filmGenre;

	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		if (!director.matches("[A-Z]{1}[a-z]* [A-Z]{1}[a-z]*")) {
			throw new FilmValidationException("director");
		}else {
			this.director = director;
		}

	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filmGenre == null) ? 0 : filmGenre.hashCode());
		result = prime * result + ((filmName == null) ? 0 : filmName.hashCode());
		result = prime * result + ((director == null) ? 0 : director.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (filmGenre == null) {
			if (other.filmGenre != null)
				return false;
		} else if (!filmGenre.equals(other.filmGenre))
			return false;
		if (filmName == null) {
			if (other.filmName != null)
				return false;
		} else if (!filmName.equals(other.filmName))
			return false;
		if (director == null) {
			if (other.director != null)
				return false;
		} else if (!director.equals(other.director))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return  filmName + ";" + filmGenre + ";" + director;
	}

}
>>>>>>> fca0daedfb015b5611b3481145542a6d4984402b
