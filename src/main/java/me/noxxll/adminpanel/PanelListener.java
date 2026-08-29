package me.noxxll.adminpanel;
import org.bukkit.Bukkit; import org.bukkit.entity.Player; import org.bukkit.event.*; import org.bukkit.event.inventory.InventoryClickEvent; import org.bukkit.event.player.AsyncPlayerChatEvent; import java.util.*;
public final class PanelListener implements Listener {
    private final AdminPanel plugin; private final PanelManager p; private final MuteManager m;
    public PanelListener(AdminPanel x,PanelManager p,MuteManager m){plugin=x;this.p=p;this.m=m;}
    @EventHandler(priority=EventPriority.HIGHEST) public void chat(AsyncPlayerChatEvent e){if(m.isMuted(e.getPlayer().getUniqueId())){e.setCancelled(true);e.getPlayer().sendMessage(p.color("&cYou are muted."));}}
    @EventHandler public void click(InventoryClickEvent e){if(!(e.getWhoClicked() instanceof Player a))return;if(!(e.getInventory().getHolder() instanceof PanelHolder h))return;e.setCancelled(true);int s=e.getRawSlot();if(s<0)return;
        switch(h.type()){case MAIN->{if(s==11)p.openPlayers(a,0);}case PLAYERS->{if(s==40)p.openMain(a);else if(s==39)p.openPlayers(a,h.page()-1);else if(s==41)p.openPlayers(a,h.page()+1);else if(s<36){Player t=at(h.page(),s);if(t!=null)p.openPlayer(a,t);}}
        case PLAYER->{Player t=on(h.target());if(t==null)return;switch(s){case 10->p.durationMenu(a,t,true);case 11->p.durationMenu(a,t,false);case 12->p.kick(a,t);case 14->p.teleport(a,t);case 15->p.spectate(a,t);case 16->p.openInventory(a,t);case 20->p.unmute(a,t);case 31->p.openPlayers(a,0);}}
        case BAN->{Player t=on(h.target());if(t==null)return;long[] d={600,3600,86400,604800,-1};if(s==10)p.ban(a,t,d[0]);else if(s==11)p.ban(a,t,d[1]);else if(s==12)p.ban(a,t,d[2]);else if(s==14)p.ban(a,t,d[3]);else if(s==16)p.ban(a,t,-1);else if(s==22)p.openPlayer(a,t);}
        case MUTE->{Player t=on(h.target());if(t==null)return;long[] d={600,3600,86400,604800,-1};if(s==10)p.mutePlayer(a,t,d[0]);else if(s==11)p.mutePlayer(a,t,d[1]);else if(s==12)p.mutePlayer(a,t,d[2]);else if(s==14)p.mutePlayer(a,t,d[3]);else if(s==16)p.mutePlayer(a,t,-1);else if(s==22)p.openPlayer(a,t);}
        case INVENTORY->{if(s==53){Player t=on(h.target());if(t!=null)p.openPlayer(a,t);}}}}
    private Player at(int page,int slot){List<Player>x=new ArrayList<>(Bukkit.getOnlinePlayers());x.sort(Comparator.comparing(Player::getName,String.CASE_INSENSITIVE_ORDER));int i=page*36+slot;return i>=0&&i<x.size()?x.get(i):null;}
    private Player on(UUID u){return u==null?null:Bukkit.getPlayer(u);}
}