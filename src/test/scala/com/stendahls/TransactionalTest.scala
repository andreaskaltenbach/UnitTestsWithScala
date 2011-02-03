package com.stendahls

import org.junit.Test
import service.CelebrityServiceImpl
import support.TransactionSupport

/**
 * 
 * @author andreaskaltenbach
 */
class TransactionalTest extends TransactionSupport {

  val celebrityService = new CelebrityServiceImpl

  @Test def testInTransaction {
      transactional {
        val michael = CelebrityTest("Michael", 1958)
        celebrityService.createCelebrity(michael)
      }
  }
}