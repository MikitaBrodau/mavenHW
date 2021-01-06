package com.Brodau;

public class JsonDeserialization {
    private final String path;
    private final String oldName;
    private final String newName;

    public JsonDeserialization(String path, String oldName, String newName) {
        this.path = path;
        this.oldName = oldName;
        this.newName = newName;
    }

    public String getPath() {
        return path;
    }

    public String getOldName() {
        return oldName;
    }

    public String getNewName() {
        return newName;
    }
}
