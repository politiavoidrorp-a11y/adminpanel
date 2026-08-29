package me.noxxll.adminpanel;
import org.bukkit.plugin.java.JavaPlugin;
public final class AdminPanel extends JavaPlugin {
    private MuteManager muteManager;
    private PanelManager panelManager;
    @Override public void onEnable() {
        saveDefaultConfig();
        muteManager = new MuteManager(this); muteManager.load();
        panelManager = new PanelManager(this, muteManager);
        getCommand("admin").setExecutor(new AdminCommand(panelManager));
        getServer().getPluginManager().registerEvents(new PanelListener(this, panelManager, muteManager), this);
        getLogger().info("KELPMC ADMIN PANEL enabled.");
    }
    @Override public void onDisable() { if (muteManager != null) muteManager.save(); }
}