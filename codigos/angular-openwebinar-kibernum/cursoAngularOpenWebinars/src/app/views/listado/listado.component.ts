import { Component, OnInit } from '@angular/core';
import { Entrada } from 'src/app/shared/data/entrada';

@Component({
  selector: 'app-listado',
  templateUrl: './listado.component.html',
  styleUrls: ['./listado.component.css']
})
export class ListadoComponent implements OnInit {

  public entradas: Entrada[];

  constructor() { 
    this.entradas = [
      {
        titulo: "Instalando Oracle con Docker",
        resumen: "Sin un adecuado entendimiento de Docker options no podremos"
      },
      {
        titulo: "Leyendo CSV e importando a MongoDB",
        resumen: "La importancia de tipos de datos en MongoDB y JPA"
      }
    ]
  }

  ngOnInit(): void {
  }

}
