package AstrologyQuiz;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ButtonGroup;

public class QuestionPanel extends JPanel {
	private JLabel lblQuestion;
	private JRadioButton rdbtnOpt0;
	private JRadioButton rdbtnOpt1;
	private JRadioButton rdbtnOpt2;
	private JRadioButton rdbtnOpt3;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public QuestionPanel() {
		setupComponents();
	}
	
	public QuestionPanel(QuestionSetup qS) {
		this(); //setup the components
		lblQuestion.setText(qS.getQuestion()); //set question
		rdbtnOpt0.setText(qS.getOpt0()); // set opt 0
		rdbtnOpt1.setText(qS.getOpt1()); // set opt 1
		rdbtnOpt2.setText(qS.getOpt2()); // set opt 2
		rdbtnOpt3.setText(qS.getOpt3()); // set opt 3
	}
	
	public String getSelectedOption() { //return back the selected option as radio buttons are private.
		if (this.rdbtnOpt0.isSelected()) {
			return this.rdbtnOpt0.getText();
		}
		if (this.rdbtnOpt1.isSelected()) {
			return this.rdbtnOpt1.getText();
		}
		if (this.rdbtnOpt2.isSelected()) {
			return this.rdbtnOpt2.getText();
		}
		if (this.rdbtnOpt3.isSelected()) {
			return this.rdbtnOpt3.getText();
		}
		return "";
	}
	
	
	public void setupComponents() {
		lblQuestion = new JLabel("Question");
		
		rdbtnOpt0 = new JRadioButton("Option 0");
		buttonGroup.add(rdbtnOpt0);
		
		rdbtnOpt1 = new JRadioButton("Option 1");
		buttonGroup.add(rdbtnOpt1);
		
		rdbtnOpt2 = new JRadioButton("Option 2");
		buttonGroup.add(rdbtnOpt2);
		
		rdbtnOpt3 = new JRadioButton("Option 3");
		buttonGroup.add(rdbtnOpt3);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(lblQuestion))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(rdbtnOpt0))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(rdbtnOpt1))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(rdbtnOpt2))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(rdbtnOpt3)))
					.addContainerGap(303, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(lblQuestion)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnOpt0)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnOpt1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnOpt2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnOpt3)
					.addContainerGap(149, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}
