package sistema;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.text.*;

public class CartaoDePonto {


	static ArrayList <CartaoDePonto>  ListadeCartoes = new ArrayList<CartaoDePonto>();
	private GregorianCalendar calendario;
	private int totaldeminutos;
	private int numerodocartao;
	private int id;
	private static Scanner entrada;


	public CartaoDePonto(GregorianCalendar calendario, int horainicio, int minutoinicio, int horafim, int minutofim, int id) {
		
		this.calendario = calendario;
		this.id = id;
		this.totaldeminutos = ((horafim * 60) + minutofim) - ((horainicio * 60) + minutoinicio);
		this.numerodocartao = GerarNumerodeCartao();

	}

	public GregorianCalendar getCalendario() {
		return calendario;
	}

	public int getTotaldeminutos() {
		return totaldeminutos;
	}

	public int getNumerodocartao() {
		return numerodocartao;
	}

	public int getId() {
		return id;
	}
	
	public int GerarNumerodeCartao (){
		int i =1;
		if(ListadeCartoes.isEmpty() == true){
			i =1;
		}
		else{


			while(VerificarExistenciaNumerodeCartao(i)){
				i= i +1 ;
			}
		}

		return i;
	}
	boolean VerificarExistenciaID (int id){
		boolean x = false;

		for(int i=0; i <ListadeCartoes.size(); i++)
		{	

			if (ListadeCartoes.get(i).getId()== id)
			{	
				x = true;

			}
		}
		return x;

	}
	boolean VerificarExistenciaNumerodeCartao (int numero){
		boolean x = false;

		for(int i=0; i <ListadeCartoes.size(); i++)
		{	

			if (ListadeCartoes.get(i).getNumerodocartao() == numero)
			{	
				x = true;

			}
		}
		return x;

	}

	int BuscarIndiceNumeroCartao(int numero){
		int indice =0;
		if (VerificarExistenciaNumerodeCartao(numero)){
			for(int i=0; i <ListadeCartoes.size(); i++)
			{	

				if (ListadeCartoes.get(i).getNumerodocartao() == numero)
				{	
					indice = i;
				}
			}
			return indice;
		}
		return indice;
	}

	static void LancarCartao() throws ParseException{

		entrada = new Scanner(System.in);
		System.out.println("Informe o ID do empregado que deseja lançar cartão de ponto");
		int id ;
		id = entrada.nextInt();
		if (Empregado.Percorrer(id)){
			if (Empregado.empregados.get(Empregado.BuscarID(id)) instanceof Horista){
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				Date data;
				GregorianCalendar calendario = new GregorianCalendar();
				boolean entradacerta = false;
				while (!entradacerta){

					System.out.println("Informe a data do cartão de ponto no formato DD/MM/AAAA");
					try{

						String date = entrada.next();
						data = format.parse(date);
						calendario.setTime(data);
						entradacerta = true;
					}
					catch ( ParseException p){
						System.out.println("Você digitou uma data inválida");

					}
				}
				System.out.println("Informe somente a hora de entrada no formato 24 horas [0 - 24]");
				int horainicio = entrada.nextInt();
				System.out.println("Informe somente os minutos da hora de entrada");
				int minutoinicio = entrada.nextInt();
				System.out.println("Informe somente a hora de saída no formato 24 [0 - 24]");
				int horafinal = entrada.nextInt();
				if (horafinal > horainicio){
				System.out.println("Informe somente os minutos da hora de saída");
				int minutofinal = entrada.nextInt();
				
				
				CartaoDePonto cartao = new CartaoDePonto(calendario, horainicio, minutoinicio, horafinal, minutofinal, id);
				ListadeCartoes.add(cartao);
				Açoes.FazerAcao(cartao, "lancarponto");
				System.out.println("\tCartão de ponto lançado.");
				}
				else{
					System.out.println("A hora de saída não pode ser menor do que a hora de entrada.");
					
				}
			}

			else{
				System.out.println("O empregado não é um empregado do tipo horista");


			}
		}

		else{
			System.out.println("Não há nenhum empregado cadastrado com esse ID");
		}

	}

}

