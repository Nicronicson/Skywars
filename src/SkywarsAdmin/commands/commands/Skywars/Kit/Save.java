package SkywarsAdmin.commands.commands.Skywars.Kit;

import SkywarsAdmin.Util.Language;
import SkywarsAdmin.Util.LanguageKeyword;
import SkywarsAdmin.tools.Kit;
import SkywarsAdmin.tools.Kitbuilder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Save{
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if(strings.length == 1) {
                //Überprüfe, ob der richtige Spieler auf das Kit zugreift:
                if(Kitbuilder.getPlayer() != null && Kitbuilder.getPlayer() == player && strings[0].equals(Kitbuilder.getName())){
                    //TODO:Kit speichern
                    if(new Kit(null, null, null, null, null, null, null).save(strings[0] , player)){
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
