package com.stendahls.support;

import org.junit.After;
import org.junit.Before;

import java.util.Arrays;
import java.util.List;

/**
 * @author andreaskaltenbach
 */
public abstract class AbstractTestDataCreatingTest {

    public static boolean testDataCreated = false;

    private List<String> testData;

    @Before
    public void createTestDataService() {
        if (!testDataCreated) {
            createTestData();
        }
    }

    private void createTestData() {
        System.out.println("Creating test data");
        testData = Arrays.asList("Michael Jackson", "Madonna", "Jesus");
        testDataCreated = true;
    }

    protected List<String> getTestData() {
        return testData;
    }
}
