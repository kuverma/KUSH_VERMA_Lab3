package com.GL;

import java.util.HashSet;
import java.util.Set;

public class Question2 {

	static class Node {
		int nodeData;
		Node leftNode, rightnode;

		Node(int key) {
			nodeData = key;
			leftNode = rightnode = null;
		}
	};

	private Node insertArr(int[] arr) {
		// inserting all element of an arr in tree

		Node result = null;
		for (int i = 0; i < arr.length; i++) {
			result = insertNode(result, arr[i]);
		}
		return result;
	}

	private Node insertNode(Node node, int value) {
		// inserting value in tree.

		if (node == null)
			return new Node(value);
		if (value < node.nodeData)
			node.leftNode = insertNode(node.leftNode, value);
		else
			node.rightnode = insertNode(node.rightnode, value);
		return node;
	}

	private void searchForPair(Node root, int target) {

		Set<Integer> set = new HashSet<Integer>();

		boolean flag = true;

		flag = findPairInSet(root, target, set);

		if (!flag) {
			System.out.println("Pair nodes are not found");
		}

	}

	private boolean findPairInSet(Node root, int target, Set<Integer> set) {

		if (root == null)
			return false;

		// check in left subtree
		if (findPairInSet(root.leftNode, target, set))
			return true;

		// check at root node
		if (set.contains(target - root.nodeData)) {
			System.out.println("Pair is (" + (target - root.nodeData) + "," + root.nodeData + ")");
			return true;
		} else
			set.add(root.nodeData);

		// check in right subtree
		if (findPairInSet(root.rightnode, target, set))
			return true;

		return false;
	}

	public static void main(String[] args) {

		Question2 FPairinBST = new Question2();

		Node root = null;

		int[] arr = { 40, 20, 60, 10, 30, 50, 70 };

		root = FPairinBST.insertArr(arr);

		int sum = 130;

		FPairinBST.searchForPair(root, sum);
	}
}
