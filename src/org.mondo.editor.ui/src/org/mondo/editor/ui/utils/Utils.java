package org.mondo.editor.ui.utils;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Miscellaneous class of utility functions
 * 
 * @author miso partner AnaPescador
 *
 */
public final class Utils {

	
	/**
	 * Static method that copy a directory or file into the given destiny
	 * @param source - directory
	 * @param dest - destiny
	 * @throws IOException
	 */
	public static void copy(String source, String dest) throws IOException {	
		Path from = Paths.get(source);
		Path to = Paths.get(dest);
        if (Files.isDirectory(from, LinkOption.NOFOLLOW_LINKS)){      	
            CopyDirVisitor cdv = new CopyDirVisitor();
            cdv.fromPath = from;
            cdv.toPath = to;
            Files.walkFileTree(from, cdv);
        } else {
            CopyOption[] options = new CopyOption[]{
              StandardCopyOption.REPLACE_EXISTING,
              StandardCopyOption.COPY_ATTRIBUTES
            }; 
            Files.copy(from, to, options);
        }
		
    }
	
	/**
	 * Class that implements a SimpleFileVisitor that copy the file structure (attribute fromPath) into 
	 * another path (attribute toPath)
	 * @author miso partner AnaPescador
	 *
	 */
	public static class CopyDirVisitor extends SimpleFileVisitor<Path>{
	    private Path fromPath;
	    private Path toPath;
	    private StandardCopyOption copyOption = StandardCopyOption.REPLACE_EXISTING;
	    @Override
	    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
	        Path targetPath = toPath.resolve(fromPath.relativize(dir));
	        if(!Files.exists(targetPath)){
	            Files.createDirectory(targetPath);
	        }
	        return FileVisitResult.CONTINUE;
	    }

	    @Override
	    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
	        Files.copy(file, toPath.resolve(fromPath.relativize(file)), copyOption);
	        return FileVisitResult.CONTINUE;
	    }
	}
	
	/**
	 * Static method that returns the name of the operation system
	 * @return the name of the OS
	 */
	public static String getOsName(){
	      String OS = null;
		  if(OS == null) { OS = System.getProperty("os.name"); }
	      return OS;
	}
	/**
	 * Static method that returns if the OS is windows.
	 * @return true if is windows, false if not
	 */
	public static boolean isWindows(){
	      return getOsName().startsWith("Windows");
	}

}
