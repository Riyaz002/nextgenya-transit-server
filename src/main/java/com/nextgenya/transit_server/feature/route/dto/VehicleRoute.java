package com.nextgenya.transit_server.feature.route.dto;

import com.nextgenya.transit_server.feature.route.model.VehicleType;

public record VehicleRoute(VehicleType vehicleType, Long vehicleId, Long routeId, String routeName, String routeDescription){}
