package net.beefymuscle.craftingmat;

import net.beefymuscle.craftingmat.block.craftingMatBlocks;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeefsCraftingMat implements ModInitializer {
	public static final String MOD_ID = "bcm";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		craftingMatBlocks.registerCraftingMatBlocks();

	}
}