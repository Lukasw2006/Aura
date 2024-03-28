package de.lukas.aura.command;

import de.lukas.aura.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AuraCommand implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player)sender;
            if(player.hasPermission("Aura.User")){
                if(args.length == 0) {
                    if (Main.aura.contains(player.getName())) {

                        Main.aura.remove(player.getName());
                        player.sendMessage("§bSchutzschild §cDeaktiviert!");
                    } else {
                        Main.aura.add(player.getName());
                        player.sendMessage("§bSchutzschild §aAktiviert!");


                    }
                }else
                    player.sendMessage("§b§lVerwendung /aura");
            }else
                player.sendMessage("§cDazu hast du keine Rechte");
        }
        return false;
    }
}
