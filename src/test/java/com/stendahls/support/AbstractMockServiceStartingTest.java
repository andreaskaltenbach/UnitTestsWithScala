package com.stendahls.support;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * @author andreaskaltenbach
 */
public abstract class AbstractMockServiceStartingTest {

    @Before
    public void startService() {
        System.out.println("Starting mock service");
    }

    @After
    public void stopService() {
        System.out.println("Stop mock service");
    }

}
