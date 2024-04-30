package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.evaadditionsforge.init.EvaAdditionsModBlocks;

public class MiningAidBlockDestroyedByPlayerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:mining_aid_blocks")))) {
			{
				BlockPos _pos = BlockPos.containing(x, y - 1, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
				world.destroyBlock(_pos, false);
			}
			if ((world.getBlockState(BlockPos.containing(x, y - 2, z))).is(BlockTags.create(new ResourceLocation("minecraft:mining_aid_off")))) {
				world.setBlock(BlockPos.containing(x, y - 1, z), EvaAdditionsModBlocks.MINING_AID_STOP.get().defaultBlockState(), 3);
			} else {
				world.setBlock(BlockPos.containing(x, y - 1, z), EvaAdditionsModBlocks.MINING_AID.get().defaultBlockState(), 3);
			}
		}
	}
}
