package com.stendahls

import org.scalatest.junit.AssertionsForJUnit
import service.{CelebrityAlreadyAliveException, CelebrityServiceImpl}
import support.Celebrity
import support.Celebrity._
import scala.collection.JavaConversions._
import org.scalatest.Assertions

import org.junit.Test
//import org.testng.annotations.Test

/**
 * 
 * @author andreaskaltenbach
 */
class ResurrectionTest extends Assertions {

  val celebrityService = new CelebrityServiceImpl

  /**
   * 1. Resurrect Michael Jackson
   */
  @Test def testResurrectMichaelJackson() {
    val michael = Celebrity("Michael Jackson", 1958, 2009)

    assert(!michael.isAlive)

    celebrityService.resurrect(Set(michael))

    assert(michael.isAlive)
  }

  /**
   * 2. Try to resurrect Madonna, but she is already alive
   */
  @Test def testResurrectMadonna() {
    val madonna = Celebrity("Madonna", 1958)

    intercept[CelebrityAlreadyAliveException] {
		  celebrityService.resurrect(Set(madonna))
		}
  }

  /**
   * 3. Resurrect Michael Jackson and Jesus and verify
   *    explicitly that those two are really alive again
   */
  @Test def testResurrectMichaelAndJesus() {
    val celebrities = Set(
      Celebrity("Michael Jackson", 1958, 2009),
      Celebrity("Jesus", deathYear=31))

    assert(celebrities.forall(c => !c.isAlive))

    celebrityService.resurrect(celebrities)

    assert(celebrities.exists(c => c.getName == "Michael Jackson" && c.isAlive), "Michael is not alive")
    assert(celebrities.exists(c => c.getName == "Jesus" && c.isAlive), "Jesus is not alive")
  }

  // struggle when switching between JUnit and TestNG in Java:
  // JUnit:  assertEquals(expected, actual)
  // TestNG: assertEquals(actual, expected)
}