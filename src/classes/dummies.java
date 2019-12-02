package classes;

import java.util.Random;

import functions.functions;
import functions.translations;
import modules.products.classes.Film;
import modules.products.classes.Game;
import modules.products.classes.MusicDisc;
import modules.products.classes.Product;
import modules.purchases.classes.Purchase;
import modules.users.classes.Admin;
import modules.users.classes.Partner;

public class dummies {
	public static void generateDummies() {

		Admin admin = new Admin("admin", "admin", "admin", "Surname1 Surname2", functions.generateDni(null),
				"Ontinyent", "46870", "C/ Sant Josep, 6", "jrevertvila@gmail.com", new Date(randomDate()), 665996125);
		modules.users.classes.Singleton.users.add(admin);

		for (int i = 0; i < 30; i++) {
			Partner user = new Partner("partner" + i, "123", randomName(), randomName() + " " + randomName(),
					functions.generateDni(null), "Ontinyent", "46870", "C/ Sant Josep, 6", randomEmail(),
					new Date(randomDate()), randomTlf());

			Product product = new Film(randomTitle(), 10, 10, 4.5, new Date(randomDate()), randomNumber(200, 10),
					"Descripcion - Synopsis");

			Product product2 = new Game(randomTitle(), 10, 10, 3.0, new Date(randomDate()), randomPlatform());

			Product product3 = new MusicDisc(randomTitle(), 10, 10, 4.1, new Date(randomDate()), randomNumber(50, 5),
					randomName());

			modules.users.classes.Singleton.users.add(user);
			modules.products.classes.Singleton.products.add(product);
			modules.products.classes.Singleton.products.add(product2);
			modules.products.classes.Singleton.products.add(product3);
		}

		for (int i = 0; i < 150; i++) {
			Purchase purchase = new Purchase(randomProduct(), randomPartner(), 1);
			modules.purchases.classes.Singleton.purchases.add(purchase);
		}
	}

	public static Integer randomNumber(int max, int min) {
		Random random = new Random();
		int randomNumber = random.nextInt(max - min) + min;
		return randomNumber;
	}

	public static String randomPlatform() {
		String platform = "";
		String[] typePlatforms = { "PS3", "PS4", "XBox 360", "XBox One", "Nintendo Switch", "Nintendo DS",
				"Nintendo WII", "PC" };
		int randomIndex = (int) (Math.random() * typePlatforms.length);

		platform = typePlatforms[randomIndex];

		return platform;
	}

	public static Product randomProduct() {
		Product product = null;
		Boolean correct = false;
		do {
			int randomIndex = (int) (Math.random() * modules.products.classes.Singleton.products.size());
			if (modules.products.classes.Singleton.products.get(randomIndex).getStock() > 0) {
				product = modules.products.classes.Singleton.products.get(randomIndex);
				correct = true;
			} else {
				correct = false;
			}
		} while (correct == false);

		return product;
	}

	public static Partner randomPartner() {
		Partner partner = null;
		Boolean correct = false;
		do {
			int randomIndex = (int) (Math.random() * modules.users.classes.Singleton.users.size());
			if (functions.validateInstaceof(modules.users.classes.Singleton.users.get(randomIndex), "Partner")) {
				partner = (Partner) modules.users.classes.Singleton.users.get(randomIndex);
				correct = true;
			} else {
				correct = false;
			}
		} while (correct == false);

		return partner;
	}

	public static String randomDate() {// Obtenemos un nombre aleatorio
		String date = "";
		Random generator = new Random();

		String[] dates = { "01-03-1946", "26-12-2035", "04-05-1995", "13-10-2022", "08-03-1999", "01-12-1999",
				"20-11-1995", "17-02-2008", "15-03-2096", "26-04-2001", "20-10-1993", "13-02-2097", "28-05-2030",
				"05-03-2077", "03-03-1948", "31-12-2054", "28-03-2063", "28-07-2079", "28-04-1998", "25-09-2077",
				"16-09-1972", "30-05-1908", "31-12-1926", "10-10-1911", "26-01-1977", "14-12-2017", "02-06-1921",
				"02-10-1904", "08-08-1978", "23-05-1977", "23-02-2054", "20-02-1921", "11-03-1918", "18-07-2036",
				"05-12-2013" };

		int randomIndex = generator.nextInt(dates.length);
		date = dates[randomIndex];
		return date;
	}

