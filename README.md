# Tappas Backend
Tappas es una aplicación backend desarrollada en Spring Boot que importa datos desde un dataset con todos los restaurantes en Extremadura desde un archivo Excel y los expone a través de una API REST conectada a MongoDB. Su objetivo es facilitar a los usuarios la búsqueda de los mejores restaurantes en función de su ciudad y el plato que desean comer.


## Endpoints REST
**GET /api/restaurantes/ciudades** → Lista de ciudades únicas.

**GET /api/restaurantes/platos**→ Lista de platos únicos.

**GET /api/restaurantes/{municipio}** → Restaurantes por ciudad.

**GET /api/restaurantes/menu/{id}** → Menú completo por restaurante.

**GET /api/restaurantes/podium**  Top 3 restaurantes según valoración.

## Base de datos

Nuestra API se conecta a una base de datos no relacional en MongoDB cargada en una imagen Docker con el dataset de restaurantes de la región.