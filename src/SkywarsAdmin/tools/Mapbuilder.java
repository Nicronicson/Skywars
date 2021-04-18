package SkywarsAdmin.tools;

import org.bukkit.entity.Player;

public class Mapbuilder {
    private static Player player;
    private static MapAdmin map;

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

    public static MapAdmin getMap() {
        return map;
    }

    public static void setMap(MapAdmin map) {
        Mapbuilder.map = map;
    }

    public static void reset(){
        setPlayer(null);
        setMap(null);
        setOverride(false);
    }
}
