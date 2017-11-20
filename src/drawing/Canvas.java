package drawing;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class represents canvas and its related operations
 * 
 * @author paude
 *
 */
public class Canvas {
	private static final Logger LOGGER = Logger.getLogger(Canvas.class.getName());
	static {
		LOGGER.addHandler(new ConsoleHandler());
	}

	// canvas modal(array of characters)
	private char[][] canvas;

	/**
	 * Constructor
	 */
	public Canvas() {
		System.out.println("Initialising...");
	}

	/**
	 * Create a canvas with speficied height and width
	 * 
	 * @param width
	 *            Width of canvas
	 * @param height
	 *            Height of canvas
	 */
	public void create(int width, int height) {
		this.canvas = new char[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (i == 0 || i == height - 1)
					this.canvas[i][j] = '-';
				else if (j == 0 || j == width - 1) {
					this.canvas[i][j] = '|';
				} else {
					this.canvas[i][j] = ' ';
				}
			}
		}
	}

	/**
	 * Create a line from (x1,y1) to (x2,y2)
	 * 
	 * @param x1
	 *            X-coordinate of initial point
	 * @param y1
	 *            Y-coordinate of initial point
	 * @param x2
	 *            X-coordinate of final point
	 * @param y2
	 *            Y-coordinate of final point
	 */
	public void createLine(int x1, int y1, int x2, int y2) {
		if (x1 == x2) {
			// Vertical Line
			LOGGER.log(Level.INFO, "Creating Vertical Line");

			int start = y1;
			int end = y2;
			if (y2 < y1) {
				start = y2;
				end = y1;
			}
			for (int i = start; i <= end; i++) {
				this.canvas[i][x1] = 'x';
			}
		}

		if (y1 == y2) {
			// Horizontal Line
			LOGGER.log(Level.INFO, "Creating Horizontal Line");
			int start = x1;
			int end = x2;
			if (x2 < x1) {
				start = x2;
				end = x1;
			}
			for (int i = start; i <= end; i++) {
				this.canvas[y1][i] = 'x';
			}
		}

	}

	/**
	 * Create a rectangle with top left(x1,y1) and bottom right(x2,y2)
	 * 
	 * @param x1
	 *            top left x
	 * @param y1
	 *            top left y
	 * @param x2
	 *            bottom right x
	 * @param y2
	 *            bottom right y
	 */
	public void createRectangle(int x1, int y1, int x2, int y2) {
		// Drawing rectangle is just creating for boundary lines
		this.createLine(x1, y1, x2, y1);
		this.createLine(x2, y1, x2, y2);
		this.createLine(x2, y2, x1, y2);
		this.createLine(x1, y2, x1, y1);
	}

	/**
	 * Carries out bucket fill with color c
	 * 
	 * @param x
	 *            X Co-ordinate
	 * @param y
	 *            Y Co-ordinate
	 * @param c
	 *            Color
	 */
	public void bucketFill(int x, int y, char c) {
		char elem = this.canvas[x][y];
		if (elem == '|' || elem == '-' || elem == 'x' || elem == c) {
			return;
		}
		this.canvas[x][y] = c;

		this.bucketFill(x + 1, y, c);
		this.bucketFill(x, y + 1, c);
		this.bucketFill(x - 1, y, c);
		this.bucketFill(x, y - 1, c);
		
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (char[] row : this.canvas) {
			for (char elem : row) {
				stringBuilder.append(elem);
			}
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}

}
