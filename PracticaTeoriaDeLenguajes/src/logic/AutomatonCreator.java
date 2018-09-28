/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import model.AFD;
import model.DoubleNode;

/**
 *
 * @author luis_
 */
public class AutomatonCreator {
    public static AFD generateAFD (DoubleNode start)
    {
        List<DoubleNode> visited = new LinkedList<DoubleNode>();
        int num = 1;
        num = goOverSecuence(start, visited, num);
        // Set a name for all nodes and fill a given list with all nodes
        
        Collections.sort(visited, 
                (DoubleNode x, DoubleNode y) -> 
                Integer.compare(x.data, y.data)
        );
        printLamdas(getLamdaTransitions(visited));
        return null;
    }
    
    public static List<List<Integer>> getLamdaTransitions (List<DoubleNode> nodes)
    {
        List<List<Integer>> lamdaTransitions = new LinkedList<List<Integer>>();
        for (DoubleNode node:nodes)
        {
            List<Integer> transitions = new LinkedList<>();
            calculateLamdaTransitions(node, transitions);
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
