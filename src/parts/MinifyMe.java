package parts;

import java.io.File;
import java.io.IOException;

/**
 * Java file that can used to minify js and css files in lms codebase.
 * Please note to update the basePath and jarPath variables before running the class.
 * 
 * @author vbhandari
 *
 */
public class MinifyMe {

	static int spc_count = -1;
	static String basePath = "C:\\workspace\\min-trunk\\web\\src\\main\\webapp\\";
	static String jarPath = "C:\\yuicompressor-2.3.6.jar";

	/**
	 * Method to read the files/ directories/ sub-directories under
	 * a given directory. This method scans and finds the list of css and js files.
	 * It also excludes the already minified files. 
	 * 
	 * @param aFile
	 */
	static void findFiles(File aFile) {
		spc_count++;
		String spcs = "";
		for (int i = 0; i < spc_count; i++)
			spcs += " ";
		//Check if file is a non-minified css
		if (aFile.isFile() && aFile.getName().endsWith(".css") && !aFile.getName().endsWith("min.css")){			
			try{
				minify(aFile.getAbsolutePath(), " --type css ");
			}catch (Exception e){
				System.out.println("Exception encountered"+e.getMessage());				
			}
		}
		if (aFile.isFile() && aFile.getName().endsWith(".js") && !aFile.getName().endsWith("min.js")){
			//Check if file is a non-minified js
			try{
				minify(aFile.getAbsolutePath(), " --type js ");
			}catch (Exception e){
				System.out.println("Exception encountered"+e.getMessage());				
			}
		}
		else if (aFile.isDirectory()) {			
			File[] listOfFiles = aFile.listFiles();
			if (listOfFiles != null) {
				for (int i = 0; i < listOfFiles.length; i++)
					findFiles(listOfFiles[i]);
			} else {
				System.out.println(spcs + " [ACCESS DENIED]");
			}
		}
		spc_count--;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String scripts = basePath+"scripts-min";
		File scriptsFiles = new File(scripts);
		findFiles(scriptsFiles);
		String epCSS = basePath+"themes\\educatorPortal\\css-min";
		File epCSSFiles = new File(epCSS);
		findFiles(epCSSFiles);
		String lightBlueCSS = basePath+"themes\\light_blue\\css-min";
		File lightBlueCSSFiles = new File(lightBlueCSS);
		findFiles(lightBlueCSSFiles);
		String williamBurgs = basePath+"themes\\williamburgs_blue\\css-min";
		File williamBurgFiles = new File(williamBurgs);
		findFiles(williamBurgFiles);
		
	}
	
	/**
	 * The method that calls the yuicompressor.jar on individual css and js files.
     * @param fileName
     */
    public static void minify(String path, String type ) {  
         try {  
             String command = "java -jar "+jarPath+" --charset utf-8 "+type +
             path +" -o "+ path ;  
             Process process = Runtime.getRuntime().exec(command);  
             System.out.println("Executing command: " + command);  
         } catch (IOException e) {  
             System.err.println(e);  
         }  catch (Exception e) {  
             System.err.println(e);  
         } 
     }

}
