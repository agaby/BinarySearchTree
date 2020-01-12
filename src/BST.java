//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Scanner;
// 
//
//public class BST {
//	
//	public class Node{
//		private int value;
//		private Node left;
//		private Node right;
//		
//		public Node(int x){
//			value=x;
//			left=right=null;
//		}
//		
//		public void setRight(Node newRight)
//		{
//			right=newRight;
//		}
//		public void setLeft(Node newLeft)
//		{
//			left=newLeft;
//		}
//		
//	}
//	Scanner input= new Scanner(System.in);
//	public Node root;
//	private String line;
//	private int counter=1;
//	private int[] list= new int[31];
//	
//		public BST(){
//			root=null;
//		}
//		public int getroot(){
//		
//			return root.value;
//			
//		}
//		public void add(int x)
//		{
//			Node temp= new Node(x);
//			if(root==null)
//				root=temp;
//			else 
//				InsertInOrder(root, temp);
//			counter++;
//		}
//		public void InsertInOrder(Node p, Node n)
//		{
//			if(n.value<p.value)
//				if(p.left==null)
//					p.left=n;
//				else
//					InsertInOrder(p.left,n);
//				
//			else
//				if(p.right==null)
//					p.right=n;
//				else
//				InsertInOrder(p.right,n);
//		}
//		
//		private void lnrTraversal(Node n)
//		{
//			int count=1;
//			if(n==null)
//				return;
//			else
//				lnrTraversal(n.left);
//				System.out.print( ","+n.value);
//				lnrTraversal(n.right);
////				System.out.print(","+n.value);
//				
//		}
//		public void display()
//		{
//			lnrTraversal(root);
//			
//			
//		}
//		public void tree()
//		{
//				if (counter == 0 && root == null) {
//					System.out.println("");
//					System.out.println("                                                                       ROOT");
//					System.out.println("                                                                        |");
//					System.out.println(
//							"                                   o------------------------------------^------------------------------------o");
//					System.out.println(
//							"                                   |                                                                         |");
//					System.out.println(
//							"             o---------------------^---------------------o                             o---------------------^---------------------o");
//					System.out.println(
//							"             |                                           |                             |                                           |");
//					System.out.println(
//							"     o-------^-------o                           o-------^-------o             o-------^-------o                           o-------^-------o");
//					System.out.println(
//							"     |               |                           |               |             |               |                           |               |");
//					System.out.println(
//							" o---^---o       o---^---o                   o---^---o       o---^---o     o---^---o       o---^---o                   o---^---o       o---^---o");
//					stats();
//				} else {
//					System.out.println("");
//					System.out.println("                                                                        " + list[0]);
//					System.out.println("                                                                        |");
//					System.out.println(
//							"                                   "+list[1]+"------------------------------------^------------------------------------"+list[2]);
//					System.out.println(
//							"                                   |                                                                         |");
//					System.out.println(
//							             "             " + list[3] + "---------------------^---------------------" + list[4] + "                           " + list[5] + "---------------------^---------------------" + list[6]);
//					System.out.println(
//							"             |                                           |                             |                                           |");
//					System.out.println(
//							"     " + list[7] + "-------^-------" + list[8] + "                          "+ list[9]+ "-------^-------"+list[10]+"           " +list[11]+ "-------^-------" +list[12]+ "                         " + list[13] + "-------^-------" + list[14]);
//					System.out.println(
//							"     |               |                           |               |             |               |                           |               |");
//					System.out.println(
//							" " +list[15]+"---^---"+list[16]+"       "+list[17]+"---^---"+list[18]+"                   "+list[19]+"---^---"+list[20]+"     "+list[21]+"---^---"+list[22]+"   "+list[23]+"---^---"+list[24]+"     "+list[25]+"---^---"+list[26]+"                 "+list[27]+"---^---"+list[28]+"     "+list[29]+"---^---"+list[30]);
//					stats();
//				}
//		}
//		
//		
//		public void count()
//		{
//			System.out.println("count= "+counter);
//		}
//		public void clear()
//		{
//			root=null;
//			counter=0;
//			list=new int[31];
//			
//		}
//		 public void delete(int k)
//	     {
//	         if (root==null)
//	             System.out.println("Tree is Empty");
//	         else if (search(k) == false)
//	             System.out.println("Sorry "+ k +" is not present");
//	         else
//	         {
//	             root = delete(root, k);
//	             System.out.println(k+ " deleted from the tree");
//	         }
//	         counter--;
//	     }
//		 private Node delete(Node root, int k)
//	     {
//	         Node p, p2, n;
//	         if (root.value == k)
//	         {
//	             Node lt, rt;
//	             lt = root.left;
//	             rt = root.right;
//	             if (lt == null && rt == null)
//	                 return null;
//	             else if (lt == null)
//	             {
//	                 p = rt;
//	                 return p;
//	             }
//	             else if (rt == null)
//	             {
//	                 p = lt;
//	                 return p;
//	             }
//	             else
//	             {
//	                 p2 = rt;
//	                 p = rt;
//	                 while (p.left!= null)
//	                     p = p.left;
//	                 p.setLeft(lt);
//	                 return p2;
//	             }
//	         }
//	         if (k < root.value)
//	         {
//	             n = delete(root.left, k);
//	             root.setLeft(n);
//	         }
//	         else
//	         {
//	             n = delete(root.right, k);
//	             root.setRight(n);             
//	         }
//	         return root;
//	     }
//		 public boolean search(int x)
//			{
//				
//				return search(root,x);
//				
//			}
//		 private boolean search(Node n, int x)
//			{
//				boolean found=false;
//				int level=1;
//				while(n!=null && !found)
//				{
//					int nval=n.value;
//					if(x<nval)
//					{
//						n=n.left;
//						level++;
//					}
//					else if(x>nval)
//					{
//						n=n.right;
//						level++;
//					}
//					else
//					{
//						found=true;
//						level++;
//						break;
//					}
//					found=search(n,x);
//					//System.out.println("found " +x+" in level "+level);
//				}
//				
//				
//				return found;
//			}
//		 
//		 public int finde(int x)
//			{
//				
//				return finde(root,x);
//				
//			}
//			public int finde(Node n, int x)
//			{
//				Node curr=n;
//				
//				int height=0;
//				
//				while(curr!=null)
//				{
//					int nval=curr.value;
//					if(nval==x)
//					{
//						return height;
//						
//						
//					}
//					else if(nval<x)
//					{
//						curr=curr.right;
//						height++;
//					}
//					else 
//					{
//						curr=curr.left;
//						height++;
//						
//					}			
//				}
//				return height;
//			
//			}
//			public void storbst(){
//				int h=getheight(root);
//				list=new int[counter];
//				for(int i=1; i<=h; i++)
//				{
//					storeLevel(root,i);
//				}
//				String[] tree=line.split(", ");
//				tree[0]=tree[0].substring(4);
//				for(int i=0;i<list.length; i++){
//					if(!tree[i].equals("")){
//					list[i]=Integer.parseInt(tree[i]);
//				}
//			  }
//				System.out.println(Arrays.toString(list));
//			}
//			public void storeLevel(Node root, int level){
//				if(root==null)
//					return;
//				if(level==1)
//					line+=root.value+", ";
//				else if(level>1){
//					storeLevel(root.left, level-1);
//					storeLevel(root.right, level-1);
//				}
//			}
//			
//		 public int height()
//		 {
//			 if(root==null)
//				 return 0;		 
//			 return getheight(root)+1;
//		 }
//		 public int getheight(Node n){
//			 if(n==null)
//			   return-1;
//				 int left=getheight(n.left);
//				 int right=getheight(n.right);
//				 int height= Math.max(left, right)+1;
//			    return height;
//			 
//		 }
//		 public void initializeTree() {
//			 int[] list ={ 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,29,30,31};
//			 for(int i=0;i<list.length;i++){
//				 add(list[i]);
//			 }
//			//stats();
//		 }
//		 public void delete(){
//			 System.out.println("enter number you want to delete ");
//				int del=input.nextInt();
//				delete(del);
//				
//		 }
//		 
//		 public void stats(){
//			 if(root==null&& counter==0)
//			 {
//				 tree();
//				 System.out.println("tree is empty");
//				 count();
//				 System.out.println("Height= "+height());
//				 System.out.println("no root, tree is empty");
//				 
//			 }
//			 else{
//				 tree();
//				 display();
//				 System.out.println();
//				 count();
//				 System.out.println("Height= "+height());
//				 System.out.println("the root is "+getroot());
//			 }
//		 }
//		 public void balance() {
//				list = new int[counter];
//				storeArray(root, list, 0);
//				System.out.println(Arrays.toString(list));
//				root = this.balanceTree(list, 0, list.length - 1);
//			}
//
//		 private int storeArray(Node n, int[] array, int position) {
//				if (n.left != null) {
//					position = storeArray(n.left, array, position);
//				}
//				array[position++] = n.value;
//				if (n.right != null) {
//					position = storeArray(n.right, array, position);
//				}
//
//				return position;
//			}
//			private Node balanceTree(int[] array, int start, int end) {
//				if (start > end) {
//					return null;
//				}
//
//				int mid = (start + end) / 2;
//				Node n = new Node(array[mid]);
//
//				n.left = balanceTree(array, start, mid - 1);
//
//				n.right = balanceTree(array, mid + 1, end);
//
//				return n;
//			}
//	}
