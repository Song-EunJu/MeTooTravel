package com.example.metootravel;

public class MainData {
    private int iv_image;
    private String tv_title;
    private String tv_content;

    public MainData(int iv_image, String tv_title, String tv_content) {
        this.iv_image = iv_image;
        this.tv_title = tv_title;
        this.tv_content = tv_content;
    }

    public int getIv_image() {
        return iv_image;
    }

    public void setIv_image(int iv_image) {
        this.iv_image= iv_image;
    }

    public String getTv_title() {
        return tv_title;
    }

    public void setTv_title(String tv_title) {
        this.tv_title = tv_title;
    }

    public String getTv_content() {
        return tv_content;
    }

    public void setTv_content(String tv_content) {
        this.tv_content = tv_content;
    }
}
