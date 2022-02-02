/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;

/**
 *
 * @author hcadavid
 */
public class CountThread extends Thread{

    private int a;
    private int b;

    CountThread(int a, int b){
        super("CountThread");
        this.a = a;
        this.b = b;
    }
    
    public void run(){
        try {
            for (int i = this.a; i <= this.b; i++) {
                System.out.println(i);
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
