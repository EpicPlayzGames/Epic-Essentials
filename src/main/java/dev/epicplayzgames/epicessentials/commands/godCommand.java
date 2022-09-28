package dev.epicplayzgames.epicessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class godCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player player) {

            if(player.hasPermission("epic-essentials.god")) {

                if(args.length == 0) {

                    if(player.isInvulnerable()){

                        player.setInvulnerable(false);
                        player.sendMessage(ChatColor.GOLD + "God Mode Disabled");
                    } else {

                        player.setInvulnerable(true);
                        player.sendMessage(ChatColor.GOLD + "God Mode Enabled");

                    }

                }

                if(args.length == 1) {
                    String playerName = args[0];
                    Player targetPlayer = Bukkit.getPlayerExact(playerName);

                    if(args[0].equals(targetPlayer.getDisplayName())) {

                        if(targetPlayer.isInvulnerable()) {

                            targetPlayer.setInvulnerable(false);
                            targetPlayer.sendMessage(ChatColor.GOLD + "God Mode Disabled");
                            player.sendMessage(ChatColor.GOLD + "God Mode Disabled for " + targetPlayer.getDisplayName());

                        } else {

                            targetPlayer.setInvulnerable(true);
                            targetPlayer.sendMessage(ChatColor.GOLD + "God Mode Enabled");
                            player.sendMessage(ChatColor.GOLD + "God Mode Enabled for " + targetPlayer.getDisplayName());

                        }

                    }

                }

            } else {

                player.sendMessage(ChatColor.RED + "Unable to execute that command");

            }

        } else {

            System.out.println(ChatColor.RED + "Must be a player to execute that command.");

        }


        return true;
    }
}
