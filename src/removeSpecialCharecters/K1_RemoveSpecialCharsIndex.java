/** 
 * Step1: Remove Only Special Characters 
 */
package removeSpecialCharecters;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.io.*;

public class K1_RemoveSpecialCharsIndex {
	/**
	 * RemoveSpecialChars->RemoveStopwords->RemoveSinleWordLine->Bigram->Ngram
	 */
	static FileReader FileIn;
	static PrintWriter FileOut;
	
	public static void main(String[] args) throws IOException {
		List<Character>chs=new LinkedList<Character>();
		List<Character>chs_LineBreak=new LinkedList<Character>();
		chs.add(';');
		chs.add(',');
		chs.add('[');
		chs.add(']');
		chs.add('/');
		chs.add('\\');
		chs.add('.');  // Not New line only give blank.. 
		//chs.add('-');
		chs.add(':');
		chs.add('"');
		chs.add('<');
		chs.add('>');
		chs.add('(');
		chs.add(')');
		chs.add('\'');
		chs.add('\"');
		chs.add(' ');
		chs.add('\n');
		chs.add('\0');
		chs.add('+');
		chs.add('|');
		chs.add('@');
		chs.add('?');
		chs.add('!');
		chs.add('#');
		chs.add('=');
		chs.add('%');
		//chs.add('_');
		//chs.add('0');
		//chs.add('1');
		//chs.add('2');
		//chs.add('3');
		//chs.add('4');
		//chs.add('5');
		//chs.add('6');
		//chs.add('7');
		//chs.add('8');
		//chs.add('9');
		//chs.add((char)'\u09EF');
		//System.out.print("tokens"+chs);
		//-------------------------------
		//chs_LineBreak.add('0');
		//chs_LineBreak.add('1');
		//chs_LineBreak.add('2');
		//chs_LineBreak.add('3');
		//chs_LineBreak.add('4');
		//chs_LineBreak.add('5');
		//chs_LineBreak.add('6');
		//chs_LineBreak.add('7');
		//chs_LineBreak.add('8');
		//chs_LineBreak.add('9');
		chs_LineBreak.add('\n');
		chs_LineBreak.add(';');
		chs_LineBreak.add(',');
		chs_LineBreak.add('[');
		chs_LineBreak.add(']');
		chs_LineBreak.add('/');
		chs_LineBreak.add('\\');
		chs_LineBreak.add('.');  // Not New line only give blank.. 
		chs_LineBreak.add('<');
		chs_LineBreak.add('>');
		chs_LineBreak.add('(');
		chs_LineBreak.add(')');
		chs_LineBreak.add('+');
		chs_LineBreak.add('|');
		chs_LineBreak.add('@');
		chs_LineBreak.add('?');
		chs_LineBreak.add('!');
		chs_LineBreak.add('#');
		chs_LineBreak.add('=');
		chs_LineBreak.add('%');
		//----------------------------
		FileIn = new FileReader("D:/a.txt");
		BufferedReader br=new BufferedReader(FileIn);
		FileOut=new PrintWriter(new FileWriter("D:/b.txt"));
		int str;
		while((str=br.read())!=-1){
			if(!chs.contains((char)str)){
			FileOut.print((char)str);
			}
			else{
				if(chs_LineBreak.contains((char)str))
				{
				FileOut.println();
				}
				else{
				FileOut.print(' ');
				}
			}
		} //end while
		FileIn.close();
		FileOut.close();
	}
 }
