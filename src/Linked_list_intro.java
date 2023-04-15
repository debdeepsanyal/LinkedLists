import java.util.LinkedList;
import java.util.ListIterator;

public class Linked_list_intro {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<>(); //this method of declaring a Linked List is similar to that of an ArrayList
        //var placesToVisit = new LinkedList<String>(); //this is also a method to declare a Linked List, however in this method, you need to mention the datatype
                                        //in the new LinkedList<>() in the diamond brackets
           //It is worth noting that lists dont allow primitve types. i.e. we cannot declare a Linked list like -> LinkedList<int> = new LinkedList<>();
             //lists allow Objects only, hence if we want to use an int in a Linked list we need to wrap it up in a wrapper class. (Integer for int) LinkedList<Integer> integer = new LinkedList<>() is supported
        placesToVisit.add("Sydney");
        placesToVisit.add(0,"Canberra");
        System.out.println(placesToVisit);
        addNames(placesToVisit);
        System.out.println(placesToVisit);
        removeElements(placesToVisit);
        System.out.println(placesToVisit);
        getElements(placesToVisit);
        //accessElements(placesToVisit);
        System.out.println(placesToVisit);
        accessElements2(placesToVisit);
    }
    private static void addNames(LinkedList<String> list){
        list.addFirst("Brisbane");//this method and the next are exclusive to linked lists
        list.addLast("Toowoomba");//they are not available in Array lists

        //Linked lists can also be used as Queues

        list.offer("Melbourne"); //adds element to the end of the list
        list.offerFirst("Darwin");//works the same as addFirst
        list.addLast("Hobart");//works the same as offer/addLast

        //Linked lists can also be used as Stacks

        list.push("Alice Springs");//works the same as addFirst/offerFirst
    }
    private static void removeElements(LinkedList<String> list){
        list.remove(0); //its the same as list.remove() and list.removeFirst()
        list.remove("Toowoomba");
        String s1 = list.removeLast();
        System.out.println(list);
        System.out.println(s1 + " was removed");
        //Queue functions
        String s2 = list.poll();//removes the first element
        System.out.println(list);
        System.out.println(s2 + " was removed");
        //pollFirst() and pollLast() functions also exist
        //.pop() removes the first element, its a method of stack
    }
    public static void getElements(LinkedList<String> list){
        System.out.println("Retrieved element -> " + list.get(3));
        System.out.println("First element -> " + list.getFirst());
        System.out.println("Last element -> " + list.getLast());
        System.out.println("Canberra is at position -> " + list.indexOf("Canberra"));
        //Queue retrieval method
        System.out.println("Element from element() -> " + list.element());//returns the first element from the list
        //Stack retrieval method
        System.out.println("Element from peek() -> "+ list.peek());//peek returns the first element from the list
    }
    private static void accessElements(LinkedList<String>list){
        System.out.println("Trip starts from -> " + list.getFirst());
        System.out.println("Trip ends at -> " + list.getLast());
        for(int i = 0; i< list.size()-1;i++){
            if(list.get(i) == "Brisbane"){  //in this example, if we are adding an element while traversing through the loop, the element gets added at the end of the list
                list.add(i+1,"Cockatoo");
            }
            System.out.println("From ->" + list.get(i) + " To ->" +list.get(i+1));
        }
    }
    public static void accessElements2(LinkedList<String>list){ // an alternative method of traversing through a list
        System.out.println("Trip starts at " + list.getFirst());
        String previousTown = list.getFirst();
        ListIterator<String> iterator = list.listIterator(1);// so here we are declaring an Iterator and imagine that the iterator has a cursor.
                                          //the index in the listIterator() method is the index in the LinkedList the next() function is going to reach.
                 //for a better understanding, just imagine that if the index in the listIterator() is set to 1, the cursor is at a position between 0 and 1. when the next() function is called, the cursor moves to the next index, i.e. 1
        //similarly when the index in the listIterator() is set to 0, the cursor is not at 0 but right behind it.
        while (iterator.hasNext()){//hasNext checks if there are more elements to be processed
            var town = iterator.next(); //the next() function shifts the cursor to the next position, i.e. at the index inputted in the listIterator method
//            if(iterator.next().equals("Sydney")){
//                iterator.add("Cockatoo");
//            }
            System.out.println("From -> " + previousTown + " To ->" + town);
            previousTown = town;
        }
        //once this while loop executes the cursor is at the very end of the linked list, and we cannot execute another while loop with the .hasNext() method
        //we can however move backwards with the .hasPrevious() method. it simply states that the position of the cursor should be static in nature
        System.out.println("Trip ends at -> " + list.getLast());
        System.out.println(list);

        //the function listIterator() has a default index of 0 which can be overloaded, as done in this code
    }

}