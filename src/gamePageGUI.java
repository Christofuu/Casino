import java.awt.EventQueue; 
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

public class gamePageGUI extends JFrame {

	private JPanel contentPane;
	private JTextField blackjackBetField;
	private JTextField slotBetField;
	private JLabel txtEnterId;
	private String usernameEntry;
	private int blackjackBetEntry;
	private JPanel gamePanel;
	private JLabel welcomeLabel;
	private JLabel cashInJLabel;
	private JLabel cashOutJLabel;
	private JTextField cashInTextField;
	private JLabel userIDJLabel;
	private JLabel userCashJLabel;
	private JLabel userChipJLabel;
	private JLabel cashSpaceJLabel;
	private JLabel chipSpaceJLabel;
	private leaderboardPanel leaderboard;
	private JButton leaderBoardButton;
	private JButton bjPlayJButton;
	private JButton slotPlayJButton;
	private String reelElement1;
	private String reelElement2;
	private String reelElement3;
	private JFrame notEnoughChipFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gamePageGUI frame = new gamePageGUI();
					frame.setVisible(true);
					frame.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosing(WindowEvent e) {
							Leaderboard.updateLeaderboard();
							frame.dispose();
							System.exit(0);
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public class leaderboardPanel extends JFrame {
		JTextPane textarea;
		JLabel label;
		JScrollPane scrollbar;
		
		public leaderboardPanel() {
			label = new JLabel("If scroll bar doesn't appear, resize the window.");
			add(label);
			this.setTitle("Leaderboard");
			setLayout(new FlowLayout());
			textarea = new JTextPane();
			textarea.setPreferredSize(new Dimension(110, 200));
			add(textarea);
			textarea.setText(Leaderboard.leaderboardToString());
			textarea.setEditable(false);
			scrollbar = new JScrollPane(textarea);
			scrollbar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			add(scrollbar);
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
		
		JFrame usernameEntryFrame = new JFrame("Casino");
		do {
			usernameEntry = JOptionPane.showInputDialog(usernameEntryFrame, "Welcome to the casino! Please enter a username:", "Casino");
			if (usernameEntry == null || usernameEntry.isBlank()) {
				JOptionPane.showMessageDialog(usernameEntryFrame, "Please enter a non-empty username less than 12 characters.", "Enter username here", JOptionPane.ERROR_MESSAGE);
			}
		} while (usernameEntry == null || usernameEntry.isBlank());
		
		
		//game Panel Field
		gamePanel = new JPanel();
		gamePanel.setBounds(0, 0, 450, 272);
		contentPane.add(gamePanel);
		gamePanel.setLayout(null);
		
		
		welcomeLabel = new JLabel("Welcome To Casino!");
		welcomeLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setBounds(70, 6, 312, 36);
		gamePanel.add(welcomeLabel);
		
		cashInJLabel = new JLabel("Cash In");
		cashInJLabel.setBounds(70, 59, 61, 16);
		gamePanel.add(cashInJLabel);
		
		cashOutJLabel = new JLabel("Cash Out");
		cashOutJLabel.setBounds(70, 96, 61, 16);
		gamePanel.add(cashOutJLabel);
		
		cashInTextField = new JTextField();
		cashInTextField.setBounds(157, 54, 130, 26);
		gamePanel.add(cashInTextField);
		cashInTextField.setColumns(10);
		
		userIDJLabel = new JLabel("User");
		userIDJLabel.setBounds(70, 129, 61, 16);
		gamePanel.add(userIDJLabel);
		
		userCashJLabel = new JLabel("Cash");
		userCashJLabel.setBounds(70, 157, 61, 16);
		gamePanel.add(userCashJLabel);
		
		userChipJLabel = new JLabel("Chips");
		userChipJLabel.setBounds(70, 185, 61, 16);
		gamePanel.add(userChipJLabel);
		
		cashSpaceJLabel = new JLabel(String.valueOf(Casino.getPlayer().getMoney()));
		cashSpaceJLabel.setBounds(157, 157, 61, 16);
		gamePanel.add(cashSpaceJLabel);
		
		chipSpaceJLabel = new JLabel(String.valueOf(Casino.getPlayer().getChips()));
		chipSpaceJLabel.setBounds(157, 185, 61, 16);
		gamePanel.add(chipSpaceJLabel);
		
		leaderboard = new leaderboardPanel();
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
		userHandLabel.setBounds(40, 65, 61, 16);
		blackJackPanel.add(userHandLabel);
		
		JLabel dealerHandLabel = new JLabel("Dealer's Hand");
		dealerHandLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dealerHandLabel.setBounds(340, 65, 61, 16);
		blackJackPanel.add(dealerHandLabel);
		
		JLabel userHandSpace = new JLabel("No cards.");
		userHandSpace.setBounds(40, 108, 150, 16);
		blackJackPanel.add(userHandSpace);
		
		JLabel dealerHandSpace = new JLabel("No cards.");
		dealerHandSpace.setBounds(340, 108, 150, 16);
		blackJackPanel.add(dealerHandSpace);
		
		JLabel potSpace = new JLabel("Pot:");
		potSpace.setHorizontalAlignment(SwingConstants.CENTER);
		potSpace.setBounds(197, 87, 61, 16);
		blackJackPanel.add(potSpace);
		
		blackjackBetField = new JTextField();
		blackjackBetField.setHorizontalAlignment(SwingConstants.CENTER);
		blackjackBetField.setBounds(129, 141, 90, 26);
		blackJackPanel.add(blackjackBetField);
		blackjackBetField.setColumns(10);
		
		
		
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
		
		slotBetField = new JTextField();
		slotBetField.setHorizontalAlignment(SwingConstants.CENTER);
		slotBetField.setForeground(Color.LIGHT_GRAY);
		slotBetField.setText("Slot Bet Amount");
		slotBetField.setBounds(220, 68, 130, 26);
		slotPanel.add(slotBetField);
		slotBetField.setColumns(10);
		
		JLabel reel1 = new JLabel("A");
		reel1.setBounds(62, 118, 61, 16);
		slotPanel.add(reel1);
		
		JLabel reel2 = new JLabel("B");
		reel2.setBounds(184, 118, 61, 16);
		slotPanel.add(reel2);
		
		JLabel reel3 = new JLabel("C");
		reel3.setBounds(313, 118, 61, 16);
		slotPanel.add(reel3);
		
		
		
		//gamePanel Buttons
		JButton cashAddJButton = new JButton("Cash In");
		cashAddJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean cashInSuccess = Casino.getPlayer().cashIn(Integer.parseInt(cashInTextField.getText()));
				cashInTextField.setText("");
				if (cashInSuccess == true) {
					cashSpaceJLabel.setText(String.valueOf(Casino.getPlayer().getMoney()));
					chipSpaceJLabel.setText(String.valueOf(Casino.getPlayer().getChips()));
				} else {
					JFrame cashInErrorFrame = new JFrame("Cash In Error");
					JOptionPane.showMessageDialog(cashInErrorFrame, "Please enter a non-negative number less than " + (Casino.getPlayer().getMoney() + 1), "Error", JOptionPane.ERROR_MESSAGE);
					throw new ArithmeticException("User must enter a value between 0 and " + Casino.getPlayer().getMoney() +".");
				}
			}
		});
		cashAddJButton.setBounds(299, 60, 119, 15);
		gamePanel.add(cashAddJButton);
		
