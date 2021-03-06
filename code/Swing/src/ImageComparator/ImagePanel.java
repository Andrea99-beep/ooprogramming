package ImageComparator;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private BufferedImage image = null;
	
	public BufferedImage getImage() {
		return image;
	}
	
	public void setImage(BufferedImage image) {
		this.image = image;
		this.repaint();
		this.revalidate();
	}
	
	@Override
	public Dimension getPreferredSize() {
		if (image == null) {
			return new Dimension();		
		}
		return new Dimension(image.getWidth(), image.getHeight());
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null) {
			g.drawImage(image, 0, 0, null);  	
		}

	}

}