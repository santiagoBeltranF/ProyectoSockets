package org.example;


import org.example.models.PaqueteTuristico;
import org.example.models.Persona;
import org.example.models.Reserva;
import org.example.util.NameGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;


public class AgenciaServidor {

    private ArrayList<Persona> personas =  new ArrayList<>();

    private ArrayList<PaqueteTuristico> paqueteTuristicos = new ArrayList<>();

    private List<Reserva> reservas = new ArrayList<>();

    private static final String[] allDestinations = {
            "mexico",
            "italia",
            "españa",
            "australia",
            "londres",
            "suiza",
            "venecia"
    };

    public AgenciaServidor() {
        String[] predefinedPackageNames = {
                "Paquete turistico A",
                "Paquete turistico B",
                "Paquete turistico C",
                "Paquete turistico D",
        };

        NameGenerator nameGenerator = new NameGenerator(predefinedPackageNames);

        for (int i = 0; i < predefinedPackageNames.length; i++) {
            List<String> predefinedDestinations = generateRandomDestinations();
            paqueteTuristicos.add(PaqueteTuristico.builder()
                    .id(i)
                    .fecha(generateRandomFutureDate())
                    .duracion(ThreadLocalRandom.current().nextInt(1, 11))
                    .nombre(nameGenerator.getName())
                    .destinos(predefinedDestinations)
                    .build());
        }
    }

    private List<String> generateRandomDestinations() {
        List<String> destinationsList = new ArrayList<>();
        while (destinationsList.size() < 3) { // Cambiar 3 al número deseado de destinos por paquete
            int index = ThreadLocalRandom.current().nextInt(0, allDestinations.length);
            String destination = allDestinations[index];
            if (!destinationsList.contains(destination)) {
                destinationsList.add(destination);
            }
        }
        return destinationsList;
    }

    private LocalDate generateRandomFutureDate() {
        long minDay = LocalDate.now().toEpochDay();
        long maxDay = minDay + 365; // 1 año
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    public void agregarCliente(Persona c) throws Exception {
        personas.add(c);
        System.out.println("Cliente agregado correctamente");
    }

    public void agregarReserva(Reserva c) throws Exception {
        for (Persona persona : personas) {
            if (!Objects.equals(persona.getId(), c.getPersonaId())) {
                personas.add(c.getPersona());
            }
        }

        reservas.add(c);

        System.out.println("Cliente agregado correctamente");
    }

    public ArrayList<Persona> listarClientes() {
        System.err.println("listad clientes" + personas);

        return personas;
    }

    public ArrayList<PaqueteTuristico> listarPaquetesTuristicos() {
        return paqueteTuristicos;
    }

    public List<Reserva> listarReserva() {
        return reservas;
    }

    public static LocalDate date() {
        int hundredYears = 100 * 365;
        return LocalDate.ofEpochDay(ThreadLocalRandom
                .current().nextInt(-hundredYears, hundredYears));
    }

    public List<PaqueteTuristico> obtenerPaquetesTuristicos() {
        return this.paqueteTuristicos;
    }
}