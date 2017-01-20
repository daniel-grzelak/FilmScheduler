<<<<<<< HEAD
import java.util.Random;

public class ReadFilmRandom implements IFilm{

	private final static String[] TITLES = {"CYTRYNDOR","Heheszek", "WHIPPED CREAM"};
	private final static String[] GENRES = {"comedy", "HORROR", "thriller"};
	private final static String[] DIRECTORS = {"Mr Mietek", "Kurt Cobain", "Cup of TeA"};
	
	@Override
	public Film readFilm() {
		Random rng = new Random();

		
		return new Film(TITLES[rng.nextInt(TITLES.length)], GENRES[rng.nextInt(GENRES.length)], DIRECTORS[rng.nextInt(DIRECTORS.length)]);
		
	}
}
=======
import java.util.Random;

public class ReadFilmRandom implements IFilm{

	private final static String[] TITLES = {"CYTRYNDOR","Heheszek", "WHIPPED CREAM"};
	private final static String[] GENRES = {"comedy", "HORROR", "thriller"};
	private final static String[] DIRECTORS = {"Mr Mietek", "Kurt Cobain", "Cup of TeA"};
	
	@Override
	public Film readFilm() {
		Random rng = new Random();

		
		return new Film(TITLES[rng.nextInt(TITLES.length)], GENRES[rng.nextInt(GENRES.length)], DIRECTORS[rng.nextInt(DIRECTORS.length)]);
		
	}
}
>>>>>>> fca0daedfb015b5611b3481145542a6d4984402b
