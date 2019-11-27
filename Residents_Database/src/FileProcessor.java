import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileProcessor {

	public static ResidentDataBaseModel readFile(String fileName) throws IOException {

		ResidentDataBaseModel model = new ResidentDataBaseModel();
		ResidentModel res = null;
		FileReader fr = null;
		try {
			fr = new FileReader(fileName);
		} catch (FileNotFoundException f) {

		}

		BufferedReader br = null;
		try {
			br = new BufferedReader(fr);
			String nextLine = br.readLine();
			while (nextLine != null) {
				nextLine = br.readLine();
				if (nextLine != null) {
					res = processLine(nextLine);
					if (!model.contains(res)) {
						model.add(res);
					}
				}
			}
			br.close();
		} catch (ArrayIndexOutOfBoundsException a) {
			return model;
		} catch (IOException e) {
			return null;
		} catch (StringIndexOutOfBoundsException i) {
			throw new StringIndexOutOfBoundsException();
		}
		return model;
	}

	public static ResidentModel processLine(String line) {

		/*
		 * firstname, middlename, lastname. bed, major enrollment, floor, smoke,
		 * mindsmoke, smokeout mindsmokeout, havepet, mindpet, work, neat personality,
		 * social, sleep, mate1, mate2 mate3, hobbies, pets, characteristics,
		 * seekedcharacteristics
		 */

		ArrayList<Hobby> hobbies = new ArrayList<Hobby>();
		ArrayList<Pet> pets = new ArrayList<Pet>();
		ArrayList<Characteristic> characteristics = new ArrayList<Characteristic>();
		ArrayList<Characteristic> seekedCharacteristics = new ArrayList<Characteristic>();
		String[] parts = line.split(",");
		int i = 0;

		String firstName = parts[i];
		++i;
		String middleName = parts[i];
		++i;
		String lastName = parts[i];
		++i;
		Bed bed = Bed.fromString(parts[i]);
		++i;
		Major major = Major.fromString(parts[i]);
		++i;
		Enrollment enrollment = Enrollment.fromString(parts[i]);
		++i;
		Floor floor = Floor.fromString(parts[i]);
		++i;
		boolean smoke;
		int num = Integer.parseInt(parts[i]);
		if (num == 0) {
			smoke = false;
		} else {
			smoke = true;
		}
		++i;
		boolean mindSmoke;
		num = Integer.parseInt(parts[i]);
		if (num == 0) {
			mindSmoke = false;
		} else {
			mindSmoke = true;
		}
		++i;
		boolean smokeOut;
		num = Integer.parseInt(parts[i]);
		if (num == 0) {
			smokeOut = false;
		} else {
			smokeOut = true;
		}
		++i;
		boolean mindSmokeOut;
		num = Integer.parseInt(parts[i]);
		if (num == 0) {
			mindSmokeOut = false;
		} else {
			mindSmokeOut = true;
		}
		++i;
		boolean havePet;
		num = Integer.parseInt(parts[i]);
		if (num == 0) {
			havePet = false;
		} else {
			havePet = true;
		}
		++i;
		boolean mindPet;
		num = Integer.parseInt(parts[i]);
		if (num == 0) {
			mindPet = false;
		} else {
			mindPet = true;
		}
		++i;
		int work = Integer.parseInt(parts[i]);
		++i;
		int neat = Integer.parseInt(parts[i]);
		++i;
		int personality = Integer.parseInt(parts[i]);
		++i;
		int social = Integer.parseInt(parts[i]);
		++i;
		int sleep = Integer.parseInt(parts[i]);
		++i;
		String mate1 = parts[i];
		++i;
		String mate2 = parts[i];
		++i;
		String mate3 = parts[i];
		++i;
		while (!parts[i].equals("!") && i < parts.length) {
			hobbies.add(Hobby.fromString(parts[i]));
			++i;
		}

		++i;
		while (!parts[i].equals("!") && i < parts.length) {
			pets.add(Pet.fromString(parts[i]));
			++i;
		}
		++i;
		while (!parts[i].equals("!") && i < parts.length) {
			characteristics.add(Characteristic.fromString(parts[i]));
			++i;
		}
		++i;
		while (!parts[i].equals("!") && i < parts.length) {
			seekedCharacteristics.add(Characteristic.fromString(parts[i]));
			++i;
		}
		if (hobbies.size() == 0) {
			hobbies.add(Hobby.OTHER);
		}
		if (pets.size() == 0) {
			pets.add(Pet.NONE);
		}
		if (characteristics.size() == 0) {
			characteristics.add(Characteristic.OTHER);
		}
		if (seekedCharacteristics.size() == 0) {
			seekedCharacteristics.add(Characteristic.OTHER);
		}
		++i;
		GenderPreference gender = GenderPreference.fromString(parts[i]);
		
		ResidentModel res = new ResidentModel(firstName, middleName, lastName, bed, mate1, mate2, mate3, major,
				enrollment, hobbies, characteristics, seekedCharacteristics, floor, smoke, mindSmoke, smokeOut,
				mindSmokeOut, havePet, mindPet, pets, work, neat, personality, social, sleep, gender);
		return res;
	}

}