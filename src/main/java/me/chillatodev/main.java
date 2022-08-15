package me.chillatodev;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Level;
import cn.nukkit.plugin.PluginBase;
import java.io.File;
import java.util.Map;
import java.util.Objects;

public class main extends PluginBase {
    @Override
    public void onEnable() {
        //this.getServer().getCommandMap().getCommand("world").unregister(getServer().getCommandMap());
        this.getServer().getCommandMap().getCommands().remove("world");
        File worldsload = new File("worlds/");
        for (File worldload : Objects.requireNonNull(worldsload.listFiles())) {
            if (worldload.isDirectory()) {
                if (!getServer().isLevelLoaded(worldsload.getName())) {
                    getServer().isLevelLoaded(worldsload.getName());
                    getLogger().info("Ho caricato " + worldload.getName());
                }
            }
        }
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (sender instanceof Player) {
            switch(command.getName()) {
                case "wl":
                    if(!sender.hasPermission("wl.use")){
                        sender.sendMessage("§l§6Worldloader §7>> §cYou are not permission");
                        return false;
                    } else {
                        sender.sendMessage("§l§6Worldloader §7>> §l§3Mondi nel server:");
                        Map<Integer, Level> level = this.getServer().getLevels();
                        level.forEach((i, l) -> {
                            sender.sendMessage("§b- " + l.getFolderName());
                        });
                    }
            }
            return true;
        }
        return  true;
    }
}
