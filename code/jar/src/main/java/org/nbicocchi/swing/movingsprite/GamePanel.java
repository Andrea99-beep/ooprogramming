package org.nbicocchi.swing.movingsprite;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	BufferedImage image;
	int xLock, yLock, rLock;

	public GamePanel(Dimension d, String path) {
		super();
		setPreferredSize(d);
		setBackground(Color.black);

		this.xLock = 0;
		this.yLock = 0;
		try {
			this.image = ImageIO.read(getClass().getResource(path));
			this.rLock = image.getWidth();
			if (image.getWidth() != image.getHeight()) {
				throw new IllegalArgumentException();
			}
		} catch (IOException e) {
			this.image = null;
			this.rLock = 50;
		} catch (IllegalArgumentException e) {
			this.image = null;
			this.rLock = 50;
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (image != null) {
			g.drawImage(image, xLock, yLock, null);
		} else {
			g.setColor(Color.red);
			g.fillOval(xLock, yLock, rLock, rLock);
		}
	}
}