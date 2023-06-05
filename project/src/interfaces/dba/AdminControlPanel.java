package interfaces.dba;
import database.OracleClient;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;

public class AdminControlPanel extends javax.swing.JPanel{
	
	public AdminControlPanel(){
		this.setSize(1000,500);
		this.setForeground(new Color(255,255,255));
		this.setBackground(new Color(34, 36, 42));
		this.initComponents();
	}
	public void initComponents() {
		title = new JLabel();
		container = new JPanel();
		container.setLayout(new BorderLayout());
		tableContainer = new JPanel();
		insertContainer = new JPanel(new GridBagLayout());
		sqlCommand = new JTextArea();
		tableOptions = new JComboBox<String>();
		submitButton = new JButton();
		
		JPanel headerPanel = new JPanel(new BorderLayout());
		JPanel footerPanel = new JPanel(new BorderLayout());
		headerPanel.setPreferredSize(new Dimension(800,70));
		footerPanel.setPreferredSize(new Dimension(800,50));
		headerPanel.setBackground(getBackground());
		footerPanel.setBackground(getBackground());
		
		
		container.setBackground(new Color(34, 36, 42));
		container.setBorder(null);
		container.setPreferredSize(new Dimension(800,400));
		
		tableContainer.setSize(400,340);
		tableContainer.setPreferredSize(new Dimension(320,400));
		tableContainer.setBackground(new Color(34, 36, 42));
		tableContainer.setBorder(BorderFactory.createMatteBorder(0,0,0,1, new Color(230,230,230)));
		
		insertContainer.setSize(400,400);
		insertContainer.setPreferredSize(new Dimension(480,400));
		insertContainer.setBackground(new Color(22,27,46));

		title.setForeground(new Color(240,240,240));
		title.setText("Welcome DBA Interventions !");
		title.setFont(new java.awt.Font("Cairo", 0, 26));
		title.setBackground(getBackground());

		sqlCommand.setBorder(null);
		sqlCommand.setSize(new Dimension(800,90));
		sqlCommand.setPreferredSize(new Dimension(800,150));
		sqlCommand.setBackground(new Color(0,0,0));
		sqlCommand.setForeground(new Color(255,255,255));
		sqlCommand.setFont(new Font("Roboto",0,14));
		sqlCommand.setText("SQL> ");
		
		submitButton.setBackground(new Color(0,255,0));
		submitButton.setPreferredSize(new Dimension(130,25));
		submitButton.setText("Submit");
		submitButton.setForeground(new Color(0,0,0));
		submitButton.setBorder(null);
		submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitCommand();
                System.out.println("Works");
            }
        });
		
		tableOptions.setPreferredSize(new Dimension(320,50));
		tableOptions.setBackground(new Color(34,36,42));
		tableOptions.setForeground(new Color(255,255,255));
		tableOptions.setFont(new Font("Roboto",0,18));
		
		
		setUpOptionBar();
		setEmployeLayout();
		
		// setting headers and footers
		headerPanel.add(title,BorderLayout.WEST);
		footerPanel.add(submitButton,BorderLayout.EAST);
		
		tableContainer.add(tableOptions);
		 
		container.add(tableContainer,BorderLayout.WEST);
		container.add(insertContainer,BorderLayout.EAST);
		container.setBorder(new EmptyBorder(0,0,20,0));
		
		
		this.add(headerPanel);
		this.add(container);
		this.add(sqlCommand);
		this.add(footerPanel);
		
		
		this.setVisible(true);
		
		
	}
	
	private void setUpOptionBar() {
		tableOptions.addItem("employee");
		tableOptions.addItem("interventions");
		tableOptions.addItem("client");
		tableOptions.addItem("cars");
		tableOptions.addItem("intervenants");
		tableOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedItem = (String) tableOptions.getSelectedItem();
				if(selectedItem.contains("employee")) {
					setEmployeLayout();
				}
				else if (selectedItem.contains("intervention")) {
					setInterventionsLayout();
				}
				else if (selectedItem.contains("cars")) {
					setCarsLayout();
				}
				else if (selectedItem.contains("client")) {
					setClientLayout();
				}
				else if (selectedItem.contains("intervenants")) {
					setIntervenantsLayout();
					
				}
				System.out.println("Option Selected is :"+selectedItem);
			}
		});
	}
	
	public void setEmployeLayout() {
		// delete all from insertContainer
		sqlCommand.setText("SQL> INSERT INTO EMPLOYE VALUES (0,'','','',0)");
		String command = "SQL> INSERT INTO EMPLOYE VALUES ";
		Object[] tuple = new Object[] {
				0,"","","",0.0
		};
		insertContainer.removeAll();
		
		JLabel numEmployeLabel = new JLabel();
		numEmployeLabel.setFont(new Font("Cairo",0,12));
		numEmployeLabel.setText("Number :");
		numEmployeLabel.setForeground(new Color(255,255,255));
		JLabel numVehiculeInterventionsLabel = new JLabel();
		numVehiculeInterventionsLabel.setFont(new Font("Cairo",0,12));
		numVehiculeInterventionsLabel.setText("Name :");
		numVehiculeInterventionsLabel.setForeground(new Color(255,255,255));
		JLabel firstDateInterventionLabel = new JLabel();
		firstDateInterventionLabel.setFont(new Font("Cairo",0,12));
		firstDateInterventionLabel.setText("Last name :");
		firstDateInterventionLabel.setForeground(new Color(255,255,255));
		JLabel categoryLabel = new JLabel();
		categoryLabel.setFont(new Font("Cairo",0,12));
		categoryLabel.setText("Category :");
		categoryLabel.setForeground(new Color(255,255,255));
		JLabel salaryLabel = new JLabel();
		salaryLabel.setFont(new Font("Cairo",0,12));
		salaryLabel.setText("salary :");
		salaryLabel.setForeground(new Color(255,255,255));
		
		JTextField numEmploye = new JTextField();
		numEmploye.setPreferredSize(new Dimension(200,40));
		JTextField numVehiculeInterventions = new JTextField();
		numVehiculeInterventions.setPreferredSize(new Dimension(200,40));
		JTextField firstDateIntervention = new JTextField();
		firstDateIntervention.setPreferredSize(new Dimension(200,40));
		JTextField category = new JTextField();
		category.setPreferredSize(new Dimension(200,40));
		JTextField salary = new JTextField();
		salary.setPreferredSize(new Dimension(200,40));
		
		numEmploye.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
            	try {
            		int num = Integer.parseInt(numEmploye.getText() + e.getKeyChar());
            		tuple[0] = num;
            		String values = "("+(int) tuple[0] + "," + "'"+ (String) tuple[1] + "'"+ "," + "'"+(String) tuple[2] + "'"+ "," + "'"+(String) tuple[3]+ "'"+"," + (Double) tuple[4] +")";
            		sqlCommand.setText(command+values); 
            	}
            	catch(Exception error) {
            		System.out.println("Couldn't modify tuple" + error);
            	}
            }
		});
		numVehiculeInterventions.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
            	try {
            		String text = numVehiculeInterventions.getText() + e.getKeyChar();
            		tuple[1] = text;
            		String values = "("+(int) tuple[0] + "," + "'"+ (String) tuple[1] + "'"+ "," + "'"+(String) tuple[2] + "'"+ "," + "'"+(String) tuple[3]+ "'"+"," + (Double) tuple[4] +")";
            		sqlCommand.setText(command+values); 
            	}
            	catch(Exception error) {
            		System.out.println("Couldn't modify tuple" + error);
            	}
            }
		});
		firstDateIntervention.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
            	try {
            		String text = firstDateIntervention.getText() + e.getKeyChar();
            		tuple[2] = text;
            		String values = "("+(int) tuple[0] + "," + "'"+ (String) tuple[1] + "'"+ "," + "'"+(String) tuple[2] + "'"+ "," + "'"+(String) tuple[3]+ "'"+"," + (Double) tuple[4] +")";
            		sqlCommand.setText(command+values); 
            	}
            	catch(Exception error) {
            		System.out.println("Couldn't modify tuple" + error);
            	}
            }
		});
		category.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
            	try {
            		String text = category.getText() + e.getKeyChar();
            		tuple[3] = text;
            		String values = "("+(int) tuple[0] + "," + "'"+ (String) tuple[1] + "'"+ "," + "'"+(String) tuple[2] + "'"+ "," + "'"+(String) tuple[3]+ "'"+"," + (Double) tuple[4] +")";
            		sqlCommand.setText(command+values); 
            	}
            	catch(Exception error) {
            		System.out.println("Couldn't modify tuple" + error);
            	}
            }
		});
		salary.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
            	try {
            		double num = Double.parseDouble(salary.getText() + e.getKeyChar());
            		tuple[4] = num;
            		String values = "("+(int) tuple[0] + "," + "'"+ (String) tuple[1] + "'"+ "," + "'"+(String) tuple[2] + "'"+ "," + "'"+(String) tuple[3]+ "'"+"," + (Double) tuple[4] +")";
            		sqlCommand.setText(command+values); 
            	}
            	catch(Exception error) {
            		System.out.println("Couldn't modify tuple" + error);
            	}
            }
		});
		
		
		numEmploye.setBorder(null);
		numVehiculeInterventions.setBorder(null);
		firstDateIntervention.setBorder(null);
		category.setBorder(null);
		salary.setBorder(null);
		
		
		// lets set constraints for gridBag
		GridBagConstraints gbc = new GridBagConstraints();gbc.fill = GridBagConstraints.BOTH;gbc.insets = new Insets(5,5,5,5);
		
		JPanel smallContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		smallContainer.setBackground(insertContainer.getBackground());
		smallContainer.setPreferredSize(new Dimension(200,65));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		smallContainer.add(numEmployeLabel);
		smallContainer.add(numEmploye);
		insertContainer.add(smallContainer,gbc);
		
		smallContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		smallContainer.setBackground(insertContainer.getBackground());
		smallContainer.setPreferredSize(new Dimension(200,65));
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.insets = new Insets(5,5,5,5);
		smallContainer.add(numVehiculeInterventionsLabel);
		smallContainer.add(numVehiculeInterventions);
		insertContainer.add(smallContainer,gbc);
		
		smallContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		smallContainer.setBackground(insertContainer.getBackground());
		smallContainer.setPreferredSize(new Dimension(200,65));
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(5,5,5,5);
		smallContainer.add(firstDateInterventionLabel);
		smallContainer.add(firstDateIntervention);
		insertContainer.add(smallContainer,gbc);
		
		smallContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		smallContainer.setBackground(insertContainer.getBackground());
		smallContainer.setPreferredSize(new Dimension(200,65));
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(5,5,5,5);
		smallContainer.add(categoryLabel);
		smallContainer.add(category);
		insertContainer.add(smallContainer,gbc);
		
		smallContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		smallContainer.setBackground(insertContainer.getBackground());
		smallContainer.setPreferredSize(new Dimension(200,65));
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(5,5,5,5);
		smallContainer.add(salaryLabel);
		smallContainer.add(salary);
		insertContainer.add(smallContainer,gbc);
		
	}
	
	public void setInterventionsLayout() {
		// delete all from insertContainer
		sqlCommand.setText("SQL> INSERT INTO INTERVENTIONS VALUES (0,'','','',0)");
		String command = "SQL> INSERT INTO INTERVENTIONS VALUES ";
		Object[] tuple = new Object[] {
				0,0,"","","",0.0
		};
		insertContainer.removeAll();
		
		JLabel numInterventionsLabel = new JLabel();
		numInterventionsLabel.setFont(new Font("Cairo",0,12));
		numInterventionsLabel.setText("Number :");
		numInterventionsLabel.setForeground(new Color(255,255,255));
		JLabel numVehiculeInterventionsLabel = new JLabel();
		numVehiculeInterventionsLabel.setFont(new Font("Cairo",0,12));
		numVehiculeInterventionsLabel.setText("Num Car :");
		numVehiculeInterventionsLabel.setForeground(new Color(255,255,255));
		JLabel firstDateInterventionLabel = new JLabel();
		firstDateInterventionLabel.setFont(new Font("Cairo",0,12));
		firstDateInterventionLabel.setText("firstDay :");
		firstDateInterventionLabel.setForeground(new Color(255,255,255));
		JLabel lastDayInterventionsLabel = new JLabel();
		lastDayInterventionsLabel.setFont(new Font("Cairo",0,12));
		lastDayInterventionsLabel.setText("last Day :");
		lastDayInterventionsLabel.setForeground(new Color(255,255,255));
		JLabel typeInterventionLabel = new JLabel();
		typeInterventionLabel.setFont(new Font("Cairo",0,12));
		typeInterventionLabel.setText("type :");
		typeInterventionLabel.setForeground(new Color(255,255,255));
		JLabel countIntervLabel = new JLabel();
		countIntervLabel.setFont(new Font("Cairo",0,12));
		countIntervLabel.setText("count :");
		countIntervLabel.setForeground(new Color(255,255,255));
		
		JTextField numInterventions = new JTextField();
		numInterventions.setPreferredSize(new Dimension(200,40));
		JTextField numVehiculeInterventions = new JTextField();
		numVehiculeInterventions.setPreferredSize(new Dimension(200,40));
		JTextField firstDateIntervention = new JTextField();
		firstDateIntervention.setPreferredSize(new Dimension(200,40));
		JTextField lastDayInterventions = new JTextField();
		lastDayInterventions.setPreferredSize(new Dimension(200,40));
		JTextField typeIntervention = new JTextField();
		typeIntervention.setPreferredSize(new Dimension(200,40));
		JTextField countInterv = new JTextField();
		countInterv.setPreferredSize(new Dimension(200,40));
		
		numInterventions.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
            	try {
            		int num = Integer.parseInt(numInterventions.getText() + e.getKeyChar());
            		tuple[0] = num;
            		String values = "("+(int) tuple[0] + "," + tuple[1]+ ","+ "'"+ (String) tuple[2] + "'"+ "," + "'"+(String) tuple[3] + "'"+ "," + "'"+(String) tuple[4]+ "'"+"," + (Double) tuple[5] +")";
            		sqlCommand.setText(command+values); 
            	}
            	catch(Exception error) {
            		System.out.println("Couldn't modify tuple" + error);
            	}
            }
		});
		numVehiculeInterventions.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
            	try {
            		int num = Integer.parseInt(numVehiculeInterventions.getText() + e.getKeyChar());
            		tuple[1] = num;
            		String values = "("+(int) tuple[0] + "," + (int) tuple[1]+ ","+ "'"+ (String) tuple[2] + "'"+ "," + "'"+(String) tuple[3] + "'"+ "," + "'"+(String) tuple[4]+ "'"+"," + (Double) tuple[5] +")";
            		sqlCommand.setText(command+values); 
            	}
            	catch(Exception error) {
            		System.out.println("Couldn't modify tuple" + error);
            	}
            }
		});
		firstDateIntervention.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
            	try {
            		String text = firstDateIntervention.getText() + e.getKeyChar();
            		tuple[3] = text;
            		String values = "("+(int) tuple[0] + "," + tuple[1]+ ","+ "'"+ (String) tuple[2] + "'"+ "," + "'"+(String) tuple[3] + "'"+ "," + "'"+(String) tuple[4]+ "'"+"," + (Double) tuple[5] +")";
            		sqlCommand.setText(command+values); 
            	}
            	catch(Exception error) {
            		System.out.println("Couldn't modify tuple" + error);
            	}
            }
		});
		lastDayInterventions.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
            	try {
            		String text = lastDayInterventions.getText() + e.getKeyChar();
            		tuple[4] = text;
            		String values = "("+(int) tuple[0] + "," + tuple[1]+ ","+ "'"+ (String) tuple[2] + "'"+ "," + "'"+(String) tuple[3] + "'"+ "," + "'"+(String) tuple[4]+ "'"+"," + (Double) tuple[5] +")";
            		sqlCommand.setText(command+values); 
            	}
            	catch(Exception error) {
            		System.out.println("Couldn't modify tuple" + error);
            	}
            }
		});
		typeIntervention.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
            	try {
            		String text  = typeIntervention.getText() + e.getKeyChar();
            		tuple[2] = text;
            		String values = "("+(int) tuple[0] + "," + tuple[1]+ ","+ "'"+ (String) tuple[2] + "'"+ "," + "'"+(String) tuple[3] + "'"+ "," + "'"+(String) tuple[4]+ "'"+"," + (Double) tuple[5] +")";
            		sqlCommand.setText(command+values); 
            	}
            	catch(Exception error) {
            		System.out.println("Couldn't modify tuple" + error);
            	}
            }
		});
		
		
		countInterv.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
            	try {
            		Double num = Double.parseDouble(countInterv.getText() + e.getKeyChar());
            		tuple[5] = num;
            		String values = "("+(int) tuple[0] + "," + tuple[1]+ ","+ "'"+ (String) tuple[2] + "'"+ "," + "'"+(String) tuple[3] + "'"+ "," + "'"+(String) tuple[4]+ "'"+"," + (Double) tuple[5] +")";
            		sqlCommand.setText(command+values); 
            	}
            	catch(Exception error) {
            		System.out.println("Couldn't modify tuple" + error);
            	}
            }
		});
		
		
		numInterventions.setBorder(null);
		numVehiculeInterventions.setBorder(null);
		firstDateIntervention.setBorder(null);
		lastDayInterventions.setBorder(null);
		typeIntervention.setBorder(null);
		countInterv.setBorder(null);
		
		// lets set constraints for gridBag
		GridBagConstraints gbc = new GridBagConstraints();gbc.fill = GridBagConstraints.BOTH;gbc.insets = new Insets(5,5,5,5);
		
		JPanel smallContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		smallContainer.setBackground(insertContainer.getBackground());
		smallContainer.setPreferredSize(new Dimension(200,65));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		smallContainer.add(numInterventionsLabel);
		smallContainer.add(numInterventions);
		insertContainer.add(smallContainer,gbc);
		
		smallContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		smallContainer.setBackground(insertContainer.getBackground());
		smallContainer.setPreferredSize(new Dimension(200,65));
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.insets = new Insets(5,5,5,5);
		smallContainer.add(numVehiculeInterventionsLabel);
		smallContainer.add(numVehiculeInterventions);
		insertContainer.add(smallContainer,gbc);
		
		smallContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		smallContainer.setBackground(insertContainer.getBackground());
		smallContainer.setPreferredSize(new Dimension(200,65));
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(5,5,5,5);
		smallContainer.add(firstDateInterventionLabel);
		smallContainer.add(firstDateIntervention);
		insertContainer.add(smallContainer,gbc);
		
		smallContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		smallContainer.setBackground(insertContainer.getBackground());
		smallContainer.setPreferredSize(new Dimension(200,65));
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(5,5,5,5);
		smallContainer.add(lastDayInterventionsLabel);
		smallContainer.add(lastDayInterventions);
		insertContainer.add(smallContainer,gbc);
		
		smallContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		smallContainer.setBackground(insertContainer.getBackground());
		smallContainer.setPreferredSize(new Dimension(200,65));
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(5,5,5,5);
		smallContainer.add(typeInterventionLabel);
		smallContainer.add(typeIntervention);
		insertContainer.add(smallContainer,gbc);
		
		smallContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		smallContainer.setBackground(insertContainer.getBackground());
		smallContainer.setPreferredSize(new Dimension(200,65));
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.insets = new Insets(5,5,5,5);
		smallContainer.add(countIntervLabel);
		smallContainer.add(countInterv);
		insertContainer.add(smallContainer,gbc);
		
	}
	
	public void setCarsLayout() {
		// delete all from insertContainer
		sqlCommand.setText("SQL> INSERT INTO VEHICULE VALUES (0,0,0,'',0)");
		String command = "SQL> INSERT INTO VEHICULE VALUES ";
		Object[] tuple = new Object[] {
				0,0,0,"",0
		};
		insertContainer.removeAll();
		
		JLabel numVehiculeLabel = new JLabel();
		numVehiculeLabel.setFont(new Font("Cairo",0,12));
		numVehiculeLabel.setText("Number :");
		numVehiculeLabel.setForeground(new Color(255,255,255));
		JLabel numClientLabel = new JLabel();
		numClientLabel.setFont(new Font("Cairo",0,12));
		numClientLabel.setText("Num Client :");
		numClientLabel.setForeground(new Color(255,255,255));
		JLabel numModelLabel = new JLabel();
		numModelLabel.setFont(new Font("Cairo",0,12));
		numModelLabel.setText("Num Model:");
		numModelLabel.setForeground(new Color(255,255,255));
		JLabel modelLabel = new JLabel();
		modelLabel.setFont(new Font("Cairo",0,12));
		modelLabel.setText("Model :");
		modelLabel.setForeground(new Color(255,255,255));
		JLabel yearLabel = new JLabel();
		yearLabel.setFont(new Font("Cairo",0,12));
		yearLabel.setText("year :");
		yearLabel.setForeground(new Color(255,255,255));
		
		JTextField numVehicule = new JTextField();
		numVehicule.setPreferredSize(new Dimension(200,40));
		JTextField numClient = new JTextField();
		numClient.setPreferredSize(new Dimension(200,40));
		JTextField numModel = new JTextField();
		numModel.setPreferredSize(new Dimension(200,40));
		JTextField model = new JTextField();
		model.setPreferredSize(new Dimension(200,40));
		JTextField year = new JTextField();
		year.setPreferredSize(new Dimension(200,40));
		
		numVehicule.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
            	try {
            		int num = Integer.parseInt(numVehicule.getText() + e.getKeyChar());
            		tuple[0] = num;
            		String values = "("+(int) tuple[0] + "," + (int) tuple[1]+ ","+(int) tuple[2] + "," +  "'"+ (String) tuple[3] + "'"+ "," + (int) tuple[4]+")";
            		sqlCommand.setText(command+values); 
            	}
            	catch(Exception error) {
            		System.out.println("Couldn't modify tuple" + error);
            	}
            }
		});
		numClient.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
            	try {
            		int num = Integer.parseInt(numClient.getText() + e.getKeyChar());
            		tuple[1] = num;
            		String values = "("+(int) tuple[0] + "," + (int) tuple[1]+ ","+(int) tuple[2] + "," + "'"+ (String) tuple[3] + "'"+ "," + (int) tuple[4]+")";
            		sqlCommand.setText(command+values); 
            	}
            	catch(Exception error) {
            		System.out.println("Couldn't modify tuple" + error);
            	}
            }
		});
		numModel.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
            	try {
            		int num = Integer.parseInt(numModel.getText() + e.getKeyChar());
            		tuple[2] = num;
            		String values = "("+(int) tuple[0] + "," + (int) tuple[1]+ ","+(int) tuple[2] + "," + "'"+ (String) tuple[3] + "'"+ "," + (int) tuple[4]+")";
            		sqlCommand.setText(command+values); 
            	}
            	catch(Exception error) {
            		System.out.println("Couldn't modify tuple" + error);
            	}
            }
		});
		model.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
            	try {
            		String text = model.getText() + e.getKeyChar();
            		tuple[3] = text;
            		String values = "("+(int) tuple[0] + "," + (int) tuple[1]+ ","+(int) tuple[2] + "," + "'"+ (String) tuple[3] + "'"+ "," + (int) tuple[4]+")";
            		sqlCommand.setText(command+values); 
            	}
            	catch(Exception error) {
            		System.out.println("Couldn't modify tuple" + error);
            	}
            }
		});
		year.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
            	try {
            		int text  = Integer.parseInt(year.getText() + e.getKeyChar());
            		tuple[4] = text;
            		String values = "("+(int) tuple[0] + "," + (int) tuple[1]+ ","+(int) tuple[2] + "," + "'"+ (String) tuple[3] + "'"+ "," + (int) tuple[4]+")";
            		sqlCommand.setText(command+values); 
            	}
            	catch(Exception error) {
            		System.out.println("Couldn't modify tuple" + error);
            	}
            }
		});
		
		
		
		numVehicule.setBorder(null);
		numClient.setBorder(null);
		numModel.setBorder(null);
		model.setBorder(null);
		year.setBorder(null);
		
		// lets set constraints for gridBag
		GridBagConstraints gbc = new GridBagConstraints();gbc.fill = GridBagConstraints.BOTH;gbc.insets = new Insets(5,5,5,5);
		
		JPanel smallContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		smallContainer.setBackground(insertContainer.getBackground());
		smallContainer.setPreferredSize(new Dimension(200,65));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		smallContainer.add(numVehiculeLabel);
		smallContainer.add(numVehicule);
		insertContainer.add(smallContainer,gbc);
		
		smallContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		smallContainer.setBackground(insertContainer.getBackground());
		smallContainer.setPreferredSize(new Dimension(200,65));
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.insets = new Insets(5,5,5,5);
		smallContainer.add(numClientLabel);
		smallContainer.add(numClient);
		insertContainer.add(smallContainer,gbc);
		
		smallContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		smallContainer.setBackground(insertContainer.getBackground());
		smallContainer.setPreferredSize(new Dimension(200,65));
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(5,5,5,5);
		smallContainer.add(numModelLabel);
		smallContainer.add(numModel);
		insertContainer.add(smallContainer,gbc);
		
		smallContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		smallContainer.setBackground(insertContainer.getBackground());
		smallContainer.setPreferredSize(new Dimension(200,65));
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(5,5,5,5);
		smallContainer.add(modelLabel);
		smallContainer.add(model);
		insertContainer.add(smallContainer,gbc);
		
		smallContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		smallContainer.setBackground(insertContainer.getBackground());
		smallContainer.setPreferredSize(new Dimension(200,65));
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(5,5,5,5);
		smallContainer.add(yearLabel);
		smallContainer.add(year);
		insertContainer.add(smallContainer,gbc);
		
	}
	
	public void setClientLayout() {
		// delete all from insertContainer
		sqlCommand.setText("SQL> INSERT INTO CLIENT VALUES (0,'','','','','','','','')");
		String command = "SQL> INSERT INTO CLIENT VALUES ";
		Object[] tuple = new Object[] {
				0,"","","","","","","",""
		};
		insertContainer.removeAll();
		
		JLabel numClientLabel = new JLabel();
		numClientLabel.setFont(new Font("Cairo",0,12));
		numClientLabel.setText("Id client :");
		numClientLabel.setForeground(new Color(255,255,255));
		JLabel civLabel = new JLabel();
		civLabel.setFont(new Font("Cairo",0,12));
		civLabel.setText("civ :");
		civLabel.setForeground(new Color(255,255,255));
        JLabel nameClientLabel = new JLabel();
		nameClientLabel.setFont(new Font("Cairo",0,12));
		nameClientLabel.setText("Name Client :");
		nameClientLabel.setForeground(new Color(255,255,255));
		JLabel lastNameClientLabel = new JLabel();
		lastNameClientLabel.setFont(new Font("Cairo",0,12));
		lastNameClientLabel.setText("Last Name:");
		lastNameClientLabel.setForeground(new Color(255,255,255));
		JLabel birthdayLabel = new JLabel();
		birthdayLabel.setFont(new Font("Cairo",0,12));
		birthdayLabel.setText("Birthday :");
		birthdayLabel.setForeground(new Color(255,255,255));
		JLabel addressLabel = new JLabel();
		addressLabel.setFont(new Font("Cairo",0,12));
		addressLabel.setText("Address :");
		addressLabel.setForeground(new Color(255,255,255));
        JLabel telProfLabel = new JLabel();
		telProfLabel.setFont(new Font("Cairo",0,12));
		telProfLabel.setText("Prof Phone:");
		telProfLabel.setForeground(new Color(255,255,255));
        JLabel telPrevLabel = new JLabel();
		telPrevLabel.setFont(new Font("Cairo",0,12));
		telPrevLabel.setText("Prev Phone :");
		telPrevLabel.setForeground(new Color(255,255,255));
        JLabel faxLabel = new JLabel();
		faxLabel.setFont(new Font("Cairo",0,12));
		faxLabel.setText("Fax :");
		faxLabel.setForeground(new Color(255,255,255));
		
		JTextField numClient = new JTextField();
		numClient.setPreferredSize(new Dimension(200,40));
        JTextField civ = new JTextField();
		civ.setPreferredSize(new Dimension(200,40));
		JTextField nameClient = new JTextField();
		nameClient.setPreferredSize(new Dimension(200,40));
		JTextField lastNameClient = new JTextField();
		lastNameClient.setPreferredSize(new Dimension(200,40));
		JTextField birthday = new JTextField();
		birthday.setPreferredSize(new Dimension(200,40));
		JTextField address = new JTextField();
		address.setPreferredSize(new Dimension(200,40));
        JTextField telPrev = new JTextField();
		telPrev.setPreferredSize(new Dimension(200,40));
        JTextField telProf = new JTextField();
		telProf.setPreferredSize(new Dimension(200,40));
        JTextField fax = new JTextField();
		fax.setPreferredSize(new Dimension(200,40));
		
		numClient.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
            	try {
            		int num = Integer.parseInt(numClient.getText() + e.getKeyChar());
            		tuple[0] = num;
            		String values = "("+(int) tuple[0] +","+"'"+(String) tuple[1]+"'"+","+"'"+(String) tuple[2]+"'"+","+"'"+(String) tuple[3]+"'"+","+"'"+(String) tuple[4]+"'"+","+"'"+(String) tuple[5]+"'"+","+"'"+(String) tuple[6]+"'"+","+"'"+(String) tuple[7]+"'"+","+"'"+(String) tuple[8]+"'"+")";
            		sqlCommand.setText(command+values); 
            	}
            	catch(Exception error) {
            		System.out.println("Couldn't modify tuple" + error);
            	}
            }
		});
        civ.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
            	try {
            		String num = civ.getText() + e.getKeyChar();
            		tuple[1] = num;
            		String values = "("+(int) tuple[0] +","+"'"+(String) tuple[1]+"'"+","+"'"+(String) tuple[2]+"'"+","+"'"+(String) tuple[3]+"'"+","+"'"+(String) tuple[4]+"'"+","+"'"+(String) tuple[5]+"'"+","+"'"+(String) tuple[6]+"'"+","+"'"+(String) tuple[7]+"'"+","+"'"+(String) tuple[8]+"'"+")";
            		sqlCommand.setText(command+values); 
            	}
            	catch(Exception error) {
            		System.out.println("Couldn't modify tuple" + error);
            	}
            }
		});
		nameClient.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
            	try {
            		String num = nameClient.getText() + e.getKeyChar();
            		tuple[2] = num;
            		String values = "("+(int) tuple[0] +","+"'"+(String) tuple[1]+"'"+","+"'"+(String) tuple[2]+"'"+","+"'"+(String) tuple[3]+"'"+","+"'"+(String) tuple[4]+"'"+","+"'"+(String) tuple[5]+"'"+","+"'"+(String) tuple[6]+"'"+","+"'"+(String) tuple[7]+"'"+","+"'"+(String) tuple[8]+"'"+")";
            		sqlCommand.setText(command+values); 
            	}
            	catch(Exception error) {
            		System.out.println("Couldn't modify tuple" + error);
            	}
            }
		});
		lastNameClient.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
            	try {
            		String num = lastNameClient.getText() + e.getKeyChar();
            		tuple[3] = num;
            		String values = "("+(int) tuple[0] +","+"'"+(String) tuple[1]+"'"+","+"'"+(String) tuple[2]+"'"+","+"'"+(String) tuple[3]+"'"+","+"'"+(String) tuple[4]+"'"+","+"'"+(String) tuple[5]+"'"+","+"'"+(String) tuple[6]+"'"+","+"'"+(String) tuple[7]+"'"+","+"'"+(String) tuple[8]+"'"+")";
            		sqlCommand.setText(command+values); 
            	}
            	catch(Exception error) {
            		System.out.println("Couldn't modify tuple" + error);
            	}
            }
		});
		birthday.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
            	try {
            		String num = birthday.getText() + e.getKeyChar();
            		tuple[4] = num;
            		String values = "("+(int) tuple[0] +","+"'"+(String) tuple[1]+"'"+","+"'"+(String) tuple[2]+"'"+","+"'"+(String) tuple[3]+"'"+","+"'"+(String) tuple[4]+"'"+","+"'"+(String) tuple[5]+"'"+","+"'"+(String) tuple[6]+"'"+","+"'"+(String) tuple[7]+"'"+","+"'"+(String) tuple[8]+"'"+")";
            		sqlCommand.setText(command+values); 
            	}
            	catch(Exception error) {
            		System.out.println("Couldn't modify tuple" + error);
            	}
            }
		});
		address.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
            	try {
            		String num = address.getText() + e.getKeyChar();
            		tuple[5] = num;
            		String values = "("+(int) tuple[0] +","+"'"+(String) tuple[1]+"'"+","+"'"+(String) tuple[2]+"'"+","+"'"+(String) tuple[3]+"'"+","+"'"+(String) tuple[4]+"'"+","+"'"+(String) tuple[5]+"'"+","+"'"+(String) tuple[6]+"'"+","+"'"+(String) tuple[7]+"'"+","+"'"+(String) tuple[8]+"'"+")";
            		sqlCommand.setText(command+values); 
            	}
            	catch(Exception error) {
            		System.out.println("Couldn't modify tuple" + error);
            	}
            }
		});
        telProf.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
            	try {
            		String num = telProf.getText() + e.getKeyChar();
            		tuple[6] = num;
            		String values = "("+(int) tuple[0] +","+"'"+(String) tuple[1]+"'"+","+"'"+(String) tuple[2]+"'"+","+"'"+(String) tuple[3]+"'"+","+"'"+(String) tuple[4]+"'"+","+"'"+(String) tuple[5]+"'"+","+"'"+(String) tuple[6]+"'"+","+"'"+(String) tuple[7]+"'"+","+"'"+(String) tuple[8]+"'"+")";
            		sqlCommand.setText(command+values); 
            	}
            	catch(Exception error) {
            		System.out.println("Couldn't modify tuple" + error);
            	}
            }
		});
        telPrev.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
            	try {
            		String num = telPrev.getText() + e.getKeyChar();
            		tuple[7] = num;
            		String values = "("+(int) tuple[0] +","+"'"+(String) tuple[1]+"'"+","+"'"+(String) tuple[2]+"'"+","+"'"+(String) tuple[3]+"'"+","+"'"+(String) tuple[4]+"'"+","+"'"+(String) tuple[5]+"'"+","+"'"+(String) tuple[6]+"'"+","+"'"+(String) tuple[7]+"'"+","+"'"+(String) tuple[8]+"'"+")";
            		sqlCommand.setText(command+values); 
            	}
            	catch(Exception error) {
            		System.out.println("Couldn't modify tuple" + error);
            	}
            }
		});
        fax.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
            	try {
            		String num = fax.getText() + e.getKeyChar();
            		tuple[8] = num;
            		String values = "("+(int) tuple[0] +","+"'"+(String) tuple[1]+"'"+","+"'"+(String) tuple[2]+"'"+","+"'"+(String) tuple[3]+"'"+","+"'"+(String) tuple[4]+"'"+","+"'"+(String) tuple[5]+"'"+","+"'"+(String) tuple[6]+"'"+","+"'"+(String) tuple[7]+"'"+","+"'"+(String) tuple[8]+"'"+")";
            		sqlCommand.setText(command+values); 
            	}
            	catch(Exception error) {
            		System.out.println("Couldn't modify tuple" + error);
            	}
            }
		});
		
		
		numClient.setBorder(null);
		nameClient.setBorder(null);
		lastNameClient.setBorder(null);
		birthday.setBorder(null);
		address.setBorder(null);
		
		// lets set constraints for gridBag
		GridBagConstraints gbc = new GridBagConstraints();gbc.fill = GridBagConstraints.BOTH;gbc.insets = new Insets(5,5,5,5);
		
		JPanel smallContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		smallContainer.setBackground(insertContainer.getBackground());
		smallContainer.setPreferredSize(new Dimension(200,65));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		smallContainer.add(numClientLabel);
		smallContainer.add(numClient);
		insertContainer.add(smallContainer,gbc);
		
		smallContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		smallContainer.setBackground(insertContainer.getBackground());
		smallContainer.setPreferredSize(new Dimension(200,65));
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.insets = new Insets(5,5,5,5);
		smallContainer.add(civLabel);
		smallContainer.add(civ);
		insertContainer.add(smallContainer,gbc);
        
        smallContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		smallContainer.setBackground(insertContainer.getBackground());
		smallContainer.setPreferredSize(new Dimension(200,65));
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(5,5,5,5);
		smallContainer.add(nameClientLabel);
		smallContainer.add(nameClient);
		insertContainer.add(smallContainer,gbc);
		
		smallContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		smallContainer.setBackground(insertContainer.getBackground());
		smallContainer.setPreferredSize(new Dimension(200,65));
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(5,5,5,5);
		smallContainer.add(lastNameClientLabel);
		smallContainer.add(lastNameClient);
		insertContainer.add(smallContainer,gbc);
		
		smallContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		smallContainer.setBackground(insertContainer.getBackground());
		smallContainer.setPreferredSize(new Dimension(200,65));
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(5,5,5,5);
		smallContainer.add(birthdayLabel);
		smallContainer.add(birthday);
		insertContainer.add(smallContainer,gbc);
		
		smallContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		smallContainer.setBackground(insertContainer.getBackground());
		smallContainer.setPreferredSize(new Dimension(200,65));
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.insets = new Insets(5,5,5,5);
		smallContainer.add(addressLabel);
		smallContainer.add(address);
		insertContainer.add(smallContainer,gbc);
		
        smallContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		smallContainer.setBackground(insertContainer.getBackground());
		smallContainer.setPreferredSize(new Dimension(200,65));
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.insets = new Insets(5,5,5,5);
		smallContainer.add(telProfLabel);
		smallContainer.add(telProf);
		insertContainer.add(smallContainer,gbc);

        smallContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		smallContainer.setBackground(insertContainer.getBackground());
		smallContainer.setPreferredSize(new Dimension(200,65));
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.insets = new Insets(5,5,5,5);
		smallContainer.add(telPrevLabel);
		smallContainer.add(telPrev);
		insertContainer.add(smallContainer,gbc);

        smallContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		smallContainer.setBackground(insertContainer.getBackground());
		smallContainer.setPreferredSize(new Dimension(200,65));
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.insets = new Insets(5,5,5,5);
		smallContainer.add(faxLabel);
		smallContainer.add(fax);
		insertContainer.add(smallContainer,gbc);

	}
	
	public void setIntervenantsLayout() {
		// delete all from insertContainer
		sqlCommand.setText("SQL> INSERT INTO INTERVENANTS VALUES (0,0,'','')");
		String command = "SQL> INSERT INTO INTERVENANTS VALUES ";
		Object[] tuple = new Object[] {
				0,0,"",""
		};
		insertContainer.removeAll();
		
		JLabel numEmployeLabel = new JLabel();
		numEmployeLabel.setFont(new Font("Cairo",0,12));
		numEmployeLabel.setText("Num client :");
		numEmployeLabel.setForeground(new Color(255,255,255));
		JLabel numInterventionLabel = new JLabel();
		numInterventionLabel.setFont(new Font("Cairo",0,12));
		numInterventionLabel.setText("Num Interv :");
		numInterventionLabel.setForeground(new Color(255,255,255));
		JLabel firstDateInterventionLabel = new JLabel();
		firstDateInterventionLabel.setFont(new Font("Cairo",0,12));
		firstDateInterventionLabel.setText("First Day :");
		firstDateInterventionLabel.setForeground(new Color(255,255,255));
		JLabel lastDayInterventionLabel = new JLabel();
		lastDayInterventionLabel.setFont(new Font("Cairo",0,12));
		lastDayInterventionLabel.setText("last Day:");
		lastDayInterventionLabel.setForeground(new Color(255,255,255));


		JTextField numEmploye = new JTextField();
		numEmploye.setPreferredSize(new Dimension(200,40));
		JTextField numIntervention = new JTextField();
		numIntervention.setPreferredSize(new Dimension(200,40));
		JTextField firstDateIntervention = new JTextField();
		firstDateIntervention.setPreferredSize(new Dimension(200,40));
		JTextField lastDayIntervention = new JTextField();
		lastDayIntervention.setPreferredSize(new Dimension(200,40));
		
		numEmploye.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
            	try {
            		int num = Integer.parseInt(numEmploye.getText() + e.getKeyChar());
            		tuple[1] = num;
            		String values = "("+(int) tuple[0] + "," + "'"+ (int) tuple[1] + "'"+ "," + "'"+(String) tuple[2] + "'"+ "," + "'"+(String) tuple[3]+ "'"+")";
            		sqlCommand.setText(command+values); 
            	}
            	catch(Exception error) {
            		System.out.println("Couldn't modify tuple" + error);
            	}
            }
		});
		numIntervention.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
            	try {
            		int text = Integer.parseInt(numIntervention.getText() + e.getKeyChar());
            		tuple[0] = text;
            		String values = "("+(int) tuple[0] + "," + "'"+ (int) tuple[1] + "'"+ "," + "'"+(String) tuple[2] + "'"+ "," + "'"+(String) tuple[3]+ "'"+")";
            		sqlCommand.setText(command+values); 
            	}
            	catch(Exception error) {
            		System.out.println("Couldn't modify tuple" + error);
            	}
            }
		});
		firstDateIntervention.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
            	try {
            		String text = firstDateIntervention.getText() + e.getKeyChar();
            		tuple[2] = text;
            		String values = "("+(int) tuple[0] + "," + "'"+ (int) tuple[1] + "'"+ "," + "'"+(String) tuple[2] + "'"+ "," + "'"+(String) tuple[3]+ "'"+")";
            		sqlCommand.setText(command+values); 
            	}
            	catch(Exception error) {
            		System.out.println("Couldn't modify tuple" + error);
            	}
            }
		});
		lastDayIntervention.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
            	try {
            		String text = lastDayIntervention.getText() + e.getKeyChar();
            		tuple[3] = text;
            		String values = "("+(int) tuple[0] + "," + "'"+ (int) tuple[1] + "'"+ "," + "'"+(String) tuple[2] + "'"+ "," + "'"+(String) tuple[3]+ "'"+")";
            		sqlCommand.setText(command+values); 
            	}
            	catch(Exception error) {
            		System.out.println("Couldn't modify tuple" + error);
            	}
            }
		});
		
		numEmploye.setBorder(null);
		numIntervention.setBorder(null);
		firstDateIntervention.setBorder(null);
		lastDayIntervention.setBorder(null);
		
		
		// lets set constraints for gridBag
		GridBagConstraints gbc = new GridBagConstraints();gbc.fill = GridBagConstraints.BOTH;gbc.insets = new Insets(5,5,5,5);
		
		JPanel smallContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		smallContainer.setBackground(insertContainer.getBackground());
		smallContainer.setPreferredSize(new Dimension(200,65));
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		smallContainer.add(numEmployeLabel);
		smallContainer.add(numEmploye);
		insertContainer.add(smallContainer,gbc);
		
		smallContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		smallContainer.setBackground(insertContainer.getBackground());
		smallContainer.setPreferredSize(new Dimension(200,65));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(5,5,5,5);
		smallContainer.add(numInterventionLabel);
		smallContainer.add(numIntervention);
		insertContainer.add(smallContainer,gbc);
		
		smallContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		smallContainer.setBackground(insertContainer.getBackground());
		smallContainer.setPreferredSize(new Dimension(200,65));
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(5,5,5,5);
		smallContainer.add(firstDateInterventionLabel);
		smallContainer.add(firstDateIntervention);
		insertContainer.add(smallContainer,gbc);
		
		smallContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		smallContainer.setBackground(insertContainer.getBackground());
		smallContainer.setPreferredSize(new Dimension(200,65));
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(5,5,5,5);
		smallContainer.add(lastDayInterventionLabel);
		smallContainer.add(lastDayIntervention);
		insertContainer.add(smallContainer,gbc);
		
		
	}
	
	public void submitCommand() {
		String command = sqlCommand.getText().split("SQL> ")[1].split("\n")[0];
		String response = dbmServer.executeR(command);
		if(response.contains("Error")) {
			sqlCommand.setText(sqlCommand.getText()+"\n"+response);
		}
		else {
			sqlCommand.setText(sqlCommand.getText()+"\nInserted with success !");
			reload();
		}
	}
	public void reload() {
		
	}
	
	// variables
	JPanel container;
	OracleClient dbmServer;
	JPanel tableContainer;
	JPanel insertContainer;
	JTextArea sqlCommand;
	JButton submitButton;
	GridBagConstraints gbc;
	public JComboBox<String> tableOptions;
	public JLabel title;
	
	public void setDbmServer(OracleClient dbmServer){
		this.dbmServer = dbmServer;
	}
}
