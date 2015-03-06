package config.writers;

import config.Configuration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

/**
 *  Записує об'єкти конфігурації в json-файли.
 *  @author Довгаль Дмитро
 */
public class JSONWriter implements Writer {

    private File configFile;

    /**
     * Створює файл з іменем вказаним у змінній file
     * за шляхом path у який буде записана конфігурація
     * @param path - шлях до файлу
     * @param file - файл
     */
    public JSONWriter(String path, String file){


        //if were specified non-json file then replacing extension on json
        if(!file.endsWith(".json")){
            file = file.substring(0, file.lastIndexOf("."));
            file = file.concat("json");
        }
        createFolder(path);
        this.configFile = new File(path, file);



    }

    /**
     * Створює файл з іменем вказаним у змінній file
     * за стандарним шляхом "./json/" у який буде записана конфігурація
     * @param file - файл
     */
    public JSONWriter(String file){
        this("/json/", file);
    }

    /**
     * Створює файл з іменем config
     * за шляхом "./json" у який буде записана конфігурація
     */
    public JSONWriter(){
        this("./json/", "config.json");

    }

    //Допоміжний метод для створення тек, за вказаним шляхом, якщо таких не існує
    private void createFolder(String path){
        try {
            File parentFolder = new File(path);
            String[] folders = parentFolder.getCanonicalPath().replace("\\", "/").split("/");
            String newPath = folders[0];
            for (int i = 1; i < folders.length+1; i++) {
                File f = new File(newPath);
                if (!f.exists()) {
                    f.mkdir();
                }
                if(i < folders.length)
                    newPath += "/" + folders[i];

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void save(Configuration configuration) {
        org.json.JSONWriter jsonWriter = null;
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(configFile);
            jsonWriter = new org.json.JSONWriter(fileWriter);

            jsonWriter.object();
            Set<String> keys = configuration.keySet();
            for (String key: keys){
                jsonWriter.key(key).value(configuration.get(key));
            }
            jsonWriter.endObject();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
