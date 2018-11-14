/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author luis_
 */
public class Production {
    private TerminalNonTerminal leftSide;
    private ArrayList<TerminalNonTerminal> rightSide;

    public Production() {
        rightSide = new ArrayList<> ();
    }

    public Production(String leftSide) {
        this.leftSide = new TerminalNonTerminal(leftSide, true);
        rightSide = new ArrayList<> ();
    } 

    public TerminalNonTerminal getLeftSide() {
        return leftSide;
    }

    public void setLeftSide(TerminalNonTerminal leftSide) {
        this.leftSide = leftSide;
    }

    public ArrayList<TerminalNonTerminal> getRightSide() {
        return rightSide;
    }

    public void setRightSide(ArrayList<TerminalNonTerminal> rightSide) {
        this.rightSide = rightSide;
    }
}
