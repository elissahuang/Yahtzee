package Scorecard;

import java.awt.Color;

public class Score {
	private String name;//name of the type of score
	private boolean hasPreset;//does the type of score have a preset value
	private int presetValue;//the preset value, if it exists
	private int score;//the score the user has in that location
	private Color color;//the color of the score
	
	public Score(String name, boolean hasPreset, int presetValue, int score, Color color) {
		this.name = name;
		this.hasPreset = hasPreset;
		this.presetValue = presetValue;
		this.score = score;
		this.color = color;
	}
	public String getName() {
		return name;
	}
	public boolean getHasPreset() {
		return hasPreset;
	}
	public int getPresetValue() {
		return presetValue;
	}
	public int getScore() {
		return score;
	}
	public Color getColor() {
		return color;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setHasPreset(boolean hasPreset) {
		this.hasPreset = hasPreset;
	}
	public void setPresetValue(int presetValue) {
		this.presetValue = presetValue;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public String toString() {
		return name;
	}
	
}