import java.util.LinkedList;

record place(String name, int address){ // declaring a record because records allow us to have data in a detailed, customised format,
    // which we can add to the list later by creating an instance of the record. the variables we pass as arguments in the record
    //and the way which we choose to print it, forms the element in the list.
    @Override
    public String toString() { //overriding the toString to modify the way we choose to print the elements
        return (name + " -> (" + address + ")");
    }
}

public class interactive_list2 {
    public static void main(String[] args) {
        LinkedList <place> placesToVisit = new LinkedList<>();
        place item = new place("Adelaide",1150); // creating a new instance of the record
        addPlaces(item,placesToVisit);
        System.out.println(placesToVisit);
        addPlaces(new place("Melbourne",700),placesToVisit);
        System.out.println(placesToVisit.indexOf(item));
        System.out.println(placesToVisit);
        addPlaces(new place("Perth",1200),placesToVisit);
        System.out.println(placesToVisit);
        addPlaces(new place("alice springs",200),placesToVisit);
        System.out.println(placesToVisit);

    }
    public static void addPlaces(place item , LinkedList <place> list){ // as arguments, we take the instance, and the list. we want to add the data in the instance to the list
        if(list.contains(item)){ //checking for duplicate, however this is case sensitive
            System.out.println("Item already present in list");
            return;
        }
        for(place i : list){ //looping through the items in the list
            if(i.name().equalsIgnoreCase(item.name())){//if the name of the item being looped through matches the name of the item passed as an argument matches
                System.out.println("Item already there");
                return;
            }
        }


//        for(int i = 0; i<list.size();i++){ //traditional for loop to check duplicate
//            if(list.get(i).name().equalsIgnoreCase(item.name())){   //list.get(i) returns the value stored in list, which is of type place.
                                           //place.name() gives us the name we had passed as argument for the record. the_name.equalsIgnoreCase(item.name) checks if the name is equal to the name of the item passed in the method argument
//                System.out.println("Item present");
//                return;
//            }
//        }
        int c = 0;
        for(var i : list){ // looping through each item in the list
            if(item.address() < i.address()){ //if the address of the argument is less than the item in the list, we want it to get it added at c.
                              //now initially, c is 0. so, if the address of the argument element is smaller than the first item in the list, the item gets added in the first position.
                              //if not, c gets incremented. so if the item's address is smaller than the 3rd element, item gets added at position 3
                list.add(c,item);
                return;//once the item is added, terminate the method
            }
            c++;
        }
        list.add(item);//if the address is the largest, add it at the very last of the list
    }
}
