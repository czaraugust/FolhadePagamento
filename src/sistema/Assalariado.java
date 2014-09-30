package sistema;

public class Assalariado extends Empregado{
	
	protected  double salario;
	

	public Assalariado(String nome, String endereço, double salario, String metodo, int ID, boolean sindicato) 
	{
		super (nome, endereço, "Assalariado",metodo, ID, sindicato);
		
		this.salario = salario;
	}


	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	

	
	

}
