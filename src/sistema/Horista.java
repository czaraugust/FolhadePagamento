package sistema;

public class Horista  extends Empregado {

	private double salariohora;
	public Horista (String nome, String endereço, double salariohora, String metodo, int ID, boolean sindicato) {
		super (nome, endereço, "Horista" , metodo, ID, sindicato);
		this.salariohora = salariohora;

	}

	public double getSalariohora() {
		return salariohora;
	}

	public void setSalariohora(double salariohora) {
		this.salariohora = salariohora;
	}

}