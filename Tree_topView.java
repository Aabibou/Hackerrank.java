/*
    Abibou Mbodji August 2019
    This is the solution of this problem.
    https://www.hackerrank.com/challenges/tree-top-view/problem
*/

import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    
    static ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
    static int maxDepth=0;
    static int minDepth=0;
    
	public static void topView(Node root1) {
        Node root=root1;
      if(root==null) return;
      depthMinMax(root, 0);
      int n=maxDepth-minDepth+1;

      for(int i=0;i<n;i++){
          list.add(new ArrayList<Integer>());
      }
      depth(root, 0);
      
      for(ArrayList<Integer> l: list)
        if(l.size()==1)
            System.out.print(l.get(0)+" ");
        else{
            System.out.print(minHeightOf(root1, l)+" ");
        }
    }
    static int minHeightOf(Node root, ArrayList<Integer> l){
        Node curNode=root;
        int min=Integer.MAX_VALUE, minValue=-1;
        for(int a:l){
            int h=heightOf(root, a);
            if(h<min){
                min=h; minValue=a;
            }
        }
        return minValue;
    }
    static int heightOf(Node root, int a){
        if(root.data==a) return 0;
        else if(a>root.data) return 1+heightOf(root.right, a);
        else return 1+heightOf(root.left, a);
    }
    static void depthMinMax(Node root, int d){
        if(root==null){
            d++;
            return;
        }
        minDepth=Math.min(minDepth, d);
        maxDepth=Math.max(maxDepth, d);
        depthMinMax(root.left, d-1);
        depthMinMax(root.right, d+1);
    }
    static void depth(Node root, int d){
        if(root==null){
            d++;
            return;
        }
        list.get(d-minDepth).add(root.data);
        depth(root.left, d-1);
        depth(root.right, d+1);
    }

    public static void levelOrder(Node root) {
      Queue<Node> queue=new LinkedList<Node>();
      queue.add(root);
      while(!queue.isEmpty()){
          //remove head
          Node current=queue.remove();
          if(current.left!=null){
            queue.add(current.left);
            
          }
        if(current.right!=null)
          queue.add(current.right);
         System.out.print(current.data + " ");

      }
      
    }

	public static Node insert(Node root, int data) {
