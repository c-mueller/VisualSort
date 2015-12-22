/*
 * Copyright (c) HALive 2015
 * See LICENCE For Licence information.
 */

package halive.visualsort.visualsort;

import halive.visualsort.core.DataEntry;
import halive.visualsort.core.SortingHandler;
import halive.visualsort.core.datageneration.DataGenerator;
import halive.visualsort.CorePlugin;
import halive.visualsort.core.sorting.SortingAlgorithm;
import halive.visualsort.sortingalgorithms.SlowSort;
import halive.visualsort.visualsort.util.SortingTestUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

/**
 * Combined Test, this Test tests every Sorting Algorithm wth every DataGenerator
 */
@RunWith(Parameterized.class)
public class GenerationAndAlgorithmTest {

    private SortingHandler handler;
    private Combination<DataGenerator, SortingAlgorithm> comb;
    private DataEntry[] entries;

    public GenerationAndAlgorithmTest(Combination<DataGenerator, SortingAlgorithm> comb) {
        this.comb = comb;
    }

    @Before
    public void setUp() throws Exception {
        handler = new SortingHandler(null);
        handler.setSortingAlgorithm(comb.b);
        handler.setDataGenerator(comb.a);
        int amtEntries = comb.b instanceof SlowSort ? 100 : 1000;
        this.entries = new DataEntry[amtEntries];
        for (int i = 0; i < entries.length; i++) {
            entries[i] = new DataEntry(1);
        }
        handler.setEntries(entries);
    }

    @Test
    public void testGeneratorAndSorter() throws Exception {
        comb.a.generateData(entries, DataGeneratorTest.MAX_VALUE);
        int[] v1 = SortingTestUtils.countValues(DataGeneratorTest.MAX_VALUE, entries);
        assertTrue("The Generated data is Invalid.", DataGeneratorTest.isDataValid(entries));
        comb.b.doSort(entries, handler);
        SortingTestUtils.isSorted(entries, handler);
        SortingTestUtils.compareCountArrays(v1, SortingTestUtils.countValues(DataGeneratorTest.MAX_VALUE, entries));
    }

    @Parameterized.Parameters(name = "{index}: {0}")
    public static Collection<Combination<DataGenerator, SortingAlgorithm>> data()
            throws IllegalAccessException, InstantiationException {
        ArrayList<Combination<DataGenerator, SortingAlgorithm>> combinations = new ArrayList<>();
        CorePlugin corePlugin = new CorePlugin();
        for (Class<? extends DataGenerator> c : corePlugin.getDataGeneratorClasses()) {
            DataGenerator gen = c.newInstance();
            for (Class<? extends SortingAlgorithm> a : corePlugin.getSortingAlgorithmClasses()) {
                SortingAlgorithm alg = a.newInstance();
                Combination<DataGenerator, SortingAlgorithm> combination = new Combination<>(gen, alg);
                combinations.add(combination);
            }
        }
        return combinations;
    }

    private static class Combination<A, B> {

        private A a;
        private B b;

        public Combination(A a, B b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return a + " - " + b;
        }
    }
}
