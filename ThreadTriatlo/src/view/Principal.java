/*Numa prova de triatlo moderno, o circuito se dá da seguinte maneira:
- 3Km de corrida onde os atletas correm entre 20 e 25 m / 30 ms
- 3 tiros ao alvo com pontuação de 0 a 10
- 5 km de ciclismo onde os atletas pedalam entre 30 e 40 m/ 40 ms
25 atletas participam da prova e largam juntos, no entanto, apenas 5 armas de tiro estão a
disposição. Cada atleta leva de 0,5 a 3s por tiro. Conforme os atletas finalizam o circuito de
corrida, em ordem de chegada, pegam a arma para fazer os disparos. Uma vez encerrados os
disparos, a arma é liberada para o próximo, e o atleta segue para pegar a bicicleta e continuar
o circuito.
Para determinar o ranking final dos atletas, considera-se a seguinte regra:
- O primeiro que chegar recebe 250 pontos, o segundo recebe 240, o terceiro recebe
230, ... , o último recebe 10.
- Soma-se à pontuação de cada atleta, o total de pontos obtidos nos 3 tiros (somados)
Ordenar a pontuação e exibir o resultado final do maior pontuador para o menor.
*/

package view;

import java.util.ArrayList;

import java.util.concurrent.Semaphore;

import controller.ThreadTriatlo;

public class Principal {
    
	public static void main(String[] args) {
		
		ArrayList<String> nomes = new ArrayList<>();

		nomes.add("Shrek faz urro");
		nomes.add("Sonic");
		nomes.add("Oi Eu sou o Doku");
		nomes.add("Charuto Uzocrack");
		nomes.add("Tanaka Traka");
		nomes.add("Takamassa Nomuro");
		nomes.add("Okimato atiro");
		nomes.add("Katano Okako");
		nomes.add("Procurando Nemo");
		nomes.add("Atônio biru biru");
		nomes.add("Ragnar calça peludas");
		nomes.add("Leandro Colevatinho");
		nomes.add("Gustavson");
		nomes.add("Geraldão");
		nomes.add("Ronaldo brilha muito no corinthians");
		nomes.add("Bis na aguinha");
		nomes.add("Isaadorapinto");
		nomes.add("1 2 3 de oliveira 4");
		nomes.add("Asteroide Silveira");
		nomes.add("Programa da Eliane");
		nomes.add("FAUSTÃO Ta pegando fogo o bixoooo");
		nomes.add("Harry Pote");
		nomes.add("Isidro Kutuca Aguya");
		nomes.add("Chevrolet da Silva Fode");
		nomes.add("Areonauta Barata");
		
		
		Semaphore semaPistola = new Semaphore(5);
		Semaphore semaColocacao = new Semaphore(1);

		
		for (int i = 0; i < 25; i++) {
			
			Thread atleta = new ThreadTriatlo(nomes.get(i), semaColocacao, semaPistola);
			atleta.start();
		}
		
	}

}