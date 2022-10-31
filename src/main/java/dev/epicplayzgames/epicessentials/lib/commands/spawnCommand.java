package dev.epicplayzgames.epicessentials.lib.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class spawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //Checks if command sender is a player
        if (sender instanceof Player player) {
            //Passes sender into player instance

            //Checks for player name
            if (args.length == 0 ) {

                // Teleports player to world spawn
                player.teleport(Objects.requireNonNull(player.getServer().getWorld("world")).getSpawnLocation());
                player.sendMessage(ChatColor.YELLOW + "Sent to Spawn");

            }

            //Checks for player name
            if(args.length == 1) {
                String playerName = args[0];
                Player targetPlayer = Bukkit.getPlayerExact(playerName);

                //If name provided, checks if player has permission to use command
                if(player.hasPermission("epic-essentials.spawn.other")) {

                    if(targetPlayer != null){

                        targetPlayer.teleport(Objects.requireNonNull(targetPlayer.getServer().getWorld("world")).getSpawnLocation());
                        targetPlayer.sendMessage(ChatColor.GOLD + "Sent to Spawn by " + player.getDisplayName());
                        player.sendMessage(ChatColor.GOLD + targetPlayer.getDisplayName() + " sent to Spawn");

                    } else {

                        player.sendMessage(ChatColor.RED + "Unknown player");

                    }

                } else {

                    player.sendMessage(ChatColor.RED + "Unable to execute that command");

                }

            }

        } else {

            System.out.println("Must be a player to execute that command");

        }

        return true;
    }

}
