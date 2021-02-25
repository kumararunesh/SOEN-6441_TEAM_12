package org.Main;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Class for generating the Suite for the MapEditor
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({GraphConnectedTest.class,
        MapTableTest.class,
        ReadLinesTest.class,
        ContinentSubGraphTest.class})
public class MapEditorSuite {
}