package com.calvinwang.algorithm;

import java.util.Comparator;

/**
 * Created Date 2017/5/3
 *
 * @copyright SL131
 */
public class BSTree {

    /***
     * 初始化根节点
     * @param value
     * @return
     */
    public Node initBSTree(Comparator value) {
        Node root = null;
        if (null != value) {
            root = new Node();
            root.setValue(value);
        }
        return root;
    }

    /**
     * 中序遍历整个二叉树, 根据二叉树子树和根遍历顺序的不同，可以获得升序或者降序的数据
     *
     * @param node
     */
    public void middleQuery(Node node) {

        middleQuery(node.getLeft());
        System.out.println(node.getValue());
        middleQuery(node.getRight());
    }

    /**
     * 二叉排序树插入操作
     *
     * @param node  当前比较的节点
     * @param value 要插入的值
     */
    public void insertBSTree(Node node, Comparator value) {

        Comparator nodeVal = node.getValue();
        if (nodeVal.equals(value)) {
            return;
        }

        if (nodeVal.compare(value, nodeVal) < 0) {
            if (null == node.getLeft()) {
                node.setLeft(new Node().setValue(value).setParent(node));
                return;
            }
            insertBSTree(node.getLeft(), value);
        } else {
            if (null == node.getRight()) {
                node.setRight(new Node().setValue(value).setParent(node));
                return;
            }
            insertBSTree(node.getRight(), value);
        }

        return;
    }

    /**
     * 完整的移除节点
     *
     * @param node  传入的需要比较节点
     * @param value 需要移除的节点对应的值
     */
    public void removeBSTree(Node node, Comparator value) {
        Comparator nodeVal = node.getValue();
        //进行删除操作
        if (nodeVal.equals(value)) {
            removeNode(node);
        }

        //否则比较大小进入对应子树
        if (nodeVal.compare(value, nodeVal) < 0) {
            removeBSTree(node.getLeft(), value);
        } else {
            removeBSTree(node.getRight(), value);
        }

    }

    /**
     * 移除对应节点
     *
     * @param node 当前要移除的节点
     */
    public void removeNode(Node node) {
        Node parent = node.getParent();

        //当前节点是根节点， 则进行右边最小来代替根
        if (null == parent) {

        }

        if (null == node.getLeft() && null == node.getRight()) {
            setNotAllChild(parent, null, false);
            return ;
        }
        //左子树为空， 右子树不为空
        if (null == node.getLeft() && null != node.getRight()) {
            setNotAllChild(parent, node, false);
            return ;
        }
        //右子树为空， 左子树不为空
        if (null == node.getRight() && null != node.getLeft()) {
            setNotAllChild(parent, node, true);
            return ;
        }

        //都不为空， 这里我使用当前节点右子树的最小值替换当前节点
        setAllChild(parent, node);

        return;
    }

    /***
     * 有父节点又有左右孩子的情况
     * @param parent
     * @param node
     */
    public void setAllChild(Node parent, Node node) {
        //都不为空， 这里我使用当前节点右子树的最小值替换当前节点
        Node replace = node.getRight();
        while (null != replace.getLeft()) {
            replace = replace.getLeft();
        }
        //只有右节点一个节点的情况
        if (node.getRight() != replace) {
            replace.getParent().setLeft(null);
        }
        //设置replace为父节点的左或者右孩子
        Comparator parentVal = parent.getValue();
        int route = parentVal.compare(node.getValue(), parentVal);
        if (route < 0) {
            parent.setLeft(replace);
        } else {
            parent.setRight(replace);
        }
        //设置当前节点父节点
        replace.setParent(parent);
        //设置replace的左右孩子
        replace.setLeft(node.getLeft());
        replace.setRight(node.getRight());

        return ;
    }


    /**
     *解决被移除节点同时没有左右孩子的情况
     *
     * @param parent 被移除节点的父节点
     * @param node   代替被移除的节点
     * @param left   表示是被移除的节点的左孩子还是右孩子
     */
    public void setNotAllChild(Node parent, Node node, boolean left) {

        //表示的是无子节点
        if (null == node) {
            if (parent.getLeft() == node) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
            return;
        }

        //要删除的节点有左子节点或者右子节点
        Comparator parentVal = parent.getValue();
        int route = parentVal.compare(node.getValue(), parentVal);
        Node child = null;
        if (left) {
            child = node.getLeft();
        } else {
            child = node.getRight();
        }
        if (route < 0) {
            parent.setLeft(child);
        } else {
            parent.setRight(child);
        }
        child.setParent(parent);
    }

}
