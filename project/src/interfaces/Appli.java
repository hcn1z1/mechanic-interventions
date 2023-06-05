
package interfaces;
import interfaces.login.LoginUI;
import database.OracleClient;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/**
 *
 * @author hcn1 z1
 * this is main of the application ! here we set diffrence between dba and employsbda
 * PLEASE EXECUTE employesbda.sql and database.sql if you are reading this to make it works
 */
public class Appli extends javax.swing.JFrame {

	protected static OracleClient dbmServer = new OracleClient();
    public Appli() {
    	
        this.setLocationRelativeTo(null);
    }
    
    static LoginUI loginUI_;
    public static void main(String args[]) {
		loginUI_ = new LoginUI();
		final Appli App = new Appli();
		loginUI_.minimize.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	    	App.setExtendedState(Frame.ICONIFIED); // minimize the frame
    	    }
    	});
		loginUI_.close.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        App.dispose(); // close the frame
    	    }
    	});
		loginUI_.errorLabel.setText(" ".repeat(100));
		App.setMaximumSize(new Dimension(1377,850));
		App.setUndecorated(true);
		App.setResizable(false);
		if (1377<Toolkit.getDefaultToolkit().getScreenSize().width) {
			App.setSize(1377,850);
		}
		else {
			App.setSize(1377,768);
		}
		App.setLocationRelativeTo(App);
		App.add(loginUI_);;
		App.setVisible(true);
		loginUI_.jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	boolean resp = dbmServer.connect(loginUI_.usernameField.getText(),loginUI_.passwordField.getText());
                if(resp) {
                	// connect role will get role of user ! if you used my file employesbda.sql this shall work
                	// I added the second condition in case
                	
                	if(!dbmServer.connectGetRole().toLowerCase().equals("employe_admin") && !loginUI_.usernameField.getText().toLowerCase().equals("employesbda")) {
                		AdminPanel.setAdmin(true);
                	}
                	else{
                		AdminPanel.setAdmin(false);
                	}
                	final AdminPanel panel = new AdminPanel(dbmServer.getEmployees(),dbmServer);
                	panel.minimize.addActionListener(new ActionListener() {
                	    public void actionPerformed(ActionEvent e) {
                	    	App.setExtendedState(Frame.ICONIFIED); // minimize the frame
                	    }
                	});
                	panel.close.addActionListener(new ActionListener() {
                	    public void actionPerformed(ActionEvent e) {
                	        App.dispose(); // close the frame
                	    }
                	});
                	panel.exitButton.addActionListener(new ActionListener() {
                	    public void actionPerformed(ActionEvent e) {
                	    	loginUI_.setVisible(true);
                	    	loginUI_.errorLabel.setText(" ".repeat(100));
                	    	panel.setVisible(false);
                	        App.add(loginUI_); // change back to login panel
                	    }
                	});
                	panel.setJLabel2(dbmServer.getEmployeNumber());              	
                    // Get the JFrame from the event
                    panel.setVisible(true);
                    loginUI_.setVisible(false);
                    App.add(panel);                	
                }
                else {
                	System.out.print("here");
                	loginUI_.errorLabel.setVisible(true);
                    loginUI_.errorLabel.setText("Error : couldn't resolve username or password. Please Re login");
                }
               
            }

        });

    }               
}
