import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class ArrayDequeTest {

    @Test
    public void testToList(){
        Deque<Integer>dq = new ArrayDeque<>();

        dq.addLast(2);
        dq.addLast(5);
        dq.addLast(6);
        assertThat(dq.toList()).containsExactly(2,5,6).inOrder();
        dq.addLast(7);
        dq.addLast(10);
        dq.addFirst(8);
        dq.addFirst(9);
        dq.addFirst(7);
        assertThat(dq.toList()).containsExactly(7,9,8,2,5,6,7,10).inOrder();
        dq.addFirst(6);
        dq.addLast(23);
        dq.addFirst(27);
        assertThat(dq.toList()).containsExactly(27,6,7,9,8,2,5,6,7,10,23).inOrder();

    }

    @Test
    public void testIsEmpty(){
        Deque<Integer> dq= new ArrayDeque<>();

        assertThat(dq.isEmpty()).isTrue();
        dq.addLast(20);
        dq.addFirst(30);
        dq.addLast(55);
        assertThat(dq.isEmpty()).isFalse();

    }

    @Test
    public void testSize(){
        Deque<Integer> dq= new ArrayDeque<>();

        assertThat(dq.size()).isEqualTo(0);

        dq.addLast(20);
        dq.addFirst(30);
        dq.addLast(40);
        dq.addFirst(50);
        dq.addLast(88);
        dq.addFirst(56);
        dq.addLast(11);
        dq.addLast(30);

        assertThat(dq.size()).isEqualTo(8);

        dq.addLast(30);
        dq.addLast(50);
        assertThat(dq.size()).isEqualTo(10);
    }

    @Test
    public void testGet(){
        Deque<Integer> dq= new ArrayDeque<>();

        assertThat(dq.get(-1)).isNull();
        assertThat(dq.get(2345)).isNull();

        dq.addLast(30);
        dq.addLast(40);
        dq.addLast(50);
        dq.addFirst(10);
        dq.addFirst(45);

        assertThat(dq.get(1)).isEqualTo(10);
        dq.addLast(21);
        dq.addLast(23);
        dq.addFirst(19);

        assertThat(dq.get(5)).isEqualTo(50);
        dq.addFirst(59);

        assertThat(dq.get(0)).isEqualTo(59);
    }

    @Test
    public void testRemoveFirst(){
        Deque<Integer>dq = new ArrayDeque<>();

        for(int i=0;i<200;i++){
            dq.addLast(i);
        }

        for(int i=0;i<160;i++){
            dq.removeFirst();
        }
        assertThat(dq.size()).isLessThan(110);

    }

    @Test
    public void testRemoveLast(){
        Deque<Integer>dq = new ArrayDeque<>();

        dq.addLast(30);
        dq.addLast(40);
        dq.addLast(50);
        dq.addFirst(10);
        dq.addFirst(45);

        assertThat(dq.removeLast()).isEqualTo(50);

        assertThat(dq.toList()).containsExactly(45,10,30,40);

        assertThat(dq.removeLast()).isEqualTo(40);

        assertThat(dq.toList()).containsExactly(45,10,30);


    }

}



