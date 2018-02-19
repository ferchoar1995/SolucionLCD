package LCDTester;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LCDImpresorDos{ //extends ExtraccionDigitosDos{
	

	
	private int[] pf1;
	private int[] pf2;
	private int[] pf3;
	private int[] pf4;
	private int[] pf5;
	private String[][] matrizImpr;
	private final String CARACTER_VERTICAL;
	private final String CARACTER_HORIZONTAL;// Se corrigen todos los tipos de variables
	private final String POSICION_X;
	private final String POSICION_Y;
	private int size;
    private int filasDig;
    private int columDig;
    private int totalFilas;
    private int totalColum;
    
    
    LCDImpresorDos(String a,String b) {
    	
    	this.pf1 = new int[2];
        this.pf2 = new int[2];
        this.pf3 = new int[2];
        this.pf4 = new int[2];
        this.pf5 = new int[2];// Se genera un método constructor funcional
        this.CARACTER_VERTICAL = a;
        this.CARACTER_HORIZONTAL=b;
        this.POSICION_X= "X";
        this.POSICION_Y= "Y";
    }

    static boolean isNumeric(String cadena)
    {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
   public void Digitos(List<String> a, List<String> b){
	   Iterator<String> iterator = a.iterator(); 
	   Iterator<String> iteradorEsp = b.iterator();//Se agrega una variable mas que es Espacio para que el usuario pueda
                                                   //también escoger la separación entre digitos y se agrega un nuevo método 
	                                               //para la ejecución de cada Dígito ingresado
	
	   while (iterator.hasNext()) 
      {
	   try 
       {
		    
           procesar(iterator.next(),iteradorEsp.next());       
		   
       } 
       catch (Exception ex) 
       {
       	
           System.out.println("Error: "+ex.getMessage());
       }
      }
	   
	   
	   
   }
   public void procesar(String comando, String espacioDig) {
       
       String[] parametros; 

       if (!comando.contains(",")) {
           throw new IllegalArgumentException("Cadena " + comando + " no contiene carácter ,");
       }
       
       //Se hace el split de la cadena
       parametros = comando.split(",");
       
       //Valida la cantidad de parametros
       if(parametros.length>2)
       {
          throw new IllegalArgumentException("Cadena " + comando+ " contiene más carácteres válidos ',' de los necesarios"); // Se elimina parametros.length<2 Porqué si es menor que dos simplemente no contiene carácter
       }
       if(isNumeric(parametros[0]))
       {
           if(Integer.parseInt(parametros[0]) <1 || Integer.parseInt(parametros[0]) >10)
           {
               throw new IllegalArgumentException("El párametro size ["+ parametros[0]+ "] debe estar entre 1 y 10");
           }
       }
       else
       {
           throw new IllegalArgumentException("El párametro Size [" + parametros[0] + "] no es un número");
       }
       if( !isNumeric(espacioDig))
       {
    	   throw new IllegalArgumentException("El espacio " + espacioDig + " no es un número");// Se agrega excepción para que el espacio ingresado sea número
       }
       
       if( !isNumeric(parametros[1]))
       {
    	   throw new IllegalArgumentException("Los dígitos " + parametros[1] + " no son un número");// Se agrega excepción para que los digitos o tamaño ingresados sean números
       }
       //Valida que el parametro size sea un numerico
       if(Integer.parseInt(parametros[1])<0)
       {
       	throw new IllegalArgumentException("Size " + parametros[1]+ " es un número negativo");// Se agrega una excepción si es negativa el size              
       }
       if(Integer.parseInt(parametros[1])<0)
       {
       	throw new IllegalArgumentException("Dígitos " + parametros[0]+ " es un número negativo");// Se agrega una excepción si son negativos los digitos             
       }
       
       if(Integer.parseInt(espacioDig)<=0 || Integer.parseInt(espacioDig)>5)
       {
          throw new IllegalArgumentException("Espacio " + espacioDig + " es menor que cero o supera el valor máximo permitido"); // Se agrega pr
       }
       imprimirNumero(Integer.parseInt(parametros[0]), parametros[1],Integer.parseInt(espacioDig));

   }
     
  private void imprimirNumero(int size, String numeroImp, int espacio) 
  {
      char[] digitos;
      int pivotX =0;
      this.size = size;
     

      // Calcula el numero de filas cada digito
      this.filasDig = (2 * this.size) + 3;

      // Calcula el numero de columna de cada digito
      this.columDig = this.size + 2;

      // Calcula el total de filas de la matriz en la que se almacenaran los digitos
      this.totalFilas = this.filasDig;

      // Calcula el total de columnas de la matriz en la que se almacenaran los digitos
      this.totalColum = (this.columDig * numeroImp.length())
              + (espacio * numeroImp.length());

      // crea matriz para almacenar los numero a imprimir
      this.matrizImpr = new String[this.totalFilas][this.totalColum];

      // crea el arreglo de digitos
      digitos = numeroImp.toCharArray();

      // Inicializa matriz
      for (int i = 0; i < this.totalFilas; i++) {
          for (int j = 0; j < this.totalColum; j++) {
              this.matrizImpr[i][j] = " ";
          }
      }

      for (char digito : digitos) {
          
    	 
          int numero = Integer.parseInt(String.valueOf(digito));

          //Calcula puntos fijos
          this.pf1[0] = 0;
          this.pf1[1] = 0 + pivotX;

          this.pf2[0] = (this.filasDig / 2);
          this.pf2[1] = 0 + pivotX;

          this.pf3[0] = (this.filasDig - 1);
          this.pf3[1] = 0 + pivotX;

          this.pf4[0] = (this.columDig - 1);
          this.pf4[1] = (this.filasDig / 2) + pivotX;

          this.pf5[0] = 0;
          this.pf5[1] = (this.columDig - 1) + pivotX;

          pivotX = pivotX + this.columDig + espacio;

          adicionarDigito(numero);
      }

      // Imprime matriz
      for (int i = 0; i < this.totalFilas; i++) {
          for (int j = 0; j < this.totalColum; j++) {
              System.out.print(this.matrizImpr[i][j]);
          }
          System.out.println();
      }
  }
    
     
    private void adicionarLinea(String[][] matriz, int[] punto, String posFija,
            int size, String caracter) {

        if (posFija.equalsIgnoreCase(POSICION_X)) 
        {
            for (int y = 1; y <= size; y++) 
            {
                int valor = punto[1] + y;
                matriz[punto[0]][valor] = caracter;
            }
        } 
        else 
        {
            for (int i = 1; i <= size; i++) 
            {
                int valor = punto[0] + i;
                matriz[valor][punto[1]] = caracter;
            }
        }
    }
    
   private void adicionarDigito(int numero) {

       // Establece los segmentos de cada numero
       List<Integer> segList = new ArrayList<>();

       switch (numero) {
           case 1:
               segList.add(3);
               segList.add(4);
               break;
           case 2:
               segList.add(5);
               segList.add(3);
               segList.add(6);
               segList.add(2);
               segList.add(7);
               break;
           case 3:
               segList.add(5);
               segList.add(3);
               segList.add(6);
               segList.add(4);
               segList.add(7);
               break;
           case 4:
               segList.add(1);
               segList.add(6);
               segList.add(3);
               segList.add(4);
               break;
           case 5:
               segList.add(5);
               segList.add(1);
               segList.add(6);
               segList.add(4);
               segList.add(7);
               break;
           case 6:
               segList.add(5);
               segList.add(1);
               segList.add(6);
               segList.add(2);
               segList.add(7);
               segList.add(4);
               break;
           case 7:
               segList.add(5);
               segList.add(3);
               segList.add(4);
               break;
           case 8:
               segList.add(1);
               segList.add(2);
               segList.add(3);
               segList.add(4);
               segList.add(5);
               segList.add(6);
               segList.add(7);
               break;
           case 9:
               segList.add(1);
               segList.add(3);
               segList.add(4);
               segList.add(5);
               segList.add(6);
               segList.add(7);
               break;
           case 0:
               segList.add(1);
               segList.add(2);
               segList.add(3);
               segList.add(4);
               segList.add(5);
               segList.add(7);
               break;
           default:
               break;
       }

       Iterator<Integer> iterator = segList.iterator();

       while (iterator.hasNext()) {
           adicionarSegmento(iterator.next());
       }
   }


    private void adicionarSegmento(int segmento) {

        switch (segmento) {
            case 1:
                adicionarLinea(this.matrizImpr, this.pf1, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 2:
                adicionarLinea(this.matrizImpr, this.pf2, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 3:
                adicionarLinea(this.matrizImpr, this.pf5, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 4:
                adicionarLinea(this.matrizImpr, this.pf4, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 5:
                adicionarLinea(this.matrizImpr, this.pf1, POSICION_X,
                        this.size, CARACTER_HORIZONTAL);
                break;
            case 6:
                adicionarLinea(this.matrizImpr, this.pf2, POSICION_X,
                        this.size, CARACTER_HORIZONTAL);
                break;
            case 7:
                adicionarLinea(this.matrizImpr, this.pf3, POSICION_X,
                        this.size, CARACTER_HORIZONTAL);
                break;
            default:
                break;
        }
    }

   

}
