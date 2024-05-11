package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.client.Minecraft;

import net.mcreator.evaadditionsforge.client.toasts.PowerUpperToastToast;

public class AptitudeOreBlockDestroyedByPlayerProcedure {
	public static void execute() {
		Minecraft.getInstance().getToasts().addToast(new PowerUpperToastToast());
	}
}
