package SkywarsAdmin.tools;

import SkywarsAdmin.Util.Language;
import SkywarsCore.ChestEntry;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class ChestEntryAdmin extends ChestEntry {
    public ChestEntryAdmin(ItemStack item, Map<String, Integer> itemENC, int chance, int middleChance) {
        super(item, itemENC, chance, middleChance);
    }

    public boolean save(Player player){
        String pathname = "./plugins/SkyWarsAdmin/Chest";

        StringBuilder entchantmentPart = new StringBuilder();
        for (Map.Entry<String, Integer> entry : getItemENC().entrySet()) {
            entchantmentPart.append(entry.getKey()).append(entry.getValue()).append('-');
        }

        String filename = getItem().getData().getItemType().name() + "-" + getItem().getAmount() + "--" + entchantmentPart + "-ChestEntry" + ".yml";

        try {
            new File(pathname).mkdirs();
            PrintWriter writer = new PrintWriter(pathname + "/" + filename);
            Yaml yaml = new Yaml();
            yaml.dump(this, writer);
            player.sendMessage(Language.format(Language.getStringFromKeyword(Language.LanguageKeyword.CMD_ChestEntry_SAVED)));
        }
        catch (IOException exception){
            player.sendMessage(Language.format(Language.getStringFromKeyword(Language.LanguageKeyword.ERR_SAVING_UNSUCCESSFUL_ChestEntry)));
            return false;
        }
        return true;
    }
}
