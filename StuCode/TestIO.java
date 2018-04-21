import java.io.*;
public class TestIO{
	public static long javaCount;
	public static long count;
	public static long pubCount;
	public static void main(String[] args) throws Exception{
		File file = new File("D:\\Development\\jdk-8\\src");
		show(file);
		System.out.println("Java文件:" + javaCount);
		System.out.println("count:" + count);
		System.out.println("pubCount:" + pubCount);
	}
	
	public static void show(File file) throws Exception{
		// File[] files = file.listFiles(JavaFilter.getFilter());
		// File[] dirs = file.listFiles(DirFilter.getFilter());
		File[] files = file.listFiles(f -> f.isFile() && f.getName().endsWith(".java"));
		File[] dirs = file.listFiles(f -> f.isDirectory());
		if(files == null) return;
		
		for(File f : dirs){
			show(f);
		}
		javaCount += files.length;
		
		for(File f : files){
			BufferedReader br = new BufferedReader(new FileReader(f));
			String len;
			while((len = br.readLine()) != null){
				count++;
				pubCount += (len + ".").split("public").length - 1;
				// if("public".contains(len.toLowerCase())){
					// pubCount++;
				// }
			}
			br.close();
		}
	}
}

class JavaFilter implements FileFilter{
	private JavaFilter(){}
	private static JavaFilter jf = new JavaFilter();
	public static JavaFilter getFilter(){
		return jf;
	}
	
	@Override
	public boolean accept(File f){
		return f.isFile() && f.getName().toLowerCase().endsWith(".java");
	}
}

class DirFilter implements FileFilter{
	private DirFilter(){}
	private static DirFilter df = new DirFilter();
	public static DirFilter getFilter(){
		return df;
	}
	
	@Override
	public boolean accept(File f){
		return f.isDirectory();
	}
}