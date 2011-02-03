package com.stendahls.support

import org.junit.{After, Before}
import com.stendahls.domain.Celebrity
import com.stendahls.service.CelebrityServiceImpl

/**
 * 
 * @author andreaskaltenbach
 */
trait MockServiceStarter {

    @Before def startService =
      System.out.println("Starting mock service")

    @After def stopService() =
        System.out.println("Stop mock service")
}

/**
 * @author andreaskaltenbach
 */
trait TestDataCreator {

    val celebrityService = new CelebrityServiceImpl()

    var celebrities:List[Celebrity] = _

    @Before def before {
        if (!TestDataCreator.testDataCreated) {
            createTestData;
        }
    }

    def createTestData {
        println("Creating test data");
        celebrities =  List(
          celebrityService.createCelebrity(new Celebrity("Michael Jackson", 1958, 2009)),
          celebrityService.createCelebrity(new Celebrity("Madonna", 1958, null)),
          celebrityService.createCelebrity(new Celebrity("Jesus", 0, 31)))
        TestDataCreator.testDataCreated = true;
    }
}

object TestDataCreator {
  var testDataCreated = false
}

object Implicits {
    implicit def returnInt(i:java.lang.Integer):Int = i.intValue
}