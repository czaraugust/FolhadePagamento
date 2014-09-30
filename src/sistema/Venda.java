package sistema;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;



public class Venda {

	static ArrayList <Venda> ListaVendas = new ArrayList<Venda> ();
	private  GregorianCalendar calendario;
	private int id;
	private double venda;
	public int numerodavenda;
	private static Scanner entrada1;
	public Venda (GregorianCalendar calendario, int id , double venda) throws ParseException{
		this.id = id;
		this.calendario = calendario;
		this.venda = venda;
		this.numerodavenda = GerarNumerodeVenda();

	}

	public GregorianCalendar getCalendario() {
		return calendario;
	}
	public int getId() {
		return id;
	}

	public double getVenda() {
		return venda;
	}

	public int getNumerodavenda() {
		return numerodavenda;
	}


	public int GerarNumerodeVenda (){
		int i =1;
		if(ListaVendas.isEmpty() == true){
			i =1;
		}
		else{


			while(VerificarExistenciaVenda(i)){
				i= i +1 ;
			}
		}

		return i;
	}
	boolean VerificarExistenciaID (int id){
		boolean x = false;

		for(int i=0; i <ListaVendas.size(); i++)
		{	

			if (ListaVendas.get(i).getId()== id)
			{	
				x = true;

			}
		}
		return x;

	}
	boolean VerificarExistenciaVenda (int numero){
		boolean x = false;

		for(int i=0; i <ListaVendas.size(); i++)
		{	

			if (ListaVendas.get(i).getNumerodavenda() == numero)
			{	
				x = true;

			}
		}
		return x;

	}

	int BuscarIndiceVenda(int numero){
		int indice =0;
		if (VerificarExistenciaVenda(numero)){
			for(int i=0; i <ListaVendas.size(); i++)
			{	

				if (ListaVendas.get(i).getNumerodavenda() == numero)
				{	
					indice = i;
				}
			}
			return indice;
		}
		return indice;
	}
	static void LancarVenda() throws ParseException, InputMismatchException{
		entrada1 = new Scanner(System.in);
		System.out.println("Informe o ID do empregado que deseja lançar uma venda");
		int id = entrada1.nextInt();
		if (Empregado.Percorrer(id)){
			if (Empregado.empregados.get(Empregado.BuscarID(id)) instanceof Comissionado){
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				Date data;
				GregorianCalendar calendario = new GregorianCalendar();
				boolean entradacerta = false;
				while (!entradacerta){

					System.out.println("Informe a data do resultado de venda no formato DD/MM/AAAA");
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
				System.out.println("Informe o valor da venda");
				double vendas = entrada1.nextDouble();

				Venda venda = new Venda (calendario,id,vendas);

				ListaVendas.add(venda);
				Açoes.FazerAcao(venda, "lancarvenda");
				System.out.println("\tResultado de venda lançado.");
			}

			else{

				System.out.println("O empregado não é um empregado comissionado");
			}
		}
		else{
			System.out.println("Não há nenhum empregado cadastrado com esse ID");
		}

	}

}
