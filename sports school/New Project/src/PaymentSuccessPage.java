import javax.swing.*;
import java.awt.*;

public class PaymentSuccessPage extends JFrame {
    public PaymentSuccessPage(int invoiceNumber, double totalCost) {
        setTitle("Payment Success");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel successLabel = new JLabel("Payment Successful");
        successLabel.setFont(new Font("Arial", Font.BOLD, 18));
        successLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(successLabel);

        JLabel invoiceLabel = new JLabel("Invoice Number: " + invoiceNumber);
        invoiceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(invoiceLabel);

        JLabel totalCostLabel = new JLabel("Total Cost: £" + totalCost);
        totalCostLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(totalCostLabel);

        add(panel);
    }
}
