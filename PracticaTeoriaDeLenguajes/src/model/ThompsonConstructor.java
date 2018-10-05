/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author mac
 */
public class ThompsonConstructor {
    
    public static DoubleNode nullConstruction () {
        DoubleNode first = new DoubleNode();
        DoubleNode last = new DoubleNode();
        first.link1 = last;
        return first;
    }
    
    public static DoubleNode simpleConstruction (String symbol) {
        DoubleNode first = new DoubleNode();
        DoubleNode last = new DoubleNode();
        first.link1 = last;
        first.transition1 = symbol;
        return first;
    }
    
    public static void simpleConstruction (String symbol, DoubleNode start, DoubleNode end) {
        start.link1 = end;
        start.transition1 = symbol;
    }
    
    public static void concatConstruction (String symbol1, String symbol2, DoubleNode start, DoubleNode end) 
    {
        DoubleNode consSimbol1 = new DoubleNode();
        simpleConstruction(symbol1, start, consSimbol1); 
        DoubleNode consSimbol2 = new DoubleNode();
        consSimbol1.link1 = consSimbol2;
        simpleConstruction(symbol2, consSimbol2, end);
    }
    
    public static void unionConstruction (String symbol1, String symbol2, DoubleNode start, DoubleNode end) 
    {
        DoubleNode consSimbol1 = simpleConstruction(symbol1);
        DoubleNode consSimbol2 = simpleConstruction(symbol2);
        start.link1 = consSimbol1;
        start.transition1 = "";
        start.link2 = consSimbol2;
        start.transition2 = "";
        DoubleNode last = new DoubleNode();
        consSimbol1.link1.link1 = last;
        consSimbol2.link1.link1 = last;
        last.link1 = end;
    }
    
    public static void asteriskConstruction (String simbol, DoubleNode start, DoubleNode end)
    {
        DoubleNode consSimbol = simpleConstruction(simbol);
        consSimbol.link1.link1 = consSimbol;
        consSimbol.link1.link2 = end;
        start.link1 = consSimbol;
        start.transition1 = "";
        start.link2 = end;
        start.transition2 = "";
    }
    
    public static void plusConstruction (String simbol, DoubleNode start, DoubleNode end)
    {
        DoubleNode consSimbol = simpleConstruction(simbol);
        consSimbol.link1.link1 = consSimbol;
        consSimbol.link1.link2 = end;
        start.link1 = consSimbol;
        start.transition1 = "";
    }
}
