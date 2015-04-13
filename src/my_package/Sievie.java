package my_package;

import static java.util.Collections.list;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author lesnyman
 */
public class Sievie {

    private LinkedList<Integer> arr = new LinkedList<Integer>();

    public Sievie(int len) {
        for (int i = 2; i <= len; i++) {
            arr.add(i);
        }
    }

    public void printSieve() {
        for (Integer x : this.arr) {
            System.out.print(x + " ");
        }
        System.out.println("\n");
    }

    public void findPrimals() {
        LinkedList<Integer> primal = new LinkedList<Integer>();
        while (!this.arr.isEmpty()) {
            //System.out.println(primal.size());
            int len = this.arr.size();
            int tmp;
            int number;

            tmp = this.arr.getFirst();
            primal.add(this.arr.pollFirst());

            for (Iterator<Integer> iterator = this.arr.iterator(); iterator.hasNext();) {
                number = iterator.next();
                if ((number % tmp) == 0) {
                    iterator.remove();
                }
            }

        }
        this.arr=primal;
    }

    public static void main(String[] args) {
        Sievie sieveObj = new Sievie(1_000_000);
        //System.out.println("Starting array:");
        //System.out.println(sieveObj.arr.size());
        //sieveObj.printSieve();
        sieveObj.findPrimals();
        System.out.println("End array:");
        //sieveObj.printSieve();
        System.out.println(sieveObj.arr.size());
        
    }
}
