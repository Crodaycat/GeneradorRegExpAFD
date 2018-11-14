/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import java.util.List;
import model.AFD;
import model.Gramatic;
import model.LamdaState;
import model.Production;
import model.TerminalNonTerminal;

/**
 *
 * @author luis_
 */
public class GramaticUtils {
    public static Gramatic automatonToGramatic (AFD automaton)
    {
        ArrayList<Production> productions = new ArrayList<>(); // Producciones de la gramática
        List<LamdaState> states = automaton.states; // Estados del autómata
        String inSymbols = automaton.symbols; // Symbolos de entrada del autómata
        
        for (int i = 0; i < states.size(); i++)
        {
            LamdaState state = states.get(i);
            for (int j = 0; j < inSymbols.length(); j++)
            {
                String symbol = inSymbols.substring(j, j+1);
                Production prod = production(String.valueOf(i), state, symbol);
                if (prod != null) 
                    productions.add(prod);
            }
            if (state.isUptakingState)
            {
                Production prod = new Production(String.valueOf(i));
                prod.getRightSide().add(new TerminalNonTerminal("λ", false));
                productions.add(prod);
            }
        }
        Gramatic gramatic = new Gramatic(productions);
        return gramatic;
    }
    
    private static Production production (String leftSide, LamdaState state, String symbol)
    {
        Production prod = new Production(leftSide);
        if (state.transitions.containsKey(symbol))
        {
            TerminalNonTerminal terminal = new TerminalNonTerminal(symbol, false);
            TerminalNonTerminal nonTerminal = new TerminalNonTerminal(String.valueOf(state.transitions.get(symbol)), true);
            prod.getRightSide().add(terminal);
            prod.getRightSide().add(nonTerminal);
        } else
            return null;
        return prod;
    }
    
    // Este método calcula los primeros de una gramática de la forma especial
    public static ArrayList<String> productionFirst (Gramatic gramatic)
    {
        ArrayList<String> first = new ArrayList<>();
        gramatic.getProductions().forEach((prod) -> {
            first.add(prod.getRightSide().get(0).getSymbol());
        });
        return first;
    }
}

