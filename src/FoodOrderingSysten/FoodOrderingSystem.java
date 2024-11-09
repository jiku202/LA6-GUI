package FoodOrderingSysten;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodOrderingSystem {
    private JPanel Jpanel;
    private JCheckBox cSundae;
    private JCheckBox cPizza;
    private JCheckBox cTea;
    private JCheckBox cSoftDrinks;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JRadioButton rbNone;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;
    private JButton btnOrder;
    private ButtonGroup discountGroup;

    public FoodOrderingSystem() {
        // Set up button group for discounts
        discountGroup = new ButtonGroup();
        discountGroup.add(rbNone);
        discountGroup.add(rb5);
        discountGroup.add(rb10);
        discountGroup.add(rb15);

        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTotal();
            }
        });
    }

    private void calculateTotal() {
        // Prices of each item
        int pizzaPrice = 100;
        int burgerPrice = 80;
        int friesPrice = 65;
        int softDrinksPrice = 55;
        int teaPrice = 50;
        int sundaePrice = 40;

        int subtotal = 0;
        if (cPizza.isSelected()) subtotal += pizzaPrice;
        if (cBurger.isSelected()) subtotal += burgerPrice;
        if (cFries.isSelected()) subtotal += friesPrice;
        if (cSoftDrinks.isSelected()) subtotal += softDrinksPrice;
        if (cTea.isSelected()) subtotal += teaPrice;
        if (cSundae.isSelected()) subtotal += sundaePrice;

        // Determine discount percentage
        double discount = 0.0;
        if (rb5.isSelected()) {
            discount = 0.05;
        } else if (rb10.isSelected()) {
            discount = 0.10;
        } else if (rb15.isSelected()) {
            discount = 0.15;
        }

        double total = subtotal - (subtotal * discount);

        JOptionPane.showMessageDialog(Jpanel, "Total Amount: " + total, "Order Summary", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Food Ordering System");
        frame.setContentPane(new FoodOrderingSystem().Jpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
