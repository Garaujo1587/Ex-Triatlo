package controller;

import java.util.concurrent.Semaphore;

public class ThreadTriatlo extends Thread{

    private static int posicao = 0;
    private static String[][] colocacao = new String[25][2];
	private Semaphore semaColocacao;
	private Semaphore semaPistola;
	private int pontosTiros = 0;
	private String atleta;
	
	
	public ThreadTriatlo(String atleta, Semaphore semaColocacao, Semaphore semaPistola) {
		super();
		this.atleta = atleta;
		this.semaPistola = semaPistola;
		this.semaColocacao = semaColocacao;
	}
	
	
	

	@Override
	public void run() {

        correr();
        try {
			semaPistola.acquire();
			atirar();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			semaPistola.release();
		}
      
        pedalar();
        
        try {
        	semaColocacao.acquire();
        	pontuacao();
        }catch (Exception e) {
			System.err.println("Deu erro ao colocar colocacao: " + e);
		}finally {
			semaColocacao.release();
		}
        
		
		super.run();
	}

	private void correr() {
		
		System.out.println(atleta + " começou a correr");
		
		int distanciaPercorrida = 0;
		
		while(3000 > distanciaPercorrida) {
			
			distanciaPercorrida += (int)((Math.random()*6)+20);
			try {
				sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		System.out.println(atleta + " terminou de correr");
		
	}
	
	private void atirar() {
		
		int tiros = 0;
		
		System.out.println(atleta + " está mandando bala");
		
		while(3 > tiros) {
			
			try {
				
				pontosTiros += (int)(Math.random()*11);
				sleep((int)((Math.random()*2501)+500));
				
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			tiros++;
		}
		
		System.out.println( atleta + " Pontuou " + pontosTiros + " Nos tiros");
		
	}
	
	private void pedalar() {
		
		System.out.println(atleta + " Comecou a pedalar");
		
		int distanciaPercorrida = 0;
		
		while(5000 > distanciaPercorrida) {
			
			distanciaPercorrida += (int)((Math.random()*11)+30);
			try {
				sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		System.out.println(atleta + " terminou de pedalar");
		
	}
	
	private void pontuacao() {
		
		int pont = 250;
		
		for (int i = 0; i < 25; i++) {
			
			if(i == posicao) {
				colocacao[i][0] = atleta;
				colocacao[i][1] = Integer.toString( pont + pontosTiros );
				System.out.println("O atleta " + atleta + " Chegou em " + (posicao+1)+ "° e ficou com a pontuação de chegada de: " + pont + "." );
			}
			pont -= 10;
		}
		
		posicao = posicao + 1;
		
		if(posicao == 25) {
			
			organizar();
			
		}
		
	}

	private void organizar() {
		
		for (int i = 0; i < colocacao.length; i++) {
			for (int j = i+1; j < colocacao.length; j++) {
				if( Integer.parseInt(colocacao[i][1]) < Integer.parseInt(colocacao[j][1])) {
					String[][] aux = colocacao;
					colocacao[i][0] = colocacao[j][0];
					colocacao[i][1] = colocacao[j][1];
					colocacao[j][0] = aux[i][0];
					colocacao[j][1] = aux[i][1];
				}
			}
		}
		
		imprimir();
		
	}

	private void imprimir() {
		
		for (int i = 0; i < colocacao.length; i++) {
			
			System.out.println("O competidor : " + colocacao[i][0] + " sua pontuação foi: " + colocacao[i][1]);
			
		}
		
	}
	
}