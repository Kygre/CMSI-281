package edu.lmu.cmsi.tree.node;

/**
 * A basic binary tree node
 */

public class BinaryTreeNode {
	private BinaryTreeNode right;
	private int value;
	private BinaryTreeNode left;

	public BinaryTreeNode(int theElement) {
		value = theElement;
		left = right = null;
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}

	public int getValue() {
		return value;
	}

	public boolean hasLeft() {
		return left != null;
	}

	public boolean hasRight() {
		return right != null;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	/*
	 * Stringy version of this node
	 */
	@Override
	public String toString() {

		String s = "";

		if (left != null) {
			s += left.getValue();
		} else {
			s += "NULL";
		}

		s += " <= " + this.value + " => ";

		if (right != null) {
			s += right.getValue();
		} else {
			s += "NULL";
		}

		return s;
	}

}
