import javax.swing.*;
import java.awt.*;

public class Frame{
	
	JFrame fframe;
	GamePanel gPanel;
	public static final int FRAME_WIDTH = 600;
	public static final int FRAME_HEIGHT = 600;
	
	/**
	 * Instantiates a new frame.
	 */
	public Frame() {
		
		gPanel = new GamePanel();
		fframe = new JFrame("PacMan");
		fframe.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		fframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		fframe.setResizable(false);
		fframe.setLocationRelativeTo(null);
		fframe.setBackground(Color.BLACK);
		
		fframe.add(gPanel);
		fframe.setVisible(true);		
	}
	
	/**
	 * The main method.
	 * Calls the frame constructor
	 */
	public static void main(String[] args) {
		Frame frame = new Frame();
	}
}
