package Day13;

import java.util.NoSuchElementException;
import java.util.Queue;

/*
Linear DS
FIFO
Insertion end=> rear end
Deletion end=> front end
 */

public class QueueUsingLinkedList {
    private ListNode front;
    private ListNode rear;
    private int length;
    public QueueUsingLinkedList(){
        front=null;
        rear=null;
        length=0;
    }
    public boolean isEmpty(){
        return length==0;
    }
    public int size(){
        return length;
    }
    public void enqueue(int value){
        ListNode newNode=new ListNode(value);
        if(front==null){
            front=newNode;
        }else{
            rear.next=newNode;
        }
        rear=newNode;
        length++;
    }
    public int dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is Empty");
        }
        int result=front.data;
        front=front.next;
        if(front==null){
            rear=null;
        }
        length--;
        return result;
    }
    public int first(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is Empty");
        }
        return front.data;
    }
    public int last(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is Empty");
        }
        return rear.data;
    }
    public static void main(String[] args) {
        QueueUsingLinkedList queue=new QueueUsingLinkedList();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

}
