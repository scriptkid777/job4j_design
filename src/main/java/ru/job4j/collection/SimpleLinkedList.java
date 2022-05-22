package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E>  implements LinkedList<E> {

    private Node<E>  first;

    private Node<E> last;

    private int size;

    private int modCount;

    public static class Node<E> {

        private final E element;

        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }


    @Override
    public void add(E value) {
    Node<E> newNode = new Node<E>(value, null);
    Node<E> last = this.last;
    if (last == null || size == 0) {
        this.first = newNode;
    } else {
      this.last.next = newNode;
    }
     this.last = newNode;
    size++;
    modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> rsl = first;
        for (int i = 0; i < index; i++) {
            rsl = rsl.next;
        }
        return rsl.element;
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> itNode = first;
            private final int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException("Облом");
                }
                return itNode != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Перебор");
                }
                E rsl = itNode.element;
                itNode = itNode.next;
                return rsl;
            }
        };
    }
}
