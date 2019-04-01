package consumer;

import queue.Book;
import queue.DataQueue;
import exception.EmptyQueueException;
import gui.ThreadStatus;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author elisc
 */
public class Consumer implements Runnable {
    
    private final DataQueue<Book> queue;
    private final ThreadStatus status;
    
    public Consumer(DataQueue<Book> queue, ThreadStatus status) {
        this.queue = queue;
        this.status = status;
    }
    
    @Override
    public void run() {
        status.doRun();
        Book book = null;
        while (true) {
            synchronized (queue) {
                try {
                    book = queue.get();
                    queue.notifyAll();
                } catch (EmptyQueueException ex) {
                    try {
                        status.doWait();
                        queue.wait();
                        status.doRun();
                    } catch (Exception e) {
                        
                    }
                    continue;
                }
            }
            HashMap<String, Integer> map = book.countWords();
            File f = new File("output/" + book.getFilename() + "_output");
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(f));
                for (String str : map.keySet()) {
                    if (str.matches("^[a-zA-Z0-9]+$")) {
                        bw.write(String.format("%s: %d\n", str, map.get(str)));
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
