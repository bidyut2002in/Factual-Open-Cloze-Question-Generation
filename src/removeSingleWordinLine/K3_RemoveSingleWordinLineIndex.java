package removeSingleWordinLine;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class K3_RemoveSingleWordinLineIndex {

		/**
		 * RemoveSpecialChars->RemoveStopwords->RemoveSinleWordLine->Bigram->Ngram
		 */
	   static FileReader FileIn;
	   static PrintWriter FileOut;
	   
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
			FileIn = new FileReader("D:/c.txt");
			BufferedReader reader=new BufferedReader(FileIn);
			FileOut=new PrintWriter(new FileWriter("D:/c1.txt"));
			
	        
	    	String str;
		        while((str=reader.readLine())!=null){ 
		        	 //System.out.println(str);
					 StringTokenizer t = new StringTokenizer(str);
					 int countTokens = t.countTokens();
						//System.out.println(countTokens);
						//while(tokenizer.hasMoreTokens())
						  //{
							//String str=tokenizer.nextToken();
					 		
 /************************** For Single word Remove >1 ********************************/
						    	if(countTokens>=1){		
						    	//System.out.println(str);
						    	   //FileOut.println(str.toLowerCase());
						    	  FileOut.println(str.toLowerCase()+"."); 
						    	}
					  
		        }
		        FileIn.close();
				FileOut.close();

		} 
}

		