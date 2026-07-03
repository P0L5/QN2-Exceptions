package com.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesDemo {

    public static void leakyVersion(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line = br.readLine();
        System.out.println(line);
        br.close();
    }

    public static void safeVersion(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            System.out.println(line);
        }
    }

    public static void main(String[] args) {
        String filename = "data.txt";

        System.out.println("=== Leaky version (before) ===");
        System.out.println("If readLine() throws, close() is never called.");

        System.out.println("\n=== Try-with-resources (after) ===");
        System.out.println("BufferedReader is auto-closed even if readLine() throws.");
        try {
            safeVersion(filename);
        } catch (IOException e) {
            System.out.println("IOException caught (expected since data.txt may not exist)");
        }
    }
}
