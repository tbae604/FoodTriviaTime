package FoodTriviaTime;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TriviaGui {
	private static int fwidth = 600;
	private static int fheight = 400;
	private static int bheight = 50;
//	private static int bwidth = 400;
	private static int bfillheight = 10;
	private static int qfillheight = 35;
	private static Dimension fwh = new Dimension(fwidth, fheight);
	private static Dimension bwh = new Dimension(fwidth, bheight);
	private static Dimension bfillwh = new Dimension(fwidth, bfillheight);
	private static Dimension qfillwh = new Dimension(fwidth, qfillheight);
//	private static Box space = new createRigidArea(fillwh);

	public static void main(String[] args) {
		TriviaGui trivia = new TriviaGui();
	}
	
	public TriviaGui() {
		JFrame frm = new JFrame("Food Trivia Time!");
		frm.setSize(fwidth, fheight);
		frm.setMinimumSize(fwh);
		frm.setMaximumSize(fwh);
		frm.setVisible(true);
		
		Container cp = frm.getContentPane();
		cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
//		cp.add(jp1);
		
		// TODO: refactor later e.g. text as parameters
		cp.add(Box.createRigidArea(qfillwh));
		JLabel question = new JLabel("The answer is");
		question.setFont(new Font("Arial", Font.PLAIN, 16));
		question.setAlignmentX(Component.CENTER_ALIGNMENT);
		cp.add(question);
		cp.add(Box.createRigidArea(qfillwh));
		
		addButton(cp, "Option A");
		addButton(cp, "Option B");
		addButton(cp, "Option C");
		addButton(cp, "Option D");
		
	}
	
	private static void addButton(Container ctn, String txt) {
		
		JButton b = new JButton(txt);
		b.setFont(new Font("Arial", Font.PLAIN, 16));
		b.setBackground(Color.LIGHT_GRAY);
		b.setMinimumSize(bwh);
		b.setMaximumSize(bwh);
		b.setAlignmentX(Component.CENTER_ALIGNMENT);
//		b.addMouseListener(Listener);
		
		ctn.add(b);
		ctn.add(Box.createRigidArea(bfillwh));
	}

}
