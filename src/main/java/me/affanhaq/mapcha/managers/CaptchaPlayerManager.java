package me.affanhaq.mapcha.managers;

import me.affanhaq.mapcha.player.CaptchaPlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public class CaptchaPlayerManager {

    private final List<CaptchaPlayer> playerList = new CopyOnWriteArrayList<>();

    public void add(CaptchaPlayer player) {
        playerList.add(player);
    }

    public void remove(CaptchaPlayer player) {
        playerList.remove(player);
    }

    @Nullable
    public CaptchaPlayer getPlayer(Player player) {
        return playerList.stream()
                .filter(p -> p.getPlayer().getUniqueId() == Objects.requireNonNull(player.getPlayer()).getUniqueId())
                .findFirst()
                .orElse(null);
    }
}
