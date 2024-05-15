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
		boolean SendDownload = false;
		double day = 0;
		double month = 0;
		double year = 0;
		double len1 = 0;
		double len2 = 0;
		double len3 = 0;
		String url = "";
		String p1 = "";
		String p2 = "";
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
				len1 = (new java.text.DecimalFormat("##").format(Math.round(json.get("day").getAsDouble()))).length();
				len2 = (new java.text.DecimalFormat("##").format(Math.round(json.get("month").getAsDouble()))).length();
				len3 = (new java.text.DecimalFormat("##").format(Math.round(json.get("year").getAsDouble()))).length();
				if (len1 == 1) {
					p1 = "00" + new java.text.DecimalFormat("##").format(Math.round(json.get("day").getAsDouble()));
				} else if (len1 == 2) {
					p1 = "0" + new java.text.DecimalFormat("##").format(Math.round(json.get("day").getAsDouble()));
				}
				if (len2 == 1) {
					p2 = "00" + new java.text.DecimalFormat("##").format(Math.round(json.get("month").getAsDouble()));
				} else if (len2 == 2) {
					p2 = "0" + new java.text.DecimalFormat("##").format(Math.round(json.get("month").getAsDouble()));
				}
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("DATE TEST " + (p1 + "/" + p2 + "/" + new java.text.DecimalFormat("##").format(Math.round(json.get("year").getAsDouble()))))), false);
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("SUBSTRING" + ((p1 + "/" + p2 + "/" + new java.text.DecimalFormat("##").format(Math.round(json.get("year").getAsDouble()))).substring(1, 3) + "/"
							+ (p1 + "/" + p2 + "/" + new java.text.DecimalFormat("##").format(Math.round(json.get("year").getAsDouble()))).substring(5, 7)))), false);
				if (json.get("send").getAsDouble() >= 1) {
					if (json.get("day").getAsDouble() > day || json.get("month").getAsDouble() > month || json.get("year").getAsDouble() > year) {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList()
									.broadcastSystemMessage(Component.literal((("The next update of Eva Additions will release on " + "\u00A7a" + Math.round(json.get("day").getAsDouble()) + "/" + Math.round(json.get("month").getAsDouble()) + "/"
											+ Math.round(json.get("year").getAsDouble()) + (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + "!")
											+ "" + (" (" + "\u00A7a" + Math.round(json.get("ver1").getAsDouble()) + "." + Math.round(json.get("ver2").getAsDouble()) + "." + Math.round(json.get("ver3").getAsDouble())
													+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ")"))),
											false);
					} else if (json.get("day").getAsDouble() == day || json.get("month").getAsDouble() == month || json.get("year").getAsDouble() == year) {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList()
									.broadcastSystemMessage(Component.literal(("" + ("The latest update of Eva Additions released on " + "\u00A7b" + Math.round(json.get("day").getAsDouble()) + "/" + Math.round(json.get("month").getAsDouble()) + "/"
											+ Math.round(json.get("year").getAsDouble()) + " (today)"
											+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + "!"))), false);
						SendDownload = true;
					} else if (json.get("month").getAsDouble() < month && json.get("day").getAsDouble() <= day || json.get("year").getAsDouble() <= year && json.get("month").getAsDouble() <= month) {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList()
									.broadcastSystemMessage(Component.literal(("" + ("The latest update of Eva Additions released on " + "\u00A7c" + Math.round(json.get("day").getAsDouble()) + "/" + Math.round(json.get("month").getAsDouble()) + "/"
											+ Math.round(json.get("year").getAsDouble()) + (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset
											+ "!"))), false);
						SendDownload = true;
					}
					if (json.get("send").getAsDouble() == 2) {
						SendDownload = true;
					}
					if (SendDownload == true) {
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
