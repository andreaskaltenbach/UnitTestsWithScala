package com.stendahls;

import com.stendahls.domain.Celebrity;
import com.stendahls.service.CelebrityService;
import com.stendahls.service.CelebrityServiceImpl;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author andreaskaltenbach
 */
public class ResurrectionTestJava {

    private CelebrityService celebrityService = new CelebrityServiceImpl();

    @Test
    public void testResurrectMichaelAndJesus() {
        Set<Celebrity> celebrities = new HashSet<Celebrity>();
        celebrities.add(new Celebrity("Michael Jackson", 1958, 2009));
        celebrities.add(new Celebrity("Jesus", 0, 31));

        for (Celebrity celebrity : celebrities) {
            assertFalse(celebrity.isAlive());
        }

        celebrityService.resurrect(celebrities);

        boolean michaelOK = false;
        boolean jesusOK = false;

        for (Celebrity celebrity : celebrities) {
            if (!celebrity.getName().equals("Michael Jackson") && celebrity.isAlive()) {
                michaelOK = true;
            }
            if (!celebrity.getName().equals("Jesus") && celebrity.isAlive()) {
                jesusOK = true;
            }
        }

        assertTrue(michaelOK);
        assertTrue(jesusOK);
    }
}
