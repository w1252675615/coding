package AlgorithmsBook.week2.Assignment2_Deques_and_Randomized_Queues;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int size;
    private class Node<Item> {
        Item item;
        Node<Item> next;
        Node<Item> pre;
    }
    public Deque() {
        first = null;
        last = null;
        size = 0;
    }                           // construct an empty deque
    public boolean isEmpty() {
        return size == 0;
    }                 // is the deque empty?
    public int size() {
        return size;
    }                       // return the number of items on the deque
    public void addFirst(Item item) {
        if (item != null) {
            Node<Item> oldfirst = first;
            first = new Node<Item>();
            first.item = item;
            first.next = oldfirst;
            first.pre = null;
            if (isEmpty()) last = first;
            else oldfirst.pre = first;
            size++;
        } else throw new IllegalArgumentException("Argument of addFirst can't be null");
    }         // add the item to the front
    public void addLast(Item item) {
        if (item != null) {
            Node<Item> oldlast = last;
            last = new Node<Item>();
            last.item = item;
            last.pre = oldlast;
            last.next = null;
            if (isEmpty()) first = last;
            else oldlast.next = last;
            size++;
        } else throw new IllegalArgumentException("Argument of addLast can't be null");
    }          // add the item to the end
    public Item removeFirst() {
        if (!isEmpty()) {
            Item item = first.item;
            first = first.next;
            size--;
            if (isEmpty()) last = null;
            else first.pre = null;
            return item;
        } else throw new NoSuchElementException("Queue underflow");
    }               // remove and return the item from the front
    public Item removeLast() {
        if (!isEmpty()) {
            Item item = last.item;
            last = last.pre;
            size--;
            if (isEmpty()) first = null;
            else last.next = null;
            return item;
        } else throw new NoSuchElementException("Queue underflow");
    }                // remove and return the item from the end
    public Iterator<Item> iterator() {
        return new DequeIterator<>(first);

    }        // return an iterator over items in order from front to end

    private class DequeIterator<Item> implements Iterator<Item> {
        private Node<Item> current;
        public DequeIterator(Node<Item> first) {
            current = first;
        }
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (hasNext()) {
                Item item = current.item;
                current = current.next;
                return item;
            } else throw new NoSuchElementException("has no next");
        }
    }
    public static void main(String[] args) {
        /* Deque deque = new Deque<Integer>();
        for(int i = 0;i < 10;i++) {
            deque.addLast(i);
        }
        while (!deque.isEmpty()) {
            Iterator<Integer> i = deque.iterator();
            while(i.hasNext()){
                int s = i.next();
                System.out.println(s+" ");
            }
            for (Object i : deque) {
                System.out.println(i+" ");
            }
            System.out.println("size "+deque.size+" dequeue "+deque.removeLast());
        }*/
    }   // unit testing (optional)
}
