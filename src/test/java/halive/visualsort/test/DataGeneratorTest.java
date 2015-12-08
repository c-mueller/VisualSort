package halive.visualsort.test;

import halive.visualsort.core.DataEntry;
import halive.visualsort.core.datageneration.DataGenerator;
import halive.visualsort.core.plugins.CorePlugin;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

/**
 * This test is ued to test he Validity of a data Generator
 */
@RunWith(Parameterized.class)
public class DataGeneratorTest {

    private static final int MAX_VALUE = 1000;

    private DataGenerator dataGen;
    private DataEntry[] dataEntries = new DataEntry[1000];

    public DataGeneratorTest(Class<? extends DataGenerator> gen)
            throws IllegalAccessException, InstantiationException {
        dataGen = gen.newInstance();
    }

    @Before
    public void setUp() throws Exception {
        for (int i = 0; i < dataEntries.length; i++) {
            dataEntries[i] = new DataEntry(1);
        }
    }

    @Test
    public void testDataGenerators() throws Exception {
        dataGen.generateData(dataEntries, MAX_VALUE);
        assertTrue(dataGen.getName() + " Did not generate valid data!", isDataValid(dataEntries));
    }

    public static boolean isDataValid(DataEntry[] dataEntries) {
        for (int i = 0; i < dataEntries.length; i++) {
            DataEntry e = dataEntries[i];
            if (e.getValue() > MAX_VALUE || e.getValue() < 0) {
                return false;
            }
        }
        return true;
    }

    @Parameterized.Parameters(name = "{index}: {0}")
    public static Collection<Class<? extends DataGenerator>> getAlgorithms() {
        return Arrays.asList(new CorePlugin().getDataGeneratorClasses());
    }
}