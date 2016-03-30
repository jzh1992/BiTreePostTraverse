package tree;

import java.util.Stack;

public class Tranverse {
	//后序遍历
	private static void postorderTranverse(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		TreeNode pre = null;
		while (p!=null||!stack.isEmpty()){
			if (p!=null){
				stack.push(p);
				p=p.left;
			}else{
				p = stack.peek();
				if (p.right!=null&&pre!=p.right){
					p=p.right;
				}else{
					p=pre=stack.peek();
					System.out.println(p.val);
					stack.pop();
					p=null;
				}
			}
		}
	}
	//中序遍历
	private static void inorderTranverse(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()){
			TreeNode p = stack.peek();
			while (p.left!=null){
				stack.push(p.left);
				p=p.left;
			}
			TreeNode print = stack.pop();
			System.out.println(print.val);
			if (!stack.isEmpty()){
				TreeNode printRoot = stack.pop();
				System.out.println(printRoot.val);
				if (printRoot.right!=null)
					stack.push(printRoot.right);
			}
		}
	}
	
	private static void inorderTranverse2(TreeNode root){
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode p = root;
		while (p!=null||!s.isEmpty()){
			if (p!=null){
				s.push(p);
				p = p.left;
			}else{
				p = s.pop();
				System.out.println(p.val);
				p = p.right;
			}
		}
	}
	private static void preorderTranverse(TreeNode root){
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode p = root;
		while (p!=null||!s.isEmpty()){
			if (p!=null){
				System.out.println(p.val);
				s.push(p);
				p = p.left;
			}else{
				p = s.pop();
				//System.out.println(p.val);
				p = p.right;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//构造树
		TreeNode h = new TreeNode(10);
		h.left = new TreeNode(5);
		h.right = new TreeNode(15);
		h.right.left = new TreeNode(6);
		h.right.right = new TreeNode(20);
		
		//inorderTranverse(h);
		//inorderTranverse2(h);
		//preorderTranverse(h);
		postorderTranverse(h);
	}

}
