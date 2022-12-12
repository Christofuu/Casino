import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class gamePageGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtEnterChip;
	private JTextField txtEnterChip_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gamePageGUI frame = new gamePageGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public gamePageGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//game Panel Field
		
		JPanel gamePanel = new JPanel();
		gamePanel.setBounds(0, 0, 450, 272);
		contentPane.add(gamePanel);
		gamePanel.setLayout(null);
		
		JLabel welcomeLabel = new JLabel("Welcom To Casino!");
		welcomeLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setBounds(70, 6, 312, 36);
		gamePanel.add(welcomeLabel);
		
		JLabel cashInJLabel = new JLabel("Cash In");
		cashInJLabel.setBounds(70, 59, 61, 16);
		gamePanel.add(cashInJLabel);
		
		JLabel cashOutJLabel = new JLabel("Cash Out");
		cashOutJLabel.setBounds(70, 96, 61, 16);
		gamePanel.add(cashOutJLabel);
		
		textField = new JTextField();
		textField.setBounds(157, 54, 130, 26);
		gamePanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(157, 91, 130, 26);
		gamePanel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton cashAddJButton = new JButton("Add");
		cashAddJButton.setBounds(299, 60, 117, 16);
		gamePanel.add(cashAddJButton);
		
		JButton cashOutJButton = new JButton("Out");
		cashOutJButton.setBounds(299, 97, 117, 16);
		gamePanel.add(cashOutJButton);
		
		JLabel userIDJLabel = new JLabel("User");
		userIDJLabel.setBounds(70, 129, 61, 16);
		gamePanel.add(userIDJLabel);
		
		JLabel userCashJLabel = new JLabel("Cash");
		userCashJLabel.setBounds(70, 157, 61, 16);
		gamePanel.add(userCashJLabel);
		
		JLabel userChipJLabel = new JLabel("Chip");
		userChipJLabel.setBounds(70, 185, 61, 16);
		gamePanel.add(userChipJLabel);
		
		JLabel idSpaceJLabel = new JLabel("New label");
		idSpaceJLabel.setBounds(157, 129, 61, 16);
		gamePanel.add(idSpaceJLabel);
		
		JLabel cashSapceJLabel = new JLabel("New label");
		cashSapceJLabel.setBounds(157, 157, 61, 16);
		gamePanel.add(cashSapceJLabel);
		
		JLabel ChipSpaceJLabel = new JLabel("New label");
		ChipSpaceJLabel.setBounds(157, 185, 61, 16);
		gamePanel.add(ChipSpaceJLabel);
		
		JButton loginPageButton = new JButton("Login");
		loginPageButton.setBounds(277, 129, 117, 77);
		gamePanel.add(loginPageButton);
		
		JButton bjPlayJButton = new JButton("Black Jack");
		bjPlayJButton.setBounds(73, 218, 117, 48);
		gamePanel.add(bjPlayJButton);
		
		JButton slotPlayJButton = new JButton("Slot Machine");
		slotPlayJButton.setBounds(225, 218, 117, 48);
		gamePanel.add(slotPlayJButton);
		
		JButton saveJButton = new JButton("Save");
		saveJButton.setBounds(348, 237, 96, 29);
		gamePanel.add(saveJButton);
		
		
		//Black Jack Panel Field
		JPanel blackJackPanel = new JPanel();
		blackJackPanel.setBounds(0, 0, 450, 272);
		contentPane.add(blackJackPanel);
		blackJackPanel.setLayout(null);
		blackJackPanel.setVisible(false);
		
		JLabel blackJackLabel = new JLabel("Black Jack");
		blackJackLabel.setHorizontalAlignment(SwingConstants.CENTER);
		blackJackLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		blackJackLabel.setBounds(102, 6, 245, 37);
		blackJackPanel.add(blackJackLabel);
		
		JLabel userHandLabel = new JLabel("Your Hand");
		userHandLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userHandLabel.setBounds(40, 65, 79, 16);
		blackJackPanel.add(userHandLabel);
		
		JLabel dealerHandLabel = new JLabel("Dealer");
		dealerHandLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dealerHandLabel.setBounds(340, 65, 61, 16);
		blackJackPanel.add(dealerHandLabel);
		
		JLabel userHandSpace = new JLabel("New label");
		userHandSpace.setBounds(40, 108, 61, 16);
		blackJackPanel.add(userHandSpace);
		
		JLabel dealerHandSpace = new JLabel("New label");
		dealerHandSpace.setBounds(340, 108, 61, 16);
		blackJackPanel.add(dealerHandSpace);
		
		JLabel potSpace = new JLabel("Pot");
		potSpace.setHorizontalAlignment(SwingConstants.CENTER);
		potSpace.setBounds(197, 87, 61, 16);
		blackJackPanel.add(potSpace);
		
		txtEnterChip = new JTextField();
		txtEnterChip.setForeground(Color.LIGHT_GRAY);
		txtEnterChip.setText("Enter Chip");
		txtEnterChip.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterChip.setBounds(129, 141, 90, 26);
		blackJackPanel.add(txtEnterChip);
		txtEnterChip.setColumns(10);
		
		JButton bjPlayButton = new JButton("Play");
		bjPlayButton.setBounds(230, 141, 117, 29);
		blackJackPanel.add(bjPlayButton);
		
		JButton hitButton = new JButton("Hit");
		hitButton.setBounds(102, 201, 117, 65);
		blackJackPanel.add(hitButton);
		
		JButton stayButton = new JButton("Stay");
		stayButton.setBounds(230, 201, 117, 65);
		blackJackPanel.add(stayButton);
		
		JButton bjBackButton = new JButton("Back");
		bjBackButton.setBounds(373, 237, 71, 29);
		blackJackPanel.add(bjBackButton);
		
		
		//Login Panel Field
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBounds(0, 0, 450, 266);
		contentPane.add(loginPanel);
		loginPanel.setLayout(null);
		loginPanel.setVisible(false);
		
		JLabel loginIDLabel = new JLabel("ID");
		loginIDLabel.setBounds(63, 50, 61, 16);
		loginPanel.add(loginIDLabel);
		
		JLabel loginPasswordLabel = new JLabel("Password");
		loginPasswordLabel.setBounds(63, 92, 61, 16);
		loginPanel.add(loginPasswordLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(170, 45, 130, 26);
		loginPanel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(170, 87, 130, 26);
		loginPanel.add(textField_3);
		textField_3.setColumns(10);
		
		JButton signUpButton = new JButton("Sign Up");
		signUpButton.setBounds(88, 183, 117, 29);
		loginPanel.add(signUpButton);
		
		JButton loginButton = new JButton("LogIn");
		loginButton.setBounds(262, 183, 117, 29);
		loginPanel.add(loginButton);
		
		JButton loginBackButton = new JButton("Back");
		loginBackButton.setBounds(327, 231, 117, 29);
		loginPanel.add(loginBackButton);
		
		
		//Slot Machine Panel Field
		JPanel slotPanel = new JPanel();
		slotPanel.setBounds(0, 0, 450, 272);
		contentPane.add(slotPanel);
		slotPanel.setLayout(null);
		slotPanel.setVisible(false);
		
		JLabel slotLabel = new JLabel("Slot Machine");
		slotLabel.setHorizontalAlignment(SwingConstants.CENTER);
		slotLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		slotLabel.setBounds(105, 6, 245, 37);
		slotPanel.add(slotLabel);
		
		JLabel slotBetLabel = new JLabel("Pot");
		slotBetLabel.setBounds(118, 73, 61, 16);
		slotPanel.add(slotBetLabel);
		
		txtEnterChip_1 = new JTextField();
		txtEnterChip_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterChip_1.setForeground(Color.LIGHT_GRAY);
		txtEnterChip_1.setText("Enter Chip");
		txtEnterChip_1.setBounds(220, 68, 130, 26);
		slotPanel.add(txtEnterChip_1);
		txtEnterChip_1.setColumns(10);
		
		JLabel element1 = new JLabel("New label");
		element1.setBounds(62, 118, 61, 16);
		slotPanel.add(element1);
		
		JLabel element2 = new JLabel("New label");
		element2.setBounds(184, 118, 61, 16);
		slotPanel.add(element2);
		
		JLabel element3 = new JLabel("New label");
		element3.setBounds(313, 118, 61, 16);
		slotPanel.add(element3);
		
		JButton pullButton = new JButton("Pull");
		pullButton.setBounds(165, 161, 117, 79);
		slotPanel.add(pullButton);
		
		JButton slotBackButton = new JButton("Back");
		slotBackButton.setBounds(374, 237, 70, 29);
		slotPanel.add(slotBackButton);
	}

}
