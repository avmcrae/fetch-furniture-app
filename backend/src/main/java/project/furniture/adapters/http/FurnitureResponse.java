package project.furniture.adapters.http;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
public class FurnitureResponse implements Serializable {
    private String _id;
    private String picture;
    private String description;
    private String link;
    private String name;
}
