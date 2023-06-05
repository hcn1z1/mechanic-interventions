package test;

import database.OracleClient;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import interfaces.dba.*;


public class Test_ {

    public static void main(String[] args) {

        // Create a new JFrame.
    	OracleClient server = new OracleClient();
    	server.connect("system", "root");
        final JFrame frame = new JFrame("PopUp Frame");

        AdminControlPanel info = new AdminControlPanel();
        
        info.setDbmServer(server);
        // Set the size of the frame.
        frame.setSize(1000, 1000);
        
        frame.add(info);
        

        // Set the location of the frame.
        frame.setLocationRelativeTo(null);

        // Make the frame visible.
        frame.setVisible(true);
    }
}