package lk.ucsc.sricare.webmobileapiservice.dto.telcosystemservice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class ActivateTelcoPackageService {
    @Getter
    private UUID userId;

    @Getter
    private UUID telcoPakcageId;
}
