import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomException extends RuntimeException {

	private static Map<String, List<String>> mapa = new HashMap<>();

	public static Map<String, List<String>> getMapa() {
		return mapa;
	}

	public static void setMapa(Map<String, List<String>> mapa) {
		CustomException.mapa = mapa;
	}

	public static String showEarliest() {
		LocalDateTime earliest = null;
		String napis = "";
		for (Map.Entry<String, List<String>> entry : getMapa().entrySet()) {
			for (String s : entry.getValue()) {
				
				String[] tab = s.split(", ");


				
				if(entry.getKey().equals("FilmValidationException")) {
					if (earliest == null) {
						earliest = LocalDateTime.parse(tab[2]);
						napis = "Earliest exception is: " + entry.getKey() + " " + s;
					} else if (earliest.isAfter(LocalDateTime.parse(tab[2]))) {
						earliest = LocalDateTime.parse(tab[2]);
						 napis = "Earliest exception is: " + entry.getKey() + " " + s;
					}
				}else {
					if (earliest == null) {
						
						earliest = LocalDateTime.parse(tab[3]);
						napis = "Earliest exception is: " + entry.getKey() + " " + s;
					} else if (earliest.isAfter(LocalDateTime.parse(tab[3]))) {
						earliest = LocalDateTime.parse(tab[3]);
						 napis = "Earliest exception is: " + entry.getKey() + " " + s;
					}
				}
			

			}
			
		}

		return napis;
	}
	
	public static String showLatest() {
		LocalDateTime latest = null;
		String napis = "";
		for (Map.Entry<String, List<String>> entry : getMapa().entrySet()) {
			for (String s : entry.getValue()) {
				
				String[] tab = s.split(", ");


				
				if(entry.getKey().equals("FilmValidationException")) {
					if (latest == null) {
						latest = LocalDateTime.parse(tab[2]);
						napis = "Latest exception is: " + entry.getKey() + " " + s;
					} else if (latest.isBefore(LocalDateTime.parse(tab[2]))) {
						latest = LocalDateTime.parse(tab[2]);
						 napis = "Latest exception is: " + entry.getKey() + " " + s;
					}
				}else {
					if (latest == null) {
						latest = LocalDateTime.parse(tab[3]);
						napis = "Latest exception is: " + entry.getKey() + " " + s;
					} else if (latest.isBefore(LocalDateTime.parse(tab[3]))) {
						latest = LocalDateTime.parse(tab[3]);
						 napis = "Latest exception is:: " + entry.getKey() + " " + s;
					}
				}
			

			}
			
		}

		return napis;
	}
	
	public static void statistics() {
		System.out.println(mapa.entrySet().stream().sorted((m1,m2)->Integer.compare(m2.getValue().size(), m1.getValue().size())).findFirst().get().getKey());
	}
	
	public static void clean() {
		mapa.clear();
	}
	
	public static void printToFile(String fileName) {
		File file = new File("D://Kapelusznik/OneDrive/Programowanie/Pliki tekstowe/" + fileName + ".txt");
		

		try(PrintWriter pw = new PrintWriter(file)) {

			for (Map.Entry<String, List<String>> en : CustomException.getMapa().entrySet()) {
				pw.println(en.getKey());
				for (String str : en.getValue()) {
					pw.println(str);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void showExceptions() {
		for (Map.Entry<String, List<String>> en : CustomException.getMapa().entrySet()) {
			System.out.println(en.getKey());
			for (String str : en.getValue()) {
				System.out.println(str);
			}
		}
	}

}
