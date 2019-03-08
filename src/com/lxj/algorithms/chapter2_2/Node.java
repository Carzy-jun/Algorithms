package com.lxj.algorithms.chapter2_2;

public  class Node<Item>{
    Comparable<Item> item;
    Node next;

    public Node() { }



    public Node(Node<Item> node) {
        this.item = node.item;
        this.next = node.next;
    }
}
