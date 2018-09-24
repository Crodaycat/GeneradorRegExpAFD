/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.LinkedList;
import java.util.List;
import model.DoubleNode;
import model.ThompsonConstructor;

/**
 *
 * @author luis_
 */
public class SecuenceConstructor 
{
    String secuence;
    String simbols;
    String secSimbols;
    
    public SecuenceConstructor (String sec)
    {
        simbols = "()+*|.±┤■"; // ┤ es fin de secuencia. ± es secuencia vacía. ■ es la secuencia nula
        secuence = sec;
        secSimbols = "";
        separateSimbols();
    }
    
    private void separateSimbols ()
    {
        for (int i = 0; i < secuence.length(); i++)
        {
            String aux = secuence.substring(i, i+1);
            if(!simbols.contains(aux) && !secSimbols.contains(aux))
            {
                secSimbols += aux;
            }
        }
    }
    
    public DoubleNode CreateThompson()
    {
        DoubleNode start = ThompsonConstructor.nullConstruction();
        DoubleNode end = start.link1;
        end.uptakingState = true;
        String aux = secuence.substring(0,1);
        int counter = 1;
        switch (aux) 
        {
            case "(":
                divideSecWithStartingParenthesis(start, secuence, counter);
                break;
            default:
        }
        return start;
    }
    
    public static int searchForParenthesisClose (int counter, String secuence)
    {
        String aux = secuence.substring(counter,counter+1);
        counter++;
        int openP = 0;
        while (!(openP == 0 && aux.equals(")")))
        {
            if(aux.equals("("))
                openP++;
            else if (aux.equals(")") && openP > 0)
                openP--;
            else if (aux.equals(")") && openP == 0)
                break;
            aux = secuence.substring(counter, counter+1);
            counter++;
        }
        return counter;
    }
    
    public static void goOverAutomaton (DoubleNode start, List<DoubleNode> visited, int num) {
        if (!visited.contains(start))
        {
            visited.add(start);
            start.data = String.valueOf(num);
            if (start.link1 == null && start.link2 == null)
            {
                System.out.print("(end)");
                return;
            }
            else
            {
                if (start.link1 != null)
                {
                    String transition = start.link1.data.equals("") ? String.valueOf(num + 1): start.link1.data;
                    if (start.transition1.equals(""))
                        System.out.print("(" + start.data + ") -λ> (" + transition + ")");
                    else
                        System.out.print("(" + start.data + ") " + "- " + start.transition1 + " > (" + transition + ")");
                    num = start.link1.data.equals("") ? num+1: num;
                    SecuenceConstructor.goOverAutomaton(start.link1, visited, num);
                }
                
                if (start.link2 != null)
                {
                    String transition = start.link2.data.equals("") ? String.valueOf(num + 1): start.link2.data;
                    if (start.transition2.equals(""))
                        System.out.print("(" + start.data + ") -λ> (" + transition + ")");
                    else
                        System.out.print("(" + start.data + ") " + "- " + start.transition2 + " > (" + transition + ")");
                    num = start.link2.data.equals("") ? num+1: num;
                    SecuenceConstructor.goOverAutomaton(start.link2, visited, num);
                }
            }
        }
    }
    
    public static boolean isSimplifiable (DoubleNode start, List<DoubleNode> visited)
    {
        if (visited == null)
        {
            visited = new LinkedList<>();
            System.out.println("Lista nula");
        }
        
        if (!visited.contains(start))
        {
            visited.add(start);
            if (start.link1 == null && start.link2 == null)
            {
                return false;
            }
            else
            {
                if (start.link1 != null)
                {
                    if (start.transition1.length() > 1)
                        return true;
                    if (SecuenceConstructor.isSimplifiable(start.link1, visited))
                        return true;
                }
                
                if (start.link2 != null)
                {
                    if (start.transition2.length() > 1)
                        return true;
                    if (SecuenceConstructor.isSimplifiable(start.link2, visited))
                        return true;
                }
            }
        }
        return false;
    }
    
    public static void expandTransitions (DoubleNode start, List<DoubleNode> visited)
    {
        if (visited == null)
        {
            visited = new LinkedList<>();
            System.out.println("Lista nula");
        }
        
        if (!visited.contains(start))
        {
            visited.add(start);
            if (start.link1 == null && start.link2 == null)
                return;
            else
            {
                if (start.link1 != null)
                {
                    if (start.transition1.length() > 1)
                        expandTransition(start);
                    SecuenceConstructor.expandTransitions(start.link1, visited);
                }
                
                if (start.link2 != null)
                {
                    if (start.transition2.length() > 1)
                        //expandTransition(start);
                    SecuenceConstructor.expandTransitions(start.link2, visited);
                }
            }
        }
    }
    
    public static void expandTransition (DoubleNode start) {
        String secuence = start.transition1;
        if (secuence.length() <= 1)
            return;
        
        String aux = secuence.substring(0, 1);
        if (aux.equals("("))
        {
            divideSecWithStartingParenthesis(start, secuence, 1);
        } else
        {
            String sec1 = aux;
            aux = secuence.substring(1, 2);
            executeDivision(aux, sec1, secuence, 2, start);
        }
    }
    
    public static void divideSecWithStartingParenthesis (DoubleNode start, String secuence, int counter)
    {
        int open = counter-1;
        counter = searchForParenthesisClose (counter, secuence); // Busca su respectivo cierre paréntesis y devuelve la posición.
        String sec1 = secuence.substring(open, counter);
        if (counter == secuence.length())
        {
            sec1 = secuence.substring(open + 1, counter - 1);
            start.transition1 = sec1;
        }   
        else
        {
            String aux = secuence.substring(counter, counter + 1);
            counter++;
            executeDivision(aux, sec1, secuence, counter, start);
        }  
    }
    
    public static void executeDivision (String operator, String sec1, String secuence, int counter,DoubleNode start)
    {
        if (operator.equals("+") || operator.equals("*"))
        {
            if (counter == secuence.length())
                executeTimesOrPlusOperator(operator, sec1, start);
            else
            {
                sec1 += operator;
                operator = secuence.substring(counter, counter + 1);
                counter++;
                String sec2 = secuence.substring(counter, secuence.length());
                executeConcatOrUnionOperator(operator, sec1, sec2, start);
            }
        }
        else
        {
            String sec2 = secuence.substring(counter, secuence.length());
            executeConcatOrUnionOperator(operator, sec1, sec2, start);
        }
    }
    
    public static void executeTimesOrPlusOperator (String operator, String secuence, DoubleNode start)
    {
        DoubleNode end = start.link1;
        if (operator.equals("*"))
            ThompsonConstructor.asteriskConstruction(secuence, start, end);
        else if (operator.equals("+"))
            ThompsonConstructor.plusConstruction(secuence, start, end);
        else
            System.out.println("El operador ingresado no se reconoce: " + operator);
    }
    
    public static void executeConcatOrUnionOperator (String operator, String sec1, String sec2, DoubleNode start)
    {
        DoubleNode end = start.link1;
        if (operator.equals("|"))
            ThompsonConstructor.unionConstruction(sec1, sec2, start, end);
        else if (operator.equals("."))
            ThompsonConstructor.concatConstruction(sec1, sec2, start, end);
        else
            System.out.println("El operador ingresado no se reconoce: " + operator);
    }
}
