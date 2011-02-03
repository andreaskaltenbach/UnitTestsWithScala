package com.stendahls.service;

import com.stendahls.domain.Celebrity;

/**
 * @author andreaskaltenbach
 */
public class CelebrityServiceImpl implements CelebrityService {

    @Override
    public Celebrity createCelebrity(Celebrity celebrity) {
        if (celebrity.getName() == null || celebrity.getName().isEmpty()) {
            throw new IllegalArgumentException("Name not set");
        }
        if (celebrity.getBirthYear() > celebrity.getDeathYear()) {
            throw new IllegalArgumentException("Birth year after death year");
        }
        return celebrity;
    }
}
