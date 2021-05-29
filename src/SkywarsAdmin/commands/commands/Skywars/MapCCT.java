package SkywarsAdmin.commands.commands.Skywars;

import SkywarsAdmin.commands.CCT;
import SkywarsAdmin.commands.commands.Skywars.Map.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class MapCCT extends CCT {
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length != 0)
        {
            if(strings[0].equals("complete")) {
                return new Complete().onCommand(commandSender, command, s, removeCommand(strings));
            }
            if(strings[0].equals("create")) {
                return new Create().onCommand(commandSender, command, s, removeCommand(strings));
            }
            if(strings[0].equals("resetspawnpoints")) {
                return new Resetspawnpoints().onCommand(commandSender, command, s, removeCommand(strings));
            }
            if(strings[0].equals("scanchests")) {
                return new Scanchests().onCommand(commandSender, command, s, removeCommand(strings));
            }
            if(strings[0].equals("setmiddle")) {
                return new Setmiddle().onCommand(commandSender, command, s, removeCommand(strings));
            }
            if(strings[0].equals("setpos1")) {
                return new Setpos1().onCommand(commandSender, command, s, removeCommand(strings));
            }
            if(strings[0].equals("setpos2")) {
                return new Setpos2().onCommand(commandSender, command, s, removeCommand(strings));
            }
            if(strings[0].equals("setspawn")) {
                return new Setspawn().onCommand(commandSender, command, s, removeCommand(strings));
            }
            if(strings[0].equals("trash")) {
                return new Trash().onCommand(commandSender, command, s, removeCommand(strings));
            }
            if(strings[0].equals("setteamsize")) {
                return new SetTeamsize().onCommand(commandSender, command, s, removeCommand(strings));
            }
        }
        return false;
    }
}
