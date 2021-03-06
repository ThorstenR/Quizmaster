package gui;

import db.QuestionHelper;
import entity.Answer;
import entity.Question;
import entity.User;
import helper.Tools;
import helper.WrongQuestion;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JRadioButton;

/**
 *
 * @author thorsten
 */
public class Quiz extends javax.swing.JFrame {	
	private User currentUser = null;
	
	private List<Question> questions = null;
	private List<Question> correctQuestions = null;
	private List<WrongQuestion> wrongQuestions = null;
	
	private int maxQuestions = 3;
	private int currentQuestion = 0;
	
	/**
	 * Creates new form Quiz
	 */
	public Quiz() {
		initComponents();
		Tools.centerFrame(this);
		
		initQuiz();
	}
	
	/**
	 * Sets the currently logged in user
	 * 
	 * @param currentUser
	 */
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	
	/**
	 * Initializes the Quiz
	 */
	private void initQuiz() {
//		questions = QuestionHelper.getQuestionsByType(db.Type.Auswahl);
		questions = QuestionHelper.getAllQuestions();
		Collections.shuffle(questions);
		questions = questions.subList(0, maxQuestions);
		
		correctQuestions = new ArrayList<Question>();
		wrongQuestions = new ArrayList<WrongQuestion>();
		currentQuestion = 0;
		
		btnNext.setText("Next");
		
		showQuestion();
	}
	
	/**
	 * Displays the next question
	 */
	private void showQuestion() {
		Question q = questions.get(currentQuestion);
		
		if(q.getType() == 3) {
			jPanel1.setVisible(true);
			txtAnswer.setVisible(false);
			
			int index = 0;
			for(Answer a: QuestionHelper.getAnswersForQuestion(q)) {
				((JRadioButton)jPanel1.getComponent(index)).setText(a.getAnswer());

				index++;
			}
			
			buttonGroup1.clearSelection();
		} else if(q.getType() == 1) {
			jPanel1.setVisible(false);
			txtAnswer.setVisible(true);
			
			txtAnswer.setText("");
		}
		
		lblQuestion.setText(q.getQuestion());
		lblQuestionCount.setText(String.format("%s/%s", Integer.toString(currentQuestion + 1), Integer.toString(maxQuestions)));
	}
	
	/**
	 * Procedure to show the Result form
	 */
	private void showResult() {
		gui.Result result = new gui.Result();
		result.setCurrentUser(currentUser);
		result.setCorrectQuestions(correctQuestions);
		result.setWrongQuestions(wrongQuestions);
		result.displayOutput();
		result.setVisible(true);

		this.setVisible(false);
	}
	
	/**
	 * Verifies the current question and prepares to display the next question
	 */
	private void checkQuestion() {
		Question q = questions.get(currentQuestion);
		Answer a = QuestionHelper.getAnswerById(q.getCorrectId());
		
		String answerText = "";
		
		if(q.getType() == 3) {
			for(Component c: jPanel1.getComponents()) {
				JRadioButton rb = ((JRadioButton)c);

				if(rb.isSelected())
					answerText = rb.getText();
			}
		} else if(q.getType() == 1) {
			answerText = txtAnswer.getText();
		}
		
		
		if(answerText.equals("")) {
			Tools.messageBoxError(null, "Select an answer first...");
			currentQuestion--;
		} else if(a.getAnswer().equals(answerText)) {
			correctQuestions.add(q);
			Tools.messageBoxInfo("Correct", "Good job!");
		} else {
			WrongQuestion wq = new WrongQuestion(a.getAnswer(), answerText, q.getQuestion());
			
			wrongQuestions.add(wq);
			
			Tools.messageBoxInfo("Wrong...", "The correct answer would have been: " + a.getAnswer());
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblQuestionLabel = new javax.swing.JLabel();
        lblQuestion = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        btnInit = new javax.swing.JButton();
        txtAnswer = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        rb4 = new javax.swing.JRadioButton();
        lblQuestionCount = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quizmaster by Thorsten Redetzky");
        setResizable(false);

        lblQuestionLabel.setText("Question:");

        lblQuestion.setText("-");

        btnNext.setText("Next");
        btnNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNextMouseClicked(evt);
            }
        });

        btnInit.setText("Init");
        btnInit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInitMouseClicked(evt);
            }
        });

        txtAnswer.setText("---");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("---");
        jRadioButton1.setMaximumSize(new java.awt.Dimension(56, 23));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("---");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("---");

        buttonGroup1.add(rb4);
        rb4.setText("---");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(17, 17, 17)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jRadioButton3)
                    .add(jRadioButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(185, 185, 185)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(rb4)
                    .add(jRadioButton2))
                .addContainerGap(202, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jRadioButton2)
                        .add(43, 43, 43)
                        .add(rb4))
                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel1Layout.createSequentialGroup()
                            .add(111, 111, 111)
                            .add(jRadioButton3))
                        .add(jPanel1Layout.createSequentialGroup()
                            .add(45, 45, 45)
                            .add(jRadioButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        lblQuestionCount.setText("-");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(lblQuestionLabel)
                        .add(18, 18, 18)
                        .add(lblQuestionCount))
                    .add(lblQuestion)
                    .add(layout.createSequentialGroup()
                        .add(6, 6, 6)
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .add(layout.createSequentialGroup()
                .add(8, 8, 8)
                .add(btnInit)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(txtAnswer, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 161, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(btnNext)
                .add(177, 177, 177))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblQuestionLabel)
                    .add(lblQuestionCount))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(lblQuestion)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(17, 17, 17)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnInit)
                    .add(btnNext)
                    .add(txtAnswer, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void btnNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseClicked
		checkQuestion();
		
		currentQuestion++;
		
		if(currentQuestion == questions.size() - 1) {
			btnNext.setText("Finish");
			showQuestion();
		} else if(currentQuestion >= questions.size()) {
			currentQuestion--;
			
			showResult();
		} else {
			showQuestion();
		}
	}//GEN-LAST:event_btnNextMouseClicked

	private void btnInitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInitMouseClicked
		initQuiz();
	}//GEN-LAST:event_btnInitMouseClicked

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/*
		 * Set the Nimbus look and feel
		 */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/*
		 * Create and display the form
		 */
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new Quiz().setVisible(true);
			}
		});
	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInit;
    private javax.swing.JButton btnNext;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JLabel lblQuestion;
    private javax.swing.JLabel lblQuestionCount;
    private javax.swing.JLabel lblQuestionLabel;
    private javax.swing.JRadioButton rb4;
    private javax.swing.JTextField txtAnswer;
    // End of variables declaration//GEN-END:variables
}
