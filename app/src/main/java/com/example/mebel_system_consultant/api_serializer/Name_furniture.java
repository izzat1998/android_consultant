package com.example.mebel_system_consultant.api_serializer;

public class Name_furniture {
    public String name;

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [name = "+name+"]";
    }


    public Name_furniture(String name) {
        this.name = name;
    }
}
