package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightRepository flightRepository;

    public DataLoader () {

    }

    @Override
    public void run(ApplicationRunner args) throws Exception {

        // Flight New York
        Flight newYorkFlight = new Flight("New York", 200, "20/12/2022", "08:00");
        flightRepository.save(newYorkFlight);

        Passenger passenger1 = new Passenger("Rebecca", "rebeccasol@gmail.com");
        passenger1.addFlight(newYorkFlight);
        passengerRepository.save(passenger1);

        Passenger passenger2 = new Passenger("Rimm", "rimmderes@gmail.com");
        passenger2.addFlight(newYorkFlight);
        passengerRepository.save(passenger2);

        // Flight Paris
        Flight parisFlight = new Flight("Paris", 150, "01/01/2023", "14:00");
        flightRepository.save(parisFlight);

        Passenger passenger3 = new Passenger("Anna", "annahenderson@gmail.com");
        passenger3.addFlight(parisFlight);
        passengerRepository.save(passenger3);

        Passenger passenger4 = new Passenger("Zsolt", "zsolt@gmail.com");
        passenger4.addFlight(parisFlight);
        passengerRepository.save(passenger4);

        // Flight Cape Town
        Flight capeTownFlight = new Flight("Cape Town", 350, "11/06/2023", "06:00");
        flightRepository.save(capeTownFlight);

        Passenger passenger5 = new Passenger("Colin", "colinfarquar@gmail.com");
        passenger5.addFlight(capeTownFlight);
        passengerRepository.save(passenger5);

        Passenger passenger6 = new Passenger("Ed", "edhulbert@gmail.com");
        passenger6.addFlight(capeTownFlight);
        passengerRepository.save(passenger6);


        // Multiple passengers to multiple flights (many to many)
        Passenger passenger7 = new Passenger("Richard", "richard@gmail.com");
        passenger7.addFlight(parisFlight);
        passenger7.addFlight(newYorkFlight);
        passengerRepository.save(passenger7);

        Passenger passenger8 = new Passenger("Eoan", "eoan@gmail.com");
        passenger8.addFlight(capeTownFlight);
        passenger8.addFlight(newYorkFlight);
        passengerRepository.save(passenger8);


    }





}
