package pk_userUI;

import javax.swing.*;

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
    public ManagerMenu(UIController object){
    	ui = object;
        displayFrame();
    }
    @Override
    void displayFrame() {
        setTitle("Manager Menu");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,1));
        Object data [][] = new Object[5][20];
        
        String colNames [] = {"BookingID","UserID","MoiveName","Status"};
        bookings = new JTable(data,colNames);
        ArrayList<Booking> temp = ui.getRequestedRefunds();
        for(int i = 0 ;i < temp.size() ; i++){
        	Booking aBook = temp.get(i);
        	bookings.setValueAt(aBook.getID(),i,0);
        	bookings.setValueAt(aBook.getUserID(),i,1);
        	bookings.setValueAt(aBook.getMovie(),i,2);
        	bookings.setValueAt(aBook.getStateStr(), i, 3);
        	System.out.println(aBook.getState());
        }
        bookings.setBounds(30,40,200,300);
        JButton b = new JButton();
        JScrollPane sp = new JScrollPane(bookings);
        panel.add(sp);
        panel.add(bookingToApprove);
        panel.add(approveRefund);
        add(panel);
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object buttonPressed = e.getSource();
        
        if(buttonPressed.equals(approveRefund)){
        	
        }
        
    }
}