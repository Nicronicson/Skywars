package SkywarsAdmin.commands.commands.Skywars.Kit;

import SkywarsAdmin.Util.Language;
import SkywarsAdmin.tools.Kit;
import SkywarsAdmin.tools.Kitbuilder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Save {
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (strings.length == 1) {
                //Überprüfe, ob der richtige Spieler auf das Kit zugreift:
                Kitbuilder.checkCurrent();
                if (Kitbuilder.getPlayer() == null || (Kitbuilder.getPlayer() == player && strings[0].equals(Kitbuilder.getName()))) {
                    //TODO: Kit speichern
                    /** Left Hand */
                    ItemStack leftHand = player.getInventory().getItemInOffHand();
                    Map.Entry<Enchantment, Integer>[] leftHandPreENC = !leftHand.getType().isAir() ? leftHand.getEnchantments().entrySet().toArray(new Map.Entry[leftHand.getEnchantments().entrySet().size()]) : new Map.Entry[0]; //Sonderfall da die leftHand nie null ist, sondern Luft als lehre Hand interpretiert wird
                    Map<String, Integer> leftHandENC = new HashMap<>();
                    for (Map.Entry<Enchantment, Integer> entry : leftHandPreENC) {
                        leftHandENC.put(entry.getKey().getKey().getKey(), entry.getValue());
                    }

                    //TODO: Unten alles so machen wie bei left Hand und in Kit alles in String umändern

                    /** Armor */
                    //helmet
                    ItemStack helmet = player.getInventory().getHelmet();
                    Map.Entry<Enchantment, Integer>[] helmetpreENC = helmet != null ? helmet.getEnchantments().entrySet().toArray(new Map.Entry[helmet.getEnchantments().entrySet().size()]) : new Map.Entry[0];
                    Map<String, Integer> helmetENC = new HashMap<>();
                    for (Map.Entry<Enchantment, Integer> entry : helmetpreENC) {
                        helmetENC.put(entry.getKey().getKey().getKey(), entry.getValue());
                    }
                    //chestplate
                    ItemStack chestplate = player.getInventory().getChestplate();
                    Map.Entry<Enchantment, Integer>[] chestplatepreENC = chestplate != null ? chestplate.getEnchantments().entrySet().toArray(new Map.Entry[chestplate.getEnchantments().entrySet().size()]) : new Map.Entry[0];
                    Map<String, Integer> chestplateENC = new HashMap<>();
                    for (Map.Entry<Enchantment, Integer> entry : chestplatepreENC) {
                        chestplateENC.put(entry.getKey().getKey().getKey(), entry.getValue());
                    }
                    //leggings
                    ItemStack leggings = player.getInventory().getLeggings();
                    Map.Entry<Enchantment, Integer>[] leggingspreENC = leggings != null ? leggings.getEnchantments().entrySet().toArray(new Map.Entry[leggings.getEnchantments().entrySet().size()]) : new Map.Entry[0];
                    Map<String, Integer> leggingsENC = new HashMap<>();
                    for (Map.Entry<Enchantment, Integer> entry : leggingspreENC) {
                        leggingsENC.put(entry.getKey().getKey().getKey(), entry.getValue());
                    }
                    //boots
                    ItemStack boots = player.getInventory().getBoots();
                    Map.Entry<Enchantment, Integer>[] bootspreENC = boots != null ? boots.getEnchantments().entrySet().toArray(new Map.Entry[boots.getEnchantments().entrySet().size()]) : new Map.Entry[0];
                    Map<String, Integer> bootsENC = new HashMap<>();
                    for (Map.Entry<Enchantment, Integer> entry : bootspreENC) {
                        bootsENC.put(entry.getKey().getKey().getKey(), entry.getValue());
                    }

                    /** Inventory */
                    ItemStack[] inventory = player.getInventory().getStorageContents();
                    ArrayList<Map.Entry<Enchantment, Integer>[]> inventorypreENC = new ArrayList<>();

                    for (ItemStack itemStack : inventory) {
                        try {
                            inventorypreENC.add(itemStack != null ? itemStack.getEnchantments().entrySet().toArray(new Map.Entry[itemStack.getEnchantments().entrySet().size()]) : new Map.Entry[0]);
                        } catch (Exception e) {
                            player.sendMessage(e.getMessage());
                        }
                    }

                    ArrayList<Map<String, Integer>> inventoryENC = new ArrayList<>();
                    for (Map.Entry<Enchantment, Integer>[] entries : inventorypreENC) {
                        Map<String, Integer> inventoryTempENC = new HashMap<>();
                        for (Map.Entry<Enchantment, Integer> entry : entries) {
                            inventoryTempENC.put(entry.getKey().getKey().getKey(), entry.getValue());
                        }
                        inventoryENC.add(inventoryTempENC);
                    }

                    new Kit(leftHand, leftHandENC, helmet, helmetENC, chestplate, chestplateENC, leggings, leggingsENC, boots, bootsENC, inventory, inventoryENC).save(strings[0], player);
                } else {
                    player.sendMessage(Language.format(Language.getStringFromKeyword(Language.LanguageKeyword.ERR_NOT_THE_OWNER)));
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
