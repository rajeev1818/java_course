import deque.MaxArrayDeque;
import org.junit.jupiter.api.*;
import deque.Deque;
import deque.ArrayDeque;
import deque.LinkedListDeque;

import java.util.Comparator;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class MaxArrayDequeTest {

    @Test
    public void addLastTestBasicWithoutToList() {
        Deque<String> lld1 = new LinkedListDeque<>();

        lld1.addLast("front"); // after this call we expect: ["front"]
        lld1.addLast("middle"); // after this call we expect: ["front", "middle"]
        lld1.addLast("back"); // after this call we expect: ["front", "middle", "back"]
        assertThat(lld1).containsExactly("front", "middle","back");
    }

    @Test
    public void testEqualDeque() {
        Deque<String> lld1 = new ArrayDeque<>();
        Deque<String> lld2 = new ArrayDeque<>();

        lld1.addLast("front");
        lld1.addLast("middle");
        lld1.addLast("back");

        lld2.addLast("front");
        lld2.addLast("middle");
        lld2.addLast("back");

        assertThat(lld1).isEqualTo(lld2);
    }

    private class Dog{
        private int size;
        private String name;

        private Dog(String name, int size){
            this.name=name;
            this.size=size;
        }
    }

    private class DogChecker implements Comparator<Dog>{

        @Override
        public int compare(Dog o1, Dog o2) {
            if(o1.size==o2.size){
                return o1.name.compareTo(o2.name);
            }
            else{
                return o1.size-o2.size;
            }
        }
    }



    @Test
    public void checkMaxArrayDeque(){
        MaxArrayDeque<Dog> dq = new MaxArrayDeque<>(new DogChecker());

        Dog d1= new Dog("loofy",2);
        Dog d2= new Dog("rufus",2);
        dq.addLast(d1);
        dq.addLast(d2);

        assertThat(dq.max().name).isEqualTo("rufus");


    }



}
