import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/** 
 * This class is the Fish class of the game, and it creates the fish images, controls the movement of the fish and the different positions of the fish 
 * @author julia anantchenko
 * @author victoria li
 * @version %I% %G%
 */
public class Fish extends JLabel { // Fish class for the game 
	/** 
	 * Represents the constants of boolean if it is a bomb or if it comes from the left side 
	 */
	public final boolean IS_BOMB, FROM_LEFT; // final variables for bomb or not, and for left side or not 
	/** 
	 * Represents the constants of the imageicon for the picture 
	 */
	private final ImageIcon PIC; // final imageicon picture 
	/** 
	 * Creates a random variable 
	 */
	private Random r;
	/** 
	 * Creates an angle 
	 */
	private int angle;
	/** 
	 * Represents constants for the width and height of the screen 
	 */
	private final double SCREENX, SCREENY; 
	/** 
	 * Creates doubles for the formula 
	 */
	private double eCX, eCY, x, y, k, h;

	/**
	 * initializes the screen size, the starting and ending location of the cats, the bomb and fish images and a random angle 
	 * @param screenx the width of the screen 
	 * @param screeny the height of the screen 
	 * @param startCatX the starting x coordinate of the left cat 
	 * @param endCatX the ending x coordinate of the right cat
	 * @param endCatY the y coordinate of the cats (same for both)
	 * @param bomb checks if it is a bomb
	 * @param fromL checks if it comes from the left side 
	 */
	public Fish (double screenx, double screeny, int startCatX, int endCatX, int endCatY, boolean bomb, boolean fromL) { // constructor, gets screen width and height, starting and ending location of the cats, if it is a bomb and if it comes from the left side

		SCREENX = screenx; 
		SCREENY = screeny;
		
		h = startCatX; 
		eCX = endCatX; 
		eCY = endCatY; 
		// initializes the locations for the parabola formula
		
		FROM_LEFT = fromL; 
		IS_BOMB = bomb;

		if (IS_BOMB) {
			PIC = new ImageIcon(new ImageIcon("bomb.png").getImage().getScaledInstance((int) (SCREENX/20), (int) (SCREENX/20), Image.SCALE_DEFAULT)); // resizes

		}
		else {
			PIC = new ImageIcon(new ImageIcon("fish.gif").getImage().getScaledInstance((int) (SCREENX/15), (int) (SCREENX/15), Image.SCALE_DEFAULT)); // resizes
		}

		setIcon(PIC);

		if (FROM_LEFT) {
			x=0;
		}
		
		else {
			x=SCREENX;
		}
		// sets initial location of x based on whether its moving from left to right 
		
		setVisible(true);

		r = new Random();
		angle = r.nextInt(4)+1;

	}
/**
 * controls the movement of the fish, the different vertices and the formula to ensure the fish always end up at the cat location
 * @param speed the speed of the fish 
 */
	public void move(double speed) {

		if (FROM_LEFT) {
			x += speed * (SCREENX/1920);
		}
		else {
			x -= speed * (SCREENX/1920);
		}
		// either increases or decreases x based on where it comes from 

		switch (angle) { // has different y coordinate for the vertices
		case 1:
			k = SCREENY/20;
			break;
		case 2:
			k = SCREENY/10;
			break;
		case 3:
			k = SCREENY/15;
			break;
		case 4:
			k = SCREENY/25;
			break;
		}

		y = ((eCY-k)/Math.pow((eCX-h), 2))*Math.pow((x-h), 2)+k; 
		// formula for the parabola based on the y = a(x-h)^2+k to have the fish end up at the cats location

		setBounds((int)(x-(this.getWidth()/2.0)), (int)y, PIC.getIconWidth(), PIC.getIconHeight());  
		// moves the fish 
		this.repaint(); 
	}
}