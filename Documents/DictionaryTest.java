
public class DictionaryTest{

   public static void main(String[] args){
      String v;
      Dictionary A = new Dictionary();
      A.insert("1","a");
      A.insert("2","b");
      A.insert("3","c");
      A.insert("4","d");
      A.insert("5","e");
      A.insert("6","f");
      A.insert("7","g");
      System.out.println(A);

      v = A.lookup("1");
      System.out.println("key=1 "+(v==null?"not found":("value="+v)));
      v = A.lookup("3");
      System.out.println("key=3 "+(v==null?"not found":("value="+v)));
      v = A.lookup("7");
      System.out.println("key=7 "+(v==null?"not found":("value="+v)));
      v = A.lookup("8");
      System.out.println("key=8 "+(v==null?"not found":("value="+v)));
      System.out.println();

	  //Testing Function 1 isEmpty
	  System.out.println(A.isEmpty()); //should print false
	  //Testing size
	  System.out.println(A.size()); //prints 7
	  A.insert("8","h");
	  A.insert("9","j");
	  System.out.println(A.size()); //prints 9
	  //testing lookup
	  v = A.lookup("9");
      System.out.println("key=9 "+(v==null?"not found":("value="+v)));
	  v = A.lookup("3");
      System.out.println("key=3 "+(v==null?"not found":("value="+v)));
	  v = A.lookup("1");
      System.out.println("key=1 "+(v==null?"not found":("value="+v)));
	  v = A.lookup("12");
      System.out.println("key=12 "+(v==null?"not found":("value="+v)));
	  //not found
	  
	  //testing more insert and duplication error
	  //A.insert("1", "b");
	  //A.insert("2","d");
	  //all create error
	  A.insert("10","Hello world");
	  A.insert ("100","thats so far");
	  System.out.println(A.size());
	  //prints out 11
	  v = A.lookup("100");
      System.out.println("key=100 "+(v==null?"not found":("value="+v)));
	  
	  //testing delete and KeyNotFoundException
	  A.delete("100");
	  System.out.println(A.size());
	  //prints out 10
	  //A.delete("101");
	  //creates Error
	  
	  //testing makeEmpty
	  A.makeEmpty();
	  System.out.println(A.size());
	  A.insert("1","Richany");
	  A.insert("2","Long");
	  A.insert("3","Chris");
	  A.insert("4","George");
	  A.insert("5","Jesse");
	  System.out.println(A.size());
	  //prints 5
	  
      v = A.lookup("1");
      System.out.println("key=1 "+(v==null?"not found":("value="+v)));
      v = A.lookup("2");
      System.out.println("key=2 "+(v==null?"not found":("value="+v)));
      v = A.lookup("3");
      System.out.println("key=3 "+(v==null?"not found":("value="+v)));
      v = A.lookup("4");
      System.out.println("key=4 "+(v==null?"not found":("value="+v)));
      System.out.println();
	  
	  A.delete("2");
	  v=A.lookup("2");
	  System.out.println((v==null?"not found":("Nobody loves me")));
	  //A.insert("2","Binh");
	  //DuplicateKeyException
	  
	  
	  
      // A.insert("2","f");  // causes DuplicateKeyException

      //A.delete("1");
      //A.delete("3");
      //A.delete("7");
      //System.out.println(A);

      // A.delete("8");  // causes KeyNotFoundException

      //System.out.println(A.isEmpty());
      //System.out.println(A.size());
      //A.makeEmpty();
      //System.out.println(A.isEmpty());
      //System.out.println(A);

   }
}