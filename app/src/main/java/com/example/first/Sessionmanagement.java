package com.example.first;

import android.content.Context;
import android.content.SharedPreferences;

public class Sessionmanagement {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String SHARED_PREF_NAME="session";
    String SESSION_KEY="session_user";
    public Sessionmanagement(Context context){
        sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }
    public void saveSession(User user){
        int id=user.getId();
        editor.putInt(SESSION_KEY,id).commit();

    }
    public  int  getSession(){
     return -1;
    }
}
