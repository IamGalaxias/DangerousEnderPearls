package nl.galaxias.dangerousenderpearls;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

/**
 * Created by Galaxias on 10-04-15 (16:41).
 * This file is part of DangerousEnderPearls in the package nl.galaxias.dangerousenderpearls.
 */
public class ProjectileHitListener implements Listener {
    @EventHandler
    public void onProjectileHit(ProjectileHitEvent e) {
        double damage = DangerousEnderPearls.getPlugin().getConfig().getDouble("damage");

        if (e.getEntityType() == EntityType.ENDER_PEARL) {
            Location l = e.getEntity().getLocation();
            l.getWorld().createExplosion(l, (float) damage);
        }
    }
}