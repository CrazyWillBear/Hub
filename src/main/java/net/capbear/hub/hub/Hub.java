package net.capbear.hub.hub;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Hub extends JavaPlugin implements Listener {

    // This is a CUSTOM plugin, it will only work if you configure THIS code accordingly.

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);

        getLogger().info("Hub enabled"); // confirm plugin activity
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().setGameMode(GameMode.ADVENTURE);
        event.setJoinMessage("");
        Player player = event.getPlayer();
        for (Player p : getServer().getOnlinePlayers()) {
            player.hidePlayer(p);
            p.hidePlayer(player);
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        event.setQuitMessage("");
    }

    @EventHandler
    public void onPlayerChat(PlayerChatEvent event) { event.setCancelled(true); }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
