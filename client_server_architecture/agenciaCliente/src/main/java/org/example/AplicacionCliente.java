package org.example;

import org.example.models.PaqueteTuristico;
import org.example.models.Persona;
import org.example.models.Reserva;
import org.example.util.Mensaje;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.List;

public class AplicacionCliente {

    public static void main(String[] args) {
        String serverAddress = "localhost"; //Dirección IP del servidor
        int serverPort = 9992; //Puerto del servidor
        try {
            Socket socket = new Socket(serverAddress, serverPort);
            //Flujo de salida para enviar datos al servidor
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            int select;
            while (true) {
                String lectura = JOptionPane.showInputDialog(null,
                        "Elige opción:\n1.- Ver paquetes" +
                        "\n2.- Ver listado clientes\n" +
                        "3.- Reservar paquete\n" +
                        "4.- Ver listado de reservas\n" +
                        "0.- Salir");
                select = Integer.parseInt(lectura);

                List<PaqueteTuristico> lstPaquetes = null;

                switch (select) {
                    case 1:
                        Mensaje message = new Mensaje("listarPaquetes", "Ver paquetes");
                        oos.writeObject(message);

                        lstPaquetes = (List<PaqueteTuristico>) ois.readObject();

                        String salida = "";
                        for (PaqueteTuristico paquete : lstPaquetes) {
                            salida += "Número de paquete: " + paquete.getId() + "\n" +
                                    "Nombre: " + paquete.getNombre() + "\n" +
                                    "Fecha: " + paquete.getFecha() + "\n" +
                                    "Duración en días: " + paquete.getDuracion() + "\n" +
                                    "Lista de destinos: " + paquete.getDestinos() + "\n" +
                                    "-----------------------------------------------------------\n";
                        }
                        JOptionPane.showMessageDialog(null, salida, "Información de paquetes", JOptionPane.INFORMATION_MESSAGE);
                        break;

                    case 2:
                        Mensaje message2 = new Mensaje("listarClientes", "Ver clientes");
                        oos.writeObject(message2);
                        List<Persona> lstPersona =  (List<Persona>) ois.readObject();
                        JOptionPane.showMessageDialog(null, "listado personas = " + lstPersona, "Listado persona", JOptionPane.WARNING_MESSAGE);
                        break;
                    case 3:
                        try {
                            Mensaje message4 = new Mensaje("listarPaquetes", "Ver paquetes");
                            oos.writeObject(message4);

                            lstPaquetes = (List<PaqueteTuristico>) ois.readObject();

                            if (lstPaquetes != null && !lstPaquetes.isEmpty()) {
                                String[] opciones = lstPaquetes.stream().map(PaqueteTuristico::getNombre).toArray(String[]::new);

                                String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione un paquete para hacer la reserva:", "Selección de paquete", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

                                PaqueteTuristico paqueteSeleccionado = lstPaquetes.stream().filter(paquete -> paquete.getNombre().equals(seleccion)).findFirst().orElse(null);

                                if (paqueteSeleccionado != null) {
                                    String idReservaString = JOptionPane.showInputDialog(null, "Ingrese el ID de la reserva:", "ID de reserva", JOptionPane.QUESTION_MESSAGE);
                                    Integer idReserva = Integer.parseInt(idReservaString);
                                    String nombrePersona = JOptionPane.showInputDialog(null, "Ingrese su nombre:", "Nombre de la persona", JOptionPane.QUESTION_MESSAGE);
                                    String identificacionPersona = JOptionPane.showInputDialog(null, "Ingrese su identificación:", "Identificación de la persona", JOptionPane.QUESTION_MESSAGE);
                                    String direccionPersona = JOptionPane.showInputDialog(null, "Ingrese su dirección:", "Dirección de la persona", JOptionPane.QUESTION_MESSAGE);
                                    String telefonoPersona = JOptionPane.showInputDialog(null, "Ingrese su teléfono:", "Teléfono de la persona", JOptionPane.QUESTION_MESSAGE);
                                    String emailPersona = JOptionPane.showInputDialog(null, "Ingrese su email:", "Email de la persona", JOptionPane.QUESTION_MESSAGE);

                                    Persona persona = new Persona();
                                    persona.setNombre(nombrePersona);
                                    persona.setIdentificacion(identificacionPersona);
                                    persona.setDireccion(direccionPersona);
                                    persona.setTelefono(telefonoPersona);
                                    persona.setEmail(emailPersona);

                                    String numeroPersonasString = JOptionPane.showInputDialog(null, "Ingrese el número de personas:", "Número de personas", JOptionPane.QUESTION_MESSAGE);
                                    Integer numeroPersonas = Integer.parseInt(numeroPersonasString);

                                    Reserva reserva = new Reserva(idReserva, persona, new Date(), paqueteSeleccionado, numeroPersonas);

                                    Mensaje message8 = new Mensaje("AgregarReserva", reserva);

                                    oos.writeObject(message8);


                                    JOptionPane.showMessageDialog(null, ois.readObject(), "Confirmación", JOptionPane.INFORMATION_MESSAGE);


                                } else {
                                    JOptionPane.showMessageDialog(null, "No se seleccionó ningún paquete turístico.", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "No se pudieron obtener los paquetes turísticos del servidor.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (IOException | ClassNotFoundException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error al comunicarse con el servidor.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 4:
                        Mensaje message9 = new Mensaje("listarReservas", "Ver reservas");
                        oos.writeObject(message9);
                        List<Reserva> lstReservas =  (List<Reserva>) ois.readObject();
                        JOptionPane.showMessageDialog(null, "listado reservas = " + lstReservas, "Listado reservas", JOptionPane.WARNING_MESSAGE);
                        break;
                    case 0:
                        Mensaje message3 = new Mensaje("salir", "salir");
                        oos.writeObject(message3);
                        return;
                }
            }

            //Cerrar streams y socket
        } catch (IOException | ClassNotFoundException  e) {
            e.printStackTrace();
        }
    }
}