	public static String randomTitle() {// Obtenemos un nombre aleatorio
		String title = "";
		Random generator = new Random();

		String[] titles1 = { "Lost", "Only", "Last", "First", "Third", "Sacred", "Bold", "Lovely", "Final", "Missing",
				"Shadowy", "Seventh", "Dwindling", "Missing", "Absent", "Vacant", "Cold", "Hot", "Burning", "Forgotten",
				"Weeping", "Dying", "Lonely", "Silent", "Laughing", "Whispering", "Forgotten", "Smooth", "Silken",
				"Rough", "Frozen", "Wild", "Trembling", "Fallen", "Ragged", "Broken", "Cracked", "Splintered",
				"Slithering", "Silky", "Wet", "Magnificent", "Luscious", "Swollen", "Erect", "Bare", "Naked",
				"Stripped", "Captured", "Stolen", "Sucking", "Licking", "Growing", "Kissing", "Green", "Red", "Blue",
				"Azure", "Rising", "Falling", "Elemental", "Bound", "Prized", "Obsessed", "Unwilling", "Hard", "Eager",
				"Ravaged", "Twinkling", "Dwindling", "Missing", "Absent", "Vacant", "Cold", "Hot", "Burning",
				"Forgotten", "Some", "No", "All", "Every", "Each", "Which", "What", "Playful", "Silent", "Weeping",
				"Dying", "Lonely", "Silent", "Laughing", "Whispering", "Forgotten", "Smooth", "Silken", "Rough",
				"Frozen", "Wild", "Trembling", "Fallen", "Ragged", "Broken", "Cracked", "Splintered" };
		String[] titles2 = { "Sons", "Child", "Children", "Illusion", "Sliver", "Destruction", "Crying", "Weeping",
				"Gift", "Word", "Words", "Thought", "Thoughts", "Scent", "Ice", "Snow", "Night", "Silk", "Guardian",
				"Angel", "Angels", "Secret", "Secrets", "Search", "Eye", "Eyes", "Danger", "Game", "Fire", "Flame",
				"Flames", "Bride", "Husband", "Wife", "Time", "Flower", "Flowers", "Light", "Lights", "Door", "Doors",
				"Window", "Windows", "Bridge", "Bridges", "Ashes", "Memory", "Thorn", "Thorns", "Name", "Names",
				"Future", "Past", "History", "Something", "Nothing", "Someone", "Nobody", "Person", "Man", "Woman",
				"Boy", "Girl", "Way", "Mage", "Witch", "Witches", "Lover", "Tower", "Valley", "Abyss", "Hunter",
				"Truth", "Edge" };

		int randomIndex1 = generator.nextInt(titles1.length);
		int randomIndex2 = generator.nextInt(titles2.length);
		title = titles1[randomIndex1] + " " + titles2[randomIndex2];
		return title;
	}

	public static String randomName() {// Obtenemos un nombre aleatorio
		String name = "";
		Random generator = new Random();

		String[] names = { "VICENT", "WALTER", "JOAN", "MARIA", "DANIEL", "JOSEP", "SARA", "PEPA", "FELIPE", "JAUME",
				"SERGIO", "PACO", "EMILIO", "NANDO", "ALFONS", "EDUARD", "ATALIA", "VERONICA", "FINA", "PEPE", "OSCAR",
				"LORELAY", "JIM", "LOLA", "LAIA", "ISMAEL", "JORDI", "RAMON", "JAVIER", "NURIA", "ELENA", "BELTRAN",
				"PABLO", "JUANJO" };

		int randomIndex = generator.nextInt(names.length);
		name = names[randomIndex];
		return name;
	}

	public static String randomEmail() {// Obtenemos un nombre aleatorio
		String email = "";
		Random generator = new Random();

		String[] emails = { "elewa@casinoleaks.info", "beunhye@womanolog.ru", "2oussama.ayoub.2j@anorling.com",
				"pakramlemoudaa4g@mobilhondasidoarjo.com", "eaulian@mobilhondasidoarjo.com",
				"jroma.liikeu@nonconductors.com", "jroma.liikeu@nonconductors.com", "kferas.ihav@johnfabio.online",
				"6sayfmoussa80k@mensdivorcearkansas.com", "6tamr.alghanm@1xstabka.ru", "ehalzpheryz@wedostuffwell.net",
				"yloveriraq_abbasn@correoparacarlos.ga", "2norcorbettn@tweeflood.com",
				"5ljbwry.jsm9@blueauramassage.com", "lleliam@customizing225ll.online",
				"zadam.el@americanimportstore.com", "goumaima.rouchdik@customizing225ll.online" };

		int randomIndex = generator.nextInt(emails.length);
		email = emails[randomIndex];
		return email;
	}

	public static Integer randomTlf() {// Obtenemos un nombre aleatorio
		Integer number = 0;
		Random generator = new Random();

		Integer[] numbers = { 683222448, 769123776, 667047815, 623729414, 753086967, 736864735, 788463066, 627049094,
				739630804, 717022786, 756491133, 683839246, 725952955, 791678172, 697336297, 797612212, 747927651,
				629862564, 765573015, 754924926, 631256502, 658472195, 774863914, 697813878, 635719742, 786457121,
				750981592, 646232718, 732674916, 796284650 };

		int randomIndex = generator.nextInt(numbers.length);
		number = numbers[randomIndex];
		return number;
	}

	public static String transalte(String wordForTranslate) {
		String translated = "";
		String[] translateData = translations.translationsWords();
		for (int i = 0; i < translateData.length; i += 2) {
			if (translateData[i].matches(wordForTranslate)) {
				translated = translateData[(i + 1)];
			}
		}

		return translated;
	}

	private static final char[] LETRAS_NIF = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J',
			'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' };

	public static String generateDni(String seed) {
		if (seed != null) {
			try {
				Integer.parseInt(seed);
			} catch (NumberFormatException ex) {
				return "KO";
			}
		} else {
			seed = "";
		}
		String numeroDNI = String.valueOf(Math.random()).concat(seed);
		String fullDNI = numeroDNI.substring(numeroDNI.length() - 8);

		int dniInt = Integer.valueOf(fullDNI);
		fullDNI = fullDNI + LETRAS_NIF[dniInt % 23];
		return fullDNI;
	}
}
