package com.lxj.algorithms.chapter1_3;


public class ResizingArrayQueueOfString {
    private int count = 1;
    private String[] queue = new String[count];
    private int first = 0;
    private int last = 0;

    public boolean isEmpty() {
        return first == last;
    }

    public int size() {
        return last - first;
    }

    private void resize(int max) {
        String[] temp = new String[max];
        int j = 0;
        for (int i = first; i < last; i++) {
            temp[j++] = queue[i];
        }
        queue = temp;
        count = max;
        last = last - first;
        first = 0;
    }

    public void enqueue(String s) {
        if (last == queue.length) resize(2 * queue.length);
        queue[last++] = s;
    }

    public String dequeue() {
        if (size() == count / 4) resize( queue.length/2);
        return queue[first++];
    }

    public static void main(String[] args) {
        ResizingArrayQueueOfString queue = new ResizingArrayQueueOfString();
        queue.enqueue("a");
        System.out.println("size(): " + queue.size() + " | count: " + queue.count);
        queue.enqueue("b");
        System.out.println("size(): " + queue.size() + " | count: " + queue.count);
        queue.enqueue("c");
        System.out.println("size(): " + queue.size() + " | count: " + queue.count);
        queue.enqueue("d");
        System.out.println("size(): " + queue.size() + " | count: " + queue.count);
        queue.enqueue("e");
        System.out.println("size(): " + queue.size() + " | count: " + queue.count);
        queue.enqueue("f");
        System.out.println("size(): " + queue.size() + " | count: " + queue.count);
        queue.enqueue("g");
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue() + " | size(): " + queue.size() + " | count: " + queue.count);
        }
    }

}
