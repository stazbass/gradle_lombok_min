package mapper;

import entities.DestinationEntity;
import entities.SourceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SourceMapper {
  SourceMapper MAPPER = Mappers.getMapper( SourceMapper.class );
  @Mappings({
      @Mapping(source="id", target="id"),
      @Mapping(source="name", target="name")})
  DestinationEntity sourceToDest(SourceEntity source);
}
