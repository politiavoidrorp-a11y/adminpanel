package me.noxxll.adminpanel;
import org.bukkit.command.*; import org.bukkit.entity.Player;
public final class AdminCommand implements CommandExecutor {
    private final PanelManager panels;
    public AdminCommand(PanelManager panels){this.panels=panels;}
    @Override public boolean onCommand(CommandSender s, Command c, String l, String[] a){
        if(!(s instanceof Player p)){s.sendMessage("Only players can use this command.");return true;}
        if(!p.hasPermission("adminpanel.use")){p.sendMessage(panels.msg("no-permission"));return true;}
        panels.openMain(p); return true;
    }
}