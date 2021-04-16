package SkywarsAdmin.tools;

import org.bukkit.entity.Player;

public class Kitbuilder {
    private static Player player;

    private static String name;

    private static boolean override = false;

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        Kitbuilder.player = player;
    }

    public static boolean isOverride() {
        return override;
    }

    public static void setOverride(boolean override) {
        Kitbuilder.override = override;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Kitbuilder.name = name;
    }

    public static void reset(){
        setPlayer(null);
        setOverride(false);
    }
}
