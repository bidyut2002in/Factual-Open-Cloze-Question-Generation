//FBI 
package answerIdentification;
import java.io.*;
import java.util.*;

public class K5_NGram_FBI_0{
	
	static FileReader FileIn;
	static PrintWriter FOut;
	static PrintWriter FileOut;
	static PrintWriter File1Out;
	
public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
	FileIn = new FileReader("D:/d.txt");	//POS-4-NNPExtraction
	BufferedReader br=new BufferedReader(FileIn);
	FOut=new PrintWriter(new FileWriter("D:/f1.txt"));
	FileOut=new PrintWriter(new FileWriter("D:/f2.txt"));
	File1Out=new PrintWriter(new FileWriter("D:/f3.txt"));
	
    String line;
   
		    while((line=br.readLine())!=null){
		    	StringTokenizer tokenizer=new StringTokenizer(line);
		    	List<String> list=new LinkedList<String>();
		    	while(tokenizer.hasMoreTokens())
		    	{
		    		String str=tokenizer.nextToken();
		    		list.add(str);
		    		FOut.println(str);
		    	} // end while
		    	
		    	if(list.size()>1)
		    	{
		    	for(int x=0,y=1;y<list.size();x++,y++)
		    	  {
		    		String wordPair=list.get(x)+" "+list.get(y);
		    		FileOut.println(wordPair);
		    	}  // end for
		    	} // end if
		    	
		    	if(list.size()>1)
		    	{
		    	for(int x=0,y=1,z=2;z<list.size();x++,y++,z++)
		    	  {
		    		String triPair=list.get(x)+" "+list.get(y)+" "+list.get(z);
		    		File1Out.println(triPair);
		    	}  // end for
		    	} // end if
		    } //end while
  
		    FileIn.close();
		    FOut.close();
		    File1Out.close();
		    FileOut.close();
		}
	}