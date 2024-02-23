package org.example.util;

import org.example.AgenciaServidor;
import org.example.models.Persona;
import org.example.models.Reserva;
import org.example.models.dtos.ReservaDTO;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class HiloCliente implements Runnable {
    private final Socket socket;
    private final AgenciaServidor agencia;

    public HiloCliente(Socket socket, AgenciaServidor agencia) {
        this.socket = socket;
        this.agencia = agencia;
    }

    @Override
    public void run() {
        try {
            //Se crean flujos de datos de entrada y salida para comunicarse a través del socket
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            while (true) {
                //Se lee el mensaje enviado por el cliente
                Mensaje mensaje = (Mensaje) in.readObject();

                System.out.println(mensaje.toString());

                //Se captura el tipo de mensaje
                String tipo = mensaje.getTipo();
                //Se captura el contenido del mensaje
                Object contenido = mensaje.getContenido();

                //Según el tipo de mensaje se invoca el método correspondiente
                switch (tipo) {
                    case "agregarCliente":
                        agregarCliente((Persona) contenido, out);
                        break;
                    case "AgregarReserva":
                        agregarReserva((Reserva) contenido, out);
                        break;
                    case "listarClientes":
                        listarClientes(out);
                        break;
                    case "listarPaquetes":
                        listarPaquetes(out);
                        break;
                    case "listarReservas":
                        listarReservas(out);
                        break;
                    case "salir":
                        //Si el cliente envía un mensaje de salir, se cierra la conexión del socket
                        socket.close();
                        return;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }


    public void agregarCliente(Persona persona, ObjectOutputStream out) throws IOException {
        try {
            agencia.agregarCliente(persona);
            out.writeObject("Cliente agregado correctamente");

        } catch (Exception e) {
            out.writeObject(e.getMessage());
        }
    }

    public void agregarReserva(Reserva reserva, ObjectOutputStream out) throws IOException {
        try {
            agencia.agregarReserva(reserva);
            out.writeObject("Cliente agregado correctamente");

        } catch (Exception e) {
            out.writeObject(e.getMessage());
        }
    }

    public void listarClientes(ObjectOutputStream out) throws IOException {
        out.writeObject(agencia.listarClientes());
    }

    public void listarPaquetes(ObjectOutputStream out) throws IOException {
        out.writeObject(agencia.listarPaquetesTuristicos());
    }

    public void listarReservas(ObjectOutputStream out) throws IOException {
        out.writeObject(agencia.listarReserva());
    }

}
