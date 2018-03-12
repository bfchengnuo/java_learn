import java.io.*;
public class Delete{
	public static void main(String[] args)throws Exception{
		Thread.sleep(5000);
		File[] fs = new File(".").listFiles(x -> x.isFile() && x.getName().toLowerCase().endsWith(".class"));
		for(File f : fs){
			f.delete();
		}
	}
}