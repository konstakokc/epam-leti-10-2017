package com.epam.jf.kuchinskii.homework;

import com.epam.jf.common.homework.task7.AbstractIntArrayList;

public class Task7 extends AbstractIntArrayList {

    private int[] array;

    public Task7() {
        array = new int[16];
    }

    public Task7(int capacity) {
        array = new int[capacity];
    }

    public Task7(AbstractIntArrayList list) {

    }

    @Override
    public boolean add(int value) {
        return false;
    }

    @Override
    public boolean add(int value, int index) {
        return false;
    }

    @Override
    public int get(int index) {
        return 0;
    }

    @Override
    public boolean contains(int value) {
        return false;
    }

    @Override
    public boolean containsAll(AbstractIntArrayList list) {
        return false;
    }

    @Override
    public int remove(int index) {
        return 0;
    }

    @Override
    public int set(int value, int index) {
        return 0;
    }

    @Override
    public boolean addAll(AbstractIntArrayList list) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int indexOf(int value) {
        return 0;
    }

    @Override
    public int lastIndexOf(int value) {
        return 0;
    }

    @Override
    public AbstractIntArrayList subList(int fromInclusive, int toInclusive) {
        return null;
    }
}
