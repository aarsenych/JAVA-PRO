package com.gmail.arsenycholexandra;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

@SaverAnnotation(path = "/Users/alexandraarsenych/IdeaProjects/JavaPro/HomeTask1/Task2/src/com/gmail/arsenycholexandra/String")
public class Savers {

    static String s = "Today is the greatest day!";

    public Savers() {
    }

    public static String getS() {

        return s;
    }

    @Save
    public static void saveToPath(String path) throws FileNotFoundException {

        File file = new File(path);
        PrintWriter pw = new PrintWriter(file);
        pw.println(getS());
        pw.flush();
        pw.close();
    }
}
