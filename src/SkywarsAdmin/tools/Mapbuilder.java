package SkywarsAdmin.tools;

import org.bukkit.entity.Player;

public class Mapbuilder {
    private static Player player;
    private static Map map;

    private static boolean override = false;

    public static boolean isOverride() {
        return override;
    }

    public static void setOverride(boolean override) {
        Mapbuilder.override = override;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player Player) {
        Mapbuilder.player = Player;
    }

    public static Map getMap() {
        return map;
    }

    public static void setMap(Map map) {
        Mapbuilder.map = map;
    }

    public static void reset(){
        setPlayer(null);
        setMap(null);
        setOverride(false);
    }
}
