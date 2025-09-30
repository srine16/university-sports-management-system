import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasketballPage extends JFrame {
    public BasketballPage() {
        setTitle("Universities Sports School Dashboard - Basketball");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Header Panel
        JPanel navPanel = new JPanel();
        navPanel.setBackground(new Color(10, 25, 65));
        navPanel.setBounds(0, 0, 900, 80);
        navPanel.setLayout(null);
        add(navPanel);

        JLabel titleLabel = new JLabel("Universities Sports School Dashboard");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setBounds(20, 20, 500, 30);
        navPanel.add(titleLabel);

        JButton logoutButton = new JButton("Log out");
        logoutButton.setBounds(780, 20, 100, 30);
        navPanel.add(logoutButton);

        // Search Bar
        JTextField searchField = new JTextField(" Search sports");
        searchField.setBounds(20, 90, 250, 30);
        add(searchField);

        JButton searchButton = new JButton("🔍");
        searchButton.setBounds(280, 90, 50, 30);
        add(searchButton);

        // Sports Navigation
        JPanel sportsNav = new JPanel();
        sportsNav.setBounds(350, 90, 500, 30);
        add(sportsNav);

        String[] sports = {"Gym Membership", "Indoor Sports", "Outdoor Sports", "Sports Membership", "Contract"};
        for (String sport : sports) {
            JButton button = new JButton(sport);
            sportsNav.add(button);
        }

        // Image Section
        JLabel imageLabel = new JLabel(new ImageIcon("basketball.jpg")); // Ensure correct image path
        imageLabel.setBounds(20, 140, 450, 350);
        add(imageLabel);

        // Details Panel
        JPanel detailsPanel = new JPanel();
        detailsPanel.setBounds(500, 140, 350, 350);
        detailsPanel.setBackground(new Color(15, 40, 80));
        detailsPanel.setLayout(null);
        add(detailsPanel);

        JLabel sportTitle = new JLabel("Basketball");
        sportTitle.setForeground(Color.WHITE);
        sportTitle.setFont(new Font("Arial", Font.BOLD, 22));
        sportTitle.setBounds(20, 20, 200, 30);
        detailsPanel.add(sportTitle);

        JLabel priceLabel = new JLabel("£10 GBP");
        priceLabel.setForeground(new Color(0, 255, 0));
        priceLabel.setFont(new Font("Arial", Font.BOLD, 18));
        priceLabel.setBounds(20, 60, 200, 30);
        detailsPanel.add(priceLabel);

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
        JTextArea detailsArea = new JTextArea(
            "🏀 Basketball Membership Details\n\n"
          + "Enjoy access to training resources, practice sessions,\n"
          + "discounts on gear, and play with fellow athletes.\n\n"
          + "📅 Start: 10th January, 2025\n"
          + "📅 End: 10th December, 2025\n"
          + "⏰ Time: Every Friday from 10 AM to 4 PM"
        );
        detailsArea.setBounds(20, 240, 300, 100);
        detailsArea.setFont(new Font("Arial", Font.PLAIN, 14));
        detailsArea.setForeground(Color.WHITE);
        detailsArea.setBackground(new Color(15, 40, 80));
        detailsArea.setEditable(false);
        detailsPanel.add(detailsArea);

        // Navigation Buttons
        JButton prevButton = new JButton("⬅ Previous");
        prevButton.setBounds(20, 520, 120, 30);
        add(prevButton);

        JButton nextButton = new JButton("Next ➡");
        nextButton.setBounds(750, 520, 120, 30);
        add(nextButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BasketballPage().setVisible(true));
    }
}
