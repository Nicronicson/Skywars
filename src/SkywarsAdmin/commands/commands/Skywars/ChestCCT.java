package SkywarsAdmin.commands.commands.Skywars;

import SkywarsAdmin.commands.CCT;
import SkywarsAdmin.commands.commands.Skywars.Chest.AddItem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class ChestCCT extends CCT {
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length != 0)
        {
            if(strings[0].equals("additem")) {
                return new AddItem().onCommand(commandSender, command, s, removeCommand(strings));
            }
        }
        return false;
    }
}
