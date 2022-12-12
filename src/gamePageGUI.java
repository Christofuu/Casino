import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class gamePageGUI extends JFrame {

	private JPanel contentPane;
	private JTextField cashInTextField;
	private JTextField cashOutTextField;
	private JTextField txtEnterChip;
	private JTextField txtEnterChip_1;
	private JTextField txtEnterId;

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


	public class leaderboardPanel extends JFrame {
		JTextPane textarea;
		JButton button;
		JLabel label;
		
		public leaderboardPanel() {
			setLayout(new FlowLayout());
			textarea = new JTextPane();
			add(textarea);
			textarea.setText(Leaderboard.leaderboardToString());
		}
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
		
		JLabel welcomeLabel = new JLabel("Welcome To Casino!");
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
		
		cashInTextField = new JTextField();
		cashInTextField.setBounds(157, 54, 130, 26);
		gamePanel.add(cashInTextField);
		cashInTextField.setColumns(10);
		
		cashOutTextField = new JTextField();
		cashOutTextField.setBounds(157, 91, 130, 26);
		gamePanel.add(cashOutTextField);
		cashOutTextField.setColumns(10);
		JLabel userIDJLabel = new JLabel("User");
		userIDJLabel.setBounds(70, 129, 61, 16);
		gamePanel.add(userIDJLabel);
		
		JLabel userCashJLabel = new JLabel("Cash");
		userCashJLabel.setBounds(70, 157, 61, 16);
		gamePanel.add(userCashJLabel);
		
		JLabel userChipJLabel = new JLabel("Chip");
		userChipJLabel.setBounds(70, 185, 61, 16);
		gamePanel.add(userChipJLabel);
		
		JLabel cashSapceJLabel = new JLabel("New label");
		cashSapceJLabel.setBounds(157, 157, 61, 16);
		gamePanel.add(cashSapceJLabel);
		
		JLabel ChipSpaceJLabel = new JLabel("New label");
		ChipSpaceJLabel.setBounds(157, 185, 61, 16);
		gamePanel.add(ChipSpaceJLabel);
		//Login Panel Field
		
		leaderboardPanel leaderboard = new leaderboardPanel();
		leaderboard.setSize(100, 250);
		leaderboard.setVisible(false);
		
		
		
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
		
		JLabel dealerHandLabel = new JLabel("Dealer's Hand'");
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
		txtEnterChip.setText("Bet Amount");
		txtEnterChip.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterChip.setBounds(129, 141, 90, 26);
		blackJackPanel.add(txtEnterChip);
		txtEnterChip.setColumns(10);
		
		
		
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
		txtEnterChip_1.setText("Bet Amount");
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
		
		
		
		//gamePanel Buttons
		JButton cashAddJButton = new JButton("Cash In");
		cashAddJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Casino.getPlayer().cashIn(cashInTextField.getText().);
			}
		});
		cashAddJButton.setBounds(299, 60, 117, 16);
		gamePanel.add(cashAddJButton);
		
		
		JButton cashOutJButton = new JButton("Cash Out");
		cashOutJButton.setBounds(299, 97, 117, 16);
		gamePanel.add(cashOutJButton);
		
		
		JButton leaderBoardButton = new JButton("Leaderboard");
		leaderBoardButton.setBounds(277, 129, 117, 77);
		gamePanel.add(leaderBoardButton);
		leaderBoardButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				leaderboard.setVisible(true);
				
				//TODO need to perform leaderboard
				//leaderboardtextArea.append(Leaderboard.leaderboardToString() + "\n");
			
			}
		});
		
		JButton bjPlayJButton = new JButton("Black Jack");
		bjPlayJButton.setBounds(73, 218, 117, 48);
		gamePanel.add(bjPlayJButton);
		bjPlayJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gamePanel.setVisible(false);
				blackJackPanel.setVisible(true);
			}
		});
		
		JButton slotPlayJButton = new JButton("Slot Machine");
		slotPlayJButton.setBounds(225, 218, 117, 48);
		gamePanel.add(slotPlayJButton);
		slotPlayJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gamePanel.setVisible(false);
				slotPanel.setVisible(true);
				
			}
		});
		
		JButton saveJButton = new JButton("Save");
		saveJButton.setBounds(348, 237, 96, 29);
		gamePanel.add(saveJButton);
		
		txtEnterId = new JTextField();
		txtEnterId.setText("Enter ID");
		txtEnterId.setForeground(Color.LIGHT_GRAY);
		txtEnterId.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterId.setBounds(135, 124, 130, 26);
		
		Casino.getPlayer().setUsername(txtEnterId.getText());
		
		gamePanel.add(txtEnterId);
		txtEnterId.setColumns(10);
		saveJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int saveResult = JOptionPane.showConfirmDialog(saveJButton, "Do you want to save your data?", "Save", JOptionPane.YES_NO_OPTION);
				if(saveResult == 1) {
					
				}
			}
		});
		
		
		//Black Jack Button
		
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
		bjBackButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				blackJackPanel.setVisible(false);
				gamePanel.setVisible(true);
				
			}
		});
		
		//Slots Buttons
		JButton pullButton = new JButton("Pull");
		pullButton.setBounds(165, 161, 117, 79);
		slotPanel.add(pullButton);
		
		JButton slotBackButton = new JButton("Back");
		slotBackButton.setBounds(374, 237, 70, 29);
		slotPanel.add(slotBackButton);
		slotBackButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				slotPanel.setVisible(false);
				gamePanel.setVisible(true);
			}
		});
	}
}
