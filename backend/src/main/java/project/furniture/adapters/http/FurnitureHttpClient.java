package project.furniture.adapters.http;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Slf4j
@Component
public class FurnitureHttpClient {
    private RestTemplate restTemplate;
    private String baseUrl;

    @Autowired
    public FurnitureHttpClient(@Value("${furnitureApi.baseUrl}") String baseUrl, RestTemplate restTemplate) {
        this.baseUrl = baseUrl;
        this.restTemplate = restTemplate;
    }

    public FurnitureResponse[] fetchAbcFurnitureProducts() {
        String requestUrl = this.baseUrl.concat("/5e2b66793d75894195de548e");
        return fetchFurnitureFromGivenApi(requestUrl);
    }

    public FurnitureResponse[] fetchMikesKitchenSupplyProducts() {
        String requestUrl = this.baseUrl.concat("/5e2b666350a7fe418c533306");
        return fetchFurnitureFromGivenApi(requestUrl);
    }

    public FurnitureResponse[] fetchStuffNThingsProducts() {
        String requestUrl = this.baseUrl.concat("/5e2b68903d75894195de55c4");
        return fetchFurnitureFromGivenApi(requestUrl);
    }

    private FurnitureResponse[] fetchFurnitureFromGivenApi(String requestUrl) {
        ResponseEntity<FurnitureResponse[]> responseEntity = restTemplate.getForEntity(requestUrl, FurnitureResponse[].class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return Objects.requireNonNull(responseEntity.getBody());
        }
        log.error(String.format("Error fetching furniture from api %s, status code: %d, message: %s", requestUrl, responseEntity.getStatusCodeValue(), responseEntity.toString()));
        return new FurnitureResponse[0];
    }
}
