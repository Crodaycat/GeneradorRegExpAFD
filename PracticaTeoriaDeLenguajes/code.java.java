   import java.util.Scanner; 
   public class Template {  
       static int actualState = 0;  
       static String secuence;  
       static String uptakingStates = "2";  
                 
       public static void main(String args[])  
       {  
           System.out.println("Ingrese la secuencia que desea reconocer:");   
           Scanner scanner = new Scanner(System.in);   
           secuence = scanner.nextLine();
           for (int i = 0; i < secuence.length(); i++)  
           {  
               if (actualState != -1) {  
                   String readedChar = secuence.substring(i, i + 1);  
                   switch (actualState)  
                   {  
                       case 0:  
                           state0(readedChar);  
                           break;  
                       case 1:  
                           state1(readedChar);  
                           break;  
                       case 2:  
                           state2(readedChar);  
                           break;  
                   }  
               } else {  
                   System.out.println("La secuencia ha sido rechazada");  
                   return;  
               }  
           }  
           if (uptakingStates.contains(String.valueOf(actualState))) { 
                System.out.println("La secuencia ha sido aceptada");  
           } else {  
               System.out.println("La secuencia ha sido rechazada");  
           }  
       }  
         
       public static void state0 (String symbol)  
       {  
           switch (symbol)  
           {  
               case "0":  
                   actualState = 1;  
                   break;  
               default:  
                   actualState = -1;  
           }  
       }  
       public static void state1 (String symbol)  
       {  
           switch (symbol)  
           {  
               case "0":  
                   actualState = 2;  
                   break;  
               case "1":  
                   actualState = 2;  
                   break;  
               default:  
                   actualState = -1;  
           }  
       }  
       public static void state2 (String symbol)  
       {  
           switch (symbol)  
           {  
               case "0":  
                   actualState = 1;  
                   break;  
               default:  
                   actualState = -1;  
           }  
       }  
   }  
    
