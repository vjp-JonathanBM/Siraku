# API REST SPRING JPA - SIRAKU 
## ESTRUCTURA MVC :wrench:
### CAPA DE PERSISTENCIA
`Model` Contiene cada una de las entidades PL del modelo asi como las relaciones entre ellas.

`Repository` JPA.
### MAPEO PERSISTENCIA <-> NEGOCIO
`BO` capa intermedia entre la capa de persistencia y negocio para garantizar que la transferencia de datos se realiza correctamente.
### CAPA DE NEGOCIO

`Service` Interfaz con lola definición de los métodos a implementar.

`ServiceImpl` Implementación de los métodos sobre las operaciones que realizará la aplicación.

### MAPEO NEGOCIO <-> PRESENTACIÓN
`DTO` capa intermedia entre la capa de negocio y presentación para garantizar que la transferencia de datos se realiza correctamente.

### CAPA DE PRESENTACIÓN
`Controller` Contiene la llamada a los métodos del servicio para realizar las operaciones determinadas anteriormente.


## TESTING :white_check_mark:
`Test Unitarios` ServiceImpl.

`Test Integración` Controller.

## DOCUMENTACIÓN
`Herramienta de documentación` Javadoc.
