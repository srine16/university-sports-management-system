import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame {
    public Dashboard() {
        setTitle("University Sports School Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Header Panel
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

        // Membership Buttons
        String[] sports = {"Cricket", "Drone Racing", "Football", "Basketball", "Base Jumping", "Gliding"};
        Class<?>[] pages = {CricketMembershipPage.class, DroneRacingPage.class, FootballMembershipPage.class, 
                            BasketballPage.class, BaseJumpingMembershipPage.class, GlidingMembershipPage.class};

        int yPosition = 120;
        for (int i = 0; i < sports.length; i++) {
            JButton button = new JButton(sports[i] + " Membership");
            button.setBounds(300, yPosition, 200, 40);
            add(button);
            
            final Class<?> pageClass = pages[i];
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        JFrame page = (JFrame) pageClass.getDeclaredConstructor().newInstance();
                        page.setVisible(true);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
            yPosition += 60;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Dashboard().setVisible(true));
    }
}
