package indy.skyblock.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class Utils {

    public static String colorFormat(String message){
        return ChatColor.translateAlternateColorCodes('&',message);
    }

    public static ItemStack createItem(Inventory inv, int slot, String material, int amount, String name, String[] lore) {

        List<String> loreList = Arrays.asList(lore);

        ItemStack item;
        item = new ItemStack(Material.getMaterial(material), amount);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(loreList);
        item.setItemMeta(meta);

        inv.setItem(slot, item);
        return item;
    }
}
