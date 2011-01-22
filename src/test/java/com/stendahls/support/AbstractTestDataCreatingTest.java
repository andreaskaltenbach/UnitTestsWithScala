package com.stendahls.support;

import com.stendahls.domain.Celebrity;
import com.stendahls.service.CelebrityService;
import com.stendahls.service.CelebrityServiceImpl;
import org.junit.After;
import org.junit.Before;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author andreaskaltenbach
 */
public abstract class AbstractTestDataCreatingTest {

    public static boolean testDataCreated = false;

    private List<Celebrity> celebrities;

    private CelebrityService celebrityService = new CelebrityServiceImpl();

    @Before
    public void before() {
        if (!testDataCreated) {
            createTestData();
        }
    }

    private void createTestData() {
        System.out.println("Creating test data");

        celebrities = new ArrayList<Celebrity>();
        celebrities.add(celebrityService.createCelebrity(new Celebrity("Michael Jackson", 1958, 2009)));
        celebrities.add(celebrityService.createCelebrity(new Celebrity("Madonna", 1958, null)));
        celebrities.add(celebrityService.createCelebrity(new Celebrity("Jesus", 0, 31)));
        testDataCreated = true;
    }

    protected List<Celebrity> getTestData() {
        return celebrities;
    }
}
