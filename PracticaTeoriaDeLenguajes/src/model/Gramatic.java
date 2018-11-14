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

public class Gramatic {
    private ArrayList<Production> productions;

    public Gramatic() {
        productions = new ArrayList<>();
    }
    
    public Gramatic(ArrayList<Production> productions) {
        this.productions = productions;
    }

    public ArrayList<Production> getProductions() {
        return productions;
    }

    public void setProductions(ArrayList<Production> productions) {
        this.productions = productions;
    }
    
    public void print () // cuando se vaya ese ruido desmuteo
    {
        System.out.println("<-----------------start gramatic--------------->");
        for (Production prod : productions)
        {
            System.out.print("<" + prod.getLeftSide().getSymbol() + "> -> ");
            for (TerminalNonTerminal tnt :  prod.getRightSide())
            {
                if (tnt.isIsNonTerminal())
                    System.out.print("<" + tnt.getSymbol() + ">");
                else
                    System.out.print(tnt.getSymbol());
            }
            System.out.println();
        }
        System.out.println("<---------------end gramatic----------------->");
    }
}
