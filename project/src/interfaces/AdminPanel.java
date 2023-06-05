package interfaces;
import interfaces.cars.CarsPanel;
import interfaces.cars.DivCars;
import interfaces.dba.AdminControlPanel;
import interfaces.employe.*;
import interfaces.intervention.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import core.Employe;
import database.OracleClient;


public class AdminPanel extends javax.swing.JPanel {

	// custom components
    Employe[] employees;
    EmployePanel employePanel;
    CarsPanel carsPanel;
    InterventionsPanel interventionPanel;
    OracleClient dbmServer;
    AdminControlPanel controlPanel;
    
    
    
    public AdminPanel(Employe[] employees,OracleClient dbmServer) {
    	this.employees = employees;
    	this.dbmServer = dbmServer;
    	if(admin) {
    		carsPanel = new CarsPanel(dbmServer) {
    			public void toAdmin() {
    				resetOptions("cars");
    			}
    		};
    	}
    	else {
    		System.out.println("I didn't take cars");
    	}
    	EmployePanel.setDB(dbmServer);
    	InterventionsPanel.setDB(dbmServer);
    	interventionPanel = new InterventionsPanel() {
    		public void reupdate() {
    			resetOptions("interv");
    		}
    	};
    	// overriding a click function in interventionPanel
    	
        initComponents();
    }

    @SuppressWarnings("unchecked")  
    private void initComponents() {
    	
    	this.setSize(1377,850);
    	this.setBackground(new java.awt.Color(34, 36, 42));
    	EmployePanel.setAdmin(admin);
    	employePanel = new EmployePanel(employees){
    		@Override
    		public void eInvClicked(MouseEvent e,String name) {                                            
    	        // TODO add your handling code here:
    			if(admin) {
	    	    	intervantionButtonActionPerformed();
	    	    	reloadWork();
	    	    	intervantionQuery(name);
    			} // this action is authorised only to admins
    	    }          
    	};
    	
    	setReload();
    	setReloadVisible(false);
    	reloadWork();
    	menu = new javax.swing.JPanel();
        intervantionButton = new javax.swing.JButton() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        	public void mouseEntered(MouseEvent e) {
            }
            public void mouseExited(MouseEvent e) {
            	
            }
        };
        controlPanel = new AdminControlPanel() {
        	public void reload() {
        		resetOptions("");
        		reloadWork();
        	}
        };
        if(!admin) {
        	controlPanel.tableOptions.removeItemAt(4);
        	controlPanel.tableOptions.removeItemAt(3);
        	controlPanel.tableOptions.removeItemAt(2);
        	controlPanel.tableOptions.removeItemAt(1);
        	controlPanel.title.setText("Welcome EmployesBDA User !");
        }
        dashboardButton = new javax.swing.JButton();
        employeButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        carsButton = new javax.swing.JButton();
        container = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = employePanel.jLabel2;
        
        controlPanel.setDbmServer(dbmServer);
        
        minimize = new javax.swing.JButton();
        minimize.setBackground(new java.awt.Color(34,36,42));
        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/minimize.png"))); // NOI18N
        minimize.setBorder(null);

        close = new javax.swing.JButton();
        close.setBackground(new java.awt.Color(34,36,42));
        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/close.png"))); // NOI18N
        close.setBorder(null);

        
        menu.setBackground(new java.awt.Color(20, 20, 20));
        menu.setForeground(new java.awt.Color(255, 255, 255));

