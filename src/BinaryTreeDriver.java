import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
public class BinaryTreeDriver {
public static Scanner input= new Scanner(System.in);
public static BinarySearchTree tree= new BinarySearchTree();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		boolean exit=false;
		do{
			
			System.out.println("choose one of the following:"
				+ "\n A) add item B) balance the tree D)delete Item F)Find Item I)Initialize tree N) New Tree Q) Quit ");
		     char ans=input.next().charAt(0);
			switch(ans){
			case 'a': 
				System.out.println("enter a number to add");
				int x= input.nextInt();
				tree.add(x);
				tree.displayStats();
				tree.displayTree();
				System.out.println();
				break;
			case 'b':
				tree.balance();
				tree.displayTree();
				tree.displayStats();
				break;
			case 'd':
				tree.displaydelete();
				tree.displayStats();
				tree.displayTree();
				System.out.println();
				break;
			case 'f':
				System.out.println("what number do you want to find?");
				int find=input.nextInt();
				System.out.println("found "+find+" on level "+tree.getLevel(find));	
				tree.displayStats();
				System.out.println();
				
				break;
			case 'i':
				
				tree.initializeTree();
				tree.displayTree();
				tree.displayStats();
				System.out.println();
				System.out.println();
				break;
			case 'n' :
				tree.clear();
				//tree();
				tree.display();
				tree.displayTree();
				tree.displayStats();
				System.out.println();
				//System.out.println("Height= "+tree.getHeight());
				System.out.println();
				break;
			case 'q':
				System.out.println("BYE");	
				exit=true;
				System.exit(0);
				
			}
		}
			while(exit==false);
		
	}
//	public static void tree(){
//		for(int i=1;i<list.length+2;i++)
//		{
//			
//			tree.add(i);
//		}
//		//tree.display();
//		System.out.println();
//		System.out.println("                                                "+list[0]+"                                                           ");
//		System.out.println("                                          |                |                                                       ");
//		System.out.println("                        -----------------                    -----------------------------                           ");
//		System.out.println("                        |                                                                 |                                    ");
//		System.out.println("                       "+list[1]+"                                                                  "+list[2]+"                               ");
//		System.out.println("            -----                ------                                         --------                -------------                ");
//		System.out.println("            |                           |                                       |                                      |                ");
////		System.out.println("          "+i+"                       "+i+"                                 "+i+"                                         "+i+"              ");
////		System.out.println("       ---      ---             -----        -----                  -----            -----                -------          --------         ");
////		System.out.println("      |           |             |                  |                |                     |               |                       |         ");
////		System.out.println("    "+i+"       "+i+"         "+i+"              "+i+"              "+i+"                  "+i+"           "+i+"                    "+i+"        ");
////		System.out.println("  --    --     --   --       --    --           --     --        --   --              ---   ---       ---       ----          -----     ----  ");
////		System.out.println("  |      |     |      |     |        |        |          |      |       |             |        |      |             |         |              |       ");
////		System.out.println(""+i+"   "+i+" "+i+" "+i+ ""+i+"   "+i+"   "+i+"        "+i+"   "+i+"  "+i+"         "+i+"    "+i+"   "+i+"         "+i+"     "+i+"          "+i+"       ");
//		
//		
//		
//	}

}
