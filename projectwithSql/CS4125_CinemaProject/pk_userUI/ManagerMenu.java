package pk_userUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import pk_business.Booking;
import pk_controller.UIController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;


public class ManagerMenu extends Frame {

    private JTextField bookingToApprove = new JTextField("");
    private JButton approveRefund = new JButton("Approve Refund");
    private JTable bookings;
    private JButton logout = new JButton("Logout");
 
    public ManagerMenu(UIController object){
    	ui = object;
        displayFrame();
    }
    @Override
    void displayFrame() {
        setTitle("Manager Menu");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,1));
        Object data [][] = new Object[0][0];
        
        String colNames [] = {"BookingID","UserID","MoiveName","Status"};
        bookings = new JTable();
        
        refreshTable();
        approveRefund.addActionListener(this);
        logout.addActionListener(this);
        JButton b = new JButton();
        JScrollPane sp = new JScrollPane(bookings);
        
        panel.add(sp);     
        panel.add(bookingToApprove);
        panel.add(approveRefund);
        panel.add(logout);
        add(panel);
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    	public void refreshTable(){
    		ArrayList<String> temp = ui.getRequestedRefunds();
            
            bookings.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {
                     
                    },
                    new String [] {
                        "Booking ID", "User", "Movie" , "State"
                    }
                ));
            DefaultTableModel dm = (DefaultTableModel)bookings.getModel();
            while(dm.getRowCount() > 0)
            {
                dm.removeRow(0);
            }
            for( String str : temp){
            	dm.addRow(str.split(","));
            }
    	}
    @Override
    public void actionPerformed(ActionEvent e) {
        Object buttonPressed = e.getSource();
        
        if(buttonPressed.equals(approveRefund)){
        	if(!bookingToApprove.getText().matches(""))
        		ui.approveBooking(Integer.parseInt(bookingToApprove.getText()));
        	refreshTable();
        }
        if(buttonPressed.equals(logout)){
        	ui.displayLogin();
        	dispose();
        }
        
    }
}