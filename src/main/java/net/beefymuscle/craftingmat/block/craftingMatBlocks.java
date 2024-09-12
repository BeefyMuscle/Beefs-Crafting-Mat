package net.beefymuscle.craftingmat.block;

import com.mojang.serialization.MapCodec;
import net.beefymuscle.craftingmat.BeefsCraftingMat;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class craftingMatBlocks {

    public static final Block CRAFTING_MAT = registerBlock("crafting_mat",
            new CraftingMat(AbstractBlock.Settings.create()
                    .mapColor(MapColor.OAK_TAN)
                    .strength(2.5F)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()) {
            });


    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(BeefsCraftingMat.MOD_ID, name), block);

    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(BeefsCraftingMat.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }


    public static void registerCraftingMatBlocks() {
        BeefsCraftingMat.LOGGER.info("Registering Blocks for " + BeefsCraftingMat.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((entries -> {
            entries.add(craftingMatBlocks.CRAFTING_MAT);
        }));
    }
}
