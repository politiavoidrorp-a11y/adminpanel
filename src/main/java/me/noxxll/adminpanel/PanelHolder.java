package me.noxxll.adminpanel;
import org.bukkit.inventory.*;
import java.util.UUID;
public final class PanelHolder implements InventoryHolder {
    private final PanelType type; private final UUID target; private final int page;
    public PanelHolder(PanelType t,UUID u,int p){type=t;target=u;page=p;}
    public PanelType type(){return type;} public UUID target(){return target;} public int page(){return page;}
    @Override public Inventory getInventory(){return null;}
}