import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

import Dice.Die;

//class that runs the yahtzee program
@SuppressWarnings("serial")
public class Yahtzee extends JApplet{
	
	//JApplet size
	private final int APPLET_WIDTH = 600;
	private final int APPLET_HEIGHT = 800;
	
	private Random random = new Random();
	
	//the number that holds the current number of turns
	private int num = 1;
	//number of dicerolls
	private int diceRollNum = 1;
	//number of bonuses that player 1 and player 2 haves
	private int p1BonusNum = 1;
	private int p2BonusNum = 1;
	
	//sum of points for player 1 and player 2
	private int p1Upper = 0;
	private int p2Upper = 0;
	
	//total number of points for player 1 and player 2
	private int p1Total = 0;
	private int p2Total = 0;
	
	//the die faces
	private int[] diceRolls = new int[5];
	private boolean[] isSaved = new boolean[5];
	
	//variables for if the player 1 and player 2 upper buttons are used
	//helpful for bonus yahtzee
	private boolean[] p1buttonUsed = new boolean[6];
	private boolean[] p2buttonUsed = new boolean[6];
	
	//turns
	private boolean player1Turn = true;
	
	//JLabel for the game information
	private JLabel playerTurn;
	
	//JLabel for the game "debugging"
	private JLabel gameHelp;
	
	//image icons for the die faces
	private ImageIcon oneDot, twoDot, threeDot, fourDot, fiveDot, sixDot;
	private ImageIcon oneDotClicked, twoDotClicked, threeDotClicked, fourDotClicked, fiveDotClicked, sixDotClicked;
	
	//JButtons for the die
	private JButton dice1, dice2, dice3, dice4, dice5;
	
	//JButton for rolling the dice
	private JButton rollDice;

	//JButton for the scorecard
	private JButton aces1, twos1, threes1, fours1, fives1, sixes1, threeK1, fourK1, fullHouse1, smStr1, lgStr1, yahtzee1, chance1, bonus1;
	private JButton aces2, twos2, threes2, fours2, fives2 ,sixes2, threeK2, fourK2, fullHouse2, smStr2, lgStr2, yahtzee2, chance2, bonus2;
	
	//JButton for ending the game
	private JButton winner;
	
	//JLabels for the scorecard
	private JLabel acesS, twosS, threesS, foursS, fivesS, sixesS, threeKS, fourKS, fullHouseS, smStrS, lgStrS, yahtzeeS, chanceS, bonusS;
	
	//JLabels for player 1 and player 2
	private JLabel p1, p2;
	
	//URLLabel linked to the yahtzeeRules
	//opens the url in Chrome
	private URLLabel yahtzeeRules;
	
