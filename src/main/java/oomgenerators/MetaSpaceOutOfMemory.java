package oomgenerators;
import helpers.MyClassLoader;
import java.util.ArrayList;

/**
 * Класс-нагружатель памяти типа MetaSpace
 */

public class MetaSpaceOutOfMemory {


    /**
     * Метод загружет память MetaSpace путем бесконечной загрузки класса
     */
    public static void eatMemory() {


        Integer i1 = new Integer("1");
        Integer i2 = Integer.valueOf("3");
        System.out.println("Вы выбрали MetaSpace");
        System.out.println();

        ArrayList<MyClassLoader> loaders = new ArrayList<>();


        int count = 1;
        //запускаем бесконечный цикл
        while (true) {

            if (count % 1000 == 0) {
                System.out.println("Было загруженно " + count + " классов");
            }

            //создаем экземпляр своего загрузчика класса
            MyClassLoader myClassLoader = new MyClassLoader();

            //загружаем класс
            myClassLoader.findClass("TrashClass.class");

            //помещаем объект-загрузчик класса в ArrayList, что бы не произошло
            // его удаление (а так же загруженного класса) GC

            loaders.add(myClassLoader);
            count++;

        }

    }

}
