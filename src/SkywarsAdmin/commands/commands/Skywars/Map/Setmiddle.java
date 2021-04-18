package SkywarsAdmin.commands.commands.Skywars.Map;

import SkywarsAdmin.Util.Language;
import SkywarsAdmin.tools.Mapbuilder;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Setmiddle{
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if(strings.length == 0) {
                //Überprüfe, ob der richtige Spieler auf eine vorhandene Map zugreift
                if(Mapbuilder.getPlayer() != null && Mapbuilder.getPlayer() == player){
                    Mapbuilder.getMap().setMiddle(new Location(null, player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ()));
                    player.sendMessage(Language.format(Language.getStringFromKeyword(Language.LanguageKeyword.CMD_SET_MIDDLE)));
                } else {
                    player.sendMessage(Language.format(Language.getStringFromKeyword(Language.LanguageKeyword.ERR_NO_WORLD_IN_CREATION)));
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
