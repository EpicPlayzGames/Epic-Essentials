package dev.epicplayzgames.epicessentials.lib.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class feedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //Checks if command sender is a player
        if(sender instanceof Player player) {
            //Passes command sender into the player instance

            //Checks if player has appropriate permission to execute the command
            if(player.hasPermission("epic-essentials.feed")) {

                //Checks if player provides a name or not
                if(args.length == 0) {

                    player.setFoodLevel(20);
                    player.setSaturation(20);
                    player.sendMessage(ChatColor.GOLD + "You've Been Fed.");

                }

                //Checks if a name is provided
                if(args.length == 1) {
                    String playerName = args[0];
                    Player targetPlayer = Bukkit.getPlayerExact(playerName);

                    //Checks to see if player is online or not
                    if(targetPlayer != null) {

                        targetPlayer.setFoodLevel(20);
                        targetPlayer.setSaturation(20);
                        targetPlayer.sendMessage(ChatColor.GOLD + "You've been fed by " + player.getDisplayName());

                        player.sendMessage(ChatColor.GOLD + targetPlayer.getDisplayName() + " has been fed.");

                    } else {

                        player.sendMessage(ChatColor.RED + "Unknown Player.");

                    }

                }

            } else {

                player.sendMessage(ChatColor.RED + "Unable to execute that command.");

            }

        } else {

            System.out.println(ChatColor.RED + "Unable to execute that command.");

        }

        return true;
    }

}
