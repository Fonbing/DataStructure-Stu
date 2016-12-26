package cn.chenfengjy.linearlist.linklist;

import cn.chenfengjy.linearlist.IList;

import java.util.Scanner;

/**
 * Created by ChenFengJY on 2016/12/26.
 * java语言实现链表结构------用 “类” 来代替指针，建立一个专门的类来存放结点，头指针存放头结点，头结点的指针域存放下一个节点
 */
public class LinkList implements IList {

    private Node head;   //单链表的头指针---注意：之所以为结点类型，头指针存放的是下一个结点（头结点）

    public LinkList() {
        head = new Node();  //初始化头结点
    }

    public LinkList(int n, boolean oreder) throws Exception {
        this();
        System.out.println("请输入长度为" + n + "的单链表");
        if (oreder) {
            create1(n);
        } else {
            create2(n);
        }
    }

    private void create1(int n) throws Exception { //头插法
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            insert(0, sc.next());
        }
    }

    private void create2(int n) throws Exception {  //尾插法
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            insert(i, sc.next());
        }
    }


    @Override
    public void clear() {
        head.setData(null);
        head.setNext(null);
    }

    @Override
    public boolean isEmpty() {
        return head.getNext() == null;
    }

    @Override
    public int length() {
        int length = 0;
        Node p = head.getNext();
        while (p != null) {
            p = p.getNext();
            ++length;
        }
        return length;
    }

    @Override
    public Object get(int i) {
        int j = 0;
        Node p = head.getNext();   //此为第一个结点 非头结点
        while (p != null && j < i) {
            p = p.getNext();
            ++j;
        }
        return p.getData();
    }

    @Override
    public void insert(int i, Object x) throws Exception {
        /*int j = 0;
        Node p = head.getNext();
        while (p != null && j < i - 1) {   //查找待添加结点的前驱结点
            p = p.getNext();
            ++j;
        }*/
        int j = -1;
        Node p = head;                       //要从头结点开始算起，考虑插入位置位置为0的情况
        while (p != null && j < i - 1) {
            p = p.getNext();
            ++j;
        }
        if (j > i - 1 || p == null)   // i不合法
            throw new Exception("插入位置不合法");
        Node node = new Node(x);
        node.setNext(p.getNext());
        p.setNext(node);
    }

    @Override
    public void remove(int i) throws Exception {
        int j = -1;
        Node p = head;               //查找待删除结点的前驱结点
        while (p.getNext() != null && j < i - 1) {
            p = p.getNext();
            ++j;
        }
        if (j > i - 1 || p == null)   // i不合法
            throw new Exception("删除位置不合法");
        p.setNext(p.getNext().getNext());
    }

    @Override
    public int indexOf(Object x) {
        int i = 0;
        Node p = head.getNext();
        while (p != null && p.getData().equals(x)) {
            p = p.getNext();
            ++i;
        }
        if (p != null)
            return i;
        else return -1;
    }

    @Override
    public void display() {
        Node node = head.getNext();
        while (node != null) {
            System.out.println(node.getData().toString());
            node = node.getNext();
        }
        System.out.println();
    }
}
