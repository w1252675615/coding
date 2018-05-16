package LeetCode;

import java.util.concurrent.ConcurrentHashMap;

public class Q146_LRUCache {
    class Node {
        int key;
        int value;
        Node pre;
        Node post;
        Node() {}
    }

    private void addNode(Node node) {
        node.pre = head;
        node.post = head.post;
        head.post.pre = node;
        head.post = node;
    }

    private void removeNode(Node node) {
        Node pre = node.pre;
        Node post = node.post;
        pre.post = post;
        post.pre = pre;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    private Node popNode() {
        Node node = tail.pre;
        removeNode(node);
        return node;
    }

    Node head = new Node();
    Node tail = new Node();
    int capacity;
    int count;
    ConcurrentHashMap<Integer,Node> cache = new ConcurrentHashMap<>();


    public Q146_LRUCache(int capacity) {
        this.capacity = capacity;
        count = 0;
        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            if (count == capacity) {
                cache.remove(popNode().key);
                --count;
            }
            node = new Node();
            node.key = key;
            node.value = value;
            addNode(node);
            cache.put(key,node);
            ++count;
        }else {
            node.value = value;
            moveToHead(node);
        }
    }

    public static void main(String[] args) {
        Q146_LRUCache q146_lruCache = new Q146_LRUCache(2);
        q146_lruCache.put(1,1);
        q146_lruCache.put(2,2);
        q146_lruCache.get(1);
        q146_lruCache.put(3,3);
        System.out.println("count:"+q146_lruCache.count+"map:"+q146_lruCache.cache.size());
    }
}
