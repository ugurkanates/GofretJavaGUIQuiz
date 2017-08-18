import javax.swing.*;
import java.util.Random;

/**
 * Created by paypaytr on 8/18/17.
 */
/*public class GofretJavaQuiz extends JPanel {
    int correctAns=0;
    JPanel questionpanel = new JPanel();
    JPanel answerpanel = new JPanel();
    JRadioButton [] responarray;
    ButtonGroup group  = new ButtonGroup();

    JButton next = new JButton("Next");
    JButton ginish = new JButton("Finish");
    //ImageIcon icon = new ImageIcon("/home/paypaytr/IdeaProjects/GofretQuizApp/src/rid.jpg");
    //JButton b3 = new JButton(icon);
  //  JTextField t1 = new JTextField("Sıkıldım",5);
  //  JTextArea ta = new JTextArea("abi moruk \n 123",5,5);


    public static void main(String[] args){
       GofretJavaQuiz a = new GofretJavaQuiz();
    }
    public GofretJavaQuiz(){
        JFrame gui = new JFrame();
        gui.setTitle("Gofret the Quiz");
        gui.setSize(350,350);
        gui.setResizable(false);
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gui.setVisible(false);
        //panel.add(b3);
        //panel.add(t1);
        //panel.add(ta);
       // gui.add(panel);
        JOptionPane.showMessageDialog(null,"Lets get started","info",JOptionPane.INFORMATION_MESSAGE);
        gui.setVisible(true);
    }
} */

import javax.swing.JFrame;
        import javax.swing.JPanel;
        import java.awt.CardLayout;
        import java.util.Random;
        import javax.swing.JOptionPane;

public class GofretJavaQuiz extends JFrame{
    JPanel p=new JPanel();
    CardLayout cards=new CardLayout();
    int numQs;
    int wrongs=0;
    int total=0;

    String[][] answers={
            {"BETHESDA","ID.Soft","Rockstar*","Valve"},
            {"Tarkan","Kusum Aydin","Aleyna Tilki","Bayhan"},
            {"Euler","Erasmus","Fibonnaci","Archemides"},
            {"Coke","Pepsi","Fanta(aka sari kola)","Sprite"},
            {"Deri Ceket","Motorcycle","Cigar","Sabri"},
            {"Nitrogen","Calcium"},
            {"True","False"},
            {"Besiktas","Fenerbahce","Galatasaray","Basaksehir"},
            {"The Lion King","Hamlet","Death of The Salesmen","Phantom of the Opera"},
    };

    theQuiz questions[]={

            new theQuiz(
                    "Which company made the game DOOM ?",
                    answers[0],
                    1,this
            ),
            new theQuiz(
                    "Who is more famous than the others?",
                    answers[1],
                    0,this
            ),
            new theQuiz(
                    "Who discovered the number e?",
                    answers[2],
                    0,this
            ),
            new theQuiz(
                    "Which makes you more fat",
                    answers[3],
                    0,this
            ),
            new theQuiz(
                    "Choose the one who doesn't group with others",
                    answers[4],
                    3,this
            ),
            new theQuiz(
                    "Which one human body has more ",
                    answers[5],
                    0,this
            ),
            new theQuiz(
                    "True or False, Elon Musk is Serbian",
                    answers[6],
                    1,this
            ),
            new theQuiz(
                    "Which one has most prizes?",
                    answers[7],
                    2,this
            ),
            new theQuiz(
                    "Which of these plays is made by shakespeare?",
                    answers[8],
                    1,this
            )
    };

    public static void main(String args[]){
        new GofretJavaQuiz();
    }

    public GofretJavaQuiz(){
        super("Quiz Game");
        setResizable(true);
        setSize(500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        p.setLayout(cards);
        numQs=questions.length;
        for(int i=0;i<numQs;i++){
            p.add(questions[i],"q"+i);
        }
        Random r=new Random();
        int i=r.nextInt(numQs);
        cards.show(p,"q"+i);
        add(p);
        setVisible(true);
    }

    public void next(){
        if((total-wrongs)==numQs){
            showSummary();
        }else{
            Random r=new Random();
            boolean found=false;
            int i=0;
            while(!found){
                i=r.nextInt(numQs);
                if(!questions[i].used){
                    found=true;
                }
            }
            cards.show(p,"q"+i);
        }
    }

    public void showSummary(){
        JOptionPane.showMessageDialog(null,"All Done :), here are your results"+
                "\nNumber of incorrect Answers: \t"+wrongs+
                "\nNumber of Correct Answers: \t"+(total-wrongs)+
                "\nAverage Incorrect Answers per Quesiotn: \t"+((float)wrongs/numQs)+
                "\nPercent Correct: \t\t"+(int)(((float)(total-wrongs)/total)*100)+"%"
        );
        System.exit(0);
    }
}