package helper;

/**
 *
 * @author Leatherface
 */
public class WrongQuestion {
	private String correctAnswer = "";
	private String wrongAnswer = "";
	private String question = "";
	
	public WrongQuestion() {
		
	}
	public WrongQuestion(String correctAnswer, String wrongAnswer, String question) {
		this.correctAnswer = correctAnswer;
		this.wrongAnswer = wrongAnswer;
		this.question = question;
	}
	
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	public void setWrongAnswer(String wrongAnswer) {
		this.wrongAnswer = wrongAnswer;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String getCorrectAnswer() {
		return this.correctAnswer;
	}
	
	public String getWrongAnswer() {
		return this.wrongAnswer;
	}
	
	public String getQuestion() {
		return this.question;
	}
}
