package com.stendahls.support

import javax.persistence.Persistence

/**
 * Trait for transactional behavior in unit tests.
 *
 * @author andreaskaltenbach
 */
trait TransactionSupport {

	val em = TestEntityManagerFactoryProvider.factory.createEntityManager

	def transactional(testCode: => Unit) = {
    println("Start transaction.")
		em.getTransaction.begin
    testCode
    println("Rollback transaction.")
		em.getTransaction.rollback
	}

	def persist[Entity](entity:Entity) = {
		em.persist(entity)
		entity
	}
}

object TestEntityManagerFactoryProvider {
	val factory = Persistence.createEntityManagerFactory("Test")
}