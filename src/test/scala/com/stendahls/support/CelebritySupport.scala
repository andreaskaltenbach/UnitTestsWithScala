package com.stendahls.support

import com.stendahls.domain.Celebrity

/**
 * @author andreaskaltenbach
 */
object Celebrity {

  /** Factory method */
	def apply(name:String, birthYear:Int = 0, deathYear:Option[Int] = None) =

     deathYear match {
       case Some(deathYear) => new Celebrity(name, birthYear, deathYear)
       //case None => new Celebrity(name, birthYear, null)
     }

  /** Implicit converson from Int to Some[Int] */
  implicit def intToSomeWrapper(i:Int):Option[Int] = Some(i)
}