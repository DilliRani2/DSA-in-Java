package Day13;

import java.util.NoSuchElementException;

/*
Linear DS
LIFO
Implementation: 1. Array 2. LinkedList 3. Queue
 */
class ListNode{
    int data;
    ListNode next;
    public ListNode(int data){
        this.data=data;
        this.next=null;
    }
}
public class StackUsingLinkedlist {
    private ListNode top;
    private int length;
    public StackUsingLinkedlist(){
        this.top=null;
        this.length=0;
    }
    public boolean isEmpty(){
        return length==0;
    }
    public int size(){
        return length;
    }
    public void push(int value){
        ListNode newNode=new ListNode(value);
        if(top==null){
            top=newNode;
            length++;
            return;
        }
        newNode.next=top;
        top=newNode;
        length++;
    }
    public int pop(){
        if(isEmpty()){
            throw new NoSuchElementException("Stack is Empty");
        }
        int result=top.data;
        top=top.next;
        length--;
        return result;
    }
    public int peek(){
        if(isEmpty()){
            throw new NoSuchElementException("Stack is Empty");
        }
        return top.data;
    }

    public static void main(String[] args) {
        StackUsingLinkedlist stack=new StackUsingLinkedlist();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }

}
