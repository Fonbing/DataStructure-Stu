package cn.chenfengjy.linearlist;

/**
 * Created by ChenFengJY on 2016/12/26.
 */
public interface IList {
    public void clear();                     //1）线性表的置空操作

    public boolean isEmpty();                //2）线性表判空操作

    public int length();                      //3）求线性表的长度：

    public Object get(int i);                   //4）取元素操作：

    public void insert(int i, Object x) throws Exception;        //5）插入操作：

    public void remove(int i) throws Exception;                  //6）删除操作：

    public int indexOf(Object x);           //7）查找操作：

    public void display();                  //8)输出操作：
}
