package com.qacart.todo.enums;

public enum UserType {
    CRMUser("nasfour", "Password@02"),
    CRMUserUAT("nasfour", "Password@0100")
    ;

    public final String userName;
    public final String password;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }


    UserType(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

}
