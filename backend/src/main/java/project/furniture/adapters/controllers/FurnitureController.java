package project.furniture.adapters.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import project.furniture.domain.services.FurnitureService;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class FurnitureController {
    @Autowired
    private FurnitureService furnitureService;

    @GetMapping("/search")
    List<FurnitureDto> fetchFurnitureProducts() {
        return furnitureService.fetchAll();
    }

}