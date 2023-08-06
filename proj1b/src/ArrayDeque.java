import java.util.ArrayList;
import java.util.List;

public class ArrayDeque<T> implements Deque<T> {
    private static int frontIndex;
    private static int backIndex;
    private T[] items;
    private static int length;

    public ArrayDeque(){
        items= (T[]) new Object[8];
        frontIndex=3;
        backIndex=4;
        length=0;
    }


    public static void main(String[] args){
        Deque<Integer>dq= new ArrayDeque<>();

        for(int i=0;i<200;i++){
            dq.addLast(i);
        }

        for(int i=0;i<160;i++){
            dq.removeFirst();
        }




    }

    private void resizeUp(){
        T[] newArr= (T[]) new Object[2 * items.length];
        int midIndex=newArr.length/2;
        int newArritr=midIndex;
        int itr=backIndex;
        int count=0;
        while(count<length){
            newArr[newArritr]=items[itr];
            newArritr=(newArritr+1)% newArr.length;
            itr=(itr+1)%items.length;
            count++;
        }
        backIndex=newArritr;
        frontIndex=midIndex-1;
        items=newArr;
    }

    private void resizeDown(){
        T[] newArr= (T[]) new Object[items.length/2];
        int midIndex=newArr.length/2;
        int newArritr=midIndex;
        int itr=frontIndex+1;
        int count=0;
        while(count<length){
            newArr[newArritr]=items[itr];
            newArritr=(newArritr+1)% newArr.length;
            itr=(itr+1)%items.length;
            count++;
        }
        backIndex=newArritr;
        frontIndex=midIndex-1;
        items=newArr;
    }


    @Override
    public void addFirst(T x) {

        if(length ==this.items.length){
            resizeUp();
            addFirst(x);
        }
        else{
            items[frontIndex]=x;
            if(frontIndex-1>=0){
                frontIndex-=1;
            }
            else{
                frontIndex=(frontIndex-1) % items.length+ items.length;
            }
            length++;
        }


    }

    @Override
    public void addLast(T x) {

        if(length==this.items.length){
            resizeUp();
            addLast(x);
        }
        else{
            items[backIndex]=x;
            if(backIndex+1< items.length){
                backIndex+=1;
            }
            else{
                backIndex=(backIndex+1)% items.length;
            }
            length++;
        }


    }

    @Override
    public List<T> toList() {
        List<T> returnList= new ArrayList<>();

        int itr=frontIndex+1;
        int count=0;
        while(count<length){
            returnList.add(items[itr]);
            itr=(itr+1)% items.length;
            count++;
        }

        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return length==0;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public T removeFirst() {
        if( length>16 &&  ((length * 1.0)/ items.length) * 100 < 25.0){
            resizeDown();
            return removeFirst();
        }

        frontIndex = (frontIndex+1)% items.length;
        T expectedVal=items[frontIndex];
        items[frontIndex]=null;
        length-=1;
        return expectedVal;
    }

    @Override
    public T removeLast() {

        if(length>16 && ((length * 1.0)/ items.length) * 100 < 25.0){
            resizeDown();
            return removeLast();
        }

        if(backIndex-1>=0){
            backIndex = (backIndex-1) % items.length;
        }
        else{
            backIndex = (backIndex-1) % items.length + items.length;
        }


        T expectedVal=items[backIndex];
        items[backIndex]=null;
        length-=1;
        return expectedVal;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= length){
            return null;
        }

        int actualIndex = (frontIndex+1+index) % items.length;
        return items[actualIndex];
    }
}
