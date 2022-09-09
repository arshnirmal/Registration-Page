package com.example.registrationpage;

public class RegisterationInput {
    private String name,email,date;

    public RegisterationInput(String name, String email, int dd,int mm,int yyyy) {
        this.name = name;
        this.email = email;
        this.date = Integer.toString(dd)+"/"+Integer.toString(mm)+"/"+Integer.toString(yyyy);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "RegisterationInput{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
