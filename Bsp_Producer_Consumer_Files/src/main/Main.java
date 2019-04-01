package main;


import queue.Book;
import queue.DataQueue;
import producer.Producer;
import consumer.Consumer;
import gui.ThreadStatus;
import java.awt.GridLayout;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author elisc
 */
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(2, 1));
        DataQueue<Book> queue = new DataQueue<Book>(3);
        
        ThreadStatus statusPro = new ThreadStatus("Producer");
        frame.add(statusPro);
        
        ThreadStatus statusCon = new ThreadStatus("Consumer");
        frame.add(statusCon);
        
        Thread producer = new Thread(new Producer(queue, statusPro));
        Thread consumer = new Thread(new Consumer(queue, statusCon));
        
        producer.start();
        consumer.start();
        
        frame.setSize(500, 250);
        frame.setVisible(true);
    }
}
