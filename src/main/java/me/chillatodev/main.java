package me.chillatodev;

import cn.nukkit.plugin.PluginBase;
import java.io.File;
import java.util.Objects;

public class main extends PluginBase {
    @Override
    public void onEnable() {
        File worldsload = new File("worlds/");
        for(File worldload : Objects.requireNonNull(worldsload.listFiles())) {
            if(worldload.isDirectory()) {
                if(!getServer().isLevelLoaded(worldsload.getName())){
                    getServer().isLevelLoaded(worldsload.getName());
                    getLogger().info("Ho caricato " + worldload.getName());
                }
            }
        }
    }
}
