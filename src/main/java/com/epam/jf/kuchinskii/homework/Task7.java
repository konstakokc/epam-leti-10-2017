package com.epam.jf.kuchinskii.homework;

import com.epam.jf.common.homework.task7.AbstractIntArrayList;
import java.util.Arrays;

public class Task7 extends AbstractIntArrayList {

    private static final int DEFAULT_CAPACITY = 10;
    private static final int[] EMPTY_ELEMENTDATA = {};
    private static final int[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    private int[] elementData;
    private int size;

    public Task7() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public Task7(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new int[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    public Task7(AbstractIntArrayList list) {
        Task7 t = (Task7)list;
        elementData = t.toArray();
        if ((size = elementData.length) == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        }
    }

    public int[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    private void rangeCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
    }

    @Override
    public boolean add(int value) {
        ensureCapacity(size + 1);
        elementData[size++] = value;
        return true;
    }

    @Override
    public boolean add(int value, int index) {
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);
        System.arraycopy(elementData, index, elementData, index + 1,size - index);
        elementData[index] = value;
        size++;
        return true;
    }

    public void ensureCapacity(int minCapacity) {
        minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        if (minCapacity - elementData.length > 0) {
            grow(minCapacity);
        }
    }

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            newCapacity = hugeCapacity(minCapacity);
        }
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }

    @Override
    public int get(int index) {
        rangeCheck(index);
        return elementData[index];
    }

    @Override
    public boolean contains(int value) {
        return indexOf(value) >= 0;
    }

    @Override
    public boolean containsAll(AbstractIntArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            if (!this.contains(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int remove(int index) {
        rangeCheck(index);

        int oldValue = elementData[index];

        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        size--;
        return oldValue;
    }

    @Override
    public int set(int value, int index) {
        rangeCheck(index);
        int oldValue = elementData[index];
        elementData[index] = value;
        return oldValue;
    }

    @Override
    public boolean addAll(AbstractIntArrayList list) {
        Task7 t = (Task7)list;
        int[] a = t.toArray();
        int numNew = a.length;
        ensureCapacity(size + numNew);  // Increments modCount
        System.arraycopy(a, 0, elementData, size, numNew);
        size += numNew;
        return numNew != 0;
    }

    @Override
    public void clear() {
        this.elementData = EMPTY_ELEMENTDATA;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int value) {
        for (int i = size - 1; i >= 0; i--) {
            if (elementData[i] == value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public AbstractIntArrayList subList(int fromInclusive, int toInclusive) {
        rangeCheck(fromInclusive);
        rangeCheck(toInclusive);
        if (Integer.compare(toInclusive, fromInclusive) < 0) {
            throw new IllegalArgumentException(toInclusive + " must be greater than " + fromInclusive);
        }

        Task7 subList = new Task7(toInclusive - fromInclusive);

        for (int i = fromInclusive; i <= toInclusive; i++) {
            subList.add(elementData[i]);
        }

        return subList;
    }
}
