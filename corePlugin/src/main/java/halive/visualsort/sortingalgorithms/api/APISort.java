/*
 * Copyright (c) HALive 2015
 * See LICENCE For Licence information.
 */

package halive.visualsort.sortingalgorithms.api;

import halive.visualsort.core.DataEntry;
import halive.visualsort.core.SortingHandler;
import halive.visualsort.core.algorithms.sorting.SortingAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * This Class sorts using hte Arrays.sort() method
 */
public class APISort extends SortingAlgorithm implements Comparator<DataEntry> {

    public APISort() {
        super("API Sort", "");
    }

    @Override
    public void doSort(DataEntry[] data, SortingHandler sortingHandler, int l, int r) {
        Arrays.sort(data, this);
    }

    @Override
    public int compare(DataEntry o1, DataEntry o2) {
        return o1.compareTo(o2);
    }

    @Override
    public String getCategory() {
        return "Java API";
    }

    @Override
    public boolean allowExport() {
        return false;
    }
}
