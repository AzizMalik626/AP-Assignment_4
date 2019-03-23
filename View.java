/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author azizm
 */
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

class View extends JFrame {

    GridLayout grid = new GridLayout(3, 3);
    JButton[] buttons;
    Model model;
    boolean disable;
    JPanel myPanel;

    public View(Model model) {
        super("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myPanel  = new JPanel();
        myPanel.setLayout(grid);        
        myPanel.setPreferredSize(new Dimension(600, 600));
        buttons = new JButton[9];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(new ImageIcon(this.getClass().getResource("N.png")));//new ImageIcon()
            buttons[i].getPreferredSize();
            myPanel.add(buttons[i]);
        }
        add(myPanel);
        pack();
        setVisible(true);
        this.model = model;
        disable = false;
    }

   
    public boolean isWin() {
        int player1[]=new int[8];
        int player2[]=new int[8];
        for (int i = 0; i < player1.length; i++) 
        {
            player1[i]=0;
            player2[i]=0;
        }
        for (int i = 0; i < 3; i++) 
        {
            if (buttons[i].getText() == " ")
                player1[0]++;//p1 1st row
            if (buttons[i].getText() == "  ")
                player2[0]++;//p2 1st row
        }
        for (int i = 3; i < 6; i++)
        {
            if (buttons[i].getText() == " ")
                player1[1]++;//p1 2nd row
            if (buttons[i].getText() == "  ")
                player2[1]++;//p1 2nd row                
        }
        for (int i = 6; i < 9; i++)
        {
            if (buttons[i].getText() == " ")
                player1[2]++;//p1 3rd row
            if (buttons[i].getText() == "  ")
                player2[2]++;//p1 3rd row
        }
         
        
        for (int i = 0; i < 9; i += 3) {
            if (buttons[i].getText() == " ")
                player1[3]++;//p1 col 1
            if (buttons[i].getText() == "  ")
                player2[3]++;//p2 col 1
        }

        for (int i = 1; i < 9; i += 3) {
            if (buttons[i].getText() == " ")
                player1[4]++;//p1 col 2
            if (buttons[i].getText() == "  ")
                player2[4]++;//p2 col 2
        }

        for (int i = 2; i < 9; i += 3) {
            if (buttons[i].getText() == " ")
                player1[5]++;//p1 col 3
            if (buttons[i].getText() == "  ")
                player2[5]++;//p2 col 3
        }
        
        
        for (int i = 0; i < 9; i += 4) {
            if (buttons[i].getText() == " ")
                player1[6]++;//p1 col 3
            if (buttons[i].getText() == "  ")
                player2[6]++;//p2 col 3
        }

        for (int i = 2; i < 7; i += 2) {
            if (buttons[i].getText() == " ")
                player1[7]++;//p1 col 3
            if (buttons[i].getText() == "  ")
                player2[7]++;//p2 col 3
        }
        
        for (int i = 0; i < player1.length; i++) {
            if(player1[i]==3 | player2[i]==3)
            {
                //this.disableAll();
                return true;
            }
        }
        return false;
    }

    public void stateChecking() { 
        if (model.movesCounter == 9 || isWin() )
            disable = true;
    }

    public void disableAll() {
        for (int i = 0; i < buttons.length; i++)
            buttons[i].setEnabled(false);
    }
}