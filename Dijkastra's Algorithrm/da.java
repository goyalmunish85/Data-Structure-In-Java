import java.util.*;
class Node
{
  int d;
  int weight;
  Node(int ds , int w)
  {
    d = ds;
    weight = w;
  }
}
public class da
{
  void addEdge(LinkedList<Node>[] a,int s,int d,int w)
  {
    a[s].add(new Node(d,w));
  }
  int finmin(int [] dist,boolean[] Visited)
  {
    int min = Integer.MAX_VALUE;
    int index =-1;
    for(int i=0;i<dist.length;i++){
      if(Visited[i]==false && min > dist[i])
      {
        min = dist[i];
        index =i;
      }
    }
    return index;
  }
  void dijkastra(LinkedList<Node>[] a,int s,int[] dist, boolean[] Visited)
  {
    Visited[s] = true;

    //System.out.println(a[s].g.weight);
    for(int i=0;i<a[s].size();i++)
    {
      if(Visited[a[s].get(i).d]==false&&dist[a[s].get(i).d]>(dist[s]+a[s].get(i).weight))
      {
        dist[a[s].get(i).d] = dist[s]+a[s].get(i).weight;
      }
    }
      int source =finmin(dist,Visited);
      if(source ==-1)
      return;
      else
      {
        //visited[source] = true;
      dijkastra(a,source,dist,Visited);
    }

  }
  public static void main(String[] args) {
    da obj = new da();
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    LinkedList<Node>[] arr = new LinkedList[n];
    for(int i=0; i<n ;i++)
    {
      arr[i] = new LinkedList<Node>();
    }
    boolean[] Visited = new boolean[n];
    int[] dist = new int[n];
    for(int i=0;i<n;i++)
    {
      Visited[i] = false;
      dist[i] = Integer.MAX_VALUE;
    }
    obj.addEdge(arr,0,1,4);
    obj.addEdge(arr,0,7,8);

    obj.addEdge(arr,1,0,4);
    obj.addEdge(arr,1,2,5);
    obj.addEdge(arr,1,7,11);

    obj.addEdge(arr,2,1,5);
    obj.addEdge(arr,2,3,7);
    obj.addEdge(arr,2,8,2);
    obj.addEdge(arr,2,5,4);

    obj.addEdge(arr,3,2,7);
    obj.addEdge(arr,3,4,9);
    obj.addEdge(arr,3,5,14);

    obj.addEdge(arr,4,3,9);
    obj.addEdge(arr,4,5,10);

    obj.addEdge(arr,5,4,10);
    obj.addEdge(arr,5,3,14);
    obj.addEdge(arr,5,2,4);
    obj.addEdge(arr,5,6,2);

    obj.addEdge(arr,6,5,2);
    obj.addEdge(arr,6,8,6);
    obj.addEdge(arr,6,7,1);

    obj.addEdge(arr,7,0,8);
    obj.addEdge(arr,7,1,11);
    obj.addEdge(arr,7,6,1);
    obj.addEdge(arr,7,8,7);

    obj.addEdge(arr,8,2,2);
    obj.addEdge(arr,8,6,6);
    obj.addEdge(arr,8,7,7);
    dist[0] = 0;
    obj.dijkastra(arr,0,dist,Visited);
    for(int i=0;i<n;i++)
    {
      System.out.println(dist[i]);
    }
  }

}
