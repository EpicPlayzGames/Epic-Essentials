package dev.epicplayzgames.epicessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class gamemodeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player player){

            if(player.hasPermission("epic-essentials.gamemode")){

                if(args.length == 0 ) {

                    player.sendMessage(ChatColor.RED + "Command parameters not met.");

                }

                if(args.length == 1) {
                    String gamemode = args[0];

                    if (args[0].equals(gamemode)){

                        switch (gamemode) {
                            case "c" -> {
                                player.setGameMode(GameMode.CREATIVE);
                                player.sendMessage(ChatColor.GOLD + "Gamemode set to Creative.");
                            }
                            case "s" -> {
                                player.setGameMode(GameMode.SURVIVAL);
                                player.sendMessage(ChatColor.GOLD + "Gamemode set to survival.");
                            }
                            case "sp" -> {
                                player.setGameMode(GameMode.SPECTATOR);
                                player.sendMessage(ChatColor.GOLD + "Gamemode set to Spectator");
                            }
                            case "a" -> {
                                player.setGameMode(GameMode.ADVENTURE);
                                player.sendMessage(ChatColor.GOLD + "Gamemode set to Adventure.");
                            }
                        }

                    }

                }

                if(player.hasPermission("epic-essentials.gamemode.other")){

                    if(args.length == 2) {
                        String gamemode = args[0];
                        String playerName = args[1];
                        Player targetPlayer = Bukkit.getPlayerExact(playerName);

                        if(args[0].equals(gamemode)) {

                            if (targetPlayer != null) {

                                if(args[1].equals(targetPlayer.getDisplayName())) {

                                    switch (gamemode) {
                                        case "c" -> {
                                            targetPlayer.setGameMode(GameMode.CREATIVE);
                                            targetPlayer.sendMessage(ChatColor.GOLD + "Gamemode set to Creative by " + player.getDisplayName());
                                            player.sendMessage(ChatColor.GOLD + "Set creative mode for " + targetPlayer.getDisplayName());
                                        }
                                        case "s" -> {
                                            targetPlayer.setGameMode(GameMode.SURVIVAL);
                                            targetPlayer.sendMessage(ChatColor.GOLD + "Gamemode set to survival by " + player.getDisplayName());
                                            player.sendMessage(ChatColor.GOLD + "Set survival mode for " + targetPlayer.getDisplayName());
                                        }
                                        case "sp" -> {
                                            targetPlayer.setGameMode(GameMode.SPECTATOR);
                                            targetPlayer.sendMessage(ChatColor.GOLD + "Gamemode set to Spectator by " + player.getDisplayName());
                                            player.sendMessage(ChatColor.GOLD + "Set spectator mode for " + targetPlayer.getDisplayName());
                                        }
                                        case "a" -> {
                                            targetPlayer.setGameMode(GameMode.ADVENTURE);
                                            targetPlayer.sendMessage(ChatColor.GOLD + "Gamemode set to Adventure by " + player.getDisplayName());
                                            player.sendMessage(ChatColor.GOLD + "Set adventure mode for " + targetPlayer.getDisplayName());
                                        }
                                    }

                                } else {

                                    player.sendMessage(ChatColor.RED + "Unknown player.");

                                }

                            }

                        }


                    }

                } else {

                    player.sendMessage(ChatColor.RED + "Unable to execute that command.");

                }

            } else {

                player.sendMessage(ChatColor.RED + "Unable to execute that command.");

            }

        } else {

            System.out.println(ChatColor.RED + "Must be a player to execute this command.");

        }

        return true;
    }

}
