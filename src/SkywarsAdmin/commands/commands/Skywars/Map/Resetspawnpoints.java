package SkywarsAdmin.commands.commands.Skywars.Map;

import SkywarsAdmin.Util.Language;
import SkywarsAdmin.tools.Mapbuilder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Resetspawnpoints{
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if(strings.length == 0) {
                //Überprüfe, ob der richtige Spieler auf eine vorhandene Map zugreift
                if(Mapbuilder.getPlayer() != null && Mapbuilder.getPlayer() == player){
                    Mapbuilder.getMap().resetSpawnpoints();
                    player.sendMessage(Language.format(Language.getStringFromKeyword(Language.LanguageKeyword.CMD_RESET_SPAWNPOINTS)));
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
