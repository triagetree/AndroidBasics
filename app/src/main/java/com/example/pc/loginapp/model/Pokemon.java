package com.example.pc.loginapp.model;

public class Pokemon {

    private String name,type;
    private int picture;

    public Pokemon(){

    }
    public Pokemon(String name,String type,int picture){
        this.name=name;
        this.type=type;
        this.picture=picture;
        }

        public String getName(){
        return name;
        }
        public void setName(String name){
        this.name=name;
        }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}
