import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque<T> implements Deque<T> {

    Node<T> sentinel;
    int size;

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
        Deque<Integer>lld= new LinkedListDeque<>();
        lld.addFirst(10);
        lld.addFirst(20);
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

    public T helperGetRecursive(Node<T> ref,int index,int curr){
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
}
