<<<<<<< HEAD
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

public class Showing {

	private Film film;
	private double filmPrice;
	private double filmLength;
	private int roomNumber;
	private String propFileName = "showing.properties";

	public Showing(Film film, double filmPrice, double filmLength, int roomNumber) throws ShowingValidationException {
		super();
		setFilm(film);
		setFilmPrice(filmPrice);
		setFilmLength(filmLength);
		setRoomNumber(roomNumber);
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public double getFilmPrice() {
		return filmPrice;
	}

	public void setFilmPrice(double filmPrice) {
		Properties prop = new Properties();

		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName)) {

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}

		if (!(Integer.parseInt(prop.getProperty("CENA_MIN")) <= filmPrice
				&& filmPrice <= Integer.parseInt(prop.getProperty("CENA_MAX")))) {
			throw new ShowingValidationException("cena filmu", getFilm().getFilmName());
		} else {
			this.filmPrice = filmPrice;
		}
	}

	public double getFilmLength() {
		return filmLength;
	}

	public void setFilmLength(double filmLength) {
		Properties prop = new Properties();

		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName)) {

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}





		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		
		if (!(Double.parseDouble(prop.getProperty("CZAS_FILMU1")) == filmLength
				|| Double.parseDouble(prop.getProperty("CZAS_FILMU2")) == filmLength
				|| Double.parseDouble(prop.getProperty("CZAS_FILMU3")) == filmLength)) {
			throw new ShowingValidationException("czas filmu", getFilm().getFilmName());
		} else {
			this.filmLength = filmLength;
		}
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		Properties prop = new Properties();

		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName)) {

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}



			

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		
		if (!(Integer.parseInt(prop.getProperty("SALA_MIN")) <= roomNumber
				&& roomNumber <= Integer.parseInt(prop.getProperty("SALA_MAX")))) {
			throw new ShowingValidationException("numer sali", getFilm().getFilmName());
		} else {
			this.roomNumber = roomNumber;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(filmPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(filmLength);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((film == null) ? 0 : film.hashCode());
		result = prime * result + roomNumber;
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
		Showing other = (Showing) obj;
		if (Double.doubleToLongBits(filmPrice) != Double.doubleToLongBits(other.filmPrice))
			return false;
		if (Double.doubleToLongBits(filmLength) != Double.doubleToLongBits(other.filmLength))
			return false;
		if (film == null) {
			if (other.film != null)
				return false;
		} else if (!film.equals(other.film))
			return false;
		if (roomNumber != other.roomNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return film + ";" + filmPrice + ";" + filmLength + ";" + roomNumber;
	}

	public static void saveShowings(String fileName, Set<Showing> showings) {
		File plik = new File("D://Kapelusznik/OneDrive/Programowanie/Pliki tekstowe/" + fileName + ".txt");
		try (PrintWriter pw = new PrintWriter(plik)) {

			for (Showing s : showings) {
				pw.println(s.toString());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
=======
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

public class Showing {

	private Film film;
	private double filmPrice;
	private double filmLength;
	private int roomNumber;
	private String propFileName = "showing.properties";

	public Showing(Film film, double filmPrice, double filmLength, int roomNumber) throws ShowingValidationException {
		super();
		setFilm(film);
		setFilmPrice(filmPrice);
		setFilmLength(filmLength);
		setRoomNumber(roomNumber);
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public double getFilmPrice() {
		return filmPrice;
	}

	public void setFilmPrice(double filmPrice) {
		Properties prop = new Properties();

		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName)) {

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}

		if (!(Integer.parseInt(prop.getProperty("CENA_MIN")) <= filmPrice
				&& filmPrice <= Integer.parseInt(prop.getProperty("CENA_MAX")))) {
			throw new ShowingValidationException("cena filmu", getFilm().getFilmName());
		} else {
			this.filmPrice = filmPrice;
		}
	}

	public double getFilmLength() {
		return filmLength;
	}

	public void setFilmLength(double filmLength) {
		Properties prop = new Properties();

		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName)) {

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}





		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		
		if (!(Double.parseDouble(prop.getProperty("CZAS_FILMU1")) == filmLength
				|| Double.parseDouble(prop.getProperty("CZAS_FILMU2")) == filmLength
				|| Double.parseDouble(prop.getProperty("CZAS_FILMU3")) == filmLength)) {
			throw new ShowingValidationException("czas filmu", getFilm().getFilmName());
		} else {
			this.filmLength = filmLength;
		}
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		Properties prop = new Properties();

		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName)) {

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}



			

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		
		if (!(Integer.parseInt(prop.getProperty("SALA_MIN")) <= roomNumber
				&& roomNumber <= Integer.parseInt(prop.getProperty("SALA_MAX")))) {
			throw new ShowingValidationException("numer sali", getFilm().getFilmName());
		} else {
			this.roomNumber = roomNumber;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(filmPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(filmLength);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((film == null) ? 0 : film.hashCode());
		result = prime * result + roomNumber;
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
		Showing other = (Showing) obj;
		if (Double.doubleToLongBits(filmPrice) != Double.doubleToLongBits(other.filmPrice))
			return false;
		if (Double.doubleToLongBits(filmLength) != Double.doubleToLongBits(other.filmLength))
			return false;
		if (film == null) {
			if (other.film != null)
				return false;
		} else if (!film.equals(other.film))
			return false;
		if (roomNumber != other.roomNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return film + ";" + filmPrice + ";" + filmLength + ";" + roomNumber;
	}

	public static void saveShowings(String fileName, Set<Showing> showings) {
		File plik = new File("D://Kapelusznik/OneDrive/Programowanie/Pliki tekstowe/" + fileName + ".txt");
		try (PrintWriter pw = new PrintWriter(plik)) {

			for (Showing s : showings) {
				pw.println(s.toString());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
>>>>>>> fca0daedfb015b5611b3481145542a6d4984402b
