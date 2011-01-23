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
    scala.collection.immutable.Map.apply(
    //Map(
       7 -> new Celebrity("Michael Jackson", 1958, 2009),
      13 -> new Celebrity("Madonna", 1958, null),
       0 -> new Celebrity("Jesus", 0, 31))

  @Test def testCelebrities = {
    createCelebrityList foreach(println(_))
    createNo1UkHitsMap foreach(println(_))
  }


   /*
  @Test def testCelebrities() = {
  val celebrities = List(
Person("Michael Jackson", 1958, 2009),
Person("Madonna", 1958),
Person("Jesus", deathYear=31))

  val no1HitsUk = Map(
7 -> Person("Michael Jackson", 1958, 2009),
13 -> Person("Madonna", 1958),
0 -> Person("Jesus", deathYear=31))
  …
}*/
}