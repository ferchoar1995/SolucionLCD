package LCDTester;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExtraccionDigitosDos
{
	 
	private List<String> listaComando = new ArrayList<>();
	private final String CADENA_FINAL;
	private  List<String> Espacio= new ArrayList<>(); 
	Scanner lector = new Scanner(System.in);
	
	ExtraccionDigitosDos(String b)
	{
		
		this.CADENA_FINAL=b;
	}
	public List<String> getEspacio() 
    {
	     return Espacio;
	}

    public void setEspacio(List<String> Espacio) //  Se crea esta clase con el fin de poder obtener el Size, los dígitos y el espacio 
                                                 //  entre dígitos por teclado y se corrige la repetición de la palabra Entrada:
                                                 //  y se crea una nueva lógica para la adquisición de la información.
    {
			this.Espacio = Espacio;
    }
    
	public List<String> getListaComando() 
	{
         return listaComando;
    }

	public void setListaComando(List<String> listaComando) 
	{
		this.listaComando = listaComando;
	}
	
	public void LecturaDigitosEntrada()
	{ 
	int Bandera=0;
	System.out.print("Ingrese los dígitos a imprimir o ingrese 0,0 si desea terminar: ");
	 while(Bandera!=1)
       {   
		String comando;
	    comando = lector.nextLine();
	    String[]TamanoEntrada= comando.split(" ");                  
	    for (int i = 0; i < TamanoEntrada.length; i++)
	    {	
	     if(!TamanoEntrada[i].equalsIgnoreCase(this.CADENA_FINAL))
	     {   				
	    	 getListaComando().add(TamanoEntrada[i]);                                
	     }
		 else
		 {
		  Bandera=1;
		 }
		}
	    if(Bandera!=1)
	    {
	    System.out.print("Ingrese los dígitos a imprimir de nuevo o ingrese 0,0 si desea terminar: ");
	    }
	   }
    }
	 
	public void LecturaEspaciosEntrada()
	{
		 
		 for (int i = 1; i-1< getListaComando().size(); i++)
		 {
			  System.out.print("Ingrese el espacio para los dígitos "+i+" (Entre 0 y 5) :");
			  getEspacio().add(lector.next());
		 }
	}
	
}