<p align="center"><a href="https://laravel.com" target="_blank"><img src="https://raw.githubusercontent.com/laravel/art/master/logo-lockup/5%20SVG/2%20CMYK/1%20Full%20Color/laravel-logolockup-cmyk-red.svg" width="400"></a></p>

<p align="center">
<a href="https://travis-ci.org/laravel/framework"><img src="https://travis-ci.org/laravel/framework.svg" alt="Build Status"></a>
<a href="https://packagist.org/packages/laravel/framework"><img src="https://img.shields.io/packagist/dt/laravel/framework" alt="Total Downloads"></a>
<a href="https://packagist.org/packages/laravel/framework"><img src="https://img.shields.io/packagist/v/laravel/framework" alt="Latest Stable Version"></a>
<a href="https://packagist.org/packages/laravel/framework"><img src="https://img.shields.io/packagist/l/laravel/framework" alt="License"></a>
</p>

#Requisitos
* Mariadb - Mysql
* Php
* Composer
* Postman

### Una vez clonado el proyecto
* composer install
* cp .env.example .env
* php artisan key:generate
* vim .env
 	DB_CONNECTION=mysql
	DB_HOST=127.0.0.1
	DB_PORT=3306
	DB_DATABASE=NombreBaseDatosMySQL
	DB_USERNAME=UsuarioMySQL
	DB_PASSWORD=PasswordMySQL
* php artisan migrate:fresh

### probar las siguientes rutas
* POST - http://localhost:8000/api/pais/consumirAPI	- Consumir API de paises externa.
*  GET - http://localhost:8000/api/pais			- Obtener JSON con los paises cargados.


