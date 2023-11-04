package lk.ucsc.sricare.webmobileapiservice.dto.telcosystemservice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class AddUsageRequest {
    @Getter
    private UUID userPackageActivationId;

    @Getter
    private Integer usage;
}
