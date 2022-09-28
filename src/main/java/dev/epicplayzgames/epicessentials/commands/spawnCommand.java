package dev.epicplayzgames.epicessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class spawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //Checks if command sender is a player
        if (sender instanceof Player) {
            //Passes sender into player instance
            Player player = (Player) sender;

            //Checks for player name
            if (args.length == 0 ) {

                // Teleports player to world spawn
                player.teleport(player.getWorld().getSpawnLocation());
                player.sendMessage(ChatColor.GOLD + "Teleported to World Spawn");

            }

            //Checks for player name
            if(args.length == 1) {
                String playerName = args[0];
                Player targetPlayer = Bukkit.getPlayerExact(playerName);

                //If name provided, checks if player has permission to use command
                if(player.hasPermission("epic-essentials.spawn.other")) {

                    targetPlayer.teleport(targetPlayer.getWorld().getSpawnLocation());
                    targetPlayer.sendMessage(ChatColor.GOLD + "Teleported to spawn by " + player.getDisplayName());
                    player.sendMessage(ChatColor.GOLD + targetPlayer.getDisplayName() + " teleported to spawn");

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
