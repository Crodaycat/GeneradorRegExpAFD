package logic;

import javax.swing.JOptionPane;

public class Template {
    int actualState = 0;
    String secuence;
    String uptakingStates = "";
            
    public void main ()
    {
        secuence = JOptionPane.showInputDialog("Ingrese la secuencia que desea reconocer:");
        for (int i = 0; i < secuence.length(); i++)
        {
            if (actualState != -1) {
                String readedChar = secuence.substring(i, i + 1);
                switch (actualState)
                {
                    case 1:
                        stateNRO(readedChar);
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
            System.out.println("La secuencia ha sido aceptada");
        }
    }
    
    public void stateNRO (String symbol)
    {
        switch (symbol)
        {
            case "1":
                actualState = 1;
                break;
            default:
                actualState = -1;
        }
    }
}
