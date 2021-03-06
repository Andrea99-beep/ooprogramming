package Puzzle;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Puzzle extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private final int XTILES = 5;
	private final int YTILES = 10;
	private final int TILE_WIDTH = 100;
	private final int TILE_HEIGHT = 50;
	private final String filename = "extra/cow.jpg";

	private JPanel panel;
	private ArrayList<ImageButton> buttons;

	public Puzzle() {
		super("Puzzle");
		buttons = new ArrayList<ImageButton>();
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.gray));
		panel.setLayout(new GridLayout(YTILES, XTILES, 0, 0));
		add(panel, BorderLayout.CENTER);

		Image source = null;
		BufferedImage resized = null;
		
		try {
			source = ImageIO.read(new File(filename));
			resized = new BufferedImage(
					XTILES * TILE_WIDTH, 
					YTILES * TILE_HEIGHT,
					BufferedImage.TYPE_INT_ARGB);

			Graphics2D g = resized.createGraphics();
			g.drawImage(source, 0, 0, XTILES * TILE_WIDTH, YTILES * TILE_HEIGHT, null);
			g.dispose();
		} catch (IOException ex) {
			Logger.getLogger(Puzzle.class.getName()).log(Level.SEVERE, null, ex);
		}

		for (int i = 0; i < YTILES; i++) {
			for (int j = 0; j < XTILES; j++) {
				Image image = createImage(new FilteredImageSource(resized.getSource(),
						new CropImageFilter(j * TILE_WIDTH, 
								i * TILE_HEIGHT,
								TILE_WIDTH, TILE_HEIGHT)));

				ImageButton button = null;
				if (i == YTILES-1 && j == XTILES-1) {
					// empty tile
					button = new ImageButton(i, j);
					button.setBorderPainted(false);
					button.setContentAreaFilled(false);
					button.setEmptyButton();
				} else {
					// image tiles
					button = new ImageButton(image, i, j);
				} 

				button.setBorder(BorderFactory.createLineBorder(Color.gray));
				button.addActionListener(this);
				panel.add(button);
				buttons.add(button);
			}
		}
		pack();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// look for empty button
		int lidx = 0;
		for (ImageButton button : buttons) {
			if (button.isEmptyButton()) {
				lidx = buttons.indexOf(button);
			}
		}

		// look for clicked button
		JButton button = (JButton) e.getSource();
		int bidx = buttons.indexOf(button);

		// eventually swap
		if ((bidx - 1 == lidx) || (bidx + 1 == lidx) || (bidx - XTILES == lidx) || (bidx + XTILES == lidx)) {
			Collections.swap(buttons, bidx, lidx);
		}

		// repaint panel
		panel.removeAll();
		for (JComponent btn : buttons) {
			panel.add(btn);
		}
		panel.validate();

		// check for end game
		checkSolution();
	}

	private void checkSolution() {
		ArrayList<Point> current = new ArrayList<Point>();
		for (ImageButton btn : buttons) {
			current.add(btn.getPoint());
		}

		ArrayList<Point> solution = new ArrayList<Point>();
		for (int i = 0; i < YTILES; i++) {
			for (int j = 0; j < XTILES; j++) {
				solution.add(new Point(i, j));
			}
		}

		if (current.equals(solution)) {
			JOptionPane.showMessageDialog(this, "Finished",
					"Congratulation", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
