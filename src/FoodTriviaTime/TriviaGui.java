package FoodTriviaTime;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import au.com.bytecode.opencsv.CSVParser;
import au.com.bytecode.opencsv.CSVReader;
import model.QuestionObject;

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
	private List<QuestionObject> questions;

	/**
	 * Call to main
	 * 
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		TriviaGui trivia = new TriviaGui();
	}
	
	/**
	 * Creates the interactive trivia display window
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public TriviaGui() throws FileNotFoundException, IOException {
		generateQuestions();
		
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
	
	/**
	 * Creates a new JButton for a trivia answer
	 * 
	 * @param ctn is Container to hold button
	 * @param txt is answer button will display
	 */
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

	/**
	 * Generates all questions upon startup
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void generateQuestions() throws FileNotFoundException, IOException {
		questions = new ArrayList<QuestionObject>();
		List<String[]> allLines = getAllLines();
		
		for (String[] s : allLines) {
			questions.add(generateQuestion(s));
		}
		
		// randomize answers of each question
		for (QuestionObject qo : questions) {
			qo.randomizeAnswers();
		}
		
		// randomize order of questions
		Collections.shuffle(questions);
	}
	
	/**
	 * Generates question from array of string
	 * 
	 * @param line consists of all data for one question
	 * @return ordered QuestionObject
	 */
	private QuestionObject generateQuestion(String[] line) {
		String qt = line[1];
		List<String> ans = new ArrayList<String>();
		String a0 = line[12];
		String a1 = line[15];
		String a2 = line[18];
		String a3 = line[21];
		ans.add(a0);
		ans.add(a1);
		ans.add(a2);
		ans.add(a3);
		return new QuestionObject(qt, ans);
	}
	
	/**
	 * Reads csv file of rows of question data
	 * 
	 * @return List<String[]>: each String[] is a line from csv
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private List<String[]> getAllLines() throws FileNotFoundException, IOException {
		CSVReader reader = new CSVReader(new FileReader("/FoodTriviaTime/resources/questionsfood.csv"));
		return (ArrayList<String[]>) reader.readAll();
	}
	
}
