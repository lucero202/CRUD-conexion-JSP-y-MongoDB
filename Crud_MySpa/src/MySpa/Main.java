package MySpa;

import java.net.UnknownHostException;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;


public class Main {

	public static void main(String args[]) {

		ArrayList<Cliente> Client = new ArrayList<Cliente>();
		ArrayList<Empleado> Emple = new ArrayList<Empleado>();
		ArrayList<Reserva> Reser = new ArrayList<Reserva>();
		ArrayList<Servicio> Servi = new ArrayList<Servicio>();
//----------------------------------------------------------------------------------------------------------------------------	
		Client.add(new Cliente(101,"Carlos Martinez", 321404, "carlosm@gmail.com", "calle 3 #5-66", 30));
		Client.add(new Cliente(202,"Lucia Camargo", 3123034, "luciacm@gmail.com", "calle 8 # 7-66", 41));
		Client.add(new Cliente(303,"Guillero Fernandez", 310444, "guillermof@gmail.com", "calle 9 # 7-44", 20));
	
		Emple.add(new Empleado(123,"Camila", 5680302, "Corporal"));
		Emple.add(new Empleado(156,"Lina", 5680302, "Belleza"));
		Emple.add(new Empleado(168,"Roberto", 5680302, "Salud"));
		
		Reser.add(new Reserva(9911, "Exfoliacion", 20032020, 9, 25000, "belleza",  101, 156, 11));
		Reser.add(new Reserva(9911, "Masaje Redcutor", 15052020, 15, 40000, "corporal",  202, 123, 22));
		Reser.add(new Reserva(9911, "Limpieza Facil", 01052020, 8, 15000, "belleza",  404, 156, 33));
		
		
		Servi.add(new Servicio(11,"Exfoliacion", 50000));
		Servi.add(new Servicio(22,"Masaje Reductor", 80000));
		Servi.add(new Servicio(33, "Exfoliacion", 30000));
		
		
//-----------------------------------------------------------------------------------------------------------------------------		
		try {
		// PASO 1: Conexion al Server de MongoDB Pasandole el host y el puerto
			MongoClient mongoClient = new MongoClient("localhost", 27017);

		// PASO 2: Conexion a la base de datos
			DB db = mongoClient.getDB("MySpa");

		// PASO 3: Obtenemos una coleccion para trabajar con ella
			DBCollection collection = db.getCollection("Cliente");
			DBCollection collection1 = db.getCollection("Empleado");
			DBCollection collection2 = db.getCollection("Reserva");
			DBCollection collection3 = db.getCollection("Servicio");

		/*	
		// PASO 4: CRUD (Create-Read-Update-Delete)

			// PASO 4.1: "CREATE" -> Creamos las colecciones del Spa
			for (Cliente cli : Client) {
				collection.insert(cli.dBObjectcliente());
			}
			for (Empleado emp : Emple) {
				collection1.insert(emp.dBObjectempleado());
			}
			for (Reserva res : Reser) {
				collection2.insert(res.dBObjectreserva());
			}
			for (Servicio ser : Servi) {
				collection3.insert(ser.dBObjectservicio());
			}
			*/
//--------------------------------------------------------------------------------------------------------------------------------------------------
		
			// PASO 4.2.1: "READ" -> Leemos todos los documentos de la base de datos
			int numCliente = (int) collection.getCount();
			System.out.println("Numero de Codigos en la coleccion Clientes: " + numCliente + "\n");
			DBCursor cursor = collection.find();
			try {
				while (cursor.hasNext()) {
					System.out.println(cursor.next().toString());
				}
			} finally {
				cursor.close();
			}
			
			int numEmpleados = (int) collection1.getCount();
			System.out.println("Numero de Codigos en la coleccion Empleados: " + numEmpleados + "\n");
			DBCursor cursor1 = collection1.find();
			try {
				while (cursor1.hasNext()) {
					System.out.println(cursor1.next().toString());
				}
			} finally {
				cursor1.close();
			}
			
			int numReserva = (int) collection2.getCount();
			System.out.println("Numero de Codigos en la coleccion Reservas: " + numReserva + "\n");
			DBCursor cursor2 = collection2.find();
			try {
				while (cursor2.hasNext()) {
					System.out.println(cursor2.next().toString());
				}
			} finally {
				cursor2.close();
			}
			
			int numServicio = (int) collection3.getCount();
			System.out.println("Numero de Codigos en la coleccion Servicios: " + numServicio + "\n");
			DBCursor cursor3 = collection3.find();
			try {
				while (cursor3.hasNext()) {
					System.out.println(cursor3.next().toString());
				}
			} finally {
				cursor3.close();
			}
			
			
			// PASO 4.2.2: "READ" -Buscar Rerservas que sean Corporales y lo pasamos a un objeto Java
			System.out.println("\nReservas que sean de la categoria Corporal");
			DBObject query = new BasicDBObject("cat_reserva", new BasicDBObject("$regex", "Corporal"));
			cursor = collection.find(query);
			try {
				while (cursor2.hasNext()) {
					Reserva Reserv = new Reserva((BasicDBObject) cursor2.next());
					System.out.println(Reserv.toString());
				}
			} finally {
				cursor.close();
			}
		//} 
			
//------------------------------------------------------------------------------------------------------------------------------
			/*
			// PASO 4.3: "UPDATE" -> Actualizamos el valor de la reserva Corporal. Agregamos 25000 a las servicios con valor de 50000
			DBObject find = new BasicDBObject("Valor Reserva", new BasicDBObject("$lte", 25000));
			DBObject updated = new BasicDBObject().append("$inc", new BasicDBObject().append("Servcio", 50000));
			collection1.update(find, updated, false, true);
			try {
				while (cursor1.hasNext()) {
					System.out.println(cursor1.next().toString());
				}
			} finally {
				cursor1.close();
			}
			*/
//------------------------------------------------------------------------------------------------------------------------------	
			
			//PASO 4.4: "DELETE" -> Borramos todas las Reserva que sean (Reserva=true)
			DBObject findDoc = new BasicDBObject("Reserva", true);
			collection.remove(findDoc);

	
		
			
		// PASO FINAL: Cerrar la conexion
			mongoClient.close();

		} 
		catch (Exception ex) {
			System.out.println("Exception al conectar al server de Mongo: " + ex.getMessage());
		}

	}

}
