package Examples;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 
 * A simple class showing random access capabilities on files
 * 
 * @author Nicola Bicocchi
 *
 */
public class RandomAccess {
	public static void main(String[] args) {
		byte[] buffer = new byte[1024];
		try {
			RandomAccessFile file = new RandomAccessFile("webpage.html", "r");
			file.seek(0);
			file.read(buffer);
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(new String(buffer));
	}
}