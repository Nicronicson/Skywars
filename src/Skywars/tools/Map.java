package Skywars.tools;

import Skywars.Util.Language;
import Skywars.Util.LanguageKeyword;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Map {
    final private String mapname;
    private Location middle;
    private Location pos1;
    private Location pos2;
    final private List<Location> spawnpoints;
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
                new File("/SkyWars/" + mapname + ".yml").createNewFile();
                PrintWriter writer = new PrintWriter("/SkyWars/" + mapname + ".yml");
                Yaml yaml = new Yaml();
                yaml.dump(this, writer);
            }
            catch (IOException exception){
                player.sendMessage(Language.format(Language.getStringFromKeyword(LanguageKeyword.ERR_SAVING_UNSUCCESSFUL)));
            }
        } else {
            return false;
        }
        return true;
    }
}
