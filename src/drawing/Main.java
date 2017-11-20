package drawing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Startup class
 * 
 * @author paude
 *
 */
public class Main {

	public static void main(String... args) throws IOException {
		Operations operations = new Operations();

		boolean quitted = false;
		do {
			System.out.print("Enter command: ");
			String inputValue = new BufferedReader(new InputStreamReader(System.in)).readLine();
			String[] splitted = inputValue.split(" ");
			if (splitted[0].equals("Q")) {
				// Quitting

				quitted = true;
			} else if (splitted[0].equals("C")) {
				// Create a canvas
				int width = Integer.parseInt(splitted[1]);
				int height = Integer.parseInt(splitted[2]);
				operations.create(width + 2, height + 2);

			} else if (splitted[0].equals("L")) {
				// Line
				int x1 = Integer.parseInt(splitted[1]);
				int y1 = Integer.parseInt(splitted[2]);
				int x2 = Integer.parseInt(splitted[3]);
				int y2 = Integer.parseInt(splitted[4]);
				operations.line(x1, y1, x2, y2);
			} else if (splitted[0].equals("R")) {
				// Rectangle
				int x1 = Integer.parseInt(splitted[1]);
				int y1 = Integer.parseInt(splitted[2]);
				int x2 = Integer.parseInt(splitted[3]);
				int y2 = Integer.parseInt(splitted[4]);
				operations.rect(x1, y1, x2, y2);

			} else if (splitted[0].equals("B")) {
				// Bucket
				int x = Integer.parseInt(splitted[1]);
				int y = Integer.parseInt(splitted[2]);
				char c = splitted[3].charAt(0);
				operations.fill(x, y, c);

			} else {
				System.out.println("Invalid Input!");
			}
		} while (!quitted);

		System.out.println("Thank You!");
		System.exit(0);
	}
}
