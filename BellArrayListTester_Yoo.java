/**
BellArrayList
@author Ethan Yoo
*/


/**Tests BellArrayList*/
class BellArrayListTester_Yoo{
   public static void main(String[] args){
      Integer i = new Integer(5);
      Double d = new Double(3.15);
      String s = new String("hello");
      Boolean bool = new Boolean(true);
      
      BellArrayList b = new BellArrayList(5);
      System.out.println("Size: " + b.size());
      b.add(i);
      System.out.println("Size: " + b.size());
      System.out.println("Last item: " + b.get(b.size()-1));
      b.add(d);
      b.add(s);
      System.out.println("Last item: " + b.get(b.size()-1));
      System.out.println("Index 1 item: " + b.get(1));
      b.add(1, bool);
      System.out.println("Index 1 item: " + b.get(1));
      b.set(1, s);
      System.out.println("Index 1 item: " + b.get(1));
      System.out.println("Removed item: " + b.remove(0));
      System.out.println("Index 0 item: " + b.get(0));
      b.ensureCapacity(0);
      System.out.println("Size: " + b.size());
      b.add(i);
      b.add(i);
      b.add(i);
      b.add(i);
      b.add(i);
      b.add(i);
      b.add(i);
      b.add(i);
      b.add(i);
      b.add(i);
      System.out.println("Size: " + b.size());
      System.out.print("Items: ");
      for(int j = 0; j < b.size(); j++){
         System.out.print(b.get(j) + " ");
      }
      System.out.println();
      b.add(7, s);
      System.out.println("Size: " + b.size());
      System.out.print("Items: ");
      for(int j = 0; j < b.size(); j++){
         System.out.print(b.get(j) + " ");
      }

   }
}



/**The BellArrayList class which stores a list of objects*/
class BellArrayList{
   private Object[] list;
   
   /**Constructs an empty list with an initial capacity of ten*/
   public BellArrayList(){
      list = new Object[10];
   }
   
   /**Constructs an empty list with the specified initial capacity*/
   public BellArrayList(int initialCapacity){
      list = new Object[initialCapacity];
   }
   
   /**Returns the number of non-null objects in the list.*/
   public int size(){
      int ret = 0;
      for (Object obj: list){
         if (obj != null) ret++;
      }
      return ret;
   }
   
   /**Returns the element at the specified position in this list*/
   public Object get(int index){
      int realIndex = -1;
      for (int i = 0; i < list.length; i++){
         if (list[i] != null) realIndex++;
         if (index == realIndex) return list[i];
      }
      return list[realIndex];
   }
   
   /**Inserts the specified element at the specified position in this list*/
   public void add(int index, Object item){
      if (size() + 1 > list.length){
         Object[] newList = new Object[list.length+1];
         for (int i = 0; i < newList.length; i++){
            if (i < list.length) newList[i] = list[i];
            if (i == index) newList[i] = item;
            if (i > index) newList[i] = list[i - 1];
         }
         list = newList;
      }
      else{
         for (int i = list.length - 1; i >= 0; i--){
            if (i > index) list[i] = list[i - 1];
            if (i == index) list[i] = item;
         }
      }
   }
   
   /**Appends the specified element to the end of this list*/
   public void add(Object item){
      for (int i = 0; i < list.length; i++){
         if (list[i] == null){
            list[i] = item;
            return;
         }
      }
      add(list.length, item);
   }
   
   /**Removes the element at the specified position in this list*/
   public Object remove(int index){
      Object ret = list[index];
      list[index] = null;
      for(int i = 0; i < list.length; i++){
         if (list[i] == null){
            if (i + 1 == list.length) break;
            if (list[i + 1] == null) break;
            list[i] = list[i + 1];
            list[i + 1] = null;
         }
      }
      return ret;
   }
   
   /**Replaces the element at the specified position in this list with the specified element*/
   public Object set(int index, Object item){
      Object ret = list[index];
      for (int i = 0; i < list.length; i++){
         if (list[i] == null){
            list[i] = item;
            break;
         }
         if (i == index){
            list[i] = item;
            break;
         }
      }
      return ret;
   }
   
   /**Increases the capacity of this ArrayList instance, if necessary, to ensure that it can hold at least the number of elements specified by the minimum capacity argument*/
   public void ensureCapacity(int minCapacity){
      if (minCapacity <= size()) return;
      Object[] newList = new Object[minCapacity];
      for (int i = 0; i < list.length; i++){
         if (list[i] != null) newList[i] = list[i];
      }
      list = newList;
   }

}