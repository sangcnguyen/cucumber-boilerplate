package manager;

import reader.ConfigReader;
import reader.JsonReader;

public class FileReaderManager {
    private static FileReaderManager instance;
    private static ConfigReader configReader;
    private static JsonReader jsonReader;

    private FileReaderManager() {
    }

    public static FileReaderManager getInstance() {
        if (instance == null) {
            instance = new FileReaderManager();
        }
        return instance;
    }

    public ConfigReader getConfigReader() {
        return (configReader == null) ? configReader = new ConfigReader() : configReader;
    }

    public JsonReader getJsonReader() {
        return (jsonReader == null) ? jsonReader = new JsonReader() : jsonReader;
    }
}