package org.devoxx4kids.forge.mods;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = MainMod.MODID, version = MainMod.VERSION)
public class MainMod {
	public static final String MODID = "MyMods";
	public static final String VERSION = "1.0";
	private static final String baseURI = "http://localhost:8080/tnt-bomber-rest/webresources/tnt";
	private static final String tntCountURI = baseURI + "/count";
	private static final String tntSpreadXURI = baseURI + "/spreadx";
	private static final String tntSpreadYURI = baseURI + "/spready";
	private static final String tntSpreadZURI = baseURI + "/spreadz";

	private static InputStream getStream;

	@EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new TNTBomber());
	}

	public static int getTNTCount() {
		return readInteger(tntCountURI);
	}

	public static int getTNTSpreadX() {
		return readInteger(tntSpreadXURI);
	}

	public static int getTNTSpreadY() {
		return readInteger(tntSpreadYURI);
	}

	public static int getTNTSpreadZ() {
		return readInteger(tntSpreadZURI);
	}

	private static int readInteger(String endpointAddress) {
		try {
			byte[] bytes = new byte[10];
			int read = getEndpoint(endpointAddress).read(bytes);
			return Integer.parseInt(new String(bytes, 0, read));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static InputStream getEndpoint(String endpointAddress)
			throws MalformedURLException, IOException {
		URL url = new URL(endpointAddress);
		HttpURLConnection httpConnection = (HttpURLConnection) url
				.openConnection();
		httpConnection.setDoInput(true);
		httpConnection.setDoOutput(true);
		httpConnection.setRequestMethod("GET");
		return httpConnection.getInputStream();
	}
}