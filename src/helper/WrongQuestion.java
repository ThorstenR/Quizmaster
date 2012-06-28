package helper;

/**
 * Class to hold the minimal required information
 * used for the result page
 * 
 * @author thorsten
 */
public class WrongQuestion {
	private String correctAnswer = "";
	private String wrongAnswer = "";
	private String question = "";
	
	/**
	 * Non-paramterized constructor required for GUI builder
	 */
	public WrongQuestion() {
		
	}
	/**
	 * Parameterized constructor
	 * 
	 * @param correctAnswer
	 * @param wrongAnswer
	 * @param question
	 */
	public WrongQuestion(String correctAnswer, String wrongAnswer, String question) {
		this.correctAnswer = correctAnswer;
		this.wrongAnswer = wrongAnswer;
		this.question = question;
	}
	
	/**
	 * Sets the correct answer
	 * 
	 * @param correctAnswer
	 */
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	/**
	 * Sets the wrong answer
	 * 
	 * @param wrongAnswer
	 */
	public void setWrongAnswer(String wrongAnswer) {
		this.wrongAnswer = wrongAnswer;
	}
	
	/**
	 * Sets the question
	 * 
	 * @param question
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	
	/**
	 * Returns the correct answer
	 * 
	 * @return String
	 */
	public String getCorrectAnswer() {
		return this.correctAnswer;
	}
	
	/**
	 * Returns the wrong answer
	 * 
	 * @return String
	 */
	public String getWrongAnswer() {
		return this.wrongAnswer;
	}
	
	/**
	 * Returns the question
	 * 
	 * @return String
	 */
	public String getQuestion() {
		return this.question;
	}
}
