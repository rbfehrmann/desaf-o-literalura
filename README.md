# Literalura

## ¡Bienvenido a **Literalura**!

Literalura es una aplicación interactiva de consola desarrollada con **Spring Boot** que permite gestionar una colección de libros, interactuar con la API de Gutendex para buscar libros, y almacenar información en una base de datos. Este proyecto es parte del Alura Challenge.

---

## 🔧 **Funcionalidades**

- **Buscar libros por título**: Integra la API de Gutendex para obtener información de libros relacionados con el título ingresado.
- **Listar libros registrados**: Consulta todos los libros almacenados en la base de datos.
- **Listar autores registrados**: Visualiza todos los autores únicos presentes en los registros.
- **Filtrar libros por idioma**: Encuentra libros registrados según su idioma.
- **Guardar libros**: Agrega nuevos libros con detalles de título, autor e idioma.
- **Sistema de menú intuitivo**: Facilita la interacción del usuario mediante opciones claras y menús iterativos.

---

## 🔐 **Requisitos**

Asegúrate de contar con los siguientes recursos para ejecutar la aplicación:

- Java 17 o superior.
- Maven 3.6 o superior.
- Base de datos PostgreSQL.

---

## 🌐 **Configuración Inicial**

1. **Clona este repositorio:**
   ```bash
   git clone https://github.com/tu-usuario/literalura.git
   cd literalura
   ```

2. **Configura las propiedades del proyecto:**
   Edita el archivo `src/main/resources/application.properties` con los valores correspondientes a tu entorno:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
   spring.datasource.username=tu-usuario
   spring.datasource.password=tu-contraseña
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Construye el proyecto con Maven:**
   ```bash
   mvn clean install
   ```

4. **Ejecuta la aplicación:**
   ```bash
   mvn spring-boot:run
   ```

## 🚀 **Cómo usar la aplicación**

Al ejecutar la aplicación, se te presentará el siguiente menú en consola:

```
----- Menú -----
1. Buscar libro por título
2. Listar todos los libros
3. Listar autores registrados
4. Listar libros por idioma
5. Guardar libro
0. Salir
Seleccione una opción:
```

Sigue las instrucciones para interactuar con la base de datos o realizar consultas a la API de Gutendex. ¡Es muy fácil de usar!

---

## 🔬 **Tecnologías Utilizadas**

- **Lenguaje**: Java 17
- **Framework**: Spring Boot 3.1
- **Base de Datos**: PostgreSQL
- **Integración de API**: Gutendex (https://gutendex.com)
- **Herramientas**: Maven, JPA, WebClient/RestTemplate

---

## 🎨 **Colaboración**

¿Te interesa mejorar Literalura? ¡Súmate!

1. Haz un fork del repositorio.
2. Crea una rama con tu función:
   ```bash
   git checkout -b nueva-funcion
   ```
3. Realiza tus cambios y haz un commit:
   ```bash
   git commit -m "Agregada nueva funcionalidad"
   ```
4. Sube los cambios a tu rama:
   ```bash
   git push origin nueva-funcion
   ```
5. Abre un Pull Request.

---

## ❤️ **Agradecimientos**

Gracias a la comunidad de **Alura** por el desafío y la oportunidad de desarrollar este proyecto como actual estudiante de back-end.

---

