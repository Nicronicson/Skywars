package SkywarsAdmin.tools;

import SkywarsAdmin.Main;
import SkywarsAdmin.Util.Language;
import SkywarsCore.Kit;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KitAdmin extends Kit {

    public KitAdmin(String name, ItemStack leftHand, Map<String, Integer> leftHandENC, ItemStack helmet, Map<String, Integer> helmetENC, ItemStack chestplate, Map<String, Integer> chestplateENC, ItemStack leggings, Map<String, Integer> leggingsENC, ItemStack boots, Map<String, Integer> bootsENC, ItemStack[] inventory, ArrayList<Map<String, Integer>> inventoryENC, ItemStack visual) {
        super(name, leftHand, leftHandENC, helmet, helmetENC, chestplate, chestplateENC, leggings, leggingsENC, boots, bootsENC, inventory, inventoryENC, visual);
    }

    public boolean save(String name, Player player) {
        String pathname = Main.PATH + "/Kit";
        String filename = name + "-kit" + ".yml";

        try {
            new File(pathname).mkdirs();
            if (!new File(pathname + "/" + filename).exists() || Kitbuilder.isOverride()) {
                PrintWriter writer = new PrintWriter(pathname + "/" + filename);
                Yaml yaml = new Yaml();

                //Creation of a map to save it:
                Map<String, Object> map = new HashMap<>();

                map.put("name", name);

                Map<String, Object> leftHandMap = new HashMap<>();
                if (leftHand != null) {
                    leftHandMap.put("type", leftHand.getType().getKey().getKey());
                    leftHandMap.put("amount", leftHand.getAmount());
                    leftHandMap.put("durability", ((Damageable) leftHand.getItemMeta()).getDamage());
                }

                map.put("leftHand", leftHandMap);
                map.put("leftHandENC", leftHandENC);

                Map<String, Object> helmetMap = new HashMap<>();
                if (helmet != null) {
                    helmetMap.put("type", helmet.getType().getKey().getKey());
                    helmetMap.put("amount", helmet.getAmount());
                    helmetMap.put("durability", ((Damageable) helmet.getItemMeta()).getDamage());
                }

                map.put("helmet", helmetMap);
                map.put("helmetENC", helmetENC);

                Map<String, Object> chestplateMap = new HashMap<>();
                if (chestplate != null) {
                    chestplateMap.put("type", chestplate.getType().getKey().getKey());
                    chestplateMap.put("amount", chestplate.getAmount());
                    chestplateMap.put("durability", ((Damageable) chestplate.getItemMeta()).getDamage());
                }

                map.put("chestplate", chestplateMap);
                map.put("chestplateENC", chestplateENC);

                Map<String, Object> leggingsMap = new HashMap<>();
                if (leggings != null) {
                    leggingsMap.put("type", leggings.getType().getKey().getKey());
                    leggingsMap.put("amount", leggings.getAmount());
                    leggingsMap.put("durability", ((Damageable) leggings.getItemMeta()).getDamage());
                }

                map.put("leggings", leggingsMap);
                map.put("leggingsENC", leggingsENC);

                Map<String, Object> bootsMap = new HashMap<>();
                if (boots != null) {
                    bootsMap.put("type", boots.getType().getKey().getKey());
                    bootsMap.put("amount", boots.getAmount());
                    bootsMap.put("durability", ((Damageable) boots.getItemMeta()).getDamage());
                }

                map.put("boots", bootsMap);
                map.put("bootsENC", bootsENC);

                List<Map<String, Object>> inventoryMapList = new ArrayList<>();

                for (ItemStack inventorySlot : inventory) {
                    Map<String, Object> inventorySlotMap = new HashMap<>();
                    if (inventorySlot != null) {
                        inventorySlotMap.put("type", inventorySlot.getType().getKey().getKey());
                        inventorySlotMap.put("amount", inventorySlot.getAmount());
                        inventorySlotMap.put("durability", ((Damageable) inventorySlot.getItemMeta()).getDamage());
                    }
                    inventoryMapList.add(inventorySlotMap);
                }

                map.put("inventory", inventoryMapList);
                map.put("inventoryENC", inventoryENC);

                map.put("visual", visual.getType().getKey().getKey());

                yaml.dump(map, writer);

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
        } catch (Exception exception) {
            player.sendMessage(Language.format(Language.getStringFromKeyword(Language.LanguageKeyword.ERR_SAVING_UNSUCCESSFUL_KIT)));
            return false;
        }
        return true;
    }
}
