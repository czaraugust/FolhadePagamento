package sistema;

import java.util.*;

public class Açoes {

	static Stack<String> Fazer = new  Stack<String>();
	static Stack<String> Desfazer = new Stack<String> ();
	static Stack <Object> Fazeracoes = new Stack<Object>();
	static Stack <Object> Desfazeracoes = new Stack<Object> ();
	

	public Açoes(){


	}

	static void FazerAcao (Object O, String Acao){

		Fazer.add(Acao);
		Fazeracoes.add(O);


	}

	@SuppressWarnings("static-access")
	static void desfazerAcao (){
		if (Fazeracoes.isEmpty() == true){
			System.out.println("\tNão existem ações para serem desfeitas");
		}
		else {
			String acao = Fazer.peek();
			Object O = Fazeracoes.peek();
			if (O instanceof Empregado){
				Empregado E = (Empregado) O;
				int id= E.getID();	

				if (acao == "adicionar"){

					Empregado.imprimir(id);
					System.out.println("O empregado com os dados acima foi removido do sistema");
					Empregado.empregados.remove(Empregado.BuscarID(id));

					Desfazer.push(Fazer.pop());
					Desfazeracoes.push(Fazeracoes.pop());
				}
				if (acao == "remover"){
					Empregado.empregados.add(E);

					Desfazer.push(Fazer.pop());
					Desfazeracoes.push(Fazeracoes.pop());

				}
				if (acao == "setarnome"){

					String nome = Empregado.empregados.get(Empregado.BuscarID(id)).getNome();				
					Empregado.empregados.get(Empregado.BuscarID(id)).setNome(((Empregado) Fazeracoes.peek()).getNome());
					E.setNome(nome);
					Desfazer.push(Fazer.pop());
					Desfazeracoes.push(Fazeracoes.pop());
					Empregado.imprimir(id);

				}
				if (acao == "setarendereço"){
					String endereço = Empregado.empregados.get(Empregado.BuscarID(id)).getEndereço();
					Empregado.empregados.get(Empregado.BuscarID(id)).setEndereço(((Empregado) Fazeracoes.peek()).getEndereço());
					E.setEndereço(endereço);
					Desfazer.push(Fazer.pop());
					Desfazeracoes.push(Fazeracoes.pop());
					Empregado.imprimir(id);
				}


				if (acao == "setarmetodo"){
					String metodo = Empregado.empregados.get(Empregado.BuscarID(id)).getMetodo();
					Empregado.empregados.get(Empregado.BuscarID(id)).setMetodo(((Empregado) Fazeracoes.peek()).getMetodo());
					E.setMetodo(metodo);
					Desfazer.push(Fazer.pop());
					Desfazeracoes.push(Fazeracoes.pop());
					Empregado.imprimir(id);

				}
				if (acao == "setarsindicato"){

					boolean sindicato = Empregado.empregados.get(Empregado.BuscarID(id)).isSindicato();
					Empregado.empregados.get(Empregado.BuscarID(id)).setSindicato(((Empregado) Fazeracoes.peek()).isSindicato());
					E.setSindicato(sindicato);
					Desfazer.push(Fazer.pop());
					Desfazeracoes.push(Fazeracoes.pop());
					Empregado.imprimir(id);

				}
				if (acao =="setartipodecontrato"){

					if (Empregado.isHorista(E)){
						Horista H = Empregado.CloneHorista(E);
						Empregado.empregados.set(Empregado.BuscarID(id), H);
						Desfazer.push(Fazer.pop());
						Desfazeracoes.push(Fazeracoes.pop());
					}
					if (Empregado.isAssalariado(E)){
						Assalariado A = Empregado.CloneAssalariado(E);
						Empregado.empregados.set(Empregado.BuscarID(id), A);
						Desfazer.push(Fazer.pop());
						Desfazeracoes.push(Fazeracoes.pop());
					}
					if (Empregado.isComissionado(E)){
						Comissionado C = Empregado.CloneComissionado(E);
						Empregado.empregados.set(Empregado.BuscarID(id), C);
						Desfazer.push(Fazer.pop());
						Desfazeracoes.push(Fazeracoes.pop());
					}
					Empregado.imprimir(id);
				}

				if (acao == "setaridsindical"){

					int idsindical = Empregado.empregados.get(Empregado.BuscarID(id)).getIDsindical();
					Empregado.empregados.get(Empregado.BuscarID(id)).setIDsindical(((Empregado) Fazeracoes.peek()).getIDsindical());
					E.setIDsindical(idsindical);
					Desfazer.push(Fazer.pop());
					Desfazeracoes.push(Fazeracoes.pop());
					Empregado.imprimir(id);

				}
				if (acao == "setartaxasindical"){
					double taxasindical = Empregado.empregados.get(Empregado.BuscarID(id)).getTaxasindical();
					Empregado.empregados.get(Empregado.BuscarID(id)).setTaxasindical(((Empregado) Fazeracoes.peek()).getTaxasindical());
					E.setTaxasindical(taxasindical);
					Desfazer.push(Fazer.pop());
					Desfazeracoes.push(Fazeracoes.pop());
					Empregado.imprimir(id);

				}

			}
			if (O instanceof CartaoDePonto){

				CartaoDePonto C = (CartaoDePonto) O;
				C.ListadeCartoes.remove(C.BuscarIndiceNumeroCartao(((CartaoDePonto) Fazeracoes.peek()).getNumerodocartao()));
				Desfazer.push(Fazer.pop());
				Desfazeracoes.push(Fazeracoes.pop());
			}
			if (O instanceof Venda){

				Venda V = (Venda) O;
				V.ListaVendas.remove(V.BuscarIndiceVenda(((Venda) Fazeracoes.peek()).getNumerodavenda()));
				Desfazer.push(Fazer.pop());
				Desfazeracoes.push(Fazeracoes.pop());
			}

			if (O instanceof Sindicato){

				Sindicato S  = (Sindicato) O;
				S.ListaSindicato.remove(S.BuscarIndiceNumerodeTaxa (((Sindicato) Fazeracoes.peek()).getNumero()));
				Desfazer.push(Fazer.pop());
				Desfazeracoes.push(Fazeracoes.pop());
			}
			System.out.println("\tAção desfeita.");
		}


	}
	@SuppressWarnings("static-access")
	static void refazerAcao(){

		if (Desfazeracoes.isEmpty() == true){
			System.out.println("\tNão existem ações para serem refeitas");
		}
		else{
			String acao = Desfazer.peek();
			Object O = Desfazeracoes.peek();
			if (O instanceof Empregado){
				Empregado E = (Empregado) O;
				int id= E.getID();
				if (acao  == "adicionar"){

					Empregado.empregados.add(E);
					Fazer.push(Desfazer.pop());
					Fazeracoes.push(Desfazeracoes.pop());
					Empregado.imprimir(id);
				}
				if (acao  != "adicionar" && acao != "remover"){

					Empregado.empregados.set(Empregado.BuscarID(id), E);
					Fazer.push(Desfazer.pop());
					Fazeracoes.push(Desfazeracoes.pop());
					Empregado.imprimir(id);
				}

				if (acao == "remover"){

					Empregado.empregados.remove(Empregado.BuscarID(id));
					Fazer.push(Desfazer.pop());
					Fazeracoes.push(Desfazeracoes.pop());


				}

			}
			if (O instanceof CartaoDePonto){

				CartaoDePonto C = (CartaoDePonto) O;
				C.ListadeCartoes.add( (CartaoDePonto)Desfazeracoes.peek());
				Fazer.push(Desfazer.pop());
				Fazeracoes.push(Desfazeracoes.pop());
			}
			if (O instanceof Venda){

				Venda V = (Venda) O;
				V.ListaVendas.add( (Venda)Desfazeracoes.peek());
				Fazer.push(Desfazer.pop());
				Fazeracoes.push(Desfazeracoes.pop());
			}

			if (O instanceof Sindicato){


				Sindicato  S = (Sindicato) O;
				S.ListaSindicato.add((Sindicato) Desfazeracoes.peek());
				Fazer.push(Desfazer.pop());
				Fazeracoes.push(Desfazeracoes.pop());
			}
			System.out.println("\tAção refeita.");
			
		}

	}


}
