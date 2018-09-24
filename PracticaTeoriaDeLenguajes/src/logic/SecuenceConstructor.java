/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

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
        String aux = secuence.substring(0,1);
        int contador = 1;
        switch (aux) 
        {
            case "(":
                int inicio = contador-1;
                contador = searchForParenthesisClose (contador);  // Busca su respectivo cierre paréntesis y devuelve la posición.
                String sec1 = secuence.substring(inicio, contador);
                System.out.println(sec1);
                aux = secuence.substring(contador, contador + 1);
                contador++;
                if (aux.equals("*") || aux.equals("+"))
                {
                    sec1 += aux;
                    aux = secuence.substring(contador, contador + 1);
                    contador++;
                    String sec2 = secuence.substring(contador, secuence.length());
                    if (aux.equals("."))
                    {
                        System.out.println(sec1);
                        System.out.println(sec2);
                    }
                    else if (aux.equals("|"))
                    {
                        System.out.println(sec1);
                        System.out.println(sec2);
                    }
                    else
                    {
                        System.out.println("Aparecio un simbolo extraño: " + aux);
                    }
                } 
                else if (aux.equals("|") || aux.equals("."))
                {
                    
                } 
                else
                {
                    System.out.println("Aparecio un simbolo extraño: " + aux);
                }
                    
                    
                break;
            default:
        }
        return null;
    }
    
    public int searchForParenthesisClose (int counter)
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
}
