package Config.readers;

import Config.Configuration;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

/**
 *  Зчитує об'єкти конфігурації з json-файлу.
 *  @author Довгаль Дмитро
 */
public class JSONReader implements Reader {

    private File configFile;

    /**
     * Створює файл з іменем вказаним у змінній file
     * за шляхом path з якого буде зчитана конфігурація
     * @param path - шлях до файлу
     * @param file - файл
     */
    public JSONReader(String path, String file){
        if(!file.endsWith(".json")){
            System.err.println("Error in JSONReader constructor");
            System.err.println(file + " is non-json file");
            System.exit(1);
        }

        configFile = new File(path, file);
        if(!configFile.exists()){
            System.err.println("Error in JSONReader constructor");
            System.err.println(file + " is not exist");
            System.exit(1);
        }

    }

    /**
     * Створює файл з іменем вказаним у змінній file
     * за стандартним шляхом "./json/" з якого буде зчитана конфігурація
     * @param file - файл
     */
    public JSONReader(String file){
        this("./json", file);
    }

    /**
     * Створює файл з іменем config.json
     * за шляхом "./json" з якого буде зчитана конфігурація
     */
    public JSONReader(){
        this("./json", "config.json");
    }

    @Override
    public Configuration load() {
        Configuration loadedConfig = new Configuration();
        JSONObject jsonObject = null;

        try {
            jsonObject = new JSONObject(new JSONTokener(new FileReader(configFile)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        assert jsonObject != null;
        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()){
            String key = keys.next();
            loadedConfig.put(key, jsonObject.getString(key));
        }

        return loadedConfig;
    }
}
