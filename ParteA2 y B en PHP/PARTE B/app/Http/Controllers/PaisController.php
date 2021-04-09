<?php

namespace App\Http\Controllers;

use App\Models\Pais;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http;
use Illuminate\Support\Facades\Schema;

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

    public function show(Request $request)
    {
        $pais = Pais::query()->where('codigoPais',intval($request->codigoPais))->first();
        return response([$pais],200);
    }

    public function actualizar(Request $request){
        $request->validate([
            'nombre' => 'required',
            'nombrePais' => 'required | sometimes',
            'capitalPais' => 'required | sometimes',
            'region' => 'required | sometimes',
            'poblacion' => 'required | sometimes',
            'latitud' => 'required | sometimes',
            'longitud' => 'required | sometimes'
        ]);
        $pais = Pais::where('nombre',$request->name)->first();
        if(isset($pais)){
            $pais->update($request->except('nombre'));
            return response($pais,200);
        }
        return response(["mensaje" => "no se encontro el pais llamado $request->nombre"],405);
    }

    public function paisRegion(Request $request){
        $paises = Pais::query()->where('region',$request->region)->get();
        return response((isset($paises) ? $paises : 'No se encontro paises en dicha region'),(isset($paises) ? 200 : 405));
    }

    public function paisbyRegionMayor(Request $request){
        $paises = Pais::where([
            ['region', $request->region],
            ['poblacion','>', intval($request->poblacion)]
        ])->get();
        return response((($paises) ? $paises : "No se encontro paises en dicha region con poblacion mayor a $request->poblacion"),(isset($paises) ? 200 : 405));
    }

    public function paisEntrePoblacion(Request $request){
        $paises = Pais::query()
        ->where('poblacion','>',intval($request->minimo))
        ->where('poblacion','<',intval($request->maximo))
        ->get();
        return response(
            [isset($poblacion) ? $poblacion : "No se encontraron paises entre $request->minimo y $request->maximo"],
            isset($poblacion) ? 200 : 405
        );
    }

    public function paisDistinto(Request $request){
        $paises = Pais::where('region', '!=', $request->region)->get();
        return response((($paises) ? $paises : "No se encontro paises distintos a region $request->region"),(isset($paises) ? 200 : 405));
    }

    public function paisOrderByNameASC(){
        return Pais::orderBy('nombrePais', 'ASC')->get();
    }

    public function skipPais(Request $request){
        return Pais::skip(intval($request->numero))->get();
    }

    public function buscarPaisRegexNombre(Request $request){
        return Pais::where('nombrePais', 'regex', "/.*$request->nombre/.*")->get();
    }

    public function borrarPais(Request $request){

        $pais = Pais::query()->where('codigoPais',intval($request->codigoPais))->first();

        if(isset($pais)){
            $pais->delete();
            return response([
                'mensaje' => "El pais con codigo $request->codigoPais fue destruido."
            ],200);
        }

        return response([
            'mensaje' => "No se encontro el pais con el codigo $request->codigo"
        ],405);
    }

    public function dropearPaises(){
        Schema::dropIfExists('pais');
        return response(
            ["mensaje" => "Se borro la tabla pais"]
            ,200
        );
    }

    public function consumirAPI(){

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
                'mensaje' => 'Carga finalizada.'
            ],201);

    }
}
