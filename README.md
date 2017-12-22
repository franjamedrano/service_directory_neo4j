# service_directory_neo4j

Este proyecto contiene un cliente del ServiceDirectory adaptado a una base de datos neo4j.

Para instalarlo hacerlo funcionar en local hay que hacer los siguientes pasos:

## 1. Instalación y cofiguración neo4j:

La forma más rápida es levantar un contenedor con el neo4j. Para ello habría que ejecutar el siguiente comando:

```
docker run -d    --publish=7474:7474 --publish=7687:7687     --volume=$HOME/neo4j/data:/data     neo4j
```

Una vez arrancado entrar en la consola de neo4j y modificar la password inicial.

## 2. Población de datos:

A continuación habría que crear la estructura y los datos necesarios para funcionar, dejo unos datos de prueba:

```
CREATE (IMC00000:User {userId:'IMC00000'})
CREATE (IMC00001:User {userId:'IMC00001'})
CREATE (IMC00002:User {userId:'IMC00002'})
CREATE (IMC00003:User {userId:'IMC00003'})
CREATE (IMC00004:User {userId:'IMC00004'})
CREATE (IMC00005:User {userId:'IMC00005'})
CREATE (IMC00006:User {userId:'IMC00006'})
CREATE (IMC00007:User {userId:'IMC00007'})
CREATE (IMC00008:User {userId:'IMC00008'})
CREATE (IMC00009:User {userId:'IMC00009'})
CREATE (PRU0001:User {userId:'PRU0001'})
CREATE (PRU0002:User {userId:'PRU0002'})
CREATE (PRU0003:User {userId:'PRU0003'})
CREATE (PRU0004:User {userId:'PRU0004'})
CREATE (PRU0005:User {userId:'PRU0005'})
CREATE (O_01820005:WorkGroup {workGroupId:'O_01820005',name:'Group 1'})
CREATE (O_01820012:WorkGroup {workGroupId:'O_01820012',name:'Group 2'})
CREATE (O_prueba:WorkGroup {workGroupId:'O_prueba',name:'Group Prueba'})
CREATE
  (IMC00000)-[:BELONGS]->(O_01820005),
  (IMC00001)-[:BELONGS]->(O_01820005),
  (IMC00002)-[:BELONGS]->(O_01820005),
  (IMC00003)-[:BELONGS]->(O_01820005),
  (IMC00004)-[:BELONGS]->(O_01820005),
  (IMC00005)-[:BELONGS]->(O_01820005),
  (IMC00006)-[:BELONGS]->(O_01820005),
  (IMC00007)-[:BELONGS]->(O_01820005),
  (IMC00008)-[:BELONGS]->(O_01820005),
  (IMC00009)-[:BELONGS]->(O_01820005),
  (PRU0001)-[:BELONGS]->(O_prueba),
  (PRU0002)-[:BELONGS]->(O_prueba),
  (PRU0003)-[:BELONGS]->(O_prueba),
  (PRU0004)-[:BELONGS]->(O_prueba),
  (PRU0005)-[:BELONGS]->(O_prueba),
  (IMC00000)-[:SUPERVISE]->(O_01820005)
;
```

## 3. Configuración proyecto

Lo siguiente es actualizar el fichero `service_directory_neo4j/src/main/resources/application.properties` con los datos de conexión.

## 4. Compilar y arrancar

Por último, compilar el proyecto y arrancarlo. Los servicios y la firma están definidos en el siguiente enlace:
https://bbva-apicatalog.appspot.com/#/global/processes/apis/bpmUsers

