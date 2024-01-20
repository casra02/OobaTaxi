package com.google.ar.core.examples.java.dbManagement;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class AccountDB{
    public static List<String[]> accounts = new ArrayList<>();
    public static boolean loggedIn = false;

    public static void addAccount(String email, String password){
        String[] info = {email,password};
        accounts.add(info);
    }

    public static boolean deleteAccount(String email,String password){
        for(int i = 0; i < accounts.size(); i++){
            if(accounts.get(i)[0].equals(email) && accounts.get(i)[1].equals(password)){
                accounts.remove(i);
                return true;
            }
        }
        return false;
    }

    public static boolean editAccount(String prevEmail, String prevPassword, String newEmail, String newPassword){
        String [] newInfo = {newEmail,newPassword};
        for(int i = 0; i < accounts.size(); i++){
            if(accounts.get(i)[0].equals(prevEmail) && accounts.get(i)[1].equals(prevPassword)){
                accounts.set(i,newInfo);
                return true;
            }
        }
        return false;
    }

    public static boolean checkAccountExists(String email){
        for(int i = 0; i < accounts.size(); i++){
            if(accounts.get(i)[0].equals(email)){
                return true;
            }
        }
        return false;
    }

    public static boolean checkLogin(String email, String password){
        for(int i = 0; i < accounts.size(); i++){
            if(accounts.get(i)[0].equals(email) && accounts.get(i)[1].equals(password)){
                return true;
            }
        }
        return false;
    }

}
