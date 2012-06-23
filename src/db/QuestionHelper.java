package db;

import entity.Answer;
import entity.AnswerQuestion;
import entity.Question;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author thorsten
 */
public class QuestionHelper {
	public static ArrayList<Answer> getAnswersForQuestion(Question q) {
		try {
			List<AnswerQuestion> answerquestions = (List<AnswerQuestion>) MySQL.execute("from AnswerQuestion where question_id = " + q.getId());
			
			String condition = "";
			for(AnswerQuestion aq: answerquestions) {
				condition += aq.getId() + ",";
			}
			condition = condition.replaceAll("[,]+$", "");
			
			ArrayList<Answer> answers = new ArrayList<Answer>();
			for(Answer a: (List<Answer>) MySQL.execute("from Answer where id in(" + condition + ")")) {
				answers.add(a);
			}
			
			return answers;
		} catch (HibernateException he) {
			he.printStackTrace();
			
			return null;
		}
	}
	
	public static List<Question> getAllQuestions() {
		try {
			return (List<Question>) MySQL.execute("from Question", 2);
		} catch (HibernateException he) {
			he.printStackTrace();
			
			return null;
		}
	}
	
	public static List<Question> getQuestionsByType(Type type) {
		try {
			return (List<Question>) MySQL.execute("from Question where type = " + type);
		} catch (HibernateException he) {
			he.printStackTrace();
			
			return null;
		}		
	}
	
	public static Question getQuestionById(int id) {
		try {
			return (Question) MySQL.execute("from Question where id = " + id);
		} catch (HibernateException he) {
			he.printStackTrace();
			
			return null;
		}
	}
	
	public static Question getQuestionByQuestion(String question) {
		try {
			return (Question) MySQL.execute("from Question where question = '" + question + "'");
		} catch (HibernateException he) {
			he.printStackTrace();
			
			return null;
		}
	}
	
	public static Question getRandomQuestion() {
		try {
			return (Question) MySQL.execute("from Question ORDER BY rand()");
		} catch (HibernateException he) {
			he.printStackTrace();
			
			return null;
		}
	}
}
