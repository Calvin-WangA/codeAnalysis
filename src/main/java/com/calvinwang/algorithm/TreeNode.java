package com.calvinwang.algorithm;

import java.util.Comparator;

/**
 * Created Date 2017/5/2
 *
 * @copyright SL131
 */
public class TreeNode<T extends  Comparator> {

    private Comparator value;

    private TreeNode left;

    private TreeNode right;

    private TreeNode parent;

    private boolean red;

    public Comparator getValue() {
        return value;
    }

    public TreeNode setValue(T value) {
        this.value = value;

        return this;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode setLeft(TreeNode left) {
        this.left = left;

        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public TreeNode setRight(TreeNode right) {
        this.right = right;

        return right;
    }

    public TreeNode getParent() {
        return parent;
    }

    public TreeNode setParent(TreeNode parent) {
        this.parent = parent;

        return parent;
    }

    public boolean isRed() {
        return red;
    }

    public TreeNode setRed(boolean red) {
        this.red = red;

        return this;
    }

}
