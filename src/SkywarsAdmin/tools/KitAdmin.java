package SkywarsAdmin.tools;

import SkywarsAdmin.Main;
import SkywarsAdmin.Util.Language;
import SkywarsCore.Kit;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.PotionMeta;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

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
                    leftHandMap.put("type", leftHand.getType().name());
                    leftHandMap.put("amount", leftHand.getAmount());
                    leftHandMap.put("durability", ((Damageable) leftHand.getItemMeta()).getDamage());
                    leftHandMap.put("lore", leftHand.getItemMeta().getLore());

                    if(leftHand.getItemMeta() instanceof PotionMeta){
                        PotionMeta potionMeta = (PotionMeta) leftHand.getItemMeta();

                        Map<String, Object> potionMetaMap = new HashMap<>();
                        potionMetaMap.put("value", potionMeta.getBasePotionData().getType().name());
                        potionMetaMap.put("extended", potionMeta.getBasePotionData().isExtended());
                        potionMetaMap.put("upgraded", potionMeta.getBasePotionData().isUpgraded());

                        leftHandMap.put("potionMeta", potionMetaMap);
                    }
                }

                map.put("leftHand", leftHandMap);
                map.put("leftHandENC", leftHandENC);

                Map<String, Object> helmetMap = new HashMap<>();
                if (helmet != null) {
                    helmetMap.put("type", helmet.getType().name());
                    helmetMap.put("amount", helmet.getAmount());
                    helmetMap.put("durability", ((Damageable) helmet.getItemMeta()).getDamage());
                    helmetMap.put("lore", helmet.getItemMeta().getLore());
                }

                map.put("helmet", helmetMap);
                map.put("helmetENC", helmetENC);

                Map<String, Object> chestplateMap = new HashMap<>();
                if (chestplate != null) {
                    chestplateMap.put("type", chestplate.getType().name());
                    chestplateMap.put("amount", chestplate.getAmount());
                    chestplateMap.put("durability", ((Damageable) chestplate.getItemMeta()).getDamage());
                    chestplateMap.put("lore", chestplate.getItemMeta().getLore());
                }

                map.put("chestplate", chestplateMap);
                map.put("chestplateENC", chestplateENC);

                Map<String, Object> leggingsMap = new HashMap<>();
                if (leggings != null) {
                    leggingsMap.put("type", leggings.getType().name());
                    leggingsMap.put("amount", leggings.getAmount());
                    leggingsMap.put("durability", ((Damageable) leggings.getItemMeta()).getDamage());
                    leggingsMap.put("lore", leggings.getItemMeta().getLore());
                }

                map.put("leggings", leggingsMap);
                map.put("leggingsENC", leggingsENC);

                Map<String, Object> bootsMap = new HashMap<>();
                if (boots != null) {
                    bootsMap.put("type", boots.getType().name());
                    bootsMap.put("amount", boots.getAmount());
                    bootsMap.put("durability", ((Damageable) boots.getItemMeta()).getDamage());
                    bootsMap.put("lore", boots.getItemMeta().getLore());
                }

                map.put("boots", bootsMap);
                map.put("bootsENC", bootsENC);

                List<Map<String, Object>> inventoryMapList = new ArrayList<>();

                Arrays.stream(inventory).forEachOrdered(inventorySlot -> {
                    Map<String, Object> inventorySlotMap = new HashMap<>();
                    if (inventorySlot != null) {
                        inventorySlotMap.put("type", inventorySlot.getType().name());
                        inventorySlotMap.put("amount", inventorySlot.getAmount());
                        inventorySlotMap.put("durability", ((Damageable) inventorySlot.getItemMeta()).getDamage());
                        inventorySlotMap.put("lore", inventorySlot.getItemMeta().getLore());

                        if(inventorySlot.getItemMeta() instanceof PotionMeta){
                            PotionMeta potionMeta = (PotionMeta) inventorySlot.getItemMeta();

                            Map<String, Object> potionMetaMap = new HashMap<>();
                            potionMetaMap.put("value", potionMeta.getBasePotionData().getType().name());
                            potionMetaMap.put("extended", potionMeta.getBasePotionData().isExtended());
                            potionMetaMap.put("upgraded", potionMeta.getBasePotionData().isUpgraded());

                            inventorySlotMap.put("potionMeta", potionMetaMap);
                        }
                    }
                    inventoryMapList.add(inventorySlotMap);
                });

                map.put("inventory", inventoryMapList);
                map.put("inventoryENC", inventoryENC);

                map.put("visual", visual.getType().name());

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
