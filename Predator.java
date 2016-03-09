import java.awt.*;

public class Predator extends Creature 
{
	
	public int xPosition;
	public int yPosition;
	public int directionY;
	public int directionX;
	public int speed;
	public int radius = 50;
	public int angle;
	public int directionFace = 0; // which way the mouth should be facing
	public boolean isPredator;
	private int signal;

	/**
	 * Instantiates a new pacman.
	 *
	 * @param int, xPosition, the x position
	 * @param int, yPosition, the y position
	 * @param int, speed, the speed
	 */
	public Predator(int xPosition, int yPosition, int speed) 
	{
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.speed = speed;
		isPredator = true;
		signal = 0;
		this.setDir(this.getSpeed(), 0);
	}
	
	
	/**
	 * Changes the direction of the predator to face left
	 */
	public void left() 
	{
		signal += 1;
		signalToDirection();
		directionFace += 90;
	}
	
	/**
	 * Changes the direction of the predator to face right
	 */
	public void right()
	{
		signal -= 1;
		signalToDirection();
		directionFace -= 90;
	}

	
	/**
	 * Sets the direction for the pacman to move towards.
	 */
	public void signalToDirection() 
	{
		if (signal == -4 || signal == 4) {
			signal = 0;
		}
		if (signal == 0) this.setDir(this.getSpeed(), 0); 
		if (signal == 1) this.setDir(0, -this.getSpeed());
		if (signal == 2) this.setDir(-this.getSpeed(), 0);
		if (signal == 3) this.setDir(0, this.getSpeed()); 
		
		if (signal == -1) this.setDir(0, this.getSpeed());
		if (signal == -2) this.setDir(-this.getSpeed(), 0);
		if (signal == -3) this.setDir(0, -this.getSpeed()); 
	}
	
	
	/**
	 * Sets the reverse direction for the pacman.
	 */
	public void reverseSignal()
	{
		if (signal == -2 || signal ==2) {
			signal = 0;//reverse left
			directionFace = 0;
		} else if (signal == 0) {
			signal = 2; // reverse right
			directionFace = 180;
		} else if (signal ==  1 || signal == -3) {
			signal = -1; //reverse up
			directionFace=270;
		} else if (signal  == -1 || signal == 3) {
			signal =1; // reverse down
			directionFace = 90;
		}
	}
	
	/**
	 * Gets the speed.
	 *
	 * @return int, speed
	 */
	public int getSpeed() 
	{
		return speed;
	}
	
	/**
	 * Gets the x Position
	 * 
	 * @return int, xPosition
	 */
	public int getX() 
	{
		return xPosition;
	}
	
	/**
	 * Gets the y Position
	 * 
	 * @return int, yPosition
	 */
	public int getY() 
	{
		return yPosition;
	}
	
	/**
	 * Gets the x Direction
	 * 
	 * @return int, directionX, Which way the pac man is moving in the x direction
	 */
	public int getXDir() 
	{
		return directionX;
	}
	
	/**
	 * Gets the y Direction
	 * 
	 * @return int, directionY, Which way the pac man is moving in the y direction
	 */
	public int getYDir() {
		return directionY;
	}
	
	/**
	 * Sets the current direction 
	 *
	 * @param int, directionX, the direction x
	 * @param int, directionY, the direction y
	 */
	public void setDir(int directionX, int directionY) {
		this.directionX = directionX;
		this.directionY = directionY;
	}
	
	/**
	 * Move the pacman
	 */
	public void move() {
		xPosition+= directionX;
		yPosition+= directionY;
		
	}
	
	
	/**
	 * Checks to see if the creatures collided
	 * 
	 * @param MoveableShape, other, determines if colliding with other
	 * @return boolean, true if it collides, else false
	 */
	public boolean collide(MoveableShape other) {
		return false;
	}

	/**
	 * Draw pacman shapes.
	 *
	 * @param Graphics2D, g2, The graphics required to draw
	 */
	public void draw(Graphics2D g2) {

		// Body
		angle = (int) (20 * (Math.sin((xPosition + yPosition)*2*Math.PI/50) + 1)); 
		g2.setColor(Color.YELLOW);
		g2.fillArc(xPosition, yPosition, radius, radius, angle/2 + directionFace, 360-angle);
		
		// Eyes
		g2.setColor(Color.BLACK);
		g2.fillOval(xPosition + radius / 4 ,yPosition + radius / 4 , radius / 5, radius / 5); // drawing eye;
		g2.setColor(Color.WHITE);
		g2.fillOval((xPosition+7) + radius / 8 ,(yPosition+8) + radius / 8 , radius / 10, radius / 10);
	}
}
