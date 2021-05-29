package SkywarsAdmin.tools;

import SkywarsAdmin.Main;
import SkywarsAdmin.Util.Language;
import SkywarsCore.ChestEntry;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class ChestEntryAdmin extends ChestEntry {
    public ChestEntryAdmin(ItemStack item, Map<String, Integer> itemENC, int chance, int middleChance) {
        super(item, itemENC, chance, middleChance);
    }

    public boolean save(Player player){
        String pathname = Main.PATH + "/Chest";

        StringBuilder entchantmentPart = new StringBuilder();
        for (Map.Entry<String, Integer> entry : getItemENC().entrySet()) {
            entchantmentPart.append(entry.getKey()).append(entry.getValue()).append('-');
        }

        String filename = item.getType().getKey().getKey() + "-" + getItem().getAmount() + "--" + entchantmentPart + "-ChestEntry" + ".yml";

        try {
            new File(pathname).mkdirs();
            PrintWriter writer = new PrintWriter(pathname + "/" + filename);
            Yaml yaml = new Yaml();

            //Creation of a map to save it:
            Map<String, Object> map = new HashMap<>();

            Map<String, Object> itemMap = new HashMap<>();
            itemMap.put("type", item.getType().getKey().getKey());
            itemMap.put("amount", item.getAmount());
            itemMap.put("durability", ((Damageable) item.getItemMeta()).getDamage());

            map.put("item", itemMap);
            map.put("itemENC", itemENC);
            map.put("chance", chance);
            map.put("middleChance", middleChance);

            yaml.dump(map, writer);
            player.sendMessage(Language.format(Language.getStringFromKeyword(Language.LanguageKeyword.CMD_ChestEntry_SAVED)));
        }
        catch (IOException exception){
            player.sendMessage(Language.format(Language.getStringFromKeyword(Language.LanguageKeyword.ERR_SAVING_UNSUCCESSFUL_ChestEntry)));
            return false;
        }
        return true;
    }
}
