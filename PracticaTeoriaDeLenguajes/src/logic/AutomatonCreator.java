/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.OptionalInt;
import model.AFD;
import model.DoubleNode;
import model.LamdaState;

/**
 *
 * @author luis_
 */
public class AutomatonCreator {
    public static AFD generateAFD (DoubleNode start, String transSymbols)
    {
        List<DoubleNode> nodes = new LinkedList<DoubleNode>();
        int num = 1;
        num = goOverSecuence(start, nodes, num);
        // Set a name for all nodes and fill a given list with all nodes
        
        Collections.sort(nodes, 
                (DoubleNode x, DoubleNode y) -> 
                Integer.compare(x.data, y.data)
        );
        
        List<List<Integer>> lamdaTransitions = getLamdaTransitions(nodes);
        printLamdas(lamdaTransitions);
        
        int uptakingNode = findUptakingNode(nodes);
        
        AFD afd = new AFD();
        afd.symbols = transSymbols;
        afd.states = createStates(uptakingNode, lamdaTransitions, transSymbols, nodes);
        
        return afd;
    }
    
    public static List<LamdaState> createStates (int uptakingNode, List<List<Integer>> lamdas, String transSymbols, List<DoubleNode> nodes)
    {
        List<LamdaState> states = new LinkedList<>();
        
        //If contains uptaking node tells it to be an uptaking state.
        LamdaState state = new LamdaState(lamdas.get(0), lamdas.get(0).contains(uptakingNode));
        states.add(state);
        
        for (int x = 0; x < states.size(); x++)
        {
            LamdaState st = states.get(x);
            for (int i = 0; i < transSymbols.length(); i++)
            {
                String symbol = transSymbols.substring(i,i+1);
                createState(uptakingNode, nodes, symbol, st, states, lamdas);
            }
        }
        
        return states;
    }
    
    public static void createState 
    (int uptakingNode, 
    List<DoubleNode> nodes, 
    String transition, 
    LamdaState state, 
    List<LamdaState> states, 
    List<List<Integer>> lamdaTrans)
    {
        LamdaState createdState = new LamdaState();
        System.out.println("---------------------------------");
        System.out.println("Estado numero: " + states.indexOf(state));
        System.out.print("Cierres lamda: ");
        for (Integer node : state.lamdaTransitions) 
        {
            if (nodes.get(node - 1).transition1.equals(transition))
            {
                System.out.println("trans1: ");
                System.out.print(nodes.get(node - 1).link1.data + ", ");
                List<Integer> transitions = lamdaTrans.get((nodes.get(node - 1).link1.data) - 1);
                for (Integer trans : transitions) {
                    if (!createdState.lamdaTransitions.contains(trans))
                    {
                        createdState.lamdaTransitions.add(trans);
                        createdState.isUptakingState = trans == uptakingNode ? true : createdState.isUptakingState;
                    }
                }
            }
            
            if (nodes.get(node - 1).transition2.equals(transition))
            {
                System.out.println("trans2: ");
                System.out.print(nodes.get(node - 1).link2.data + ", ");
                List<Integer> transitions = lamdaTrans.get((nodes.get(node - 1).link2.data) - 1);
                for (Integer trans : transitions) {
                    if (!createdState.lamdaTransitions.contains(trans))
                    {
                        createdState.lamdaTransitions.add(trans);
                        createdState.isUptakingState = trans == uptakingNode ? true : createdState.isUptakingState;
                    }
                }
            }
        }
        
        System.out.println("Simbolo de transición: " + transition);
        System.out.print("Estados: ");
        for (Integer num : createdState.lamdaTransitions)
        {
            System.out.print(num + ", ");
        }
        System.out.println("Trasición a: ");
        if (createdState.lamdaTransitions.size() > 0)
        {
            int stateNum = insertState(createdState, states);
            System.out.println(stateNum);
            state.transitions.put(transition, stateNum);
        }  
    }
    
    public static int insertState (LamdaState state, List<LamdaState> states)
    {
        Collections.sort(state.lamdaTransitions, 
                (Integer x, Integer y) -> 
                Integer.compare(x, y)
        );
        IntStream stream = IntStream.range(0, states.size())
            .filter(i -> states.get(i).lamdaTransitions.equals(state.lamdaTransitions));
        OptionalInt i = stream.findFirst();
        if (i.isPresent()) {
            return i.getAsInt();
        }   
        states.add(state);
        return (states.size() - 1);
    }
    
    public static int findUptakingNode (List<DoubleNode> nodes)
    {
        int uptakingNode = nodes.stream().
                filter(node -> node.uptakingState == true).
                findAny().orElse(null).data;
        return uptakingNode;
    }
    
    public static int insertState ()
    {
        return 0;
    }
    
    public static List<List<Integer>> getLamdaTransitions (List<DoubleNode> nodes)
    {
        List<List<Integer>> lamdaTransitions = new LinkedList<>();
        
        for (DoubleNode node:nodes)
        {
            List<Integer> transitions = new LinkedList<>();
            calculateLamdaTransitions(node, transitions);
            
            Collections.sort(transitions, 
                (Integer x, Integer y) -> 
                Integer.compare(x, y)
            ); // Sort the list ASC
            
            lamdaTransitions.add(transitions);
        }
        return  lamdaTransitions;
    }
    
    public static void printLamdas (List<List<Integer>> lamdas)
    {
        System.out.println("");
        for (List<Integer> lamda: lamdas) 
        {
            for (int lamdita: lamda)
            {
                System.out.print(lamdita);
                System.out.print(", ");
            }
            System.out.println("");
        }
        
    }
    
    public static void calculateLamdaTransitions (DoubleNode start, List<Integer> transitions)
    {
        if (!transitions.contains(start.data))
        {
            transitions.add(start.data);
            if (!(start.link1 == null) || !(start.link2 == null))
            {
                if (start.link1 != null && start.transition1.equals(""))
                {
                    calculateLamdaTransitions(start.link1, transitions);
                }
                
                if (start.link2 != null && start.transition2.equals(""))
                {
                    calculateLamdaTransitions(start.link2, transitions);
                }
            }
        }
    }
    
    public static int goOverSecuence (DoubleNode start, List<DoubleNode> visited, int num) {
        if (!visited.contains(start))
        {
            visited.add(start);
            start.data = num;
            if (start.link1 == null && start.link2 == null)
            {
                System.out.print(num + "(end)");
                return num;
            }
            else
            {
                if (start.link1 != null)
                {
                    int transition = start.link1.data == 0 ? (num + 1): start.link1.data;
                    if (start.transition1.equals(""))
                        System.out.print("(" + start.data + ") -λ> (" + transition + ")");
                    else
                        System.out.print("(" + start.data + ") " + "- " + start.transition1 + " > (" + transition + ")");
                    num = start.link1.data == 0 ? num+1: num;
                    num = goOverSecuence(start.link1, visited, num);
                }
                
                if (start.link2 != null)
                {
                    int transition = start.link2.data == 0 ? (num + 1): start.link2.data;
                    if (start.transition2.equals(""))
                        System.out.print("(" + start.data + ") -λ> (" + transition + ")");
                    else
                        System.out.print("(" + start.data + ") " + "- " + start.transition2 + " > (" + transition + ")");
                    num = start.link2.data == 0 ? num+1: num;
                    num = goOverSecuence(start.link2, visited, num);
                }
            }
        }
        return num;
    }
}
