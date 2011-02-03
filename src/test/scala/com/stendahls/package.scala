import com.stendahls.domain.Celebrity

package com.stendahls {

  package object support {

    val flipYears = (c:Celebrity) => {c.setDeathYear(c.getBirthYear - 1); c}

    val eliminateName = (c:Celebrity) => {c.setName(""); c}

    val killCelebrity = (c:Celebrity) => {c.setDeathYear(2011); c}
  }
}