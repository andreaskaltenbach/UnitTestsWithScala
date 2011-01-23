package com.stendahls;

import com.stendahls.domain.Celebrity;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author andreaskaltenbach
 */
public class CelebrityTest {

  private List<Celebrity> createCelebrityList() {
    List<Celebrity> celebrityList = new ArrayList<Celebrity>();
    celebrityList.add(new Celebrity("Michael Jackson", 1958, 2009));
    celebrityList.add(new Celebrity("Madonna", 1958, null));
    celebrityList.add(new Celebrity("Jesus", 0, 31));
    return  celebrityList;
  }

  private Map<Integer, Celebrity> createNo1UkHitsMap() {
    Map<Integer, Celebrity> celebrityMap = new HashMap<Integer, Celebrity>();
    celebrityMap.put(7, new Celebrity("Michael Jackson", 1958, 2009));
    celebrityMap.put(13, new Celebrity("Madonna", 1958, null));
    celebrityMap.put(0, new Celebrity("Jesus", 0, 31));
    return  celebrityMap;
  }

  @Test
  public void testCelebrities() {
    for(Celebrity celebrity : createCelebrityList()) {
        System.out.println(celebrity);
    }

    for(Map.Entry<Integer, Celebrity> celebrityEntry : createNo1UkHitsMap().entrySet()) {
        System.out.println(celebrityEntry);
    }
  }
}
