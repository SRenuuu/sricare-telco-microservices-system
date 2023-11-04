package lk.ucsc.sricare.serviceissuesservice.dto;

import jakarta.validation.constraints.NotNull;

/*
    PostRequestDTO - Represents the request body for post-request
 */
public class PostRequestDTO {
    @NotNull
    private String user_id;
    @NotNull
    private String type;
    @NotNull
    private String description;

    public String getUser_id() {
        return user_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PostRequestDTO(String user_id, String type, String description) {
        this.user_id = user_id;
        this.type = type;
        this.description = description;
    }
}
