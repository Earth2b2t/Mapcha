package me.affanhaq.mapcha;

import me.affanhaq.keeper.data.ConfigFile;
import me.affanhaq.keeper.data.ConfigValue;

import java.util.Arrays;
import java.util.List;

import static org.bukkit.ChatColor.GREEN;
import static org.bukkit.ChatColor.RED;
import static org.bukkit.ChatColor.RESET;
import static org.bukkit.ChatColor.YELLOW;

@ConfigFile("config.yml")
public class Config {

    public static String BYPASS_PERMISSION = "mapcha.bypass";

    @ConfigValue("title")
    public static String TITLE = "Captcha";

    @ConfigValue("prefix")
    public static String PREFIX = "[" + GREEN + "Mapcha" + RESET + "]";

    @ConfigValue("commands")
    public static List<String> ALLOWED_COMMANDS = Arrays.asList("/register", "/login");

    @ConfigValue("captcha.cache")
    public static boolean USE_CACHE = true;

    @ConfigValue("captcha.font_name")
    public static String FONT_NAME = "Consolas";

    @ConfigValue("captcha.tries")
    public static int TRIES = 3;

    @ConfigValue("captcha.time")
    public static int TIME_LIMIT = 30;

    @ConfigValue("captcha.teleport_to_highest")
    public static boolean TELEPORT_TO_HIGHEST = false;

    @ConfigValue("server.enabled")
    public static boolean SEND_TO_SERVER = false;

    @ConfigValue("server.name")
    public static String SUCCESS_SERVER = "";

    @ConfigValue("messages.success")
    public static String MESSAGE_SUCCESS = "Captcha " + GREEN + "solved!";

    @ConfigValue("messages.retry")
    public static String MESSAGE_RETRY = "Captcha " + YELLOW + "failed, " + RESET + "please try again. ({CURRENT}/{MAX})";

    @ConfigValue("messages.fail")
    public static String MESSAGE_FAIL = "Captcha " + RED + "failed!";

    @ConfigValue("styles.invert_color")
    public static boolean INVERT_COLOR = false;

    @ConfigValue("styles.points")
    public static boolean POINTS = true;

    @ConfigValue("styles.lines")
    public static boolean LINES = true;

}
