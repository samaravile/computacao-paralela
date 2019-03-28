package jantar;

/*
 Define os filosofos e o que eles são capazes de fazer
 */

public class Philosopher extends Thread {

    private int ID;

    //padroes de comportamento dos filosofos.
    static final int THINKING = 0;
    static final int STARVING = 1;
    static final int EATING = 2;
    static int garfo[] = {1, 1, 1, 1, 1};

    public Philosopher(String name, int ID) {
        super(name);
        this.ID = ID;
    }

    //metodo que mostra qual filosofo está com fome
    public void Starving() {
        Design.status[this.ID] = 1; //setando o valor para classe Design
        System.out.println("O Filósofo " + getName() + " está FAMINTO!");
    }

  //metodo que mostra qual filosofo está comendo
    public void Eat() {
        Design.status[this.ID] = 2; //setando o valor para classe Desing
        System.out.println("O Filósofo " + getName() + " está COMENDO!");
        garfo[NeighborsLeft()] = 0;
        garfo[NeighborsLeft()] = 0;
        try {
            //tempo que o filosofo vai ficar comendo
        	Thread.sleep(1000L);
        } catch (InterruptedException ex) {
            System.out.println("ERROR>" + ex.getMessage());
        }
        garfo[NeighborsLeft()] = 1;
        garfo[NeighborsLeft()] = 1;
    }

    //tempo que o filosofo vai ficar pensando
    public void Think() {
        Design.status[this.ID] = 0; //setando o valor para classe Desing
        System.out.println("O Filósofo " + getName() + " está PENSANDO!");

        try {
        	//tempo que o filosofo vai ficar pensando
            Thread.sleep(1000L);
        } catch (InterruptedException ex) {
            System.out.println("ERROR>" + ex.getMessage());
        }
    }

    
    //metodo para soltar o hashi que o filosofo pegou
    public void PutFork() {
    	//decrementa o semaforo mutex principal da classe e mostra o metodo que está operando no momento
        Design.mutex.decrementar();
      
        Think(); //filosofo pensando

        //apos o filosofo pensar ele ira informar para os vizinhos pegar o hashi que já estao disponiveis
        Design.philosophers[NeighborsLeft()].TryGetFork();        
        Design.philosophers[NeighborsRight()].TryGetFork();

        //volta o semaforo mutex para o estado normal indicando que ja realizou todo procedimento da mesa
        Design.mutex.incrementar();
    }
    
    //metodo para pegar hashi
    public void GetFork() {
        
    	//decremento o semaforo mutex principal da classe e mostra metodo que está operando no momento
    	Design.mutex.decrementar(); 
    
        Starving();
        //chama metodo onde o filosofo esta faminto e verifica com os vizinhos se ele pode pegar o hashi
        TryGetFork();

        Design.mutex.incrementar();
        Design.semaphores[this.ID].decrementar();
    }

    public void TryGetFork() {
        if (Design.status[this.ID] == 1
                && Design.status[NeighborsLeft()] != 2
                && Design.status[NeighborsRight()] != 2) {
            Eat();
            Design.semaphores[this.ID].incrementar();
        }

    }

    @Override
    public void run() {

        try {
            Think();

            do {          	
                GetFork();
                Thread.sleep(1000L);
                PutFork();
            } while (true);
        } catch (InterruptedException ex) {
            System.out.println("ERROR>" + ex.getMessage());
        }

    }

    //apenas para retornar a posiçao dos 5 filosofos
    public int NeighborsRight() {
        return (this.ID + 1) % 5;
    }

    public int NeighborsLeft() {
        if (this.ID == 0) {

            return 4;
        } else {

            return (this.ID - 1) % 5;
        }
    }
    
}
