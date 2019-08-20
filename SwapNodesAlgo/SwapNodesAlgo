/*
    Abibou Mbodji August 2019
    This is the solution of this problem.
    https://www.hackerrank.com/challenges/swap-nodes-algo/problem
*/

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
class Node {
            public int data;
            public Node left;
            public Node right;
            public Node(int _data){
                data=_data;
                left=null;
                right=null;
            }       
        }

public class Solution {      
    /*
     * Complete the swapNodes function below.
     */
    static void swapNodes(Node root, int[] queries) {
        int height=1;
        for(int k: queries){
            DFSinOrder(root, height, k);
            System.out.println();
        }
    }
    static void DFSinOrder(Node root, int height, int k){
        if(root==null) return;
        if(height%k==0 && (root.left!=null || root.right!=null)){
            Node tmp=root.left;
            root.left=root.right;
            root.right=tmp;
        }
        DFSinOrder(root.left, height+1, k);
        System.out.print(root.data+" ");//"(h="+height+") ");
        DFSinOrder(root.right, height+1, k);
    }

    
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args){

        int n = in.nextInt();

        Node root=new Node(1);
        Queue<Node> queue=new LinkedList<Node>();
        queue.add(root);
        Node cur;


        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            int leftData=in.nextInt();
            int rightData=in.nextInt();
            cur=queue.remove();

            if(leftData!=-1){
                cur.left=new Node(leftData);
                queue.add(cur.left);
            }
            //add the new right node in the queue.
            if(rightData!=-1) {  
                cur.right=new Node(rightData);
            //add the new right node in the queue.
                queue.add(cur.right);
            }
    
        }
        

        

        int queriesCount = in.nextInt();

        int[] queries = new int[queriesCount];

        for(int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = in.nextInt();
            queries[queriesItr] = queriesItem;
        }

        swapNodes(root, queries);   
    }
}

