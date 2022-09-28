package dev.epicplayzgames.epicessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class clearchatCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //Assigns sender to the player instance
        if(sender instanceof Player player) {

            //Checks if player has permissions needed
            if(player.hasPermission("epic-essentials.clearchat.use")) {

                // Checks for online players
                for(Player p : Bukkit.getOnlinePlayers()) {

                    //Checks for those who can bypass the clear
                    if(p.hasPermission("epic-essentials.clearchat.bypass")) {

                        p.sendMessage(ChatColor.GOLD + "Chat was cleared by " + player.getDisplayName() + " , but you bypassed this");

                    } else {

                        //Loops through 100 messages and clears chat
                        for (int x = 0; x < 100; x++) {

                            p.sendMessage("");

                        }
                        p.sendMessage(ChatColor.GOLD + "Chat was cleared by " + player.getDisplayName());

                    }

                }

            } else {

                player.sendMessage(ChatColor.RED + "Unable to execute that command");

            }

        }

        return true;
    }
}