	public void init() {
		//sets size of JApplet
		setSize(APPLET_WIDTH, APPLET_HEIGHT);
		
		//creates ImageIcons of each dot
		oneDot = new ImageIcon("onedot.jpg");
		twoDot = new ImageIcon("twodot.jpg");
		threeDot = new ImageIcon("threedot.jpg");
		fourDot = new ImageIcon("fourdot.jpg");
		fiveDot = new ImageIcon("fivedot.jpg");
		sixDot = new ImageIcon("sixdot.jpg");
		
		//resizes ImageIcon
		oneDot = getResizedImage(oneDot);
		twoDot = getResizedImage(twoDot);
		threeDot = getResizedImage(threeDot);
		fourDot = getResizedImage(fourDot);
		fiveDot = getResizedImage(fiveDot);
		sixDot = getResizedImage(sixDot);
		
		//creates ImageIcons of each clicked dot
		oneDotClicked = new ImageIcon("onedotClicked.jpg");
		twoDotClicked = new ImageIcon("twodotClicked.jpg");
		threeDotClicked = new ImageIcon("threedotClicked.jpg");
		fourDotClicked = new ImageIcon("fourdotClicked.jpg");
		fiveDotClicked = new ImageIcon("fivedotClicked.jpg");
		sixDotClicked = new ImageIcon("sixdotClicked.jpg");
		
		//resizes ImageIcon of each clicked dot
		oneDotClicked = getResizedImage(oneDotClicked);
		twoDotClicked = getResizedImage(twoDotClicked);
		threeDotClicked = getResizedImage(threeDotClicked);
		fourDotClicked = getResizedImage(fourDotClicked);
		fiveDotClicked = getResizedImage(fiveDotClicked);
		sixDotClicked = getResizedImage(sixDotClicked);
		
		//creates JButtons for each die
		dice1 = new JButton();
		dice2 = new JButton();
		dice3 = new JButton();
		dice4 = new JButton();
		dice5 = new JButton();
		
		//adds actionListeners for each die
		dice1.addActionListener(new dice1Listener());
		dice2.addActionListener(new dice2Listener());
		dice3.addActionListener(new dice3Listener());		
		dice4.addActionListener(new dice4Listener());		
		dice5.addActionListener(new dice5Listener());
		
		//creates a JButton for rollDice action 
		rollDice = new JButton("Roll Dice");
		rollDice.addActionListener(new rollDiceListener());
		
		//JButtons for p1
		aces1 = new JButton("");
		twos1 = new JButton("");
		threes1 = new JButton("");
		fours1 = new JButton("");
		fives1 = new JButton("");
		sixes1 = new JButton("");
		threeK1 = new JButton("");
		fourK1 = new JButton("");
		fullHouse1 = new JButton("");
		smStr1 = new JButton("");
		lgStr1 = new JButton("");
		yahtzee1 = new JButton("");
		chance1 = new JButton("");
		bonus1 = new JButton("");
		
		aces1.addActionListener(new aces1());
		twos1.addActionListener(new twos1());
		threes1.addActionListener(new threes1());
		fours1.addActionListener(new fours1());
		fives1.addActionListener(new fives1());
		sixes1.addActionListener(new sixes1());
		threeK1.addActionListener(new threeK1());
		fourK1.addActionListener(new fourK1());
		fullHouse1.addActionListener(new fullHouse1());
		smStr1.addActionListener(new smStr1());
		lgStr1.addActionListener(new lgStr1());
		yahtzee1.addActionListener(new yahtzee1());
		chance1.addActionListener(new chance1());
		bonus1.addActionListener(new bonus1());
		
		//JButtons for p2
		aces2 = new JButton("");
		twos2 = new JButton("");
		threes2 = new JButton("");
		fours2 = new JButton("");
		fives2 = new JButton("");
		sixes2 = new JButton("");
		threeK2 = new JButton("");
		fourK2 = new JButton("");
		fullHouse2 = new JButton("");
		smStr2 = new JButton("");
		lgStr2 = new JButton("");
		yahtzee2 = new JButton("");
		chance2 = new JButton("");
		bonus2 = new JButton("");
		
		aces2.addActionListener(new aces2());
		twos2.addActionListener(new twos2());
		threes2.addActionListener(new threes2());
		fours2.addActionListener(new fours2());
		fives2.addActionListener(new fives2());
		sixes2.addActionListener(new sixes2());
		threeK2.addActionListener(new threeK2());
		fourK2.addActionListener(new fourK2());
		fullHouse2.addActionListener(new fullHouse2());
		smStr2.addActionListener(new smStr2());
		lgStr2.addActionListener(new lgStr2());
		yahtzee2.addActionListener(new yahtzee2());
		chance2.addActionListener(new chance2());
		bonus2.addActionListener(new bonus2());
		
		//JLabels for scoreboard
		acesS = new JLabel("Aces");
		twosS = new JLabel("Twos");
		threesS = new JLabel("Threes");
		foursS = new JLabel("Fours");
		fivesS = new JLabel("Fives");
		sixesS = new JLabel("Sixes");
		threeKS = new JLabel("Three of a Kind");
		fourKS = new JLabel("Four of a Kind");
		fullHouseS = new JLabel("Full House");
		smStrS = new JLabel("Small Straight");
		lgStrS = new JLabel("Large Straight");
		yahtzeeS = new JLabel("Yahtzee");
		chanceS = new JLabel("Chance");
		bonusS = new JLabel("Yahtzee Bonus");
		
		//JLabel designating player 1 and player 2
		p1 = new JLabel("Player 1");
		p2 = new JLabel("Player 2");
		
		//creates a JLabel for a URL to the rules of Yahtzee on the site and sets the location
		yahtzeeRules = new URLLabel("Yahtzee Rules", "http://www.yahtzee.org.uk/rules.html");
		
		//creates a JLabel to say which player's turn it is, sets text, and sets location
		playerTurn = new JLabel("Player 1's turn!");
		
		gameHelp = new JLabel("");
		
		//JButton to find the winner
		winner = new JButton("Who won?");
		winner.addActionListener(new winner());
		
		//creates Container
		Container cp = getContentPane();
		cp.setSize(new Dimension(600, 800));
		cp.setBackground(new Color(195,242,242));
		cp.setLayout(new BorderLayout());
		
		//creates JPanel for BorderLayout
		JPanel west = new JPanel(new GridLayout(10, 1, 10, 10));
		west.setBackground(new Color(195,242,242));
		
		JPanel east = new JPanel(new GridLayout(15, 3, 5, 5));
		east.setBackground(new Color(195,242,242));
		
		//adds each JButton and JLabel to the Container
		cp.add(west, BorderLayout.WEST);
		
		west.add(playerTurn);
		west.add(dice1);
		west.add(dice2);
		west.add(dice3);
		west.add(dice4);
		west.add(dice5);
		west.add(rollDice);
		west.add(gameHelp);
		west.add(winner);
		west.add(yahtzeeRules);
	
		cp.add(east, BorderLayout.EAST);		
		
		east.add(new JLabel());
		east.add(p1);
		east.add(p2);
		
		east.add(acesS);
		east.add(aces1);
		east.add(aces2);
		
		east.add(twosS);
		east.add(twos1);
		east.add(twos2);
		
		east.add(threesS);
		east.add(threes1);
		east.add(threes2);
		
		east.add(foursS);
		east.add(fours1);
		east.add(fours2);
		
		east.add(fivesS);
		east.add(fives1);
		east.add(fives2);
		
		east.add(sixesS);
		east.add(sixes1);
		east.add(sixes2);
		
		east.add(threeKS);
		east.add(threeK1);
		east.add(threeK2);
		
		east.add(fourKS);
		east.add(fourK1);
		east.add(fourK2);
		
		east.add(fullHouseS);
		east.add(fullHouse1);
		east.add(fullHouse2);
		
		east.add(smStrS);
		east.add(smStr1);
		east.add(smStr2);
		
		east.add(lgStrS);
		east.add(lgStr1);
		east.add(lgStr2);
		
		east.add(yahtzeeS);
		east.add(yahtzee1);
		east.add(yahtzee2);
		
		east.add(chanceS);
		east.add(chance1);
		east.add(chance2);
		
		east.add(bonusS);
		east.add(bonus1);
		east.add(bonus2);
	}
	
