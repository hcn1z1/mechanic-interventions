/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package interfaces.intervention;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import core.Interventions;
import database.OracleClient;

/**
 *
 * @author LENOVO IP330
 */
public class InterventionsPanel extends javax.swing.JPanel {

    /**
     * Creates new form InterventionsPanel
     */
	public static Interventions[] interventions;
	static OracleClient dbmServer; 
	public javax.swing.JLabel jLabel2;
    public InterventionsPanel() {
        initComponents();
    }

                        
    public void initComponents() {
    	jLabel2 = new javax.swing.JLabel();
    	label1= new java.awt.Label();
    	label2= new java.awt.Label();
    	label3= new java.awt.Label();
    	label4= new java.awt.Label();
    	label5= new java.awt.Label();
    	label6= new java.awt.Label();
    	label7= new java.awt.Label();
    	

    	setBackground(new java.awt.Color(34, 36, 42));
    	setForeground(new java.awt.Color(255, 255, 255));
    	setToolTipText("");

    	label1.setFont(new java.awt.Font("Cairo", 0, 20));
    	label1.setForeground(new java.awt.Color(255, 255, 255));
    	label1.setText("Employe");
    	label1.setPreferredSize(new Dimension(150, 20));


    	label2.setFont(new java.awt.Font("Cairo", 0, 20));
    	label2.setForeground(new java.awt.Color(255, 255, 255));
    	label2.setText("Intervention");
    	label2.setPreferredSize(new Dimension(150, 20));

    	label3.setFont(new java.awt.Font("Cairo", 0, 20));
    	label3.setForeground(new java.awt.Color(255, 255, 255));
    	label3.setText("Type Intervention");
    	label3.setPreferredSize(new Dimension(150, 60));

    	label4.setFont(new java.awt.Font("Cairo", 0, 20));
    	label4.setForeground(new java.awt.Color(255, 255, 255));
    	label4.setText("Start Date");
    	label4.setPreferredSize(new Dimension(150, 60));

    	label5.setFont(new java.awt.Font("Cairo", 0, 20));
    	label5.setForeground(new java.awt.Color(255, 255, 255));
    	label5.setText("Last Date");
    	label5.setPreferredSize(new Dimension(150, 60));

    	label6.setFont(new java.awt.Font("Cairo", 0, 20));
    	label6.setForeground(new java.awt.Color(255, 255, 255));
    	label6.setText("Car Identificator");
    	label6.setPreferredSize(new Dimension(150, 60));

    	
    	JPanel _mainPanel = new JPanel();
    	GridLayout gpx = new GridLayout(1, 6, 50, 20); // increased gap to 50 pixels
    	_mainPanel.setLayout(gpx);
    	_mainPanel.setAlignmentX(LEFT_ALIGNMENT);
    	_mainPanel.setBackground(new Color(34, 36, 42));
    	_mainPanel.setSize(1183, 150);
    	_mainPanel.add(label1);
    	_mainPanel.add(label2);
    	_mainPanel.add(label3);
    	_mainPanel.add(label4);
    	_mainPanel.add(label5);
    	_mainPanel.add(label6);
    	_mainPanel.setBorder(null);
    	_mainPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(216,216,216)));
        panel = new JPanel();
        panel.setBorder(null);
        panel.setBackground(new Color(34,36,42));
        panel.setAlignmentX(LEFT_ALIGNMENT);
        panel.add(_mainPanel);
    	
        searchField = new javax.swing.JTextField();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        label6 = new java.awt.Label();
        label7 = new java.awt.Label();
        layout = new GridBagLayout();
        mainPanel = new JPanel(); 
        mainPanel.setBackground(new Color(34,36,42));
	    mainPanel.setLayout(layout);
	    GridBagConstraints gbc = new GridBagConstraints();
        for (int i = 0; i < interventions.length; i++) {
        	DivInterv intervPanel = new DivInterv() {
        		@Override
        		public void reupdatePanel(boolean status){
        			System.out.printf("why not working");
        			if(status) {
        				reupdate();
        			}
        		}
        	};
        	intervPanel.setServer(dbmServer);
        	intervPanel.setBorder(null);
        	intervPanel.eName.setText(interventions[i].nameClient);
        	intervPanel.eInterv.setText(interventions[i].interventionId + "");
        	intervPanel.eIntervType.setText(interventions[i].interventionType);
        	intervPanel.eIntervStartDate.setText(interventions[i].intervStartingDate.toString());
        	intervPanel.eIntervLastDate.setText(interventions[i].intervFinalDate.toString());
        	intervPanel.eCar.setText(interventions[i].carId + "");
	        gbc.gridx = 0;
	        gbc.gridy = i;
	        gbc.anchor = GridBagConstraints.WEST;

	        mainPanel.add(intervPanel, gbc);

	    }
        scrollPanel = new javax.swing.JScrollPane(mainPanel,
        	    javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        	    javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        	    );
        panel.setSize(scrollPanel.getSize().width,60);
        setBackground(new java.awt.Color(34, 36, 42));
        setPreferredSize(new java.awt.Dimension(1144, 678));
        scrollPanel.setAlignmentX(LEFT_ALIGNMENT);
        searchField.setBackground(new java.awt.Color(53, 55, 57));
        searchField.setFont(new java.awt.Font("Sakkal Majalla", 0, 20)); // NOI18N
        searchField.setForeground(new java.awt.Color(197, 197, 197));
        searchField.setText("Search here...");
        searchField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        searchField.setToolTipText("Default Search: NAME or LASTNAME or ID.\r\nQuery Search: 'interv>'int intervals ex: interv>3.");
        searchField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                // perform action here
                if(e.getKeyChar()>='a' && e.getKeyChar()<='z' || e.getKeyChar()>='0' && e.getKeyChar()<='9' || e.getKeyChar()>='A' && e.getKeyChar()<='Z') {
                	String query = searchField.getText() + e.getKeyChar();
                	runSearch(query);
                }
                
                else if ((int) e.getKeyChar() == 8){
                	System.out.println((int) e.getKeyChar());
                	try {
                		String query = searchField.getText().substring(0,searchField.getText().length());
                		runSearch(query);
                	}catch(Exception error){
                		System.out.print(error);
                		searchInside("");
                	}
                	
                }
                
            }
        });

        
        
        label1.setFont(new java.awt.Font("Cairo", 0, 20)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("Interventions ID");

        label2.setFont(new java.awt.Font("Cairo", 0, 20)); // NOI18N
        label2.setForeground(new java.awt.Color(255, 255, 255));
        label2.setText("Interventions");

        label3.setFont(new java.awt.Font("Cairo", 0, 20)); // NOI18N
        label3.setForeground(new java.awt.Color(255, 255, 255));
        label3.setText("Salary");

        label4.setFont(new java.awt.Font("Cairo", 0, 20)); // NOI18N
        label4.setForeground(new java.awt.Color(255, 255, 255));
        label4.setText("Category");

        label5.setFont(new java.awt.Font("Cairo", 0, 20)); // NOI18N
        label5.setForeground(new java.awt.Color(255, 255, 255));
        label5.setText("Lastname");

        label6.setFont(new java.awt.Font("Cairo", 0, 20)); // NOI18N
        label6.setForeground(new java.awt.Color(255, 255, 255));
        label6.setText("Name");

        scrollPanel.setBackground(new java.awt.Color(34, 36, 42));
        scrollPanel.setBorder(null);
        scrollPanel.setAlignmentY(TOP_ALIGNMENT);
        
    }// </editor-fold>                        

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           
    
    public void runSearch(String query) {
    	if(query.contains("car:")) {
    		try {
    			searchCount(Integer.parseInt(query.split("car:")[1]),0);
    		}
    		catch(Exception error) {
    			System.out.print("Error getting number of query : "+error);
    		}
    	}
    	// query of months and days and years
    	else if(query.contains("dd:")) {
    		try {
    			System.out.println("dday : " +Integer.parseInt(query.split("dd:")[1]));
    			searchDate(Integer.parseInt(query.split("dd:")[1]),0);
    		}
    		catch(Exception error) {
    			System.out.print("Error getting number of query : "+error);
    		}
    	}
    	else if(query.contains("mm:")) {
    		try {
    			searchDate(Integer.parseInt(query.split("mm:")[1]),1);
    		}
    		catch(Exception error) {
    			System.out.print("Error getting number of query : "+error);
    		}
    	}
    	else if(query.contains("yy:")) {
    		try {
    			searchDate(Integer.parseInt(query.split("yy:")[1]),2);
    		}
    		catch(Exception error) {
    			System.out.print("Error getting number of query : "+error);
    		}
    	}
    	else if(query.contains("interv:")) {
    		try {
    			System.out.print(Integer.parseInt(query.split("interv:")[1]));
    			searchCount(Integer.parseInt(query.split("interv:")[1]),1);
    		}
    		catch(Exception error) {
    			System.out.print("Error getting number of query : "+error);
    		}
    	}
    	else {
	    	searchInside(query);
    	}
    }
    public void searchDate(int query,int option) { // option : 0/day 1/month 2/year
    	int i = 0;
    	int date;
    	int _date;
    	for(Component component : mainPanel.getComponents()) {
    		if (component instanceof DivInterv) {
    			DivInterv jDiv = (DivInterv) component;
    			switch(option) {
    				case 0:
    					System.out.println("this case");
    					date = Integer.parseInt(jDiv.eIntervLastDate.getText().split("-")[2]); // format is yyyy-mm-dd
    					_date = Integer.parseInt(jDiv.eIntervStartDate.getText().split("-")[2]);
    					if(date == query || _date == query) {
    						jDiv.setVisible(true);
    						i++;
    					}
    					else {
    						jDiv.setVisible(false);
    					}
    					break;
    				case 1:
    					date = Integer.parseInt(jDiv.eIntervLastDate.getText().split("-")[1]);
    					_date = Integer.parseInt(jDiv.eIntervStartDate.getText().split("-")[1]);
    					if(date == query || _date == query) {
    						i++;
    						jDiv.setVisible(true);
    					}
    					else {
    						jDiv.setVisible(false);
    					}
    					break;
    				case 2:
    					date = Integer.parseInt(jDiv.eIntervLastDate.getText().split("-")[0]); 
    					_date = Integer.parseInt(jDiv.eIntervStartDate.getText().split("-")[0]);
    					if(date == query || _date == query) {
    						i++;
    						jDiv.setVisible(true);
    					}
    					else {
    						jDiv.setVisible(false);
    					}
    				default:
    					break;
    			}
    		}
    		
    	}
    	jLabel2.setText(i+ " Interventions");
    }
    public void searchInside(String query) { // this function for looking into name and lastname
    	if(query.length()<1) {
    		int i  = 0;
    		 for (Component component : mainPanel.getComponents()) {
 		        if (component instanceof DivInterv) {
 		        	i++;
 		        	DivInterv jDiv = (DivInterv) component;
 		        	jDiv.setVisible(true);
 		        }

    		 }
    		 jLabel2.setText(i+ " Interventions");
    	}
    	else {
    		System.out.println("am i EVEN here 2.0");
    		Component[] components = scrollPanel.getComponents();
    		int i = 0;
    		if (true) {
    		    //JPanel panel = (JPanel) components[0];
    		    for (Component component : mainPanel.getComponents()) {
    		        if (component instanceof DivInterv) {
    		        	DivInterv jDiv = (DivInterv) component;
    		        	if(! query.equals(jDiv.eName.getText().substring(0,query.length())) && ! query.equals(jDiv.eIntervType.getText().substring(0,query.length()))) {
    		        		jDiv.setVisible(false);
    		        	}
    		        
    		        	else {
    		        		jDiv.setVisible(true);
    		        		i++;
    		        	}
    		            // Modify the text of the labels as needed
    		        }
    		    }
    		    jLabel2.setText(i+ " Interventions");
    		    
    		}	
    	}
    	
    }
    public void searchCount(int numCount,int id) { // this function for looking into name and lastname
		Component[] components = scrollPanel.getComponents();
		int i = 0;
		if (true) {
		    //JPanel panel = (JPanel) components[0];
		    for (Component component : mainPanel.getComponents()) {
		        if (component instanceof DivInterv) {
		        	DivInterv jDiv = (DivInterv) component;
		            
		        	if(!(Integer.parseInt(jDiv.eCar.getText())==numCount) && id==0) {
		        		jDiv.setVisible(false);
		        		
		        	}
		        	else if(!(Integer.parseInt(jDiv.eInterv.getText())==numCount) && id==1) {
		        		jDiv.setVisible(false);
		        	}
		        	else {
		        		jDiv.setVisible(true);
		        		i++;
		        	}
		            // Modify the text of the labels as needed
		        }
		    }
		    jLabel2.setText(i+ " Interventions");
		    	
    	}
    	
    }
    public void reupdate() {
    	
    }
    public static void setDB(OracleClient dbmServer_) {
    	dbmServer = dbmServer_;
    	interventions = dbmServer.getInterventions();
    	
    }
    public OracleClient getDbmServer() {
		return dbmServer;
	}
	// Variables declaration - do not modify                     
    public java.awt.Label label1;
    public java.awt.Label label2;
    public java.awt.Label label3;
    public java.awt.Label label4;
    public java.awt.Label label5;
    public java.awt.Label label6;
    public java.awt.Label label7;
    public static javax.swing.JScrollPane scrollPanel;
    public static javax.swing.JTextField searchField;
    public GridBagLayout layout;
    public JPanel mainPanel;
    public JPanel panel;
    // End of variables declaration                   
	public void eInvClicked(MouseEvent e, String name) {
		System.out.println("i am here");
		
	}
	public void setInterventions(Interventions[] interventions_) {
		 interventions = interventions_;
		
	}
}
