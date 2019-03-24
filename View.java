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
import javax.swing.*;

class View extends JFrame {

    GridLayout grid = new GridLayout(3, 3);
    JButton[] buttons;
    Model model;
    boolean disable;
    JPanel myPanel;
    JPanel myPanel2;
    JLabel winLable;
    JButton reset;

    public View(Model model) {
        super("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Reset Button
        Font font1 = new Font("SansSerif", Font.BOLD, 24);
        winLable= new JLabel("");
        winLable.setFont(font1);
        //winLable.setVisible(false);
        reset = new JButton();
        reset.setFont(font1);
        reset.setText("Reset Game");
        reset.setSize(50,50);
        reset.setPreferredSize(new Dimension(10, 60));
        //........................
        
        //Panel 1
        myPanel  = new JPanel();
        myPanel.setLayout(grid);        
        myPanel.setPreferredSize(new Dimension(700, 500));
        buttons = new JButton[9];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(new ImageIcon(this.getClass().getResource("")));//new ImageIcon()
            buttons[i].getPreferredSize();
            myPanel.add(buttons[i]);
        }
        //..........................
        //Panel 2
        myPanel2= new JPanel(new GridBagLayout());
        myPanel2.setPreferredSize(new Dimension(500, 100));
        myPanel2.add(winLable);
        myPanel2.add(reset);
        
        GridBagConstraints gc2 = new GridBagConstraints();
        gc2.fill = GridBagConstraints.HORIZONTAL;
        gc2.weightx = 1;
        gc2.gridx = 0;
        gc2.gridy = 0;
        gc2.ipadx = 10;
        myPanel2.add(winLable, gc2);
        gc2.gridx = 1;
        gc2.gridy = 0;
        myPanel2.add(reset, gc2);
        //..............................
        //Main Frame
        this.add(myPanel,BorderLayout.CENTER);
        this.add(myPanel2,BorderLayout.PAGE_END);
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
            if(player1[i]==3)
            {
                //this.disableAll();
                winLable.setText("Palyer X Won");
                return true;
            }
        }
       
       for (int i = 0; i < player2.length; i++) {
            if(player2[i]==3)
            {
                //this.disableAll();
                winLable.setText("Palyer O Won");
                return true;
            }
        }
       int i=0;
       for (i=0; i < player1.length; i++) 
        {
            if(player1[i]==0 | player2[i]==0  )
                break;
        }
       if(i==player1.length)
           winLable.setText("It's a Tie");
       
       return false;
       
    }

    public void stateChecking() { 
        if (model.movesCounter == 9 || isWin() )
            disable = true;
        
    }

    public void disableAll() {
        for (JButton button : buttons) {
            button.setEnabled(false);
        }
    }
    public void resetAll() {
        for (JButton button : buttons) {
            button.setText("");
            button.setIcon(model.n);
            button.setEnabled(true);
            winLable.setText("");
            model.resetCounter();
            disable=false;
        }
    }
}