	//rolls the dice that are not saved then shows the results
	private void rollDice() {
		for(int i = 0; i < diceRolls.length; i++) {
			if(isSaved[i] == false) {
				diceRolls[i] = random.nextInt(6) + 1;;
			}
		}
		dice1.setIcon(getDieImage(0));
		dice2.setIcon(getDieImage(1));
		dice3.setIcon(getDieImage(2));
		dice4.setIcon(getDieImage(3));
		dice5.setIcon(getDieImage(4));
		if(player1Turn == true) {
			getP1RollResults();
		}else if(player1Turn == false) {
			getP2RollResults();
		}
		
	}
	
	//sets each button to their result after a dice roll
	private void getP1RollResults() {
		if(aces1.isEnabled())
			aces1.setText(Integer.valueOf(Die.checkAces(diceRolls)).toString());
		if(twos1.isEnabled())
			twos1.setText(Integer.valueOf(Die.checkTwos(diceRolls)).toString());
		if(threes1.isEnabled())
			threes1.setText(Integer.valueOf(Die.checkThrees(diceRolls)).toString());
		if(fours1.isEnabled())
			fours1.setText(Integer.valueOf(Die.checkFours(diceRolls)).toString());
		if(fives1.isEnabled())
			fives1.setText(Integer.valueOf(Die.checkFives(diceRolls)).toString());
		if(sixes1.isEnabled())
			sixes1.setText(Integer.valueOf(Die.checkSixes(diceRolls)).toString());
		if(threeK1.isEnabled())
			threeK1.setText(Integer.valueOf(Die.checkThreeKind(diceRolls)).toString());
		if(fourK1.isEnabled())
			fourK1.setText(Integer.valueOf(Die.checkFourKind(diceRolls)).toString());
		if(fullHouse1.isEnabled())
			fullHouse1.setText(Integer.valueOf(Die.checkFullHouse(diceRolls)).toString());
		if(smStr1.isEnabled())
			smStr1.setText(Integer.valueOf(Die.checkSmallStraight(diceRolls)).toString());
		if(lgStr1.isEnabled())
			lgStr1.setText(Integer.valueOf(Die.checkLargeStraight(diceRolls)).toString());
		if(yahtzee1.isEnabled())
			yahtzee1.setText(Integer.valueOf(Die.checkYahtzee(diceRolls)).toString());
		if(chance1.isEnabled())
			chance1.setText(Integer.valueOf(Die.checkChance(diceRolls)).toString());
	}
	
