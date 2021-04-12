package Skywars.commands;

import Skywars.Util.Language;
import Skywars.Util.LanguageKeyword;
import Skywars.tools.Mapbuilder;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class SkywarsSetSpawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if(strings.length == 0) {
                //Überprüfe, ob der richtige Spieler auf eine vorhandene Map zugreift
                if(Mapbuilder.getPlayer() != null && Mapbuilder.getPlayer() == player){
                    if(Mapbuilder.getMap().getMiddle() != null) {
                        //Position bestimmen
                        Location spawnpoint = new Location(null, player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ());
                        //Spawn Richtung bestimmen
                        Vector spawnpointVector = spawnpoint.toVector();
                        Vector middleVector = Mapbuilder.getMap().getMiddle().toVector();
                        Vector spawnDirectionVector = middleVector.subtract(spawnpointVector);
                        spawnpoint.setDirection(spawnDirectionVector);
                        Mapbuilder.getMap().addSpawnpoint(spawnpoint);
                        player.sendMessage(Language.format(Language.getStringFromKeyword(LanguageKeyword.CMD_ADD_SPAWNPOINT)));
                    } else {
                        player.sendMessage(Language.format(Language.getStringFromKeyword(LanguageKeyword.ERR_NO_MIDDLE)));
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
