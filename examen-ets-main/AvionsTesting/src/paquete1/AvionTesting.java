package paquete1;

/*
Actividad 4 (RA3: f, g, h, i)

Se realiza en clase

Se proporciona el código de una clase llamada Avion.java
	⁃	Crea una clase de prueba para comprobar el
	 correcto funcionamiento de los métodos: 
	 
	 
	 getAutonomiaVuelo,
	  getCosteVuelo, puedeVolarDistancia, tiempoVueloEstimado. 
	  Emplea la anotación @BeforeEach y @BeforeAll e indica en comnetando
	   el código para que se usa cada uno de ellas. 7p
	   
	⁃	Realiza la cobertura de pruebas
	 y muestra al profesor las mismas. 3P

El profesor lo corrige a medida que 
lo vayan terminando en vuestro ordendador
*/

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AvionTesting {
	//Variables a usar en las pruebas 
	//(String modelo, String aerolinea, double capacidadCombustible) {
	static String modelo;
	static String aerolinea;
	static double capacidadCombustible;
	static Avion fz;
	static double consumoPorHora;
	static double costeCombustible;
	static double distancia;
	static double consumoPorKm;
	static double velocidadMedia;
	
	//var para llevar control sobre metodos ejecutados
	static int contadorMetodos;
	static int metodoFallido;
	static int metodoSinFallos;
	
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//Asignacion de valor variables staticas:
		modelo ="FZ-103";
		aerolinea = "RyanAir";
		capacidadCombustible = 1000;
		consumoPorHora= 200;
		costeCombustible=30;
		distancia = 10;
		consumoPorKm = 5;
		velocidadMedia= -22;
		
		
		contadorMetodos=0;
		metodoFallido = 0;
		metodoSinFallos = 0;
	}

	
	@BeforeEach
	void setUp() throws Exception {
		//creacion de objeto de tipo Avion
		fz = new Avion(modelo,aerolinea,capacidadCombustible);
		//mensaje que indica el inicio de una prueba:
		System.out.println("Iniciando prueba del metodo:");
		contadorMetodos++;
	}
	
	//uso de anotacion DisplayName para modificar el nombre que sale por pantalla en la ventana de ejecuccion de prubas de junit
	@DisplayName(value="Test getAutonomiaVuelo") 
	@Test
	void testGetAutonomiaVuelo() {
		//uso de try/catch statement para manipular un posible fallo en la ejecucion y poder aportar mas informacion o realizar acciones que consideremos oportunas y adecuadas
		try {
			//mensaje con el nombre del metodo a probar
			System.out.println("getAutonomiaVuelo");
			//assertEquals usado para comprobar si el resultado que esperamos es el mismo que el real
			//0.0001 es el delta/margen usado para decir apartir de que posicion decimal no consideramos que sea un fallo en la ejecucion de la prueba
			//el mensaje del final aparecera en caso de haber disconcordancias en la ejecucion, este mensaje aparecera en la venta de "Failure Trace " esto aportara mas informacion y facilitara la lectura de las pruebas
			assertEquals(capacidadCombustible/consumoPorHora, 
					fz.getAutonomiaVuelo(consumoPorHora),
					0.001 ,
					"metodo getAutonomiaVuelo ha fallado."); 
    		System.out.println("No se ha encontrado fallos/errores en la ejecucion de: getAutonomiaVuelo");
    		//En caso de no haber un error se le suma uno a metodosSinFallos.
    		metodoSinFallos++;
    	}
		
    	catch(AssertionError e){
    		System.err.println("Fallo en la ejecucion de getAutonomiaVuelo");
    		//En caso de haber un fallo se le suma uno a metodoFallido.
    		metodoFallido++;
    		//Re-lanzar para que la prueba marque el fallo en JUnit
    		throw e;
    	}
	
	
	}
	
	
	
 

	@DisplayName(value="Test getCosteVuelo") //uso de anotacion DisplayName para modificar el nombre que sale por pantalla en la ventana de ejecuccion de prubas de junit
	@Test
	void testGetCosteVuelo() {
		try {
			//mensaje con el nombre del metodo a probar
			System.out.println("getCosteVuelo");
			
			assertEquals(capacidadCombustible/consumoPorHora * costeCombustible, 
					fz.getCosteVuelo(consumoPorHora, costeCombustible),
					0.001 ,
					"metodo getCosteVuelo ha fallado."); 
    		System.out.println("No se ha encontrado fallos/errores en la ejecucion de: getCosteVuelo");
    		metodoSinFallos++;
    	}
    	catch(AssertionError e){
    		System.err.println("Fallo en la ejecucion de getCosteVuelo");
    		metodoFallido++;
    		// Re-lanzar para que la prueba marque el fallo en JUnit
    		throw e;
    	}
	}
	
	
	
	
	
	@DisplayName(value="Test puedeVolarDistancia true") 
	@Test
	void testPuedeVolarDistancia() {
		try {
			//mensaje con el nombre del metodo a probar
			System.out.println("puedeVolarDistancia");
			
			assertTrue(fz.puedeVolarDistancia(distancia, consumoPorKm),
	                   "Error: El método puedeVolarDistancia no devuelve true para distancia=" 
	                   + distancia + " y consumoPorKm=" + consumoPorKm); 
    		System.out.println("No se ha encontrado fallos/errores en la ejecucion de: puedeVolarDistancia");
    		metodoSinFallos++;
		}
    	catch(AssertionError e){
    		System.err.println("Fallo en la ejecucion de puedeVolarDistancia");
    		metodoFallido++;
    		// Re-lanzar para que la prueba marque el fallo en JUnit
    		throw e;
    	}
	}
	
	
	
	@DisplayName(value="Test tiempoVueloEstimado comprobacion de que el mensaje no es lanzado") 
	@Test
	void testTiempoVueloEstimadox() { //comprobacion de que lanza el mensaje de error correctamente
		System.out.println("tiempoVueloEstimado"); 
		try {
			 assertEquals(capacidadCombustible / consumoPorHora, 
					 fz.tiempoVueloEstimado(consumoPorHora),
					 0.0001,
					 "Fallo tiempoVueloEstimado no devuelve el valor esperado.");
			 metodoSinFallos++;
			 
		 }
		catch(AssertionError e ){
			System.err.println("Fallo en el metodo testTiempoVueloEstimado al comprobar los datos que devuelve.");
			metodoFallido++;
			throw e;
			
		}
		
		
		
	}
	
	
	
	
	@DisplayName(value="Test tiempoVueloEstimado comprobacion de que el mensaje es lanzado") 
	@Test
	void testTiempoVueloEstimadoy() { //comprobacion de que lanza el mensaje de error correctamente
		System.out.println("tiempoVueloEstimado"); 
		try {
	            double tiempo = fz.tiempoVueloEstimado(velocidadMedia); // Debería lanzar IllegalArgumentException
	            fail("Se esperaba una IllegalArgumentException, pero no se lanzó.");
	            
	        } catch (IllegalArgumentException e) {
	            assertEquals("La velocidad debe ser mayor que 0", e.getMessage());
	            
	        }
	}
	
	
	
	
	
	
	
	
	
	@AfterEach
	void tearDown() throws Exception {
		//limpieza y mensaje de finalizacion de metodo y numero de veces que este sea ejecutado:
		System.out.println("Finalizacion del metodo numero: " + contadorMetodos);
		fz =null;
		
		
		
	}
	
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		//mensaje de finalizacion y porcentaje de metodos que han dado error
		System.out.println("Finalizacion de la ejecucion de todos los metodos de la clase Avion");
		System.out.println(String.format("Numero de metodos realizados: %d \n" + 
		"Numero de metodos fallidos: %d \n" + 
				"Numero de metodos sin fallos: %d", 
                contadorMetodos,
                metodoFallido,
                metodoSinFallos));
		
		
		
	}

}
