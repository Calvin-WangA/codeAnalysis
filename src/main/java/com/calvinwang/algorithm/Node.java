package com.calvinwang.algorithm;

import java.util.Comparator;

/**
 * Created Date 2017/5/3
 *
 * @copyright SL131
 */
public class Node<T extends Comparator> {

    private T value;

    private Node<T> parent;

    private Node<T> left;

    private Node<T> right;

    public T getValue() {
        return value;
    }

    public Node<T> setValue(T value) {
        this.value = value;

        return this;
    }

    public Node<T> getParent() {
        return parent;
    }

    public Node<T> setParent(Node<T> parent) {
        this.parent = parent;

        return parent;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> setLeft(Node<T> left) {
        this.left = left;

        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    public Node<T> setRight(Node<T> right) {
        this.right = right;

        return right;
    }
}
