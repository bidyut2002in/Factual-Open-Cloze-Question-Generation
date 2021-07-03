package POS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class POS_2_Pattern_Match {
	/**
	 * @param args
	 */
	
	static PrintWriter out;
	static BufferedReader in;
		
	public static void main(String[] args) throws IOException {
	//Map<String, Double>wordValue=new TreeMap<String,Double>();
	//Input 1: POS
	in=new BufferedReader(new FileReader("D:/POS-3.txt"));
	out=new PrintWriter(new FileWriter("D:/POS-4.txt"));
	String line;
	int count_Sentence=0;
	while((line=in.readLine())!=null){
		if(line.length()>0){
		StringTokenizer tokenizer=new StringTokenizer(line,"/ "); //[/ and One Space]
		//ArrayList<String> s = new ArrayList<String>();
		String word="";
		String pos="";
		String sentence="";
		String sentence_pos="";
		int count_DT=0;
		while(tokenizer.hasMoreTokens())
    	{
    		word=tokenizer.nextToken();
    		pos=tokenizer.nextToken();
    		
    		//System.out.println(word+" "+pos);
    		
    		sentence=sentence+word+" ";
    		sentence_pos=sentence_pos+pos+" ";
    		
    		if (pos.equalsIgnoreCase("DT"))
    		{
    			count_DT=count_DT+1;    			
    		}
    		
    	} // end while
	
	//System.out.println(sentence_pos);
	
	if(sentence_pos.startsWith("NNP VB") ||sentence_pos.startsWith("NNP NNP VB") ||sentence_pos.startsWith("NNP NNP NNP VB") ||
	   sentence_pos.startsWith("NNP VBN")||sentence_pos.startsWith("NNP NNP VBN")||sentence_pos.startsWith("NNP NNP NNP VBN")||
	   sentence_pos.startsWith("NNP VBD")||sentence_pos.startsWith("NNP NNP VBD")||sentence_pos.startsWith("NNP NNP NNP VBD")||
	   sentence_pos.startsWith("NNP VBG")||sentence_pos.startsWith("NNP NNP VBG")||sentence_pos.startsWith("NNP NNP NNP VBG")||
	   sentence_pos.startsWith("NNP VBP")||sentence_pos.startsWith("NNP NNP VBP")||sentence_pos.startsWith("NNP NNP NNP VBP")||
	   sentence_pos.startsWith("NNP VBZ")||sentence_pos.startsWith("NNP NNP VBZ")||sentence_pos.startsWith("NNP NNP NNP VBZ")||
	   sentence_pos.startsWith("NNPS VB") ||sentence_pos.startsWith("NNP NNPS VB") ||sentence_pos.startsWith("NNP NNPS NNP VB")||
	   sentence_pos.startsWith("NNPS VBN")||sentence_pos.startsWith("NNP NNPS VBN")||sentence_pos.startsWith("NNP NNPS NNP VBN")||
	   sentence_pos.startsWith("NNPS VBD")||sentence_pos.startsWith("NNP NNPS VBD")||sentence_pos.startsWith("NNP NNPS NNP VBD")||
	   sentence_pos.startsWith("NNPS VBG")||sentence_pos.startsWith("NNP NNPS VBG")||sentence_pos.startsWith("NNP NNPS NNP VBG")||
	   sentence_pos.startsWith("NNPS VBP")||sentence_pos.startsWith("NNP NNPS VBP")||sentence_pos.startsWith("NNP NNPS NNP VBP")||
	   sentence_pos.startsWith("NNPS VBZ")||sentence_pos.startsWith("NNP NNPS VBZ")||sentence_pos.startsWith("NNP NNPS NNP VBZ"))
	{	
		out.println(sentence);
		count_Sentence=count_Sentence+1;
	}
	
		
else  if ((count_DT==1) && (sentence_pos.contains("DT NNP")||sentence_pos.contains("DT NNP NNP")||sentence_pos.contains("DT NNP NNP NNP")
		||sentence_pos.contains("DT NN NNP")/*||sentence_pos.contains("DT CD")*/||sentence_pos.contains("DT JJ NNP")||sentence_pos.contains("DT JJ NN NNP")
		||sentence_pos.contains("DT JJ NN NN NNP NNP")||sentence_pos.contains("DT NN IN NNP NNP")||sentence_pos.contains("DT JJ NN IN NNP")
		||sentence_pos.contains("DT NN IN NNP")||sentence_pos.contains("DT JJ JJ NN IN NNP")||sentence_pos.contains("DT JJ NN IN NNP")))
	{
		out.println(sentence);
		count_Sentence=count_Sentence+1;		
	} 
	
		
/*	if(count_DT==1) 
	{
		System.out.println(sentence_pos);
		count_Sentence=count_Sentence+1;		
	}
*/				
	}//end if
	}//end while
	
	System.out.println("No. of Sentences is "+count_Sentence);
	
	in.close();
	out.close();
	}
}
