package pk_userUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class displayMovies extends Frame {
    JComboBox selectMovie;
    JComboBox selectTime;
    JButton viewSeats = new JButton("view seats");

    public displayMovies(){
        displayFrame();
    }
    @Override
    void displayFrame() {
        selectMovie = new JComboBox();
        selectTime = new JComboBox();
        selectMovie.addActionListener(this);
        selectTime.addActionListener(this);
        viewSeats.addActionListener(this);
        setTitle("New Booking");
        setLayout(new GridBagLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        selectMovie.setAlignmentX(Component.CENTER_ALIGNMENT);
        selectTime.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewSeats.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(selectMovie);
        panel.add(Box.createRigidArea(new Dimension(0,25)));
        panel.add(selectTime);
        panel.add(Box.createRigidArea(new Dimension(0,25)));
        panel.add(viewSeats);
        add(panel);
        setSize(300,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object getButton = e.getSource();
        if(getButton == viewSeats) {
            displaySeats seats = new displaySeats();
        }
    }
}
