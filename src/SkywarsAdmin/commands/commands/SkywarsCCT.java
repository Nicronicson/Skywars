package SkywarsAdmin.commands.commands;

import SkywarsAdmin.commands.CCT;
import SkywarsAdmin.commands.commands.Skywars.KitCCT;
import SkywarsAdmin.commands.commands.Skywars.MapCCT;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SkywarsCCT extends CCT implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length != 0)
        {
            if(strings[0].equals("map")) {
                return new MapCCT().onCommand(commandSender, command, s, removeCommand(strings));
            }
            if(strings[0].equals("kit")) {
                return new KitCCT().onCommand(commandSender, command, s, removeCommand(strings));
            }
        }
        return false;
    }
}
