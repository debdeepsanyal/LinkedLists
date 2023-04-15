import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class interactive_linkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<String> placesToVisit = new LinkedList<>(List.of("Sydney","Adelaide","Alice Springs","Brisbane","Darwin","Melbourne","Perth"));
        int [] str  = new int[]{1374,2771,917,3972,877,3923};
        boolean t = true;
        int k,j = 1;
//        while(t){
//            ListIterator<String> iterator = placesToVisit.listIterator(j);
//            System.out.println("""
//                    Press 1 to move forward
//                    Press 2 to move back
//                    Press 0 to exit
//                    """);
//            int num = sc.nextInt();
//            switch (num){
//                case 1 -> {
//                    if(iterator.hasNext()){
//                        j++;
//                        System.out.println("The next stoppage is " + iterator.next());
//                        k = placesToVisit.indexOf(iterator.next());
//                        System.out.println("It is at a distance of " + str[k-2] + " kms from Sydney");
//
//                    }
//                    else{
//                        System.out.println("You've reached the end of the plan ");
//                    }
//
//                }
//                case 2 -> {
//                    if(iterator.hasPrevious()){
//                        System.out.println("The previous stoppage was " + iterator.previous());
//                        k = placesToVisit.indexOf(iterator.previous());
//                        System.out.println("It was a distance of " +  str[k+1] + " kms from Sydney");
//                        j--;
//                    }
//                }
//                default -> {
//                    break;
//                }
//            }
//
//        }
        while (t){
            System.out.println("""
                    Press 1 to move forward
                    Press 2 to move back
                    Press 0 to exit
                    """);
            int num = sc.nextInt();
            switch (num){
                case 1 -> {
                    System.out.println("The next stoppage is " + placesToVisit.get(j));
                    System.out.println("It is at a distance of " + str[j] + " kms from Sydney");
                    j++;
                }
                case 2 -> {
                    j-=2;
                    System.out.println("The previous stoppage was " + placesToVisit.get(j));
                    System.out.println("It is at a distance of " + str[j] + " kms from Sydney");
                    j++;
                }
            }
        }
    }
}
