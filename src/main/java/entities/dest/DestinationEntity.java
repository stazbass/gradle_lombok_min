package entities.dest;

import entities.source.ExternalEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DestinationEntity {
  private String id;
  private String name;
  private ExternalEntity externalEntity;
}
