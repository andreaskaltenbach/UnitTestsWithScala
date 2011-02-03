package com.stendahls

import org.junit.Test
import support.TransactionSupport

/**
 * 
 * @author andreaskaltenbach
 */
class TransactionalTest extends TransactionSupport {

  @Test def testInTransaction {
      transactional {
        println("Do something in transaction")
      }
  }
}