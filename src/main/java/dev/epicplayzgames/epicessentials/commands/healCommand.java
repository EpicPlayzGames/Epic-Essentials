package dev.epicplayzgames.epicessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class healCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //Checks if command sender is a player
        if(sender instanceof Player) {
            //Passes command sender into the player instance
            Player player = (Player) sender;

            //Checks if player has appropriate permission to execute the command
            if(player.hasPermission("epic-essentials.heal")) {

                //Checks for player name
                if(args.length == 0) {

                    player.setHealth(20);
                    player.setFoodLevel(20);
                    player.setSaturation(20);
                    player.sendMessage(ChatColor.GOLD + "You've Been Healed.");

                }

                //Checks for player name
                if(args.length == 1) {
                    String playerName = args[0];
                    Player targetPlayer = Bukkit.getPlayerExact(playerName);

                    //Checks if target player is online
                    if(targetPlayer != null) {

                        targetPlayer.setHealth(20);
                        targetPlayer.setFoodLevel(20);
                        targetPlayer.setSaturation(20);
                        targetPlayer.sendMessage(ChatColor.GOLD + "You've been healed by " + player.getDisplayName());

                        player.sendMessage(ChatColor.GOLD + targetPlayer.getDisplayName() + " has been healed.");

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
