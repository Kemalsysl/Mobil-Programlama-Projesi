package com.example.proje1.Domain;

public class CategoryDomain {
    private String title;
    private  String pic;

    public CategoryDomain(String title, String pic){
        this.title=title;
        this.pic=pic;
    }

    public String getTitle() {
        return title;
    }

    public String getPic() {
        return pic;
    }
}
