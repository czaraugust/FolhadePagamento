package sistema;

public class Horista  extends Empregado {

	private double salariohora;
	public Horista (String nome, String endere�o, double salariohora, String metodo, int ID, boolean sindicato) {
		super (nome, endere�o, "Horista" , metodo, ID, sindicato);
		this.salariohora = salariohora;

	}

	public double getSalariohora() {
		return salariohora;
	}

	public void setSalariohora(double salariohora) {
		this.salariohora = salariohora;
	}

}