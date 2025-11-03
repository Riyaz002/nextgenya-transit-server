package com.nextgenya.transit_server.feature.route.controller;

import com.nextgenya.transit_server.feature.route.dto.VehicleRoute;
import com.nextgenya.transit_server.feature.route.service.RouteServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/routes")
class RouteController {
    @GetMapping("/all")
    public List<VehicleRoute> getAll()  {
        List<VehicleRoute> allRoutes = new RouteServiceImpl().getAllRoutes();
        return ResponseEntity.ok(allRoutes).getBody();
    }

    @GetMapping("/bus")
    public List<VehicleRoute> getBus(){
        List<VehicleRoute> allRoutes = new RouteServiceImpl().getBusRoutes();
        return ResponseEntity.ok(allRoutes).getBody();
    }

    @GetMapping("/metro")
    public List<VehicleRoute> getMetro(){
        List<VehicleRoute> allRoutes = new RouteServiceImpl().getMetroRoutes();
        return ResponseEntity.ok(allRoutes).getBody();
    }
}