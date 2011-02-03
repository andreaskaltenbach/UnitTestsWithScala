package com.stendahls.service;

import com.stendahls.domain.Celebrity;

import java.util.Collections;

public class Delegater {
	
	private CelebrityService delegate;
	
	public Delegater(CelebrityService delegate) {
		this.delegate = delegate;
	}

    /**
     * Returns true when the celebrity could be resurrected, otherwise false
     */
    public void delegateResurrection(Celebrity celebrity) {
		delegate.resurrect(Collections.singleton(celebrity));
	}

}
