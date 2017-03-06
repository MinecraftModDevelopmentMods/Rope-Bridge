package com.mrtrollnugnug.ropebridge.handler;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.FMLClientHandler;

public final class ConfigurationHandler
{

    /**
     * An instance of the Configuration object being used.
     */
    private static Configuration config = null;
    private static int maxBridgeDistance;
    private static int bridgeDroopFactor;
    private static float bridgeYOffset;
    private static boolean zoomOnAim;
    private static boolean breakThroughBlocks;
    private static boolean ignoreSlopeWarnings;
    private static boolean customAchievements;
    private static float slabsPerBlock;
    private static float stringPerBlock;

    /**
     * Initializes the configuration file.
     *
     * @param file
     *            The file to read/write config stuff to.
     */
    public static void initConfig(File file)
    {

        setConfig(new Configuration(file));
        syncConfig();
    }

    /**
     * Syncs all configuration properties.
     */
    public static void syncConfig()
    {

        setMaxBridgeDistance(getConfig().getInt("maxBridgeDistance", Configuration.CATEGORY_GENERAL, 400, 1, 1000, "Max length of bridges made be Grappling Gun."));
        setBridgeDroopFactor(getConfig().getInt("bridgeDroopFactor", Configuration.CATEGORY_GENERAL, 100, 0, 100, "Percent of slack the bridge will have, causing it to hang."));
        setBridgeYOffset(getConfig().getFloat("bridgeYOffset", Configuration.CATEGORY_GENERAL, -0.3F, -1.00F, 1.00F, "Generated bridges will be raised or lowered by this ammount in blocks.\nDefault is just below user's feet."));
        setZoomOnAim(getConfig().getBoolean("zoomOnAim", Configuration.CATEGORY_CLIENT, true, "WARNING - might cause problems with optifine. Due to restrictions in Minecrafts code, you won't be able to change your fov once enabled either."));
        setBreakThroughBlocks(getConfig().getBoolean("breakThroughBlocks", Configuration.CATEGORY_GENERAL, false, "If enabled, all blocks that dare stand in a bridge's way will be broken.\nVery useful in creative mode."));
        setIgnoreSlopeWarnings(getConfig().getBoolean("ignoreSlopeWarnings", Configuration.CATEGORY_GENERAL, false, "Set true to ignore all slope warnings and allow building of very steep bridges."));
        setCustomAchievements(getConfig().getBoolean("customAchievements", Configuration.CATEGORY_GENERAL, true, "Custom crafting and building achievements."));
        setSlabsPerBlock(getConfig().getInt("slabsPerBlock", Configuration.CATEGORY_GENERAL, 1, 0, 10, "Slabs consumed for every bridge block built."));
        setStringPerBlock(getConfig().getInt("stringPerBlock", Configuration.CATEGORY_GENERAL, 2, 0, 20, "String consumed for every bridge block built."));
        setZoomOnAim(!FMLClientHandler.instance().hasOptifine());

        if (getConfig().hasChanged())
            getConfig().save();
    }

	public static float getSlabsPerBlock() {
		return slabsPerBlock;
	}

	public static void setSlabsPerBlock(float slabsPerBlock) {
		ConfigurationHandler.slabsPerBlock = slabsPerBlock;
	}

	public static float getStringPerBlock() {
		return stringPerBlock;
	}

	public static void setStringPerBlock(float stringPerBlock) {
		ConfigurationHandler.stringPerBlock = stringPerBlock;
	}

	public static Configuration getConfig() {
		return config;
	}

	public static void setConfig(Configuration config) {
		ConfigurationHandler.config = config;
	}

	public static boolean isZoomOnAim() {
		return zoomOnAim;
	}

	public static void setZoomOnAim(boolean zoomOnAim) {
		ConfigurationHandler.zoomOnAim = zoomOnAim;
	}

	public static boolean isIgnoreSlopeWarnings() {
		return ignoreSlopeWarnings;
	}

	public static void setIgnoreSlopeWarnings(boolean ignoreSlopeWarnings) {
		ConfigurationHandler.ignoreSlopeWarnings = ignoreSlopeWarnings;
	}

	public static int getBridgeDroopFactor() {
		return bridgeDroopFactor;
	}

	public static void setBridgeDroopFactor(int bridgeDroopFactor) {
		ConfigurationHandler.bridgeDroopFactor = bridgeDroopFactor;
	}

	public static float getBridgeYOffset() {
		return bridgeYOffset;
	}

	public static void setBridgeYOffset(float bridgeYOffset) {
		ConfigurationHandler.bridgeYOffset = bridgeYOffset;
	}

	public static boolean isBreakThroughBlocks() {
		return breakThroughBlocks;
	}

	public static void setBreakThroughBlocks(boolean breakThroughBlocks) {
		ConfigurationHandler.breakThroughBlocks = breakThroughBlocks;
	}

	public static int getMaxBridgeDistance() {
		return maxBridgeDistance;
	}

	public static void setMaxBridgeDistance(int maxBridgeDistance) {
		ConfigurationHandler.maxBridgeDistance = maxBridgeDistance;
	}

	public static boolean isCustomAchievements() {
		return customAchievements;
	}

	public static void setCustomAchievements(boolean customAchievements) {
		ConfigurationHandler.customAchievements = customAchievements;
	}
}