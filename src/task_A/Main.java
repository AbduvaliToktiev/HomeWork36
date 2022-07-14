package task_A;


import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        getTimeList(new ArrayList<>());
        getTimeList(new LinkedList());

    }

    private static long getTimeList(List list) {
        Date date = new Date();
        cats1000000(list);
        Date newDate = new Date();
        long difference = newDate.getTime() - date.getTime();
        // 1    System.out.println("Результат в миллисекундах: " + difference);
        return difference;
    }

    private static void cats1000000(List list) {
        for (int i = 0; i < 1000000; i++) {
            list.add(new String(String.valueOf(i)));


        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            list.add(new String(String.valueOf(i)));
        }
        // 2   System.out.println("Время работы в миллисекундах: " + (System.currentTimeMillis()-start));
        list.get(500000);
        System.out.println("" + list.get(500000));
    }
}
// В первый раз быстрее у ArrayList
// Во второй раз время одинаково