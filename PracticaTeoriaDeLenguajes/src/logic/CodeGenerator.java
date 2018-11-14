/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;
import model.LamdaState;

/**
 *
 * @author luis_
 */
public class CodeGenerator {
    public static String generateCode (List<LamdaState> states, String inSymbols)
    {
        String code = 
            "   import java.util.Scanner; \n" +
            "   public class Template {  \n"  + 
            "       static int actualState = 0;  \n"  + 
            "       static String secuence;  \n"  + 
            "       static String uptakingStates = \"";
        
        String uptakings = "";
        for (int i = 0; i < states.size(); i++)
        {
            if (states.get(i).isUptakingState)
            {
                if (uptakings.length() == 0)
                    uptakings += i;
                else
                    uptakings += "," + i;
            }
        }
        
        code += uptakings + "\";  \n"  + 
            "                 \n"  + 
            "       public static void main(String args[])  \n"  + 
            "       {  \n"  + 
            "           System.out.println(\"Ingrese la secuencia que desea reconocer:\");   \n" +
            "           Scanner scanner = new Scanner(System.in);   \n"  + 
            "           secuence = scanner.nextLine();\n"  + 
            "           for (int i = 0; i < secuence.length(); i++)  \n"  + 
            "           {  \n"  + 
            "               if (actualState != -1) {  \n"  + 
            "                   String readedChar = secuence.substring(i, i + 1);  \n"  + 
            "                   switch (actualState)  \n"  + 
            "                   {  \n";
        
        for (int i = 0; i < states.size(); i++)
        {
            code += "                       case " + i + ":  \n"  + 
            "                           state" + i + "(readedChar);  \n"  + 
            "                           break;  \n";
        }
        code += "                   }  \n"  + 
            "               } else {  \n"  + 
            "                   System.out.println(\"La secuencia ha sido rechazada\");  \n"  + 
            "                   return;  \n"  + 
            "               }  \n"  + 
            "           }  \n"  + 
            "           if (uptakingStates.contains(String.valueOf(actualState))) { \n "  + 
            "               System.out.println(\"La secuencia ha sido aceptada\");  \n"  + 
            "           } else {  \n"  + 
            "               System.out.println(\"La secuencia ha sido rechazada\");  \n"  + 
            "           }  \n"  + 
            "       }  \n"  + 
            "         \n";
        
        for (int i = 0; i < states.size(); i++)
        {
            LamdaState state = states.get(i);
            code += "       public static void state" + i + " (String symbol)  \n"  + 
            "       {  \n"  + 
            "           switch (symbol)  \n"  + 
            "           {  \n";
            
            for (int j = 0; j < inSymbols.length(); j++)
            {
                String symbol = inSymbols.substring(j, j + 1);
                if (state.transitions.containsKey(symbol))
                {
                    code += "               case \"" + symbol + "\":  \n"  + 
                    "                   actualState = " + state.transitions.get(symbol) + ";  \n"  + 
                    "                   break;  \n";
                }
            }
            code += "               default:  \n"  + 
            "                   actualState = -1;  \n"  + 
            "           }  \n"  + 
            "       }  \n";
        }
        code += "   }  \n"  + 
            "    \n" ;
        return code;
    }
}
