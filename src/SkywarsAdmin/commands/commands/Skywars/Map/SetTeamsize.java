package SkywarsAdmin.commands.commands.Skywars.Map;

import SkywarsAdmin.Util.Language;
import SkywarsAdmin.tools.Mapbuilder;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetTeamsize {
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if(strings.length == 1) {
                if(strings[0].matches("[+-]?\\d*(\\.\\d+)?")) {
                    //Überprüfe, ob der richtige Spieler auf eine vorhandene Map zugreift
                    if (Mapbuilder.getPlayer() != null && Mapbuilder.getPlayer() == player) {
                        Mapbuilder.getMap().setTeamsize(Integer.parseInt(strings[0]));
                        player.sendMessage(Language.format(String.format(Language.getStringFromKeyword(Language.LanguageKeyword.CMD_SET_TEAMSIZE), Mapbuilder.getMap().getTeamsize())));
                    } else {
                        player.sendMessage(Language.format(Language.getStringFromKeyword(Language.LanguageKeyword.ERR_NO_WORLD_IN_CREATION)));
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
