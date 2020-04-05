// things i could potentially add: the ability to make own questions
// create class with ability to build a Question with parameters of how colors
// are shifted
// linked list?? of questions??
// enums? for colors?
// increase/decrease option?

// red is spunky/spontaneous
// green is calming and happy, friendly, optimistic, openminded
// blue is peace, organization, introversion, responsible
import java.util.ArrayList;
import java.awt.Color;
import java.util.Scanner;
public class SpiritColor {
	private ArrayList<Question> quiz;
	private int questionNumber;
	private Answer userAnswer;
	private ColorMixer colorMixer;
	private Color color;
	private static Scanner scnr;
	
	public SpiritColor() {
		quiz = new ArrayList<Question>();
		questionNumber = 0;
		colorMixer = new ColorMixer();
	}
	
	public SpiritColor(int capacity) {
		quiz = new ArrayList<Question>(capacity);
		questionNumber = 0;
		colorMixer = new ColorMixer();
	}
	
	public void buildColor() {
		int redChange = userAnswer.getChangeRed();
		int greenChange = userAnswer.getChangeGreen();
		int blueChange = userAnswer.getChangeBlue();
		colorMixer.addRed(redChange);
		colorMixer.addGreen(greenChange);
		colorMixer.addBlue(blueChange);
		System.out.print(colorMixer.getRGB());
	}
	
	public String getQuestion(int questionNumber) {
		return null;
	}
	
	public Question addQuestion(Question question) {
		quiz.add(question);
		return question;
	}
	
	public Question addQuestion(int index, Question question) {
		quiz.add(index, question);
		return question;
	}
	
	public Question deleteQuestion (Question question) {
		quiz.remove(question);
		return question;
	}
	
	public Question deleteQuestion (int index) {
		Question removedQuestion = quiz.remove(index);
		return removedQuestion;
	}
	public void getResults() {
		System.out.println("The color generated is a personal color depending on the exact answers you filled out!");
		System.out.println("Chances are, your color is not going to fit into one category of color.");
		System.out.println("Use the following guide to better your understanding:");
		System.out.println("Red: love, passion, anger, impatience");
		System.out.println("Orange: thirst, wealth, happiness, standout");
		System.out.println("Yellow: cheer, attention, childish, warmth, energy, optimism");
		System.out.println("Green: calming, jealous, relaxed");
		System.out.println("Blue: trust, calm, faith, power");
		System.out.println("Purple: luxurious, arrogance, myserious, sadness");	
	}
	
	public Answer getUserAnswer(int length) {
		boolean isNumber = false;
		int userAnswerNum;
		do {
			System.out.println("Enter answer 1 - " + length + ": ");
			while (!scnr.hasNextInt()) {
				String input = scnr.next();
				System.out.println(input + " is not a valid input");
			}
			userAnswerNum = scnr.nextInt();
		} while (userAnswerNum < 1 || userAnswerNum > length);
		userAnswer = quiz.get(questionNumber).getAnswer(userAnswerNum - 1);
		return userAnswer;
	}
	
	public void askQuestion(Question question) {
		scnr = new Scanner(System.in);
		System.out.println(question.getQuestion());
		int answerCounter = 0;
		for (int i = 0; i < question.getAnswers().length; i++) {
			Answer currentAnswer = question.getAnswer(i);
			answerCounter++;
			System.out.println(answerCounter + ": " + currentAnswer.getAnswer());
		}
		System.out.println("Your answer: " + getUserAnswer(answerCounter).getAnswer());
	}
	
	public void goThroughQuiz() {
		for (int i = 0; i < quiz.size(); i++) {
			int questionNum = questionNumber + 1;
			System.out.println("Question " + questionNum + ": ");
			askQuestion(quiz.get(i));
			buildColor();
			colorMixer.addQuestion();
			questionNumber++;
			System.out.println("");
		}
		colorMixer.showColor();
		getResults();
	}
	
