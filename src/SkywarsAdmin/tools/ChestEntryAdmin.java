package SkywarsAdmin.tools;

import SkywarsAdmin.Main;
import SkywarsAdmin.Util.Language;
import SkywarsCore.ChestEntry;
import SkywarsCore.Rarity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.PotionMeta;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class ChestEntryAdmin extends ChestEntry {
    public ChestEntryAdmin(ItemStack item, Map<String, Integer> itemENC, Rarity rarity) {
        super(item, itemENC, rarity);
    }

    public boolean save(Player player){
        String pathname = Main.PATH + "/Chest/" + rarity.getValue();

        StringBuilder entchantmentPart = new StringBuilder();
        for (Map.Entry<String, Integer> entry : getItemENC().entrySet()) {
            entchantmentPart.append(entry.getKey()).append(entry.getValue()).append('-');
        }

        StringBuilder potionPart = new StringBuilder();
        if(item.getItemMeta() instanceof PotionMeta) {
            PotionMeta potionMeta = (PotionMeta) item.getItemMeta();

            potionPart.append("(")
                    .append(potionMeta.getBasePotionData().getType().name())
                    .append(potionMeta.getBasePotionData().isExtended())
                    .append(potionMeta.getBasePotionData().isUpgraded())
                    .append(")");
        }

        String filename = item.getType().getKey().getKey() + potionPart + "-" + getItem().getAmount() + "--" + entchantmentPart + "-ChestEntry" + ".yml";

        try {
            new File(pathname).mkdirs();
            PrintWriter writer = new PrintWriter(pathname + "/" + filename);
            Yaml yaml = new Yaml();

            //Creation of a map to save it:
            Map<String, Object> map = new HashMap<>();

            Map<String, Object> itemMap = new HashMap<>();
            itemMap.put("type", item.getType().name());
            itemMap.put("amount", item.getAmount());
            itemMap.put("durability", ((Damageable) item.getItemMeta()).getDamage());
            itemMap.put("lore", item.getItemMeta().getLore());

            if(item.getItemMeta() instanceof PotionMeta){
                PotionMeta potionMeta = (PotionMeta) item.getItemMeta();

                Map<String, Object> metaMap = new HashMap<>();
                metaMap.put("value", potionMeta.getBasePotionData().getType().name());
                metaMap.put("extended", potionMeta.getBasePotionData().isExtended());
                metaMap.put("upgraded", potionMeta.getBasePotionData().isUpgraded());

                itemMap.put("potionMeta", metaMap);
            }

            map.put("item", itemMap);
            map.put("itemENC", itemENC);

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
