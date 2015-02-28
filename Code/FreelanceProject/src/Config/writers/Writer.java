package Config.writers;

import Config.Configuration;

/**
 * Даний інтерфейс містить метод <code>save()</code>, який можна використовувати
 * для запису конфігураційних файлів на жорсткий диск.
 * @author Гутов Владислав
 */
public interface Writer {

    /**
     *  Записує надані конфігураційні параметри
     * @param configuration - параметри, які треба записати
     */
    public void save(Configuration configuration);

}
