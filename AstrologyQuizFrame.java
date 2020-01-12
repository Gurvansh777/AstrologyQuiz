package AstrologyQuiz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AstrologyQuizFrame extends JFrame {
	

	private JPanel panelNorth, panelCenter, contentPane;
	private JTextField txtUserName;
	private JLabel lblUserName;
	private JButton btnSubmit;
	private JScrollPane scrollPane;
	
	//Need to put these objects in an array. Add a counter to loop out 
	QuestionSetup qS, qS1, qS2;
	QuestionPanel qP, qP1, qP2;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AstrologyQuizFrame frame = new AstrologyQuizFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setupComponents() {
		
		setDefaultCloseOperation(3);
		setBounds(100, 100, 800, 400); //Bounds of the frame
		
		(contentPane = new JPanel()).setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.setLayout(new BorderLayout(0, 0)); //Setup a border layout
		panelNorth = new JPanel();
		contentPane.add(panelNorth, "North"); 
		
		panelNorth.setLayout(new FlowLayout(0, 5, 5)); //Add a flow layout on NORTH to push in name text field
		lblUserName = new JLabel("Name: ");
		panelNorth.add(lblUserName);
		
		txtUserName = new JTextField();
		panelNorth.add(txtUserName);
		
		txtUserName.setColumns(10);
		
		
		btnSubmit = new JButton("Submit"); // Add a submit button in SOUTH. Will calculate score on click
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  calculateScore();
			}
	
		});
		contentPane.add(btnSubmit, "South");
		
		scrollPane = new JScrollPane(); //Scroll bar in CENTER
		contentPane.add(scrollPane, "Center");
		
		panelCenter = new JPanel();
		scrollPane.setViewportView(panelCenter);
		panelCenter.setLayout(new GridLayout(0, 1, 0, 0)); //Grid Layout in CENTER so that every question is created vertically.
	
	}
				
	public void readDatabase() {
		//Read stuff from access db
		//Line by line..keep on creating QuestionSetup Objects.
		//Make sure counting number of objects which is equal to number of questions.
		//No we can put objects on question panel..can be done in the loop it self. Not sure!
		
		//If GUI works fine, calculateScore should work properly!
		//Just need to focus on reading and creating objects
		
		String[] questsfromDB = {"What is your name?", "A", "B", "C", "D", "D"};
		String[] quests1fromDB = {"What is your Age?", "1", "2", "3", "4", "C"};
		int counter = 0;
		
		 qS = new QuestionSetup(questsfromDB[0], questsfromDB[1], questsfromDB[2], questsfromDB[3], questsfromDB[4], questsfromDB[5]);
		 qS1 = new QuestionSetup(quests1fromDB[0], quests1fromDB[1], quests1fromDB[2], quests1fromDB[3], quests1fromDB[4], quests1fromDB[5]);
		 qS2 = new QuestionSetup("[0]", "[1]", "[2]", "[3]", "[4]", "A");
		counter++;
		 qP = new QuestionPanel(qS);	
		 qP1 = new QuestionPanel(qS1);
		 qP2 = new QuestionPanel(qS2);
		counter++;
		
		
		//for(int i = 0; i < counter; i++) {
		panelCenter.add(qP);
		panelCenter.add(qP1);
		panelCenter.add(qP2);
			
			
		//};
	}
	
	public void calculateScore() {
		int score = 0;
		if(qS.getAnswer().equals(qP.getSelectedOption())){
			score++;
		}
		if(qS1.getAnswer().equals(qP1.getSelectedOption())){
			score++;
		}
		if(qS2.getAnswer().equals(qP2.getSelectedOption())){
			score++;
		}
		
		JOptionPane.showMessageDialog(null,
				"Hi, " + txtUserName.getText() + "!  Your score is " + score + ".");
		
	}

	/**
	 * Create the frame.
	 */
	public AstrologyQuizFrame() {
		setTitle("Astrology Quiz"); //Setting up the title
		setupComponents(); //Start with creating components
		readDatabase();// Read database and create questions
	}

}
