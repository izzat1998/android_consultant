package com.example.mebel_system_consultant.api_serializer;

public class Category
{
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

    public Category(String name) {
        this.name = name;
    }
}

