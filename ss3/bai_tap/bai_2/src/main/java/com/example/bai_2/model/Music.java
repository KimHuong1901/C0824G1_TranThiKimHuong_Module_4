package com.example.bai_2.model;

public class Music {
    private String name;
    private String single;
    private String type;
    private String urlFile;
    public Music() {}
    public Music(String name, String single, String type, String urlFile) {
        this.name = name;
        this.single = single;
        this.type = type;
        this.urlFile = urlFile;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSingle() {
        return single;
    }
    public void setSingle(String single) {
        this.single = single;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getUrlFile() {
        return urlFile;
    }
    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }
}
