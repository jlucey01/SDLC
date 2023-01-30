package SDLC;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
public class sdlc {
   public static void main(String args[]) throws IOException {
      //Instantiating the URL class
      URL url = new URL("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm");
      //Retrieving the contents of the specified page
      Scanner sc = new Scanner(url.openStream());
      //Instantiating the StringBuffer class to hold the result
      StringBuffer sb = new StringBuffer();
      while(sc.hasNext()) {
         sb.append(sc.next());
         //System.out.println(sc.next());
      }
      //Retrieving the String from the String Buffer object
      String result = sb.toString();
      System.out.println(result);
      //Removing the HTML tags
      result = result.replaceAll("<[^>]*>", "");
      System.out.println("Contents of the web page: "+result);
      System.out.println("Done!");
   }
}
