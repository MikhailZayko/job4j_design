package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row;
    private int column;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        if (row == data.length) {
            return false;
        }
        while (data[row].length == 0 && row < data.length - 1) {
            row++;
        }
        return data[row].length != 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int result = data[row][column++];
        if (column == data[row].length) {
            row++;
            column = 0;
        }
        return result;
    }
}
