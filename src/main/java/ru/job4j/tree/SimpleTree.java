package ru.job4j.tree;

import java.util.Optional;
import java.util.*;
import java.util.function.Predicate;

public class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> father = findBy(parent);
        List<Node<E>> sons = father.get().children;
        if (findBy(parent).isPresent()
                && findBy(child).isEmpty()) {
            sons.add(new Node<>(child));
            rsl = true;
        }
        return rsl;
    }


    public boolean isBinary() {
        return findByPredicate(node -> node.children.size() > 2).isEmpty();
    }


    public Optional<Node<E>> findBy(E value) {
        return findByPredicate(node -> node.value.equals(value));
    }


    public Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}
