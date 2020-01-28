package project.furniture.domain.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import project.furniture.adapters.controllers.FurnitureDto;
import project.furniture.adapters.http.FurnitureHttpClient;
import project.furniture.adapters.http.FurnitureResponse;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FurnitureServiceTest {

    @Mock
    private FurnitureHttpClient furnitureHttpClient;

    @InjectMocks
    private FurnitureService furnitureService;

    @Test
    public void shouldQueryAllThreeSourcesForFurnitureAndCombineTheResults() {
        FurnitureResponse productOne = FurnitureResponse.builder()._id("987987").description("desc").name("green product").build();
        FurnitureResponse productTwo = FurnitureResponse.builder()._id("87678").description("description").name("green product 2").build();
        when(furnitureHttpClient.fetchStuffNThingsProducts()).thenReturn(new FurnitureResponse[]{productOne, productTwo});

        FurnitureResponse productThree = FurnitureResponse.builder()._id("1231321").description("some words").name("green product").build();
        when(furnitureHttpClient.fetchAbcFurnitureProducts()).thenReturn(new FurnitureResponse[]{productThree});

        FurnitureResponse productFour = FurnitureResponse.builder()._id("234324").description("some words and more").name("red product").build();
        FurnitureResponse productFive = FurnitureResponse.builder()._id("464364").description("testinggg").name("blue product").build();
        when(furnitureHttpClient.fetchMikesKitchenSupplyProducts()).thenReturn(new FurnitureResponse[]{productFive, productFour});

        List<FurnitureDto> products = furnitureService.fetchAll();

        assertThat(products.size(), equalTo(5));
    }
}