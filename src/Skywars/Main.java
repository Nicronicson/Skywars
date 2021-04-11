package Skywars;

import Skywars.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
    public void onEnable(){
        getLogger().info("Loading Essence Plugin.");
        getLogger().info("Downloading Essence Language.");
        getLogger().info("Loading Essence Commands.");
        registerCommands();
        getLogger().info("Loading Essence Listeners.");
        registerListeners();
        getLogger().info("Essence primed and ready.");
    }

    private void registerCommands(){
        getCommand("skywars complete map").setExecutor(new SkywarsCompleteMap());
        getCommand("skywars create map").setExecutor(new SkywarsCreateMap());
        getCommand("skywars reset spawnpoints").setExecutor(new SkywarsResetSpawnpoints());
        getCommand("skywars scan chests").setExecutor(new SkywarsScanChests());
        getCommand("skywars set pos1").setExecutor(new SkywarsSetPos1());
        getCommand("skywars set pos2").setExecutor(new SkywarsSetPos2());
        getCommand("skywars set spawn").setExecutor(new SkywarsSetSpawn());
    }

    private void registerListeners(){
        //getServer().getPluginManager().registerEvents(new VanishListener(vanish), this);
    }
}
