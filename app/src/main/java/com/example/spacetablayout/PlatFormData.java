package com.example.spacetablayout;

public class PlatFormData {
    public String email;
    public String password;

    public PlatFormData() {

    }

    public PlatFormData(String email, String password ) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
