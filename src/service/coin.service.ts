import { Injectable } from "@angular/core";
import { CoinDTO } from 'src/dto/coindto';
import { AbstractService } from './abstractservice';
import { HttpClient } from  '@angular/common/http';







@Injectable({
    providedIn: 'root'
})

export class CoinService extends AbstractService<CoinDTO>{


    constructor(http: HttpClient) {
        super(http);
        this.type = 'coin' ;

    }
}
     
