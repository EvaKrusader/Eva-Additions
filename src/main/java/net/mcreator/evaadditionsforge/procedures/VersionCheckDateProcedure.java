package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;

import java.util.Calendar;

import java.net.URL;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class VersionCheckDateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		File file = new File("");
		com.google.gson.JsonObject json = new com.google.gson.JsonObject();
		double day = 0;
		double month = 0;
		double year = 0;
		String url = "";
		day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		month = Calendar.getInstance().get(Calendar.MONTH);
		year = Calendar.getInstance().get(Calendar.YEAR);
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
				if (json.get("send").getAsDouble() >= 1) {
					if (json.get("day").getAsDouble() > day || json.get("month").getAsDouble() > month || json.get("year").getAsDouble() > year) {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList()
									.broadcastSystemMessage(Component.literal(("" + ("The next update of Eva Additions will release on " + "\u00A7a" + Math.round(json.get("day").getAsDouble()) + "/" + Math.round(json.get("month").getAsDouble()) + "/"
											+ Math.round(json.get("year").getAsDouble()) + (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset
											+ "!"))), false);
					} else if (json.get("day").getAsDouble() == day || json.get("month").getAsDouble() == month || json.get("year").getAsDouble() == year) {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList()
									.broadcastSystemMessage(Component.literal(("" + ("The latest update of Eva Additions released on " + "\u00A7b" + Math.round(json.get("day").getAsDouble()) + "/" + Math.round(json.get("month").getAsDouble()) + "/"
											+ Math.round(json.get("year").getAsDouble()) + " (today)"
											+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + "!"))), false);
						{
							boolean _setval = true;
							entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.sendDownload = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (json.get("month").getAsDouble() < month && json.get("day").getAsDouble() <= day || json.get("year").getAsDouble() <= year && json.get("month").getAsDouble() <= month) {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList()
									.broadcastSystemMessage(Component.literal(("" + ("The latest update of Eva Additions released on " + "\u00A7c" + Math.round(json.get("day").getAsDouble()) + "/" + Math.round(json.get("month").getAsDouble()) + "/"
											+ Math.round(json.get("year").getAsDouble()) + (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset
											+ "!"))), false);
						{
							boolean _setval = true;
							entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.sendDownload = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (json.get("send").getAsDouble() == 2) {
						{
							boolean _setval = true;
							entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.sendDownload = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).sendDownload == true) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										("tellraw @a {\"text\":\"Click here to download the new version!\",\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"" + "" + json.get("update").getAsString()
												+ "\"}}"));
							}
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
