package helpers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Класс, кастомный загрузчик класса.
 * Подгружает в райнтайме класс SomeClass
 */

public class MyClassLoader extends ClassLoader {

    //ссылка на скомпилированный класс, который будем подгружать
    String path = "src\\main\\resources\\TrashClass.class";

    @Override
    public Class<?> findClass(String name) {

        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(null, bytes, 0, bytes.length);

    }

}
