//FBI 
package answerIdentification;
import java.io.*;
import java.util.*;

public class K6_NGram_FBI_1{
	
	static FileReader FIn;
	static FileReader FileIn;
	static FileReader File1In;
	static PrintWriter FileOut;
		
	//static 
	static List<String> uList=new LinkedList<String>();
	static List<String> biList=new LinkedList<String>();
	static List<String> triList=new LinkedList<String>();
	static LinkedHashMap<String,Double> unigram = new LinkedHashMap<String,Double>(); 
    static LinkedHashMap<String,Double> bigram = new LinkedHashMap<String,Double>();
    static LinkedHashMap<String,Double> trigram = new LinkedHashMap<String,Double>();
       
public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
	FIn = new FileReader("D:/f1.txt");
	BufferedReader br1=new BufferedReader(FIn);
	FileIn = new FileReader("D:/f2.txt");
	BufferedReader br2=new BufferedReader(FileIn);
	File1In = new FileReader("D:/f3.txt");
	BufferedReader br3=new BufferedReader(File1In);
	
	FileOut=new PrintWriter(new FileWriter("D:/g1.txt"));
	
	String uLine;	 
	while((uLine=br1.readLine())!=null){
		    	//StringTokenizer tokenizer=new StringTokenizer(line);
		    	uList.add(uLine);
		    	
		    	if(!unigram.containsKey(uLine))
					unigram.put(uLine, new Double(1.0));
				else
				{
					double val=unigram.get(uLine);
					unigram.put(uLine, val+1.0);
				}//end if
	}
	String biLine;	 
	while((biLine=br2.readLine())!=null){
		    	//StringTokenizer tokenizer=new StringTokenizer(line);
		    	biList.add(biLine);
		    	
		    	if(!bigram.containsKey(biLine))
					bigram.put(biLine, new Double(1.0));
				else
				{
					double val=bigram.get(biLine);
					bigram.put(biLine, val+1.0);
				}//end if
	}
	String triLine;	 
	while((triLine=br3.readLine())!=null){
		    	//StringTokenizer tokenizer=new StringTokenizer(line);
		    	triList.add(triLine);
		    	
		    	if(!trigram.containsKey(triLine))
					trigram.put(triLine, new Double(1.0));
				else
				{
					double val=trigram.get(triLine);
					trigram.put(triLine, val+1.0);
				}//end if
	}
	//System.out.println(unigram);
	//System.out.println(bigram);
	//System.out.println(trigram);
	
	/* --------------------------------------------*/
	int c1=0;
    Iterator<String> it1 = unigram.keySet().iterator();
		while (it1.hasNext() ) {
			String key = it1.next();
			double frq = unigram.get(key);
/**********************Frequency**********************/
			if(frq>1){
			FileOut.println(key + " : " + frq);
			c1=c1+1;
			}
			} // end while
			
    /* --------------------------------------------*/
	int c2=0;
	Iterator<String> it2 = bigram.keySet().iterator();
 	while (it2.hasNext() ) {
 		String key = it2.next();
 		double frq = bigram.get(key);
/**********************Frequency**********************/
 		if(frq>1){
			FileOut.println(key + " : " + frq);
			c2=c2+1;
			}
			} // end while
 	 /* --------------------------------------------*/
 		int c3=0;
 		Iterator<String> it3 = trigram.keySet().iterator();
 	 	while (it3.hasNext() ) {
 	 		String key = it3.next();
 	 		double frq = trigram.get(key);
/**********************Frequency**********************/
 	 		if(frq>1){
 				FileOut.println(key + " : " + frq);
 				c3=c3+1;
 				}
 				} // end while
	System.out.println(" Unigram : "+c1+" Bigram : "+c2+" Trigram : "+c3);		
    System.out.println(" Done!");
	FileOut.close();
	}
}