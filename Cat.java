import java.awt.Image;
import javax.swing.*;
/**
 * This class is the Cat class of the game, creating the cat images, setting their location and controlling their actions by changing their images 
 * @author julia anantchenko
 * @author victoria li
 * @version %I% %G%
 */
public class Cat extends JLabel { // Cat class for the game 

	// FIELDS: 
	/**
	 * Creates constants of the cat images when their mouths are open, closed, and when the player loses
	 */
	private final ImageIcon CAT_CLOSED, CAT_OPEN, CAT_CRYING; // the imageicons for the game 
	/**
	 * Creates constants for the screen size
	 */
	private final double SCREENX, SCREENY; // the screen size of the game 
	/** 
	 * Represents the width and height of the images
	 */
	private int picWidth, picHeight; // the variables for the width and height of the pictures 
	/**
	 * Represents the strings for when the cat's mouth is open, closed or crying
	 */
	private String closed, open, crying; 
	/**
	 * Represents a boolean if the cats are open or crying 
	 */
	public boolean isOpen, isCrying;

	/** 
	 * @param catType represents the type of cat chosen 
	 * @param loc represents the location of the cat 
	 * @param x represents the width of the screen 
	 * @param y represents the height of the screen 
	 * Initializes screenX, screenY, the image of the specific cat chosen, resizes the cats and sets the location of the cats
	 */
	public Cat (int catType, int loc, double x, double y) { // // constructor, gets the type of cat chosen, location and the width and height of the screen

		SCREENX = x; // initialize screenX 
		SCREENY = y; // initialize screenY 
		picWidth = (int) (SCREENX/8);
		picHeight = (int) (SCREENX/16*3);

		switch (catType) { // chooses the type of cat 
		case 1:
			closed = "greycatclosemouth.PNG";
			open = "greycatopenmouth.PNG";
			crying = "greycatcrying.gif";
			break;
		case 2:
			closed = "whitecatclosemouth.PNG";
			open = "whitecatopenmouth.PNG";
			crying = "whitecatcrying.gif";
			break;
		case 3:
			closed = "browncatclosemouth.PNG";
			open = "browncatopenmouth.PNG";
			crying = "browncatcrying.gif";
			break;
		case 4:
			closed = "orangecatclosemouth.PNG";
			open = "orangecatopenmouth.PNG";
			crying = "orangecatcrying.gif";
			break;
		}

		CAT_CLOSED = new ImageIcon(new ImageIcon(closed).getImage().getScaledInstance(picWidth, picHeight, Image.SCALE_DEFAULT));
		CAT_OPEN = new ImageIcon(new ImageIcon(open).getImage().getScaledInstance(picWidth, picHeight, Image.SCALE_DEFAULT));
		CAT_CRYING = new ImageIcon(new ImageIcon(crying).getImage().getScaledInstance(picWidth, picHeight, Image.SCALE_DEFAULT));
		// scales the images to fit the screen size 
		closeMouth();

		if (loc == 1)
		{
			setBounds((int) (SCREENX/5 - picWidth/2), (int) (SCREENY/5*4 - picHeight/2), (int) picWidth, (int) picHeight);
		}
		// left cat location
		if (loc == 2) {
			setBounds((int) (SCREENX/5*4 - picWidth/2), (int) (SCREENY/5*4 - picHeight/2), (int) picWidth, (int) picHeight);
		}
		// right cat location 

		setVisible(true);
		setFocusable(true);

	}
	/**
	 * sets the image to the open mouthed cat, and sets the boolean to check for if the mouth is open to be true 
	 */
	public void openMouth() { // opens the mouth of the cat 
		super.setIcon(CAT_OPEN);
		isOpen = true;
		repaint();
	}
	/**
	 * sets the image to the closed mouthed cat, and sets the boolean to check for if the mouth is open to be false 
	 */
	public void closeMouth() { // closes the mouth of the cat 
		super.setIcon(CAT_CLOSED);
		isOpen = false;
		repaint();
	}
	/**
	 * sets the image to the crying cat, and sets the boolean to check for if the cat is crying 
	 */
	public void cry() { // makes cat cry
		super.setIcon(CAT_CRYING);
		isCrying = true;
		repaint();
	}
}