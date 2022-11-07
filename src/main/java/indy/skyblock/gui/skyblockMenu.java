package indy.skyblock.gui;

import indy.skyblock.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

public class skyblockMenu {

    public static Inventory inv;

    public static Inventory GUI() {
        inv = Bukkit.createInventory(null, 54, Utils.colorFormat("Skyblock Menu"));

        inv.setContents(inv.getContents());

        return inv;
    }
}
