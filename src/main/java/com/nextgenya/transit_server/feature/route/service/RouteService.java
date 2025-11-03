package com.nextgenya.transit_server.feature.route.service;

import com.nextgenya.transit_server.feature.route.dto.VehicleRoute;

import java.util.List;

public interface RouteService {
    List<VehicleRoute> getAllRoutes();
    List<VehicleRoute> getBusRoutes();
    List<VehicleRoute> getMetroRoutes();
}
