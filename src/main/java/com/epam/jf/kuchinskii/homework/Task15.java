package com.epam.jf.kuchinskii.homework;

public class Task15 extends com.epam.jf.common.homework.Task15 {

    @Override
    public int[][] verticalCyclicShift(int[][] matrix, int numberShifts) {
        if (numberShifts == 0) {
            return matrix;
        }
        int width = matrix[0].length;
        if (width == 0) {
            throw new IllegalArgumentException("Invalid matrix.");
        }
        int length = matrix.length;
        int[][] result = new int[length][width];
        int numberShiftsAbs = Math.abs(numberShifts);
        numberShifts = numberShifts % length;

        for (int i = 0; i < length; i++) {
            int shiftIndex = (i + numberShiftsAbs <= length - 1) ? i + numberShiftsAbs
                                                                 : i + numberShiftsAbs - length;
            for (int j = 0; j < width; j++) {
                if (numberShifts > 0) {
                    result[shiftIndex][j] = matrix[i][j];
                } else {
                    result[i][j] = matrix[shiftIndex][j];
                }
            }
        }
        return result;
    }

    @Override
    public int[][] horizontalCyclicShift(int[][] matrix, int numberShifts) {
        if (numberShifts == 0) {
            return matrix;
        }
        int width = matrix[0].length;
        if (width == 0) {
            throw new IllegalArgumentException("Invalid matrix.");
        }
        int length = matrix.length;
        int[][] result = new int[length][width];
        int numberShiftsAbs = Math.abs(numberShifts);
        numberShifts = numberShifts % width;

        for (int i = 0; i < width; i++) {
            int shiftIndex = (i + numberShiftsAbs <= width - 1) ? i + numberShiftsAbs
                                                                : i + numberShiftsAbs - width;
            for (int j = 0; j < length; j++) {
                if (numberShifts > 0) {
                    result[j][shiftIndex] = matrix[j][i];
                } else {
                    result[j][i] = matrix[j][shiftIndex];
                }
            }
        }
        return result;
    }
}
