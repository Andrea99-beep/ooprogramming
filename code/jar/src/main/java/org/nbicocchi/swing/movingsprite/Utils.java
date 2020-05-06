package org.nbicocchi.swing.movingsprite;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class Utils {
	public static Image getImage(final String path) {
		final URL url = Thread.currentThread().getContextClassLoader().getResource(path);
		return Toolkit.getDefaultToolkit().getImage(url);
	}

}
