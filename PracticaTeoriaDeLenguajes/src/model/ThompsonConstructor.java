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
    
    public static DoubleNode simpleConstruction (String simbol) {
        DoubleNode first = new DoubleNode();
        DoubleNode last = new DoubleNode();
        first.link1 = last;
        first.transition1 = simbol;
        return first;
    }
    
    public static DoubleNode[] concatConstruction (String simbol1, String simbol2) {
        DoubleNode[] vector = new DoubleNode[2];
        DoubleNode consSimbol1 = simpleConstruction(simbol1);
        DoubleNode consSimbol2 = simpleConstruction(simbol2);
        consSimbol1.link1.link1 = consSimbol2;
        vector[0] = consSimbol1;
        vector[1] = consSimbol2.link1;
        return vector;
    }
    
    public static DoubleNode[] unionConstruction (String simbol1, String simbol2) {
        DoubleNode[] vector = new DoubleNode[2];
        DoubleNode consSimbol1 = simpleConstruction(simbol1);
        DoubleNode consSimbol2 = simpleConstruction(simbol2);
        DoubleNode first = new DoubleNode();
        DoubleNode last = new DoubleNode();
        first.link1 = consSimbol1;
        first.link2 = consSimbol2;
        consSimbol1.link1.link1 = last;
        consSimbol2.link1.link1 = last;
        vector[0] = first;
        vector[1] = last;
        return vector;
    }
    
    public static DoubleNode[] unionConstruction (DoubleNode start, DoubleNode end, String simbol) {
        DoubleNode[] vector = new DoubleNode[2];
        DoubleNode consSimbol1 = start.link2;
        DoubleNode consSimbol2 = simpleConstruction(simbol);
        DoubleNode first = new DoubleNode();
        start.link1 = first;
        first.link1 = consSimbol1;
        first.link2 = consSimbol2;
        DoubleNode last = new DoubleNode();
        last.link1 = end;
        consSimbol1.link1.link1 = last;
        consSimbol2.link1.link1 = last;
        vector[0] = first;
        vector[1] = last;
        return vector;
    }
    
    public static DoubleNode[] asteriskConstruction (String simbol){
        DoubleNode[] vector = new DoubleNode[2];
        DoubleNode consSimbol1 = simpleConstruction(simbol);
        consSimbol1.link1.link1 = consSimbol1;
        DoubleNode start = new DoubleNode();
        start.link1 = consSimbol1;
        DoubleNode end = new DoubleNode();
        start.link2 = end;
        consSimbol1.link1.link2 = end;
        vector[0] = start;
        vector[1] = end;
        return vector;
    }
    
    public static DoubleNode[] plusConstruction (String simbol){
        DoubleNode[] vector = new DoubleNode[2];
        DoubleNode consSimbol1 = simpleConstruction(simbol);
        consSimbol1.link1.link1 = consSimbol1;
        DoubleNode start = new DoubleNode();
        start.link1 = consSimbol1;
        DoubleNode end = new DoubleNode();
        consSimbol1.link1.link2 = end;
        vector[0] = start;
        vector[1] = end;
        return vector;
    }
    
}
