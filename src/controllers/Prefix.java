package controllers;

import java.io.Serializable;
import java.util.UUID;

public class Prefix implements Serializable {

    public String id = UUID.randomUUID().toString();
    public String filePath;

    public Prefix(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "Prefix{" +
                "id='" + id + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
