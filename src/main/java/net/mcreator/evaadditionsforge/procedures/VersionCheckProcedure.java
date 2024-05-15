package net.mcreator.evaadditionsforge.procedures;

import org.checkerframework.checker.units.qual.s;

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
		File file = new File("");
		com.google.gson.JsonObject json = new com.google.gson.JsonObject();
		String url = "";
		double ver1 = 0;
		double ver2 = 0;
		double ver3 = 0;
		double currentVersion = 0;
		double nextVersion = 0;
		ver1 = 0;
		ver2 = 1;
		ver3 = 1;
		{
			String _setval = (new java.text.DecimalFormat("#").format((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ver1) + ".") + ""
					+ (new java.text.DecimalFormat("#").format((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ver2) + ".")
					+ new java.text.DecimalFormat("#").format((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ver3);
			entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.currentVersion = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
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
				{
					String _setval = (new java.text.DecimalFormat("#").format(Math.round(json.get("ver1").getAsDouble())) + ".") + "" + (new java.text.DecimalFormat("#").format(Math.round(json.get("ver2").getAsDouble())) + ".")
							+ new java.text.DecimalFormat("#").format(Math.round(json.get("ver3").getAsDouble()));
					entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.nextVersion = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				currentVersion = new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(new java.text.DecimalFormat("#").format((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ver1) + ""
						+ new java.text.DecimalFormat("#").format((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ver2)
						+ new java.text.DecimalFormat("#").format((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ver3));
				nextVersion = new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(Math.round(json.get("ver1").getAsDouble()) + "" + Math.round(json.get("ver2").getAsDouble()) + Math.round(json.get("ver3").getAsDouble()));
				if (nextVersion > currentVersion) {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("This version of the mod is outdated."), false);
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(
								Component.literal(("You are using the version " + "\u00A7c" + (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).currentVersion
										+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " of this mod.")),
								false);
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(
								Component.literal(("The version " + "\u00A7a" + (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).nextVersion
										+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " of this mod is out!")),
								false);
					{
						boolean _setval = true;
						entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.sendOutMessage = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						boolean _setval = true;
						entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.SendDOwnloadLink = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (nextVersion == currentVersion) {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList()
								.broadcastSystemMessage(Component.literal(("You are using the right version of this mod! (" + "\u00A7b"
										+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).nextVersion
										+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ")")), false);
				} else if (nextVersion < currentVersion) {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList()
								.broadcastSystemMessage(Component.literal(("You are somehow using an unreleased version of this mod (\u00A7e"
										+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).currentVersion
										+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ")")), false);
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList()
								.broadcastSystemMessage(Component.literal(
										("The current version of this mod is " + "\u00A7a" + (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).nextVersion
												+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ".")),
										false);
					{
						boolean _setval = false;
						entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.sendOutMessage = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		VersionCheckDateProcedure.execute(world, entity);
		ChooseAptitudeProcedure.execute(entity);
	}
}
