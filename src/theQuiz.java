/**
 * Created by paypaytr on 8/18/17.
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class theQuiz  extends JPanel implements ActionListener {


    int correctAns;
    GofretJavaQuiz quiz;
    int selected;
    boolean used;
    //questions
    JPanel qPanel=new JPanel();
    //answers
    JPanel aPanel=new JPanel();
    JRadioButton[] responses;
    ButtonGroup group=new ButtonGroup();
    //bottom
    JPanel botPanel=new JPanel();
    JButton next=new JButton("Next");
    JButton finish=new JButton("Finish");
    ImageIcon icon = new ImageIcon("rid.jpg");
    JButton bimage = new JButton(icon);
	/*public static void main(String args[]){
		JFrame frame=new JFrame("RadioButton Test");
		frame.setSize(400,300);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setResizable(true);

		String[] answers={"wrong1","right","wrong2"};
		frame.add(new RadioQuestion("what's right?",answers,1));

		frame.setVisible(true);
	}*/

    public theQuiz(String q, String[] options, int ans, GofretJavaQuiz quiz){
        this.quiz=quiz;
        add(bimage);
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        correctAns=ans;
        //question
        qPanel.add(new JLabel(q));
        add(qPanel);
        //answer
        responses=new JRadioButton[options.length];
        for(int i=0;i<options.length;i++){
            responses[i]=new JRadioButton(options[i]);
            responses[i].addActionListener(this);
            group.add(responses[i]);
            aPanel.add(responses[i]);
        }
        add(aPanel);
        //bottom
        next.addActionListener(this);
        finish.addActionListener(this);
        botPanel.add(next);
        botPanel.add(finish);
        add(botPanel);
    }

    public void actionPerformed(ActionEvent e){
        Object src=e.getSource();
        //next button
        if(src.equals(next)){
            showResult();
            if(selected==correctAns){
                used=true;
                quiz.next();
            }
        }
        //finish button
        if(src.equals(finish)){
            quiz.showSummary();
        }
        //radio buttons
        for(int i=0;i<responses.length;i++){
            if(src==responses[i]){
                selected=i;
            }
        }
    }

    public void showResult(){
        String text=responses[selected].getText();
        quiz.total++;
        if(selected==correctAns){
            JOptionPane.showMessageDialog(null,text+" is correct\nWell Done :)");
        }else{
            quiz.wrongs++;
            JOptionPane.showMessageDialog(null,text+" is wrong\nSorry :(");
        }
    }
}