package com.example.demo.Dto;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "gameserverinfo")

public class GameServerInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String creatorSteamId;
    public int maxPlayers;
    public boolean isPublic;
    public String mapName;
    public String players;
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public String getCreatorSteamId() {
        return creatorSteamId;
    }

    public void setCreatorSteamId(String creatorSteamId) {
        this.creatorSteamId = creatorSteamId;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public String getPlayers() {
        return players;
    }

    public void setPlayers(String players) {
        this.players = players;
    }

    public String toString(){
        return "creatorSteamId: '" + this.creatorSteamId + "', maxPlayers: '" + this.maxPlayers + "', mapName: '" + this.mapName + "', players: "+ this.players;
    }

}


