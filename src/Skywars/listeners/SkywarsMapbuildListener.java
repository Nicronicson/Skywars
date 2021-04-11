package Skywars.listeners;

import Skywars.Util.Language;
import Skywars.Util.LanguageKeyword;
import Skywars.tools.Mapbuilder;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class SkywarsMapbuildListener implements Listener {
 public SkywarsMapbuildListener(){

 }
 @EventHandler
 public void onPlayerChangedWorldEvent(PlayerChangedWorldEvent event){
     if(Mapbuilder.getPlayer() == event.getPlayer()){
         Mapbuilder.reset();
         event.getPlayer().sendMessage(Language.format(Language.getStringFromKeyword(LanguageKeyword.CMD_MAP_TRASHED)));
     }
 }
}
