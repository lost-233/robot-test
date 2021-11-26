package com.zhaoming.test.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zm
 */
public class ComUtils {


    public static String execute(String[] command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            InputStreamReader rd = new InputStreamReader(process.getInputStream());
            BufferedReader input = new BufferedReader(rd);
            StringBuilder builder = new StringBuilder();
            while (input.readLine() != null) {
                builder.append(input.readLine());
            }
            return builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}