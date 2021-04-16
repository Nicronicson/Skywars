package SkywarsAdmin;

import SkywarsAdmin.commands.commands.SkywarsCCT;
import SkywarsAdmin.listeners.SkywarsMapbuildListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
    //TODO: TabCompleter
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
        getCommand("skywarsadmin").setExecutor(new SkywarsCCT());
        //getCommand("testcommand").setExecutor(new TestCommand());
    }

    private void registerListeners(){
        getServer().getPluginManager().registerEvents(new SkywarsMapbuildListener(), this);
    }
}
