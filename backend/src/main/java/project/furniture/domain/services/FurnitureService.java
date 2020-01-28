package project.furniture.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.furniture.adapters.controllers.FurnitureDto;
import project.furniture.adapters.http.FurnitureHttpClient;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Service
public class FurnitureService {
    private final FurnitureHttpClient furnitureHttpClient;

    public FurnitureService(@Autowired FurnitureHttpClient furnitureHttpClient) {
        this.furnitureHttpClient = furnitureHttpClient;
    }

    public List<FurnitureDto> fetchAll() {
        return Stream.of(
                furnitureHttpClient.fetchAbcFurnitureProducts(),
                furnitureHttpClient.fetchMikesKitchenSupplyProducts(),
                furnitureHttpClient.fetchStuffNThingsProducts()
        ).flatMap(Arrays::stream)
                .map(FurnitureDto::from)
                .collect(toList());
    }
}
