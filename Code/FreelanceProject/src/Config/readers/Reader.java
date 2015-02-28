package Config.readers;

import Config.Configuration;

/**
 * Інтерфейс повинні реалізовувати всі класи, які будуть
 * реалізовувати зчитування конфігурації з файла.
 * @author Гутов Владислав
 *
 */
public interface Reader {
    /**
     * Метод виконує зчитування конфігурації
     * @return повертає об'ект типу {@link Config.Configuration}
     */
    public Configuration load();
}