
package sistema;

import java.text.ParseException;
import java.util*;



class Main {

	private static Scanner entrada;


	public static void main(String[] args) throws ParseException, InputMismatchException , NoSuchElementException {


		System.out.println("\tSISTEMA DE FOLHA DE PAGAMENTO\n");
		int acao=0  ;



		while (true){

			System.out.println("\nQual ação deseja realizar?\n");
			System.out.println("1 - Adicionar um empregado");
			System.out.println("2 - Remover um empregado");
			System.out.println("3 - Lançar um cartão de ponto");
			System.out.println("4  -Lançar um resultado de venda");
			System.out.println("5 - Lançar uma taxa de serviço");
			System.out.println("6 - Alterar detalhes de um empregado");
			System.out.println("7 - Rodar folha de pagamento");
			System.out.println("8 - Desfazer última ação");
			System.out.println("9 - Refazer última ação");
			System.out.println("10 - Lista de ID's\r");
			boolean entradacerta = false;
			while (!entradacerta){

				try {
					entrada = new Scanner(System.in);
					acao = entrada.nextInt(); 
					entradacerta = true;

				}
				catch (InputMismatchException e){
					System.out.println("\tVocê digitou um caractere inválido\nDigite o número correspondente à opção desejada");
				}
				catch(NoSuchElementException e){
					System.err.println("Você digitou uma entrada inesperada!");
					return;
				
				}
				
				
				


			}

			if (acao == 1)
			{
				try{
					Empregado.Adicionar();
				}
				catch (InputMismatchException e){
					System.out.println("\tVocê digitou um caractere inválido");
				}



			}
			if (acao == 2){
				try{
					Empregado.Remover();
				}
				catch (InputMismatchException e){
					System.out.println("\tVocê digitou um caractere inválido");

				}
			}
			if (acao ==3){

				try{
					CartaoDePonto.LancarCartao();
				}
				catch (InputMismatchException e){
					System.out.println("\tVocê digitou um caractere inválido");

				}

			}
			if (acao ==4){

				try{
					Venda.LancarVenda();
				}
				catch (InputMismatchException e){
					System.out.println("\tVocê digitou um caractere inválido");

				}



			}
			if (acao ==5){
				try{
					Sindicato.LancarTaxa();
				}
				catch (InputMismatchException e){
					System.out.println("\tVocê digitou um caractere inválido");

				}


			}
			if (acao == 6){


				try{
					Empregado.Alterar();
				}
				catch (InputMismatchException e){
					System.out.println("\tVocê digitou um caractere inválido");

				}

			}
			if (acao == 7){

				try{
					Pagamento.RodarFolha();
				}
				catch (InputMismatchException e){
					System.out.println("\tVocê digitou um caractere inválido");

				}

			}
			if (acao == 8){

				try{
					Açoes.desfazerAcao();
				}
				catch (InputMismatchException e){
					System.out.println("\tVocê digitou um caractere inválido");

				}


			}
			if (acao ==  9){
				try{
					Açoes.refazerAcao();;
				}
				catch (InputMismatchException e){
					System.out.println("\tVocê digitou um caractere inválido");

				}


			}
			if (acao == 10){

				try{
					Empregado.ListaID();
				}
				catch (InputMismatchException e){
					System.out.println("\tVocê digitou um caractere inválido");

				}


			}

			if (acao < 1 || acao >10){


				System.out.println("\tVocê digitou uma opção inválida");
			}


		}

	}	
}
