package data;

//   http://translate.google.it/translate_tts?ie=UTF-8&q=hello+world&tl=[1}&prev=input

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.text.MessageFormat;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import us.monoid.web.BinaryResource;
import us.monoid.web.Resty;

public class tts {

	private static final String BASE_URL = "http://translate.google.com/translate_tts?ie=UTF-8&q={0}&tl={1}&prev=input";

	/*
	 * public static void main(String[] args) { say("My name is jarvis"); }
	 */

	public static void say(String text, String acc) {
		try {
			File f = new File("translate.mp3");
			String sentence = URLEncoder.encode(text, "UTF-8");
			String urlString = MessageFormat.format(BASE_URL, sentence, acc);
			BinaryResource res = new Resty().bytes(new URI(urlString));
			res.save(f);

			FileInputStream in = new FileInputStream(f);

			Player p = new Player(in);

			p.play();

			p.close();
			f.delete();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}

	}
}