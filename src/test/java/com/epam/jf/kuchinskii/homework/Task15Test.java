package com.epam.jf.kuchinskii.homework;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class Task15Test {

    @Test
    public void testVerticalZeroShift() {
        Task15 task = new Task15();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result = task.verticalCyclicShift(matrix, 0);
        int[][] check = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertArrayEquals(result, check);
    }

    @Test
    public void testVerticalEmptyMatrix() {
        Task15 task = new Task15();
        int[][] matrix = {{}};

        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                int[][] result = task.verticalCyclicShift(matrix, 1);
            }
        });
    }

    @Test
    public void testVerticalOneShift() {
        Task15 task = new Task15();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result = task.verticalCyclicShift(matrix, 1);
        int[][] check = {{7, 8, 9}, {1, 2, 3}, {4, 5, 6}};
        assertArrayEquals(result, check);
    }

    @Test
    public void testVerticalMinusOneShift() {
        Task15 task = new Task15();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result = task.verticalCyclicShift(matrix, -1);
        int[][] check = {{4, 5, 6}, {7, 8, 9}, {1, 2, 3}};
        assertArrayEquals(result, check);
    }

    @Test
    public void testHorizontalZeroShift() {
        Task15 task = new Task15();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result = task.horizontalCyclicShift(matrix, 0);
        int[][] check = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertArrayEquals(result, check);
    }

    @Test
    public void testHorizontalEmptyMatrix() {
        Task15 task = new Task15();
        int[][] matrix = {{}};

        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                int[][] result = task.horizontalCyclicShift(matrix, 1);
            }
        });
    }

    @Test
    public void testHorizontalOneShift() {
        Task15 task = new Task15();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result = task.horizontalCyclicShift(matrix, 1);
        int[][] check = {{3, 1, 2}, {6, 4, 5}, {9, 7, 8}};
        assertArrayEquals(result, check);
    }

    @Test
    public void testHorizontalMinusOneShift() {
        Task15 task = new Task15();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result = task.horizontalCyclicShift(matrix, -1);
        int[][] check = {{2, 3, 1}, {5, 6, 4}, {8, 9, 7}};
        assertArrayEquals(result, check);
    }
}
