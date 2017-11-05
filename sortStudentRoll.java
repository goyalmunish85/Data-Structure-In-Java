import java.util.*;
class student implements Comparable<student>{
  String name = new String();
  int roll;
  int cgpa;
  student(String s, int r ,int c)
  {
    name = s;
    roll = r;
    cgpa = c;
  }
  String tostring()
  {
    return(name+" "+roll+" "+cgpa);
  }
  public int compareTo(student o)
  {
    if(roll == o.roll)
      return 0;
    else if(roll > o.roll)
      return 1;
    return -1;
  }
}
class sortStudentRoll{
 public static void main(String args[]){
  ArrayList<student> list=new ArrayList<student>();
  Scanner s = new Scanner(System.in);
  int n = s.nextInt();
  for(int i=0;i<n;i++)
  {
    String st = s.next();
    int r = s.nextInt();
    int c = s.nextInt();

    list.add(new student(st,r,c));
  }
  Collections.sort(list);
  Iterator itr=list.iterator();
  while(itr.hasNext()){
   student st = (student)itr.next();
   System.out.println(st.name +" "+ st.roll +" "+ st.cgpa);
 }
}
}
