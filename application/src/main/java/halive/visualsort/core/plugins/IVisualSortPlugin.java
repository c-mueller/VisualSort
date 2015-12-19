/*
 * Copyright (c) HALive 2015
 * See LICENCE For Licence information.
 */

package halive.visualsort.core.plugins;

import halive.visualsort.core.sorting.SortingAlgorithm;

/**
 * Classes implementing this Interface can be loaded by the PluginLoader to add More
 * Datagenerators and SortingAlgortihms
 *
 * @author HALive
 */
public interface IVisualSortPlugin {

    /**
     * Returns the name of the Plugin
     *
     * @return
     */
    String getPluginName();

    /**
     * Returns a Array of the Datagenerators addded by the Plugin.
     *
     * @return
     */
    Class[] getDataGeneratorClasses();

    Class<? extends SortingAlgorithm>[] getSortingAlgorithmClasses();
}