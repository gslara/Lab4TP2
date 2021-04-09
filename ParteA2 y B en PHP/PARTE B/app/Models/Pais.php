<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Jenssegers\Mongodb\Eloquent\Model as Eloquent;

class Pais extends Eloquent
{
    use HasFactory;
    protected $connection = 'mongodb';
    protected $collection = 'pais';

    protected $fillable = [
        'codigoPais',
        'nombrePais',
        'capitalPais',
        'region',
        'poblacion',
        'latitud',
        'longitud',
    ];

}
