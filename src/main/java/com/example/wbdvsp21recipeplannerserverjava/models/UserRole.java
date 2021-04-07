package com.example.wbdvsp21recipeplannerserverjava.models;

public enum UserRole {

    CREATOR,
    SHOPPER;

    @Override
    public String toString(){
        switch (this){
            case CREATOR:
                return "CREATOR";
            case SHOPPER:
                return "SHOPPER";
            default:
                return "None";
        }
    }
}
