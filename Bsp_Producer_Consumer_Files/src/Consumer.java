/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author elisc
 */
public class Consumer {
    
    private final DataQueue<Book> queue;

    public Consumer(DataQueue<Book> queue) {
        this.queue = queue;
    }   
    
    
}
