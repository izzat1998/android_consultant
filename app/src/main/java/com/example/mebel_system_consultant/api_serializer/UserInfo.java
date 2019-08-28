package com.example.mebel_system_consultant.api_serializer;

public class UserInfo {
    private Visitors[] visitors;

    private String character;

    private String nuance;

    private String name;

    private String phone_number;

    private String status;


    public Visitors[] getVisitors ()
    {
        return visitors;
    }

    public void setVisitors (Visitors[] visitors)
    {
        this.visitors = visitors;
    }

    public String getCharacter ()
    {
        return character;
    }

    public void setCharacter (String character)
    {
        this.character = character;
    }

    public String getNuance ()
    {
        return nuance;
    }

    public void setNuance (String nuance)
    {
        this.nuance = nuance;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getPhone_number ()
    {
        return phone_number;
    }

    public void setPhone_number (String phone_number)
    {
        this.phone_number = phone_number;
    }


    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [visitors = "+visitors+", character = "+character+", nuance = "+nuance+", name = "+name+", phone_number = "+phone_number+", status = "+status+"]";
    }

    public UserInfo(Visitors[] visitors, String character, String nuance, String name, String phone_number, String status) {
        this.visitors = visitors;
        this.character = character;
        this.nuance = nuance;
        this.name = name;
        this.phone_number = phone_number;
        this.status = status;
    }
}
