package weibo4j.examples.WeiboCrawler;

import java.io.File;

public class FilePathTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          System.out.println(FilePathTest.class.getResource(""));
          System.out.println(FilePathTest.class.getResource("/"));
           System.out.println(new File("").getAbsolutePath());
		   System.out.println(System.getProperty("user.dir"));
		   System.out.println(System.getProperty("file.separator"));
	}

}
