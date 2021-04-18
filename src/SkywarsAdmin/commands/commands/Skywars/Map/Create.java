package SkywarsAdmin.commands.commands.Skywars.Map;

import SkywarsAdmin.Util.Language;
import SkywarsAdmin.tools.Map;
import SkywarsAdmin.tools.Mapbuilder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Create{
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if(strings.length == 0) {
                if (Mapbuilder.getPlayer() == null) {
                    Mapbuilder.setPlayer(player);
                    Mapbuilder.setMap(new Map(player.getWorld().getName()));
                    player.sendMessage(Language.format(Language.getStringFromKeyword(Language.LanguageKeyword.CMD_MAP_CREATED)));
                } else {
                    player.sendMessage(Language.format(Language.getStringFromKeyword(Language.LanguageKeyword.ERR_WORLD_IN_CREATION)));
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