		//TODO replace text field for cash out with this
		JButton cashOutJButton = new JButton("Cash Out");
		cashOutJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Casino.getPlayer().cashOut();
				cashSpaceJLabel.setText(String.valueOf(Casino.getPlayer().getMoney()));
				chipSpaceJLabel.setText(String.valueOf(Casino.getPlayer().getChips()));
			}
		});
		cashOutJButton.setBounds(157, 91, 130, 26);
		gamePanel.add(cashOutJButton);
		
		
		leaderBoardButton = new JButton("Leaderboard");
		leaderBoardButton.setBounds(277, 129, 117, 77);
		gamePanel.add(leaderBoardButton);
		leaderBoardButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				leaderboard.setSize(new Dimension(300, 500));
				leaderboard.setVisible(true);
			}
		});
		
		bjPlayJButton = new JButton("Blackjack");
		bjPlayJButton.setBounds(73, 218, 117, 48);
		gamePanel.add(bjPlayJButton);
		bjPlayJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String chipString = chipSpaceJLabel.getText();
				int chip = Integer.valueOf(chipString);
				
				if(chip < 2) {
					JOptionPane.showMessageDialog(notEnoughChipFrame, "You need to have Chips to Enter Casino", "Please Cash In", JOptionPane.OK_OPTION);
				} else {
					
					gamePanel.setVisible(false);
					blackJackPanel.setVisible(true);
				}
				
			}
		});
		
		
		slotPlayJButton = new JButton("Slot Machine");
		slotPlayJButton.setBounds(225, 218, 117, 48);
		gamePanel.add(slotPlayJButton);
		slotPlayJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String chipString = chipSpaceJLabel.getText();
				int chip = Integer.valueOf(chipString);
				
				if(chip < 2) {
					JOptionPane.showMessageDialog(notEnoughChipFrame, "You need to have Chips to Enter Casino", "Please Cash In", JOptionPane.OK_OPTION);
				} else {
					
					gamePanel.setVisible(false);
					slotPanel.setVisible(true);
					
				}
				
			}
		});
		

		
		txtEnterId = new JLabel();
		txtEnterId.setText(usernameEntry);
		txtEnterId.setBounds(157, 124, 130, 26);
		Casino.getPlayer().setUsername(txtEnterId.getText());
		
		gamePanel.add(txtEnterId);
		
		
		//Black Jack Button
		JButton bjPlayButton = new JButton("Play");
		bjPlayButton.setSize(100, 50);
		blackJackPanel.add(bjPlayButton);
		bjPlayButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Blackjack.getPot() > 0) {
					Blackjack.resetGameConditions();
					Blackjack.blackjack(blackjackBetEntry);
					userHandSpace.setText(Blackjack.playerHandToString());
					dealerHandSpace.setText(Blackjack.dealerHandToString());
					
					if (Blackjack.checkWin() == true && Blackjack.getPlayerWin() == true) {
						JFrame blackjackWinMessage = new JFrame();
						JOptionPane.showMessageDialog(blackjackWinMessage, "You won!", "Winner!", JOptionPane.INFORMATION_MESSAGE);
						potSpace.setText("Pot: ");
						userHandSpace.setText("User hand");
						dealerHandSpace.setText("Dealer Hand");
						Blackjack.resetGameConditions();
					}
					if (Blackjack.checkWin() == true && Blackjack.getPlayerWin() == false) {
						JFrame blackjackLoseMessage = new JFrame();
						JOptionPane.showMessageDialog(blackjackLoseMessage, "You lost", ":(", JOptionPane.INFORMATION_MESSAGE);
						potSpace.setText("Pot: ");
						userHandSpace.setText("User hand");
						dealerHandSpace.setText("Dealer Hand");
						Blackjack.resetGameConditions();
					}
				} else {
					JFrame blackjackBetError = new JFrame();
					JOptionPane.showMessageDialog(blackjackBetError, "Please enter a valid bet above 0 chips", "Invalid Bet", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton bjBetButton = new JButton("Bet");
		bjBetButton.setBounds(230, 141, 117, 29);
		blackJackPanel.add(bjBetButton);
		bjBetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean blackjackBetSuccess = false;
				do {
				try {
					blackjackBetEntry = Integer.parseInt(blackjackBetField.getText());
					System.out.println(Integer.parseInt(blackjackBetField.getText()));
				} catch (NumberFormatException error) {
					JFrame blackjackBetError = new JFrame();
					JOptionPane.showMessageDialog(blackjackBetError, "Please only enter integers.", "Invalid Bet", JOptionPane.ERROR_MESSAGE);
				}
				
				blackjackBetSuccess = Blackjack.checkBet(blackjackBetEntry);
				
				if (blackjackBetSuccess == false) {
					JFrame blackjackBetError = new JFrame();
					JOptionPane.showMessageDialog(blackjackBetError, "Please enter a bet between 0 and " + Casino.getPlayer().getChips() + " chips.", "Invalid Bet", JOptionPane.ERROR_MESSAGE);
				} else {
					Blackjack.setBet(blackjackBetEntry);
					Blackjack.setPot();
					potSpace.setText("Pot: " + String.valueOf(Blackjack.getPot()));
				}
				blackjackBetField.setText("");
				} while (blackjackBetSuccess = false);
			}
		});
		
		
		JButton hitButton = new JButton("Hit");
		hitButton.setBounds(102, 201, 117, 65);
		blackJackPanel.add(hitButton);
		hitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Blackjack.playerHit();
				userHandSpace.setText(Blackjack.playerHandToString());
				if(Blackjack.blackjackLoop() == false && Blackjack.getPlayerWin() == false) {
					dealerHandSpace.setText(Blackjack.dealerHandToString());
					JFrame blackjackLoseMessage = new JFrame();
					JOptionPane.showMessageDialog(blackjackLoseMessage, "You lost", ":(", JOptionPane.INFORMATION_MESSAGE);
					potSpace.setText("Pot: ");
					userHandSpace.setText("User hand");
					dealerHandSpace.setText("Dealer Hand");
					Blackjack.resetGameConditions();
				} else if (Blackjack.blackjackLoop() == false && Blackjack.getPlayerWin() == true) {
					JFrame blackjackWinMessage = new JFrame();
					JOptionPane.showMessageDialog(blackjackWinMessage, "You won!", "Winner!", JOptionPane.INFORMATION_MESSAGE);
					potSpace.setText("Pot: ");
					userHandSpace.setText("User hand");
					dealerHandSpace.setText("Dealer Hand");
					Blackjack.resetGameConditions();
				} else {
					dealerHandSpace.setText(Blackjack.dealerHandToString());
				}
			}
			
		});
		
		JButton stayButton = new JButton("Stay");
		stayButton.setBounds(230, 201, 117, 65);
		blackJackPanel.add(stayButton);
		stayButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Blackjack.blackjackLoop() == false && Blackjack.getPlayerWin() == false) {
					JFrame blackjackLoseMessage = new JFrame();
					JOptionPane.showMessageDialog(blackjackLoseMessage, "You lost", ":(", JOptionPane.INFORMATION_MESSAGE);
					dealerHandSpace.setText(Blackjack.dealerHandToString());
					potSpace.setText("Pot: ");
					userHandSpace.setText("User hand");
					dealerHandSpace.setText("Dealer Hand");
					Blackjack.resetGameConditions();
				} else if (Blackjack.getPlayerWin() == true) {
					dealerHandSpace.setText(Blackjack.dealerHandToString());
					JFrame blackjackWinMessage = new JFrame();
					JOptionPane.showMessageDialog(blackjackWinMessage, "You won!", "Winner!", JOptionPane.INFORMATION_MESSAGE);
					potSpace.setText("Pot: ");
					userHandSpace.setText("User hand");
					dealerHandSpace.setText("Dealer Hand");
					Blackjack.resetGameConditions();
				}
			}
			
		});
		
		JButton bjBackButton = new JButton("Back");
		bjBackButton.setBounds(373, 237, 71, 29);
		blackJackPanel.add(bjBackButton);
		bjBackButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				blackJackPanel.setVisible(false);
				cashSpaceJLabel.setText(String.valueOf(Casino.getPlayer().getMoney()));
				chipSpaceJLabel.setText(String.valueOf(Casino.getPlayer().getChips()));
				gamePanel.setVisible(true);
				
			}
		});
		
		
		//Slots Buttons
		JButton pullButton = new JButton("Pull");
		pullButton.setBounds(165, 161, 117, 79);
		slotPanel.add(pullButton);
		
		pullButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String betString = slotBetField.getText();
				int betAmount = Integer.valueOf(betString);
				boolean winOrLose = false;
				int winningMultiplier = 0;
				
				try {
						
					Casino.getPlayer().bet(betAmount);
					chipSpaceJLabel.setText(String.valueOf(Casino.getPlayer().getChips()));
					
					Machine casinoMachine = new Machine();
					casinoMachine.slotCompute();
					reelElement1 = casinoMachine.getSlot1Element();
					reelElement2 = casinoMachine.getSlot2Element();
					reelElement3 = casinoMachine.getSlot3Element();
					
					reel1.setText(reelElement1);
					reel2.setText(reelElement2);
					reel3.setText(reelElement3);
					
					winOrLose = casinoMachine.getWinOrLose();
					if(casinoMachine.getWinOrLose() == true) {
						Casino.getPlayer().payout(betAmount * Machine.getWinningMultiplier());
						JFrame winJFrame = new JFrame();
						chipSpaceJLabel.setText(String.valueOf(Casino.getPlayer().getChips()));
						JOptionPane.showMessageDialog(winJFrame, "Congraturation You Win!!"+ "\n" + "You win " + betAmount * Machine.getWinningMultiplier() + " chips." , "WIN", JOptionPane.INFORMATION_MESSAGE);
					} 
					
						else if(casinoMachine.getWinOrLose() == false) {
						Casino.getPlayer().getChips();
						JFrame loseJFrame = new JFrame();
						chipSpaceJLabel.setText(String.valueOf(Casino.getPlayer().getChips()));
						JOptionPane.showMessageDialog(loseJFrame, "You lose!!"+ "\n" + "Now You have " + Casino.getPlayer().getChips() + " chips", "Lose", JOptionPane.INFORMATION_MESSAGE);
						
						
					}
						
				}
				 catch (NumberFormatException n) {
					
					 JFrame slotBetError = new JFrame();
					 JOptionPane.showMessageDialog(slotBetError, "Please enter a bet between 0 and " + Casino.getPlayer().getChips() + " chips.", "Invalid Bet", JOptionPane.ERROR_MESSAGE);
				}

				
						
				}
			});
				
		
		
		JButton slotBackButton = new JButton("Back");
		slotBackButton.setBounds(374, 237, 70, 29);
		slotPanel.add(slotBackButton);
		slotBackButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				slotPanel.setVisible(false);
				gamePanel.setVisible(true);
			}
		});
	}
}
