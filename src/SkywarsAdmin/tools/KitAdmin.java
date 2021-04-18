package SkywarsAdmin.tools;

import SkywarsAdmin.Util.Language;
import SkywarsCore.Kit;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

public class KitAdmin extends Kit {

    public KitAdmin(ItemStack leftHand, Map<String, Integer> leftHandENC, ItemStack helmet, Map<String, Integer> helmetENC, ItemStack chestplate, Map<String, Integer> chestplateENC, ItemStack leggings, Map<String, Integer> leggingsENC, ItemStack boots, Map<String, Integer> bootsENC, ItemStack[] inventory, ArrayList<Map<String, Integer>> inventoryENC) {
        super(leftHand, leftHandENC, helmet, helmetENC, chestplate, chestplateENC, leggings, leggingsENC, boots, bootsENC, inventory, inventoryENC);
    }

    public boolean save(String name, Player player){
        String pathname = "./plugins/SkyWarsAdmin";
        String filname = name + "-kit" + ".yml";

        try {
            new File(pathname).mkdir();
            if(!new File(pathname + "/" + filname).exists() || Kitbuilder.isOverride()) {
                PrintWriter writer = new PrintWriter(pathname + "/" + filname);
                Yaml yaml = new Yaml();
                yaml.dump(this, writer);
                player.sendMessage(Language.format(Language.getStringFromKeyword(Language.LanguageKeyword.CMD_KIT_SAVED)));
                Kitbuilder.reset();
            } else {
                Kitbuilder.setOverride(true);
                Kitbuilder.setPlayer(player);
                Kitbuilder.setName(name);
                Kitbuilder.setTime();
                player.sendMessage(Language.format(Language.getStringFromKeyword(Language.LanguageKeyword.ERR_KIT_EXISTING)));
                return false;
            }
        }
        catch (IOException exception){
            player.sendMessage(Language.format(Language.getStringFromKeyword(Language.LanguageKeyword.ERR_SAVING_UNSUCCESSFUL_KIT)));
            return false;
        }
        return true;
    }
}
