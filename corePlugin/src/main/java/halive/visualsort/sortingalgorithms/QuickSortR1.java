/*
 * Copyright (c) HALive 2015
 * See LICENCE For Licence information.
 */

package halive.visualsort.sortingalgorithms;

import halive.visualsort.core.DataEntry;
import halive.visualsort.core.SortingHandler;
import halive.visualsort.sortingalgorithms.util.QuickSortBase;

/**
 * Implements one Implementation of Quick Sort. It uses The last Element as A privot element.
 */
public class QuickSortR1 extends QuickSortBase {

    public QuickSortR1() {
        super("Quick Sort - Variant 1", " ");
    }

    public int getPivotPos(int left, int right, DataEntry[] data, SortingHandler c) {
        int i = left;
        int j = right - 1;
        int pivot = data[right].getValue();
        while (c.compare(i <= j)) {
            if (c.compare(data[i].getValue() > pivot)) {
                c.swap(i, j);
                j--;
            } else {
                i++;
            }
        }
        c.swap(i, right);
        return i;
    }
}