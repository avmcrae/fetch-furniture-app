package project.furniture.adapters.controllers;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import project.furniture.domain.services.FurnitureService;
import project.furniture.testHelpers.FurnitureDtoTestBuilder;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FurnitureControllerTest {

    @Mock
    FurnitureService furnitureService;

    @InjectMocks
    FurnitureController furnitureController;

    @Test
    public void shouldFetchListOfFurnitureProducts() {
        FurnitureDto dtoOne = new FurnitureDtoTestBuilder().build();
        FurnitureDto dtoTwo = new FurnitureDtoTestBuilder().build();
        when(furnitureService.fetchAll()).thenReturn(asList(dtoOne, dtoTwo));

        List<FurnitureDto> furnitureResponse = furnitureController.fetchFurnitureProducts();

        assertThat(furnitureResponse.size(), Matchers.equalTo(2));
        assertThat(furnitureResponse.get(0), Matchers.equalTo(dtoOne));
        assertThat(furnitureResponse.get(1), Matchers.equalTo(dtoTwo));
    }
}