
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
    
    public DataQueue(int maxSize) {
        this.maxSize = maxSize;
    }
    
    public T get() throws EmptyQueueException{
        if(data.isEmpty()){
            throw new EmptyQueueException();
        }
        else{
            return data.poll();
        }
    }
    
    public void put(T element) throws FullQueueException{
        if(data.size() == maxSize){
            throw new FullQueueException();
        }
        else{
            data.add(element);
        }
    }
    
}
