package com.stendahls


import org.scalatest.mock.EasyMockSugar
import org.scalatest.junit.AssertionsForJUnit
import org.junit.Test
import service.{Delegater, CelebrityService}
import support.Celebrity
import scala.collection.JavaConversions._

/**
 * 
 * @author andreaskaltenbach
 */
class EasyMockTest extends AssertionsForJUnit with EasyMockSugar {

  // create mock
  val celebrityServiceMock = mock[CelebrityService]
  val delegater = new Delegater(celebrityServiceMock);

  val michael = Celebrity("Michael Jackson", 1958)

  @Test def testDelegater {

    // 1. define behaviour (Recording)
		expecting {
			celebrityServiceMock.resurrect(Set(michael)) times(1)
		}

    // 2./3. play mock behaviour (Replay & Verify)
		whenExecuting(celebrityServiceMock) {
			delegater.delegateResurrection(michael)
		}
	}
}