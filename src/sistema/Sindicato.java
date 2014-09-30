package sistema;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Sindicato {
	
	static ArrayList <Sindicato> ListaSindicato = new ArrayList<Sindicato> ();
	private int ID;
	private GregorianCalendar calendario;
	private double taxadeserviço;
	private int numero;
	private static Scanner entrada1;
	
	

	public Sindicato(GregorianCalendar calendario , int ID, double taxadeserviço) throws ParseException{
		this.calendario =calendario;
		this.numero = GerarNumerodeTaxa();
		this.ID = ID;
		this.taxadeserviço = taxadeserviço;
	}
	public int getID() {
		return ID;
	}
	public GregorianCalendar getCalendario() {
		return calendario;
	}
	public double getTaxadeserviço() {
		return taxadeserviço;
	}
	public int getNumero() {
		return numero;
	}
	
	public int GerarNumerodeTaxa (){
		int i =1;
		if(ListaSindicato.isEmpty() == true){
			i =1;
		}
		else{


			while(VerificarExistenciaNumerodeTaxa(i)){
				i= i +1 ;
			}
		}

		return i;
	}
	boolean VerificarExistenciaID (int id){
		boolean x = false;

		for(int i=0; i <ListaSindicato.size(); i++)
		{	

			if (ListaSindicato.get(i).getID()== id)
			{	
				x = true;

			}
		}
		return x;

	}
	boolean VerificarExistenciaNumerodeTaxa (int numero){
		boolean x = false;

		for(int i=0; i <ListaSindicato.size(); i++)
		{	

			if (ListaSindicato.get(i).getNumero() == numero)
			{	
				x = true;

			}
		}
		return x;

	}

	int BuscarIndiceNumerodeTaxa(int numero){
		int indice =0;
		if (VerificarExistenciaNumerodeTaxa(numero)){
			for(int i=0; i <ListaSindicato.size(); i++)
			{	

				if (ListaSindicato.get(i).getNumero() == numero)
				{	
					indice = i;
				}
			}
			return indice;
		}
		return indice;
	}
	
	static void LancarTaxa() throws ParseException{
		entrada1 = new Scanner(System.in);
		System.out.println("Informe o ID do empregado que deseja lançar uma venda");
		int N = entrada1.nextInt();
		if (Empregado.Percorrer(N)){
			if (Empregado.empregados.get(Empregado.BuscarID(N)).isSindicato()){
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				Date data;
				GregorianCalendar calendario = new GregorianCalendar();
				boolean entradacerta = false;
				while (!entradacerta){

					System.out.println("Informe a data do lançamento da taxa de serviço no formato DD/MM/AAAA");
					try{

						String date = entrada1.next();
						data = format.parse(date);
						calendario.setTime(data);
						entradacerta = true;
					}
					catch ( ParseException p){
						System.out.println("Você digitou uma data inválida");

					}
				}
				System.out.println("Informe o valor da taxa de serviço");
				double taxa= entrada1.nextDouble();
				
				
				Sindicato sindicato = new Sindicato(calendario, N, taxa);
				
				ListaSindicato.add(sindicato);
				Açoes.FazerAcao(sindicato, "lançarsindicato");
				System.out.println("\tTaxa de serviço lançada.");

			}

			else{

				System.out.println("O empregado não é associado ao sindicato");
			}
		}
		else{
			System.out.println("Não há nenhum empregado cadastrado com esse ID");
		}

	}
}


