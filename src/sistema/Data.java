package sistema;

import java.util.GregorianCalendar;


public class Data {

	public Data(){

	}

	@SuppressWarnings("static-access")
	static public boolean VerificaSexta (GregorianCalendar data){
		boolean retorno = false;

		if (data.get(data.DAY_OF_WEEK) == 6){
			retorno = true;

		}

		return retorno;
	}

	@SuppressWarnings("static-access")
	static public boolean VerificaUltimoDiaUtil (GregorianCalendar data){
		boolean retorno = false;
		GregorianCalendar aux = new GregorianCalendar();

		aux.set(aux.YEAR, data.get(data.YEAR));
		aux.set(aux.MONTH, data.get(data.MONTH));
		aux.set(aux.DAY_OF_MONTH, data.getActualMaximum(data.DATE));

		if ((data.get(data.DAY_OF_WEEK)) !=7 && (data.get(data.DAY_OF_WEEK)) !=1){

			if(data.getActualMaximum(data.DAY_OF_MONTH) == data.get(data.DAY_OF_MONTH)){
				retorno = true;
			}

		}

		if (aux.get(aux.DAY_OF_WEEK)== 7 || aux.get(aux.DAY_OF_WEEK)== 1){
			if (VerificaSexta(data)){
				retorno = true;
			}
		}

		if (retorno){
			
		}
		return retorno;
	}

	@SuppressWarnings("static-access")
	static int Setar2aSexta(GregorianCalendar data){
		int dia =0;			
			GregorianCalendar aux = new GregorianCalendar();
			aux.set(aux.YEAR, data.get(data.YEAR));
			aux.set(aux.MONTH, data.get(data.MONTH));

			for (int i =1; i<=7; i++){
				aux.set(aux.DAY_OF_MONTH, i);
				if (aux.get(aux.DAY_OF_WEEK) == 6){
					dia = i;


				}
			}
		
		
		return (dia +14);
	}
	@SuppressWarnings("static-access")
	static public boolean VerificaSextaImpar(GregorianCalendar data){
		boolean retorno = false;
		if (VerificaSexta(data)){
			int dia =0;
			GregorianCalendar aux = new GregorianCalendar();
			aux.set(aux.YEAR, data.get(data.YEAR));
			aux.set(aux.MONTH, data.get(data.MONTH));

			for (int i =1; i<=7; i++){
				aux.set(aux.DAY_OF_MONTH, i);
				if (aux.get(aux.DAY_OF_WEEK) == 6){
					dia = i;
				}
			}

			if(data.get(data.DAY_OF_MONTH)== dia +14) {
				retorno = true;

			}

			if(data.get(data.DAY_OF_MONTH) == (dia +28)){
				retorno = true;

			}
		}

		return retorno;
	}

	@SuppressWarnings("static-access")
	static public boolean Verifica1aSexta(GregorianCalendar data){
		boolean retorno = false;
		if (VerificaSexta(data)){
			int dia =0;
			GregorianCalendar aux = new GregorianCalendar();
			aux.set(aux.YEAR, data.get(data.YEAR));
			aux.set(aux.MONTH, data.get(data.MONTH));

			for (int i =1; i<=7; i++){
				aux.set(aux.DAY_OF_MONTH, i);
				if (aux.get(aux.DAY_OF_WEEK) == 6){
					dia = i;
				}
			}
			if (data.get(data.DAY_OF_MONTH) == dia ){
				retorno = true;

			}


		}
		return retorno;
	}
}