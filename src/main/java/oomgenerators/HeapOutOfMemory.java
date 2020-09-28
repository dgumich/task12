package oomgenerators;
import java.util.ArrayList;


/**
 * Класс-нагружатель памяти типа Heapspace
 */

public class HeapOutOfMemory {


    /**
     * Метод два раза загружает память. В первый раз - ссылки на массивы не сохраняются, что позволяет GB
     * периодически их удалять.
     * Во второй раз, ссылка на массив помещается в ArrayList, что сохраняет объекты в Heap
     * и не позволяет GC удалить их.
     */

    public static void eatMemory() throws InterruptedException {

        System.out.println("Вы выбрали HeapSpace");
        System.out.println("В цикле создаем большой массив, ссылка на который не сохраняется. Это позволяет GB чистить Heap");
        System.out.println();

        //запуск без сохранения
        Thread.sleep(3000);
        createArray(false);

        System.out.println("Теперь содаем большой массив и ссылку на него сохраняем в ArrayList. Это не позволит GB чистить Heap");
        System.out.println();

        //запуск с сохранением
        Thread.sleep(3000);
        createArray(true);

    }

    /**
     * Метод создает большие массивы. В зависимости от
     * @param saved - boolean параметра сохраняет или нет ссылку на массив в ArrayList.
     * @throws InterruptedException
     */

    private static void createArray(boolean saved) throws InterruptedException {


        ArrayList<double[]> arrayList = new ArrayList<>();

        for (int i = 0; i < 30; i++) {

            //создаем массив
            double[] array = new double[Integer.MAX_VALUE / 100];

            //при необходимости сохраняем ссылку на массив в ArrayList
            if (saved) {
                arrayList.add(array);
                arrayList.add(null);
            }

            //выводим количество использованной памяти
            System.out.println("Было создано массивов: " + (i+1));
            System.out.println("Свободной памяти: " + Runtime.getRuntime().freeMemory());
            System.out.println("Использовано памяти: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
            System.out.println();
            Thread.sleep(1000);
        }

    }

}
