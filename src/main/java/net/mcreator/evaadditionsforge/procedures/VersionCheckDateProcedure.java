package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;

import java.util.Calendar;

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
				if (json.get("send").getAsDouble() == 1) {
					if (json.get("day").getAsDouble() > day || json.get("month").getAsDouble() > month && json.get("day").getAsDouble() >= day
							|| json.get("year").getAsDouble() > year && json.get("month").getAsDouble() >= month && json.get("day").getAsDouble() >= day) {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal((""
									+ ("The next update of Eva Additions will release on " + Math.round(json.get("day").getAsDouble()) + "/" + Math.round(json.get("month").getAsDouble()) + "/" + Math.round(json.get("year").getAsDouble()) + "!"))),
									false);
					}
					if (json.get("day").getAsDouble() == day && json.get("month").getAsDouble() == month && json.get("year").getAsDouble() == year) {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(
									Component.literal(("You are using the right version (" + Math.round(json.get("day").getAsDouble()) + "." + Math.round(json.get("month").getAsDouble()) + "." + Math.round(json.get("year").getAsDouble()) + ")")),
									false);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
