package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        boolean rsl = false;
        expand();
        int index = 0;
        if (key != null) {
            index = indexFor(hash(key.hashCode()));
        }
            if (table[index] == null) {
                table[index] = new MapEntry(key, value);
                rsl = true;
            } else {
                rsl = false;
            }
            modCount++;
            count++;
        return rsl;
    }

    private int hash(int hashCode) {
        return  hashCode % capacity;
    }

    private int indexFor(int hash) {
        return hash % capacity;
    }

    private void expand() {
    float size = (float) count / (float) table.length;
    int index = 0;
    if (size >= LOAD_FACTOR) {
        capacity = capacity * 2;
        MapEntry<K, V>[] table2 = new MapEntry[capacity];
        MapEntry<K, V> tmp;
        for (int i = 0; i < table.length; i++) {
           if (table[i] != null) {
               tmp = table[i];
               if (tmp.key == null) {
                   index = 0;
               } else {
                   index =  indexFor(hash(tmp.key.hashCode()));
               }
             table2[index] = tmp;
           }
        }
        table = table2;
    }

    }

    @Override
    public V get(K key) {
        int index = 0;
        if (key != null) {
            index = indexFor(hash(key.hashCode()));
       }
        if (table[index] != null && Objects.equals(table[index].key, key)) {
            return table[index].value;
        }
       return null;
    }

    @Override
    public boolean remove(K key) {
        boolean rsl = false;
        int index = 0;
        if (key != null) {
            index = indexFor(hash(key.hashCode()));
        }
        if (table[index] != null && Objects.equals(table[index].key, key)) {
            table[index] = null;
            modCount++;
            count--;
          rsl = true;
        }
        return rsl;
    }

    @Override
    public Iterator<K> iterator() {
        return  new Iterator<K>() {

            int expectedModCount = modCount;

            int cursor;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                while (cursor < table.length && table[cursor] == null) {
                cursor++;
                }
                return cursor < table.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                   throw new NoSuchElementException();
                }
                System.out.println("key - " + table[cursor].key + " value - " + table[cursor].value);

                return table[cursor++].key;
            }
        };
    }



    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }
}