package deque;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDeque<T> implements Deque<T> {

    Node<T> sentinel;
    int size;

    private class LinkedListIterator implements Iterator<T>{
        int index;
        private LinkedListIterator(){
            index=0;
        }
        @Override
        public boolean hasNext() {
            return index<size;
        }

        @Override
        public T next() {
            T returnValue= get(index);
            index+=1;
            return returnValue;
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private static class Node<T>{
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T x){
            this.data=x;
            this.prev=null;
            this.next=null;
        }
        Node(){
            this.next=null;
            this.prev=null;
        }
    }

    public LinkedListDeque(){
        sentinel= new Node<>();
        sentinel.next=sentinel;
        sentinel.prev=sentinel;
        size=0;
    }

    public static void main(String[] args){
        Deque<String> lld1 = new LinkedListDeque<>();

        lld1.addLast("front");
        lld1.addLast("middle");
        lld1.addLast("back");

        System.out.println(lld1);
    }

    @Override
    public void addFirst(T x) {
        Node<T> temp= new Node<>(x);
        sentinel.next.prev=temp;
        temp.next=sentinel.next;
        sentinel.next=temp;
        temp.prev=sentinel;
        size+=1;
    }

    @Override
    public void addLast(T x) {
        Node<T> temp=new Node<>(x);
        sentinel.prev.next=temp;
        temp.prev=sentinel.prev;
        sentinel.prev=temp;
        temp.next=sentinel;
        size+=1;
    }

    @Override
    public List<T> toList() {

        List<T> returnList= new ArrayList<>();

        Node<T> temp=sentinel.next;
        while (temp!=sentinel){
            returnList.add(temp.data);
            temp=temp.next;
        }
        return returnList;


    }

    @Override
    public boolean isEmpty() {
        return this.size==0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T removeFirst() {
        T data= sentinel.next.data;

        sentinel.next=sentinel.next.next;
        sentinel.next.prev=sentinel;


        return data;
    }

    @Override
    public T removeLast() {
        T data=sentinel.prev.data;

        sentinel.prev=sentinel.prev.prev;
        sentinel.prev.next=sentinel;

        return data;
    }

    @Override
    public T get(int index) {
        if(index<0){
            return null;
        }
        int itr=0;
        Node<T> temp=sentinel.next;

        while(temp!=sentinel && itr<=index){
            if(itr==index){
                return temp.data;
            }
            temp=temp.next;
            itr+=1;
        }

        if(itr<index){
            return null;
        }
        return temp.data;

    }

    private T helperGetRecursive(Node<T> ref,int index,int curr){
        if(ref==sentinel){
            return null;
        }
        else if(curr>index || curr<0){
            return null;
        }

        else if(curr==index){
            return ref.data;
        }

        return helperGetRecursive(ref.next,index,curr+1);


    }

    @Override
    public T getRecursive(int index) {
        return helperGetRecursive(sentinel.next,index,0);
    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;

        if(o instanceof LinkedListDeque other){
            if(other.size!=this.size){
                return false;
            }

            for(T x:this){
                if(!other.toList().contains(x)){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return this.toList().toString();

    }
}
