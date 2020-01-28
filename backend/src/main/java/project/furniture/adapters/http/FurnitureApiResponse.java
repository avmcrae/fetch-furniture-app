package project.furniture.adapters.http;

import lombok.Getter;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Getter
public class FurnitureApiResponse implements Serializable {
    private List<FurnitureResponse> furnitureList;
}
