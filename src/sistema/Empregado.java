package sistema;

import java.util.*;



public abstract class Empregado {
	protected String  nome;
	protected String endere�o;
	protected int ID;
	protected String tipo;
	protected String metodo;
	boolean sindicato;
	protected double taxasindical= 0;
	protected int IDsindical = 0;


	static ArrayList <Empregado > empregados = new ArrayList<Empregado> ();
	private static Scanner entrada;
	private static Scanner entrada2;
	private static Scanner remover;


	public Empregado (String nome, String endere�o, String tipo, String metodo, int ID, boolean sindicato){
		this.nome = nome;
		this.endere�o = endere�o;
		this.tipo = tipo;
		this.ID = ID;
		this.sindicato = sindicato;
		this.metodo = metodo;

	}




	public int getIDsindical() {
		return IDsindical;
	}
	public void setIDsindical(int iDsindical) {
		this.IDsindical = iDsindical;
	}
	public int getID() {
		return ID;
	}

	public double getTaxasindical() {
		return taxasindical;
	}

	public void setTaxasindical(double taxasindical) {
		this.taxasindical = taxasindical;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndere�o() {
		return endere�o;
	}

	public void setEndere�o(String endere�o) {
		this.endere�o = endere�o;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public boolean isSindicato() {
		return sindicato;
	}

	public void setSindicato(boolean sindicato) {
		this.sindicato = sindicato;
	}

	static boolean isComissionado (Empregado E){
		if (E instanceof Comissionado){
			return true;
		}
		else return false;

	}
	static boolean isHorista (Empregado E){
		if (E instanceof Horista){
			return true;
		}
		else return false;

	}


	static boolean isAssalariado (Empregado E){
		if (E instanceof Assalariado){
			return true;
		}
		else return false;

	}
	static String setarMetodo (int escolha){
		String metodo = "";

		if (escolha == 1)
		{
			metodo = "Cheque pelos Correios";
		}
		if (escolha == 2)
		{
			metodo = "Cheque em m�os";
		}
		if (escolha == 3)
		{
			metodo = "Dep�sito em conta banc�ria";
		}

		return metodo;

	}
	static void Adicionar() throws InputMismatchException{
		entrada = new Scanner(System.in);
		int acao;
		String name;
		String endere�o;
		boolean sind = false;
		int metodo;
		int sindicato;


		System.out.println("Informe o nome do empregado");
		name = entrada.nextLine();
		System.out.println("Informe o endere�o do empregado");
		endere�o = entrada.nextLine();

		System.out.println("Qual o m�todo de pagamento escolhido pelo empregado?");
		System.out.println("1 - Cheque pelos Correios");
		System.out.println("2 - Cheque em m�os");
		System.out.println("3 - Dep�sito em conta banc�ria");
		metodo= entrada.nextInt();
		if (metodo >= 1 && metodo <= 3){
			System.out.println("O empregado � vinculado ao sindicato");
			System.out.println("1 - SIM");
			System.out.println("2 - N�O");
			sindicato= entrada.nextInt();
			if (sindicato == 1 || sindicato == 2){
				if (sindicato == 1) 
				{
					sind =true;

				}
				if (sindicato == 2) 
				{
					sind = false;
				}


				System.out.println("O empregado que deseja adicionar � do tipo:");
				System.out.println("1 - Horista");
				System.out.println("2 - Assalariado");
				System.out.println("3 - Comissionado\r");
				acao = entrada.nextInt();
				if (acao >=1 && acao <=3){
					if (acao == 1){
						double salariohora;
						System.out.println("Informe o sal�rio/hora do empregado");
						salariohora = entrada.nextDouble();
						Horista horista = new Horista (name,endere�o,salariohora,setarMetodo(metodo), GerarID(), sind);
						empregados.add(horista);
						A�oes.FazerAcao(horista, "adicionar");
						System.out.println("Empregado cadastrado com sucesso!\n\tDados do Empregado: ");
						System.out.println("Nome: " + horista.nome );
						System.out.println("Endere�o: " + horista.endere�o);
						System.out.println("ID: " + horista.ID);
						System.out.println("M�todo de pagamento: " + horista.getMetodo());
						System.out.println("Tipo de Contrato: " + horista.tipo);
						System.out.println("Sal�rio/Hora: R$" + horista.getSalariohora() );

					}
					if (acao == 2){
						double salario;
						System.out.println("Informe o sal�rio mensal do empregado");
						salario = entrada.nextDouble();
						Assalariado assalariado = new Assalariado (name,endere�o,salario , setarMetodo(metodo), GerarID() , sind);
						empregados.add(assalariado);
						A�oes.FazerAcao(assalariado, "adicionar");			
						System.out.println("Empregado cadastrado com sucesso!\n\tDados do Empregado: ");
						System.out.println("Nome: " + assalariado.nome );
						System.out.println("Endere�o: " + assalariado.endere�o);
						System.out.println("ID: " + assalariado.ID);
						System.out.println("M�todo de pagamento: " + assalariado.getMetodo());
						System.out.println("Tipo de Contrato: " + assalariado.tipo);
						System.out.println("Sal�rio Mensal: R$" + assalariado.getSalario());



					}
					if (acao == 3){
						double comissao;
						double salariomensal;
						System.out.println("Informe o sal�rio mensal do empregado");
						salariomensal = entrada.nextDouble();
						System.out.println("Informe o percentual de comiss�o sobre a vendas do empregado");
						comissao = entrada.nextDouble();
						Comissionado comissionado = new Comissionado (name, endere�o, salariomensal, comissao,setarMetodo(metodo),GerarID(), sind);
						empregados.add(comissionado);
						A�oes.FazerAcao(comissionado, "adicionar");
						System.out.println("Empregado cadastrado com sucesso!\n\tDados do Empregado: ");
						System.out.println("Nome: " + comissionado.nome );
						System.out.println("Endere�o: " + comissionado.endere�o);
						System.out.println("ID: " + comissionado.ID);
						System.out.println("M�todo de pagamento: " + comissionado.getMetodo());
						System.out.println("Tipo de Contrato: " + comissionado.tipo);
						System.out.print("Comiss�o: " + comissionado.getComissao());
						System.out.println(" %");
						System.out.println("Sal�rio Mensal: R$ " + comissionado.getSalario());
					}
				}
				else{
					System.out.println("Voc� digitou uma op��o inv�lida");

				}
			}
			else{
				System.out.println("Voc� digitou um op��o inv�lida");
			}


		}
		else{
			System.out.println("Voc� digitou uma op��o inv�lida");

		}



	}
	static void Remover() throws InputMismatchException{
		if (empregados.isEmpty()){
			System.out.println("Ainda n�o h� nenhum empregado cadastrado");
		}
		else{

			int id;
			Empregado E = null ;
			remover = new Scanner(System.in);
			System.out.println("Informe o ID do funcion�rio que deseja remover");
			id = remover.nextInt();


			if (isHorista(empregados.get(BuscarID(id))) == true){

				E = CloneHorista(empregados.get(BuscarID(id)));

			}
			if (isAssalariado(empregados.get(BuscarID(id))) == true){

				E = CloneAssalariado(empregados.get(BuscarID(id)));

			}
			if (isComissionado(empregados.get(BuscarID(id))) == true){

				E = CloneComissionado(empregados.get(BuscarID(id)));

			}
			if (Percorrer(id)){
				System.out.println("Nome: " + empregados.get(BuscarID(id)).getNome());
				System.out.println("Endere�o: " + empregados.get(BuscarID(id)).getEndere�o());
				System.out.println("ID: " + empregados.get(BuscarID(id)).getID());
				System.out.println("M�todo de pagamento: " + empregados.get(BuscarID(id)).metodo);
				System.out.println("Tipo de Contrato: " + empregados.get(BuscarID(id)).getTipo());
				System.out.println("Deseja remover o empregado com os dados acima?\n1 - SIM\n2 - N�O");
				int confirma = remover.nextInt();
				if (confirma == 1){
					A�oes.FazerAcao(E, "remover");
					empregados.remove(BuscarID(id));
					System.out.println("\tEmpregado removido com sucesso!");
				}
			}
			else{
				System.out.println("A ID informada n�o est� associada a nenhum empregado");
			}
		}



	}
	static boolean Percorrer (int id){
		boolean x = false;

		for(int i=0; i <empregados.size(); i++)
		{	

			if (empregados.get(i).getID() == id)
			{	
				x = true;

			}
		}
		return x;

	}

	static int BuscarID(int ID){
		int indice =0;
		if (Percorrer(ID)){
			for(int i=0; i <empregados.size(); i++)
			{	

				if (empregados.get(i).getID() == ID)
				{	
					indice = i;
				}
			}
			return indice;
		}
		return indice;
	}

	static int GerarID(){
		int x;
		Random gerador = new Random();
		int num = gerador.nextInt(100) +1;
		for (x=0; x<empregados.size();x++){

			if (num == empregados.get(x).getID());{

				num = gerador.nextInt(100) +1;

			}
		}

		return num;
	}
	static void imprimir (int id){


		System.out.println("\tDados atuais do empregado");
		System.out.println("ID  " + empregados.get(BuscarID(id)).getID());
		System.out.println("Nome: " + empregados.get(BuscarID(id)).getNome());
		System.out.println("Endere�o: " + empregados.get(BuscarID(id)).getEndere�o());
		System.out.println("M�todo de pagamento: " + empregados.get(BuscarID(id)).getMetodo());
		System.out.println("Tipo de Contrato: " + empregados.get(BuscarID(id)).getTipo());
		if (empregados.get(BuscarID(id)).isSindicato() == true)
		{
			System.out.println("Associa��o ao Sindicato: SIM");
			System.out.println("Identifica��o Sindical: " + empregados.get(BuscarID(id)).getIDsindical());
			System.out.println("Taxa Sindical: " + empregados.get(BuscarID(id)).getTaxasindical());
			
		}
		else{
			System.out.println("Associa��o ao Sindicato: N�O");
		}

		System.out.println();
	}

	static void ListaID(){

		if (!empregados.isEmpty()){
			for (int i =0 ; i< empregados.size() ; i++){
				System.out.print("Nome: " +empregados.get(i).getNome());
				System.out.println(" ID: " + empregados.get(i).getID());


			}
		}

		else {

			System.out.println("N�o h� empregados cadastrados!");
		}
	}

	static Horista CloneHorista(Empregado E){

		Horista H = (Horista) E;
		Horista empregado = new Horista(H.getNome(), H.getEndere�o(), H.getSalariohora(),H.getMetodo(),H.getID(), H.isSindicato() );
		empregado.setIDsindical(H.getIDsindical());
		empregado.setTaxasindical(H.getTaxasindical());


		return empregado ;
	}
	static Assalariado CloneAssalariado (Empregado E){

		Assalariado A = (Assalariado) E;
		Assalariado empregado = new Assalariado(A.getNome(), A.getEndere�o(), A.getSalario(), A.getMetodo() , A.getID(), A.isSindicato());
		empregado.setIDsindical(A.getIDsindical());
		empregado.setTaxasindical(A.getTaxasindical());

		return empregado;
	}
	static Comissionado CloneComissionado(Empregado E){

		Comissionado C = (Comissionado) E;
		Comissionado empregado = new Comissionado(C.getNome(), C.getEndere�o() , C.getSalario() , C.getComissao() , C.getMetodo() , C.getID() , C.isSindicato());
		empregado.setIDsindical(C.getIDsindical());
		empregado.setTaxasindical(C.getTaxasindical());

		return empregado;

	}





	static void Alterar() throws InputMismatchException{
		if (empregados.isEmpty()){
			System.out.println("Ainda n�o h� nenhum empregado cadastrado");

		}
		else{
			int id;
			int acao;			
			String string;
			int escolha; 
			Empregado E = null ;

			entrada2 = new Scanner(System.in);
			System.out.println("Informe o ID do funcion�rio que deseja alterar");
			id = entrada2.nextInt();

			if (isHorista(empregados.get(BuscarID(id))) == true){

				E = CloneHorista(empregados.get(BuscarID(id)));

			}
			if (isAssalariado(empregados.get(BuscarID(id))) == true){

				E = CloneAssalariado(empregados.get(BuscarID(id)));

			}
			if (isComissionado(empregados.get(BuscarID(id))) == true){

				E = CloneComissionado(empregados.get(BuscarID(id)));

			}
			if (!Percorrer(id)){
				System.out.println("N�o h� nenhum empregado cadastrado com a ID informada");
			}
			else{
				
				imprimir(id);
				System.out.println("Informe o atibuto que deseja modificar");
				System.out.println("1 - Nome\n2 - Endere�o\n3 - M�todo de Pagamento\n4 - Tipo de contrato\n5 - Associa��o ao Sindicato");
				if (empregados.get(BuscarID(id)).isSindicato() == true)
				{

					System.out.println("6 - Identifica��o Sindical\n7 - Taxa Sindical\n\r");
				}

				acao = entrada2.nextInt();
				entrada2.nextLine();
				if (acao >=1 && acao <=7){
					if (acao == 1){

						System.out.println("Informe o novo nome do empregado");
						string = entrada2.nextLine();
						A�oes.FazerAcao(E, "setarnome");
						empregados.get(BuscarID(id)).setNome(string);
						System.out.println("\tNome atualizado com sucesso!\n");
						imprimir(id);

					}
					if (acao == 2){

						System.out.println("Informe o novo endere�o do empregado");
						string = entrada2.nextLine();
						A�oes.FazerAcao(E, "setarendere�o");
						empregados.get(BuscarID(id)).setEndere�o(string);
						System.out.println("\tEndere�o atualizado com sucesso!\n");
						imprimir(id);

					}
					if (acao == 3){
						A�oes.FazerAcao(E, "setarmetodo");
						System.out.println("Qual o novo m�todo de pagamento escolhido pelo empregado?");
						System.out.println("1 - Cheque pelos Correios");
						System.out.println("2 - Cheque em m�os");
						System.out.println("3 - Dep�sito em conta banc�ria");
						escolha = entrada2.nextInt();
						if (escolha == 1)
						{
							empregados.get(BuscarID(id)).setMetodo("Cheque pelos Correios");
							System.out.println("\tM�todo de pagamento atualizado com sucesso!\n");
							imprimir(id);
						}
						if (escolha == 2)
						{
							empregados.get(BuscarID(id)).setMetodo("Cheque em m�os");
							System.out.println("\tM�todo de pagamento atualizado com sucesso!\n");
							imprimir(id);
						}
						if (escolha == 3)
						{
							empregados.get(BuscarID(id)).setMetodo("Dep�sito em conta banc�ria");
							System.out.println("\tM�todo de pagamento atualizado com sucesso!\n");
							imprimir(id);
						}	
						else{
							System.out.println("Voc� escolheu uma op��o inv�lida.");
						}

					}
					if (acao == 4){
						double salario;
						System.out.println("Qual o novo tipo de contrato do empregado?");
						System.out.println("1 - Horista");
						System.out.println("2 - Assalariado");
						System.out.println("3 - Comissionado");
						escolha = entrada2.nextInt();
						if (acao >=1 && acao <=3){
							A�oes.FazerAcao(E, "setartipodecontrato");

							if (escolha == 1){
								System.out.println("Informe o valor do sal�rio/hora do empregado");
								salario = entrada2.nextDouble();
								Horista horista = new Horista (empregados.get(BuscarID(id)).getNome(), empregados.get(BuscarID(id)).getEndere�o(), salario, 
										empregados.get(BuscarID(id)).getMetodo(), empregados.get(BuscarID(id)).getID(), empregados.get(BuscarID(id)).isSindicato());
								empregados.set(BuscarID(id), horista);
								imprimir(id);



							}
							if (escolha == 2){
								System.out.println("Informe o valor do sal�rio mensal do empregado");
								salario = entrada2.nextDouble();
								Assalariado assalariado = new Assalariado (empregados.get(BuscarID(id)).getNome(), empregados.get(BuscarID(id)).getEndere�o(), salario, 
										empregados.get(BuscarID(id)).getMetodo(), empregados.get(BuscarID(id)).getID(), empregados.get(BuscarID(id)).isSindicato());
								empregados.set(BuscarID(id), assalariado);
								imprimir(id);

							}
							if (escolha == 3){
								System.out.println("Informe o valor do sal�rio base do empregado");
								salario = entrada2.nextDouble();
								System.out.println("Informe o valor da comiss�o sobre as vendas do empregado");
								double comissao = entrada2.nextDouble();
								Comissionado comissionado = new Comissionado (empregados.get(BuscarID(id)).getNome(), empregados.get(BuscarID(id)).getEndere�o(), salario, comissao,
										empregados.get(BuscarID(id)).getMetodo(), empregados.get(BuscarID(id)).getID(), empregados.get(BuscarID(id)).isSindicato());
								empregados.set(BuscarID(id), comissionado);
								imprimir(id);
							}
						}
						else {
							System.out.println("Voc� escolheu uma op��o inv�lida.");
						}
					}
					if (acao == 5){

						if (empregados.get(BuscarID(id)).isSindicato()){


							System.out.println("O empregado � associado ao sindicato. Deseja desassoci�-lo?\n1 - SIM\n2 - N�O\n");
							int decisao = entrada2.nextInt();
							if (decisao == 1){
								A�oes.FazerAcao(E, "setarsindicato");
								empregados.get(BuscarID(id)).setSindicato(false);
								imprimir(id);
							}

						}
						else {
							System.out.println("O empregado n�o � associado ao sindicato. Deseja associ�-lo?\n1 - SIM\n2 - N�O\n");
							int decisao = entrada2.nextInt();
							if (decisao == 1){
								A�oes.FazerAcao(E, "setarsindicato");
								empregados.get(BuscarID(id)).setSindicato(true);
								imprimir(id);
							}

						}
					}
					if (acao == 6){
						if (!empregados.get(BuscarID(id)).isSindicato()){
							System.out.println("O empregado n�o � associado ao sindicato. Associe-o antes de alterar esta dado\n");
						}
						else{

							System.out.println("Informe a identifica��o sindical do empregado\n");
							int idSindical = entrada2.nextInt();
							A�oes.FazerAcao(E, "setaridsindical");
							empregados.get(BuscarID(id)).setIDsindical(idSindical);
							imprimir(id);
						}
					}
					if (acao == 7){
						if (!empregados.get(BuscarID(id)).isSindicato()){
							System.out.println("O empregado n�o � associado ao sindicato. Associe-o antes de alterar esta dado\n");
						}
						else{
							A�oes.FazerAcao(E, "setartaxasindical");
							System.out.println("Informe a taxa de contribui��o sindical do empregado\n");
							double taxaSindical = entrada2.nextDouble();
							empregados.get(BuscarID(id)).setTaxasindical(taxaSindical);

							imprimir(id);
						}
					}

				}
				else{
					System.out.println("Voc� escolheu uma op��o inv�lida.");
				}

			}

		}

	}



}
