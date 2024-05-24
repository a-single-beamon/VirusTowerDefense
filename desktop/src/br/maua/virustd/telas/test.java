package br.maua.virustd.telas;

import java.util.Map;

public class test {
    public static void main(String[] args) {
        // Get all environment variables
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n", envName, env.get(envName));
        }

        // Get a specific environment variable
        String javaHome = System.getenv("JAVA_HOME");
        System.out.println("JAVA_HOME: " + javaHome);
    }
}

