/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package interfaces.employe;

import interfaces.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import core.Employe;
import database.OracleClient;
import interfaces.intervention.*;
/**
 *
 * @author LENOVO IP330
 */
public class EmployePanel extends javax.swing.JPanel {

    /**
     * Creates new form employePanel
     */
	public Employe[] employees;
	static OracleClient dbmServer; 
	InterventionsPanel interventionPanel;
	public javax.swing.JLabel jLabel2;
    public EmployePanel(Employe[] employees) {
    	this.employees = employees;
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

    	setBackground(new java.awt.Color(34, 36, 42));
    	setForeground(new java.awt.Color(255, 255, 255));
    	setToolTipText("");

    	label1.setFont(new java.awt.Font("Roboto", 0, 20));
    	label1.setForeground(new java.awt.Color(255, 255, 255));
    	label1.setText("Name");
    	label1.setPreferredSize(new Dimension(150, 30));


    	label2.setFont(new java.awt.Font("Cairo", 0, 20));
    	label2.setForeground(new java.awt.Color(255, 255, 255));
    	label2.setText("Lastname");
    	label2.setPreferredSize(new Dimension(150, 30));

    	label3.setFont(new java.awt.Font("Cairo", 0, 20));
    	label3.setForeground(new java.awt.Color(255, 255, 255));
    	label3.setText("Identifier");
    	label3.setPreferredSize(new Dimension(150, 60));

    	label4.setFont(new java.awt.Font("Cairo", 0, 20));
    	label4.setForeground(new java.awt.Color(255, 255, 255));
    	label4.setText("Interventions");
    	label4.setPreferredSize(new Dimension(150, 60));

    	label5.setFont(new java.awt.Font("Cairo", 0, 20));
    	label5.setForeground(new java.awt.Color(255, 255, 255));
    	label5.setText("Salary");
    	label5.setPreferredSize(new Dimension(150, 60));

    	label6.setFont(new java.awt.Font("Cairo", 0, 20));
    	label6.setForeground(new java.awt.Color(255, 255, 255));
    	label6.setText("Category");
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
        layout = new GridBagLayout();
        mainPanel = new JPanel(); 
        mainPanel.setBackground(new Color(34,36,42));
	    mainPanel.setLayout(layout);
	    GridBagConstraints gbc = new GridBagConstraints();
        for (int i = 0; i < employees.length; i++) {
        	final DivEmp empPanel = new DivEmp(this.getDbmServer());
        	empPanel.setBorder(null);
        	empPanel.eName.setText(employees[i].name);
        	empPanel.eLName.setText(employees[i].lastName);
        	empPanel.eID.setText(employees[i].numEmploye + "");
        	empPanel.eSal.setText(employees[i].salaire + "");
        	empPanel.eCAT.setText(employees[i].category);
        	empPanel.eINV.setText(employees[i].interventions + "");
        	empPanel.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                	// remove all space
                	String name = empPanel.eName.getText().replaceAll("\\s", "");;
                	System.out.println(name+" Length is:"+name.length());
                	eInvClicked(e,name);
                }
                public void mouseEntered(MouseEvent e) {
                	empPanel.eINV.setForeground(Color.GREEN); // set foreground color to red when mouse enters
                }
                public void mouseExited(MouseEvent e) {
                	empPanel.eINV.setForeground(Color.WHITE); // set foreground color back to black when mouse exits
                }
            });
        	
	        JLabel label = new JLabel("Enter Name (" + i + ")");
	        JTextField text = new JTextField(15);
	        gbc.gridx = 0;
	        gbc.gridy = i;
	        gbc.anchor = GridBagConstraints.WEST;

	        mainPanel.add(empPanel, gbc);

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
                System.out.println("A letter was typed!");
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
        label1.setText("employe ID");

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

    public void eInvClicked(MouseEvent e,String name) {                                            
        // TODO add your handling code here:
    	System.out.print("clicked");
    }                                           
    
    public void runSearch(String query) {
    	if (!admin) {
    		try{
    			int num = Integer.parseInt(query);
    			runQuickSearch(num);
    		}
    		catch(Exception e) {
    			runQuickSearch(-1);
    		}
    		return;
    	}
    	if(query.contains("interv>")) {
    		try {
    			System.out.print(Integer.parseInt(query.split("interv>")[1]));
    			searchInterventions(Integer.parseInt(query.split("interv>")[1]));
    		}
    		catch(Exception error) {
    			System.out.print("Error getting number of query : "+error);
    		}
    		
    	}
    	else {
	    	try {
	    		int identificator = Integer.parseInt(query);
	    		searchIdentificator(identificator);
	    	}
	    	catch(Exception error) {
	    		searchInside(query);
	    	}
    	}
    }
    public void searchInside(String query) { // this function for looking into name and lastname
    	if(query.length()<1) {
    		int i  = 0;
    		 for (Component component : mainPanel.getComponents()) {
 		        if (component instanceof DivEmp) {
 		        	i++;
 		        	DivEmp jDiv = (DivEmp) component;
 		        	jDiv.setVisible(true);
 		        }

    		 }
    		 jLabel2.setText(i+ " Employe");
    	}
    	else {
    		System.out.println("am i EVEN here 2.0");
    		Component[] components = scrollPanel.getComponents();
    		int i = 0;
    		if (true) {
    		    for (Component component : mainPanel.getComponents()) {
    		        if (component instanceof DivEmp) {
    		        	DivEmp jDiv = (DivEmp) component;
    		        	if(! query.equals(jDiv.eName.getText().substring(0,query.length())) && ! query.equals(jDiv.eLName.getText().substring(0,query.length()))) {
    		        		jDiv.setVisible(false);
    		        	}
    		        	else {
    		        		jDiv.setVisible(true);
    		        		i++;
    		        		System.out.println("substring is :"+jDiv.eName.getText().substring(0,query.length())+  " query is : "+query);
    		        	}
    		            // Modify the text of the labels as needed
    		        }
    		    }
    		    jLabel2.setText(i+ " Employe");
    		    
    		}	
    	}
    	
    }
    public void searchInterventions(int numInterv) { // this function for looking into name and lastname
		Component[] components = scrollPanel.getComponents();
		int i = 0;
		if (true) {
		    //JPanel panel = (JPanel) components[0];
		    for (Component component : mainPanel.getComponents()) {
		        if (component instanceof DivEmp) {
		        	DivEmp jDiv = (DivEmp) component;
		            
		        	if(!(Integer.parseInt(jDiv.eINV.getText())>=numInterv)) {
		        		jDiv.setVisible(false);
		        		
		        	}
		        	else {
		        		jDiv.setVisible(true);
		        		i++;
		        	}
		            // Modify the text of the labels as needed
		        }
		    }
		    jLabel2.setText(i+ " Employe");
		    	
    	}
    	
    }
    public void searchIdentificator(int numID) { // this function for looking into name and lastname
		Component[] components = scrollPanel.getComponents();
		int i = 0;
		if (true) {
		    //JPanel panel = (JPanel) components[0];
		    for (Component component : mainPanel.getComponents()) {
		        if (component instanceof DivEmp) {
		        	DivEmp jDiv = (DivEmp) component;
		        	if(!(Integer.parseInt(jDiv.eID.getText())==numID)) {
		        		System.out.println("i am here "+ Integer.parseInt(jDiv.eID.getText()));
		        		jDiv.setVisible(false);
		        	}
		        	else {
		        		jDiv.setVisible(true);
		        		i++;
		        	}

		            // Modify the text of the labels as needed
		        }
		    }
		    jLabel2.setText(i+ " Employe");
		    	
    	}
    	
    }
    
    public void runQuickSearch(int id) {
    	if(id == -1) {
    		int i  = 0;
    		 for (Component component : mainPanel.getComponents()) {
 		        if (component instanceof DivEmp) {
 		        	i++;
 		        	DivEmp jDiv = (DivEmp) component;
 		        	jDiv.setVisible(false);
 		        }

    		 }
    		 jLabel2.setText(i+ " Employe");
    	}
    	else {
    		System.out.println("am i EVEN here 2.0");
    		Component[] components = scrollPanel.getComponents();
    		int i = 0;
    		if (true) {
    		    for (Component component : mainPanel.getComponents()) {
    		        if (component instanceof DivEmp) {
    		        	DivEmp jDiv = (DivEmp) component;
    		        	if(!(id== Integer.parseInt(jDiv.eID.getText()))) {
    		        		jDiv.setVisible(false);
    		        	}
    		        	else {
    		        		jDiv.setVisible(true);
    		        		i++;
    		        	}
    		        }
    		    }
    		    jLabel2.setText(i+ " Employe");
    		    
    		}	
    	}
    }
    
    public static void setDB(OracleClient dbmServer_) {
    	dbmServer = dbmServer_;
    	
    }
    public void setInterv(InterventionsPanel interventionPanel) {
    	this.interventionPanel = interventionPanel;
    }
    public OracleClient getDbmServer() {
		return dbmServer;
	}
    
    public void setEmployees(Employe[] employees) {
    	this.employees = employees;
    }
    
    public static void setAdmin(boolean stat) {
    	admin = stat;
    }
    
	// Variables declaration - do not modify                     
    public java.awt.Label label1;
    public java.awt.Label label2;
    public java.awt.Label label3;
    public java.awt.Label label4;
    public java.awt.Label label5;
    public java.awt.Label label6;
    public javax.swing.JScrollPane scrollPanel;
    public javax.swing.JTextField searchField;
    public GridBagLayout layout;
    public JPanel mainPanel;
    public JPanel panel;
    private static boolean admin = true;
    // End of variables declaration                   
}
