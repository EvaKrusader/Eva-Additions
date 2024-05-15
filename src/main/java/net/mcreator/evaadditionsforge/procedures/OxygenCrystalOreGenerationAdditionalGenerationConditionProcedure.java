package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class OxygenCrystalOreGenerationAdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		sx = -1;
		found = false;
		for (int index0 = 0; index0 < 2; index0++) {
			sy = -1;
			for (int index1 = 0; index1 < 2; index1++) {
				sz = -1;
				for (int index2 = 0; index2 < 2; index2++) {
					if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.CAVE_AIR) {
						found = true;
					}
					sz = sz + 2;
				}
				sy = sy + 2;
			}
			sx = sx + 2;
		}
		if (found == true) {
			return true;
		}
		return false;
	}
}
