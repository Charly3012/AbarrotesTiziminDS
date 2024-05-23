
# Abarrotes Tizimin

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![JavaFX](https://img.shields.io/badge/JavaFX-007396?style=for-the-badge&logo=java&logoColor=white)

## Descripción

Abarrotes Tizimin es un software de ventas desarrollado en Java y JavaFX para la gestión de ventas en tiendas de abarrotes. Este proyecto ha sido creado como parte de un proyecto escolar y tiene como objetivo facilitar la administración de inventarios, ventas y clientes en una tienda de abarrotes.

## Características

- Gestión de productos (alta, baja, modificación)
- Gestión de ventas (registro de ventas, historial de ventas)
- Gestión de clientes (registro de clientes, historial de compras)
- Reportes de ventas e inventarios
- Interfaz gráfica intuitiva y amigable

## Requisitos

- Java Development Kit (JDK) 11 o superior
- JavaFX SDK

## Instalación

1. Clona este repositorio:
    ```bash
    git clone https://Charly3012/abarrotes-tizimin.git
    ```

2. Importa el proyecto en tu IDE de preferencia (por ejemplo, IntelliJ IDEA o Eclipse).

3. Configura las librerías de JavaFX en tu IDE.

4. Ejecuta la aplicación desde la clase principal `AppAT`.

## Uso

1. Inicia la aplicación.
2. Utiliza el menú principal para navegar entre las distintas secciones (productos, ventas, clientes).
3. Añade, edita o elimina productos desde la sección de gestión de productos.
4. Registra nuevas ventas y consulta el historial en la sección de ventas.
5. Gestiona la información de los clientes desde la sección correspondiente.

## Estructura del Proyecto

```plaintext
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── controlador
│   │   │           ├── controladores
│   │   │       └── modelo
│   │   │           ├── modelos
│   │   └── resources
│   │       ├── css
│   │       ├── fxml
│   │       ├── persistencia
│   │       └── imagenes
└── README.md
