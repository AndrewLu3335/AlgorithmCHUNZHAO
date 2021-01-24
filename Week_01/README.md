学习笔记

一、 用add first或者 add last 这套新的API改写 Deque

```java
/**
 * @Author: Andrew Lu
 * @Description: Rewrite Dequeue Demo
 */
public class DequeDemo {

    public static void main(String[] args) {
        Deque<String> deque= new LinkedList<>();
        //add to the Last of deque
        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");
        //result: [a, b, c]
        System.out.println(deque);
        //get the head of deque, no element will be removed
        String str=deque.getFirst();
        //result: a
        System.out.println(str);
        //result: [a,b, c]
        System.out.println(deque);

        while(deque.size()>0) {
            //result： a b c
            //get the head of deque and remove the head element.
            System.out.println(deque.removeFirst());
        }
        // result: []
        System.out.println(deque);
    }
}
```

二 、分析源代码都基于jdk8
	1. Queue源代码分析：
        	Queue是一个接口，属于Collection的子类接口。

    1. boolean add(E e); 
        向队列中插入一个元素并且，允许的情况下可以无视容器的容量限制。返回值:成功则返回true，如果没有空间插入该元素则抛异常IllegalStateException。
    
    2. boolean offer(E e);
        同add方法一样，向队列中插入一个元素，允许的情况下可以无视容器的容量限制。返回值：成功则返回true，如果插入失败（容量限制）则返回false。
    
    3. E remove();
        提取（返回）队列的头元素并且删除该元素，如果队列为空，则跑出异常NoSuchElementException。
    
    4. E poll();
        提取（返回）队列的头元素并且删除该元素，如果队列为空，则返回null。
    
    5.  E element();
        提取（返回）队列的头元素，但不会删除该元素。如果队列是空的则会抛异常NoSuchElementException。
    
    6.  E peek();
         提取（返回）队列的头元素，但不会删除该元素。如果队列是空的则会返回null。

2. PriorityQueue源码分析：
       PriorityQueue是一个Queue接口的实现类。
       优先队列是由一个平衡二叉堆实现的，里面的队列是会按照比较器规定的顺序，如果没有比较器的话队头则是队列中最小的值。
       

        成员变量：
        transient Object[] queue;   //Object类型数组作为队列的存储结构
        private int size = 0;       //队列里元素的数量
        private final Comparator<? super E> comparator;     //继承了Comparator比较器的类（可以自己写个继承Comparator的类来定义比较规则）
        transient int modCount = 0;    //优先队列被操作的次数
        
        构造方法：默认初始容量为11
        1. 空形参构造。 初始化默认值1+比较器null，采用默认的优先比较规则。
        2. 形参：初始容量。 比较器方面采用默认的优先比较规则。
        3. 形参：实现了比较器comparator的类。采用自定义的比较器+默认初始化容量。
        4. 形参：实现了比较器comparator的类+容量。 判断容量是否<1 小的话就抛异常IllegalArgumentException。使用自自己定义的优先级比较规则+自定义容量。
    
        初始化优先级队列也可以通过
        initFromPriorityQueue(PriorityQueue<? extends E> c) //传入一个优先级队列初始化
        initElementsFromCollection(Collection<? extends E> c)   //传入一个Collection来初始化
        initFromCollection(Collection<? extends E> c)           //在上一个方法的基础上做了个堆化的操作。
    
        核心功能
        private void grow(int minCapacity)
        数组扩容。就容量和64进行比较，比64大的就增加50%如果小的就增加原来容量+2.
        判断新的容量是否大于数组最大容量限制，如果大的就复制Integer的最大值。最后将就的queue拷贝到新的数组中。
    
        public boolean offer(E e) 
        在优先队列中插入一个元素，  1）非空判断
                                2）判断是否超出容量？grow（）方法增加容量 ： size增加1 
                                3）如果没有元素 则在队头插入如果有元素则siftUp。
    
        public boolean add(E e) 
        插入一个元素，调用offer()方法。
    
        public void clear()
        遍历整个队列数组，并且清空全部元素，置size为0。
    
        public boolean contains(Object o) 
        遍历找出o元素在队列数组中的下标(indexOf(o))，如果没有则返回false；如果能找到，就返回true。
    
        public E peek() 标记unchecked
        如果size不为0则返回队列数组中第一个元素，如果size为0就返回null
    
        public E poll()
        如果当前为空队列数组则返回null，取出数组第一个元素，并且删除
    
        remove(Object o)
        删除一个节点，如果有则删除，如果没有则返回false
    
        private E removeAt(int i) 
        删除队列数组中下标为i的元素，如果是数组中的最后一个元素（堆最后个元素），就直接删除，否则需要维持堆特性，返回要删除的元素。
    
        sift* 方法均为维护二叉堆（heapify）的步骤。



三、学习感受

​	经过第一周的算法训练，我碰到问题先看题，有思路的自己写实现，没思路的直接看解答，在解答区找前几个精选中最好有图片的解答进去，先看思路 如果有思路的自己可以实现下，最坏情况自己直接看代码，然后在纸上默写，感觉默写的差不多了直接去leetcode上的答案提交区写代码。

​	一天写的新算法题会记录在日历本上，等第二天早上根据日历本上写的题号，把前一天的题目解一遍。再开始第二天的内容。过了一个星期，正好可以看日历本上当前日期上一个日期（一周前）找到对应的代码进行复习解题。



四、本周不足

​	有时候自己有思路之后会写出各种bug，调试好多次，自己会很执着，这点导致了我刷题的效率不高。下周开始要改掉这个习惯，直接看答案。

​	因为之前写算法写的少，就算心里有实现方法了，实现起来还会碰到很多问题。以后要多写写算法来让自己提高手写算法的能力。

​	感觉自己看源码有点累，还是需要多看看Java的底层源码。



==为自己加油！努力坚持！祝愿自己能进个大厂！==

 	



​    