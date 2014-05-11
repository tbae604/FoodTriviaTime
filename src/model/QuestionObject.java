package model;

import java.util.ArrayList;
import java.util.List;

public class QuestionObject {
	private String questionText;
	private List<String> answers;
	private Integer correctIndex;

	public QuestionObject (String qt, List<String> ans) {
		questionText = qt;
		answers = ans;
		correctIndex = 0;
	}
	
	public String getQuestionText() {
		return null;
	}
		
	public Integer getCorrectIndex() {
		return null;
	}
	
	public String getAnswerAtIndex(Integer i) {
		return answers.get(i);
	}
	
	/**
	 * Randomizes order of answers while keeping track of position
	 * of the correct answer within the incorrect answers
	 */
	public void randomizeAnswers() {
		List<String> rAnswers = new ArrayList<String>();
		List<Integer> lox = new ArrayList<Integer>();
		lox.add(4);
		lox.add(3);
		lox.add(2);
		lox.add(0);
		
		for (int x : lox) {
			Integer i = (int) Math.floor(Math.random() * x);
			if (i == 0) {
				// correctIndex in new list is its size at this point
				// that is
				// old list      new list     new list size
				//  0123          empty         0
				//  012           0             1
				//  01            01            2
				//  0             012           3
				//  empty         0123          4
				correctIndex = rAnswers.size();
			}
			rAnswers.add(answers.get(i));
			answers.remove(i);
		}
	}
	
}