	//sets each button to their result after a dice roll
	private void getP2RollResults() {
		if(aces2.isEnabled())
			aces2.setText(Integer.valueOf(Die.checkAces(diceRolls)).toString());
		if(twos2.isEnabled())
			twos2.setText(Integer.valueOf(Die.checkTwos(diceRolls)).toString());
		if(threes2.isEnabled())
			threes2.setText(Integer.valueOf(Die.checkThrees(diceRolls)).toString());
		if(fours2.isEnabled())
			fours2.setText(Integer.valueOf(Die.checkFours(diceRolls)).toString());
		if(fives2.isEnabled())
			fives2.setText(Integer.valueOf(Die.checkFives(diceRolls)).toString());
		if(sixes2.isEnabled())
			sixes2.setText(Integer.valueOf(Die.checkSixes(diceRolls)).toString());
		if(threeK2.isEnabled())
			threeK2.setText(Integer.valueOf(Die.checkThreeKind(diceRolls)).toString());
		if(fourK2.isEnabled())
			fourK2.setText(Integer.valueOf(Die.checkFourKind(diceRolls)).toString());
		if(fullHouse2.isEnabled())
			fullHouse2.setText(Integer.valueOf(Die.checkFullHouse(diceRolls)).toString());
		if(smStr2.isEnabled())
			smStr2.setText(Integer.valueOf(Die.checkSmallStraight(diceRolls)).toString());
		if(lgStr2.isEnabled())
			lgStr2.setText(Integer.valueOf(Die.checkLargeStraight(diceRolls)).toString());
		if(yahtzee2.isEnabled())
			yahtzee2.setText(Integer.valueOf(Die.checkYahtzee(diceRolls)).toString());
		if(chance2.isEnabled())
			chance2.setText(Integer.valueOf(Die.checkChance(diceRolls)).toString());
	}
	
	//clears all the die in isSaved to not saved
	private void clearDie() {
		for(int i = 0; i < isSaved.length; i++) {
			isSaved[i] = false;
		}
	}
	
	//gets the image of the die
	private ImageIcon getDieImage(int num) {
		if(diceRolls[num] == 1 && isSaved[num] == true) {
			return oneDotClicked;
		}else if(diceRolls[num] == 1 && isSaved[num] == false) {
			return oneDot;
		}else if(diceRolls[num] == 2 && isSaved[num] == true)  {
			return twoDotClicked;
		}else if(diceRolls[num] == 2 && isSaved[num] == false)  {
			return twoDot;
		}else if(diceRolls[num] == 3 && isSaved[num] == true)  {
			return threeDotClicked;
		}else if(diceRolls[num] == 3 && isSaved[num] == false)  {
			return threeDot;
		}else if(diceRolls[num] == 4 && isSaved[num] == true)  {
			return fourDotClicked;
		}else if(diceRolls[num] == 4 && isSaved[num] == false)  {
			return fourDot;
		}else if(diceRolls[num] == 5 && isSaved[num] == true)  {
			return fiveDotClicked;
		}else if(diceRolls[num] == 5 && isSaved[num] == false)  {
			return fiveDot;
		}else if(diceRolls[num] == 6 && isSaved[num] == true)  {
			return sixDotClicked;
		}
		return sixDot;
	}
	
