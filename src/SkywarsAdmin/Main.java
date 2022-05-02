package SkywarsAdmin;

import SkywarsAdmin.commands.TestCommand;
import SkywarsAdmin.commands.commands.SkywarsCCT;
import SkywarsAdmin.listeners.SkywarsMapbuildListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin{

    public static String PATH = "/root/CloudNet/local/templates/SkywarsAdmin/default/plugins/SkyWarsAdmin";

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
        Objects.requireNonNull(getCommand("skywarsadmin")).setExecutor(new SkywarsCCT());
        //getCommand("testcommand").setExecutor(new TestCommand());
    }

    private void registerListeners(){
        getServer().getPluginManager().registerEvents(new SkywarsMapbuildListener(), this);
    }
}
