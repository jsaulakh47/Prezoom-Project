package app;

import java.io.BufferedReader;
// import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting GUI...");
        gui.javafx.Main.main(args);
    }

    private static Properties readProperties() 
    {
        Properties props = new Properties();
        Path myPath = Paths.get("config.properties");
       
        try {
            BufferedReader bf = Files.newBufferedReader(myPath, StandardCharsets.UTF_8);
            props.load(bf);
        } catch (IOException ex) {
            System.out.println(ex);
        }

        return props;
    }

    public static String getTitle()
    {
        return readProperties().getProperty("title");
    }
}