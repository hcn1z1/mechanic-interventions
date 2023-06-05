/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package interfaces.cars;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import core.Cars;
import core.Employe;
import database.OracleClient;

/**
 *
 * @author LENOVO IP330
 */
public class CarsPanel extends javax.swing.JPanel {

    /**
     * Creates new form employePanel
     */
	OracleClient dbmServer;
	public Cars[] cars;
	public javax.swing.JLabel jLabel2;
    public CarsPanel(OracleClient sqlServer) {
    	this.dbmServer = sqlServer;
    	cars = dbmServer.getCars();
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

    	label1.setFont(new java.awt.Font("Cairo", 0, 20));
    	label1.setForeground(new java.awt.Color(255, 255, 255));
    	label1.setText("Car");
    	label1.setPreferredSize(new Dimension(70, 60));


    	label2.setFont(new java.awt.Font("Cairo", 0, 20));
    	label2.setForeground(new java.awt.Color(255, 255, 255));
    	label2.setText("Modele");
    	label2.setPreferredSize(new Dimension(70, 60));

    	label3.setFont(new java.awt.Font("Cairo", 0, 20));
    	label3.setForeground(new java.awt.Color(255, 255, 255));
    	label3.setText("Marque");
    	label3.setPreferredSize(new Dimension(70, 60));

    	label4.setFont(new java.awt.Font("Cairo", 0, 20));
    	label4.setForeground(new java.awt.Color(255, 255, 255));
    	label4.setText("Intervention");
    	label4.setPreferredSize(new Dimension(70, 60));
    	
    	label5.setFont(new java.awt.Font("Cairo", 0, 20));
    	label5.setForeground(new java.awt.Color(255, 255, 255));
    	label5.setText("Count");
    	label5.setPreferredSize(new Dimension(70, 60));
    	
    	label6.setFont(new java.awt.Font("Cairo", 0, 20));
    	label6.setForeground(new java.awt.Color(255, 255, 255));
    	label6.setText("");
    	label6.setPreferredSize(new Dimension(70, 60));


    	JPanel _mainPanel = new JPanel();
    	GridLayout gpx = new GridLayout(1, 6, 120, 20); // increased gap to 50 pixels

    	_mainPanel.setLayout(gpx);
    	_mainPanel.setAlignmentX(LEFT_ALIGNMENT);
    	_mainPanel.setBackground(new Color(34, 36, 42));
    	_mainPanel.setSize(1030, 224);
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
        panel.setBackground(new Color(34, 36, 42));
        panel.setAlignmentX(LEFT_ALIGNMENT);
        panel.add(_mainPanel);
    	
        searchField = new javax.swing.JTextField();
        layout = new GridBagLayout();
        mainPanel = new JPanel(); 
        mainPanel.setBackground(new Color(34,36,42));
	    mainPanel.setLayout(layout);
	    GridBagConstraints gbc = new GridBagConstraints();
        for (int i = 0; i < cars.length; i++) {
        	DivCars carPanel = new DivCars() {
        		public void deleteThis(int car) {
        			String query = "DELETE FROM VEHICULE WHERE NUMVEHICULE="+car;
        			System.out.println("I dont know what is happening but i am here");
        			boolean result = dbmServer.executeStatement(query);
        			if (result) {
        				System.out.println("Result become True");
        				toAdmin();
        			}
        			else {
        				System.out.println("Result returns to be false");
        			}
        		} 
        	};
        	carPanel.setBorder(null);
        	carPanel.eName.setText(cars[i].model);
        	carPanel.eLName.setText(cars[i].marque);
        	carPanel.eID.setText(cars[i].count + "");
        	carPanel.eCar.setText(cars[i].numCar+"");
        	carPanel.eINV.setText(cars[i].numIntervention +"");
        	
	        JLabel label = new JLabel("Enter Name (" + i + ")");
	        JTextField text = new JTextField(15);
	        gbc.gridx = 0;
	        gbc.gridy = i;
	        gbc.anchor = GridBagConstraints.CENTER;

	        mainPanel.add(carPanel, gbc);

	    }
        scrollPanel = new javax.swing.JScrollPane(mainPanel,
        	    javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        	    javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        	    );
        setBackground(new java.awt.Color(34, 36, 42));
        setPreferredSize(new java.awt.Dimension(1144, 678));
        scrollPanel.setAlignmentX(LEFT_ALIGNMENT);
        searchField.setBackground(new java.awt.Color(53, 55, 57));
        searchField.setFont(new java.awt.Font("Sakkal Majalla", 0, 20)); // NOI18N
        searchField.setForeground(new java.awt.Color(197, 197, 197));
        searchField.setText("Search here...");
        searchField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
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

        scrollPanel.setBackground(new java.awt.Color(34, 36, 42));
        scrollPanel.setBorder(null);
        
    }// </editor-fold>                        

    public void toAdmin() {
		// overrided into admin
		
	}


	public void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           
    
    public void runSearch(String query) {
    	if(query.contains("cars>")) {
    		try {
    			System.out.print(Integer.parseInt(query.split("cars>")[1]));
    			searchCount(Integer.parseInt(query.split("cars>")[1]));
    		}
    		catch(Exception error) {
    			System.out.print("Error getting number of query : "+error);
    		}
    		
    	}
    	else {
	    	searchInside(query);
    	}
    }
    public void searchInside(String query) { // this function for looking into name and lastname
    	if(query.length()<1) {
    		int i  = 0;
    		 for (Component component : mainPanel.getComponents()) {
 		        if (component instanceof DivCars) {
 		        	i++;
 		        	DivCars jDiv = (DivCars) component;
 		        	jDiv.setVisible(true);
 		        }

    		 }
    		 jLabel2.setText(i+ " Cars");
    	}
    	else {
    		System.out.println("am i EVEN here 2.0");
    		Component[] components = scrollPanel.getComponents();
    		int i = 0;
    		if (true) {
    		    //JPanel panel = (JPanel) components[0];
    		    for (Component component : mainPanel.getComponents()) {
    		        if (component instanceof DivCars) {
    		        	DivCars jDiv = (DivCars) component;
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
    		    jLabel2.setText(i+ " Cars");
    		    
    		}	
    	}
    	
    }
    public void searchCount(int numCount) { // this function for looking into name and lastname
		Component[] components = scrollPanel.getComponents();
		int i = 0;
		if (true) {
		    //JPanel panel = (JPanel) components[0];
		    for (Component component : mainPanel.getComponents()) {
		        if (component instanceof DivCars) {
		        	DivCars jDiv = (DivCars) component;
		            
		        	if(!(Integer.parseInt(jDiv.eID.getText())>=numCount)) {
		        		jDiv.setVisible(false);
		        		
		        	}
		        	else {
		        		jDiv.setVisible(true);
		        		i++;
		        	}
		            // Modify the text of the labels as needed
		        }
		    }
		    jLabel2.setText(i+ " Cars");
		    	
    	}
    	
    }

    public void setCars(Cars[] cars) {
    	this.cars = cars;
    }
    // Variables declaration                     
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
    // End of variables declaration                   
}
