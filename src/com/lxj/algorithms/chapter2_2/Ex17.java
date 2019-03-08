package com.lxj.algorithms.chapter2_2;


/*
 * 链表排序。
 * 实现对链表的自然排序（这是将链表排序的最好方法， 因为它不需要额外的空间且运行时间是线性对数级别的）。
 */
public class Ex17<Item> {


    private void Sort(LinkList a){
        while (true) {
            // 找到第一个块
            Node<Item> lo = a.getFirst();
            Node<Item> mid = FindBlock(lo);
            if (mid.next == null)
                break;
            while (mid.next != null) {
                Node<Item> hi = FindBlock(mid.next);
                if (lo == a.getFirst())
                    a.setFirst(Merge(lo, mid, hi));
                else
                    lo.next = Merge(lo.next, mid, hi);
                // 跳到表尾
                if (less(hi.item, mid.item))
                    lo = mid;
                else
                    lo = hi;
                if (lo.next != null)
                    mid = FindBlock(lo.next);
            }
        }
    }

    private Node<Item> Merge(Node lo, Node mid, Node hi) {
        Node<Item> after = hi.next; // 要合并的两个块之后的元素
        Node<Item> first;
        Node<Item> i = lo;          // 链表1
        Node<Item> j = mid.next;    // 链表2
        // 切割链表
        mid.next = null;
        hi.next = null;

        Node<Item> current;
        // 决定新的表头
        if (less(i.item, j.item)) {
            current = i;
            i = i.next;
        } else {
            current = j;
            j = j.next;
        }
        first = current;
        // 归并表
        while (i != null && j != null) {
            if (less(i.item, j.item)) {
                current.next = i;
                i = i.next;
                current = current.next;
            } else {
                current.next = j;
                j = j.next;
                current = current.next;
            }
        }
        if (i == null)
            current.next = j;
        else
            current.next = i;
        // 连接表尾（链表 1 的尾部或者链表 2 的尾部）
        if (mid.next == null)
            mid.next = after;
        else
            hi.next = after;

        return first;
    }


    private Node<Item> FindBlock(Node<Item> lo) {
        Node<Item> hi = lo;
        while (hi.next != null) {
            if (less(hi.item, (Comparable<Item>) hi.next.item) || hi.item.equals(hi.next.item))
                hi = hi.next;
            else
                break;
        }
        return hi;
    }


    private boolean less(Comparable<Item> v, Comparable<Item> w){
        return v.compareTo((Item) w)<0;
    }
    public static void main(String[] args){
        LinkList<Integer> a = new LinkList<>();
        for (int i =1 ; i < 20; i += 1)
        a.insert(i);
        System.out.println(a.ToString());
        Ex17 test = new Ex17();
        test.Sort(a);
        System.out.println(a.ToString());
    }
}
