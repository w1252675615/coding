package Offer.Q41_StreamMedian;
/*
    找出数据流的中位数
*/

import java.util.Comparator;
import java.util.PriorityQueue;

public class StreamMedian {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });
    public void Insert(Integer num) {
        if (((maxHeap.size() + minHeap.size()) & 1) == 0) {
            if (maxHeap.size() > 0 && num < maxHeap.peek()) {
                maxHeap.offer(num);
                minHeap.offer(maxHeap.poll());
            }else minHeap.offer(num);
        }else {
            if (minHeap.size() > 0 && num > minHeap.peek()) {
                minHeap.offer(num);
                maxHeap.offer(minHeap.poll());
            }else maxHeap.offer(num);
        }
    }

    public Double GetMedian() {
        if (((maxHeap.size() + minHeap.size()) & 1) == 0) {
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }else return minHeap.peek()*1.0;
    }
}
