import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CricketMembershipPage extends JFrame {
    public CricketMembershipPage() {
        setTitle("University Sports School Dashboard - Cricket");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        // Navigation Bar
        JPanel navPanel = new JPanel();
        navPanel.setBackground(new Color(10, 25, 50));
        navPanel.setBounds(0, 0, 1024, 80);
        navPanel.setLayout(null);

        JLabel titleLabel = new JLabel("Universities Sports School Dashboard");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setBounds(20, 20, 500, 30);
        navPanel.add(titleLabel);

        JButton logoutButton = new JButton("Log out");
        logoutButton.setBounds(900, 20, 100, 30);
        navPanel.add(logoutButton);
        add(navPanel);

        // Search Bar
        JTextField searchField = new JTextField("Search sports");
        searchField.setBounds(20, 100, 250, 30);
        add(searchField);

        JButton searchButton = new JButton("🔍");
        searchButton.setBounds(280, 100, 50, 30);
        add(searchButton);

        // Image Section
        JLabel imageLabel = new JLabel(new ImageIcon("cricket_image.jpg"));
        imageLabel.setBounds(20, 150, 400, 300);
        add(imageLabel);

        // Details Section
        JLabel titleLabel2 = new JLabel("Cricket");
        titleLabel2.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel2.setBounds(450, 150, 200, 30);
        add(titleLabel2);

        JLabel priceLabel = new JLabel("£40GBP");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        priceLabel.setForeground(new Color(0, 150, 0));
        priceLabel.setBounds(450, 190, 200, 30);
        add(priceLabel);

        JLabel durationLabel = new JLabel("Duration");
        durationLabel.setBounds(450, 230, 100, 20);
        add(durationLabel);

        String[] durationOptions = {"3 month", "6 month", "1 year"};
        JComboBox<String> durationDropdown = new JComboBox<>(durationOptions);
        durationDropdown.setBounds(450, 260, 200, 30);
        add(durationDropdown);

        JButton bookButton = new JButton("Book Now");
        bookButton.setBounds(450, 310, 200, 40);
        bookButton.setBackground(new Color(34, 120, 60));
        bookButton.setForeground(Color.WHITE);
        add(bookButton);

        // Link Book Now to Payment Page
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PaymentPage paymentPage = new PaymentPage();
                paymentPage.setVisible(true);
            }
        });


        // Membership Details
        JTextArea detailsArea = new JTextArea("Cricket Membership Details\n\n" +
                "Become a part of our cricketing community and enjoy exclusive benefits:\n" +
                "- Match Participation\n" +
                "- Practice Facilities\n" +
                "- Skill Development\n" +
                "- Exclusive Events\n" +
                "- Discounts on gear and tickets\n" +
                "- Community Engagement");
        detailsArea.setBounds(450, 370, 500, 150);
        detailsArea.setWrapStyleWord(true);
        detailsArea.setLineWrap(true);
        detailsArea.setEditable(false);
        add(detailsArea);

        // Previous and Next Buttons
        JButton previousButton = new JButton("← Previous");
        previousButton.setBounds(20, 600, 100, 40);
        add(previousButton);

        JButton nextButton = new JButton("Next →");
        nextButton.setBounds(900, 600, 100, 40);
        add(nextButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        new CricketMembershipPage();
    }
}
