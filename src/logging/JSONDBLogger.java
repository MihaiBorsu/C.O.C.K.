package logging;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.simple.JSONObject;


/**
 * Writes data to a json file.
 * 
 * @param	fullPath	path wehre the json file should be stored
 * @param	append		append data to file
 *
 */
public class JSONDBLogger {
	private PrintWriter pw;
	private JSONObject obj;

	public JSONDBLogger(String fullPath, boolean append) {
		try {
			BufferedWriter dbFile = new BufferedWriter(new FileWriter(fullPath, append));
			pw = new PrintWriter(dbFile);
			obj = new JSONObject();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * Adds a key-value pair to the json object
	 * 
	 * @param key
	 * @param value
	 */
	public void add(Object key, Object value) {
		obj.put(key.toString(), value.toString());
	}

//	public void write(Object... values) {
//		String s = "";
//		for (Object o : values)
//			s += o.toString() + " ";
//		pw.println(s);
//	}

	
	/**
	 * Writes the data to file, while closing it. 
	 */
	public void write() {
		pw.write(obj.toJSONString() + '\n');
//		if (pw != null)
		pw.close();
	}

}
