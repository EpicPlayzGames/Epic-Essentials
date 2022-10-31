package dev.epicplayzgames.epicessentials.lib.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class mutechatCommand implements CommandExecutor {
    public static boolean muted = false;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //Assigns sender to player instance
        if(sender instanceof Player player) {

            //Checks if player has permissions needed
            if(player.hasPermission("epic-essentials.mutechat.use")) {

                //Checks if server chat is muted
                if(muted) {

                    //Unmuted server chat
                    muted = false;
                    Bukkit.broadcastMessage(ChatColor.GOLD + "The chat was unmuted by " + player.getDisplayName());

                } else {

                    //Mutes server chat
                    muted = true;
                    Bukkit.broadcastMessage(ChatColor.GOLD + "Chat was muted by " + player.getDisplayName());

                }

            } else {

                player.sendMessage(ChatColor.RED + "Unable to execute that command");

            }

        }

        return true;
    }
}
