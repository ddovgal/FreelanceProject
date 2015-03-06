package config.readers;

import config.Configuration;

/**
 * Інтерфейс повинні реалізовувати всі класи, які будуть
 * реалізовувати зчитування конфігурації з файла.
 * @author Гутов Владислав
 *
 */
public interface Reader {
    /**
     * Метод виконує зчитування конфігурації
     * @return повертає об'ект типу {@link config.Configuration}
     */
    public Configuration load();
}