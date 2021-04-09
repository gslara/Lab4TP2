<?php

namespace App\Http\Controllers;

use App\Models\Pais;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http;

class PaisController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        return Pais::all();
    }

    public function show($id)
    {
        return Pais::find($id);
    }

    public function consumirAPI(){
        $logrado = false;
        for($i = 1; $i <= 300; $i++){
            $request =
            Http::get('https://restcountries.eu/rest/v2/callingcode/'.$i);
            if(isset($request[0])){
                $request = $request[0];
                $pais = Pais::find($i);
                if(isset($pais)){
                    $pais->update([
                        'codigoPais' => $i,
                        'nombrePais' => $request['name'],
                        'capitalPais' => $request['capital'],
                        'region' => $request['region'],
                        'poblacion' => $request['population'],
                        'latitud' => $request['latlng'][0],
                        'longitud' => $request['latlng'][1]
                    ]);
                }else{
                    Pais::create([
                        'codigoPais' => $i,
                        'nombrePais' => $request['name'],
                        'capitalPais' => $request['capital'],
                        'region' => $request['region'],
                        'poblacion' => $request['population'],
                        'latitud' => $request['latlng'][0],
                        'longitud' => $request['latlng'][1]
                    ]);
                }
            }
            continue;
        }
            return response([
                'mensaje' => 'se logro insertar | actualizar datos.'
            ],201);

    }
}
