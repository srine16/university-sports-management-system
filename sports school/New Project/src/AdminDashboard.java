import javax.swing.*;
import java.awt.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class AdminDashboard extends JFrame {
    public AdminDashboard() {
        setTitle("Universities Sports School Dashboard");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(10, 30, 60));

        // Header Panel
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(10, 30, 60));

        JLabel headerLabel = new JLabel("Universities Sports School Dashboard", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 22));
        headerLabel.setForeground(Color.WHITE);

        JLabel subHeaderLabel = new JLabel("University Management System", JLabel.CENTER);
        subHeaderLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        subHeaderLabel.setForeground(Color.WHITE);

        JPanel titlePanel = new JPanel(new GridLayout(2, 1));
        titlePanel.setBackground(new Color(10, 30, 60));
        titlePanel.add(headerLabel);
        titlePanel.add(subHeaderLabel);

        headerPanel.add(titlePanel, BorderLayout.CENTER);
        panel.add(headerPanel, BorderLayout.NORTH);

        // Navigation Bar with Search
        JPanel navPanel = new JPanel();
        navPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        navPanel.setBackground(Color.WHITE);

        JTextField searchField = new JTextField("Search sports", 20);
        JButton searchButton = new JButton("🔍"); // Search icon placeholder

        navPanel.add(searchField);
        navPanel.add(searchButton);

        String[] menuItems = {"Membership data list", "New Events", "Events overview", "Staff Member"};
        for (String item : menuItems) {
            JButton button = new JButton(item);
            button.setFocusPainted(false);
            button.setBackground(new Color(240, 240, 240));
            navPanel.add(button);
        }

        panel.add(navPanel, BorderLayout.CENTER);

        // Create Chart Panel
        JFreeChart barChart = createChart();
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(700, 400));

        // Center Panel for Chart
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBackground(new Color(10, 30, 60));

        JLabel chartTitle = new JLabel("USSD Booking System", JLabel.CENTER);
        chartTitle.setFont(new Font("Arial", Font.BOLD, 18));
        chartTitle.setForeground(Color.WHITE);

        centerPanel.add(chartTitle, BorderLayout.NORTH);
        centerPanel.add(chartPanel, BorderLayout.CENTER);

        panel.add(centerPanel, BorderLayout.SOUTH);

        add(panel);
    }

    private JFreeChart createChart() {
        CategoryDataset dataset = createDataset();
        return ChartFactory.createBarChart(
                "USSD", "Sports", "Percentage", dataset);
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(10, "Series1", "Cricket");
        dataset.addValue(25, "Series1", "Football");
        dataset.addValue(35, "Series1", "Basketball");
        dataset.addValue(50, "Series1", "Drone Racing");
        dataset.addValue(75, "Series1", "Gliding");
        dataset.addValue(85, "Series1", "Base Jumping");

        dataset.addValue(5, "Series2", "Cricket");
        dataset.addValue(15, "Series2", "Football");
        dataset.addValue(30, "Series2", "Basketball");
        dataset.addValue(45, "Series2", "Drone Racing");
        dataset.addValue(70, "Series2", "Gliding");
        dataset.addValue(80, "Series2", "Base Jumping");

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AdminDashboard frame = new AdminDashboard();
            frame.setVisible(true);
        });
    }
}
