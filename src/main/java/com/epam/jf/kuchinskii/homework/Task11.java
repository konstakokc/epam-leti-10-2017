package com.epam.jf.kuchinskii.homework;

public class Task11 extends com.epam.jf.common.homework.Task11 {

    @Override
    public int reverse(int value) {
        return (value < 10) ? value : (value % 10 + reverse(value / 10));
    }
}
