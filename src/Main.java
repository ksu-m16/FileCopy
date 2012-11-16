import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;


public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		File f = new File("E:\\MyDocuments\\My\\tm\\2.jpg");
		File targetFile = new File(f.getAbsolutePath() + "_copy.jpg");
			
		InputStream is = new FileInputStream(f);
		OutputStream os = new FileOutputStream(targetFile);
		
		byte[] b = new byte[1024];

		while (is.available() > 0) {
			if (is.available() < b.length) {
				b = new byte[is.available()];
			}
			is.read(b);
			os.write(b);
			
		}
		
		is.close();
		os.close();
		
	}

}
