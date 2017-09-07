package Dice;

//holds static methods for checking the die
public class Die {
	
	public Die() {
		
	}
	//checks aces in the dicerolls
	public static int checkAces(int[] diceRolls) {
		int counter = 0;
		for(int num: diceRolls) {
			if(num == 1) {
				counter++;
			}
		}
		return counter;
	}
	//checks twos in the dicerolls
	public static int checkTwos(int[] diceRolls) {
		int counter = 0;
		for(int num: diceRolls) {
			if(num == 2) {
				counter++;
			}
		}
		return counter * 2;
	}
	//checks three in the dicerolls
	public static int checkThrees(int[] diceRolls) {
		int counter = 0;
		for(int num: diceRolls) {
			if(num == 3) {
				counter++;
			}
		}
		return counter * 3;
	}
	//checks fours in the dicerolls
	public static int checkFours(int[] diceRolls) {
		int counter = 0;
		for(int num: diceRolls) {
			if(num == 4) {
				counter++;
			}
		}
		return counter * 4;
	}
	//checks fives in the dicerolls
	public static int checkFives(int[] diceRolls) {
		int counter = 0;
		for(int num: diceRolls) {
			if(num == 5) {
				counter++;
			}
		}
		return counter * 5;
	}
	//checks sixes in the dicerolls
	public static int checkSixes(int[] diceRolls) {
		int counter = 0;
		for(int num: diceRolls) {
			if(num == 6) {
				counter++;
			}
		}
		return counter * 6;
	}
	//checks three of a kind in dicerolls
	public static int checkThreeKind(int[] diceRolls) {
		int ones = 0;
		int twos = 0;
		int threes = 0;
		int fours = 0;
		int fives = 0;
		int sixes = 0;
		for(int die: diceRolls) {
			if(die == 1){
				ones++;
			}else if(die == 2){
				twos++;
			}else if(die == 3) {
				threes++;
			}else if(die == 4) {
				fours++;
			}else if(die == 5) {
				fives++;
			}else{
				sixes++;
			}
		}
		if(ones == 3 || twos == 3 || threes == 3 || fours == 3 || fives == 3 || sixes == 3) {
			int sum = 0;
			for(int die: diceRolls) {
				sum += die;
			}
			return sum;
		}
		return 0;
	}
	//checks four of a kind in dicerolls
	public static int checkFourKind(int[] diceRolls) {
		int ones = 0;
		int twos = 0;
		int threes = 0;
		int fours = 0;
		int fives = 0;
		int sixes = 0;
		for(int die: diceRolls) {
			if(die == 1){
				ones++;
			}else if(die == 2){
				twos++;
			}else if(die == 3) {
				threes++;
			}else if(die == 4) {
				fours++;
			}else if(die == 5) {
				fives++;
			}else{
				sixes++;
			}
		}
		if(ones == 4 || twos == 4 || threes == 4 || fours == 4 || fives == 4 || sixes == 4) {
			int sum = 0;
			for(int die: diceRolls) {
				sum += die;
			}
			return sum;
		}
		return 0;
	}
	//checks full house in dicerolls
	public static int checkFullHouse(int[] diceRolls) {
		//bubblesort to sort the diceRolls
		int[] newDiceRolls = new int[5];
		for(int i = 0; i < diceRolls.length; i++) {
			newDiceRolls[i] = diceRolls[i];
		}
        for (int i = 0; i < newDiceRolls.length; i++) {
            for (int j = 0; j < newDiceRolls.length-i - 1; j++) {
                if (newDiceRolls[j] > newDiceRolls[j + 1]) {
                    int temp = newDiceRolls[j];
                    newDiceRolls[j] = newDiceRolls[j + 1];
                    newDiceRolls[j + 1] = temp;
                }
            }
        }
        if(newDiceRolls[0] == newDiceRolls[1] && newDiceRolls[2] == newDiceRolls[3] && newDiceRolls[3] == newDiceRolls[4]) {
        	return 25;
        }
        if(newDiceRolls[0] == newDiceRolls[1] && newDiceRolls[1] == newDiceRolls[2] && newDiceRolls[3] == newDiceRolls[4]) {
        	return 25;
        }
        return 0;
	}
	//checks small straight in dicerolls
	public static int checkSmallStraight(int[] diceRolls) {
		//This counts up all your dice and puts the number of each, in order, in a new array. 
		//If the 5 dice you rolled were 3, 4, 3, 1, 6, new array would be {1, 0, 2, 1, 0, 1}
		int[] numDice = new int[6];
		for(int i: diceRolls) {
			numDice[i-1] += 1;
		}
		int straightCount = 0;
		for(int i: numDice) {
		    if(i > 0) {
		    	straightCount++;
		    }else {
		    	straightCount = 0;
		    }if(straightCount > 3) {
		    	return 30;
		    }
		}
		return 0;
	}
	//checks large straight in dicerolls
	public static int checkLargeStraight(int[] diceRolls) {
		//This counts up all your dice and puts the number of each, in order, in a new array. 
		//If the 5 dice you rolled were 3, 4, 3, 1, 6, new array would be {1, 0, 2, 1, 0, 1}
		int[] numDice = new int[6];
		for(int i: diceRolls) {
			numDice[i-1] += 1;
		}
		int straightCount = 0;
		for(int i: numDice) {
		    if(i > 0) {
		    	straightCount++;
		    }else {
		    	straightCount = 0;
		    }if(straightCount > 4) {
		    	return 40;
		    }
		}
		return 0;
	}
	//checks yahtzee in dicerolls
	public static int checkYahtzee(int[] diceRolls) {
		if(diceRolls[0] == diceRolls[1] && diceRolls[1] == diceRolls[2] && diceRolls[2] == diceRolls[3] && diceRolls[3] == diceRolls[4]) {
			return 50;
		}
		return 0;
	}
	//checks chance in dicerolls
	public static int checkChance(int[] diceRolls) {
		int sum = 0;
		for(int die: diceRolls) {
			sum += die;
		}
		return sum;
	}
}