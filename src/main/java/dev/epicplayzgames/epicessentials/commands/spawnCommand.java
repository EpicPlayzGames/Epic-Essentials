package dev.epicplayzgames.epicessentials.commands;

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

            // Teleports player to world spawn
            player.teleport(player.getWorld().getSpawnLocation());
            player.sendMessage(ChatColor.GOLD + "Teleported to World Spawn");

        }

        return true;
    }
}
