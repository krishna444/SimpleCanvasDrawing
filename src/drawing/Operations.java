package drawing;

import drawing.commands.BucketFillCommand;
import drawing.commands.CreateCommand;
import drawing.commands.ICommand;
import drawing.commands.LineCommand;
import drawing.commands.RectanglecCommand;

/**
 * Carries out operations on canvas
 * @author paude
 *
 */
public class Operations {
	private ICommand command;
	private Canvas canvas;
	
	public Operations() {
		this.canvas=new Canvas();
	}
	
	public void create(int width,int height){
		this.command=new CreateCommand(this.canvas, width, height);
		this.command.execute();		
	}
	
	public void line(int x1, int y1, int x2, int y2){
		this.command=new LineCommand(canvas, x1, y1, x2, y2);
		this.command.execute();		
	}
	
	public void rect(int x1, int y1, int x2, int y2){
		this.command=new RectanglecCommand(this.canvas, x1, y1, x2, y2);
		this.command.execute();
	}
	
	public void fill(int x, int y, char c){
		this.command=new BucketFillCommand(this.canvas, x, y, c);
		this.command.execute();
		
	}
}
