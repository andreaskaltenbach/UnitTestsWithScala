package com.stendahls.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author andreaskaltenbach
 */
public class Celebrity {

	private String name;
	private Integer birthYear;
	private Integer deathYear;

	public Celebrity(String name, Integer birthYear, Integer deathYear) {
		this.name = name;
		this.birthYear = birthYear;
		this.deathYear = deathYear;
	}


	@Override
	public String toString() {
		return name + ", born in " + birthYear + ", died in " + deathYear + ".";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(Integer birthYear) {
		this.birthYear = birthYear;
	}

	public Integer getDeathYear() {
		return deathYear;
	}

	public void setDeathYear(Integer deathYear) {
		this.deathYear = deathYear;
	}

	public boolean isAlive() {
		return deathYear == null;
	}
}
