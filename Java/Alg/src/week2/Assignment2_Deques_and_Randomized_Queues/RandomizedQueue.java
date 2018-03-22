package week2.Assignment2_Deques_and_Randomized_Queues;

import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] queue;
    private int size;
    private int first;
    private int last;


    public RandomizedQueue() {
        queue = (Item[]) new Object[2];
        first = 0;
        last = 0;
        size = 0;
    }                // construct an empty randomized queue
    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = queue[first + i];
        }
        queue = temp;
        first = 0;
        last = size;
    }

    public boolean isEmpty() {
        return size == 0;
    }                // is the randomized queue empty?
    public int size() {
        return size;
    }                       // return the number of items on the randomized queue
    public void enqueue(Item item) {
        if (item != null) {
            if (last == queue.length) resize(2 * queue.length);
            queue[last++] = item;
            size++;
        } else throw new IllegalArgumentException("Argument of enqueue can't be null");
    }          // add the item
    public Item dequeue() {
        if (!isEmpty()) {
            int i = StdRandom.uniform(size)+first;
            Item item = queue[i];
            if (i != first) queue[i] = queue[first];
            queue[first] = null;
            first++;
            size--;
            if (size > 0 && size == queue.length/4) resize(queue.length / 2);
            return item;
        } else throw new NoSuchElementException("Queue underflow");
    }                   // remove and return a random item
    public Item sample() {
        if (!isEmpty()) {
            return queue[StdRandom.uniform(size)+first];
        } else throw new NoSuchElementException("No Element");

    }                    // return a random item (but do not remove it)
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator<>(queue);
    }        // return an independent iterator over items in random order
    private class RandomizedQueueIterator<Item> implements Iterator<Item> {
        private int index;
        private final Item[] copyQueue;
        public RandomizedQueueIterator(Item[] queue) {
            copyQueue = (Item[]) new Object[size];
            for (int i = 0; i < size; i++) {
                copyQueue[i] = queue[first + i];
            }
            StdRandom.shuffle(copyQueue);
            index = 0;
        }
        public boolean hasNext() {
            return index < size;
        }
        public Item next() {
            if (hasNext()) {
                return copyQueue[index++];
            } else throw new NoSuchElementException("has no next");
        }
    }
    public static void main(String[] args) {
        /* RandomizedQueue rq = new RandomizedQueue<Integer>();
        for (int i = 0;i < 10;i ++){
            rq.enqueue(i);
        }
        System.out.println("first "+rq.first+"last"+rq.last+"size"+rq.size);*/
        /* while (!rq.isEmpty()) {
            System.out.println("dequeue "+rq.dequeue());
        }*/
        /* for (Object i : rq) {
            System.out.println(i + " ");
        }
        for (Object i : rq) {
            System.out.println(i + " ");
        }*/


        }  // unit testing (optional)
}