	//resizes each ImageIcon
	private ImageIcon getResizedImage(ImageIcon imageIcon) {
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(78, 78, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		return new ImageIcon(newimg);  // transform it back
	}
	
	//*****************************************************************************
	
	//actionListener for the first die, sets the image of the die 
	public class dice1Listener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			isSaved[0] = !isSaved[0];
			dice1.setIcon(getDieImage(0));
		}
	}
	
	//actionListener for the second die, sets the image of the die
	public class dice2Listener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			isSaved[1] = !isSaved[1];
			dice2.setIcon(getDieImage(1));
		}
	}
	
	//actionListener for the third die, sets the image of the die
	public class dice3Listener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			isSaved[2] = !isSaved[2];
			dice3.setIcon(getDieImage(2));
		}
	}
	
	//actionListener for the fourth die, sets the image of the die
	public class dice4Listener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			isSaved[3] = !isSaved[3];
			dice4.setIcon(getDieImage(3));
		}
	}
	
	//actionListener for the fifth die, sets the image of the die
	public class dice5Listener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			isSaved[4] = !isSaved[4];
			dice5.setIcon(getDieImage(4));
		}
	}
	
	//actionListener for the rollDice button
	public class rollDiceListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(num <= 13) {
				if(diceRollNum == 1) {
					diceRollNum++;
					rollDice();
				}else if(diceRollNum == 2) {
					diceRollNum++;
					rollDice();
				}else if(diceRollNum == 3) {
					rollDice();
					rollDice.setEnabled(false);
				}
			}
		}
	}
	
	//actionListener for the winner button
	public class winner implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(p1Upper >= 63) {
				p1Total += 63;
			}
			if(p2Upper >= 63) {
				p2Total += 63;
			}
			p1Total += p1Upper;
			p2Total += p2Upper;
			
			if(p1Total > p2Total) {
				playerTurn.setText("Player 1 wins!");
			}else if(p2Total > p1Total) {
				playerTurn.setText("Player 2 wins!");
			}else if(p2Total == p1Total) {
				playerTurn.setText("It's a tie!");
			}
		}
	}
	
	//actionListener for the aces buttons
	public class aces1 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			diceRollNum = 1;
			p1Upper += Integer.valueOf(Die.checkAces(diceRolls));
			aces1.setText(Integer.valueOf(Die.checkAces(diceRolls)).toString());
			playerTurn.setText("Player 2's turn!");
			clearDie();
			player1Turn = false;
			p1buttonUsed[0] = true;
			aces1.setEnabled(false);
			rollDice.setEnabled(true);
		}
	}
	
	//actionListener for the twos buttons
	public class twos1 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			diceRollNum = 1;
			p1Upper += Integer.valueOf(Die.checkTwos(diceRolls));
			twos1.setText(Integer.valueOf(Die.checkTwos(diceRolls)).toString());
			playerTurn.setText("Player 2's turn!");
			clearDie();
			player1Turn = false;
			p1buttonUsed[1] = true;
			twos1.setEnabled(false);
			rollDice.setEnabled(true);
		}
	}
	
	//actionListener for the threes buttons
	public class threes1 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			diceRollNum = 1;
			p1Upper += Integer.valueOf(Die.checkThrees(diceRolls));
			threes1.setText(Integer.valueOf(Die.checkThrees(diceRolls)).toString());
			playerTurn.setText("Player 2's turn!");
			clearDie();
			player1Turn = false;
			p1buttonUsed[2] = true;
			threes1.setEnabled(false);
			rollDice.setEnabled(true);
		}
	}
	
	//actionListener for the fours buttons
	public class fours1 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			diceRollNum = 1;
			p1Upper += Integer.valueOf(Die.checkFours(diceRolls));
			fours1.setText(Integer.valueOf(Die.checkFours(diceRolls)).toString());
			playerTurn.setText("Player 2's turn!");
			clearDie();
			player1Turn = false;
			p1buttonUsed[3] = true;
			fours1.setEnabled(false);
			rollDice.setEnabled(true);
		}
	}
	
	//actionListener for the fives buttons
	public class fives1 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			diceRollNum = 1;
			p1Upper += Integer.valueOf(Die.checkFives(diceRolls));
			fives1.setText(Integer.valueOf(Die.checkFives(diceRolls)).toString());
			playerTurn.setText("Player 2's turn!");
			clearDie();
			player1Turn = false;
			p1buttonUsed[4] = true;
			fives1.setEnabled(false);
			rollDice.setEnabled(true);
		}
	}
	
	//actionListener for the sixes buttons
	public class sixes1 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			diceRollNum = 1;
			p1Upper += Integer.valueOf(Die.checkSixes(diceRolls));
			sixes1.setText(Integer.valueOf(Die.checkSixes(diceRolls)).toString());
			playerTurn.setText("Player 2's turn!");
			clearDie();
			player1Turn = false;
			p1buttonUsed[5] = true;
			sixes1.setEnabled(false);
			rollDice.setEnabled(true);
		}
	}
	
	//actionListener for the three of a kind buttons
	public class threeK1 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			diceRollNum = 1;
			p1Total += Integer.valueOf(Die.checkThreeKind(diceRolls));
			threeK1.setText(Integer.valueOf(Die.checkThreeKind(diceRolls)).toString());
			playerTurn.setText("Player 2's turn!");
			clearDie();
			player1Turn = false;
			threeK1.setEnabled(false);
			rollDice.setEnabled(true);
		}
	}
	
	//actionListener for the four of a kind buttons
	public class fourK1 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			diceRollNum = 1;
			p1Total += Integer.valueOf(Die.checkFourKind(diceRolls));
			fourK1.setText(Integer.valueOf(Die.checkFourKind(diceRolls)).toString());
			playerTurn.setText("Player 2's turn!");
			clearDie();
			player1Turn = false;
			fourK1.setEnabled(false);
			rollDice.setEnabled(true);
		}
	}
	
	//actionListener for the full house buttons
	public class fullHouse1 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			diceRollNum = 1;
			p1Total += Integer.valueOf(Die.checkFullHouse(diceRolls));
			fullHouse1.setText(Integer.valueOf(Die.checkFullHouse(diceRolls)).toString());
			playerTurn.setText("Player 2's turn!");
			clearDie();
			player1Turn = false;
			fullHouse1.setEnabled(false);
			rollDice.setEnabled(true);
		}
	}
	
	//actionListener for the small straight buttons
	public class smStr1 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			diceRollNum = 1;
			p1Total += Integer.valueOf(Die.checkSmallStraight(diceRolls));
			smStr1.setText(Integer.valueOf(Die.checkSmallStraight(diceRolls)).toString());
			playerTurn.setText("Player 2's turn!");
			clearDie();
			player1Turn = false;
			smStr1.setEnabled(false);
			rollDice.setEnabled(true);
		}
	}
	
	//actionListener for the large straight buttons
	public class lgStr1 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			diceRollNum = 1;
			p1Total += Integer.valueOf(Die.checkLargeStraight(diceRolls));
			lgStr1.setText(Integer.valueOf(Die.checkLargeStraight(diceRolls)).toString());
			playerTurn.setText("Player 2's turn!");
			clearDie();
			player1Turn = false;
			lgStr1.setEnabled(false);
			rollDice.setEnabled(true);
		}
	}
	
	//actionListener for the yahtzee buttons
	public class yahtzee1 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			diceRollNum = 1;
			p1Total += Integer.valueOf(Die.checkYahtzee(diceRolls));
			yahtzee1.setText(Integer.valueOf(Die.checkYahtzee(diceRolls)).toString());
			playerTurn.setText("Player 2's turn!");
			clearDie();
			player1Turn = false;
			yahtzee1.setEnabled(false);
			rollDice.setEnabled(true);
		}
	}
	
	//actionListener for the chance buttons
	public class chance1 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			diceRollNum = 1;
			p1Total += Integer.valueOf(Die.checkChance(diceRolls));
			chance1.setText(Integer.valueOf(Die.checkChance(diceRolls)).toString());
			playerTurn.setText("Player 2's turn!");
			clearDie();
			player1Turn = false;
			chance1.setEnabled(false);
			rollDice.setEnabled(true);
		}
	}
	
	//actionListener for the bonus yahtzee buttons
	public class bonus1 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			boolean isBonus = true;
			for(boolean use: p1buttonUsed) {
				if(use == false) {
					isBonus = false;
					break;
				}
			}
			if(isBonus == false && aces1.isEnabled())
				gameHelp.setText("Please fill in Aces through Sixes before Bonus Yahtzee!");
			if(isBonus == false && twos1.isEnabled())
				gameHelp.setText("Please fill in Aces through Sixes before Bonus Yahtzee!");			
			if(isBonus == false && threes1.isEnabled())
				gameHelp.setText("Please fill in Aces through Sixes before Bonus Yahtzee!");
			if(isBonus == false && fours1.isEnabled())
				gameHelp.setText("Please fill in Aces through Sixes before Bonus Yahtzee!");
			if(isBonus == false && fives1.isEnabled())
				gameHelp.setText("Please fill in Aces through Sixes before Bonus Yahtzee!");
			if(isBonus == false && sixes1.isEnabled())
				gameHelp.setText("Please fill in Aces through Sixes before Bonus Yahtzee!");
			else if(p1BonusNum <= 3 && isBonus == true){
				diceRollNum = 1;
				p1Total += 100;
				bonus1.setText((Integer.valueOf(p1BonusNum * 100)).toString());
				playerTurn.setText("Player 2's turn!");
				clearDie();
				player1Turn = false;
				p1BonusNum++;
				rollDice.setEnabled(true);
			}else if(p1BonusNum > 3){
				gameHelp.setText("All Bonus Yahtzees have already been used.");
				bonus1.setEnabled(false);
				rollDice.setEnabled(true);
			}
		}
	}
	
	//actionListener for the aces buttons
	public class aces2 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			diceRollNum = 1;
			p2Upper += Integer.valueOf(Die.checkAces(diceRolls));
			aces2.setText(Integer.valueOf(Die.checkAces(diceRolls)).toString());
			playerTurn.setText("Player 1's turn!");
			clearDie();
			player1Turn = true;
			p2buttonUsed[0] = true;
			aces2.setEnabled(false);
			rollDice.setEnabled(true);
			num++;
		}
	}
	
	//actionListener for the twos buttons
	public class twos2 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			diceRollNum = 1;
			p2Upper += Integer.valueOf(Die.checkTwos(diceRolls));
			twos2.setText(Integer.valueOf(Die.checkTwos(diceRolls)).toString());
			playerTurn.setText("Player 1's turn!");
			clearDie();
			player1Turn = true;
			p2buttonUsed[1] = true;
			twos2.setEnabled(false);
			rollDice.setEnabled(true);
			num++;
		}
	}
	
	//actionListener for the threes buttons
	public class threes2 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			diceRollNum = 1;
			p2Upper += Integer.valueOf(Die.checkThrees(diceRolls));
			threes2.setText(Integer.valueOf(Die.checkThrees(diceRolls)).toString());
			playerTurn.setText("Player 1's turn!");
			clearDie();
			player1Turn = true;
			p2buttonUsed[2] = true;
			threes2.setEnabled(false);
			rollDice.setEnabled(true);
			num++;
		}
	}
	
	//actionListener for the fours buttons
	public class fours2 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			diceRollNum = 1;
			p2Upper += Integer.valueOf(Die.checkFours(diceRolls));
			fours2.setText(Integer.valueOf(Die.checkFours(diceRolls)).toString());
			playerTurn.setText("Player 1's turn!");
			clearDie();
			player1Turn = true;
			p2buttonUsed[3] = true;
			fours2.setEnabled(false);
			rollDice.setEnabled(true);
			num++;
		}
	}
	
	//actionListener for the fives buttons
	public class fives2 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			diceRollNum = 1;
			p2Upper += Integer.valueOf(Die.checkFives(diceRolls));
			fives2.setText(Integer.valueOf(Die.checkFives(diceRolls)).toString());
			playerTurn.setText("Player 1's turn!");
			clearDie();
			player1Turn = true;
			p1buttonUsed[4] = true;
			rollDice.setEnabled(true);
			fives2.setEnabled(false);
			num++;
		}
	}
	
	//actionListener for the sixes buttons
	public class sixes2 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			diceRollNum = 1;
			p2Upper += Integer.valueOf(Die.checkSixes(diceRolls));
			sixes2.setText(Integer.valueOf(Die.checkSixes(diceRolls)).toString());
			playerTurn.setText("Player 1's turn!");
			clearDie();
			player1Turn = true;
			p1buttonUsed[5] = true;
			sixes2.setEnabled(false);
			rollDice.setEnabled(true);
			num++;
		}
	}
	
	//actionListener for the three of a kind buttons
	public class threeK2 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			diceRollNum = 1;
			p2Total += Integer.valueOf(Die.checkThreeKind(diceRolls));
			threeK2.setText(Integer.valueOf(Die.checkThreeKind(diceRolls)).toString());
			playerTurn.setText("Player 1's turn!");
			clearDie();
			player1Turn = true;
			threeK2.setEnabled(false);
			rollDice.setEnabled(true);
			num++;
		}
	}
	
	//actionListener for the four of a kind buttons
	public class fourK2 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			diceRollNum = 1;
			p2Total += Integer.valueOf(Die.checkFourKind(diceRolls));
			fourK2.setText(Integer.valueOf(Die.checkFourKind(diceRolls)).toString());
			playerTurn.setText("Player 1's turn!");
			clearDie();
			player1Turn = true;
			fourK2.setEnabled(false);
			rollDice.setEnabled(true);
			num++;
		}
	}
	
	//actionListener for the full house buttons
	public class fullHouse2 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			diceRollNum = 1;
			p2Total += Integer.valueOf(Die.checkFullHouse(diceRolls));
			fullHouse2.setText(Integer.valueOf(Die.checkFullHouse(diceRolls)).toString());
			playerTurn.setText("Player 1's turn!");
			clearDie();
			player1Turn = true;
			fullHouse2.setEnabled(false);
			rollDice.setEnabled(true);
			num++;
		}
	}
	
	//actionListener for the small straight buttons
	public class smStr2 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			diceRollNum = 1;
			p2Total += Integer.valueOf(Die.checkSmallStraight(diceRolls));
			smStr2.setText(Integer.valueOf(Die.checkSmallStraight(diceRolls)).toString());
			playerTurn.setText("Player 1's turn!");
			clearDie();
			player1Turn = true;
			smStr2.setEnabled(false);
			rollDice.setEnabled(true);
			num++;
		}
	}
	
	//actionListener for the large straight buttons
	public class lgStr2 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			diceRollNum = 1;
			p2Total += Integer.valueOf(Die.checkLargeStraight(diceRolls));
			lgStr2.setText(Integer.valueOf(Die.checkLargeStraight(diceRolls)).toString());
			playerTurn.setText("Player 1's turn!");
			clearDie();
			player1Turn = true;
			lgStr2.setEnabled(false);
			rollDice.setEnabled(true);
			num++;
		}
	}
	
	//actionListener for the yahtzee buttons
	public class yahtzee2 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			diceRollNum = 1;
			p2Total += Integer.valueOf(Die.checkYahtzee(diceRolls));
			yahtzee2.setText(Integer.valueOf(Die.checkYahtzee(diceRolls)).toString());
			playerTurn.setText("Player 1's turn!");
			clearDie();
			player1Turn = true;
			yahtzee2.setEnabled(false);
			rollDice.setEnabled(true);
			num++;
		}
	}
	
	//actionListener for the chance button
	public class chance2 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			diceRollNum = 1;
			p2Total += Integer.valueOf(Die.checkChance(diceRolls));
			chance2.setText(Integer.valueOf(Die.checkChance(diceRolls)).toString());
			playerTurn.setText("Player 1's turn!");
			clearDie();
			player1Turn = true;
			chance2.setEnabled(false);
			rollDice.setEnabled(true);
			num++;
		}
	}
	
	//actionListener for the bonus yahtzee button
	public class bonus2 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			boolean isBonus = true;
			for(boolean use: p2buttonUsed) {
				if(use == false) {
					isBonus = false;
					break;
				}
			}
			if(isBonus == false && aces2.isEnabled())
				gameHelp.setText("Please fill in Aces through Sixes before Bonus Yahtzee!");
			else if(isBonus == false && twos2.isEnabled())
				gameHelp.setText("Please fill in Aces through Sixes before Bonus Yahtzee!");			
			else if(isBonus == false && threes2.isEnabled())
				gameHelp.setText("Please fill in Aces through Sixes before Bonus Yahtzee!");
			else if(isBonus == false && fours2.isEnabled())
				gameHelp.setText("Please fill in Aces through Sixes before Bonus Yahtzee!");
			else if(isBonus == false && fives2.isEnabled())
				gameHelp.setText("Please fill in Aces through Sixes before Bonus Yahtzee!");
			else if(isBonus == false && sixes2.isEnabled())
				gameHelp.setText("Please fill in Aces through Sixes before Bonus Yahtzee!");
			else if(p2BonusNum <= 3 && isBonus == true){
				diceRollNum = 1;
				p2Total += 100;
				bonus2.setText((Integer.valueOf(p2BonusNum * 100)).toString());
				playerTurn.setText("Player 1's turn!");
				clearDie();
				player1Turn = true;
				p2BonusNum++;
				rollDice.setEnabled(true);
				num++;
			}else if(p1BonusNum > 3){
				bonus2.setEnabled(false);
				gameHelp.setText("All Bonus Yahtzees have already been used.");
				rollDice.setEnabled(true);
				num++;
			}
		}
	}
}