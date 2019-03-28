package jantar;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author Isadora, Luis e Samara
 */
public class JantarDosFilosofos extends JFrame {
    
    private static BufferedImage img;
    
    public JantarDosFilosofos(BufferedImage img[]) {
    	//criando novo designer
        add(new Design(img)); 
        setTitle("E aí? Qual Einstein você é hoje!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(680, 620);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args) {
        try {
            BufferedImage img[] = new BufferedImage[11];
            img[0] = ImageIO.read(JantarDosFilosofos.class.getResourceAsStream("einstein1.jpg"));
            img[1] = ImageIO.read(JantarDosFilosofos.class.getResourceAsStream("einstein2.jpg"));
            img[2] = ImageIO.read(JantarDosFilosofos.class.getResourceAsStream("einstein3.jpg"));
            img[3] = ImageIO.read(JantarDosFilosofos.class.getResourceAsStream("einstein4.jpg"));
            img[4] = ImageIO.read(JantarDosFilosofos.class.getResourceAsStream("einstein5.jpg"));
            img[5] = ImageIO.read(JantarDosFilosofos.class.getResourceAsStream("sushi.jpg"));
            img[6] = ImageIO.read(JantarDosFilosofos.class.getResourceAsStream("hashi1.png"));
            //na posição do array 7 não tem hashi na mesa
            img[8] = ImageIO.read(JantarDosFilosofos.class.getResourceAsStream("hashi3.png"));
            img[9] = ImageIO.read(JantarDosFilosofos.class.getResourceAsStream("hashi2.png"));
          
            new JantarDosFilosofos(img);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
    }
}
