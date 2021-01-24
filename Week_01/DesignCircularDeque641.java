/**
 * @Author: Andrew Lu
 * @Description: No Description
 */
public class DesignCircularDeque641 {
    /**
     * 用数组+双指针：front & rear
     * 注意所有会出现数组下标越界的情况 以及 判断空还是装满的函数的冲突（数组中必须多一个单位的空间）
     */
    /** Initialize your data structure here. Set the size of the deque to be k. */
    private int [] data;
    private int front;
    private int rear;
    private int capacity;

    public DesignCircularDeque641(int k) {
        //注意这里多一个单位空间，防止isEmpty()与isFull条件冲突
        this.capacity=k+1;
        data=new int[capacity];
        front=0;
        rear=0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        //先减再取余数 +capacity只是防止数组下标<0越界
        front=(front-1+capacity)%capacity;
        data[front]=value;
        return true;

    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        //注意这里rear指向的是要尾插的位置 先赋值再移动rear
        data[rear]=value;
        rear=(rear+1)%capacity;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        front=(front+1)%capacity;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        //注意这里加上capacity对于结果没有影响只是防止数组越界
        rear=(rear-1+capacity)%capacity;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(!isEmpty()) { return data[front];}
        return -1;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(!isEmpty()){return data[(rear-1+capacity)%capacity];}
        return -1;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return front==rear;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return ((rear+1)%capacity)==front;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
