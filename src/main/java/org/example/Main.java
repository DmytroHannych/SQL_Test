package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static final String URL = "jdbc:h2:~/test";
    private static final String ADMIN = "Gannich";
    private static final String PASSWORD = "12345";

    public static void main(String[] args) {
        try (H2Repo repo = new H2Repo(URL,ADMIN,PASSWORD);
            InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("init_db.sql")){
                Scanner scanner = new Scanner(inputStream);
                StringBuilder stringBuilder = new StringBuilder();
                while (scanner.hasNextLine()){
                    stringBuilder.append(scanner.hasNext());
                }
                repo.execute(stringBuilder.toString());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
}
}
