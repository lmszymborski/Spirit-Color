
public class Answer {
private int changeRed;
private int changeBlue;
private int changeGreen;
private String answer;

public Answer(String answer, int changeRed, int changeGreen, int changeBlue) {
	this.answer = answer;
	this.changeBlue = changeBlue;
	this.changeGreen = changeGreen;
	this.changeRed = changeRed;
}

public Answer (String answer, boolean changeRed, boolean changeGreen, boolean changeBlue) {
	this.answer = answer;
	if (changeRed) {
		this.changeRed = 50;
	}
	if (changeBlue) {
		this.changeBlue = 50;
	}
	if (changeGreen) {
		this.changeGreen = 50;
	}
}

public String getAnswer() {
	return answer;
}

public int getChangeRed() {
	return changeRed;
}

public int getChangeGreen() {
	return changeGreen;
}

public int getChangeBlue() {
	return changeBlue;
}

}
