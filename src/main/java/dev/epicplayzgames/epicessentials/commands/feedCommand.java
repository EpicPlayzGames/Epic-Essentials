package dev.epicplayzgames.epicessentials.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class feedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //Checks if command sender is a player
        if(sender instanceof Player) {
            //Passes command sender into the player instance
            Player player = (Player) sender;

            //Checks if player has appropriate permission to execute the command
            if(player.hasPermission("epic-essentials.feed")) {

                player.setFoodLevel(20);
                player.setSaturation(20);
                player.sendMessage(ChatColor.GOLD + "You've Been Fed.");

            } else {

                player.sendMessage(ChatColor.RED + "Unable to execute that command.");

            }

        } else {

            System.out.println(ChatColor.RED + "Unable to execute that command.");

        }

        return true;
    }

}
