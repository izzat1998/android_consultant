package com.example.mebel_system_consultant.api_serializer;


public class Consultant
{
    private String name;

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

    public Consultant(String name) {
        this.name = name;
    }
}
