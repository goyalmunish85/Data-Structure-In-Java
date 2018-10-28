//We have to find the best and the second best player within the given players
import java.util.*;

public class Wimbledon{
    
    private Random r = new Random();
    private List <Integer> players = new ArrayList();
    private LinkedList<Integer>[] adj;
    
    public Wimbledon(int n)
    {
        for(int i = 0; i < n; i++)
        {
            players.add(i+1);
        }
        
        this.adj = new LinkedList[n+1];
        for(int i = 0; i <= n; i++)
        {
            this.adj[i] = new LinkedList<>();
        }
    }
    
    
    public int getBest()
    {
        while(players.size()>1)
        {
            List<Integer> temp = new ArrayList();
            for(int i = 0; i < players.size(); i=i+2)
            {
                temp.add(players.get(getWinner(i,i+1)));
                
            }
            System.out.println("This round winners are: " + temp.toString());
            players = temp;
        }
        return players.get(0);
    }
    
    
    private int getWinner(int i, int j)
    {
        if(j>=players.size())
        {
            System.out.println("Byeeee");
            return i;
        }
        System.out.println(players.get(i)+" is playing with "+players.get(j));
        boolean b = r.nextBoolean();
        if(b)
        {
            adj[i].add(j);
            return i;
        }
        adj[j].add(i);
        return j;
    }
    
    public LinkedList getList(int best){
        return adj[best];
    }
    
    
    public static void main(String args[])
    {
        Wimbledon wim = new Wimbledon(16);
        int best = wim.getBest();
        System.out.println("best player is " + best);
        System.out.println("best player is " + wim.getList(best));
    }
}
