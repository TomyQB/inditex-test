# Proyecto de Gestión de Precios

## Descripción del Proyecto

Este proyecto es una aplicación de gestión de precios que permite consultar el precio que debe pagar un cliente de distintos productos en función de diferentes criterios como el `productId`, `brandId` y una fecha específica. La aplicación está construida utilizando **Java**, **Spring Boot** y **Maven**.

## Arquitectura Hexagonal

### ¿Qué es la Arquitectura Hexagonal?

La arquitectura hexagonal, también conocida como arquitectura de puertos y adaptadores, es un patrón de diseño de software que tiene como objetivo crear aplicaciones altamente mantenibles y testeables. La idea principal es separar el núcleo de la aplicación (la lógica de negocio) de las partes externas (interfaces de usuario, bases de datos, servicios externos, etc.).

### Beneficios de la Arquitectura Hexagonal

- **Independencia de la tecnología**: Permite cambiar las tecnologías externas sin afectar la lógica de negocio.
- **Facilidad de pruebas**: Facilita la creación de pruebas unitarias y de integración.
- **Mantenibilidad**: Mejora la mantenibilidad del código al tener mayor desacoplamiento.

### Aplicación de la Arquitectura Hexagonal en este Proyecto

Es cierto que es una arquitectura compleja para un ejercicio tan sencillo, tanto es así que es más compleja la arquitectura que el funcionamiento del servicio, pero he decidido hacer un ejemplo con esta estructura para reflejar, muy por encima, algunos aspectos de los principios SOLID como son:

- **Single Responsability**: Cada capa se encarga de una responsabilidad única facilitando el mantenimiento del código.
- **Open/Closed Principle**: Para añadir una nueva funcionalidad se puede extender de los casos de uso o crear nuevos adaptadores sin necesdad de modificar el código existente.
- **Liskov's Substitution Principle**: Facilita la sustitución de servicios externos ya que se encuentran en la capa más externa.
- **Interface Segregation**: Tenemos interfaces sencillas que facilitan la implementación de adaptadores.
- **Dependency Inversion**: Las capas internas no dependen de las externas en la jerarquía domain -> application -> infrastructure.

## Arrancar el Proyecto

Para arrancar el proyecto, sigue los siguientes pasos:

1. **Clonar el repositorio**:

   ```sh
   git clone <URL_DEL_REPOSITORIO>
   cd <NOMBRE_DEL_PROYECTO>
   ```

2. **Compilar el proyecto con Maven**:

   ```sh
   mvn clean install
   ```

3. **Ejecutar la aplicación**:

   ```sh
   mvn spring-boot:run
   ```

4. **Verificar que la aplicación está corriendo**: La aplicación estará disponible en `http://localhost:8080`.

## Ejecución de Tests

Para ejecutar los tests del proyecto, sigue los siguientes pasos:

1. **Clonar el repositorio**:

   ```sh
   git clone <URL_DEL_REPOSITORIO>
   cd <NOMBRE_DEL_PROYECTO>
   ```

2. **Ejecutar los tests con Maven**:

   ```sh
   mvn -Dtest=PriceControllerIT test
   ```

3. **Verificar los resultados**: Los resultados de los tests se mostrarán en la consola.

## Conclusión

Este proyecto demuestra cómo aplicar la arquitectura hexagonal para crear una aplicación de gestión de precios mantenible y testeable. La separación de la lógica de negocio y las dependencias externas facilita la evolución del proyecto y la integración de nuevas tecnologías.
