package com.example.first;

public class Upload {
    private String mname;
    private String mImageUrl;
    public Upload(){


    }
    public Upload(String name,String ImageUrl)
    {
        if(name.trim().equals("")){
            name="No Name";
        }
        mname=name;
        mImageUrl =ImageUrl;
    }
    public String getname(){
        return mname;
    }
    public void setName(String name){
        mname=name;
    }
    public String getImageUrl(){
        return mImageUrl;
    }
    public void setImageUrl(String imageurl){
        mImageUrl=imageurl;
    }
}
