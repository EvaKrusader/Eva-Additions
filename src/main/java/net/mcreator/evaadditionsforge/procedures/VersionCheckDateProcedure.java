package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;

import java.net.URL;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class VersionCheckDateProcedure {
	public static void execute(LevelAccessor world) {
		File file = new File("");
		com.google.gson.JsonObject json = new com.google.gson.JsonObject();
		String url = "";
		double day = 0;
		double month = 0;
		double year = 0;
		day = 20;
		month = 5;
		year = 2024;
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
				if (json.get("day").getAsDouble() > day || json.get("month").getAsDouble() > month && json.get("day").getAsDouble() >= day
						|| json.get("year").getAsDouble() > year && json.get("month").getAsDouble() >= month && json.get("day").getAsDouble() >= day) {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList()
								.broadcastSystemMessage(
										Component.literal((("This version of the mod is outdated. The version " + Math.round(json.get("day").getAsDouble()) + "." + Math.round(json.get("month").getAsDouble()) + "."
												+ Math.round(json.get("year").getAsDouble()) + " of this mod is out!") + "" + (" (You are using the version " + Math.round(day) + "." + Math.round(month) + "." + Math.round(year) + " of this mod)"))),
										false);
				}
				if (json.get("day").getAsDouble() == day && json.get("month").getAsDouble() == month && json.get("year").getAsDouble() == year) {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(
								Component.literal(("You are using the right version (" + Math.round(json.get("day").getAsDouble()) + "." + Math.round(json.get("month").getAsDouble()) + "." + Math.round(json.get("year").getAsDouble()) + ")")), false);
				}
				if (json.get("day").getAsDouble() < day || json.get("month").getAsDouble() < month && json.get("day").getAsDouble() <= day
						|| json.get("year").getAsDouble() < year && json.get("month").getAsDouble() <= month && json.get("day").getAsDouble() <= day) {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(Component.literal((("What??? You are using the version " + Math.round(day) + "." + Math.round(month) + "." + Math.round(year) + " of this mod???") + ""
								+ ("The version " + Math.round(json.get("day").getAsDouble()) + "." + Math.round(json.get("month").getAsDouble()) + "." + Math.round(json.get("year").getAsDouble()) + " of this mod is out!"))), false);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
