<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreatePaisTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('pais', function (Blueprint $table) {
                $table->index('codigoPais');
                $table->string('nombrePais',50);
                $table->string('capitalPais',50);
                $table->string('region',50);
                $table->integer('poblacion');
                $table->decimal('latitud');
                $table->decimal('longitud');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('pais');
    }
}
