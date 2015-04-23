package session2;

public class BowlingScoreCalculator {

	private int countFrames = 0;
	private boolean firstRoll = true;
	private int sum = 0;

	public int calculateScore(String rolls) {
		for (int rollIndex = 0; rollIndex < rolls.length() && countFrames < 10; rollIndex++) {
			char roll = rolls.charAt(rollIndex);
			if (rollIsStrike(roll)) {
				handleStrike(rolls, rollIndex);
			} else if (rollIsSpare(roll)) {
				handleSpare(rolls, rollIndex);
			} else {
				handleRegularRoll(rolls, rollIndex);
			}
		}
		return sum;
	}

	private void handleRegularRoll(String rolls, int i) {
		sum += getValueForRolls(rolls, i);
		if (firstRoll == true) {
			firstRoll = false;
		} else {
			countFrames++;
			firstRoll = true;
		}
	}

	private void handleSpare(String rolls, int i) {
		if (rolls.charAt(i - 1) != '-') {
			sum -= getValueForRolls(rolls, i - 1);
		}
		sum += 10;
		if (rolls.charAt(i + 1) != '-') {
			sum += getValueForRolls(rolls, i + 1);
		}
		countFrames++;
		firstRoll = true;
	}

	private boolean rollIsSpare(char roll) {
		return roll == '/';
	}

	private boolean rollIsStrike(char roll) {
		return roll == 'X';
	}

	private void handleStrike(String rolls, int i) {
		sum += 10;
		sum += getValueForRolls(rolls, i + 1);
		sum += getValueForRolls(rolls, i + 2);
		countFrames++;
		firstRoll = true;
	}

	private int getValueForRolls(String rolls, int rollIndex) {
		char roll = rolls.charAt(rollIndex);
		if (rollIsStrike(roll)) {
			return 10;
		} else if (roll == '-') {
			return 0;
		} else {
			return Integer.parseInt(roll + "");
		}
	}

}
