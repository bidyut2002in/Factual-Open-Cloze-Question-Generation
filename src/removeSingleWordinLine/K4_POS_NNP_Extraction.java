package removeSingleWordinLine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class K4_POS_NNP_Extraction {
	/**
	 * @param args
	 */
	
	static PrintWriter out;
	static BufferedReader in;
		
	public static void main(String[] args) throws IOException {
	//Map<String, Double>wordValue=new TreeMap<String,Double>();
	//Input 1: Frequency or Membership of words or n-grams 
	in=new BufferedReader(new FileReader("D:/c2.txt"));
	out=new PrintWriter(new FileWriter("D:/d.txt"));
	String line;
	int count_Sentence=0;
	while((line=in.readLine())!=null){
		if(line.length()>0){
			count_Sentence=count_Sentence+1;
			StringTokenizer tokenizer=new StringTokenizer(line,"' '"); //One space is introduced after string;
			String word="";
			int flag=0;
			while(tokenizer.hasMoreTokens())
    		{
    		word=tokenizer.nextToken();
    		if(word.endsWith("/NNP")||word.endsWith("/NNPS")) //||word.endsWith("/NN")||word.endsWith("/NNS")
    		{
    			String[] output = word.split("/");
    			out.print(output[0]+" ");
    			flag++;
    		}
    		else
    		{
    			flag=0;
    			out.println();
    		}
    		    		
    		//if(flag==0){
    			//System.out.println();
    		//}
    		
    		/*sentence=sentence+word+" ";
    		if(pos.equalsIgnoreCase("CD")){
    			count_CD=count_CD+1;
    		}
    		if(pos.equalsIgnoreCase("VB")||pos.equalsIgnoreCase("VBD")||pos.equalsIgnoreCase("VBZ")||pos.equalsIgnoreCase("VBG")||pos.equalsIgnoreCase("VBN")||pos.equalsIgnoreCase("VBP")){
    			count_verb=count_verb+1;
    		}
    		if(pos.equalsIgnoreCase("NNP")||pos.equalsIgnoreCase("NNPS")){
    			count_NNP=count_NNP+1;
    		}*/
    		} // end while
			if(flag>0){
			out.println();
			}
			flag=0;
			//System.out.println("NNP="+count);
			/*if(count_NNP>=5  /* && count_verb==1*//*){
			out.println(sentence+".");
			count_Sentence=count_Sentence+1;
			}*/
		}//end if
		
	}//end while
	System.out.println("No. of Sentences is "+count_Sentence);
	in.close();
	out.close();
	}
}
