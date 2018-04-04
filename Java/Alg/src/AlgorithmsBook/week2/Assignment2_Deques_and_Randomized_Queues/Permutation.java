package AlgorithmsBook.week2.Assignment2_Deques_and_Randomized_Queues;

import  edu.princeton.cs.algs4.StdIn;
// import  edu.princeton.cs.algs4.In;

public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        while (!StdIn.isEmpty()) {
            rq.enqueue(StdIn.readString());
        }
        for (int i = 0; i < k; i++) {
            System.out.println(rq.dequeue());
        }
    }
}
