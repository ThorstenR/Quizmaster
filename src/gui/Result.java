package gui;

import entity.Question;
import entity.User;
import helper.Tools;
import helper.WrongQuestion;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author thorsten
 */
public class Result extends javax.swing.JFrame {
	private User currentUser = null;
	private List<Question> correctQuestions = null;
	private List<WrongQuestion> wrongQuestions = null;
	
	/**
	 * Creates new form Result
	 */
	public Result() {
		initComponents();
		Tools.centerFrame(this);
	}
	
	/**
	 * Sets current user
	 * 
	 * @param currentUser
	 */
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	
	/**
	 * Populates the correct questions
	 * 
	 * @param correctQuestions
	 */
	public void setCorrectQuestions(List<Question> correctQuestions) {
		this.correctQuestions = correctQuestions;
	}
	
	/**
	 * Populates the wrong questions
	 * 
	 * @param wrongQuestions
	 */
	public void setWrongQuestions(List<WrongQuestion> wrongQuestions) {
		this.wrongQuestions = wrongQuestions;
	}
	
	/**
	 * Displays all the output text
	 */
	public void displayOutput() {
		lblCongrats.setText(
			String.format(
				"Hello %s, you've got %d out of %d (%d %%) questions correct. Congrats!",
				currentUser.getUsername(),
				correctQuestions.size(),
				correctQuestions.size() + wrongQuestions.size(),
				(100 * correctQuestions.size()) / (correctQuestions.size() + wrongQuestions.size())
			)
		);
		
		showWrongQuestions();
	}
	
	/**
	 * Lists the wrong questions and related choices (wrong choice / correct choice)
	 */
	private void showWrongQuestions() {
		String output = "<html>";
		
		for(WrongQuestion wq: wrongQuestions) {
			output += String.format(""
					+ "<p>%s</p>"
					+ "Your answer: <span style=\"color: red;\">%s</span> - Correct answer: <span style=\"color: green;\">%s</span>"
					+ "<br /><br />",
					wq.getQuestion(), wq.getWrongAnswer(), wq.getCorrectAnswer()
			);
		}
		
		output += "</html>";
		
		lblOutput.setText(output);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCongrats = new javax.swing.JLabel();
        lblOutput = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quizmaster by Thorsten Redetzky");
        setResizable(false);

        lblCongrats.setText("Hello %s, you've got %d out of %d (%d %%) questions correct. Congrats!");
        lblCongrats.setToolTipText("");

        lblOutput.setText("---");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCongrats)
                    .addComponent(lblOutput))
                .addContainerGap(395, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCongrats)
                .addGap(39, 39, 39)
                .addComponent(lblOutput)
                .addContainerGap(338, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
			java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/*
		 * Create and display the form
		 */
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new Result().setVisible(true);
			}
		});
	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblCongrats;
    private javax.swing.JLabel lblOutput;
    // End of variables declaration//GEN-END:variables
}
