package com.stendahls

import org.junit.{Test, Before}
import support.Celebrity
import support.Celebrity._

/**
 * 
 * @author andreaskaltenbach
 */
class ScalaCelebrityTest {

  def createCelebrityList =
    List(
      Celebrity("Michael Jackson", 1958, 2009),
      Celebrity("Madonna", 1958),
      Celebrity("Jesus", deathYear = 31))

  def createNo1UkHitsMap =
    Map(
       7 -> Celebrity("Michael Jackson", 1958, 2009),
      13 -> Celebrity("Madonna", 1958),
       0 -> Celebrity("Jesus", deathYear = 31))

  @Test def testCelebrities = {
    createCelebrityList foreach(println(_))
    createNo1UkHitsMap foreach(println(_))
  }
}