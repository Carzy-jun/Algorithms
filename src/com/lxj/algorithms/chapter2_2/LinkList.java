package com.lxj.algorithms.chapter2_2;

import java.util.Iterator;

public class LinkList<Item> implements Iterable<Item> {
    private Node<Item> first;
    private int count;

    LinkList(){
        first = null;
        count = 0;
    }


    //表头插入一个元素
    void insert(Item item){
        Node<Item> n = new Node();
        n.item = (Comparable<Item>) item;
        n.next = first;
        first = n;
        count++;
    }

    //指定位置前插入一个元素
    public void insert(Item item, int position){
        if (position == 0){
            insert(item);
            return;
        }
        Node n = new Node();
        n.item = (Comparable) item;
        Node front = first;
        for (int i = 1; i < position; i++) {
            front = front.next;
        }
        n.next = front.next;
        front.next = n;
        count++;
    }

    /// 获取指定位置的元素。
    public Item Find(int index) {
        Node<Item> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return (Item) current.item;
    }

    /// 删除指定位置的元素，返回该元素。
    public Item delete(int index){
        Node<Item> front = first;
        Item temp = (Item) first.item;
        if (index == 0){
            first = first.next;
            count--;
            return temp;
        }
        for (int i = 1; i < index; i++){
            front = front.next;
        }
        front.next = front.next.next;
        temp = (Item) front.next.item;
        count--;
        return temp;
    }

    public int size(){
        return count;
    }
    public boolean isEmpty(){
        return first == null;
    }

    Node getFirst() {
        return first;
    }

    void setFirst(Node first) {
        this.first = first;
    }

    // 将链表转化成单个字符串，元素之间用空格隔开。
    String ToString() {
        StringBuilder s = new StringBuilder();
        for (Item i : this){
            s.append(i);
            s.append(" ");
        }
        return s.toString();
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }
        @Override

        public Item next() {
            Item item = (Item) current.item;
            current = current.next;
            return item;
        }
    }


}
