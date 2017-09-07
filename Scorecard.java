package Scorecard;

import java.awt.*;

public class Scorecard{
	public Score[] scores;//the scores
	private int upperTotal;
	private int lowerTotal;
	private int total;

	
	public Scorecard() {
		scores = new Score[18];
		createScorecard();
	}
	private void createScorecard() {
		scores [0] = new Score("Aces", false, 0, 0, Color.BLACK);
		scores [1] = new Score("Twos", false, 0, 0, Color.BLACK);
		scores [2] = new Score("Threes", false, 0, 0, Color.BLACK);
		scores [3] = new Score("Fours", false, 0, 0, Color.BLACK);
		scores [4] = new Score("Fives", false, 0, 0, Color.BLACK);
		scores [5] = new Score("Sixes", false, 0, 0, Color.BLACK);
		
		scores [6] = new Score("BONUS", true, 35, 0, Color.BLACK);
		
		scores [7] = new Score("3 of a kind", false, 0, 0, Color.BLACK);
		scores [8] = new Score("4 of a kind", false, 0, 0, Color.BLACK);
		scores [9] = new Score("Full House", true, 25, 0, Color.BLACK);
		scores[10] = new Score("Small Straight", true, 30, 0, Color.BLACK);
		scores[11] = new Score("Large Straight", true, 40, 0, Color.BLACK);
		scores[12] = new Score("Yahtzee", true, 50, 0, Color.BLACK);
		scores[13] = new Score("Chance", true, 0, 0, Color.BLACK);
		
		scores[14] = new Score("Yahtzee Bonus", true, 100, 0, Color.BLACK);
		
		scores[15] = new Score("Total of Upper", false, 0, upperTotal, Color.BLUE);
		scores[16] = new Score("Total of Lower", false, 0, lowerTotal, Color.BLUE);
		scores[17] = new Score("Grand Total", false, 0, total, Color.BLUE);
	}
	public void sumUpperTotal() {
		Score score;
		for(int i = 0; i < 6; i++) {
			score = scores[i];
			upperTotal += score.getScore();
		}
		if(upperTotal >= scores[6].getPresetValue()) {
			upperTotal += scores[6].getScore();
		}
	}
	
	public void sumLowerTotal() {
		Score score;
		for(int i = 7; i < 14; i++) {
			score = scores[i];
			lowerTotal += score.getScore();
		}
		score = scores[14];
		lowerTotal += score.getScore()*score.getPresetValue();
	}
	public void sumTotal() {
		total = upperTotal + lowerTotal;
	}
	public Score getScore(int num) {
		return scores[num];
	}
	public Score[] getScores() {
		return scores;
	}
	public void setScores(Score[] scores) {
		this.scores = scores;
	}
	public int getUpperTotal() {
		return upperTotal;
	}
	public int getLowerTotal() {
		return lowerTotal;
	}
	public int getTotal() {
		return total;
	}
	
}