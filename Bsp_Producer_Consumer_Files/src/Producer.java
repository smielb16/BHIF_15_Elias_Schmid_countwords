/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author elisc
 */
public class Producer {
    
    private final DataQueue<Book> queue;

    public Producer(DataQueue<Book> queue) {
        this.queue = queue;
    }
    
    
}
