/**
 * 
 */
package challenge_DictionaryAttack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 */
public class DictionaryAttackChallenge {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Declare and Initialise Variables

		String userInput = "";
		String line = "";
		boolean passwordFound = false;

		// Instantiate Scanner and File

		Scanner myScan = new Scanner(System.in);

		File file = new File("rockyou.txt");

		do {

			passwordFound = false;
			
			// Printable header
			System.out.println("-------------------------------------------\nPassword checker");

			// User prompt
			System.out.println("Enter a password to check for common usage");

			userInput = myScan.nextLine();

			System.out.println("Ok let's check that one ...");
			try {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);

				line = br.readLine();
				while (line != null) {
					if (userInput.equalsIgnoreCase(line)) {
						System.out.println("Weak password! Try another");
						passwordFound = true;
						break;
					} else {
						line = br.readLine();
					}
				}

				br.close();
				fr.close();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} while (passwordFound == true);

		if (passwordFound == false) {
			System.out.println("Password not found.. could be a good one to use  ..");
		}

	}

}
