package com.automotive.models.jwt;

import java.io.Serializable;
import java.util.List;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private final String username;
    private final String photo;

    private final List<String> roles;

    public JwtResponse(String jwttoken,String username, String photo,List<String> roles) {
        this.jwttoken = jwttoken;
        this.username=username;
        this.photo=photo;
        this.roles=roles;
    }

    public String getPhoto() {
        return photo;
    }

    public String getUsername() {
        return username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public String getToken() {
        return this.jwttoken;
    }
}