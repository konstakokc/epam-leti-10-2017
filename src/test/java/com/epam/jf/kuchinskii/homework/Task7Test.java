package com.epam.jf.kuchinskii.homework;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Task7Test {

    @Test
    void testAdd() {
        Task7 t = new Task7();
        t.add(1);
        t.add(2);
        t.add(5, 2);
        int[] check = new int[]{1, 2, 5};
        assertArrayEquals(t.toArray(), check);

        t.add(10, 1);
        check = new int[]{1, 10, 2, 5};
        assertArrayEquals(t.toArray(), check);
    }

    @Test
    void testGet() {
        Task7 t = new Task7();
        t.add(1);
        t.add(2);
        t.add(5);
        int check = 2;
        assertEquals(t.get(1), check);
    }

    @Test
    void testSet() {
        Task7 t = new Task7();
        t.add(1);
        t.add(2);
        t.set(10, 0);
        int check = 10;
        assertEquals(t.get(0), check);
    }

    @Test
    void testRemove() {
        Task7 t = new Task7();
        t.add(1);
        t.add(2);
        t.add(3);
        t.remove(0);
        int[] check = {2, 3};
        assertArrayEquals(t.toArray(), check);
    }

    @Test
    void testContains() {
        Task7 t = new Task7();
        t.add(1);
        t.add(2);
        t.add(3);
        assertTrue(t.contains(1));
        assertFalse(t.contains(0));
    }

    @Test
    void testIndexOf() {
        Task7 t = new Task7();
        t.add(1);
        t.add(2);
        t.add(3);
        assertEquals(t.indexOf(2), 1);
        assertEquals(t.lastIndexOf(2), 1);
    }

    @Test
    void testSubList() {
        Task7 t = new Task7();
        t.add(1);
        t.add(2);
        t.add(3);
        t.add(4);
        t.add(5);
        Task7 subT = (Task7) t.subList(1,3);
        int[] check = {2, 3, 4};
        assertArrayEquals(subT.toArray(), check);
    }

    @Test
    void testContainsAll() {
        Task7 t = new Task7();
        t.add(1);
        t.add(2);
        t.add(3);
        t.add(4);
        t.add(5);
        Task7 subT = (Task7) t.subList(1,3);
        assertTrue(t.containsAll(subT));
        t.clear();
        assertFalse(t.containsAll(subT));
    }

    @Test
    void testAddAll() {
        Task7 t = new Task7();
        t.add(1);
        t.add(2);

        Task7 t2 = new Task7(t);
        t.addAll(t2);

        int[] check = {1, 2, 1, 2};
        assertArrayEquals(t.toArray(), check);
    }

}
