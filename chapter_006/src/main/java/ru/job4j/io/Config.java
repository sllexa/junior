package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Class Config.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 21.11.2019
 */
public class Config {
    /**
     * Path config file.
     */
    private final String path;
    /**
     * store data here.
     */
    private final Map<String, String> values = new HashMap<>();

    /**
     * Constructor.
     * @param path - path
     */
    public Config(final String path) {
        this.path = path;
    }

    /**
     * load .properties file.
     */
    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines()
                    .filter(s -> !s.isEmpty() || !s.startsWith("##"))
                    .filter(s -> s.contains("="))
                    .forEach(s -> this.values.put(s.substring(0, s.indexOf("=")), s.substring(s.indexOf("=") + 1))
                    );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Return property value.
     * @param key key
     * @return value
     */
    public String value(String key) {
        return this.values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    /**
     * Method main.
     * @param args -
     */
    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
    }
}
