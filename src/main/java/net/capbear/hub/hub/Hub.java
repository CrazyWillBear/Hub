package net.capbear.hub.hub;

import net.md_5.bungee.api.chat.*;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
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
        event.setJoinMessage("");
        Player player = event.getPlayer();
        for (Player p : getServer().getOnlinePlayers()) {
            player.hidePlayer(p);
            p.hidePlayer(player);
        }

        Location loc = new Location(getServer().getWorld("world_the_end"), 0.5, 1, 0.5, 0, 0);
        player.teleport(loc);

        TextComponent survival = new TextComponent("§3- §oSurvival"/*replace this with what you want the text to say*/);
        survival.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Join Survival server!"/*replace this with what you want the text to say when its hovered on*/).create()));
        survival.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/server survival"/*replace this with the command the player will run after clicking it*/));

        // copy above and replace parameters as needed
        TextComponent creative = new TextComponent("§3- §oCreative");
        creative.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Join Creative server!").create()));
        creative.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/server creative"));

        // add each message below
        player.sendMessage("§3§lSelect a server to join by clicking on it in chat!");
        player.sendMessage(survival);
        player.sendMessage(creative);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
