package AstrologyQuiz;

public class QuestionSetup {
	private String question, opt0, opt1, opt2, opt3, answer;
	
	public QuestionSetup(String question, String opt0, String opt1, String opt2, String opt3, String answer) {
		this.question = question;
		this.opt0 = opt0;
		this.opt1 = opt1;
		this.opt2 = opt2;
		this.opt3 = opt3;
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOpt0() {
		return opt0;
	}

	public void setOpt0(String opt0) {
		this.opt0 = opt0;
	}

	public String getOpt1() {
		return opt1;
	}

	public void setOpt1(String opt1) {
		this.opt1 = opt1;
	}

	public String getOpt2() {
		return opt2;
	}

	public void setOpt2(String opt2) {
		this.opt2 = opt2;
	}

	public String getOpt3() {
		return opt3;
	}

	public void setOpt3(String opt3) {
		this.opt3 = opt3;
	}

	public String getAnswer() {
		
	
		if(answer.equals("A")) {
			return opt0;
		}
		if(answer.equals("B")) {
			return opt1;
		}
		if(answer.equals("C")) {
			return opt2;
		}
		if(answer.equals("D")) {
			return opt3;
		}
		
		return "";
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
