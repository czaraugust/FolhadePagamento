package sistema;


public class Comissionado extends Assalariado {
	private double comissao;
	private double salario;





	public Comissionado (String nome, String endereço, double salario, double comissao, String  metodo, int id, boolean sindicato ){
		super (nome, endereço, salario, metodo , id, sindicato);

		this.salario = salario;
		this.tipo = "Comissionado";
		this.comissao = comissao;


	}

	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}

}
