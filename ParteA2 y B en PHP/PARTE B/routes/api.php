<?php

use App\Http\Controllers\PaisController;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::get('pais/',[PaisController::class, 'index']);
Route::post('pais/ver',[PaisController::class, 'show']);
Route::get('pais/consumirAPI',[PaisController::class, 'consumirAPI']);
Route::post('pais/region',[PaisController::class, 'paisRegion']);
Route::post('pais/region/mayor',[PaisController::class, 'paisbyRegionMayor']);
Route::post('pais/distinto',[PaisController::class, 'paisDistinto']);
Route::put('pais',[PaisController::class, 'actualizar']);
Route::delete('pais/borrar',[PaisController::class,'borrarPais']);
Route::delete('pais/borrarDB',[PaisController::class, 'dropearPaises']);
Route::post('pais/poblacion',[PaisController::class, 'paisEntrePoblacion']);
Route::get('pais/nombre/asc',[PaisController::class, 'paisOrderByNameASC']);
Route::post('pais/skip', [PaisController::class, 'skipPais']); //Esquiva n cantidad de resultados iniciales
Route::post('pais/buscar', [PaisController::class, 'buscarPaisRegexNombre']);
