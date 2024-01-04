package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analysis {

    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {
            List<String> periods = new ArrayList<>();
            String line;
            String startTime = null;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String status = parts[0];
                String time = parts[1];
                if (("400".equals(status) || "500".equals(status)) && startTime == null) {
                    startTime = time;
                } else if (("200".equals(status) || "300".equals(status)) && startTime != null) {
                    periods.add(startTime + ";" + time + ";");
                    startTime = null;
                }
            }
            for (String period : periods) {
                writer.write(period);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}