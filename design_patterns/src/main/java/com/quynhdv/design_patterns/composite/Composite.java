package com.quynhdv.design_patterns.composite;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Composite {
    public static void main(String[] args) {
        ExcelReader csvReader = new CSVReader();
        List<Map<String, String>> strings = csvReader.readFile(new File("src/main/resources/students.csv"));
        System.out.println(strings);
    }
}

class CSVReader implements ExcelReader {

    @Override
    public List<Map<String, String>> readFile(File file) {
        List<Map<String, String>> res = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int lineCount = 0;
            List<String> headers = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                lineCount++;
                String[] lineSplit = line.split(",");
                if (lineCount == 1) {
                    headers.addAll(List.of(lineSplit));
                    continue;
                }
                assert (headers.size() == lineSplit.length);
                Map<String, String> row = new HashMap<>();
                for (int i = 0; i < headers.size(); i++) {
                    row.put(headers.get(i), lineSplit[i]);
                }
                res.add(row);
            }
        } catch (Exception e) {
            return List.of();
        }
        return res;
    }
}

class XLSXReader implements ExcelReader {
    @Override
    public List<Map<String, String>> readFile(File file) {
        return List.of();
    }
}

interface ExcelReader {
    List<Map<String, String>> readFile(File file);
}
