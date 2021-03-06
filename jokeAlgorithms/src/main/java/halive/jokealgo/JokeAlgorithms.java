/*
 * Copyright (c) HALive 2015
 * See LICENCE For Licence information.
 */

package halive.jokealgo;

import halive.visualsort.core.algorithms.sorting.SortingAlgorithm;
import halive.visualsort.core.plugins.IVisualSortPlugin;

public class JokeAlgorithms implements IVisualSortPlugin {

    @Override
    public String getPluginName() {
        return "Joke Algorithms";
    }

    @Override
    public String getPluginInfoFileName() {
        return null;
    }

    @Override
    public Class[] getDataGeneratorClasses() {
        return new Class[]{
                TrashGen.class
        };
    }

    @Override
    public Class<? extends SortingAlgorithm>[] getSortingAlgorithmClasses() {
        return new Class[]{
                BogoSort.class
        };
    }
}
