# AplicacionesWeb

## Descripción

Aplicación web utilizando **Jakarta EE** para mostrar un ejemplo básico de implementación de servicios REST con **Jakarta RESTful Web Services**. Este proyecto está diseñado para ser un punto de partida para desarrollar aplicaciones basadas en Jakarta EE.

## Requisitos

- **JDK 8** o superior.
- **Maven 3** o superior para compilar y gestionar dependencias.
- Un servidor compatible con **Jakarta EE 8**, como **Wildfly**.

## Estructura del proyecto

```
AplicacionesWeb/
├── ClaseAPI/ # Proyecto principal con el código de la aplicación
│ ├── src/ # Código fuente de la aplicación
│ ├── target/ # Archivos generados por Maven (no se debe hacer commit de esta carpeta)
│ ├── pom.xml # Archivo de configuración de Maven
│ ├── .gitignore # Archivos y directorios a ignorar por Git
│ └── ...
└── README.md # Descripción general del proyecto
```


## ¿Cómo empezar?

Sigue estos pasos para empezar a trabajar con el proyecto:

### 1. Clonar el Repositorio

Clona el repositorio en tu máquina local utilizando el siguiente comando:

```bash
git clone https://github.com/nMishelRamirez/AplicacionesWeb.git
cd ClaseAPI
```

## ¿Cómo usar?
Configura tu servidor Jakarta EE y despliega la aplicación.

Accede a los siguientes puntos finales de la API para realizar operaciones CRUD sobre libros y copias de libros:

GET /api/books - Obtiene la lista de todos los libros.

POST /api/books - Crea un nuevo libro.

PUT /api/books/{id} - Actualiza un libro existente.

DELETE /api/books/{id} - Elimina un libro.

POST /api/books/{id}/publish - Publica un libro.

GET /api/book-items - Obtiene la lista de todas las copias de libros.

POST /api/book-items - Crea una nueva copia de un libro.

Prueba la API accediendo a los siguientes endpoints en el navegador o usando herramientas como Postman:

Ejemplo de URL para libros: http://hostname:port/api/books

Ejemplo de URL para copias de libros: http://hostname:port/api/book-items

## Detalles Técnicos
Esta aplicación usa la arquitectura RESTful para exponer las operaciones de la API de libros. Utiliza JPA para interactuar con la base de datos y gestiona las entidades relacionadas como:

Book: Representa un libro con campos como título, número de páginas y autor.
BookItem: Representa una copia de un libro con un ISBN único.
Author: Entidad asociada al libro que representa al autor.

## ¿Cómo funciona?
Al crear un nuevo libro, se persiste en la base de datos con un **ID autoincrementado** generado automáticamente.

Cada libro puede tener múltiples copias (ítems de libro), y cada copia tiene un **ISBN único**.

Se utilizan transacciones para garantizar que las operaciones de creación, actualización y eliminación de libros sean atómicas.

## Autor

Este proyecto fue creado por **Mishel Ramirez**