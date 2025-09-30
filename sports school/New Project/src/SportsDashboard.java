import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.List;

public class SportsDashboard extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel centerPanel;
    private Color navyBlue = new Color(14, 31, 72);
    private Color lightGray = new Color(240, 240, 240);
    private Font mainFont = new Font("Segoe UI", Font.PLAIN, 14);
    private JTextField searchField;

    public SportsDashboard() {
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

        searchField = new JTextField(15);
        topNav.add(searchField);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> {
			try {
				performSearch();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
        topNav.add(searchButton);

        JButton paymentBtn = createStyledButton("Payment", Color.WHITE, navyBlue);
        JButton membershipBtn = createStyledButton("Membership", Color.WHITE, navyBlue);
        JButton sportsDBBtn = createStyledButton("SportsDB", Color.WHITE, navyBlue);

        // Open pop-up when "SportsDB" is clicked
        sportsDBBtn.addActionListener(e -> showSportsDBPopup());

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

        String[] universities = {"Oxford University", "Cambridge University", "University of Bath", "University of Manchester",
                "University of London", "University of Greenwich", "London Matropolitan", "University of Bath", "Brunel University London",
                "University of Cardiff", "University of Edinburgh", "Queens University of Belafst"};

        for (String uni : universities) {
            JButton uniButton = createUniversityButton(uni);
            leftPanel.add(uniButton);
            leftPanel.add(Box.createVerticalStrut(10));
        }

        JPanel universityPanel = new JPanel();
        universityPanel.setBorder(BorderFactory.createTitledBorder("Partner Universities"));
        universityPanel.add(new JLabel(new ImageIcon("university_logos.jpg"))); // Placeholder for logos

        centerPanel = new JPanel(new GridLayout(2, 3, 20, 20));
        centerPanel.setBackground(Color.WHITE);

        Object[][] sportsData = {
                {"Drone Racing", "£50/HR"},
                {"Basketball", "£35/HR"},
                {"Gliding", "£60/HR"},
                {"BMX Jumping", "£45/HR"},
                {"Cricket", "£45/HR"},
                {"Football", "£35/HR"}
        };

        for (Object[] sport : sportsData) {
            centerPanel.add(createSportCard((String) sport[0], (String) sport[1]));
        }

        contentPanel.add(leftPanel, BorderLayout.WEST);
        contentPanel.add(universityPanel, BorderLayout.NORTH);
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

    private void showSportsDBPopup() {
        // Create the dialog
        JDialog dialog = new JDialog(this, "Sports Database", true);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(this);

        // Create table model and table
        String[] columnNames = {"Sports Activities"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        
        // Fetch sports data from database
        List<String> sportsList = GroupProject2.ReadFromDB();

        // Populate table
        for (String activity : sportsList) {
            tableModel.addRow(new Object[]{activity});
        }

        // Add components to the dialog
        dialog.add(scrollPane, BorderLayout.CENTER);

        // Show the dialog
        dialog.setVisible(true);
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

        ResultSet rs = DatabaseConnection.ReadFromDB(searchText);
		displaySearchResults(rs);
    }

    private void displaySearchResults(ResultSet rs) {
        try {
            while (rs.next()) {
                String activity = rs.getString("Sports Activities");
                String price = rs.getString("Price Per Hour");
                System.out.println("Found result: " + activity + " - " + price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error displaying results.");
        }
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
