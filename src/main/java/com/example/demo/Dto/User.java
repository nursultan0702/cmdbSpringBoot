package com.example.demo.Dto;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String SteamId;
    private String nickName;
    private String email;
    private String password;
    private ArrayList<Integer> friendList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSteamId() {
        return SteamId;
    }

    public void setSteamId(String steamId) {
        SteamId = steamId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Integer> getFriendList() {
        return friendList;
    }

    public void setFriendList(ArrayList<Integer> friendList) {
        this.friendList = friendList;
    }
}