	public static void main (String[] args) {
		SpiritColor spiritColor = new SpiritColor();
		// question 1
		String q1str = "What do you like to do on the weeknights?";
		//answers
		String q1ans1str = "Go to a party or a bar"; // red
		String q1ans2str = "Watch a movie"; // blue
		String q1ans3str = "Have a night in with my friends"; // yellow
		String q1ans4str = "Get extra work done"; // orange
		String q1ans5str = "Do one of my hobbies"; // purple
		String q1ans6str = "Go on social media"; // green
		//answer codes
		Answer q1ans1 = new Answer(q1ans1str, 255, 0, 0);
		Answer q1ans2 = new Answer(q1ans2str, 0, 0, 255);
		Answer q1ans3 = new Answer(q1ans3str, 255, 255, 0);
		Answer q1ans4 = new Answer(q1ans4str, 255, 165, 0);
		Answer q1ans5 = new Answer(q1ans5str, 128, 0, 128);
		Answer q1ans6 = new Answer(q1ans6str, 0, 128, 0);
		Answer[] q1answers = new Answer[] {q1ans1, q1ans2, q1ans3, q1ans4, q1ans5, q1ans6};
		Question question1 = new Question(q1str, q1answers);
		
		// question 2
		String q2str = "What is your best quality?";
		//answers
		String q2ans1str = "I'm very caring"; // red
		String q2ans2str = "I'm a natural leader"; // blue
		String q2ans3str = "My ability to entertain"; // yellow
		String q2ans4str = "My loyalty"; // orange
		String q2ans5str = "I'm not afraid to take risks"; // purple
		String q2ans6str = "I'm very level-headed"; // green
		// answer codes
		Answer q2ans1 = new Answer(q2ans1str, 255, 0, 0);
		Answer q2ans2 = new Answer(q2ans2str, 128, 0, 128);
		Answer q2ans3 = new Answer(q2ans3str, 255, 255, 0);
		Answer q2ans4 = new Answer(q2ans4str, 255, 165, 0);
		Answer q2ans5 = new Answer(q2ans5str, 50, -100, 50);
		Answer q2ans6 = new Answer(q2ans6str, 0, 128, 0);
		Answer[] q2answers = new Answer[] {q2ans1, q2ans2, q2ans3, q2ans4, q2ans5, q2ans6};
		Question question2 = new Question(q2str, q2answers);
		
		// question 3
		String q3str = "What field do you want to go into?";
		// answers
		String q3ans1str = "Something artistic like dance, music, art, etc."; // yellow
		String q3ans2str = "Something in computers"; // blue
		String q3ans3str = "Something in biology/chemistry"; // orange
		String q3ans4str = "Something in humanities"; // red
		String q3ans5str = "I'm not sure yet"; // green
		String q3ans6str = "None of these";
		String q3ans7str = "Something in Law"; // purple
		// answer codes
		Answer q3ans1 = new Answer(q3ans1str, 255, 255, 0);
		Answer q3ans2 = new Answer(q3ans2str, 0, 0, 255);
		Answer q3ans3 = new Answer(q3ans3str, 60, 40, -100);
		Answer q3ans4 = new Answer(q3ans4str, 255, 0, 0);
		Answer q3ans5 = new Answer(q3ans5str, 0, 128, 0);
		Answer q3ans6 = new Answer(q3ans6str, 0, 0, 0);
		Answer q3ans7 = new Answer(q3ans7str, 128, 0, 128);
		Answer[] q3answers = new Answer[] {q3ans1, q3ans2, q3ans3, q3ans4, q3ans7, q3ans5, q3ans6};
		Question question3 = new Question(q3str, q3answers);
		
		// question 4
		String q4str = "What's your favorite social media?";
		// answers
		String q4ans1str = "Instagram"; // purple
		String q4ans2str = "Snapchat"; // orange
		String q4ans3str = "Twitter"; // blue
		String q4ans4str = "TikTok"; // yellow
		String q4ans5str = "Reddit"; // green
		String q4ans6str = "Youtube"; // red
		// answer codes
		Answer q4ans1 = new Answer(q4ans1str, 128, 0, 128); // purple
		Answer q4ans2 = new Answer(q4ans2str, 255, 165, 0); // orange
		Answer q4ans3 = new Answer(q4ans3str, 0, 0, 255); // blue
		Answer q4ans4 = new Answer(q4ans4str, 255, 255, 0); // yellow
		Answer q4ans5 = new Answer(q4ans5str, 0, 128, 0); // green
		Answer q4ans6 = new Answer(q4ans6str, 255, 0, 0); // red
		Answer[] q4answers = new Answer[] {q4ans1, q4ans2, q4ans3, q4ans4, q4ans5, q4ans6};
		Question question4 = new Question(q4str, q4answers);
		
		// question 5
		String q5str = "What is your favorite animal?";
		// answers
		String q5ans1str = "Cat"; // orange
		String q5ans2str = "Dog"; // yellow
		String q5ans3str = "Horse"; // purple
		String q5ans4str = "Cheetah"; // green
		String q5ans5str = "Lion"; // blue
		String q5ans6str = "Swan"; // red
		// answer codes
		Answer q5ans1 = new Answer(q5ans1str, 255, 165, 0); // orange
		Answer q5ans2 = new Answer(q5ans2str, 255, 255, 0); // yellow
		Answer q5ans3 = new Answer(q5ans3str, 128, 0, 128); // purple
		Answer q5ans4 = new Answer(q5ans4str, 0, 128, 0); // green
		Answer q5ans5 = new Answer(q5ans5str, 0, 0, 255); // blue
		Answer q5ans6 = new Answer(q5ans6str, 255, 0, 0); // red

		Answer[] q5answers = new Answer[] {q5ans1, q5ans2, q5ans3, q5ans4, q5ans5, q5ans6};
		Question question5 = new Question(q5str, q5answers);
		
		// question 6
		String q6str = "What kind of TV do you like to watch?";
		// answers
		String q6ans1str = "Drama"; // purple
		String q6ans2str = "Comedies"; // yellow
		String q6ans3str = "Feel-good"; // red
		String q6ans4str = "Reality TV"; // green
		String q6ans5str = "Documentaries"; // blue
		String q6ans6str = "Sports"; // orange
		// answer codes
		Answer q6ans1 = new Answer(q6ans1str,  128, 0, 128); // purple
		Answer q6ans2 = new Answer(q6ans2str, 255, 255, 0); // yellow
		Answer q6ans3 = new Answer(q6ans3str, 255, 0, 0); // red
		Answer q6ans4 = new Answer(q6ans4str, 0, 128, 0); // green
		Answer q6ans5 = new Answer(q6ans5str, 0, 0, 255); // blue
		Answer q6ans6 = new Answer(q6ans6str, 255, 165, 0); // orange
		
		Answer[] q6answers = new Answer[] {q6ans1, q6ans2, q6ans3, q6ans4, q6ans5, q6ans6};
		Question question6 = new Question(q6str, q6answers);
		
		spiritColor.addQuestion(question1);
		spiritColor.addQuestion(question2);
		spiritColor.addQuestion(question3);
		spiritColor.addQuestion(question4);
		spiritColor.addQuestion(question5);
		spiritColor.addQuestion(question6);
		spiritColor.goThroughQuiz();
	}
}
