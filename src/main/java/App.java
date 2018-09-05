import entities.DestinationEntity;
import entities.SourceEntity;
import mapper.SourceMapper;

import java.util.UUID;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class App {



  public void runApp() {
    System.out.println("mapstruct + lombok show !");
    SourceEntity source = SourceEntity.builder().id(UUID.randomUUID().toString()).name("drakula").build();
    DestinationEntity destinationEntity = SourceMapper.MAPPER.sourceToDest(source);
    System.out.println(destinationEntity);
  }


  public static void main(String[] args) {
//    App app = new App();
//    app.runOrderMapingProcess();
    OrderMappingDemo mapOderMain = new OrderMappingDemo();
    mapOderMain.main();
  }
}
