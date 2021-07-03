package POS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class POS_1_Preprocessing_RemoveRB{
	/**
	 * @param args
	 */
	
	static PrintWriter out;
	static BufferedReader in;
		
	public static void main(String[] args) throws IOException {
	//Map<String, Double>wordValue=new TreeMap<String,Double>();
	//Input 1: POS
	in=new BufferedReader(new FileReader("D:/POS-1.txt"));
	out=new PrintWriter(new FileWriter("D:/POS-2.txt"));
	String line;
	int count_Sentence=0;
	while((line=in.readLine())!=null){
		if(line.length()>0){
		StringTokenizer tokenizer=new StringTokenizer(line,"/ "); //[/ and One Space]
		//ArrayList<String> s = new ArrayList<String>();
		String word="";
		String pos="";
		String sentence="";
		int count_RB=0;
		int count_NNP=0;
		int count_word=0;
		int flag=0;
		while(tokenizer.hasMoreTokens())
    	{
    		word=tokenizer.nextToken();
    		pos=tokenizer.nextToken();
    		
    		System.out.println(word+" "+pos);
    		
    		count_word=count_word+1;
    		
    		sentence=sentence+word+" ";
    		
    		if(pos.equalsIgnoreCase("RB")||pos.equalsIgnoreCase("RBR")||pos.equalsIgnoreCase("RBS")||pos.equalsIgnoreCase("WRB")){ //Count RB in Sentence
    			count_RB=count_RB+1;
    		}
    		//if(pos.equalsIgnoreCase("VB")||pos.equalsIgnoreCase("VBD")||pos.equalsIgnoreCase("VBZ")||pos.equalsIgnoreCase("VBG")||pos.equalsIgnoreCase("VBN")||pos.equalsIgnoreCase("VBP")){
    			//count_verb=count_verb+1;
    		//}
    		if(pos.equalsIgnoreCase("NNP")||pos.equalsIgnoreCase("NNPS"))
    			//Count Disjoint NN	
    			{
    			flag=1;
    			continue;
    			}
    			else
    			{
    			if(flag==1){
    				count_NNP=count_NNP+1;
        			flag=0;
        			}
    			}
    	} // end while
	//System.out.println("NNP="+count);
	if(count_NNP>=2 && count_RB==0  && count_word>=10 && count_word<=25){
		out.println(sentence+".");
		count_Sentence=count_Sentence+1;
	}
	}//end if
	}//end while
	System.out.println("No. of Sentences is "+count_Sentence);
	in.close();
	out.close();
	}
}
