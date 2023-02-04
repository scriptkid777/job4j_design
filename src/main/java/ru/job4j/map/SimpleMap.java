package ru.job4j.map;

import java.util.*;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        boolean rsl;
        expand();
        int index;
            index = indexFor(hash(Objects.hashCode(key)));
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
       return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private void expand() {
    float size = (float) count / table.length;
    int index;
    if (size >= LOAD_FACTOR) {
        capacity *= 2;
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
        int index;
        V rsl = null;
        int  keyHash = this.hash(Objects.hashCode(key));
        index = indexFor(keyHash);
            if (table[index] != null && Objects.hashCode(key) == Objects.hashCode(table[index].key) && Objects.equals(table[index].key, key)) {
                        rsl = table[index].value;
                    }
        return rsl;
        }


    @Override
    public boolean remove(K key) {
        boolean rsl = false;
        int index;
        int keyHash = this.hash(Objects.hashCode(key));
            index = indexFor(keyHash);

        if (table[index] != null && Objects.hashCode(key) == Objects.hashCode(table[index].key) && Objects.equals(table[index].key, key)) {
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