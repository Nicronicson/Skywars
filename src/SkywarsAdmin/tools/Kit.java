package SkywarsAdmin.tools;

import SkywarsAdmin.Util.Language;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

public class Kit {
    private ItemStack leftHand;
    private Map<String, Integer> leftHandENC;

    private ItemStack helmet;
    private Map<String, Integer> helmetENC;
    private ItemStack chestplate;
    private Map<String, Integer> chestplateENC;
    private ItemStack leggings;
    private Map<String, Integer> leggingsENC;
    private ItemStack boots;
    private Map<String, Integer> bootsENC;

    private ItemStack[] inventory;
    private ArrayList<Map<String, Integer>> inventoryENC;

    public Kit(ItemStack leftHand, Map<String, Integer> leftHandENC, ItemStack helmet, Map<String, Integer> helmetENC, ItemStack chestplate, Map<String, Integer> chestplateENC, ItemStack leggings, Map<String, Integer> leggingsENC, ItemStack boots, Map<String, Integer> bootsENC, ItemStack[] inventory, ArrayList<Map<String, Integer>> inventoryENC) {
        this.leftHand = leftHand;
        this.leftHandENC = leftHandENC;
        this.helmet = helmet;
        this.helmetENC = helmetENC;
        this.chestplate = chestplate;
        this.chestplateENC = chestplateENC;
        this.leggings = leggings;
        this.leggingsENC = leggingsENC;
        this.boots = boots;
        this.bootsENC = bootsENC;
        this.inventory = inventory;
        this.inventoryENC = inventoryENC;
    }

    public ItemStack getLeftHand() {
        return leftHand;
    }

    public void setLeftHand(ItemStack leftHand) {
        this.leftHand = leftHand;
    }

    public Map<String, Integer> getLeftHandENC() {
        return leftHandENC;
    }

    public void setLeftHandENC(Map<String, Integer> leftHandENC) {
        this.leftHandENC = leftHandENC;
    }

    public ItemStack getHelmet() {
        return helmet;
    }

    public void setHelmet(ItemStack helmet) {
        this.helmet = helmet;
    }

    public Map<String, Integer> getHelmetENC() {
        return helmetENC;
    }

    public void setHelmetENC(Map<String, Integer> helmetENC) {
        this.helmetENC = helmetENC;
    }

    public ItemStack getChestplate() {
        return chestplate;
    }

    public void setChestplate(ItemStack chestplate) {
        this.chestplate = chestplate;
    }

    public Map<String, Integer> getChestplateENC() {
        return chestplateENC;
    }

    public void setChestplateENC(Map<String, Integer> chestplateENC) {
        this.chestplateENC = chestplateENC;
    }

    public ItemStack getLeggings() {
        return leggings;
    }

    public void setLeggings(ItemStack leggings) {
        this.leggings = leggings;
    }

    public Map<String, Integer> getLeggingsENC() {
        return leggingsENC;
    }

    public void setLeggingsENC(Map<String, Integer> leggingsENC) {
        this.leggingsENC = leggingsENC;
    }

    public ItemStack getBoots() {
        return boots;
    }

    public void setBoots(ItemStack boots) {
        this.boots = boots;
    }

    public Map<String, Integer> getBootsENC() {
        return bootsENC;
    }

    public void setBootsENC(Map<String, Integer> bootsENC) {
        this.bootsENC = bootsENC;
    }

    public ItemStack[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemStack[] inventory) {
        this.inventory = inventory;
    }

    public ArrayList<Map<String, Integer>> getInventoryENC() {
        return inventoryENC;
    }

    public void setInventoryENC(ArrayList<Map<String, Integer>> inventoryENC) {
        this.inventoryENC = inventoryENC;
    }

    public boolean save(String name, Player player){
        try {
            //TODO: Should be Okay!!! (Check if the directory and/or the .yml file are already present)
            new File("./plugins/SkyWarsAdmin").mkdir();
            if(!new File("./plugins/SkyWarsAdmin/" + name + "-kit" + ".yml").exists() || Kitbuilder.isOverride()) {
                PrintWriter writer = new PrintWriter("./plugins/SkyWarsAdmin/" + name + "-kit" + ".yml");
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
