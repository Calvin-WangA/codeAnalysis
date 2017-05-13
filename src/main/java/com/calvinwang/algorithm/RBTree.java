package com.calvinwang.algorithm;

import java.util.Comparator;

/**
 * Created Date 2017/5/2
 *
 * @copyright SL131
 */
public class RBTree {

    /***
     * 左旋
     * @param x
     */
    public TreeNode leftRotate(TreeNode x) {
        TreeNode y = x.getRight();
        y.setParent(x.getParent());
        x.setRight(y.getLeft());
        x.setParent(y);
        y.setLeft(x);

        return x;
    }

    /**
     * 右旋
     * @param x
     */
    public TreeNode rightRotate(TreeNode x) {

        TreeNode y = x.getLeft();
        y.setParent(x.getParent());
        x.setLeft(y.getRight());
        x.setParent(y);
        y.setRight(x);

        return x;
    }


    /**
     * 二叉排序树插入操作
     * @param node 当前比较的节点
     * @param value 要插入的值
     */
    public void insertBSTree(TreeNode node, Comparator value) {

        Comparator nodeVal = node.getValue();
        if (nodeVal.equals(value)) {
            return ;
        }

        if (nodeVal.compare(value, nodeVal) < 0) {
            if (null ==  node.getLeft()) {
                node.setLeft(new TreeNode().setValue(value).setParent(node).setRed(true));
                return ;
            }
            insertBSTree(node.getLeft(), value);
        }
        else {
            if (null == node.getRight()) {
                node.setRight(new TreeNode().setValue(value).setParent(node).setRed(true));
                return ;
            }
            insertBSTree(node.getRight(), value);
        }

        return ;
    }

    /**
     * 进行红黑树的修复， 我们只需要记住红黑树解决红色节点的方案：即将红色节点移到
     * 根节点，将根节点置为黑色即可。
     * @param node
     */
    public void fixInsertRBTree(TreeNode node) {

        TreeNode parent = node.getParent();
        boolean left = false;
        TreeNode uncle = null;
        if (parent.isRed()) {
            //获得叔叔节点并且判断当前节点是左节点还是右节点
            if (parent.getParent().getLeft() == parent) {
                uncle = parent.getParent().getRight();
                left = true;
            } else {
                uncle = parent.getParent().getLeft();
            }
            //如果父， 叔都是红色节点， 则进行下面操作
            if (uncle.isRed()) {
                parent.setRed(false);
                uncle.setRed(false);
                node = parent.getParent();
                node.setRed(true);
                fixInsertRBTree(node);
            } else {
                //是当前节点的右孩子则进行左旋，目的则是使当前节点往上移，设置当前节点为父节点
                //这里当孩子是左孩子不进行右旋的原因是这样操作我们不可能通过祖父节点的旋转来平衡黑色节点
                if (node == parent.getRight()) {
                    node = leftRotate(parent);
                }

                //之后还是一样的两个红在一起，但是这时候的情况是当前节点是父节点的左孩子了，
                //现在进行操作， 将父节点置为黑色， 祖父节点置为红色
                parent = node.getParent();
                parent.setRed(false);
                parent.getParent().setRed(true);
                // 此时左边的黑色节点数多1了， 这时候为了平衡黑节点数，
                //则以祖父节点为支点进行右旋操作
                node = parent.getParent();
                if(left) {
                    node = rightRotate(node);
                }
                else {
                    node = leftRotate(node);
                }

            }
        }

    }

    public void fixRemoveRBTree(TreeNode node) {

    }
}
