<p align="center"><a href="https://laravel.com" target="_blank"><img src="https://raw.githubusercontent.com/laravel/art/master/logo-lockup/5%20SVG/2%20CMYK/1%20Full%20Color/laravel-logolockup-cmyk-red.svg" width="400"></a></p>

<p align="center">
<a href="https://travis-ci.org/laravel/framework"><img src="https://travis-ci.org/laravel/framework.svg" alt="Build Status"></a>
<a href="https://packagist.org/packages/laravel/framework"><img src="https://img.shields.io/packagist/dt/laravel/framework" alt="Total Downloads"></a>
<a href="https://packagist.org/packages/laravel/framework"><img src="https://img.shields.io/packagist/v/laravel/framework" alt="Latest Stable Version"></a>
<a href="https://packagist.org/packages/laravel/framework"><img src="https://img.shields.io/packagist/l/laravel/framework" alt="License"></a>
</p>

# Requisitos
* MongoDB
* Php con conector mongoDB
* Composer
* Postman

### Una vez clonado el proyecto
* composer install
* cp .env.example .env
* php artisan key:generate
* vim .env - borrar conexion mysql anterior y colocar la nueva

    DB_CONNECTION=mongodb
    MONGO_DB_HOST=127.0.0.1
    MONGO_DB_PORT=27017
    MONGO_DB_DATABASE=labo4tp2
    MONGO_DB_USERNAME=
    MONGO_DB_PASSWORD=

* php artisan serv    

### Ejercicios
*    5)    GET -> http://localhost:8000/pais/consumirAPI    - Consumir API
*  5.1)   POST -> http://localhost:8000/pais/region         - Buscar pais por region -> KEY(region)
*  5.2)   POST -> http://localhost:8000/pais/region/mayor   - Buscar pais por region poblacion mayor -> KEY(region, poblacion)
*  5.3)   POST -> http://localhost:8000/pais/distinto       - Buscar paises que no esten en la region -> KEY(region)
*  5.4)    PUT -> http://localhost:8000/pais/               - Modificar datos segun el nombre del pais -> KEY(nombrePais, poblacion)
*  5.5) DELETE -> http://localhost:8000/pais/borrar         - Borrar pais segun el codigo -> KEY(codigoPais)
*  5.6) DELETE -> http://localhost:8000/pais/borrarDB       - drop() borra fisicamente coleccion | base de datos seleccionada.
*  5.7)   POST -> http://localhost:8000/pais/poblacion      - Buscar poblacion entre -> KEY(minimo, maximo)
*  5.8)    GET -> http://localhost:8000/pais/nombre/asc     - Paises ordenados de forma ascendente.
*  5.9)   POST -> http://localhost:8000/pais/skip           - Esquivar CodigoPais seleccionado KEY(numero) 
* 5.10)   POST -> http://localhost:8000/pais/buscar         - Buscar por palabra usando regex reemplaza a like
* 5.11) Consola usar (php artisan make:migration -mNombreDeModelo) -> Migrations crear indice $table->index('nombreIndice');
* 5.12) Consola usar (mongodump --collection Nombre_Coleccion --db Nombre_Base_Datos --dbpath ubicacionDisco)                                                  






