package com.stendahls.service;

import com.stendahls.domain.Celebrity;

import java.util.Set;

/**
 * @author andreaskaltenbach
 */
public interface CelebrityService {

    Celebrity createCelebrity(Celebrity celebrity);

    void resurrect(Set<Celebrity> person) throws CelebrityAlreadyAliveException;
}
