package com.stendahls


import service.CelebrityServiceImpl
import support.Celebrity
import support.Celebrity._
import org.junit.{Test, Before}
import com.stendahls.support._
import org.scalatest.junit.AssertionsForJUnit
import com.stendahls.support.Implicits._
import scala.collection.JavaConversions._
import org.junit.Assert._

/**
 * 
 * @author andreaskaltenbach
 */

class TestWithFunctions {

  val celebrityService = new CelebrityServiceImpl

  /**
   * 1. Happy case creating Michael Jackson.
   */
  @Test
  def testCreateMichael {
    val michael = Celebrity("Michael Jackson", 1958, 2009)
    val result = celebrityService.createCelebrity(michael)
    assertEquals(michael, result)
  }

  /**
   * 2. Try to create anonymous celebrity.
   */
  @Test(expected=classOf[IllegalArgumentException])
  def testCreateAnonymous {
    val bandWithoutName = eliminateName(Celebrity("Band without name", 1995))
    celebrityService.createCelebrity(bandWithoutName);
  }

  /**
   * 3. Try to create a weird Ozzy Osbourne where the death year is before the birth year.
   */
  @Test(expected=classOf[IllegalArgumentException])
  def testCreateWeirdOzzy {
    val ozzy = Celebrity("Ozzy Osbourne", 1948)
    val weirdOzzy = flipYears(ozzy)
    celebrityService.createCelebrity(weirdOzzy);
  }

  /**
   * 4. Manipulate celebrity in multiple ways
   */
  @Test(expected=classOf[IllegalArgumentException])
  def testMultipleManipulators {
    val roadrunner = Celebrity("Road Runner", 1949)
    val manipulatedRoadrunner = doEverything(roadrunner)

    assertTrue(!manipulatedRoadrunner.isAlive)
    assertEquals("", manipulatedRoadrunner.getName())
    assertTrue(manipulatedRoadrunner.getBirthYear() > manipulatedRoadrunner.getDeathYear())

    celebrityService.createCelebrity(manipulatedRoadrunner);
  }

  // move to Manipulator package object
  def doEverything(c:domain.Celebrity) = flipYears(eliminateName(killCelebrity(c)))

  /**
   *  5. Kill a bunch of celebrities at one go
   */
  @Test
  def testKillALotOfCelebrities {
    val teenageMutantNinjaTurtles = List(
      Celebrity("Leonardo", 1984),
      Celebrity("Michelangelo", 1984),
      Celebrity("Donatello", 1984),
      Celebrity("Raphael", 1984))

    assertTrue(teenageMutantNinjaTurtles.forall(t => t.isAlive))

    teenageMutantNinjaTurtles.foreach(killCelebrity)

    assertTrue(teenageMutantNinjaTurtles.forall(t => !t.isAlive))
  }
}