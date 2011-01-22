package com.stendahls.service;

import com.stendahls.domain.Celebrity;

/**
 * @author andreaskaltenbach
 */
public class CelebrityServiceImpl implements CelebrityService {

    @Override
    public Celebrity createCelebrity(Celebrity celebrity) {
        return celebrity;
    }
}
