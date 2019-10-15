import { Injectable } from "@angular/core";
import { AbstractService } from './abstractservice';
import { TrendDTO } from 'src/dto/trenddto';
import { HttpClient } from '@angular/common/http';





@Injectable({

    providedIn: 'root'
})

export class TrendService extends AbstractService<TrendDTO>{


    constructor(http: HttpClient)
    {
        super(http);
        this.type = 'trend';
    }

    
}