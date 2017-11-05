public class BST
{
	class root
	{
		root left;
		root right;
		public int data;
	}
	root head;
		
	BST()
	{
		head = null;
	}
	root insert(root r,int d)
	{
		if(r == null)
		{
			root nr = new root();
			nr.left = null;
			nr.right = null;
			nr.data = d;
			return nr;
		}
		else
		{
			if(d < r.data)
			{
				r.left = insert(r.left,d);
			}
			else if(d < r.data)
			{
				r.right = insert(r.right,d);
			}
		}
		return r;
	}
	void inorder(root r)
	{
		if(r==null)
			return;
	
		inorder(r.left);
		System.out.println(r.data);
		inorder(r.right);
		
		
	}
	public static void main (String[] args) {
		BST tree = new BST();
		tree.head = tree.insert(tree.head,6);
		tree.head = tree.insert(tree.head,5);
		tree.head = tree.insert(tree.head,3);
		tree.head = tree.insert(tree.head,2);
		
		tree.head = tree.insert(tree.head,10);
		tree.head = tree.insert(tree.head,14);
		tree.inorder(tree.head);
	}
}