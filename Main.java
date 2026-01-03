
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main   {

    static int myNumber = ThreadLocalRandom.current().nextInt(0
            , 100 + 1);

    static int tries = 0;
    static JLabel text = new JLabel(" Gebe eine Zahl zwischen 0 und 100 ein!");
    static JTextField textFied = new JTextField();

    public static void main(String[] args) {
        openUI();
    // nextRound();
    }

    public static void openUI() {
        JFrame frame = new JFrame("Rate die Zahl!");
        frame.setSize(800, 300);
        frame.setLocation(100, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultLookAndFeelDecorated(true);


        text.setBounds(50, 50, 400, 30);


        textFied.setBounds(50,100,200,30);

        JButton button = new JButton("Raten");
        button.setBounds(50, 150, 200, 30);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             try {
                 String textFromTextfiled = textFied.getText();
                 int number = Integer.parseInt(textFromTextfiled);
                 guess(number);
             } catch (Exception e1){
             }
             {
                 text.setText("Bitte gebe eine Zahl ein!");
             }

            }
        });

        frame.add(text);
        frame.add(textFied);
        frame.add(button);
        frame.setLayout(null);
        frame.setVisible(true);


    }

 /*   public static void nextRound() {

        tries++;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte gebe eine zahl ein: ");
        int number = scanner.nextInt();
        guess(number);
    }*/

    public static void guess( Integer number){
        if(number == myNumber)
        {
            System.out.println("Richtig geraten!!!");
            System.out.println("Du hast " + tries + " versuche gebraucht!");

            text.setText("Richtig geraten mit " + tries + "versuchen!");
        }
        else {
           tries++;

            if(number < myNumber)
            {
                text.setText("Falsch geraten! Deine zahl ist zu klein!");
            } else {
                text.setText("Falsch geraten! Deine zahl ist zu groß!");
            }
           textFied.setText("");
            //nextRound();
        }
    }
}
