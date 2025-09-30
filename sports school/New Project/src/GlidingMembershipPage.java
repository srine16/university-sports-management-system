import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GlidingMembershipPage extends JFrame {
    public GlidingMembershipPage() {
        setTitle("Universities Sports School Dashboard - Gliding");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(10, 25, 50));
        headerPanel.setBounds(0, 0, 1000, 80);
        headerPanel.setLayout(null);
        add(headerPanel);

        JLabel titleLabel = new JLabel("Universities Sports School Dashboard");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(20, 15, 400, 30);
        headerPanel.add(titleLabel);

        JButton logoutButton = new JButton("Log out");
        logoutButton.setBounds(870, 20, 100, 30);
        headerPanel.add(logoutButton);

        // Search Bar
        JTextField searchField = new JTextField(" Search sports");
        searchField.setBounds(20, 90, 300, 30);
        add(searchField);

        // Navigation Menu
        JPanel navPanel = new JPanel();
        navPanel.setBounds(340, 90, 600, 30);
        navPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
        add(navPanel);

        String[] menuItems = {"Gym Membership", "Indoor Sports", "Outdoor Sports", "Sports Membership", "Contract"};
        for (String item : menuItems) {
            JButton btn = new JButton(item);
            navPanel.add(btn);
        }

        // Image Section
        JLabel imageLabel = new JLabel(new ImageIcon("gliding.jpg")); // Ensure correct image path
        imageLabel.setBounds(20, 140, 450, 400);
        add(imageLabel);

        // Details Panel
        JPanel detailsPanel = new JPanel();
        detailsPanel.setBounds(500, 140, 450, 400);
        detailsPanel.setBackground(new Color(15, 40, 80));
        detailsPanel.setLayout(null);
        add(detailsPanel);
        
        JLabel title = new JLabel("Gliding");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(20, 20, 200, 30);
        detailsPanel.add(title);

        JLabel priceTag = new JLabel("£35 GBP");
        priceTag.setForeground(new Color(0, 255, 0));
        priceTag.setFont(new Font("Arial", Font.BOLD, 22));
        priceTag.setBounds(20, 60, 200, 30);
        detailsPanel.add(priceTag);

        JLabel durationLabel = new JLabel("Duration:");
        durationLabel.setForeground(Color.WHITE);
        durationLabel.setBounds(20, 100, 100, 20);
        detailsPanel.add(durationLabel);

        JComboBox<String> durationDropdown = new JComboBox<>(new String[]{"3 months", "6 months", "1 year"});
        durationDropdown.setBounds(20, 130, 200, 30);
        detailsPanel.add(durationDropdown);

        JButton bookNowButton = new JButton("Book Now");
        bookNowButton.setBounds(20, 180, 200, 40);
        bookNowButton.setBackground(new Color(34, 120, 60));
        bookNowButton.setForeground(Color.WHITE);
        detailsPanel.add(bookNowButton);

        // Book Now Action
        bookNowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PaymentPage paymentPage = new PaymentPage();
                paymentPage.setVisible(true);
            }
        });

        // Membership Details
        JTextArea detailsText = new JTextArea(
            "✈️ Gliding Membership Details\n\n"
          + "Enjoy gliding lessons, training resources, and discounts on gear.\n"
          + "Open to all skill levels—sign up today!\n\n"
          + "📅 Start: 10th January, 2025\n"
          + "📅 End: 10th December, 2025\n"
          + "⏰ Time: Every Friday from 10 AM to 4 PM"
        );
        detailsText.setBounds(20, 240, 400, 120);
        detailsText.setFont(new Font("Arial", Font.PLAIN, 14));
        detailsText.setForeground(Color.WHITE);
        detailsText.setBackground(new Color(15, 40, 80));
        detailsText.setEditable(false);
        detailsPanel.add(detailsText);

        // Navigation Buttons
        JButton previousButton = new JButton("⬅ Previous");
        previousButton.setBounds(20, 580, 100, 30);
        add(previousButton);

        JButton nextButton = new JButton("Next ➡");
        nextButton.setBounds(870, 580, 100, 30);
        add(nextButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GlidingMembershipPage().setVisible(true));
    }
}
