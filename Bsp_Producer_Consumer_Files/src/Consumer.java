
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;

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

    public Consumer(DataQueue<Book> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Book book = null;
        while (true) {
            synchronized (queue) {
                try {
                    book = queue.get();
                    queue.notifyAll();
                } catch (EmptyQueueException ex) {
                    try {
                        queue.wait();
                    } catch (Exception e) {

                    }
                    continue;
                }
            }
            HashMap<String, Integer> map = book.countWords();
            File f = new File("output/" + book.getFilename() + "_output");
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(f));
                for(String str : map.keySet()){
                    bw.write(String.format("%s: %d\n", str, map.get(str)));
                }
            } catch (Exception ex) {

            }
        }
    }

}
