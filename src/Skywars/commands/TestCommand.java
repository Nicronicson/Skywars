package Skywars.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.io.File;
import java.io.FileWriter;

public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        try {
            new File("./plugins/SkyWars").mkdir();
            FileWriter file = new FileWriter("./plugins/SkyWars/test.yml");
            file.write("test");
            file.close();
        } catch (Exception e){
            Bukkit.broadcastMessage(e.getMessage());
        }
        return true;
    }
}
