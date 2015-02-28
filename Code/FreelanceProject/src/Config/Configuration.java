package Config;

import java.util.HashMap;
import java.util.Set;

/**
 * Клас конфігурації. Використовується для роботи з
 * обєктами конфігурації у програмі
 * @Author Гутов Владислав
 */
public class Configuration{
    private HashMap<String, String> properties;

    /**
     * Створює пусту конфігурацію
     */
    public Configuration(){
        properties = new HashMap<String, String>();
    }

    /**
     * Повертає усі ключі, що містяться у даній конфігурації
     * @return множину ключів
     */
    public Set<String> keySet(){
        return properties.keySet();
    }

    /**
     * Повертає значення бажаного параметру
     * @param key - ключ, який треба дізнатись
     * @return значення ключа
     */
    public String get(String key){
        return properties.get(key);
    }

    /**
     * Додає параметр конфігурації
     * @param key - ключ
     * @param value - значення
     */
    public void put(String key, String value){
        properties.put(key, value);
    }
}
