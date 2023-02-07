package SDLC;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;


public class sdlc {
   
	private static void GetWords(String URL, Map< String, Integer> words) throws IOException {
		
      //Grabbing the URL
	   
      URL url = new URL("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm");
      
      //Reading the page and counting words
      
      Scanner scnr = new Scanner(url.openStream());
      while(scnr.hasNext()){
    	  String word=scnr.next().trim();
    	  Integer count=words.get(word);
    	  if(count!=null)
    	  count++;
    	  else
    	  count=1;
    	  words.put(word,count);
    	}
    	  scnr.close();
    	}
	

	public static void main(String[] args)
    	  {
		
		// Create Pairs and Print them to the console
		
    	  Map<String,Integer> words = new HashMap<String, Integer>();
    	  try {
			GetWords(null, words);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	  words.entrySet().forEach(System.out::println);
    	  
      
   }
	    
    	  
}
		

