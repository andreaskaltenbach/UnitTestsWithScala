import com.stendahls.domain.Celebrity

import com.stendahls.support.Celebrity
import com.stendahls.support.Celebrity._
import org.scalacheck.Gen
import org.scalacheck.Gen._
import com.stendahls.support.Implicits._


package com.stendahls {

import support.Celebrity

  package object support {

      val flipYears = (c:Celebrity) => {c.setDeathYear(c.getBirthYear - 1); c}

      val eliminateName = (c:Celebrity) => {c.setName(""); c}

      val killCelebrity = (c:Celebrity) => {c.setDeathYear(2011); c}


      def CelebrityGenerator:Gen[domain.Celebrity] =  {
          for {
            name <- Gen.alphaStr
            birthYear <- Gen.choose(0, 2010)
            deathYear <- Gen.choose(birthYear, birthYear + 150)
          } yield Celebrity(name, birthYear, deathYear)
      }




      def CelebrityGenerator(alive:Boolean=false):Gen[domain.Celebrity] =  {
        if (alive) {
          for {
            name <- Gen.alphaStr
            birthYear <- Gen.choose(0, 2010)
          } yield Celebrity(name, birthYear)
        }
        else {
          for {
            name <- Gen.alphaStr
            birthYear <- Gen.choose(0, 2010)
            deathYear <- Gen.choose(birthYear, birthYear + 150)
          } yield Celebrity(name, birthYear, deathYear)
          }
      }


      def BoybandGenerator(members:Int=4, alive:Boolean=true)
        = Gen.containerOfN[Set, Celebrity](members, CelebrityGenerator(alive))
    }
}