package com.stendahls;

import com.stendahls.domain.Celebrity;
import com.stendahls.service.CelebrityService;
import com.stendahls.service.Delegater;
import org.junit.Test;

import java.util.Collections;

import static org.easymock.EasyMock.*;

/**
 * @author andreaskaltenbach
 */
public class EasyMockTestJava {

    // create mock
  CelebrityService celebrityServiceMock = createMock(CelebrityService.class);
  Delegater delegater = new Delegater(celebrityServiceMock);

  Celebrity michael = new Celebrity("Michael Jackson", 1958, 2009);

  @Test
  public void testDelegater() {

        // 1. define behaviour (Recording)
        celebrityServiceMock.resurrect(Collections.singleton(michael));
	    expectLastCall().times(1);

        // 2. Replay
		replay(celebrityServiceMock);

        delegater.delegateResurrection(michael);

        //3. Verify
		verify(celebrityServiceMock);
	}
}
