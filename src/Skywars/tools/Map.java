package Skywars.tools;

import Skywars.Structs.Coordinate;
import Skywars.Util.Language;
import Skywars.Util.LanguageKeyword;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Map {
    private String mapname;
    private Coordinate pos1;
    private Coordinate pos2;
    private List<Coordinate> spawnpoints;
    private List<Coordinate> chests;
    private List<Coordinate> middleChests;

    public Map(String mapname){
        this.mapname = mapname;
        this.spawnpoints = new ArrayList<>();
        this.chests = new ArrayList<>();
        this.middleChests = new ArrayList<>();
    }

    public void setPos1(Coordinate pos1){
        pos1 = pos1;
    }

    public void setPos2(Coordinate pos2){
        pos2 = pos2;
    }

    public void addSpawnpoint(Coordinate spawnpoint){
        spawnpoints.add(spawnpoint);
    }

    public void resetSpawnpoints(){
        spawnpoints.clear();
    }

    public void setChests(List<Coordinate> chests){
        this.chests = chests;
    }

    public void setMiddleChests(List<Coordinate> middleChests){
        this.middleChests = middleChests;
    }

    public void loadMap(){

    }

    public boolean saveMap(Player player){
        boolean complete = true;
        if(pos1 == null || pos2 == null){
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
                PrintWriter writer = new PrintWriter(new File("/SkyWars/" + mapname + ".yml"));
                Yaml yaml = new Yaml();
                yaml.dump(this, writer);
            } catch (FileNotFoundException exception) {
                player.sendMessage(Language.format(Language.getStringFromKeyword(LanguageKeyword.ERR_SAVING_UNSUCCESSFUL)));
            }
        } else {
            return false;
        }
        return true;
    }
}
