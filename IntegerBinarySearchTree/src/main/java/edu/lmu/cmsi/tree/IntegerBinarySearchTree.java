package edu.lmu.cmsi.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import edu.lmu.cmsi.tree.exception.DuplicateItemException;
import edu.lmu.cmsi.tree.exception.ItemNotFoundException;
import edu.lmu.cmsi.tree.node.BinaryTreeNode;

public class IntegerBinarySearchTree {

	protected BinaryTreeNode root;

	public IntegerBinarySearchTree() {
		this.root = null;
	}

	public static void main(String[] args) {
		IntegerBinarySearchTree it = new IntegerBinarySearchTree();
		int max = 3;
		for (int i = 1; i <= max; i++) {
			it.insert(i);
		}

		it.toInOrder();

		for (Integer a : it.toBreadthFirstOrder()) {
			System.out.print(a + " - ");
		}
	}

	/**
	 * Insert into the tree.
	 *
	 * @param x
	 *            the item to insert.
	 * @throws edu.lmu.cmsi.tree.exception.DuplicateItemException
	 *             if x exists.
	 */
	public void insert(int x) {
		if (this.root == null) {

			this.root = new BinaryTreeNode(x);
		} else if (this.contains(x)) {

			throw new DuplicateItemException(x);

		} else {
			// recurse down
			BinaryTreeNode low = recurseDown(this.root, x);
			BinaryTreeNode insert = new BinaryTreeNode(x);

			if (low.getValue() > x) {
				// set to left
				low.setLeft(insert);
			} else {

				// set to right
				low.setRight(insert);
			}

		}

	}

	/**
	 * Helper method to insert x at correct location
	 * 
	 * @param x
	 * @return the lowest node before x value
	 */
	private BinaryTreeNode recurseDown(BinaryTreeNode node, int x) {

		if (node.getValue() > x) {
			// move left
			if (node.getLeft() != null) {
				return recurseDown(node.getLeft(), x);
			}
		} else {
			// move right
			if (node.getRight() != null) {
				return recurseDown(node.getRight(), x);
			}
		}

		return node;
	}

	/**
	 * Find the smallest item in the tree.
	 *
	 * @return smallest item or throws an exception if the tree is empty.
	 * @throws edu.lmu.cmsi.tree.exception.ItemNotFoundException
	 *
	 */
	public int findSmallestValue() {
		if (this.isEmpty()) {
			throw new ItemNotFoundException();
		} else {
			BinaryTreeNode node = this.root;

			while (node.hasLeft()) {
				node = node.getLeft();
			}

			return node.getValue();
		}
	}

	/**
	 * Find the largest item in the tree.
	 *
	 * @return the largest item or throws an exception if the tree is empty.
	 * @throws edu.lmu.cmsi.tree.exception.ItemNotFoundException
	 *
	 */
	public int findLargestValue() {
		if (this.isEmpty()) {
			throw new ItemNotFoundException();
		} else {
			BinaryTreeNode node = this.root;

			while (node.hasRight()) {
				node = node.getRight();
			}

			return node.getValue();
		}
	}

	/**
	 * Returns whether or not the value exists in the tree
	 *
	 * @return true if the value exists, false otherwise
	 */
	public boolean contains(int value) {

		for (int a : this.toBreadthFirstOrder()) {
			if (a == value) {
				return true;
			}
		}

		return false;

	}

	/**
	 * Returns an preorder-traversed array
	 *
	 * @return an array of Integers, or empty if the tree is empty.
	 */
	public Integer[] toPreOrder() {
		if (this.isEmpty()) {
			return new Integer[0];
		}

		return this.toArray(this.doPreOrdered(new ArrayList<BinaryTreeNode>(),
				root));

	}

	/**
	 * Helper method to produce PreOrdered List
	 */
	private ArrayList<BinaryTreeNode> doPreOrdered(
			ArrayList<BinaryTreeNode> arrayList, BinaryTreeNode root2) {

		if (root2 == null) {
			return null;
		}

		arrayList.add(root2);
		doPreOrdered(arrayList, root2.getLeft());
		doPreOrdered(arrayList, root2.getRight());

		return arrayList;
	}

	/**
	 * Helper method to produce PostOrdered List
	 */
	private ArrayList<BinaryTreeNode> doPostOrdered(
			ArrayList<BinaryTreeNode> arrayList, BinaryTreeNode root2) {

		if (root2 == null) {
			return null;
		}

		doPostOrdered(arrayList, root2.getLeft());
		doPostOrdered(arrayList, root2.getRight());
		arrayList.add(root2);

		return arrayList;
	}

	/**
	 * Helper method to produce PostOrdered List
	 * 
	 * @param arrayList
	 * @param root2
	 * @return
	 */
	private ArrayList<BinaryTreeNode> doInOrdered(
			ArrayList<BinaryTreeNode> arrayList, BinaryTreeNode root2) {

		if (root2 == null) {
			return null;
		}

		doInOrdered(arrayList, root2.getLeft());
		arrayList.add(root2);
		doInOrdered(arrayList, root2.getRight());

		return arrayList;

	}

	/**
	 * Returns an inorder-traversed array
	 *
	 * @return an array of Integers, or empty if the tree is empty.
	 */
	public Integer[] toInOrder() {
		if (this.isEmpty()) {
			return new Integer[0];
		}

		return this.toArray(this.doInOrdered(new ArrayList<BinaryTreeNode>(),
				root));

	}

	/**
	 * Returns an postorder-traversed array
	 *
	 * @return an array of Integers, or empty if the tree is empty.
	 */
	public Integer[] toPostOrder() {
		if (this.isEmpty()) {
			return new Integer[0];
		}

		return this.toArray(this.doPostOrdered(new ArrayList<BinaryTreeNode>(),
				root));
	}

	/**
	 * Returns an Breadth First-traversed array
	 *
	 * @return an array of Integers, or empty if the tree is empty.
	 */
	public Integer[] toBreadthFirstOrder() {
		if (this.isEmpty()) {
			return new Integer[0];
		} else {

			ArrayList<BinaryTreeNode> myl = new ArrayList<>();
			Queue<BinaryTreeNode> myq = new LinkedList<BinaryTreeNode>();

			myq.add(root);

			while (!myq.isEmpty()) {
				BinaryTreeNode now = myq.remove();

				if (now.hasLeft()) {
					myq.add(now.getLeft());
				}

				if (now.hasRight()) {
					myq.add(now.getRight());
				}

				myl.add(now);

			}

			return toArray(myl);
		}
	}

	/**
	 * Helper method to convert List to Integer array
	 */
	private Integer[] toArray(ArrayList<BinaryTreeNode> myl) {
		Integer[] myints = new Integer[myl.size()];

		int count = 0;
		for (BinaryTreeNode i : myl) {
			myints[count] = i.getValue();
			count++;
		}
		return myints;
	}

	/**
	 * Return if this tree is empty
	 * 
	 * @return true if this tree is empty
	 */
	private boolean isEmpty() {
		return this.root == null;
	}

}