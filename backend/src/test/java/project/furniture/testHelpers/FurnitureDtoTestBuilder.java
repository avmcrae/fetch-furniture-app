package project.furniture.testHelpers;

import project.furniture.adapters.controllers.FurnitureDto;

import java.util.UUID;

public class FurnitureDtoTestBuilder {
    private String id = UUID.randomUUID().toString();
    private String link = "http://placehold.it/32x32";
    private String description = "there's a few words here";
    private String photoUrl = "http://mikes-kitchen-supply-store/5e2b45f096f06cbb396f7100";
    private String name = "roasting pan, white";

    public FurnitureDto build() {
        return FurnitureDto.builder()
                .id(id)
                .name(name)
                .description(description)
                .photoUrl(photoUrl)
                .link(link)
                .build();
    }
}
