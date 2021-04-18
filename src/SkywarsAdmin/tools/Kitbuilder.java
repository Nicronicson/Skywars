package SkywarsAdmin.tools;

import org.bukkit.entity.Player;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

public class Kitbuilder {
    private static Player player;

    private static String name;

    private static LocalDateTime time;

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

    public static LocalDateTime getTime() {
        return time;
    }

    public static void setTime() {
        Kitbuilder.time = LocalDateTime.now(ZoneOffset.UTC);
    }

    public static boolean checkCurrent(){
        if( time != null && LocalDateTime.now(ZoneOffset.UTC).isAfter(time.plus(10, ChronoUnit.SECONDS))){
            reset();
            return false;
        }
        return true;
    }

    public static void reset(){
        setName(null);
        setPlayer(null);
        setOverride(false);
        time = null;
    }
}
