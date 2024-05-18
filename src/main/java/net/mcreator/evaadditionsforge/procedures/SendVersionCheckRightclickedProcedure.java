package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.entity.Entity;

public class SendVersionCheckRightclickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		VersionCheckProcedure.execute(entity);
	}
}
