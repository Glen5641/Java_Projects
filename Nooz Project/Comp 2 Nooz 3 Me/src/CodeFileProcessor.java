
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class processes files into Treemaps and sends them to mother class
 * 
 * @author cglen and Dean Hougen
 */
public class CodeFileProcessor {

	private static Map<String, String> codeMap = new TreeMap<String, String>();

	/**
	 * This method decodes a file and creates a treeMap with the files contents
	 * 
	 * @param fileName
	 * @return  Map of file contents
	 * @throws IOException
	 */
	public static Map<String, String> readCodeFile(String fileName) throws IOException {

		// Clear map
		if (!codeMap.isEmpty()) {
			codeMap = new TreeMap<String, String>();
		}

		// Open file reader and read first line
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		String nextLine = br.readLine();

		// Decode the parts into a codeMap
		while (nextLine != null) {
			String[] parts = nextLine.split(",");
			codeMap.put(parts[0], parts[1]);
			nextLine = br.readLine();
		}

		// Close the reader
		br.close();

		// Return map to mother class
		return codeMap;
	}
}
