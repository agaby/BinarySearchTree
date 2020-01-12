import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchTree {
	private class Node {
		private int value;
		private Node mLeft;
		private Node mRight;

		public Node(int x) {
			value = x;
			mLeft = mRight = null;
		}

		public void setLeft(Node left) {
			mLeft = left;
		}

		public void setRight(Node right) {
			mRight = right;
		}
	}

	private Node root;
	private int count;
	private int[] array =new int[32];
	//= { 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,29,30,31};
	private String line;
	// private int index = 1;

	public BinarySearchTree() {
		root = null;
		count = 1;

	}

	public int getRoot() {
		return root.value;
	}

	public void add(int x) {
		Node temp = new Node(x);
		if (root == null) {
			root = temp;
		} else {
			insertInOrder(root, temp);
		}
		count++;
	}

	private void insertInOrder(Node P, Node N) {
		if (N.value < P.value) {
			if (P.mLeft == null) {
				P.mLeft = N;
			} else {
				insertInOrder(P.mLeft, N);
			}
		} else {
			if (P.mRight == null) {
				P.mRight = N;
			} else {
				insertInOrder(P.mRight, N);
			}
		}
	}

	/*
	 * public boolean delete(int number){ Node n = find(number, root.mRight);
	 * if(n == null){ return false; } removeNode(n); count--; return true; }
	 * 
	 * public void removeNode(Node n){ if(n.mLeft == null && n.mRight == null){
	 * if(n.mParent.mLeft == n){ n.mParent.setLeft(null); }else{
	 * n.mParent.setRight(null); } }else if(n.mLeft != null && n.mRight ==
	 * null){ if(n.mParent.myLeft == n){ n.mParent.setLeft(n.mLeft);
	 * n.mLeft.setParent(n.mParent); }else{ n.mParent.setRight(n.mLeft);
	 * n.mLeft.setParent(n.mParent;) } }else if(n.mLeft == null && n.mRight !=
	 * null){ n.mParent.setRgiht(n.mRight); n.mRight.setParent(n.mParent);
	 * }else{ Node s = findMinimum(n.mRight); n.setKey(s.mKey); removeNode(s); }
	 * }
	 */

	public void display() {
		LNRtraversal(root);
		System.out.println("");
	}

	private void LNRtraversal(Node n) {
		if (n == null) {
			return;
		} else {
			LNRtraversal(n.mLeft);
			System.out.print(n.value + ",");
			LNRtraversal(n.mRight);
		}
	}

	private int storeArray(Node n, int[] array, int position) {
		if (n.mLeft != null) {
			position = storeArray(n.mLeft, array, position);
		}
		array[position++] = n.value;
		if (n.mRight != null) {
			position = storeArray(n.mRight, array, position);
		}

		return position;
	}

	public boolean contains(int number) {
		return find(number, root);
	}

	private boolean find(int number, Node n) {
		boolean found = false;

		while (n != null && !found) {

			if (number < n.value) {
				n = n.mLeft;

			} else if (number > n.value) {
				n = n.mRight;

			} else {
				found = true;
				break;
			}

			found = find(number, n);

			// System.out.println(number + " was found");
		}

		return found;
	}

	/*
	 * public int getLevel(Node root, int number, int level) { if (root == null)
	 * { return 0; } if (root.value == number) { return level; }
	 * 
	 * level = getLevel(root.mLeft, number, level + 1);
	 * 
	 * if (level != 0) { // if found in left subtree, return return level; }
	 * 
	 * level = getLevel(root.mRight, number, level + 1);
	 * 
	 * return level; }
	 */

	public int getHeight() {
		return getHeight(root);
	}

	public int getHeight(Node n) {
		if (n == null) {
			return 0;
		}

		int l = getHeight(n.mLeft), r = getHeight(n.mRight);
		return Math.max(l, r) + 1;
	}

	public int getCount() {
		return count;
	}

	public void clear() {
		root = null;
		count = 0;
		array = new int[32]; 
	}

	public void delete(int number) {
		if (root == null)
			System.out.println("Tree Empty");
		else if (contains(number) == false)
			System.out.println("Sorry " + number + " is not present");
		else {
			root = delete(root, number);
			count--;
			System.out.println(number + " deleted from the tree");
		}
	}

	private Node delete(Node root, int k) {
		Node p, p2, n;
		
		//If the root is the value to be deleted
		if (root.value == k) {

			Node left, right;
			left = root.mLeft;
			right = root.mRight;
			//If there is only one item in the tree, the root
			if (left == null && right == null) {
				return null;
			//If there is only a right side
			} else if (left == null) {
				p = right;
				return p;
			//If there is only a left side
			} else if (right == null) {
				p = left;
				return p;
			} else {
				p2 = right;
				p = right;
				while (p.mLeft != null) {
					p = p.mLeft;
				}
				p.setLeft(left);
				return p2;
			}
		}
		//If the value to be deleted is less than the root value
		if (k < root.value) {
			n = delete(root.mLeft, k);
			root.setLeft(n);
		//If the value to be deleted is greater than the root value
		} else {
			n = delete(root.mRight, k);
			root.setRight(n);
		}

		return root;
	}

	public void balance() {
		array = new int[count];
		storeArray(root, array, 0);
		System.out.println(Arrays.toString(array));
		root = this.balanceTree(array, 0, array.length - 1);
	}

	private Node balanceTree(int[] array, int start, int end) {
		if (start > end) {
			return null;
		}

		int mid = (start + end) / 2;
		Node n = new Node(array[mid]);

		n.mLeft = balanceTree(array, start, mid - 1);

		n.mRight = balanceTree(array, mid + 1, end);

		return n;
	}

	public void displayTree() {
		String[] tree=new String[32];
		
		if (count == 0 && root == null) {
			System.out.println("");
			System.out.println("                                                                       ROOT");
			System.out.println("                                                                        |");
			System.out.println(
					"                                   o------------------------------------^------------------------------------o");
			System.out.println(
					"                                   |                                                                         |");
			System.out.println(
					"             o---------------------^---------------------o                             o---------------------^---------------------o");
			System.out.println(
					"             |                                           |                             |                                           |");
			System.out.println(
					"     o-------^-------o                           o-------^-------o             o-------^-------o                           o-------^-------o");
			System.out.println(
					"     |               |                           |               |             |               |                           |               |");
			System.out.println(
					" o---^---o       o---^---o                   o---^---o       o---^---o     o---^---o       o---^---o                   o---^---o       o---^---o");
			displayStats();
		} else {
			System.out.println("");
			System.out.println("                                                                        " + array[0]);
			System.out.println("                                                                        |");
			System.out.println(
					"                                   "+array[1]+"------------------------------------^------------------------------------"+array[2]);
			System.out.println(
					"                                   |                                                                         |");
			System.out.println(
					             "             " + array[3] + "---------------------^---------------------" + array[4] + "                           " + array[5] + "---------------------^---------------------" + array[6]);
			System.out.println(
					"             |                                           |                             |                                           |");
			System.out.println(
					"     " + array[7] + "-------^-------" + array[8] + "                          "+ array[9]+ "-------^-------"+array[10]+"           " +array[11]+ "-------^-------" +array[12]+ "                         " + array[13] + "-------^-------" + array[14]);
			System.out.println(
					"     |               |                           |               |             |               |                           |               |");
			System.out.println(
					" " +array[15]+"---^---"+array[16]+"       "+array[17]+"---^---"+array[18]+"                   "+array[19]+"---^---"+array[20]+"     "+array[21]+"---^---"+array[22]+"   "+array[23]+"---^---"+array[24]+"     "+array[25]+"---^---"+array[26]+"                 "+array[27]+"---^---"+array[28]+"     "+array[29]+"---^---"+array[30]);
			displayStats();
		}
	}

	public void displayStats() {
		if (count == 0 && root == null) {
			System.out.println("Empty Tree!");
			System.out.println("Tree Height: " + getHeight());
			System.out.println("Tree Root: No root, tree is empty!");
			System.out.println("Tree Count: " + getCount());
		} else {
			display();
			
			System.out.println("Tree Height: " + getHeight());
			System.out.println("Tree Root  : " + getRoot());
			System.out.println("Tree Count : " + getCount());
		}
	}

	public void wipe(){
		for(int i=0;i<array.length; i++)
		{
			array[i]=0;
		}
	}
	public void initializeTree() {
		int [] array = { 5, 2, 6, 9, 10, 15, 12, 13, 55, 30, 22, 1, 8, 33, 3, 23, 24, 21, 4, 7, 11, 14, 16, 17, 20,
				100, 19, 25, 28, 93, 44};
		
		for (int i = 0; i < array.length; i++) {
			add(array[i]);
		}
		//displayTree();
	}
	Scanner input= new Scanner(System.in);
	 public void displaydelete(){
		 System.out.println("enter number you want to delete ");
			int del=input.nextInt();
			delete(del);
			wipe();
	 }
	
	public void storeBST() {
		int h = getHeight(root);
		array = new int[count];
		for(int i = 1; i <= h; i++) {
			storeLevel(root, i);
		}
		String[] tree = line.split(", ");
		tree[0] = tree[0].substring(4);
		for(int i = 0; i < array.length; i++) {
			if(!tree[i].equals("")) {
				array[i] = Integer.parseInt(tree[i]);
			}
		}
		System.out.println(Arrays.toString(array));
	}
	
	public void storeLevel(Node root, int level) {
		if(root == null)
			return;
		if(level == 1)
			line += root.value + ", ";
		else if(level > 1) {
			storeLevel(root.mLeft, level - 1);
			storeLevel(root.mRight, level - 1);
		}
	}
	
	public int getLevel(int num){
		return getLevel(num, root);
	}
	public int getLevel(int num, Node n){
		Node current = n;
		int height = 0;
		
		while(current != null){
			int compare = current.value;
			if(compare == num){
				return height;
			}else if(compare < num){
				current = current.mRight;
				height++;
			}else{
				current = current.mLeft;
				height++;
			}
		}
		
		return height;
		
	}
	public void displayFound(){
		System.out.println("what number you looking for? ");
		int c=input.nextInt();
		getLevel(c);
	}

	/*
	public void displayBalance(){
		int [] aTree = new int [32];
		int rootIndex = 1;
		int leftIndex, rightIndex, parentIndex, childIndex; 
		
		leftIndex = parentIndex*2;
		rightIndex=(parentIndex*2)+1;
		parentIndex=childIndex/2; 
		
		aTree[rootIndex] = array[0];
	}*/

	/*
	 * private void createArray(Node n){
	 * 
	 * if(n == null){ return; }
	 * 
	 * createArray(n.mLeft); values[index] = n.value; index++;
	 * createArray(n.mRight);
	 * 
	 * }
	 * 
	 * 
	 * public void balance(){ if(root == null){
	 * System.out.println("Empty tree, CAN'T balance"); }else{ values = new
	 * int[count]; index = 0; createArray(root); balance(0, index); values =
	 * null;
	 * 
	 * } } private void balance(int low, int high){ if(low == high){ return; }
	 * 
	 * int mid = (low+high)/2;
	 * 
	 * int insert = values[mid]; add(insert);
	 * 
	 * balance(mid+1, high); balance(low, mid); }
	 */

}
