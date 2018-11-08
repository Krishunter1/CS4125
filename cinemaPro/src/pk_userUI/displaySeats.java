package pk_userUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class displaySeats extends Frame {
    JButton[] buttons;
    JButton confirmSeat;
    public displaySeats(){
        this.displayFrame();
    }
    @Override
    void displayFrame() {
        setTitle("Select Seats");
        buttons = new JButton[50];
        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,10));
        for(int i = 0; i < 50; i++){
            buttons[i] = new JButton();
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }
        add(panel, BorderLayout.NORTH);
        JPanel panel2 = new JPanel();
        confirmSeat = new JButton("Confirm Seats");
        panel2.setLayout(new BorderLayout());
        panel2.add(new JLabel("----------screen this way-----------"), BorderLayout.NORTH);
        panel2.add(confirmSeat, BorderLayout.CENTER);
        add(panel2,BorderLayout.CENTER);
        setSize(300,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
