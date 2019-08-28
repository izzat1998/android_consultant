package com.example.mebel_system_consultant.api_serializer;

public class Visitors
{
    private String date;

    private String find_out;

    private Filial filial;

    private String model_furniture;

    private Consultant consultant;

    private String color;

    private String type_furniture;

    private String nuance;

    private String other_shop;


    private  Name_furniture[] name_furniture;
    private Category[] category;

    public String getDate ()
    {
        return date;
    }

    public void setDate (String date)
    {
        this.date = date;
    }

    public String getFind_out ()
    {
        return find_out;
    }

    public void setFind_out (String find_out)
    {
        this.find_out = find_out;
    }

    public Filial getFilial ()
    {
        return filial;
    }

    public void setFilial (Filial filial)
    {
        this.filial = filial;
    }

    public String getModel_furniture ()
    {
        return model_furniture;
    }

    public void setModel_furniture (String model_furniture)
    {
        this.model_furniture = model_furniture;
    }

    public Consultant getConsultant ()
    {
        return consultant;
    }

    public void setConsultant (Consultant consultant)
    {
        this.consultant = consultant;
    }

    public String getColor ()
    {
        return color;
    }

    public void setColor (String color)
    {
        this.color = color;
    }

    public String getType_furniture ()
    {
        return type_furniture;
    }

    public void setType_furniture (String type_furniture)
    {
        this.type_furniture = type_furniture;
    }

    public String getNuance ()
    {
        return nuance;
    }

    public void setNuance (String nuance)
    {
        this.nuance = nuance;
    }

    public String getOther_shop ()
    {
        return other_shop;
    }

    public void setOther_shop (String other_shop)
    {
        this.other_shop = other_shop;
    }


    public  Name_furniture[] getName_furniture(){return name_furniture;}

    public  void setName_furniture(Name_furniture[] name_furniture)
    {
        this.name_furniture=name_furniture;
    }

    public Category[] getCategory ()
    {
        return category;
    }

    public void setCategory (Category[] category)
    {
        this.category = category;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [date = "+date+", find_out = "+find_out+", filial = "+filial+", model_furniture = "+model_furniture+", consultant = "+consultant+", color = "+color+", type_furniture = "+type_furniture+", nuance = "+nuance+", name_furniture = "+name_furniture+", other_shop = "+other_shop+", category = "+category+"]";
    }

    public Visitors(String date, String find_out, Filial filial, String model_furniture, Consultant consultant, String color, String type_furniture, String nuance, Name_furniture[] name_furniture, String other_shop , Category[] category) {
        this.date = date;
        this.find_out = find_out;
        this.filial = filial;
        this.model_furniture = model_furniture;
        this.consultant = consultant;
        this.color = color;
        this.type_furniture = type_furniture;
        this.name_furniture=name_furniture;
        this.nuance = nuance;
        this.other_shop = other_shop;
        this.category = category;
    }
}