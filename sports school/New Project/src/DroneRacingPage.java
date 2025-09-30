import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DroneRacingPage extends JFrame {
    public DroneRacingPage() {
        setTitle("Universities Sports School Dashboard - Drone Racing");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Top Panel (Dark Blue)
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(10, 25, 50));
        topPanel.setBounds(0, 0, 1000, 80);
        topPanel.setLayout(null);
        add(topPanel);

        JLabel titleLabel = new JLabel("Universities Sports School Dashboard");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(20, 10, 400, 30);
        topPanel.add(titleLabel);

        JLabel subTitle = new JLabel("University Management System");
        subTitle.setForeground(Color.LIGHT_GRAY);
        subTitle.setFont(new Font("Arial", Font.PLAIN, 14));
        subTitle.setBounds(20, 40, 300, 20);
        topPanel.add(subTitle);

        // Search Bar
        JTextField searchField = new JTextField("Search sports");
        searchField.setBounds(600, 20, 200, 30);
        topPanel.add(searchField);

        JButton searchButton = new JButton("🔍");
        searchButton.setBounds(810, 20, 50, 30);
        topPanel.add(searchButton);

        // Logout Button
        JButton logoutButton = new JButton("Log out");
        logoutButton.setBounds(880, 20, 80, 30);
        topPanel.add(logoutButton);

        // Navigation Panel
        JPanel navPanel = new JPanel();
        navPanel.setBackground(Color.WHITE);
        navPanel.setBounds(0, 80, 1000, 50);
        navPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        add(navPanel);

        String[] menuItems = {"Gym Membership", "Indoor Sports", "Outdoor Sports", "Sports Membership", "Contract"};
        for (String item : menuItems) {
            JButton button = new JButton(item);
            button.setForeground(Color.BLACK);
            navPanel.add(button);
        }

        // Main Content Panel
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(new Color(15, 35, 70));
        contentPanel.setBounds(0, 130, 1000, 570);
        contentPanel.setLayout(null);
        add(contentPanel);

        // Image
        JLabel imageLabel = new JLabel(new ImageIcon("drone_racing.jpg"));
        imageLabel.setBounds(20, 20, 400, 300);
        contentPanel.add(imageLabel);

        // Title
        JLabel sportTitle = new JLabel("Drone Racing");
        sportTitle.setForeground(Color.WHITE);
        sportTitle.setFont(new Font("Arial", Font.BOLD, 18));
        sportTitle.setBounds(450, 20, 200, 30);
        contentPanel.add(sportTitle);

        // Price
        JLabel priceLabel = new JLabel("£45 GBP");
        priceLabel.setForeground(new Color(0, 255, 0));
        priceLabel.setFont(new Font("Arial", Font.BOLD, 22));
        priceLabel.setBounds(450, 50, 200, 30);
        contentPanel.add(priceLabel);

        // Dropdown for Duration
        String[] durations = {"3 months", "6 months", "1 year"};
        JComboBox<String> durationBox = new JComboBox<>(durations);
        durationBox.setBounds(450, 90, 200, 30);
        contentPanel.add(durationBox);

        // Book Now Button
        JButton bookButton = new JButton("Book Now");
        bookButton.setBounds(450, 130, 200, 40);
        bookButton.setBackground(new Color(34, 120, 60));
        bookButton.setForeground(Color.WHITE);
        contentPanel.add(bookButton);

        // Book Now Action
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PaymentPage paymentPage = new PaymentPage();
                paymentPage.setVisible(true);
            }
        });

        // Membership Details Panel
        JTextArea detailsArea = new JTextArea("🏆 Drone Racing Membership Details\n\n"
                + "Enjoy priority race access, training resources, and discounts!\n"
                + "📅 Start: 10th January, 2025\n"
                + "📅 End: 10th December, 2025");
        detailsArea.setBounds(450, 190, 400, 120);
        detailsArea.setFont(new Font("Arial", Font.PLAIN, 14));
        detailsArea.setForeground(Color.BLACK);
        detailsArea.setBackground(Color.WHITE);
        detailsArea.setEditable(false);
        contentPanel.add(detailsArea);

        // Previous & Next Buttons
        JButton prevButton = new JButton("⬅ Previous");
        prevButton.setBounds(20, 500, 100, 40);
        contentPanel.add(prevButton);

        JButton nextButton = new JButton("Next ➡");
        nextButton.setBounds(880, 500, 100, 40);
        contentPanel.add(nextButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DroneRacingPage().setVisible(true));
    }
}
