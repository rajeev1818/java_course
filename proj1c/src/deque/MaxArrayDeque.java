package deque;

import java.util.Comparator;
import java.util.List;

public class MaxArrayDeque<T> extends ArrayDeque<T>{

    private Comparator<T> comp;

    public MaxArrayDeque(Comparator<T> c){
        super();
        comp=c;
    }

    public T max(){
        if(this.isEmpty()){
            return null;
        }
        List<T> arr = this.toList();
        T maximum= arr.get(0);
        for(T x:arr){
            if(comp.compare(x,maximum)>0){
                maximum=x;
            }
        }

        return maximum;
    }

    public T max(Comparator<T> c){
        if(this.isEmpty()){
            return null;
        }
        List<T> arr = this.toList();
        T maximum= arr.get(0);
        for(T x:arr){
            if(c.compare(x,maximum)>0){
                maximum=x;
            }
        }

        return maximum;
    }


    private static class Checker implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }

    public static void main(String[] args){
        MaxArrayDeque<String>dq = new MaxArrayDeque<>(new Checker());

        dq.addLast("Hero");
        dq.addLast("Zero");

        System.out.println(dq.max());
    }


}
