package org.algorithm.tree;

import java.util.Random;

public class Tree {
   private Node root = new Node();
   private Integer[] treeNodes;
   static Random random = new Random();
   private int index;
   public Tree(Integer[] treeNodes){
     this.treeNodes = treeNodes;
     this.createTree(root);
     root.setValue(0);
   }
   public  Node createTree(Node node){
	   int tempIndex = random.nextInt(treeNodes.length);
	   Integer data = treeNodes[tempIndex];

	   if(index++ > 20 || data==null){
		   return null;
	   }else{
		   node.setValue(data);
		   node.setLeft(createTree(new Node()));
		   node.setRight(createTree(new Node()));
		   return node;
	   }
	   
   } 
 
   public int getTreeDepth(){
	   return this.getTreeDepth(root);
   }
   public void preErgodic(){
	  this.preErgodic(root);
   }
   private void preErgodic(Node root){
	   if(root!=null){
		   System.out.print(root.value+",");
		   preErgodic(root.left);
		   preErgodic(root.right);
	   }
   }
   public void midErgodic(){
		  this.midErgodic(root,0);
	   }
   private void midErgodic(Node root,int level){
	   if(root!=null){
		   midErgodic(root.left,++level);
		   for(int i = level;i<index;i++)
		   System.out.print(" ");
		   System.out.print(root.value+"");
		   midErgodic(root.right,++level);
//		   for(int i = level;i<index;i++)
//			   System.out.print(" ");
		   System.out.println();
	   }
   }
   public void postErgodic(){
		  this.postErgodic(root);
	   }
	private void postErgodic(Node root){
		   if(root!=null){
			   postErgodic(root.left);
			   postErgodic(root.right);
			   System.out.print(root.value+",");
		   }
	}
   private int getTreeDepth(Node root){
	   int leftHight,rightHight,maxHight;
	   if(root!=null){
	      leftHight = getTreeDepth(root.left);
	      rightHight = getTreeDepth(root.right);
	      maxHight = leftHight > rightHight?leftHight:rightHight;
	      return maxHight+1;
	   }else{
		   return 0;
	   }
   }
   public static void main(String[] args){
	   Integer[] treeNodes = {1,2,null,3,4,null,5,9,null};
	   Tree tree = new Tree(treeNodes);
	   System.out.println(tree.getTreeDepth());
	   tree.midErgodic();
	   
   }
   public class Node {

		private Integer value;
		private Node left;
		private Node right;
		
		public Node(){
			
		}
		public Node(Integer value){
			this.setValue(value);
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
		public Integer getValue() {
			return value;
		}
		public void setValue(Integer value) {
			this.value = value;
		}
		
	}
}
