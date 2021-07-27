package Ex4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer; 

public class Ex4 {

	public static void main(String[] args){
		BinaryTree tree = new BinaryTree();
		BTNode root  = new BTNode("40");
		tree.setRoot(root);
		BTNode t1 = new BTNode("25");
		BTNode t2 = new BTNode("78");
		BTNode t3 = new BTNode("10");
		BTNode t4 = new BTNode("32");
		BTNode t5 = new BTNode("50");
		BTNode t6 = new BTNode("93");
		BTNode t7 = new BTNode("3");
		BTNode t8 = new BTNode("17");
		BTNode t9 = new BTNode("30");
		BTNode t10 = new BTNode("38");
		root.setLeft(t1);
		root.setRight(t2);
		t1.setLeft(t3);
		t1.setRight(t4);
		t2.setLeft(t5);
		t2.setRight(t6);
		t3.setLeft(t7);
		t3.setRight(t8);
		t4.setLeft(t9);
		t4.setRight(t10);
		LinkedList list = new LinkedList();
		Node n = new Node("25");
		list.setHead(n);
		list.AddLast("32");
		list.AddLast("38");
		System.out.println(contains(list, tree));

		System.out.println();
		
		String path = "C:\\Users\\maxim\\Desktop\\авадот\\ex4\\smoorf.txt"; 
		BinaryTree tree1 = getFamilyTree(path);
		print("", tree1.getRoot(), false);
		
		System.out.println();

		LinkedList list2 = new LinkedList();
		Node n1 = new Node("-2");
		list2.setHead(n1);
		list2.AddLast("3");
		list2.AddLast("100");
		list2.AddLast("9");
		list2.AddLast("-30");
		list2.AddLast("11");
		LinkedList[] lArray = ZigZagSplit(list2);
		for(int i = 0; i < lArray.length; i++) {
			System.out.println(lArray[i]);
		}
	}

	public static void print(String prefix, BTNode n, boolean isLeft) {
		if (n != null) {
			print(prefix + "     ", n.getRight(), false);
			System.out.println (prefix + ("|-- ") + n.getData());
			print(prefix + "     ", n.getLeft(), true);
		}
	}


	public static boolean contains(LinkedList lst, BinaryTree bt) {
		if(lst.getHead()==null)
			return true;
		if(bt.getRoot() == null)
			return false;
		BTNode root = bt.getRoot();
		Node p = lst.getHead();
		if(ifInTree(root, p, lst))
			return true;
		else return false;
	}


	public static boolean ifInTree(BTNode t1, Node p, LinkedList lst) {
		if(t1==null)
			return false;
		if(t1.getData().equals(p.getData()) && p.getNext() == null)
			return true;
		if(t1.getData().equals(p.getData()))
			return ifInTree(t1.getRight(), p.getNext(), lst);
		else {
			if(t1.getData().equals(lst.getHead().getData())) {
				if(t1.getRight() == null && t1.getLeft() != null)
					return ifInTree(t1.getLeft(), lst.getHead().getNext(), lst);
				if(t1.getRight() != null && t1.getLeft() == null)
					return ifInTree(t1.getRight(), lst.getHead().getNext(), lst);
				return ifInTree(t1.getRight(), lst.getHead().getNext(), lst) && 
						ifInTree(t1.getLeft(), lst.getHead().getNext(), lst);
			}
			else
				return ifInTree(t1.getRight(), lst.getHead(), lst) || 
						ifInTree(t1.getLeft(), lst.getHead(), lst);
		}
	}

	public static BinaryTree getFamilyTree(String path) {
		BinaryTree tree = new BinaryTree();
		LinkedList list = new LinkedList();
		String s = "";
		File file = new File(path); 
		Scanner sc;
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				s = sc.nextLine();
				StringTokenizer st = new StringTokenizer(s, ",");
				while (st.hasMoreTokens()) {
					list.AddLast(st.nextToken());

				}
			}
			/*System.out.println(list.toString());
			System.out.println();*/
			Node p = list.getHead();
			String[] smoorfNames  = new String[list.getSize()];
			for(int i = 0; i < smoorfNames.length; i++) {
				smoorfNames[i] = p.getData();
				p = p.getNext();
			}
			/*System.out.println(Arrays.toString(smoorfNames));
			System.out.println();*/
			tree.setRoot(insertLevelOrder(smoorfNames, tree.getRoot(), 0));
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		return tree;
	}

	public static BTNode insertLevelOrder(String[] arr, BTNode root, 
			int i) 
	{ 
		if (i < arr.length) { 
			BTNode temp = new BTNode(arr[i]); 
			root = temp; 
			root.setLeft(insertLevelOrder(arr, root.getLeft(), 
					2 * i + 1)); 
			root.setRight(insertLevelOrder(arr, root.getRight(), 
					2 * i + 2)); 
		} 
		return root; 
	} 

	public static LinkedList[] ZigZagSplit(LinkedList lst) {
		Node p = lst.getHead();
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		LinkedList[] lArray = new LinkedList[2];
		int c = 0;
		while(p != null){
			if(c%2 == 0)
				list1.AddLast(p.getData());
			else
				list2.AddLast(p.getData());
			c++;
			p = p.getNext();
		}
		lArray[0] = list1;
		lArray[1] = list2;
		return lArray;
	}

}
