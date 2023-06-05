/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package interfaces.cars;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 *
 * @author LENOVO IP330
 */
public class DivCars extends javax.swing.JPanel {

    /**
     * Creates new form divEmp
     */
    public DivCars() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	JPanel panel = new JPanel();
    	eName = new JLabel();
    	eLName = new JLabel();
    	eID = new JLabel();
    	eINV = new JLabel();
    	eCar = new JLabel();
    	eCAT = new JLabel();
    	eButton = new JButton();

    	setBackground(new java.awt.Color(34, 36, 42));
    	setForeground(new java.awt.Color(255, 255, 255));
    	setToolTipText("");
 
    	eCar.setFont(new java.awt.Font("Roboto", 0, 20));
    	eCar.setForeground(new java.awt.Color(255, 255, 255));
    	eCar.setText("eCar");
    	eCar.setPreferredSize(new Dimension(70, 60));
    	
    	eName.setFont(new java.awt.Font("Roboto", 0, 20));
    	eName.setForeground(new java.awt.Color(255, 255, 255));
    	eName.setText("eName");
    	eName.setPreferredSize(new Dimension(70, 60));


    	eLName.setFont(new java.awt.Font("Roboto", 0, 20));
    	eLName.setForeground(new java.awt.Color(255, 255, 255));
    	eLName.setText("eLName");
    	eLName.setPreferredSize(new Dimension(70, 60));
    	
    	eINV.setFont(new java.awt.Font("Roboto", 0, 20));
    	eINV.setForeground(new java.awt.Color(255, 255, 255));
    	eINV.setText("eINV");
    	eINV.setPreferredSize(new Dimension(70, 60));
    	
    	eID.setFont(new java.awt.Font("Roboto", 0, 20));
    	eID.setForeground(new java.awt.Color(255, 255, 255));
    	eID.setText("eID");
    	eID.setPreferredSize(new Dimension(70, 60));
    	
    	eButton.setSize(5,5);
    	eButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/close.png")));
    	eButton.setBackground(new java.awt.Color(34, 36, 42));
    	eButton.setBorder(null);
    	
    	eButton.addActionListener(new java.awt.event.ActionListener() {
    		public void actionPerformed(ActionEvent evt) {
    			System.out.println("Action is getting performed");
    			deleteThis(Integer.parseInt(eCar.getText()));
    		}
    	});
    	JPanel mainPanel = new JPanel();


    	GridLayout gpx = new GridLayout(1, 6, 120, 60); // increased gap to 50 pixels
    	mainPanel.setLayout(gpx);
    	mainPanel.setAlignmentX(CENTER_ALIGNMENT);
    	mainPanel.setBackground(new Color(34, 36, 42));
    	mainPanel.setSize(1030, 224);
    	mainPanel.add(eCar);
    	mainPanel.add(eName);
    	mainPanel.add(eLName);
    	mainPanel.add(eINV);
    	mainPanel.add(eID);
    	mainPanel.add(eButton);
    	mainPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(216,216,216)));

    	this.setLayout(new BorderLayout());

    	this.add(mainPanel, BorderLayout.WEST);
 
    }// </editor-fold>//GEN-END:initComponents

    public void deleteThis(int car) {
		// this function is going to get overrided
	}

	private Dimension Dimension(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}


	// Variables declaration - do not modify//GEN-BEGIN:variables
    protected JLabel eCAT;
    protected JLabel eID;
    protected JLabel eINV;
    protected JLabel eLName;
    protected JLabel eName;
    protected JLabel eCar;
    protected JButton eButton;
    // End of variables declaration//GEN-END:variables
}