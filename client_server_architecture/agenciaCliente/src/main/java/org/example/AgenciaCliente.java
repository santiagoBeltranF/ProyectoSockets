package org.example;

import org.example.models.Persona;
import org.example.util.Mensaje;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class AgenciaCliente {

    private static final String HOST = "localhost";
    private static final int PUERTO = 9992;

    public void registrarCliente(String nombre, String identificacion, String email, String
            direccion, String telefono){
//Se intenta abrir una conexión a un servidor remoto usando un objeto Socket
        try (Socket socket = new Socket(HOST, PUERTO)){
//Se crean flujos de datos de entrada y salida para comunicarse a través del socket
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            //Se crea un cliente con los datos obtenidos desde la ventana
            Persona cliente = Persona.builder()
                    .nombre(nombre)
                    .identificacion(identificacion)
                    .email(email)
                    .direccion(direccion)
                    .telefono(telefono)
                    .build();


//Se envía un mensaje al servidor con los datos de la petición
            out.writeObject( Mensaje.builder()
                    .tipo("agregarCliente")
                    .contenido(cliente).build() );
//Obtenemos la respuesta del servidor
            Object respuesta = in.readObject();
//Se imprime la respuesta del servidor. Según la respuesta se podría lanzar una excepción
            System.out.println(respuesta);
//Se cierran los flujos de entrada y de salida para liberar los recursos
            in.close();
            out.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Persona> listarClientes(){
//Se intenta abrir una conexión a un servidor remoto usando un objeto Socket
        try (Socket socket = new Socket(HOST, PUERTO)){
//Se crean flujos de datos de entrada y salida para comunicarse a través del socket
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
//Se envía un mensaje al servidor con los datos de la petición
            out.writeObject( Mensaje.builder()
                    .tipo("listarClientes").build() );
//Obtenemos la respuesta del servidor
            Object respuesta = in.readObject();
//Se hace un casting de la respuesta Object a un ArrayList<Cliente>
            ArrayList<Persona> list = (ArrayList<Persona>) respuesta;
//Se cierran los flujos de entrada y de salida para liberar los recursos
            in.close();
            out.close();
//Se retorna a lista de clientes
            return list;
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }


        }
