package LCDTester;

public class LCDtesteadorDos {

	public static void main(String[] args) {
		ExtraccionDigitosDos EDigitos = new ExtraccionDigitosDos("0,0");//Se sobrecarga el constructor con el criterio de parada 0,0 que puede ser extendido a cualquier criterio de parada
	    EDigitos.LecturaDigitosEntrada();
	    EDigitos.LecturaEspaciosEntrada();
	    LCDImpresorDos ImpresorLCD = new LCDImpresorDos("|", "-");//Se sobrecarga el constructor con los simbolos con los cuales se desea imprimir el numero
	    ImpresorLCD.Digitos(EDigitos.getListaComando(),EDigitos.getEspacio());
	    //Se elimina toda la lógica del main y se agrega a las otras clases
	}

}
