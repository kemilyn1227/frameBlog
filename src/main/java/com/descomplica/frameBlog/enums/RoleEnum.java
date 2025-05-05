package com.descomplica.frameBlog.enums;

public enum RoleEnum {
    ADMIN("admin"),
    USER("user");

    //este private final string precisa ser longe do admin e user
    private final String role;

    RoleEnum(String role){

        this.role = role;

    }

    public String getRole(){
        return role;
    }
}
