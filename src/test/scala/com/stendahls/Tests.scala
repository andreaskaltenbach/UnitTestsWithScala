package com.stendahls

import org.junit.Test
import support.{TestDataCreator, MockServiceStarter}

/**
 *
 * @author andreaskaltenbach
 */
class ScalaTestWithMockService extends MockServiceStarter {

  @Test def test {
        System.out.println("Running ScalaTestWithMockService ...");
  }

}

class ScalaTestWithTestData extends TestDataCreator {

    @Test def test {
        System.out.println("Running ScalaTestWithTestData ...");
    }
}

class ScalaTestWithTestDataAndMockService extends MockServiceStarter with TestDataCreator {

    @Test def test {
        System.out.println("Running ScalaTestWithTestDataAndMockService ...");
    }
}
