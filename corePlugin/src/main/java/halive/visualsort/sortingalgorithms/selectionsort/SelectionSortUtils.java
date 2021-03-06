/*
 * Copyright (c) HALive 2015
 * See LICENCE For Licence information.
 */

package halive.visualsort.sortingalgorithms.selectionsort;

import halive.visualsort.core.DataEntry;
import halive.visualsort.core.SortingHandler;

import java.awt.Color;

public class SelectionSortUtils {

    public static int getMinimumPos(DataEntry[] d, int startPos, int endPos, SortingHandler h) {
        int minp = startPos;
        for (int i = startPos; h.compare(i <= endPos); i++) {
            d[i].setTemporaryColor(Color.cyan);
            if (h.compare(i > 0)) {
                d[i].removeTemporaryColor();
            }
            if (h.compare(d[i].getValue() < d[minp].getValue())) {
                minp = i;
            }
        }
        return minp;
    }

    public static int getMaximumPos(DataEntry[] d, int startPos, int endPos, SortingHandler h) {
        int maxp = startPos;
        for (int i = startPos; h.compare(i <= endPos); i++) {
            d[i].setTemporaryColor(Color.yellow);
            if (h.compare(i > 0)) {
                d[i].removeTemporaryColor();
            }
            if (h.compare(d[i].getValue() > d[maxp].getValue())) {
                maxp = i;
            }
        }
        return maxp;
    }
}
