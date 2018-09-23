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
    String simbols = ("()+*|.±┤■"); // ┤ es fin de secuencia. ± es secuencia vacía. ■ es la secuencia nula
    String secSimbols;
    
    void SecueceConstructor (String sec)
    {
        secuence = sec;
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
        if (!aux.equals("±"))
            while (!aux.equals("┤"))
            {
                switch (aux) {
                    case "(":
                        
                        break;
                    case ")":
                        
                        break;
                    default:
                        
                }
            }
        return null;
    }
}
