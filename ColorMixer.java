
// maybe add throwing errors?
import java.awt.Color;
import java.awt.*;
import javax.swing.*;
public class ColorMixer extends JFrame {
	private int red;
	private int green;
	private int blue;
	private int numQuestions;
	private Color color;

	public ColorMixer() {
		super("colour");
		red = 0;
		green = 0;
		blue = 0;
		numQuestions = 0;
		// create a new color
		color = new Color(red, green, blue);
	}
	
	public void showColor() {
		color = getColor();
		// create a panel
		JPanel panel = new JPanel();
		// set the background of the frame to the specified color
		panel.setBackground(color);
		setSize(200, 200);
		add(panel);
		show();
	}

	private double calculatePercentage (double obtained, double total) {
		return obtained / total;
	}
	
	public Color getColor() {
		float percentRed = (float)calculatePercentage(red, 255 * numQuestions);
		float percentGreen = (float)calculatePercentage(green, 255 * numQuestions);
		float percentBlue =(float)calculatePercentage(blue, 255 * numQuestions);
		//float redToReturn = percentRed * 255;
		//float greenToReturn = percentGreen * 255;
		//float blueToReturn = percentBlue * 255;
		System.out.println(red + ", " + green + ", " + blue);
		System.out.println(percentRed + ", " + percentGreen + ", " + percentBlue);
		//System.out.println(redToReturn + ", " + greenToReturn + ", " + blueToReturn);
//		if (red > 250) {
//			redToReturn = 250;
//		} else if (red < 0) {
//			redToReturn = 0;
//		}
//		if (green > 250) {
//			greenToReturn = 250;
//		} else if (green < 0) {
//			greenToReturn = 0;
//		}
//		if (blueToReturn > 250) {
//			blueToReturn = 250;
//		} else if (blue <0) {
//			blueToReturn = 0;
//		}
		return new Color(percentRed, percentGreen, percentBlue);
	}
	public void addQuestion() {
		numQuestions++;
	}
	public String getRGB() {
		String rgb = "red: " + red + ", green: " + green + ", blue: " + blue;
		return rgb;
	}

	public int addRed(int amount) {
		red = red + amount;
		return red;
	}

	public int addBlue(int amount) {
		blue = blue + amount;
		return blue;
	}

	public int addGreen(int amount) {
		green = green + amount;
		return green;
	}
}
