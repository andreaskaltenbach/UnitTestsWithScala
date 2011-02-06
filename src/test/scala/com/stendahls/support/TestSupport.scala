package com.stendahls.support

import org.junit.{After, Before}
import com.stendahls.domain.Celebrity
import com.stendahls.service.CelebrityServiceImpl
import org.scalacheck.Gen

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

    implicit def optionToInt(o:Option[Int]):Int = o.get
    implicit def optionToString(o:Option[String]):String = o.get
    implicit def optionToCelebrity(o:Option[com.stendahls.domain.Celebrity]):com.stendahls.domain.Celebrity = o.get
    implicit def optionToCelebritySet(o:Option[Set[com.stendahls.domain.Celebrity]]):Set[com.stendahls.domain.Celebrity] = o.get
}