        intervantionButton.setBackground(new java.awt.Color(20, 20, 20));
        intervantionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-fix-48.png"))); // NOI18N
        intervantionButton.setBorder(null);
        intervantionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	intervantionButtonActionPerformed();
            }
        });

        dashboardButton.setBackground(new java.awt.Color(20, 20, 20));
        dashboardButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-dashboard-64 (1).png"))); // NOI18N
        dashboardButton.setBorder(null);
        dashboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardButtonActionPerformed(evt);
            }
        });

        employeButton.setBackground(new java.awt.Color(20, 20, 20));
        employeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-user-50.png"))); // NOI18N
        employeButton.setBorder(null);
        employeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeButtonActionPerformed(evt);
            }
        });

        exitButton.setBackground(new java.awt.Color(20, 20, 20));
        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-quit-50.png"))); // NOI18N
        exitButton.setBorder(null);
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        carsButton.setBackground(new java.awt.Color(20, 20, 20));
        carsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-car-48.png"))); // NOI18N
        carsButton.setBorder(null);
        carsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carsButtonActionPerformed(evt);
            }
        });
        
        carsButton.setVisible(admin);
        intervantionButton.setVisible(admin);
        
        

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(exitButton)
                    .addComponent(intervantionButton)
                    .addComponent(carsButton)
                    .addComponent(employeButton)
                    .addComponent(dashboardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(dashboardButton)
                .addGap(30, 30, 30)
                .addComponent(employeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(carsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(intervantionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        container.setBackground(new java.awt.Color(34, 36, 42));

        jPanel1.setBackground(new java.awt.Color(34, 36, 42));

        jLabel1.setBackground(new java.awt.Color(34, 36, 42));
        jLabel1.setFont(new java.awt.Font("Inder", 0, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Employe");

        jLabel2.setBackground(new java.awt.Color(34, 36, 42));
        jLabel2.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(81, 81, 81));
        jLabel2.setText("29 employe");

        
        
        container.setBackground(new java.awt.Color(34, 36, 42));

        jPanel1.setBackground(new java.awt.Color(34, 36, 42));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(1190, Short.MAX_VALUE)
                .addComponent(minimize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(close)
                .addGap(7, 7, 7))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(close)
                    .addComponent(minimize))
                .addContainerGap(713, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

    }

	protected void intervantionQuery(String name) {
		interventionPanel.searchInside(name);
		interventionPanel.searchField.setText(name);
		
	}
	private void setContainerLayout() {
    	javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(1190, Short.MAX_VALUE)
                .addComponent(minimize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(close)
                .addGap(7, 7, 7))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(close)
                    .addComponent(minimize))
                .addContainerGap(713, Short.MAX_VALUE))
        );
    }
    private void carsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carsButtonActionPerformed
        // TODO add your handling code here:
    	jPanel1.removeAll();
    	this.setContainerLayout();
    	jLabel1.setText("Cars");
    	jLabel2.setText(carsPanel.cars.length+" Cars");
    	 this.dashboardButton.setOpaque(false);
	   	 this.dashboardButton.setBackground(new Color(0, 0, 0, 0));
	   	 this.intervantionButton.setOpaque(false);
	   	 this.carsButton.setOpaque(false);
	   	 this.employeButton.setOpaque(false);
	   	 javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
	                .addGap(78, 78, 78)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jLabel1)
	                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(840, 840, 840)
	                .addComponent(carsPanel.searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(87, 87, 87))
	            .addGroup(jPanel1Layout.createSequentialGroup()
	            .addGap(64, 64, 64)
	            	.addComponent(carsPanel.panel, javax.swing.GroupLayout.PREFERRED_SIZE, 1183, javax.swing.GroupLayout.PREFERRED_SIZE)
	            	.addGap(87, 87, 87))
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addGap(64, 64, 64)
	                .addComponent(carsPanel.scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1183, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	        employePanel.panel.setBorder(null);
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addGap(115, 115, 115)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel1)
	                    .addComponent(carsPanel.searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(69, 69, 69)
	                .addComponent(carsPanel.panel)
	                .addGap(20, 30, 70)
	                .addComponent(carsPanel.scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(73, Short.MAX_VALUE))
	        );
    }//GEN-LAST:event_carsButtonActionPerformed

    private void employeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeButtonActionPerformed
        // TODO add your handling code here:
    	jPanel1.removeAll();
    	this.setContainerLayout();
    	jLabel1.setText("Employe");
    	jLabel2.setText(employePanel.employees.length +" Employe");

    	for(Component component:employePanel.mainPanel.getComponents()) {
    		if (component instanceof DivEmp) {
    			DivEmp jDiv = (DivEmp) component;
    			jDiv.setVisible(admin);
    		}
    	}
    	 this.dashboardButton.setOpaque(false);
    	 this.dashboardButton.setBackground(new Color(0, 0, 0, 0));
    	 this.intervantionButton.setOpaque(false);
    	 this.carsButton.setOpaque(false);
    	 this.employeButton.setOpaque(false);
    	 javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
         jPanel1.setLayout(jPanel1Layout);
         jPanel1Layout.setHorizontalGroup(
             jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jLabel1)
                     .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addGap(840, 840, 840)
                 .addComponent(employePanel.searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(87, 87, 87))
             .addGroup(jPanel1Layout.createSequentialGroup()
             .addGap(64, 64, 64)
             	.addComponent(employePanel.panel, javax.swing.GroupLayout.PREFERRED_SIZE, 1183, javax.swing.GroupLayout.PREFERRED_SIZE)
             	.addGap(87, 87, 87))
             .addGroup(jPanel1Layout.createSequentialGroup()
                 .addGap(64, 64, 64)
                 .addComponent(employePanel.scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1183, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addContainerGap())
         );
         employePanel.panel.setBorder(null);
         jPanel1Layout.setVerticalGroup(
             jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(jPanel1Layout.createSequentialGroup()
                 .addGap(115, 115, 115)
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabel1)
                     .addComponent(employePanel.searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(69, 69, 69)
                 .addComponent(employePanel.panel)
                 .addGap(20, 30, 70)
                 .addComponent(employePanel.scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addContainerGap(73, Short.MAX_VALUE))
         );

    }//GEN-LAST:event_employeButtonActionPerformed
    
    
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
    }

    private void dashboardButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	 jPanel1.removeAll();
    	 this.setContainerLayout();	
    	 javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
         jPanel1.setLayout(jPanel1Layout);
         jPanel1Layout.setHorizontalGroup(
             jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(jPanel1Layout.createSequentialGroup()
             .addGap(64, 64, 64)
             	.addGap(87, 87, 87))
             .addGroup(jPanel1Layout.createSequentialGroup()
                 .addGap(64, 64, 64)
                 .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1183, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addContainerGap())
         );
         interventionPanel.panel.setBorder(null);
         jPanel1Layout.setVerticalGroup(
             jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(jPanel1Layout.createSequentialGroup()
                 .addGap(50, 50, 50)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addContainerGap(73, Short.MAX_VALUE))
         );
    }
    public void intervantionButtonActionPerformed() {
        // TODO add your handling code here:
    	jPanel1.removeAll();
    	this.setContainerLayout();	
    	jLabel1.setText("Interventions");
    	jLabel2.setText(interventionPanel.interventions.length +" Interventions");
    	 this.dashboardButton.setOpaque(false);
    	 this.dashboardButton.setBackground(new Color(0, 0, 0, 0));
    	 this.intervantionButton.setOpaque(false);
    	 this.carsButton.setOpaque(false);
    	 this.employeButton.setOpaque(false);
    	 javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
         jPanel1.setLayout(jPanel1Layout);
         jPanel1Layout.setHorizontalGroup(
             jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jLabel1)
                     .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addGap(800, 810, 810)
                 .addComponent(interventionPanel.searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(87, 87, 87))
             .addGroup(jPanel1Layout.createSequentialGroup()
             .addGap(64, 64, 64)
             	.addComponent(interventionPanel.panel, javax.swing.GroupLayout.PREFERRED_SIZE, 1183, javax.swing.GroupLayout.PREFERRED_SIZE)
             	.addGap(87, 87, 87))
             .addGroup(jPanel1Layout.createSequentialGroup()
                 .addGap(64, 64, 64)
                 .addComponent(interventionPanel.scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1183, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addContainerGap())
         );
         interventionPanel.panel.setBorder(null);
         jPanel1Layout.setVerticalGroup(
             jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(jPanel1Layout.createSequentialGroup()
                 .addGap(115, 115, 115)
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabel1)
                     .addComponent(interventionPanel.searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(69, 69, 69)
                 .addComponent(interventionPanel.panel)
                 .addGap(20, 30, 70)
                 .addComponent(interventionPanel.scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addContainerGap(73, Short.MAX_VALUE))
         );
    	
    }

    public void setJLabel2(int number) {
    	try {
			jLabel2.setText(number+" Employe");
		} catch (Exception e) {
			System.out.println("Error retrieving "+ e);
		}
    }
    public void resetOptions(String option) {
    	this.carsPanel.setCars(dbmServer.getCars());
    	this.carsPanel.initComponents();
    	this.carsPanel.repaint();
    	this.carsPanel.revalidate();
    	if(option.contains("car")) {this.reloadWork();;this.carsButtonActionPerformed(new ActionEvent(carsButton, 0, ""));}
    	
    	
    	
    	this.employePanel.setEmployees(dbmServer.getEmployees());;
    	this.employePanel.initComponents();
    	this.employePanel.repaint();
    	this.employePanel.revalidate();
    	if(option.contains("employe")) {
    		this.reloadWork();
    		this.employeButtonActionPerformed(null);
    	}
    	
    	
    	this.interventionPanel.setInterventions(dbmServer.getInterventions());
    	this.interventionPanel.initComponents();
    	this.interventionPanel.repaint();
    	this.interventionPanel.revalidate();
    	if(option.contains("interv")) {
    		this.reloadWork();
    		this.intervantionButtonActionPerformed();
    	}
    }
    
    private void setReload() {
		// TODO Auto-generated method stub
    	reload = new JPanel(new GridLayout());
		reload.setSize(this.getSize());
		reload.setBackground(this.getBackground());
		
		reload.setVisible(true);
		JLabel reloadLabel = new JLabel();
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		
		reloadLabel.setHorizontalAlignment(JLabel.CENTER);
		reloadLabel.setSize(100,30);
		reloadLabel.setFont(new java.awt.Font("Cairo", 0, 20));
		reloadLabel.setForeground(Color.WHITE);
		reloadLabel.setText("Loading modifications please wait...");
		reload.add(reloadLabel,gbc);
		this.add(reload);
	}
    private void setReloadVisible(boolean status) {
    	reload.setVisible(status);
    	Timer timer = new Timer(2000,e-> {
    		reload.setVisible(false);
    		((Timer) e.getSource()).stop();
    	});
    	timer.setRepeats(false);
    	timer.start();
    }
    private void reloadWork() {
    	this.setReloadVisible(true);
    	
    	//this.setReloadVisible(false);
    }
    protected static void setAdmin(boolean stat) {
    	admin = stat;
    }
    // Variables declaration
    private javax.swing.JButton carsButton;
    private javax.swing.JPanel container;
    private javax.swing.JButton dashboardButton;
    private javax.swing.JButton employeButton;
    protected javax.swing.JButton exitButton;
    private javax.swing.JButton intervantionButton;
    private static javax.swing.JPanel reload;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel menu;
    protected javax.swing.JButton minimize;
    protected javax.swing.JButton close;
    private static boolean admin = false; 
}
