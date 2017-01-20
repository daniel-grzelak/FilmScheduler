<<<<<<< HEAD
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class ReadFilmFile implements IFilm{

	private Set<Film> set = new HashSet<>();
	private final static String sciezka = "D://OneDrive/Programowanie/Pliki tekstowe/";
	
	public ReadFilmFile(String film) {
		File plik = new File(sciezka + film + ".txt");
		try(Scanner sc = new Scanner(plik)) {
			
			while(sc.hasNextLine()) {
				String[] tab = sc.nextLine().split(" - ");
				set.add(new Film(tab[0], tab[1], tab[2]));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Set<Film> getSet() {
		return set;
	}

	public void setSet(Set<Film> set) {
		this.set = set;
	}

	@Override
	public Film readFilm() {
		Random rng = new Random();
		List<Film> lista = new ArrayList<Film>(set);
		return lista.get(rng.nextInt(lista.size()));
	}	
	
	
}
=======
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class ReadFilmFile implements IFilm{

	private Set<Film> set = new HashSet<>();
	private final static String sciezka = "D://OneDrive/Programowanie/Pliki tekstowe/";
	
	public ReadFilmFile(String film) {
		File plik = new File(sciezka + film + ".txt");
		try(Scanner sc = new Scanner(plik)) {
			
			while(sc.hasNextLine()) {
				String[] tab = sc.nextLine().split(" - ");
				set.add(new Film(tab[0], tab[1], tab[2]));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Set<Film> getSet() {
		return set;
	}

	public void setSet(Set<Film> set) {
		this.set = set;
	}

	@Override
	public Film readFilm() {
		Random rng = new Random();
		List<Film> lista = new ArrayList<Film>(set);
		return lista.get(rng.nextInt(lista.size()));
	}	
	
	
}
>>>>>>> fca0daedfb015b5611b3481145542a6d4984402b
