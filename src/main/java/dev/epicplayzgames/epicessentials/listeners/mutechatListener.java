package dev.epicplayzgames.epicessentials.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import static dev.epicplayzgames.epicessentials.commands.mutechatCommand.muted;

public class mutechatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent asyncPlayerChatEvent) {

        //If muted, it checks who has bypass permissions, and cancels messages for those who don't.
        if(muted) {
            Player player = asyncPlayerChatEvent.getPlayer();

            if(player.hasPermission("epic-essentials.mutechat.bypass")) {
                player.sendMessage(ChatColor.GOLD + "Chat is currently muted, but you bypass this");

            } else {

                player.sendMessage(ChatColor.GOLD + "Chat is currently muted.");
                asyncPlayerChatEvent.setCancelled(true);

            }

        }

    }

}
