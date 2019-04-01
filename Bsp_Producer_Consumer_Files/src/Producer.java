
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author elisc
 */
public class Producer implements Runnable {

    private final DataQueue<Book> queue;

    public Producer(DataQueue<Book> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        File[] files = new File("files/").listFiles();
        for (File file : files) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String text = "";
                String line = "";
                while ((line = br.readLine()) != null) {
                    text += line;
                }
                Book book = new Book(text, file.getName());
                synchronized (queue) {
                    try {
                        queue.put(book);
                        queue.notifyAll();
                    } catch (FullQueueException ex) {
                        try{
                            queue.wait();
                        }
                        catch(Exception e){
                            
                        }
                    }
                }
            } catch (Exception ex) {

            }
        }
        
    }

}
