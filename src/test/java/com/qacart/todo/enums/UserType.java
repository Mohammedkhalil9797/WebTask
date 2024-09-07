package com.qacart.todo.enums;

public enum UserType {
    TaskLogin("standard_user", "secret_sauce")
    ;

    public final String userName;
    public final String password;




    UserType(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

}
