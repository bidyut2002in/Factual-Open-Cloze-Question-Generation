	package answerIdentification;

	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.PrintWriter;
	import java.util.*;
import java.util.Map.Entry;

	public class K8_CQ_Generation {
		/**
		 * @param args
		 */
		
		static PrintWriter out;
		static BufferedReader inAnswers;
		static BufferedReader inSentences;
		
		public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
		    for (Entry<T, E> entry : map.entrySet()) {
		        if (Objects.equals(value, entry.getValue())) {
		            return entry.getKey();
		        }
		    }
		    return null;
		}
		
		public static void main(String[] args) throws IOException {
		Map<String, Double>wordValue=new TreeMap<String,Double>();
		Map<String, Integer>IndexWord=new TreeMap<String,Integer>();
		
		inAnswers=new BufferedReader(new FileReader("D:/g1.txt"));
		inSentences=new BufferedReader(new FileReader("D:/g2.txt"));
		out=new PrintWriter(new FileWriter("D:/g3.txt"));
		String lineOfAnswer;
		int val=0;
		while((lineOfAnswer=inAnswers.readLine())!=null){
			if(lineOfAnswer.length()>0){
				StringTokenizer tokenizer=new StringTokenizer(lineOfAnswer,":");
				while(tokenizer.hasMoreTokens())
	    		{
	    		String word=tokenizer.nextToken().trim();
	    		double frq= Double.parseDouble(tokenizer.nextToken());
	    		wordValue.put(word, frq);
	    		IndexWord.put(word, val++);
	    		}
			}
		}
		//System.out.println(wordValue);
		//System.out.println(IndexWord);
		
		int count_Sentence=0;
		int count_Question=0;
		double max=0;
		double maxW1=0.0;
		double maxW2=0.0;
		String maxKeyW1="";
		String maxKeyW2="";
		int index=0;
		String line;
		while((line=inSentences.readLine())!=null){
			if(line.length()>0){
				count_Sentence=count_Sentence+1;
				Iterator<String> it1 = wordValue.keySet().iterator();
				while (it1.hasNext() ) {
					String key = it1.next();
					StringTokenizer token=new StringTokenizer(key," ");
					//System.out.println(token.countTokens());
					double frq = wordValue.get(key);
					//System.out.println(key+" "+frq);
					if(line.matches(".*\\b"+key+"\\b.*")){
						
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
				
							
				if(maxW2>0 && maxW1==0){
					line=line.replace(maxKeyW2, "___");
					out.println("Question: "+line);
					out.println("Hins: No. of Words: "+ max);
					out.println("Answer: "+maxKeyW2+":"+maxW2);
					//out.println(maxKeyW2+".");
					count_Question=count_Question+1;
					//MCQ's Option Generation
					out.println("List of Distractors:");
					//index=IndexWord.get(maxKeyW2);
					//System.out.println(index);
					int dis=3;
					while(dis>0){
						//int randomNo=(Math.round((float)(Math.random()*100))) % wordValue.size();
						//System.out.println(randomNo);
						int sequencialNo=++index % wordValue.size();
						//System.out.println(sequencialNo+"--");
						String distractor=getKeyByValue(IndexWord,sequencialNo);
						//System.out.println(distractor);
						StringTokenizer tt=new StringTokenizer(distractor," ");
						if(tt.countTokens()==max-1 || tt.countTokens()==max && !maxKeyW2.equalsIgnoreCase(distractor)){
							out.println(distractor);
							dis=dis-1;
						}
					}
					out.println();
					
				}
				else if(maxW2==0 && maxW1>0){
					line=line.replace(maxKeyW1, "___");
					out.println("Question: "+line);
					out.println("Hins: No. of Words: 1");
					out.println("Answer: "+maxKeyW1+":"+maxW1);
					//out.println(maxKeyW1+".");
					count_Question=count_Question+1;
					//MCQ's Option Generation
					out.println("List of Distractors:");
					//index=IndexWord.get(maxKeyW1);
					//System.out.println(index);
					int dis=3;
					while(dis>0){
						//int randomNo=(Math.round((float)(Math.random()*100))) % wordValue.size();
						//System.out.println(randomNo);
						int sequencialNo=++index % wordValue.size();
						//System.out.println(sequencialNo+"--");
						String distractor=getKeyByValue(IndexWord,sequencialNo);
						System.out.println(distractor);
						StringTokenizer tt=new StringTokenizer(distractor," ");
						if((tt.countTokens()==1 ||tt.countTokens()==2) && !maxKeyW1.equalsIgnoreCase(distractor))
						{
						out.println(distractor);
						dis=dis-1;
						}
					}
					out.println();
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

