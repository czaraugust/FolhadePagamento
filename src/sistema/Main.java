
package sistema;

import java.text.ParseException;
import java.util*;



class Main {

	private static Scanner entrada;


	public static void main(String[] args) throws ParseException, InputMismatchException , NoSuchElementException {


		System.out.println("\tSISTEMA DE FOLHA DE PAGAMENTO\n");
		int acao=0  ;



		while (true){

			System.out.println("\nQual a��o deseja realizar?\n");
			System.out.println("1 - Adicionar um empregado");
			System.out.println("2 - Remover um empregado");
			System.out.println("3 - Lan�ar um cart�o de ponto");
			System.out.println("4  -Lan�ar um resultado de venda");
			System.out.println("5 - Lan�ar uma taxa de servi�o");
			System.out.println("6 - Alterar detalhes de um empregado");
			System.out.println("7 - Rodar folha de pagamento");
			System.out.println("8 - Desfazer �ltima a��o");
			System.out.println("9 - Refazer �ltima a��o");
			System.out.println("10 - Lista de ID's\r");
			boolean entradacerta = false;
			while (!entradacerta){

				try {
					entrada = new Scanner(System.in);
					acao = entrada.nextInt(); 
					entradacerta = true;

				}
				catch (InputMismatchException e){
					System.out.println("\tVoc� digitou um caractere inv�lido\nDigite o n�mero correspondente � op��o desejada");
				}
				catch(NoSuchElementException e){
					System.err.println("Voc� digitou uma entrada inesperada!");
					return;
				
				}
				
				
				


			}

			if (acao == 1)
			{
				try{
					Empregado.Adicionar();
				}
				catch (InputMismatchException e){
					System.out.println("\tVoc� digitou um caractere inv�lido");
				}



			}
			if (acao == 2){
				try{
					Empregado.Remover();
				}
				catch (InputMismatchException e){
					System.out.println("\tVoc� digitou um caractere inv�lido");

				}
			}
			if (acao ==3){

				try{
					CartaoDePonto.LancarCartao();
				}
				catch (InputMismatchException e){
					System.out.println("\tVoc� digitou um caractere inv�lido");

				}

			}
			if (acao ==4){

				try{
					Venda.LancarVenda();
				}
				catch (InputMismatchException e){
					System.out.println("\tVoc� digitou um caractere inv�lido");

				}



			}
			if (acao ==5){
				try{
					Sindicato.LancarTaxa();
				}
				catch (InputMismatchException e){
					System.out.println("\tVoc� digitou um caractere inv�lido");

				}


			}
			if (acao == 6){


				try{
					Empregado.Alterar();
				}
				catch (InputMismatchException e){
					System.out.println("\tVoc� digitou um caractere inv�lido");

				}

			}
			if (acao == 7){

				try{
					Pagamento.RodarFolha();
				}
				catch (InputMismatchException e){
					System.out.println("\tVoc� digitou um caractere inv�lido");

				}

			}
			if (acao == 8){

				try{
					A�oes.desfazerAcao();
				}
				catch (InputMismatchException e){
					System.out.println("\tVoc� digitou um caractere inv�lido");

				}


			}
			if (acao ==  9){
				try{
					A�oes.refazerAcao();;
				}
				catch (InputMismatchException e){
					System.out.println("\tVoc� digitou um caractere inv�lido");

				}


			}
			if (acao == 10){

				try{
					Empregado.ListaID();
				}
				catch (InputMismatchException e){
					System.out.println("\tVoc� digitou um caractere inv�lido");

				}


			}

			if (acao < 1 || acao >10){


				System.out.println("\tVoc� digitou uma op��o inv�lida");
			}


		}

	}	
}
