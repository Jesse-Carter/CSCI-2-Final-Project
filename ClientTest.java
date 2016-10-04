/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CS2FinalProject;

import javax.swing.JFrame;

/**
 *
 * @author mcjes
 */
public class ClientTest {
    public static void main(String[] args){
        //Must be set to the Server host's IP Address to properly connect
        Client11 charlie=new Client11("134.190.170.166");
        charlie.setVisible(true);
        charlie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        charlie.startRunning();
    }
    
}
