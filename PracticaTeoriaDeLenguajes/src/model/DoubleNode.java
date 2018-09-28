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
public class DoubleNode {
    
    public DoubleNode link1; 
    public DoubleNode link2;
    public int data;
    public boolean uptakingState;
    public String transition1;
    public String transition2;

    public DoubleNode() {
        this.link1 = null;
        this.link2 = null;
        this.data = 0;
        this.uptakingState = false;
        this.transition1 = "";
        this.transition2 = "";
    }
}
