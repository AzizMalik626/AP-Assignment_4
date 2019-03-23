/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javax.swing.ImageIcon;

/**
 *
 * @author azizm
 */
public class Model {
    public int movesCounter;
    public String userSymbol;
    ImageIcon x,o;
    

    public Model() {
        movesCounter = 0;
        x= new ImageIcon( this.getClass().getResource("X.png")) ;
        o= new ImageIcon( this.getClass().getResource("O.png")) ;
    }

    public void whoseTurn() {
        if (movesCounter % 2 == 0 )
            userSymbol = " ";
        else
            userSymbol = "  ";
    }

    public void updateCounter(){
        movesCounter++; 
    }
    
}
