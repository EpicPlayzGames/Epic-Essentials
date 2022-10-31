package dev.epicplayzgames.epicessentials.lib.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class timeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if(player.hasPermission("epic-essentials.set-time")) {

            if (args.length == 0) {

                player.sendMessage(ChatColor.RED + "Command parameters not met.");

            }

            if (args.length == 1) {
                String time = args[0];

                switch (time) {
                    case "day" -> {
                        player.getWorld().setTime(1000);
                        player.sendMessage(ChatColor.GOLD + "Time set to day.");
                    }
                    case "noon" -> {
                        player.getWorld().setTime(60000);
                        player.sendMessage(ChatColor.GOLD + "Time set to noon.");
                    }
                    case "night" -> {
                        player.getWorld().setTime(13000);
                        player.sendMessage(ChatColor.GOLD + "Time set to night.");
                    }
                    case "mid-night" -> {
                        player.getWorld().setTime(18000);
                        player.sendMessage(ChatColor.GOLD + "Time set to mid-night.");
                    }
                    case "sun-rise" -> {
                        player.getWorld().setTime(23000);
                        player.sendMessage(ChatColor.GOLD + "Time set to sun-rise.");
                    }
                    case "sun-set" -> {
                        player.getWorld().setTime(12000);
                        player.sendMessage(ChatColor.GOLD + "Time set to sun-set.");
                    }
                }

            }

        } else {

            player.sendMessage(ChatColor.RED + "Unable to execute that command.");

        }

        return true;
    }

}
