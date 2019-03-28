package jantar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Isadora, Luis e Samara
 */
public class Design extends JPanel implements Runnable {
	

    String text = "STATUS";
    Thread sketch; //thread principal da aplicação

    private BufferedImage img[];
    public static Semaphore mutex = new Semaphore(1); //semaforo principal da aplicação que inicia o contador com 1
    public static Semaphore[] semaphores = new Semaphore[5]; //vetor p/ definir um semaforo para cada filosofo que será criado e inicia o contato com 0
    public static int[] status = new int[5]; //define o estado de cada filosofo na aplicacao
    static Philosopher[] philosophers = new Philosopher[5]; //criacao de 5 filosofos

    //metodo construtor para designer da aplicação e suas definições
    public Design(BufferedImage img[]) {
        this.setFocusable(true);
        this.setSize(680, 620);
        this.setBackground(Color.white);
        this.init();
        this.img = img;
    }

    public void init() {
        for (int i = 0; i < status.length; i++) {
            status[i] = 0; //inicia todos os estados para 0 
        }
        if (sketch == null) {
            sketch = new Thread(this); //verifica se a thread da animação é vazia, se não cria uma nova thread
            sketch.start(); //inicia execução
        }

        //define a prioridade principal para esta thread atual
        Thread.currentThread().setPriority(1); 

        //instanciando os filosofos
        philosophers[0] = new Philosopher("Filosofo 1", 0);
        philosophers[1] = new Philosopher("Filosofo 2", 1);
        philosophers[2] = new Philosopher("Filosofo 3", 2);
        philosophers[3] = new Philosopher("Filosofo 4", 3);
        philosophers[4] = new Philosopher("Filosofo 5", 4);

        //instanciando os semafaros
        semaphores[0] = new Semaphore(0);
        semaphores[1] = new Semaphore(0);
        semaphores[2] = new Semaphore(0);
        semaphores[3] = new Semaphore(0);
        semaphores[4] = new Semaphore(0);

        //iniciando todos filosofos
        philosophers[0].start();
        philosophers[1].start();
        philosophers[2].start();
        philosophers[3].start();
        philosophers[4].start();
    }

    //metodo para desenhar os objetos
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g.create();

        g.setColor(Color.black);
        g.setFont(new Font("TimesRoman", Font.BOLD, 15));
        //cria uma mesa
        g.drawOval(175, 150, 330, 300);

        //desenhando filosofos
        g2.drawImage(img[0], 50, 170, null);
        g2.drawImage(img[1], 95, 440, null);
        g2.drawImage(img[2], 400, 440, null);
        g2.drawImage(img[3], 520, 230, null);
        g2.drawImage(img[4], 285, 15, null);

        //desenhando pratos
        g2.drawImage(img[5], 180, 235, null);
        g2.drawImage(img[5], 230, 340, null);
        g2.drawImage(img[5], 370, 335, null);
        g2.drawImage(img[5], 405, 230, null);
        g2.drawImage(img[5], 295, 130, null);

        //desenhando hashi
        g2.drawImage(img[6], 240, 205, null);
        g2.drawImage(img[7], 230, 330, null);
        g2.drawImage(img[8], 340, 370, null);
        g2.drawImage(img[9], 390, 205, null);
        g2.drawImage(img[10], 410, 320, null);

        for (int i = 0; i < 5; i++) {
            if (status[i] == 0) {
                g.setColor(Color.black);
                text = "DORMINDO";
            }
            if (status[i] == 1) {
                g.setColor(Color.black);
                text = "ESPERANDO";
            }
            if (status[i] == 2) {
                g.setColor(Color.black);
                text = "COMENDO";
            }
            
            //desenha o filosofo na tela
            g.drawString(text, (int) (200D - 250D * Math.cos(1.2566370614359172D * (double) i)) + 100, (int) (200D - 200D * Math.sin(1.2566370614359172D * (double) i)) + 120);
        }

        //ativa a sincronia
        Toolkit.getDefaultToolkit()
                .sync();
        //pausa
        g.dispose();
    }
    public void run() {
        do {
            repaint();
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException ex) {
                System.out.println("ERROR>" + ex.getMessage());
            }
        } while (true);
    }

    public void animacaoGarfo(int numGarfo1, int numGarfo2) {

    }
}
