package SkywarsAdmin.commands.commands.Skywars;

import SkywarsAdmin.commands.CCT;
import SkywarsAdmin.commands.commands.Skywars.Kit.Save;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class KitCCT extends CCT {
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length != 0)
        {
            if(strings[0].equals("save")) {
                return new Save().onCommand(commandSender, command, s, removeCommand(strings));
            }
        }
        return false;
    }
}
