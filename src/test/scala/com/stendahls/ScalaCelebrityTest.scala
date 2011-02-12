package com.stendahls

import domain.Celebrity
import org.junit.{Test, Before}

/**
 * 
 * @author andreaskaltenbach
 */

class ScalaCelebrityTest {

  def createCelebrityList =
    List(
      new Celebrity("Michael Jackson", 1958, 2009),
      new Celebrity("Madonna", 1958, null),
      new Celebrity("Jesus", 0, 31))

  def createNo1UkHitsMap =
    Map(
       7 -> new Celebrity("Michael Jackson", 1958, 2009),
      13 -> new Celebrity("Madonna", 1958, null),
       0 -> new Celebrity("Jesus", 0, 31))

  @Test def testCelebrities = {
    createCelebrityList foreach(println(_))
    createNo1UkHitsMap foreach(println(_))
  }
}