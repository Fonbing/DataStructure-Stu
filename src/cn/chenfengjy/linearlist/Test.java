package cn.chenfengjy.linearlist;


import cn.chenfengjy.linearlist.linklist.LinkList;
import cn.chenfengjy.linearlist.linklist.Node;

/**
 * Created by ChenFengJY on 2016/12/26.
 * 1. 编写程序实现：建立一个单链表，然后删除单链表中“多余”的结点，
 * 即使操作之后的单链表中只留下不相同的结点，最后输出删除后的单链表中所有结点。
 */
public class Test {
    public static void main(String[] args) throws Exception {
        LinkList ll = new LinkList(5, false);
        System.out.println("移除前");
        ll.display();
        System.out.println("移除后");
        removeRepeatElem2(ll);
        ll.display();
    }

    private static void removeRepeatElem1(LinkList ll) throws Exception {    //移除重复元素
        for (int i = 0; i < ll.length(); i++) {
            Object temp = ll.get(i);
            for (int j = i + 1; j < ll.length(); j++) {
                if (temp.equals(ll.get(j))) {
                    ll.remove(j);
                    j--;
                }
            }
        }
    }

    private static void removeRepeatElem2(LinkList ll) throws Exception {    //移除重复元素
        Node p = ll.getHead().getNext(), q;         // p指向首结点
        while (p != null) {
            int order = ll.indexOf(p.getData());
            q = p.getNext();
            while (q != null) {
                if (p.getData().equals(q.getData())) {
                    ll.remove(order + 1);
                } else {
                    ++order;
                }
                q = q.getNext();
            }
            p = p.getNext();
        }
    }
}
