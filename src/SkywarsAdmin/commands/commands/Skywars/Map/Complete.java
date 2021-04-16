package SkywarsAdmin.commands.commands.Skywars.Map;

import SkywarsAdmin.Util.Language;
import SkywarsAdmin.Util.LanguageKeyword;
import SkywarsAdmin.tools.Mapbuilder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Complete{
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if(strings.length == 0) {
                //Überprüfe, ob der richtige Spieler auf eine vorhandene Map zugreift
                if(Mapbuilder.getPlayer() != null && Mapbuilder.getPlayer() == player){
                    //Beim erfolgreichen Abspeichern werden Spieler und Map aus dem Zwischenspeicher gelöscht
                    if(Mapbuilder.getMap().saveMap(player)){
                        Mapbuilder.reset();
                        player.sendMessage(Language.format(Language.getStringFromKeyword(LanguageKeyword.CMD_MAP_SAVED)));
                    }
                } else {
                    player.sendMessage(Language.format(Language.getStringFromKeyword(LanguageKeyword.ERR_NO_WORLD_IN_CREATION)));
                }
            } else {
                return false;
            }
        }
        return true;
    }
}