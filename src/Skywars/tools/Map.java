package Skywars.tools;

import Skywars.Util.Language;
import Skywars.Util.LanguageKeyword;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Map {
    private String mapname;
    private Location middle;
    private Location pos1;
    private Location pos2;

    private List<Location> spawnpoints;
    private List<Location> chests;
    private List<Location> middleChests;

    public Map(String mapname){
        this.mapname = mapname;
        this.middle = null;
        this.pos1 = null;
        this.pos2 = null;
        this.spawnpoints = new ArrayList<>();
        this.chests = new ArrayList<>();
        this.middleChests = new ArrayList<>();
    }

    public void setMapname(String mapname) {
        this.mapname = mapname;
    }

    public void setSpawnpoints(List<Location> spawnpoints) {
        this.spawnpoints = spawnpoints;
    }

    public String getMapname(){
        return mapname;
    }

    public List<Location> getSpawnpoints() {
        return spawnpoints;
    }

    public List<Location> getChests() {
        return chests;
    }

    public List<Location> getMiddleChests() {
        return middleChests;
    }

    public Location getMiddle() {
        return middle;
    }

    public void setMiddle(Location middle) {
        this.middle = middle;
    }

    public void setPos1(Location pos1) {
        this.pos1 = pos1;
    }

    public Location getPos1(){
        return pos1;
    }

    public void setPos2(Location pos2) {
        this.pos2 = pos2;
    }

    public Location getPos2(){
        return pos2;
    }

    public void addSpawnpoint(Location spawnpoint){
        spawnpoints.add(spawnpoint);
    }

    public void resetSpawnpoints(){
        spawnpoints.clear();
    }

    public void setChests(List<Location> chests){
        this.chests = chests;
    }

    public void setMiddleChests(List<Location> middleChests){
        this.middleChests = middleChests;
    }

    public void loadMap(){

    }

    public boolean positionsAvailable(){
        if(pos1 == null || pos2 == null){
            return false;
        } else {
            return true;
        }
    }

    public boolean saveMap(Player player){
        boolean complete = true;
        if(!positionsAvailable()){
            player.sendMessage(Language.format(Language.getStringFromKeyword(LanguageKeyword.ERR_NO_POSITION)));
            complete = false;
        }
        if(spawnpoints.isEmpty()){
            player.sendMessage(Language.format(Language.getStringFromKeyword(LanguageKeyword.ERR_NO_SPAWNPOINTS)));
            complete = false;
        }
        if(chests.isEmpty() || middleChests.isEmpty()){
            player.sendMessage(Language.format(Language.getStringFromKeyword(LanguageKeyword.ERR_NO_CHESTS)));
            complete = false;
        }
        if(complete) {
            try {
                //TODO: Check if the directory and/or the .yml file are already present
                new File("./plugins/SkyWars").mkdir();
                PrintWriter writer = new PrintWriter("./plugins/SkyWars/" + mapname + ".yml");
                Yaml yaml = new Yaml();
                yaml.dump(this, writer);
            }
            catch (IOException exception){
                player.sendMessage(Language.format(Language.getStringFromKeyword(LanguageKeyword.ERR_SAVING_UNSUCCESSFUL)));
                return false;
            }
        } else {
            return false;
        }
        return true;
    }
}
