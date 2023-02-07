package SDLC;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class sdlc {
   
	private static void GetWords(String URL, Map< String, Integer> words) throws IOException {
		
      //Grabbing the URL
	   
      URL url = new URL("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm");
      
      //Reading the page
      
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
		
		
    	  Map<String,Integer> words = new HashMap<String, Integer>();
    	  try {
			GetWords(null, words);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	  words.entrySet().forEach(System.out::println);
    	  
    	  
    	  
    	  /*System.out.println(words);
    	  /*System.out.println("\r\n");
      
      
      
      //Start StringBuffer to hold the file
      
      /*StringBuffer strbuff = new StringBuffer();
      while(scnr.hasNext()) {
         strbuff.append(scnr.next());
      }
      
      //Grabbing the String
      
      String result = strbuff.toString();
      System.out.println(result);
      
      //Removing the HTML tags
      
      result = result.replaceAll("\\<[\s]*tag[^>]*>"," ");
      result = result.replaceAll("&.*?;" , " ");
      
      System.out.println("Contents of the web page: " + result);
      System.out.println("Finally Finished Reading File!");*/
      
      
   }
	    
    	  
}
		

