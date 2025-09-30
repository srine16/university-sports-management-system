import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class backup extends JFrame {
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel centerPanel;
    private Color navyBlue = new Color(14, 31, 72);
    private Color lightGray = new Color(240, 240, 240);
    private Font mainFont = new Font("Segoe UI", Font.PLAIN, 14);
    private JTextField searchField;

    public backup() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Universities Sports School Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(navyBlue);

        createTopNav();
        createMainContent();

        add(mainPanel);
    }

    private void createTopNav() {
        JPanel topNav = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        topNav.setBackground(navyBlue);

        JLabel titleLabel = new JLabel("Universities Sports School Dashboard");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        topNav.add(titleLabel);

        JButton joinNowButton = createStyledButton("Join Now", Color.WHITE, navyBlue);
        joinNowButton.addActionListener(e -> openLoginPage());
        topNav.add(joinNowButton);

        // Search bar
        searchField = new JTextField(15);
        topNav.add(searchField);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> performSearch());
        topNav.add(searchButton);

        JButton paymentBtn = createStyledButton("Payment", Color.WHITE, navyBlue);
        JButton membershipBtn = createStyledButton("Membership", Color.WHITE, navyBlue);
        JButton sportsDBBtn = createStyledButton("SportsDB", Color.WHITE, navyBlue);

        topNav.add(paymentBtn);
        topNav.add(membershipBtn);
        topNav.add(sportsDBBtn);

        mainPanel.add(topNav, BorderLayout.NORTH);
    }

    private void createMainContent() {
        JPanel contentPanel = new JPanel(new BorderLayout());

        leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBackground(navyBlue);
        leftPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        String[] universities = {"Oxford University", "Cambridge University", "University of Bath", "University of Manchester", "Harvard University", "Stanford University", "MIT", "Yale University", "Princeton University", "University of Toronto", "University of Melbourne", "National University of Singapore"};
        for (String uni : universities) {
            JButton uniButton = createUniversityButton(uni);
            leftPanel.add(uniButton);
            leftPanel.add(Box.createVerticalStrut(10));
        }

        centerPanel = new JPanel(new GridLayout(2, 3, 20, 20));
        centerPanel.setBackground(Color.WHITE);

        contentPanel.add(leftPanel, BorderLayout.WEST);
        contentPanel.add(centerPanel, BorderLayout.CENTER);

        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton previousButton = createStyledButton("Previous", navyBlue, Color.WHITE);
        JButton nextButton = createStyledButton("Next", navyBlue, Color.WHITE);
        footerPanel.add(previousButton);
        footerPanel.add(nextButton);

        mainPanel.add(contentPanel, BorderLayout.CENTER);
        mainPanel.add(footerPanel, BorderLayout.SOUTH);
    }

    private void openLoginPage() {
        new LoginPage().setVisible(true);
        this.dispose();
    }

    private void performSearch() throws SQLException {
        String searchText = searchField.getText().trim();

        if (searchText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a sport to search.");
            return;
        }

        System.out.println("Performing search for: " + searchText);
		ResultSet rs = DatabaseConnection.ReadFromDB(searchText);
		displaySearchResults(rs);
    }

    private void displaySearchResults(ResultSet rs) {
        if (rs == null) {
            JOptionPane.showMessageDialog(this, "No results found or database error.");
            return;
        }

        centerPanel.removeAll();
        try {
            boolean found = false;
            while (rs.next()) {
                found = true;
                String sportName = rs.getString("Sports Activities");
                String price = rs.getString("Price Per Hour");
                centerPanel.add(createSportCard(sportName, price));
            }

            if (!found) {
                JOptionPane.showMessageDialog(this, "No matching sports found.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error displaying results.");
        }
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    private JButton createStyledButton(String text, Color fg, Color bg) {
        JButton button = new JButton(text);
        button.setForeground(fg);
        button.setBackground(bg);
        button.setFont(mainFont);
        return button;
    }

    private JButton createUniversityButton(String university) {
        JButton button = new JButton(university);
        button.setFont(mainFont);
        button.setBackground(lightGray);
        button.setForeground(navyBlue);
        button.setFocusPainted(false);
        return button;
    }

    private JPanel createSportCard(String sportName, String price) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel sportLabel = new JLabel(sportName);
        sportLabel.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel priceLabel = new JLabel(price);
        priceLabel.setFont(new Font("Arial", Font.PLAIN, 12));

        panel.add(sportLabel, BorderLayout.NORTH);
        panel.add(priceLabel, BorderLayout.CENTER);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SportsDashboard().setVisible(true));
    }
}

class DatabaseConnection {
    private static final String DB_PATH = "C:\\Users\\sunji\\OneDrive\\Desktop\\Group Project-B-all-Files\\GP2.db";

    public static Connection connect() {
        try {
            String url = "jdbc:sqlite:" + DB_PATH;
            Connection conn = DriverManager.getConnection(url);
            System.out.println("✅ Database connection successful.");
            return conn;
        } catch (SQLException e) {
            System.err.println("❌ Database connection failed: " + e.getMessage());
            return null;
        }
    }

    public static ResultSet ReadFromDB(String input) {
        Connection conn = connect();
        if (conn == null) {
            System.err.println("❌ Connection is null. Check database path.");
            return null;
        }

        String sql = "SELECT * FROM SPORTS WHERE `Sports Activities` LIKE ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + input + "%");
            return pstmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("❌ SQL query failed: " + e.getMessage());
            return null;
        }
    }
}
