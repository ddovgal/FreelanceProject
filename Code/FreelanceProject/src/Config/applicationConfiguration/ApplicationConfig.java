package Config.applicationConfiguration;

import Config.Configuration;
import Config.readers.JSONReader;
import Config.readers.Reader;
import Config.writers.JSONWriter;
import Config.writers.Writer;

import java.util.HashMap;
import java.util.Set;

/**
 * Містить у собі конфігурацію програми. Дозволяє зчитувати
 * чи записувати конфігурацію у файл
 * @author Гутов Владислав
 *
 */
public class ApplicationConfig {
    private Reader configReader;
    private Writer configWriter;
    private Configuration config;

    private HashMap<String, String> defaultProperties;

    private void initDefaultProperties(){
        defaultProperties = new HashMap<String, String>();
        defaultProperties.put("password", "root");
        defaultProperties.put("userName", "root");
        defaultProperties.put("driverName", "com.mysql.jdbc.Driver");
        defaultProperties.put("url", "jdbc:mysql:");
        defaultProperties.put("databaseName", "freelance");
        defaultProperties.put("serverName", "localHost");
    }

    public Set<String> getAvailiableProperties(){
        return defaultProperties.keySet();
    }

    /**
     * Створює нову конфігурацію. А також ініціалює
     * параметрі за замовчуванням
     */
    public ApplicationConfig(){
        config = new Configuration();
        configReader = new JSONReader();
        configWriter = new JSONWriter();
        initDefaultProperties();
    }

    /**
     * Встановлює <code>Reader</code>, з якого можна
     * зчитувати конфігурацію
     * @param configReader - будь-який клас, що реалізовує інтерфейс {@link Config.readers.Reader}
     */
    public void setReader(Reader configReader){
        this.configReader = configReader;
    }

    /**
     * Завантажує параметри з вказаного <code>Reader</code>'a (за замовчуванням
     * за допомогою XmlReader'у з файлу ./xml/config.xml)
     */
    public void loadProperties(){
        config = configReader.load();
    }

    /**
     * Зберігає конфігурацію за допомогою встановленого Writer'у
     * (за замовчуванням це XmlWriter, що записує у файл ./xml/config.xml)
     */
    public void saveProperties(){
        configWriter.save(config);
    }

    /**
     * Встановлює <code>Writer</code>, який буде використовуватись для
     * запису конфігурації
     * @param configWriter - будь-який клас, що реалізовує інтерфейс {@link Config.writers.Writer}
     */
    public void setWriter(Writer configWriter){
        this.configWriter = configWriter;
    }

    /**
     * Повертає бажаний параметр конфігурації. Якщо даний параметр
     * не був знайдений у конфігурації, то метод поверне значення
     * за замовчуванням
     * @param key - бажаний параметр
     * @return значення параметру
     */
    public String getProperty(String key){
        String answer = config.get(key);
        if(answer == null)
            answer = getDefaultProperty(key);

        return answer;
    }

    /**
     * Встановлює параметр
     * @param key - параметр
     * @param value - значення
     */
    public void setProperty(String key, String value){
        config.put(key, value);
    }

    /**
     * Повертає конфігурацію
     * @return конфігурацію
     */
    public Configuration getConfiguration(){
        return config;
    }

    private String getDefaultProperty(String key){
        return defaultProperties.get(key);
    }
}
