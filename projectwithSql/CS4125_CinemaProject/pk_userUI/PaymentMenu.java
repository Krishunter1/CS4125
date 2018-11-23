package pk_userUI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pk_controller.UIController;
import pk_payments.PaymentController;

public class PaymentMenu extends Frame{

	private String[] options = {"PayPal", "Credit Card", "Debit Card"};
	private JComboBox paymentMethod;
	private JButton confirm;
	private String selected;
	private JLabel priceHeader;
	private JLabel price;
	private double cost;
	private String priceDes;
	private PaymentController pc;
	public PaymentMenu(UIController object) {
		ui = object;
		cost = ui.getTicketPrice("Adult",ui.getSelectedDate());
		priceDes = ui.getTicketDes("Adult",ui.getSelectedDate());
		displayFrame();
		pc= new PaymentController();
	}
	
	@Override
	void displayFrame() {
		paymentMethod = new JComboBox(options);
		JLabel amount = new JLabel("amount");
		confirm = new JButton("Confirm");
		priceHeader = new JLabel("The cost of a " + priceDes);
		price = new JLabel("$" + cost);
		paymentMethod.addActionListener(this);
		confirm.addActionListener(this);
		setTitle("New Booking");
        setLayout(new GridBagLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        priceHeader.setAlignmentX(Component.CENTER_ALIGNMENT);
        price.setAlignmentX(Component.CENTER_ALIGNMENT);
        paymentMethod.setAlignmentX(Component.CENTER_ALIGNMENT);
        amount.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirm.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(priceHeader);
        panel.add(Box.createRigidArea(new Dimension(0,25)));
        panel.add(price);
        panel.add(Box.createRigidArea(new Dimension(0,25)));
        panel.add(paymentMethod);
        panel.add(Box.createRigidArea(new Dimension(0,25)));
        panel.add(amount);
        panel.add(Box.createRigidArea(new Dimension(0,25)));
        panel.add(confirm);
        add(panel);
        setSize(300,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object button = e.getSource();
		if(button == paymentMethod) {
        	selected = paymentMethod.getSelectedItem().toString();
        	}
		if(button == confirm) {
			if(pc.processPayment(selected)){
				ui.addBooking(selected);
				System.out.print("Booking");
				dispose();
				ui.displayUserMenu(2);
				
			}
		}
	
	}


}
