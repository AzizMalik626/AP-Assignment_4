/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author azizm
 */
public class Controller implements ActionListener{
    View view;
    Model mModel;
    

    public Controller(Model model, View view) {
        this.mModel = model;
        this.view = view;
        
        addActionListeners();
    }

    private void addActionListeners() {
        for (int i = 0; i < view.buttons.length; i++)
            view.buttons[i].addActionListener(this);
        view.reset.addActionListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if( ( (JButton) e.getSource()).getText()   == "Reset Game")
        {
            view.resetAll();
        }
        else
        {
            if (view.disable == false) {
            mModel.whoseTurn();
            ((JButton) e.getSource()).setText(mModel.userSymbol);
            if(mModel.userSymbol.equals(" ")    )
            {
                ((JButton) e.getSource()).setIcon(mModel.x);
                ((JButton) e.getSource()).setEnabled(false);
            }
            else 
            {
                ((JButton) e.getSource()).setIcon(mModel.o);
                ((JButton) e.getSource()).setEnabled(false);
            }
            mModel.updateCounter();
            view.stateChecking();
            if (view.disable == true) {
                view.disableAll();
            }
        }
        }
        
    }
    
}
