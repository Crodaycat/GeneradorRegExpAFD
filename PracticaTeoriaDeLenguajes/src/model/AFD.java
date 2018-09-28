/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author luis_
 */
public class AFD 
{
    public List<Integer> acceptationStates;
    public HashMap<Integer, HashMap<String, Integer>> states;
    private int errorState;
    
    public AFD ()
    {
        acceptationStates = new LinkedList<>();
        states = new HashMap<Integer, HashMap<String, Integer>>();
        errorState = 0;
    }
    
    public void generateErrorState ()
    {
        throw new UnsupportedOperationException();
    }
    
    public boolean evaluateString (String toEvaluate)
    {
        throw new UnsupportedOperationException();
    }
}
