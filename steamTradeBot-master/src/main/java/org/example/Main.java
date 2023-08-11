package org.example;

public class Main {

    public static void main(String[] args) {
        String steamid = "76561198988943690";

        SteamUserData userData = new SteamUserData(steamid);
        System.out.println(userData.getAllUserData());
    }
}

