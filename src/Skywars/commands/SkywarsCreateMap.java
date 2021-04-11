package Skywars.commands;

import Skywars.Util.Language;
import Skywars.Util.LanguageKeyword;
import Skywars.tools.Map;
import Skywars.tools.Mapbuilder;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SkywarsCreateMap implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if(strings.length == 0) {
                if (Mapbuilder.getPlayer() != null) {
                    Mapbuilder.setPlayer(player);
                    Mapbuilder.setMap(new Map(player.getWorld().getName()));
                } else {
                    player.sendMessage(Language.format(Language.getStringFromKeyword(LanguageKeyword.ERR_WORLD_IN_CREATION)));
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
