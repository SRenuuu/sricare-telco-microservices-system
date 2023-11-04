package lk.ucsc.sricare.webmobileapiservice.dto.telcosystemservice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder
@Data
@AllArgsConstructor
public class AnyResponse {
    private String message;

    private Object data;
}
