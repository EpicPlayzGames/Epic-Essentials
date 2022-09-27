package dev.epicplayzgames.epicessentials.commands;

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

            //Sends a player to their bed location
            player.teleport(player.getBedSpawnLocation());

        }

        return true;
    }
}
