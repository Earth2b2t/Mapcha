package me.affanhaq.mapcha.tasks;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.affanhaq.mapcha.Mapcha;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import static me.affanhaq.mapcha.Config.SUCCESS_SERVER;

public class SendPlayerToServerTask extends BukkitRunnable {

    private static final int DELAY = 15;
    private static final int PERIOD = 10000;
    private static final int MAX_RETRY = 10;
    private final Mapcha mapcha;
    private final Player player;
    private int retry;

    public SendPlayerToServerTask(Mapcha mapcha, Player player) {
        this.mapcha = mapcha;
        this.player = player;
    }

    public void start(Plugin plugin) {
        runTaskTimer(plugin, DELAY, PERIOD);
    }

    @Override
    public void run() {
        if (!player.isValid()) {
            cancel();
            return;
        }

        if (retry > MAX_RETRY) {
            player.kickPlayer(ChatColor.GOLD + "You have been disconnected");
            return;
        }

        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(SUCCESS_SERVER);
        player.sendPluginMessage(mapcha, "BungeeCord", out.toByteArray());
        retry++;
    }
}
