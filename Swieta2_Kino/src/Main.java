<<<<<<< HEAD
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		ReadFilmRandom pbfr = new ReadFilmRandom();
		Set<Showing> seanse = new HashSet<>();
		
		//Creating random films, some with errors for the sake of validation working
		Random rng = new Random();
		for (int i = 0; i < 120; ++i) {
			try {

				Showing s = new Showing(pbfr.readFilm(), 7, 60, rng.nextInt(6));
				seanse.add(s);

			} catch (FilmValidationException e) {
				if (CustomException.getMapa().containsKey("FilmValidationException")) {
					CustomException.getMapa().get("FilmValidationException").add(e.getMessage());
				} else {
					CustomException.getMapa().put("FilmValidationException",
							new ArrayList<>(Arrays.asList(new String[] { e.getMessage() })));
				}
			} catch (ShowingValidationException e) {
				if (CustomException.getMapa().containsKey("ShowingValidationException")) {
					CustomException.getMapa().get("ShowingValidationException").add(e.getMessage());
				} else {
					CustomException.getMapa().put("ShowingValidationException",
							new ArrayList<>(Arrays.asList(new String[] { e.getMessage() })));
				}
			}

		}

		
		Showing.saveShowings("seanse", seanse);

		Repertoire r = new Repertoire("seanse", LocalDate.now(), LocalDate.now().plusDays(2));
		
		
		System.out.println(r.toString());

		CustomException.showExceptions();
		System.out.println(CustomException.showEarliest());
		System.out.println(CustomException.showLatest());
		CustomException.printToFile("mapa");
		CustomException.statistics();
		CustomException.clean();
		CustomException.showExceptions();

	}

}
=======
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		ReadFilmRandom pbfr = new ReadFilmRandom();
		Set<Showing> seanse = new HashSet<>();
		
		//Creating random films, some with errors for the sake of validation working
		Random rng = new Random();
		for (int i = 0; i < 120; ++i) {
			try {

				Showing s = new Showing(pbfr.readFilm(), 7, 60, rng.nextInt(6));
				seanse.add(s);

			} catch (FilmValidationException e) {
				if (CustomException.getMapa().containsKey("FilmValidationException")) {
					CustomException.getMapa().get("FilmValidationException").add(e.getMessage());
				} else {
					CustomException.getMapa().put("FilmValidationException",
							new ArrayList<>(Arrays.asList(new String[] { e.getMessage() })));
				}
			} catch (ShowingValidationException e) {
				if (CustomException.getMapa().containsKey("ShowingValidationException")) {
					CustomException.getMapa().get("ShowingValidationException").add(e.getMessage());
				} else {
					CustomException.getMapa().put("ShowingValidationException",
							new ArrayList<>(Arrays.asList(new String[] { e.getMessage() })));
				}
			}

		}

		
		Showing.saveShowings("seanse", seanse);

		Repertoire r = new Repertoire("seanse", LocalDate.now(), LocalDate.now().plusDays(2));
		
		
		System.out.println(r.toString());

		CustomException.showExceptions();
		System.out.println(CustomException.showEarliest());
		System.out.println(CustomException.showLatest());
		CustomException.printToFile("mapa");
		CustomException.statistics();
		CustomException.clean();
		CustomException.showExceptions();

	}

}
>>>>>>> fca0daedfb015b5611b3481145542a6d4984402b
