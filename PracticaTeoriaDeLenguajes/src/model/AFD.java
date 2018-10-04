/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author luis_
 */
public class AFD 
{
    public List<LamdaState> states;
    public String symbols;
    public String specialSymbols;
    
    public AFD ()
    {
        states = new LinkedList<>();
        symbols = "";
        specialSymbols = "±┤■";
    }
    
    public boolean evaluateString (String toEvaluate)        
    //±┤■"; // ┤ es fin de secuencia. ± es secuencia vacía. ■ es la secuencia nula
    {
        int actualState = 0;
        String actualSymbol = toEvaluate.substring(0, 1);
        if (!actualSymbol.equals("±") && !actualSymbol.equals("■"))
            for (int i = 0; i < toEvaluate.length(); i++)
            {
                actualSymbol = toEvaluate.substring(i, i+1);
                if (actualSymbol.equals("┤") || (!symbols.contains(actualSymbol) && !specialSymbols.contains(actualSymbol)))
                        break;
                LamdaState state = states.get(actualState);
                if (state.transitions.containsKey(actualSymbol))
                {
                    actualState = state.transitions.get(actualSymbol);
                } 
                else
                    return false;
            }
        if (!symbols.contains(actualSymbol) && !specialSymbols.contains(actualSymbol))
            return false;
        return states.get(actualState).isUptakingState;
    }
    
    public void printAutomaton ()
    {
        System.out.println("<-----------------------Automaton start----------------------->");
        for (LamdaState state : states)
        {
            System.out.println("State: " + states.indexOf(state) + " Uptaking: " + state.isUptakingState);
            state.printTransitions();
        }
        System.out.println("<------------------------Automaton end------------------------>");
    }
}
