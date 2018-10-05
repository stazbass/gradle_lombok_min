package mapper;

import entities.dest.DestinationEntity;
import entities.source.ExternalEntity;
import entities.source.SourceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.TargetType;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper
public interface SourceMapper {
  SourceMapper MAPPER = Mappers.getMapper( SourceMapper.class );
  @Mappings({
      @Mapping(source="id", target="id"),
      @Mapping(source="name", target="name"),
      @Mapping(source="externalEntityId", target="externalEntity")
  })
  DestinationEntity sourceToDest(SourceEntity source);
  
  default <T extends ExternalEntity> T resolveExternalEntity(String sourceEntityId, @TargetType Class<T> entityClass){
    
    return (T)ExternalEntity.builder().id(sourceEntityId).randomName(UUID.randomUUID().toString()).build();
  }
}
