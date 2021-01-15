package binaryTree;

public class BinaryTree<T extends Comparable<T>> implements BTree<T> {
private TreeNode<T> root;

	@Override
	public void insert(T value) {
		// If there is no root value, insert 'value' into the root
		if (root == null) {
			root = new TreeNode<T>(value);
		// Else, if there is a root, compare 'value' to the root
		// If the root is larger than 'value', insert 'value' into the left
		} else if (value.compareTo(value()) < 0) {
			System.out.println("Node " + value + " placed into the left tree");
			root.left().insert(value);
		} else {
		// Else, insert value into the right
			System.out.println("Node " + value + " placed into the right tree");
			root.right().insert(value);
		}
	}

	@Override
	public T value() {
		System.out.println("Current root is " + root.value());
		return root.value;
	}

	@Override
	public BTree<T> left() {
		return root.left;
	}

	@Override
	public BTree<T> right() {
		return root.right;
	}
}
