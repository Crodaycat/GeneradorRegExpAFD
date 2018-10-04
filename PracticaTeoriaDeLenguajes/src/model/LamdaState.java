/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author luis_
 */
public class LamdaState {
    public List<Integer> lamdaTransitions;
    public HashMap<String, Integer> transitions;
    public boolean isUptakingState;
    
    public LamdaState()
    {
        lamdaTransitions = new LinkedList<>();
        transitions = new HashMap<String, Integer>();
        isUptakingState = false;
    }
    
    public LamdaState(List<Integer> lamda, boolean accepting)
    {
        lamdaTransitions = lamda;
        transitions = new HashMap<String, Integer>();
        isUptakingState = accepting;
    }
    
    public void printTransitions ()
    {
        for (Map.Entry<String, Integer> entry : transitions.entrySet())
        {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
