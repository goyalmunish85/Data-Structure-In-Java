import java.util.*;
public class graph_adjacency_list
{
  void addEdge(ArrayList<ArrayList<Integer>> a,int s,int d)
  {
    a.get(s).add(d);
  }
  public static void main(String[] args) {
    graph_adjacency_list obj = new graph_adjacency_list();
    ArrayList<ArrayList<Integer>> arr= new ArrayList<ArrayList<Integer>>();
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    for(int i=0;i<n;i++)
    {
      arr.add(new ArrayList<Integer>(n));
    }
    System.out.println("Enter the Edges : ");
    int v1 = s.nextInt();
    int v2 = s.nextInt();
    while(v1 != -1)
    {
        obj.addEdge(arr,v1,v2);
        v1 = s.nextInt();
        v2 = s.nextInt();
    }
    System.out.println(arr);
  }
}
