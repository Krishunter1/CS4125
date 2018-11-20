package pk_userUI;

import javax.swing.*;

import pk_controller.UIController;

import java.awt.*;
import java.awt.event.ActionEvent;

public class displaySeats extends Frame {
    JButton[] buttons;
    String[] seats;
    JButton confirmSeat;
    
    public displaySeats(String[] seats, UIController object){
    	ui = object;
    	this.seats = seats;
        this.displayFrame();
    }
    
    @Override
    void displayFrame() {
        setTitle("Select Seats");
        buttons = new JButton[10];
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,5));
        for(int i = 0; i < 10; i++){
            buttons[i] = new JButton();
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);

            if(seats[i].equals("1")) {
            	buttons[i].setEnabled(false);
            	buttons[i].setText("reserved");
            }
        }
        
        add(panel);
        confirmSeat = new JButton("Confirm Seats");
        confirmSeat.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel screen = new JLabel("----------screen this way-----------");
        screen.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(screen);
        add(confirmSeat);
        setSize(300,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	JButton button = (JButton) e.getSource();
    	button.setEnabled(false);    }
}
