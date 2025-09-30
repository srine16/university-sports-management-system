import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Screen2<Sports> extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 * @param data 
	 */
	public Screen2(String data) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Sports = new JLabel("New label");
		Sports.setFont (new Font ("Tahoma", Font.PLAIN,18));
		Sports .setBounds(10, 11, 414, 32);
				
		Sports.setText(data);

		contentPane.add(Sports);
	}
}