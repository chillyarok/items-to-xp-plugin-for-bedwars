package BAS.item_to_xp_plugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class Item_to_xp_plugin extends JavaPlugin {
    int bprice = 1; //цена в exp за 1 керпич
    int iprice = 10; //цена в exp за 1 железный слиток
    int dprice = 25; //цена в exp за 1 алмаз
    int eprice = 35; //цена в exp за 1 изумруд
    @Override
    public void onEnable() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    checkInventory(player);
                }
            }
        }.runTaskTimer(this, 0L, 1L); // 0L - задержка перед первым запуском, 10L - интервал в тиках
    }

    private void checkInventory(Player player) {
        for (ItemStack item : player.getInventory()) {
            if (item != null && item.getType() == Material.BRICK) {
                player.giveExp(bprice);
                player.getInventory().removeItem(new ItemStack(Material.BRICK,1));
                // Тут можно добавить любую логику при нахождении предмета
                break; // Останавливаем цикл, если нашли предмет
            }
            if (item != null && item.getType() == Material.IRON_INGOT) {
                player.giveExp(iprice);
                player.getInventory().removeItem(new ItemStack(Material.IRON_INGOT,1));
                // Тут можно добавить любую логику при нахождении предмета
                break; // Останавливаем цикл, если нашли предмет
            }

            if (item != null && item.getType() == Material.DIAMOND) {
                player.giveExp(dprice);
                player.getInventory().removeItem(new ItemStack(Material.DIAMOND,1));
                // Тут можно добавить любую логику при нахождении предмета
                break; // Останавливаем цикл, если нашли предмет
            }
            if (item != null && item.getType() == Material.EMERALD) {
                player.giveExp(eprice);
                player.getInventory().removeItem(new ItemStack(Material.EMERALD,1));
                // Тут можно добавить любую логику при нахождении предмета
                break; // Останавливаем цикл, если нашли предмет
            }
        }
    }
}
