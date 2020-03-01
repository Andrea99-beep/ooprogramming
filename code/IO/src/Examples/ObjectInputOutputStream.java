package Examples;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectInputOutputStream {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("data.bin"));

		List<Student> lin = new ArrayList<Student>();
		lin.add(new Student("Nicola", "Bicocchi", 2000, 28.0));
		lin.add(new Student("Mario", "Rossi", 1999, 27.0));
		lin.add(new Student("Luca", "Bianchi", 2001, 29.0));
		objectOutputStream.writeObject(lin);
		objectOutputStream.close();

		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("data.bin"));
		@SuppressWarnings("unchecked")
		List<Student> lout = (List<Student>) objectInputStream.readObject();
		objectInputStream.close();

		for (Student s : lout) {
			System.out.println(s);
		}
	}
}
