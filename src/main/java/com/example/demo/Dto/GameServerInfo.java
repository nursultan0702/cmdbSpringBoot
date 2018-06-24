package com.example.demo.Dto;

public class GameServerInfo {

    public String creatorSteamId;
    public int maxPlayers;
    public boolean isPublic;
    public String mapName;
    public String players;

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


}


