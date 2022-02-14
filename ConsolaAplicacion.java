/**
 * 
 */
package uniandes.dpoo.taller1.consola;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import uniandes.dpoo.taller1.modelo.Combo;
import uniandes.dpoo.taller1.modelo.Ingrediente;
import uniandes.dpoo.taller1.modelo.ProductoMenu;
import uniandes.dpoo.taller1.procesamiento.LoaderAplicacion;
   

/**
 * @author Usuario
 *
 */
public class ConsolaAplicacion 
{
	private ArrayList<Ingrediente> ingredientes;
	
	private ArrayList<ProductoMenu> productosMenu;
	
	private ArrayList<Combo> combos;
	
	public void ejecutarAplicacion()
	{
	//Hola
		cargarArchivo();
		try
		{
			mostrarMenu();
			int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
			
			if (opcion_seleccionada == 1) 
			{
				inicioPedido:
				System.out.println("Aca se debe poder iniciar un nuevo pedido, agregar elementos al pedido y guardar la factura (Se agrega a un "
						+ "mapa la info del pedido del tipo key:id, value:Pedido y se escribe la info en el .csv)");
				System.out.println("\n ¿Desea ordenar un combo o un producto individual?");
				int opcion= Integer.parseInt(input("Escriba 1 si desea un combo o 0 si desea un producto individual"));
				
				// Manejar excepción AIO Exception
				if(opcion == 1) {
					imprimirCombo();
				
				}
				else {
					imprimirMenu();
				}
				
				int opcion1= Integer.parseInt(input("Seleccione el producto que desea"));
				int opcion2 = Integer.parseInt(input("\n¿Desea seguir agregando al carrito o desea terminar su pedido? (1. seguir comprando/2. terminar pedido)"));
				//manejar excepciones
				if(opcion2 ==1)
						{
					
					

						}
				
				
			}
			else if (opcion_seleccionada == 2)
			{
				System.out.println("Aqui se consulta un pedido, para esto se pide al usuario el id y se busca la key en el mapa, se devuelve"
						+ " la informacion del pedido");
			}
			else if (opcion_seleccionada == 3)
			{
				System.out.println("Saliendo de la aplicación ...");
			}
			else
			{
				System.out.println("Por favor seleccione una opción válida.\n\n");
				ejecutarAplicacion();
			}
		}
		catch (Exception e)
		{
			System.out.println("Debe seleccionar uno de los números de las opciones.");
		}
	}

	private void cargarArchivo() 
	{
		LoaderAplicacion listaCarga = new LoaderAplicacion();
		ingredientes = listaCarga.getIngredientes();
		productosMenu = listaCarga.getProductosMenu();
		combos = listaCarga.getCombos();
	}

	private void mostrarMenu() 
	{
		System.out.println("*************************************");
		System.out.println("               MENU                  ");
		System.out.println("1. Iniciar un nuevo pedido");
		System.out.println("2. Consultar un pedido");
		System.out.println("3. Salir de la aplicacion");
	}
	
	public void cargarAplicacion() 
	{
		
	}
	
	/**
	 * Este método sirve para imprimir un mensaje en la consola pidiéndole
	 * información al usuario y luego leer lo que escriba el usuario.
	 * 
	 * @param mensaje El mensaje que se le mostrará al usuario
	 * @return La cadena de caracteres que el usuario escriba como respuesta.
	 */
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
	public void iniciarPedido()
	{
		
	}

	private void imprimirCombo()
	{
		System.out.println("\n\n\n  ");
		System.out.println("*************************************");
		System.out.println("                COMBOS               ");
		System.out.println("NOMBRE            ||           PRECIO \n");
		int i = 0;
		for(Combo combo: combos)
		{
			i ++;
		System.out.println(i + ". " + combo.getNombre()+"   ||   " + combo.calcularPrecio());
		}

	}
	
	private void imprimirMenu()
	{
		System.out.println("\n\n\n  ");
		System.out.println("*************************************");
		System.out.println("               PRODUCTOS             ");
		System.out.println("NOMBRE            ||           PRECIO \n");
		int i = 0;
		for(ProductoMenu producto: productosMenu)
		{
			i ++;
		System.out.println(i + ". " + producto.getNombre()+"   ||   " + producto.getPrecio());
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		ConsolaAplicacion consola = new ConsolaAplicacion();
		consola.ejecutarAplicacion();
	}

}
