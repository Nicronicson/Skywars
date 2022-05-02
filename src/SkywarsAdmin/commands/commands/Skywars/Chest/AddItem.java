package SkywarsAdmin.commands.commands.Skywars.Chest;

import SkywarsAdmin.Util.Language;
import SkywarsAdmin.tools.ChestEntryAdmin;
import SkywarsAdmin.tools.KitAdmin;
import SkywarsAdmin.tools.Kitbuilder;
import SkywarsCore.Rarity;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddItem {
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (strings.length == 1 || strings.length == 2) {
                if(strings[0].matches("[+-]?\\d*(\\.\\d+)?") &&  Integer.parseInt(strings[0]) >= 0 && Integer.parseInt(strings[0]) <= 3){
                    ItemStack item = player.getInventory().getItemInMainHand();
                    if(!item.getType().isAir()) {
                        Map.Entry<Enchantment, Integer>[] itemPreENC = !item.getType().isAir() ? item.getEnchantments().entrySet().toArray(new Map.Entry[item.getEnchantments().entrySet().size()]) : new Map.Entry[0]; //Sonderfall da die rightHand nie null ist, sondern Luft als lehre Hand interpretiert wird
                        Map<String, Integer> itemENC = new HashMap<>();
                        for (Map.Entry<Enchantment, Integer> entry : itemPreENC) {
                            itemENC.put(entry.getKey().getKey().getKey(), entry.getValue());
                        }

                        new ChestEntryAdmin(item, itemENC, Rarity.getById(Integer.parseInt(strings[0]))).save(player);
                    } else {
                        player.sendMessage(Language.format(Language.getStringFromKeyword(Language.LanguageKeyword.ERR_NO_ITEM)));
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
