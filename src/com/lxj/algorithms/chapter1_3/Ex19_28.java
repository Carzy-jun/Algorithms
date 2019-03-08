package com.lxj.algorithms.chapter1_3;

import java.util.Iterator;
import java.util.LinkedList;

public class Ex19_28 {
    private class Node {
        int item;
        Node next;
    }

    private Node first;

    //Ex19_28,删除链表最后一个元素
    public void deleteLast() {
        Node current = first;
        if (current == null) return;
        for (Node x = current; x != null; x = x.next) {
            if (x.next == null) x = null;
        }
    }

    //Ex20，删除链表第k个元素
    public void delete(int k) {
        Node current = first;
        if (current == null) return;
        int i = 1;
        for (Node x = current; x != null; x = x.next) {
            if (i == k - 1) x = x.next.next;
            i++;
        }
    }

    //Ex21
    public boolean find(LinkedList<String> a, String key) {
        Iterator<String> it = a.iterator();
        while (it.hasNext()) {
            if (key.equals(it.next())) return true;
        }
        return false;
    }

    //Ex24
    public void removeAfter(Node node) {
        if (node == null || node.next == null) {
        } else {
            if (node.next.next == null) node.next = null;
            else node.next = node.next.next;
        }
    }

    public void removeAfter1(Node node) {
        if (node == null || node.next == null) return;
        Node current = node.next;
        Node next = current.next;
        node.next = null;
        while (current.next != null) {
            current = null;
            current = next;
            next = next.next;
        }
    }

    //Ex25 ,将第二个节点插入成为第一个节点的后续节点
    public void insertAfter(Node a, Node b) {
        if (a == null || a == b) return;
        b.next = a.next;
        a.next = b;
    }

    //Ex26,删除链表中item域为key的节点
    public  void remove(String key) {
        while (first != null && key.equals(first.item)) {
            first = first.next;
        }
        Node current = first;
        Node node;
        while (current != null && current.next != null) {
            node = current.next;
            if (key.equals(node.item)) current.next = node.next;
            else current = node;
        }

    }
    //Ex27 ,返回链表键最大节点值
    public int max(Node first){
        if (first == null) {
            return 0;
        }
        if (first.next == null) {
            return  first.item;
        }
        Node pointer =  first;
        Node max =  first;
        while (pointer != null && pointer.next != null) {
            pointer = pointer.next;
            if (max.item < pointer.item) {
                max = pointer;
            }
        }
        return max.item;
    }

    //Ex28, 用递归解决上题
    public  int max1(Node first) {
        if (first == null || first.next == null) {
            return first.item;
        }
        if (first.item < first.next.item) {
            first.next = first.next.next;
            return max1(first);
        }

        return max1(first.next);
    }


}
