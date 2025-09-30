import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PaymentPage extends JFrame {
    private JTextField cardHolderName, location, postCode, cardNumber, cvcNumber;
    private JComboBox<String> paymentMethodBox;
    private JCheckBox studentDiscountCheckBox;
    private JLabel totalCostLabel;
    private double totalCost = 10.0;
    private boolean isStudentBookingRestricted = false;

    public PaymentPage() {
        setTitle("Payment Methods - Universities Sports School Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(15, 32, 64));
        headerPanel.setBounds(0, 0, 800, 80);
        headerPanel.setLayout(null);
        add(headerPanel);

        JLabel titleLabel = new JLabel("Universities Sports School Dashboard");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBounds(20, 20, 400, 30);
        headerPanel.add(titleLabel);

        JButton logoutButton = new JButton("Log out");
        logoutButton.setBounds(680, 20, 80, 30);
        headerPanel.add(logoutButton);

        JLabel paymentLabel = new JLabel("Payment Methods");
        paymentLabel.setFont(new Font("Arial", Font.BOLD, 18));
        paymentLabel.setBounds(320, 100, 200, 30);
        add(paymentLabel);

        JLabel nameLabel = new JLabel("Card Holder Full Name:");
        nameLabel.setBounds(200, 150, 150, 25);
        add(nameLabel);

        cardHolderName = new JTextField();
        cardHolderName.setBounds(350, 150, 200, 25);
        add(cardHolderName);

        JLabel locationLabel = new JLabel("Location:");
        locationLabel.setBounds(200, 190, 150, 25);
        add(locationLabel);

        location = new JTextField();
        location.setBounds(350, 190, 200, 25);
        add(location);

        JLabel postCodeLabel = new JLabel("Post Code:");
        postCodeLabel.setBounds(200, 230, 150, 25);
        add(postCodeLabel);

        postCode = new JTextField();
        postCode.setBounds(350, 230, 200, 25);
        add(postCode);

        JLabel paymentMethodLabel = new JLabel("Payment Method:");
        paymentMethodLabel.setBounds(200, 270, 150, 25);
        add(paymentMethodLabel);

        String[] paymentOptions = {"Select", "MasterCard", "Debit Card", "Credit Card", "PayPal"};
        paymentMethodBox = new JComboBox<>(paymentOptions);
        paymentMethodBox.setBounds(350, 270, 200, 25);
        add(paymentMethodBox);

        JLabel cardNumberLabel = new JLabel("Card Number:");
        cardNumberLabel.setBounds(200, 310, 150, 25);
        add(cardNumberLabel);

        cardNumber = new JTextField();
        cardNumber.setBounds(350, 310, 200, 25);
        add(cardNumber);

        JLabel cvcLabel = new JLabel("CVC Number:");
        cvcLabel.setBounds(200, 350, 150, 25);
        add(cvcLabel);

        cvcNumber = new JTextField();
        cvcNumber.setBounds(350, 350, 200, 25);
        add(cvcNumber);

        studentDiscountCheckBox = new JCheckBox("Are you a student? (20% Discount)");
        studentDiscountCheckBox.setBounds(350, 380, 250, 25);
        add(studentDiscountCheckBox);

        studentDiscountCheckBox.addActionListener(e -> updateTotalCost());

        totalCostLabel = new JLabel("Total Cost: £" + totalCost);
        totalCostLabel.setBounds(350, 420, 200, 25);
        add(totalCostLabel);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(250, 450, 100, 30);
        add(cancelButton);

        JButton processedButton = new JButton("Processed");
        processedButton.setBounds(400, 450, 100, 30);
        add(processedButton);

        processedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (studentDiscountCheckBox.isSelected() && isStudentBookingRestricted) {
                    JOptionPane.showMessageDialog(null, "Students are not allowed for double booking. One sport, one booking.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (validateFields()) {
                    int invoiceNumber = new Random().nextInt(900000) + 100000;
                    new PaymentSuccessPage(invoiceNumber, totalCost).setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter valid payment details.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JLabel restrictionLabel = new JLabel("Students are not allowed for double booking. One sport, one booking.");
        restrictionLabel.setBounds(200, 500, 400, 25);
        restrictionLabel.setForeground(Color.RED);
        add(restrictionLabel);
    }

    private void updateTotalCost() {
        if (studentDiscountCheckBox.isSelected()) {
            totalCost = 10.0 * 0.8;
            isStudentBookingRestricted = true;
        } else {
            totalCost = 10.0;
            isStudentBookingRestricted = false;
        }
        totalCostLabel.setText("Total Cost: £" + totalCost);
    }

    private boolean validateFields() {
        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PaymentPage().setVisible(true));
    }
}