import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JCheckBox termsCheckbox;

    public LoginPage() {
        setTitle("Universities Sports School Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Create main panel with GridBagLayout for better control
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        // Header Panel
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        headerPanel.setBackground(new Color(19, 35, 64));
        ImageIcon logoIcon = new ImageIcon("path_to_your_logo.png"); // Add your logo path
        JLabel logoLabel = new JLabel(logoIcon);
        JLabel titleLabel = new JLabel("Universities Sports School Dashboard");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(logoLabel);
        headerPanel.add(titleLabel);
        gbc.gridwidth = 2;  // Span two columns for header
        gbc.gridy = 0; // First row
        mainPanel.add(headerPanel, gbc);

        // Get Started Section
        JLabel getStartedLabel = new JLabel("Get Started");
        getStartedLabel.setFont(new Font("Arial", Font.BOLD, 24));
        getStartedLabel.setForeground(new Color(21, 71, 42));
        gbc.gridy = 1;  // Second row
        mainPanel.add(getStartedLabel, gbc);

        JLabel welcomeLabel = new JLabel("Welcome to USSD- Let's create your account");
        welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        welcomeLabel.setForeground(Color.GRAY);
        gbc.gridy = 2;  // Third row
        mainPanel.add(welcomeLabel, gbc);

        // Form Panel (Email and Password Fields)
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(Color.WHITE);

        // Email Field
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        emailLabel.setForeground(new Color(19, 35, 64));
        emailField = new JTextField(20);
        emailField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        emailField.setFont(new Font("Arial", Font.PLAIN, 14));
        emailField.setBackground(Color.WHITE);
        emailField.setBorder(BorderFactory.createLineBorder(new Color(19, 35, 64), 2));
        emailField.setPreferredSize(new Dimension(250, 40));
        emailField.setCaretColor(new Color(19, 35, 64)); // Change the caret (text cursor) color
        formPanel.add(emailLabel);
        formPanel.add(emailField);

        // Password Field
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordLabel.setForeground(new Color(19, 35, 64));
        passwordField = new JPasswordField(20);
        passwordField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField.setBackground(Color.WHITE);
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(19, 35, 64), 2));
        passwordField.setPreferredSize(new Dimension(250, 40));
        passwordField.setCaretColor(new Color(19, 35, 64)); // Change the caret (text cursor) color
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);

        // Forgot Password Link
        JLabel forgotPasswordLabel = new JLabel("Forgot Password?");
        forgotPasswordLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        forgotPasswordLabel.setForeground(Color.BLUE);
        forgotPasswordLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        forgotPasswordLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        forgotPasswordLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO: Implement forgot password logic
                System.out.println("Navigate to Forgot Password page");
            }
        });
        formPanel.add(forgotPasswordLabel);

        // Terms Checkbox
        termsCheckbox = new JCheckBox("I agree to the terms and conditions");
        termsCheckbox.setBackground(Color.WHITE);
        formPanel.add(termsCheckbox);

        // Create Sign In and Create Account Buttons
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton signInButton = new JButton("Sign In");
        signInButton.setBackground(new Color(21, 71, 42)); // Dark green
        signInButton.setForeground(Color.WHITE);
        signInButton.setPreferredSize(new Dimension(200, 40));
        signInButton.setFont(new Font("Arial", Font.BOLD, 14));
        buttonsPanel.add(signInButton);

        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.setBackground(new Color(21, 71, 42)); // Dark green
        createAccountButton.setForeground(Color.WHITE);
        createAccountButton.setPreferredSize(new Dimension(200, 40));
        createAccountButton.setFont(new Font("Arial", Font.BOLD, 14));
        buttonsPanel.add(createAccountButton);

        formPanel.add(buttonsPanel);

        // Social Login Section (Centered and minimalist)
        JPanel socialButtonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        socialButtonsPanel.setBackground(Color.WHITE);
        JButton appleButton = createSocialButton("Sign in with Apple");
        JButton googleButton = createSocialButton("Sign in with Google");
        JButton outlookButton = createSocialButton("Sign in with Outlook");

        socialButtonsPanel.add(appleButton);
        socialButtonsPanel.add(googleButton);
        socialButtonsPanel.add(outlookButton);

        // Sign In Link Section
        JPanel signInPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        signInPanel.setBackground(Color.WHITE);
        JLabel accountLabel = new JLabel("Already Have an account? ");
        JLabel signInLink = new JLabel("Sign in");
        signInLink.setForeground(Color.BLUE);
        signInLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signInPanel.add(accountLabel);
        signInPanel.add(signInLink);

        // Add components to main panel
        gbc.gridwidth = 1; // Reset gridwidth
        gbc.gridy = 3;  // Fourth row
        mainPanel.add(formPanel, gbc);

        gbc.gridy = 4;  // Fifth row
        mainPanel.add(socialButtonsPanel, gbc);

        gbc.gridy = 5;  // Sixth row
        mainPanel.add(signInPanel, gbc);

        // Add main panel to frame
        add(mainPanel);

        // Add action listeners
        signInButton.addActionListener(e -> handleSignUp());
        createAccountButton.addActionListener(e -> handleCreateAccount());
        signInLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO: Implement sign in page navigation
                System.out.println("Navigate to sign in page");
            }
        });
    }

    private JButton createSocialButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(Color.WHITE);
        button.setForeground(new Color(19, 35, 64));
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setPreferredSize(new Dimension(200, 40)); // Adjusted to a smaller size
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    private void handleSignUp() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        if (!termsCheckbox.isSelected()) {
            JOptionPane.showMessageDialog(this,
                    "Please agree to the terms and conditions",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please fill in all fields",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // TODO: Implement database connection and user registration
    }

    private void handleCreateAccount() {
        // TODO: Handle account creation functionality
        System.out.println("Navigate to Create Account Page");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginPage loginPage = new LoginPage();
            loginPage.setVisible(true);
        });
    }
}
