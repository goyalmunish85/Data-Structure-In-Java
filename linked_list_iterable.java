import java.util.*;
public class linked_list_iterable implements Iterable<Integer>
{
	class node
	{
		public Integer data;
		node next;
	}
	node head;
	linked_list_iterable()
	{
		head=null;
	}
	void addAtBeg(int d)
	{
		node nn = new node();
		nn.data = d;
		nn.next = head;
		head = nn;
	}
	void print(node curr)
	{
		if(curr!=null)
		{
			System.out.println(curr.data);
			print(curr=curr.next);
		}
	}
	public Iterator<Integer> iterator()
	{
		return new MyIterator();
	}
	
	class MyIterator implements Iterator<Integer>
	{
		node curr = head;
		public boolean hasNext()
		{
			return(curr!=null);
		}
		public Integer next()
		{
			node temp = curr;
			curr = curr.next;
			return temp.data;
		}
		public void remove()
		{
			
		}
	}
	public static void main (String[] args) {
		linked_list_iterable list = new linked_list_iterable();
		list.addAtBeg(4);
		list.addAtBeg(5);
		
		list.addAtBeg(7);
		
		list.addAtBeg(3);
		
		list.addAtBeg(8);
		//list.print(list.head);
		Iterator<Integer> i = list.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
		System.out.println();
		for(Integer x: list)
		{
			System.out.println(x);
		}
	}
}
