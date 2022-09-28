package dev.epicplayzgames.epicessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class homeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //Checks if sender is a player
        if(sender instanceof Player) {

            //Passes sender into player instance
            Player player = (Player) sender;

            if (args.length == 0) {

                if(player.getBedSpawnLocation() !=null) {
                    //Sends a player to their bed location
                    player.teleport(player.getBedSpawnLocation());
                    player.sendMessage(ChatColor.GOLD + "Teleported to Home");
                } else {

                    player.sendMessage(ChatColor.RED + "Bed location unknown.");

                }

            }

            //Checks if player executing command has permission
            if(player.hasPermission("epic-essentials.home.others")) {

                //Checks if player provides a name
                if(args.length == 1) {
                    String playerName = args[0];
                    Player targetPlayer = Bukkit.getPlayerExact(playerName);

                    //If name is provided, checks if target is online
                    if(targetPlayer != null) {

                        // Checks if target has a bed location
                        if(targetPlayer.getBedSpawnLocation() != null) {

                            targetPlayer.teleport(targetPlayer.getBedSpawnLocation());
                            targetPlayer.sendMessage(ChatColor.GOLD + "You've been sent home by " + player.getDisplayName());
                            player.sendMessage(ChatColor.YELLOW + targetPlayer.getDisplayName() + " has been sent home");

                        } else {

                            player.sendMessage(ChatColor.RED + "Player does not have a bed location");

                        }

                    } else {

                        player.sendMessage(ChatColor.RED + "Unknown Player");

                    }


                }

            }

        } else {

            System.out.println("Must be a player to execute this command");

        }

        return true;
    }

}
