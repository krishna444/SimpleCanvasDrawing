package drawing.commands;

import drawing.Canvas;

/**
 * Bucket fill command
 * @author krishna
 *
 */
public class BucketFillCommand implements ICommand {
	private Canvas canvas;
	private int x;
	private int y;
	private char c;

	public BucketFillCommand(Canvas canvas, int x, int y, char c) {
		this.canvas = canvas;
		this.x = x;
		this.y = y;
		this.c = c;
	}

	@Override
	public void execute() {
		this.canvas.bucketFill(this.x, this.y, this.c);
		System.out.println(this.canvas);
	}

}
