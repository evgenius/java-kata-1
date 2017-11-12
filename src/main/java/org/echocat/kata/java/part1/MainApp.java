package org.echocat.kata.java.part1;

import org.echocat.kata.java.part1.http.HttpService;
import org.echocat.kata.java.part1.storage.*;

import java.io.IOException;

@SuppressWarnings("UseOfSystemOutOrSystemErr")
public class MainApp {

    public static void main(String[] args) throws IOException {
        StorageImpl storage = new StorageImpl();
        storage.load();

        HttpService httpService = new HttpService(storage);
        httpService.run();
    }

    protected static String getHelloWorldText() {
        return "Hello world!";
    }

}
