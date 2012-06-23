package gui;

import entity.User;
import helper.PasswordEncoder;
import helper.Tools;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thorsten
 */
public class main extends javax.swing.JFrame {

	/**
	 * Creates new form main
	 */
	public main() {
		initComponents();
		Tools.centerFrame(this);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        txtUsername = new javax.swing.JTextField();
        lblGetStarted = new java.awt.Label();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        btnSignup = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quizmaster by Thorsten Redetzky");
        setResizable(false);

        txtUsername.setText("thorstenr");
        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsernameFocusGained(evt);
            }
        });

        lblGetStarted.setForeground(new java.awt.Color(0, 153, 255));
        lblGetStarted.setText("Welcome to the Quizmaster. Please log-in or sign-up below to start!");

        lblUsername.setText("Username:");

        lblPassword.setText("Password:");

        btnSignup.setText("Sign-Up");
        btnSignup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSignupMouseClicked(evt);
            }
        });

        btnLogin.setText("Log-In");
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginMouseClicked(evt);
            }
        });

        txtPassword.setText("asdf");
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(lblGetStarted, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .add(21, 21, 21)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(lblUsername)
                        .add(0, 0, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(lblPassword)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(txtUsername, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .add(txtPassword))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(btnLogin)
                .add(50, 50, 50)
                .add(btnSignup)
                .add(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(lblGetStarted, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(17, 17, 17)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblUsername)
                            .add(txtUsername, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(lblPassword))
                            .add(layout.createSequentialGroup()
                                .add(6, 6, 6)
                                .add(txtPassword, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(0, 6, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(1, 1, 1)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(btnSignup)
                                .add(0, 0, Short.MAX_VALUE))
                            .add(btnLogin, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseClicked
		User u = db.User.getUserByUsername(txtUsername.getText());
		
		if(u != null) {
			try {
				if(PasswordEncoder.getInstance().encode(txtPassword.getText(), u.getSalt()).equals(u.getPassword())) {
					if(txtUsername.getText().equals("admin")) {
						admin admin = new admin();
						admin.setVisible(true);
					} else {
						quiz quiz = new quiz();
						quiz.setVisible(true);	
					}
					
					this.setVisible(false);
				} else {
					Tools.messageBoxError(null, "Wrong password!");
				}
			} catch (NoSuchAlgorithmException ex) {
				Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
			} catch (IOException ex) {
				Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
			}
		} else {
			Tools.messageBoxError(null, "Username does not exist!");
		}
	}//GEN-LAST:event_btnLoginMouseClicked

	private void btnSignupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSignupMouseClicked
		signup signup = new signup();
		signup.setVisible(true);
	}//GEN-LAST:event_btnSignupMouseClicked

	private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
		txtPassword.selectAll();
	}//GEN-LAST:event_txtPasswordFocusGained

	private void txtUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusGained
		txtUsername.selectAll();
	}//GEN-LAST:event_txtUsernameFocusGained

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
			java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/*
		 * Create and display the form
		 */
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new main().setVisible(true);
			}
		});
	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSignup;
    private javax.swing.JSeparator jSeparator1;
    private java.awt.Label lblGetStarted;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
