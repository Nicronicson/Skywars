package SkywarsAdmin.tools;

import SkywarsAdmin.Util.Language;
import SkywarsAdmin.Util.LanguageKeyword;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Kit {
    private Item leftHand;

    private Item helmet;
    private Item chestplate;
    private Item trousers;
    private Item shoes;

    private Item[] inventory;
    private Item[] hotbar;

    public Kit(Item helmet, Item chestplate, Item leftHand, Item trousers, Item shoes, Item[] inventory, Item[] hotbar) {
        this.helmet = helmet;
        this.chestplate = chestplate;
        this.leftHand = leftHand;
        this.trousers = trousers;
        this.shoes = shoes;
        this.inventory = inventory;
        this.hotbar = hotbar;
    }

    public Item getHelmet() {
        return helmet;
    }

    public void setHelmet(Item helmet) {
        this.helmet = helmet;
    }

    public Item getChestplate() {
        return chestplate;
    }

    public void setChestplate(Item chestplate) {
        this.chestplate = chestplate;
    }

    public Item getLeftHand() {
        return leftHand;
    }

    public void setLeftHand(Item leftHand) {
        this.leftHand = leftHand;
    }

    public Item getTrousers() {
        return trousers;
    }

    public void setTrousers(Item trousers) {
        this.trousers = trousers;
    }

    public Item getShoes() {
        return shoes;
    }

    public void setShoes(Item shoes) {
        this.shoes = shoes;
    }

    public Item[] getInventory() {
        return inventory;
    }

    public void setInventory(Item[] inventory) {
        this.inventory = inventory;
    }

    public Item[] getHotbar() {
        return hotbar;
    }

    public void setHotbar(Item[] hotbar) {
        this.hotbar = hotbar;
    }

    public boolean save(String name, Player player){
        try {
            //TODO: Should be Okay!!! (Check if the directory and/or the .yml file are already present)
            new File("./plugins/SkyWarsAdmin").mkdir();
            if(!new File("./plugins/SkyWarsAdmin/" + name + ".yml").exists() || Kitbuilder.isOverride()) {
                PrintWriter writer = new PrintWriter("./plugins/SkyWarsAdmin/" + name + ".yml");
                Yaml yaml = new Yaml();
                yaml.dump(this, writer);
                Kitbuilder.reset();
            } else {
                Kitbuilder.setOverride(true);
                player.sendMessage(Language.format(Language.getStringFromKeyword(LanguageKeyword.ERR_MAP_EXISTING)));
                return false;
            }
        }
        catch (IOException exception){
            player.sendMessage(Language.format(Language.getStringFromKeyword(LanguageKeyword.ERR_SAVING_UNSUCCESSFUL)));
            return false;
        }
        return true;
    }
}
