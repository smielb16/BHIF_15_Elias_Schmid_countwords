
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author elisc
 */
public class DataQueue<T> {

    private LinkedList<T> data = new LinkedList<T>();
    private int maxSize = 3;
    
    public DataQueue(T book) {
        this.data.add(book);
    }
    
    
    
}
