package com.example.assignment_3;

import android.widget.ImageView;

public class Contacts1 {

    private String name;
    private String number;
    private String email;
    private ImageView imageView;

    public Contacts1(String name, String number, String email,ImageView imageView) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.imageView=imageView;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }
    public ImageView getImageView(){return imageView;}

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setImageView(ImageView imageView){
        this.imageView=imageView;
    }
}
