/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dl4jdream;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author psyriccio
 */
public class ImagePanel extends JPanel {
  
  private BufferedImage image;

  public ImagePanel(BufferedImage image) {
    this.image = image;
  }

  public ImagePanel() {
    this.image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
  }

  @Override
  public void paint(Graphics g) {
    g.drawImage(image, 0, 0, this);
  }

  public BufferedImage getImage() {
    return image;
  }

  public void setImage(BufferedImage image) {
    this.image = image;
  }
  
}
