	package answerIdentification;

	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.PrintWriter;
	import java.util.*;

	public class K7_OCQ_Generation {
		/**
		 * @param args
		 */
		
		static PrintWriter out;
		static BufferedReader inAnswers;
		static BufferedReader inSentences;
			
		public static void main(String[] args) throws IOException {
		Map<String, Double>wordValue=new TreeMap<String,Double>();
		
		inAnswers=new BufferedReader(new FileReader("D:/g1.txt"));
		inSentences=new BufferedReader(new FileReader("D:/g2.txt"));
		out=new PrintWriter(new FileWriter("D:/g3.txt"));
		String lineOfAnswer;
		while((lineOfAnswer=inAnswers.readLine())!=null){
			if(lineOfAnswer.length()>0){
				StringTokenizer tokenizer=new StringTokenizer(lineOfAnswer,":");
				while(tokenizer.hasMoreTokens())
	    		{
	    		String word=tokenizer.nextToken().toLowerCase().trim();
	    		double frq= Double.parseDouble(tokenizer.nextToken());
	    		//System.out.println(word + " "+frq);
	    		wordValue.put(word, frq);
	    		}
			}
		}
		//System.out.println(wordValue);
	    		    		
		int count_Sentence=0;
		int count_Question=0;
		double max=0;
		double maxW1=0.0;
		double maxW2=0.0;
		String maxKeyW1="";
		String maxKeyW2="";
		int z=0;
		String line;
		while((line=inSentences.readLine())!=null){
			if(line.length()>0){
				count_Sentence=count_Sentence+1;
				//System.out.print(count_Sentence+". ");
				Iterator<String> it1 = wordValue.keySet().iterator();
				while (it1.hasNext() ) {
					String key = it1.next();
					StringTokenizer token=new StringTokenizer(key," ");
					//System.out.println(token.countTokens());
					double frq = wordValue.get(key);
					//System.out.println(key+" "+frq);
					if(line.toLowerCase().matches(".*\\b"+key+"\\b.*")){
						//System.out.println(key);
						if(token.countTokens()>1){
							//if(maxW2<frq){maxW2=frq;maxKeyW2=key;}
							if(max<token.countTokens()){max=token.countTokens();maxW2=frq;maxKeyW2=key;}
						}
						else if(token.countTokens()==1){
							if(maxW1<frq){maxW1=frq;maxKeyW1=key;}
						}
						
						//line=line.toLowerCase().replace(key, "___");
						//System.out.println(line);
						//System.out.println(key+" "+frq);
						}//end if
				    }//end while
				//System.out.println(max);
				if(max>0){
					line=line.toLowerCase().replace(maxKeyW2, "___");
					out.println("Question: "+line);
					out.println("Hins: No. of Words: "+ max);
					out.println("Answer: "+maxKeyW2+":"+maxW2);
					//out.println(maxKeyW2+".");
					count_Question=count_Question+1;
				}
				else {
					line=line.toLowerCase().replace(maxKeyW1, "___");
					out.println("Question: "+line);
					out.println("Hins: No. of Words: 1");
					out.println("Answer: "+maxKeyW1+":"+maxW1);
					//out.println(maxKeyW1+".");	
					count_Question=count_Question+1;
				} 
				
				//System.out.println(line);
				//System.out.println(maxW2+" "+maxKeyW2);
				//System.out.println(maxW1+" "+maxKeyW1);
				max=0.0; maxW1=0.0; maxW2=0.0; maxKeyW1=""; maxKeyW2="";
		 }//endif 	
		}//end while
		System.out.println("Total Sentence is "+count_Sentence);
		System.out.println("No. of Questions is "+count_Question);
		inAnswers.close();
		inSentences.close();
		out.close();
		}
	}

