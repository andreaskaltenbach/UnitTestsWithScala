package com.stendahls

import domain.Celebrity
import org.junit.Test
import org.scalacheck.Gen
import org.scalacheck.Gen._

import com.stendahls.support._
import scala.collection.JavaConversions._
import com.stendahls.support.Implicits._
import service.{CelebrityAlreadyAliveException, CelebrityServiceImpl}
import org.scalatest.Assertions

/**
 * 
 * @author andreaskaltenbach
 */
class TestWithGenerator extends Assertions {

  val celebrityService = new CelebrityServiceImpl


  /**
   * 1. Use ScalaCheck primitive generators
   */
  @Test def testResurrectionWithPrimitiveGenerators {

    val name = Gen.alphaStr.sample
    val birthYear = Gen.choose(0, 2010).sample
    val deathYear = Gen.choose(birthYear, birthYear + 150).sample

    val celebrity = support.Celebrity(name, birthYear, deathYear)

    assert(!celebrity.isAlive)

    celebrityService.resurrect(Set(celebrity))

    assert(celebrity.isAlive)

  }

  /**
   * 2. Use own generator object
   */
  @Test def testResurrectionWithDeadCelebrity {

    val celebrity:Celebrity = CelebrityGenerator.sample

    assert(!celebrity.isAlive)

    celebrityService.resurrect(Set(celebrity))

    assert(celebrity.isAlive)

  }

  /**
   * 3. Use own generator with named and default arguments
   */
  @Test def testResurrectionOfAliveCelebrity {

    val celebrity:Celebrity = CelebrityGenerator(alive=true).sample

    assert(celebrity.isAlive)

    intercept[CelebrityAlreadyAliveException] {
      celebrityService.resurrect(Set(celebrity))
    }
  }

  /**
   *  4. use boyband generator
   */
  @Test def testResurrectBoyband {
    val boyband:Set[Celebrity] = BoybandGenerator(members=5, alive=false).sample

    assert(boyband.size == 5)

    assert(boyband.forall(c => !c.isAlive))

    celebrityService.resurrect(boyband)

    assert(boyband.forall(c => c.isAlive))
  }
}