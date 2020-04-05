
public class Question {
	private String question;
	private Answer[] answers;

	public Question(String question, Answer[] answers) {
		this.question = question;
		this.answers = answers;
	}
	
	public Answer getAnswer(int index) {
		return answers[index];
	}
	
	public String getQuestion() {
		return question;
	}
	
	public String addAnswer() {
		return null;
	}
	
	public String addAnswer(int index) {
		return null;
	}
	
	public String deleteAnswer() {
		return null;
	}
	
	public String deleteAnswer(int index) {
		return null;
	}
	
	public Answer[] getAnswers() {
		return answers;
	}
	
	public int[] getColorForSpecificAnswer() {
		return null;
	}
}
