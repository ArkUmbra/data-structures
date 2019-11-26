package com.arkumbra.ds.map;

public interface Map<K, V> {

  void put(K k, V v);
  V get(K k);

  boolean containsKey(K k);
  boolean containsValue(V v);

}
