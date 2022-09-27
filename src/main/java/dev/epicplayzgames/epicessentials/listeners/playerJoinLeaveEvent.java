package dev.epicplayzgames.epicessentials.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
public class playerJoinLeaveEvent implements Listener {

    //Executes when a player joins
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent playerJoinEvent) {

        //Checks if the player has joined the server before
        if (playerJoinEvent.getPlayer().hasPlayedBefore()) {

            playerJoinEvent.setJoinMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Welcome back, " + ChatColor.WHITE + playerJoinEvent.getPlayer().getDisplayName() + ChatColor.GOLD + "" + ChatColor.BOLD + " to the Server!");

        } else { //Preforms if player hasn't joined before

            playerJoinEvent.setJoinMessage(ChatColor.WHITE + playerJoinEvent.getPlayer().getDisplayName() + ChatColor.GOLD + "" + ChatColor.BOLD + " has joined for the first time. Welcome!");

        }

    }

    //Executes when a player leaves
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent playerQuitEvent) {
        playerQuitEvent.setQuitMessage(ChatColor.WHITE + playerQuitEvent.getPlayer().getDisplayName() + ChatColor.RED + " has left the server.");

    }

}
