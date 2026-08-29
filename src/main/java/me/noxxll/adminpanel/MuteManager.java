package me.noxxll.adminpanel;
import org.bukkit.configuration.file.YamlConfiguration; import org.bukkit.plugin.java.JavaPlugin;
import java.io.*; import java.util.*;
public final class MuteManager {
    private final JavaPlugin plugin; private final File file; private final Map<UUID,Long> mutes=new HashMap<>();
    public MuteManager(JavaPlugin p){plugin=p;file=new File(p.getDataFolder(),"mutes.yml");}
    public void load(){mutes.clear(); if(!file.exists())return; YamlConfiguration c=YamlConfiguration.loadConfiguration(file);
        if(c.isConfigurationSection("mutes")) for(String k:c.getConfigurationSection("mutes").getKeys(false)) try{
            UUID u=UUID.fromString(k); long t=c.getLong("mutes."+k); if(t==-1||t>System.currentTimeMillis())mutes.put(u,t);
        }catch(Exception ignored){} save();}
    public void save(){if(!plugin.getDataFolder().exists())plugin.getDataFolder().mkdirs(); YamlConfiguration c=new YamlConfiguration();
        mutes.forEach((u,t)->c.set("mutes."+u,t)); try{c.save(file);}catch(IOException e){plugin.getLogger().warning("Could not save mutes.yml");}}
    public void mute(UUID u,long s){mutes.put(u,s<0?-1:System.currentTimeMillis()+s*1000L);save();}
    public void unmute(UUID u){mutes.remove(u);save();}
    public boolean isMuted(UUID u){Long t=mutes.get(u); if(t==null)return false; if(t==-1)return true; if(t>System.currentTimeMillis())return true; mutes.remove(u);save();return false;}
}