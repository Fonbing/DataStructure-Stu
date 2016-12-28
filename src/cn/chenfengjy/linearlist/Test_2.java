package cn.chenfengjy.linearlist;

import cn.chenfengjy.linearlist.linklist.LinkList;
import cn.chenfengjy.linearlist.linklist.Node;

/**
 * Created by ChenFengJY on 2016/12/28.
 * 编程实现将两个有序的单链表LA（含有m个结点）和LB（含有n个结点）合并成一个新的有序的单链表LA，
 * 原有单链表LA和LB中的结点都按数据域值以非递减排列。
 */
public class Test_2 {
    public static void main(String[] args) throws Exception {
        LinkList la = new LinkList(4, false);
        LinkList lb = new LinkList(5, false);
        la = mergeList_L2(la, lb);
        System.out.println("合并后的链表为：");
        la.display();
    }

  /*  private static LinkList mergeList_L(LinkList LA, LinkList LB) {
        for (int i = 0; i < LA.length() + LB.length(); i++) {
            if (LA.get()){

            }
            Object largeNum = LA.get(i);
        }
        return null;
    }*/

    private static LinkList mergeList_L2(LinkList LA, LinkList LB) {
        Node pa = LA.getHead().getNext();
        Node pb = LB.getHead().getNext();
        Node pc = LA.getHead();
        int da, db;   // 结点值所对应的浮点数
        while (pa != null && pb != null) {
            da = Integer.valueOf(pa.getData().toString());
            db = Integer.valueOf(pb.getData().toString());
            if (da <= db) {
                pc.setNext(pa);
                pc = pa;
                pa = pa.getNext();
            } else {
                pc.setNext(pb);
                pc = pb;
                pb = pb.getNext();
            }
        }
        pc.setNext(pa != null ? pa : pb); // 插入剩余结点
        return LA;
    }
}
