package programlogic;

import io.ChooseReader;
import oomgenerators.HeapOutOfMemory;
import oomgenerators.MetaSpaceOutOfMemory;


/**
 * Класс, с логикой программы.
 *
 */

public class EatMemoryProgram {

    /**
     * Метод считывает тип памяти, в которой необходимо вызвать утечку и запускает алгортимы загрузки памяти
     */
    public void start() {

        String option = ChooseReader.readLine();

        if (option.equals("1")) {

            try {
                HeapOutOfMemory.eatMemory();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if (option.equals("2")) {

            MetaSpaceOutOfMemory.eatMemory();

        } else {
            System.out.println("Такого варианта нет, программа завершается");
        }

    }

}
