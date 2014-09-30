package sistema;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
public class Pagamento {









	private static Scanner entrada;

	@SuppressWarnings("static-access")
	static public void RodarFolha() throws ParseException{
		if (!Empregado.empregados.isEmpty()){
			SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
			Date data;
			GregorianCalendar calendario = new GregorianCalendar();
			entrada = new Scanner(System.in);

			boolean entradacerta = false;
			while (!entradacerta){

				System.out.println("Informe a data em que a folha será rodada no formato DD/MM/AAA");
				try{

					String date = entrada.next();
					data = formatador.parse(date);
					calendario.setTime(data);
					entradacerta = true;
				}
				catch ( ParseException p){
					System.out.println("Você digitou uma data inválida");

				}
			}

			for (int i =0; i < Empregado.empregados.size(); i++){
				double salario =0;
				double totaltaxas =0;
				double totalvendas =0;
				double salarioparcial = 0;
				if (Empregado.empregados.get(i) instanceof Assalariado){


					if (Data.VerificaUltimoDiaUtil(calendario)){
						Assalariado A = (Assalariado) Empregado.empregados.get(i);
						{
							if (A.isSindicato()){



								for (int j = 0; j< Sindicato.ListaSindicato.size(); j++){
									if (A.getID() == Sindicato.ListaSindicato.get(j).getID()){
										GregorianCalendar dia = Sindicato.ListaSindicato.get(j).getCalendario();

										if ( dia.get(dia.MONTH) ==  calendario.get(calendario.MONTH) -1){

											totaltaxas += Sindicato.ListaSindicato.get(j).getTaxadeserviço();

										}
									}

								}
							}

						}

						salario = A.getSalario() - (totaltaxas + A.getTaxasindical());	
						ImprimirSalario(A, salario);
					}

				}
				if (Empregado.empregados.get(i) instanceof Comissionado){
					Comissionado C = (Comissionado)Empregado.empregados.get(i);
					if (Data.VerificaSextaImpar(calendario)){
						for (int j = 0 ; j < Venda.ListaVendas.size() ; j++){

							if (Venda.ListaVendas.get(j).getId() == C.getID()){
								GregorianCalendar dia = Venda.ListaVendas.get(j).getCalendario();
								if (dia.get(dia.DAY_OF_MONTH) >= (calendario.get(calendario.DAY_OF_MONTH) -14) && dia.get(dia.DAY_OF_MONTH) <= (calendario.get(calendario.DAY_OF_MONTH))){

									totalvendas += Venda.ListaVendas.get(j).getVenda()* (C.getComissao()/100);
								}
							}

						}
						if (C.isSindicato()){

							for (int j = 0; j< Sindicato.ListaSindicato.size(); j++){
								if (C.getID() == Sindicato.ListaSindicato.get(j).getID()){
									GregorianCalendar dia = Sindicato.ListaSindicato.get(j).getCalendario();

									if ( dia.get(dia.MONTH) ==  calendario.get(calendario.MONTH) -1){

										totaltaxas += Sindicato.ListaSindicato.get(j).getTaxadeserviço();

									}
								}

							}

						}

						salario = C.getSalario() + totalvendas - (C.getTaxasindical() + totaltaxas);
						ImprimirSalario(C, salario);

					}
					if (Data.Verifica1aSexta(calendario)){


						GregorianCalendar aux = new GregorianCalendar ();
						aux.set(aux.YEAR, calendario.get(calendario.YEAR));
						aux.set(aux.MONTH, (calendario.get(calendario.MONTH ) -1));
						aux.set(aux.DAY_OF_MONTH, Data.Setar2aSexta(aux));

						for (int j = 0 ; j < Venda.ListaVendas.size() ; j++){

							if (Venda.ListaVendas.get(j).getId() == C.getID()){

								GregorianCalendar dia = Venda.ListaVendas.get(j).getCalendario();
								if (dia.get(dia.DAY_OF_YEAR) >= (aux.get(aux.DAY_OF_YEAR)) && dia.get(dia.DAY_OF_YEAR) <= (calendario.get(calendario.DAY_OF_YEAR))){

									totalvendas += Venda.ListaVendas.get(j).getVenda()* (C.getComissao()/100);
								}
							}

						}

						if (C.isSindicato()){

							for (int j = 0; j< Sindicato.ListaSindicato.size(); j++){
								if (C.getID() == Sindicato.ListaSindicato.get(j).getID()){
									GregorianCalendar dia = Sindicato.ListaSindicato.get(j).getCalendario();

									if ( dia.get(dia.MONTH) ==  calendario.get(calendario.MONTH) -1){

										totaltaxas += Sindicato.ListaSindicato.get(j).getTaxadeserviço();

									}
								}

							}

						}

						salario = C.getSalario() + totalvendas - (C.getTaxasindical() + totaltaxas);
						ImprimirSalario(C, salario);
					}

				}
				if (Empregado.empregados.get(i) instanceof Horista){

					Horista H = (Horista) Empregado.empregados.get(i);
					if (Data.VerificaSexta(calendario)){

						for (int j = 0 ; j < CartaoDePonto.ListadeCartoes.size() ; j++){

							if (CartaoDePonto.ListadeCartoes.get(j).getId() == H.getID()){
								GregorianCalendar dia = CartaoDePonto.ListadeCartoes.get(j).getCalendario();
								if (dia.get(dia.DAY_OF_YEAR) >= (calendario.get(calendario.DAY_OF_YEAR) -7) && dia.get(dia.DAY_OF_YEAR) <= (calendario.get(calendario.DAY_OF_YEAR))){

									if (CartaoDePonto.ListadeCartoes.get(j).getTotaldeminutos() <= 480){

										salarioparcial += (CartaoDePonto.ListadeCartoes.get(j).getTotaldeminutos()  * (H.getSalariohora()/60));

									}
									if (CartaoDePonto.ListadeCartoes.get(j).getTotaldeminutos() > 480){

										double sobra = (CartaoDePonto.ListadeCartoes.get(j).getTotaldeminutos() - 480);
										salarioparcial += (480*(H.getSalariohora()/60)) + (sobra * 1.5 * (H.getSalariohora()/60));

									}
								}
							}

						}

						if (H.isSindicato()){

							for (int j = 0; j< Sindicato.ListaSindicato.size(); j++){
								if (H.getID() == Sindicato.ListaSindicato.get(j).getID()){
									GregorianCalendar dia = Sindicato.ListaSindicato.get(j).getCalendario();

									if ( dia.get(dia.MONTH) ==  calendario.get(calendario.MONTH) -1){

										totaltaxas += Sindicato.ListaSindicato.get(j).getTaxadeserviço();

									}
								}

							}

						}

						salario = salarioparcial - (totaltaxas + H.getTaxasindical());
						ImprimirSalario(H, salario);

					}


				}

			}
		}
		else{
			System.out.println("Não há nenhum empregado cadastrado. Não é possível rodar a folha.");
		}

	}




	static void ImprimirSalario(Empregado E, double salario){
		System.out.println("Nome do empregado: " + E.getNome());
		System.out.println("ID do empregado: " + E.getID() );
		System.out.println("Forma de pagamento: " +E.getMetodo());
		System.out.println("Tipo de Contrato: " + E.getTipo());
		System.out.printf("Sálario a receber: R$ ");
		System.out.println(format(salario));



	}

	public static String format(double x) {  
		return String.format("%.2f", x);  
	}  

}
