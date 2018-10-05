package mapper;

import entities.dest.DestinationEntity;
import entities.source.ExternalEntity;
import entities.source.SourceEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;

@Mapper
public interface SourceMapper {
  SourceMapper MAPPER = Mappers.getMapper( SourceMapper.class );
  @Mappings({
      @Mapping(source="id", target="id"),
      @Mapping(source="name", target="name"),
      @Mapping(source="externalEntityId", target="externalEntity")
  })
  DestinationEntity sourceToDest(SourceEntity source);
  
  default <T extends ExternalEntity> T resolveExternalEntity(String sourceEntityId, @TargetType Class<T> entityClass, @Context Function<String, ExternalEntity> entitySource){
    
    return (T)entitySource.get(sourceEntityId);
  }
}
