package weibo4j.examples.MyCrawler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOp {
	
	private String fname;
	
	public void SetFname(String f){
		this.fname = f;
	}
	
	
    public void ReadByLine(){
    	try{
    		StringBuffer sb = new StringBuffer("");
    		
    		FileReader reader = new FileReader(fname);
    		BufferedReader br = new BufferedReader(reader);
    		
    		
    		String str = null;
    		
    		while((str = br.readLine())!= null){
    			sb.append(str + "/n");
    			
    			System.out.println(str);
    		}
    		br.close();
    		reader.close();
    		System.out.println("Reading Successed!");
    	}
    	catch(FileNotFoundException e){
    		e.printStackTrace();
    	}
    	catch(IOException e){
    		e.printStackTrace();
    	}
    }

    
    
    public void WriteByLine(String str){
    	try{
    		FileWriter writer = new FileWriter(fname, true);
    		BufferedWriter bw = new BufferedWriter(writer);
    		//StringBuffer sb = new StringBuffer(str);
    		
    		bw.write(str);
    		bw.newLine();
    		bw.flush();
    	}
    	catch(FileNotFoundException e){
    		e.printStackTrace();
    	}
    	catch(IOException e){
    		e.printStackTrace();
    	}
    }
    	
   
	
	
	
	
	
	

}
