import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Repertoire {

	private Map<LocalDate, Map<Showing, LocalTime>> mapa;
	private final static String sciezka = new String("D://Kapelusznik/OneDrive/Programowanie/Pliki tekstowe/");

	public Repertoire(String nazwaPliku, LocalDate data1, LocalDate data2) {
		super();
		mapa = new HashMap<LocalDate, Map<Showing, LocalTime>>();

		LocalDate dataPierwsza = null;
		LocalDate dataDruga = null;
		if (data1.isBefore(data2)) {
			dataPierwsza = data1;
			dataDruga = data2;
		} else {
			dataPierwsza = data2;
			dataDruga = data1;
		}

		for (LocalDate dataLoop = dataPierwsza; dataLoop.isBefore(dataDruga); dataLoop = dataLoop.plusDays(1)) {

			mapa.put(dataLoop, null);
		}
		
		File plik = new File(sciezka + nazwaPliku + ".txt");

		for (Map.Entry<LocalDate, Map<Showing, LocalTime>> e : mapa.entrySet()) {
			e.setValue(Randomizer(plik));
		}
	}

	public Map<Showing, LocalTime> Randomizer(File plik) {
		Map<Showing, LocalTime> mapInner = new HashMap<>();
		try (Scanner seanse = new Scanner(plik)) {
			while (seanse.hasNextLine()) {
				String[] tab = seanse.nextLine().split(";");
				mapInner.put(new Showing(new Film(tab[0], tab[1], tab[2]), Double.parseDouble(tab[3]),
						Double.parseDouble(tab[4]), Integer.parseInt(tab[5])), null);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Map.Entry<Showing, LocalTime> e : mapInner.entrySet()) {
			int numerSali = e.getKey().getRoomNumber();

			boolean czySalaJuzByla = false;
			for (Map.Entry<Showing, LocalTime> en : mapInner.entrySet()) {
				if (numerSali == en.getKey().getRoomNumber()) {
					if (en.getValue() != null) {
						czySalaJuzByla = true;
						break;
					}
				}

			}
			if (czySalaJuzByla == false) {
				e.setValue(LocalTime.of(10, 0));

			} else {
				for (Map.Entry<Showing, LocalTime> en : mapInner.entrySet()) {
					if (numerSali == en.getKey().getRoomNumber()) {

						if (en.getValue() != null) {

							e.setValue(en.getValue().plusMinutes((long) en.getKey().getFilmLength() + 8));
						}

					}
				}

			}
		}

		return mapInner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mapa == null) ? 0 : mapa.hashCode());
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
		Repertoire other = (Repertoire) obj;
		if (mapa == null) {
			if (other.mapa != null)
				return false;
		} else if (!mapa.equals(other.mapa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<LocalDate, Map<Showing, LocalTime>> e : mapa.entrySet()) {
			sb.append("\n\n" + e.getKey() + "\n\n");
			for (int i = 1; i < 5; i++) {
				sb.append("Room number " + i + "\n\n");
				for (Map.Entry<Showing, LocalTime> en : e.getValue().entrySet()) {
					if (i == en.getKey().getRoomNumber()) {
						sb.append("Film name: " + en.getKey().getFilm().getFilmName() + ", Film genre: "
								+ en.getKey().getFilm().getFilmGenre() + ", Director: "
								+ en.getKey().getFilm().getDirector() + ", Price: " + en.getKey().getFilmPrice()
								+ "$, Length: " + en.getKey().getFilmLength() + "min, Room number: "
								+ en.getKey().getRoomNumber() + "       Hour: " + en.getValue() + "\n");
					}
				}
				sb.append("\n");
			}

		}
		return sb.toString();
	}

}
