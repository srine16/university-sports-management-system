import javax.swing.*;
import java.awt.*;

public class MembershipPage extends JFrame {
    public MembershipPage() {
        // Set frame properties
        setTitle("Membership - Universities Sports School Dashboard");
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
        
        // Membership Label
        JLabel membershipLabel = new JLabel("Membership");
        membershipLabel.setFont(new Font("Arial", Font.BOLD, 18));
        membershipLabel.setBounds(340, 100, 200, 30);
        add(membershipLabel);
        
        // Form Elements
        String[] labels = {"Title", "First Name", "Surname", "Email Address", "Present Address", "Post Code", "Education Level"};
        int yPosition = 150;
        
        for (String label : labels) {
            JLabel fieldLabel = new JLabel(label + ":");
            fieldLabel.setBounds(200, yPosition, 150, 25);
            add(fieldLabel);
            
            JTextField textField = new JTextField();
            textField.setBounds(350, yPosition, 200, 25);
            add(textField);
            
            yPosition += 40;
        }
        
        // Student Discount Checkbox
        JCheckBox studentCheckBox = new JCheckBox("I am a student and eligible for a 20% discount");
        studentCheckBox.setBounds(200, yPosition, 300, 30);
        add(studentCheckBox);
        
        yPosition += 40;
        
        // Buttons
        JButton saveButton = new JButton("Save");
        saveButton.setBounds(250, 450, 100, 30);
        add(saveButton);
        
        JButton continueButton = new JButton("Continue");
        continueButton.setBounds(400, 450, 100, 30);
        add(continueButton);
        
        // Action listener for the "Continue" button
        continueButton.addActionListener(e -> {
            boolean isStudent = studentCheckBox.isSelected();
            if (isStudent) {
                JOptionPane.showMessageDialog(this, "You are eligible for a 20% student discount!");
            } else {
                JOptionPane.showMessageDialog(this, "No student discount applied.");
            }
        });
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MembershipPage().setVisible(true);
        });
    }
}
