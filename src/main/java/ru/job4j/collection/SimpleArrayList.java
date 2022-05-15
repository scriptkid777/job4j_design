package ru.job4j.collection;

import ru.job4j.list.List;

import java.util.*;

public class SimpleArrayList<T> implements List<T> {

    private T[] container;

    private int size;

    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        chSize();
        container[size] = value;
        size++;
        modCount++;
    }

    @Override
    public T set(int index, T newValue) {
        T old = get(index);
        container[index] = newValue;
        return old;
    }

    @Override
    public T remove(int index) {
        T old = get(index);
        System.arraycopy(container, index + 1, container, index, container.length - index - 1);
        container[size - 1] = null;
        modCount++;
        --size;
        return old;
    }

    @Override
    public T get(int index) {
     Objects.checkIndex(index, size);
     return container[index];
    }

    @Override
    public int size() {
     return size;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            final int expectedModCount = modCount;
            int pos = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException("Исключение");
                }
                return pos < size;
            }

            @Override
            public T next() {
              if (!hasNext()) {
               throw new  NoSuchElementException("exception");
              }
              return container[pos++];
            }
        };
    }
    private T[] chSize() {
        if (container.length == 0) {
         container[0] = null;
        }
        if (size == container.length) {
            container = Arrays.copyOf(container, container.length * 2);
        }
        return container;
    }
}
