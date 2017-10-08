package com.vpopescu.endava.recyclemap.model;

public class DataObject {
    private int imageId;
    private String imageName;
    private String imageText;

    public DataObject(int imageId, String imageName, String imageText) {
        this.imageId = imageId;
        this.imageName = imageName;
        this.imageText = imageText;
    }
    public int getImageId() {
        return imageId;
    }
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    public String getImageName() {
        return imageName;
    }
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageText() {
        return imageText;
    }

    public void setImageText(String imageText) {
        this.imageText = imageText;
    }
}