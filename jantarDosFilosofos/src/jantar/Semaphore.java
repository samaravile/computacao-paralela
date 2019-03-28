package jantar;

/**
*
* @author Isadora, Luis e Samara
*/

public class Semaphore {

   protected int cont;

   public Semaphore() {
       this.cont = 0; 
   }

   public Semaphore(int value) {
       this.cont = value;
   }

   public synchronized void decrementar() {
       while (this.cont == 0) {
           try {
               wait(); //quando o filosofo tenta pegar o hashi
           } catch (InterruptedException ex) {

               System.out.println("ERROR>" + ex.getMessage());
           }
       }

       this.cont--;
   }

   //incrementa o contador da classe e notifica que a solicitação já foi executada
   public synchronized void incrementar() {
       this.cont++;
       notify();
   }
}
