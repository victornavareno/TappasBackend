![image](https://github.com/user-attachments/assets/21f2039d-3013-4d75-a501-3639cb56d75c)



# Tappas Backend
Tappas es una aplicación backend desarrollada en Spring Boot que importa datos desde un dataset con todos los restaurantes en Extremadura desde un archivo Excel y los expone a través de una API REST conectada a MongoDB. Su objetivo es facilitar a los usuarios la búsqueda de los mejores restaurantes en función de su ciudad y el plato que desean comer.


## Endpoints REST
**GET /api/restaurantes/ciudades** → Lista de ciudades únicas.

**GET /api/restaurantes/platos**→ Lista de platos únicos.

**GET /api/restaurantes/{municipio}** → Restaurantes por ciudad.

**GET /api/restaurantes/menu/{id}** → Menú completo por restaurante.

**GET /api/restaurantes/podium**  Top 3 restaurantes según valoración.

## Bases de datos

![image](https://github.com/user-attachments/assets/dccb4269-5bfe-4ebe-927f-c32547682c0e)


Nuestra API se conecta a una base de datos no relacional en MongoDB cargada en una imagen Docker con el dataset de restaurantes de la región.

## Redis: Optimización de rendimiento
Además, Tappas integra Redis como sistema de cache para acelerar las respuestas más frecuentes, como:

- Consultas repetidas por ciudad y plato.

- Resultados del top 3 de restaurantes.

- Precaching de búsquedas populares según patrones de uso por los usuarios.
