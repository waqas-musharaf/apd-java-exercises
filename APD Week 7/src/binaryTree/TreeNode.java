package binaryTree;

public class TreeNode<T extends Comparable<T>> {
	T value;
	BTree<T> left, right;
	
	public TreeNode(T value) {
		this.value = value;
		System.out.println("Added node " + value() + " to the tree");
		left = new BinaryTree<T>();
		right = new BinaryTree<T>();
	}
	
	public T value() {
		return value;
	}
	
	public BTree<T> left() {
		return left;
	}
	
	public BTree<T> right() {
		return right;
	}

}
