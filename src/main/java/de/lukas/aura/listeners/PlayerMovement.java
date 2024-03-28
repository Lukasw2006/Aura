package de.lukas.aura.listeners;

import de.lukas.aura.Main;
import org.bukkit.Effect;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;


public class PlayerMovement implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player p = event.getPlayer();

        double radius = 20;
        for (Entity entity : p.getNearbyEntities(radius, radius, radius)) {
            if (entity instanceof Player) {
                Player k = (Player) entity;
                double Ax = p.getLocation().getX();
                double Ay = p.getLocation().getY();
                double Az = p.getLocation().getZ();

                double Bx = k.getLocation().getX();
                double By = k.getLocation().getY();
                double Bz = k.getLocation().getZ();




                if (Main.aura.contains(p.getName()) && Main.aura.contains(k.getName())) {
                } else if (Main.aura.contains(p.getName())){
                    p.getWorld().playEffect(p.getLocation(), Effect.ENDEREYE_LAUNCH, 20);
                    double x = Bx-Ax;
                    double y = By-Ay;
                    double z = Bz-Az;
                    Vector vec = new Vector(x, y ,z).normalize().setY(0.1).multiply(1);
                    k.setVelocity(vec);
                   }else if(Main.aura.contains(k.getName())){
                    p.getWorld().playEffect(p.getLocation(), Effect.ENDEREYE_LAUNCH, 20);
                    double x = Ax-Bx;
                    double y = Ay-By;
                    double z = Az-Bz;
                    Vector vec = new Vector(x, y ,z).normalize().setY(0.1).multiply(1);
                    p.setVelocity(vec);
                }
            }

        }
    }

}
