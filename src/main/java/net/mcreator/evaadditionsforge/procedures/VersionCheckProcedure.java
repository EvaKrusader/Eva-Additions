package net.mcreator.evaadditionsforge.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;

import javax.annotation.Nullable;

import java.net.URL;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

@Mod.EventBusSubscriber
public class VersionCheckProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double ver1 = 0;
		double ver2 = 0;
		double ver3 = 0;
		File file = new File("");
		com.google.gson.JsonObject json = new com.google.gson.JsonObject();
		String url = "";
		ver1 = 0;
		ver2 = 1;
		ver3 = 1;
		file = new File(System.getProperty("java.io.tmpdir"), File.separator + "modver.json");
		url = "https://raw.githubusercontent.com/EvaKrusader/Eva-Additions/master/src/main/modver.json";
		try {
			org.apache.commons.io.FileUtils.copyURLToFile(new URL(url), file, 1000, 1000);
		} catch (IOException e) {
			e.printStackTrace();
		}
		{
			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
				StringBuilder jsonstringbuilder = new StringBuilder();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					jsonstringbuilder.append(line);
				}
				bufferedReader.close();
				json = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
				if (json.get("ver1").getAsDouble() > ver1 || json.get("ver2").getAsDouble() > ver2 && json.get("ver1").getAsDouble() >= ver1
						|| json.get("ver3").getAsDouble() > ver3 && json.get("ver2").getAsDouble() >= ver2 && json.get("ver1").getAsDouble() >= ver1) {
					if (json.get("send").getAsDouble() >= 1) {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("This version of the mod is outdated."), false);
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(
									Component.literal(("The version " + "\u00A7a" + Math.round(json.get("ver1").getAsDouble()) + "." + Math.round(json.get("ver2").getAsDouble()) + "." + Math.round(json.get("ver3").getAsDouble())
											+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " of this mod is out!")),
									false);
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("You are using the version " + "\u00A7c" + Math.round(ver1) + "." + Math.round(ver2) + "." + Math.round(ver3)
									+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " of this mod")), false);
					}
				}
				if (json.get("ver1").getAsDouble() == ver1 && json.get("ver2").getAsDouble() == ver2 && json.get("ver3").getAsDouble() == ver3) {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList()
								.broadcastSystemMessage(Component.literal(("You are using the right version of this mod! (" + "\u00A7b" + Math.round(json.get("ver1").getAsDouble()) + "." + Math.round(json.get("ver2").getAsDouble()) + "."
										+ Math.round(json.get("ver3").getAsDouble()) + (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ")")),
										false);
				}
				if (json.get("ver1").getAsDouble() < ver1 || json.get("ver2").getAsDouble() < ver2 && json.get("ver1").getAsDouble() <= ver1
						|| json.get("ver3").getAsDouble() < ver3 && json.get("ver2").getAsDouble() <= ver2 && json.get("ver1").getAsDouble() <= ver1) {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("You are somehow using an unreleased version of this mod (\u00A7e" + Math.round(ver1) + "." + Math.round(ver2) + "." + Math.round(ver3)
								+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ")")), false);
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList()
								.broadcastSystemMessage(Component.literal(("The version " + "\u00A7a" + Math.round(json.get("ver1").getAsDouble()) + "." + Math.round(json.get("ver2").getAsDouble()) + "." + Math.round(json.get("ver3").getAsDouble())
										+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " of this mod is out!")), false);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		VersionCheckDateProcedure.execute(world, entity);
		ChooseAptitudeProcedure.execute(entity);
	}
}
