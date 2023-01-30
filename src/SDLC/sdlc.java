package SDLC;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class sdlc {
   public static void main(String args[]) throws IOException {
	   
      //Grabbing the URL
	   
      URL url = new URL("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm");
      
      //Reading the page
      
      Scanner scnr = new Scanner(url.openStream());
      
      //Start StringBuffer to hold the file
      
      StringBuffer strbuff = new StringBuffer();
      while(scnr.hasNext()) {
         strbuff.append(scnr.next());
      }
      
      //Grabbing the String
      
      String result = strbuff.toString();
      System.out.println(result);
      
      //Removing the HTML tags
      result = result.replaceAll("<.*?>", "");
      result = result.replaceAll("&.*?;" , "");
      
      System.out.println("Contents of the web page: "+result);
      System.out.println("Finally Finished Reading File!");
   }
}
