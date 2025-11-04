package com.nextgenya.transit_server.feature.route.service;

import com.nextgenya.transit_server.feature.route.dto.VehicleRoute;
import com.nextgenya.transit_server.feature.route.model.VehicleType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class RouteServiceImpl implements RouteService {


    @Override
    public List<VehicleRoute> getAllRoutes() {
        return Stream.concat(getBusRoutes().stream(), getMetroRoutes().stream())
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleRoute> getBusRoutes() {
        AtomicLong vehicleId = new AtomicLong();
        AtomicLong routeId = new AtomicLong(195);
        return List.of(
                new VehicleRoute(VehicleType.BUS, vehicleId.getAndIncrement(), routeId.getAndIncrement(),
                        "Mudrika (Outer Ring Road)", "Circular DTC route covering major areas like AIIMS, Dhaula Kuan, Rajouri Garden, and Anand Vihar."),
                new VehicleRoute(VehicleType.BUS, vehicleId.getAndIncrement(), routeId.getAndIncrement(),
                        "400 – Badarpur Border to ISBT Kashmiri Gate", "Connects South Delhi to Central and North Delhi via Mathura Road and ITO."),
                new VehicleRoute(VehicleType.BUS, vehicleId.getAndIncrement(), routeId.getAndIncrement(),
                        "620 – Vasant Vihar to Shivaji Stadium", "Links the diplomatic enclave and airport road area to Connaught Place."),
                new VehicleRoute(VehicleType.BUS, vehicleId.getAndIncrement(), routeId.getAndIncrement(),
                        "534 – Anand Vihar ISBT to Mehrauli", "Runs east to south Delhi via Ashram and Hauz Khas."),
                new VehicleRoute(VehicleType.BUS, vehicleId.getAndIncrement(), routeId.getAndIncrement(),
                        "522 – Nehru Place to Dwarka Sector 21", "Connects South Delhi commercial hub to West Delhi residential sectors."),
                new VehicleRoute(VehicleType.BUS, vehicleId.getAndIncrement(), routeId.getAndIncrement(),
                        "615 – Uttam Nagar to AIIMS", "Popular office route passing Janakpuri, Dhaula Kuan, and Safdarjung."),
                new VehicleRoute(VehicleType.BUS, vehicleId.getAndIncrement(), routeId.getAndIncrement(),
                        "990 – Badarpur Border to Ambedkar Nagar", "Serves South Delhi neighborhoods via Tughlakabad and Saket."),
                new VehicleRoute(VehicleType.BUS, vehicleId.getAndIncrement(), routeId.getAndIncrement(),
                        "473 – Anand Vihar to Dhaula Kuan", "Cross-city route via ITO, Connaught Place, and Karol Bagh."),
                new VehicleRoute(VehicleType.BUS, vehicleId.getAndIncrement(), routeId.getAndIncrement(),
                        "774 – Punjabi Bagh to Nehru Place", "Runs through central corridors: Rajouri Garden, Moti Nagar, and Lajpat Nagar.")
        );
    }

    public List<VehicleRoute> getMetroRoutes() {
        AtomicLong vehicleId = new AtomicLong();
        AtomicLong routeId = new AtomicLong(66);
        return List.of(
                new VehicleRoute(VehicleType.METRO, vehicleId.getAndIncrement(), routeId.getAndIncrement(),
                        "Yellow Line", "Connects Samaypur Badli in North Delhi to HUDA City Centre in Gurugram, covering key stations like Kashmiri Gate, Rajiv Chowk, and AIIMS."),
                new VehicleRoute(VehicleType.METRO, vehicleId.getAndIncrement(), routeId.getAndIncrement(),
                        "Blue Line", "Runs from Dwarka Sector 21 to Noida Electronic City, passing through Rajouri Garden, Connaught Place, and Akshardham."),
                new VehicleRoute(VehicleType.METRO, vehicleId.getAndIncrement(), routeId.getAndIncrement(),
                        "Red Line", "Extends from Rithala to Shaheed Sthal (Ghaziabad), connecting Rohini, Kashmiri Gate, and Shahdara."),
                new VehicleRoute(VehicleType.METRO, vehicleId.getAndIncrement(), routeId.getAndIncrement(),
                        "Violet Line", "Runs between Kashmere Gate and Raja Nahar Singh (Ballabhgarh), serving Central Secretariat, Lajpat Nagar, and Faridabad."),
                new VehicleRoute(VehicleType.METRO, vehicleId.getAndIncrement(), routeId.getAndIncrement(),
                        "Magenta Line", "Connects Janakpuri West to Botanical Garden, covering IGI Airport, Hauz Khas, and Kalkaji Mandir."),
                new VehicleRoute(VehicleType.METRO, vehicleId.getAndIncrement(), routeId.getAndIncrement(),
                        "Pink Line", "Encircles Delhi from Majlis Park to Shiv Vihar, linking major residential and industrial areas like Rajouri Garden and Lajpat Nagar."),
                new VehicleRoute(VehicleType.METRO, vehicleId.getAndIncrement(), routeId.getAndIncrement(),
                        "Green Line", "Links Inderlok to Brigadier Hoshiar Singh, passing through Mundka, Peeragarhi, and Nangloi."),
                new VehicleRoute(VehicleType.METRO, vehicleId.getAndIncrement(), routeId.getAndIncrement(),
                        "Grey Line", "Short corridor from Dwarka to Najafgarh, serving southwest Delhi localities."),
                new VehicleRoute(VehicleType.METRO, vehicleId.getAndIncrement(), routeId.getAndIncrement(),
                        "Orange Line (Airport Express)", "High-speed corridor connecting New Delhi Railway Station to Dwarka Sector 21 via IGI Airport.")
        );
    }
}