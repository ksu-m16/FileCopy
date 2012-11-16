import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
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


/*class ExceptionA extends Exception {
	
}

class ExceptionB extends Exception {
	
}

class ExceptionBB extends ExceptionB {
	
}

class ExceptionTest {
	
	int var = 0;
	
	public void test0() throws Exception {
		try {			
			if (var == 0) {
				throw new ExceptionBB();
			}
			throw new ExceptionA();			
		} catch(ExceptionA ex) {
			System.out.println("A0");
			throw ex;
		} catch(Exception ex) { 
			throw ex;
		}
		finally {
			System.out.println("F0");
		}
	}
	
	public void test1() throws Exception {
		try {
			test0();
		} finally {
			System.out.println("F1");
			throw new ExceptionB();
		}
	}
	
	public void test2() throws Exception {
		try {
			test1();			
		} catch(ExceptionBB ex) {
			System.out.println("EBB2");
			throw ex;
		} catch(ExceptionB ex) {
			System.out.println("EB2");
			throw new ExceptionA();
		} catch(ExceptionA ex) {
			System.out.println("EA2");
			throw ex;
		}
	}
	
	public void test3() throws Exception {
		try {
			test2();
		} catch(ExceptionA ex) {
			System.out.println("EA3");
		} catch(ExceptionB ex) {
			System.out.println("EB3");
		} finally {
			System.out.println("F3");			
		}
	}
	
}
*/

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) {
		
/*		try {
			new ExceptionTest().test3();
		} catch(Exception ex) {
			System.out.println("EMAIN");
			return;
		}*/
		
		//long time = System.currentTimeMillis();
		//myCopy("e:/cassiopeia-2012-08-23.z02", "e:/test.bin");
		//System.out.println("time taken: " + (System.currentTimeMillis() - time) + " ms");
		
		//if (args.length == 0) {
			//return;
		//}
		
		File f = new File("E:\\MyDocuments\\My\\tm\\2.jpg");
		File targetFile = new File(f.getAbsolutePath() + "_copy.jpg");
			
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(f);
			os = new FileOutputStream(targetFile);
			
			byte[] b = new byte[1024*1024];

			while (is.available() > 0) {
				if (is.available() < b.length) {
					b = new byte[is.available()];
				}
				is.read(b);
				os.write(b);
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		

		
	}
	
	public static void myCopy(String srcName, String dstName) throws IOException {
		File src = new File(srcName);
		File dst = new File(dstName);
		
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(src);
			os = new FileOutputStream(dst);
			byte buf[] = new byte[1024*1024];
			while(is.available() != 0) {				
				os.write(buf, 0, is.read(buf));
			}
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch(IOException e) {					
				}
			}
			if (os != null) {
				try {
					os.close();
				} catch(IOException e) {					
				}
			}
		}				
	}

}
