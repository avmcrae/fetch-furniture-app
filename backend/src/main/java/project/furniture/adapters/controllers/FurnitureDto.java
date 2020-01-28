package project.furniture.adapters.controllers;

import lombok.Builder;
import lombok.Getter;
import project.furniture.adapters.http.FurnitureResponse;

import java.io.Serializable;

@Getter
@Builder
public class FurnitureDto implements Serializable {
    private String id;
    private String photoUrl;
    private String description;
    private String link;
    private String name;

    public static FurnitureDto from(FurnitureResponse furnitureResponse) {
        return FurnitureDto.builder()
                .id(furnitureResponse.get_id())
                .description(furnitureResponse.getDescription())
                .photoUrl(furnitureResponse.getPicture())
                .link(furnitureResponse.getLink())
                .name(furnitureResponse.getName())
                .build();
    }
}
