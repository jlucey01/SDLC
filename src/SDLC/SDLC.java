
package SDLC;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

import java.util.Map;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import static java.util.stream.Collectors.*;



/**
 * @author <p>John Lucey</p>
 *
 * <H2>SDLC Application</H2> 
 * 
 * <p>Class to create a Graphical
 * user window. Using scanner to import a document from a URL.
 * </p> 
 *
 */

public class SDLC extends Application {
		


	
	/**
	 * @param URL Static address to capture the online document
	 * @param words Capture and count words
	 * @throws IOException Presents an error if online URL not available
	 */
	
	public static void GetWords(String URL, Map<String, Integer> words) throws IOException { 


		// Grabbing the URL

		URL url = new URL("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm");

		// Reading the page and counting words

		Scanner scnr = new Scanner(url.openStream());
		while (scnr.hasNext()) {

			String word = scnr.next().toLowerCase().trim().replaceAll("<[^>]*>", "");

			Integer count = words.get(word);
			if (count != null)
				count++;
			else
				count = 1;
			words.put(word, count);
		}
		scnr.close();
	}

/**
 * @param args Launch
 */
	public static void main(String[] args) { 

		launch(args);

	
	}

	

	@Override
	

/** 
 *
 * Start
 *
 * @param primaryStage  the primary stage for modal window. 
 * @throws   Exception 
 */
	public void start(Stage primaryStage) throws Exception { 


		VBox layout = new VBox();
		Scene scene = new Scene(layout, 300, 300);

		Button btn = new Button();
		btn.setText("Count Words");
		TextArea text = new TextArea();
		text.setMaxWidth(300);
		layout.getChildren().addAll(text, btn);

		btn.setOnAction(new EventHandler<ActionEvent>() {

			
			
			@Override

/** 
 *
 * Handle
 *
 * @param event  the event. 
 */
			public void handle(ActionEvent event) { 

				/*
				 * System.out.println(text.setText("/Users/johnlucey/Documents/Test/test.txt"));
				 */
				runmap();

				try {
					Scanner s = new Scanner(new File("/Users/johnlucey/Documents/Test/test.txt")).useDelimiter("\\s+");
					while (s.hasNext()) {
						if (s.hasNextInt()) { // check if next token is an int
							text.appendText(s.nextInt() + " \n"); // display the found integer
						} else {
							text.appendText(s.next() + " "); // else read the next token
						}
					}
				} catch (FileNotFoundException ex) {
					System.err.println(ex);
				}

			}
		});

		primaryStage.setTitle("JavaFX App");
		primaryStage.setScene(scene);
		primaryStage.show();

		primaryStage.show();
	}

	// Create pairs and send them to the console

	

/** 
 *
 * Runmap
 *
 */
	private static void runmap() { 

		Map<String, Integer> words = new HashMap<String, Integer>();
		try {
			GetWords(null, words);
		} catch (IOException e) {
			e.printStackTrace();
		}

		/* words.entrySet().forEach(System.out::println); */

		Map<String, Integer> sorted = words.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(20)
				.collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));

		sorted.entrySet().forEach(System.out::println);

		FileOutputStream f = null;
		try {
			f = new FileOutputStream("/Users/johnlucey/Documents/Test/test.txt");
		} catch (FileNotFoundException e3) {

			e3.printStackTrace();
		}

		System.setOut(new PrintStream(f));

		// Send text to a file
		sorted.forEach((key, value) -> System.out.println("Word : " + key + "\t\t\t Count : " + value));

	

}
}
