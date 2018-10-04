/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
        if (actualSymbol.equals("■"))
            return false;
        if (!actualSymbol.equals("±"))
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
    
    public void simplifyAutomaton ()
    {
        for (int i = 0; i < states.size() - 1; i++)
        {
            LamdaState state = states.get(i);
            for (int j = i+1; j < states.size(); j++)
            {
                LamdaState actState = states.get(j);
                if (state.isUptakingState == actState.isUptakingState && state.transitions.equals(actState.transitions)) 
                {
                    removeEquivalentState(i, j);
                    j = j-1;
                }
            }
        }
    }
    
    private void removeEquivalentState(int first, int equivalent)
    {
        System.out.println(first + " y " + equivalent + " son equivalentes.");
        for (int i = 0; i < states.size(); i++)
        {
            if (i == equivalent)
                continue;
            LamdaState state = states.get(i);
            for (Map.Entry<String, Integer> transition : state.transitions.entrySet())
            {
                if (transition.getValue() == equivalent)
                    transition.setValue(first);
                else if (transition.getValue() > equivalent)
                    transition.setValue(transition.getValue() - 1);
            }
        }
        states.remove(equivalent);
    }
}
