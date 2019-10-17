import { Injectable } from "@angular/core";
import { AbstractService } from './abstractservice';
import { CommitDTO } from 'src/dto/commitdto';
import { HttpClient } from '@angular/common/http';
import { CoinDTO } from 'src/dto/coindto';
import { Observable } from 'rxjs';








@Injectable({
    providedIn: 'root'
})

export class CommitService extends AbstractService<CommitDTO>{


    constructor(http: HttpClient){
        super(http);
        this.type = 'commit' ;

    }

    /*Coins(coin: CoinDTO): Observable<CommitDTO[]>{
        console.log("tipo: "+this.type);
            return this.http.post<CommitDTO[]>('http://localhost:' + this.port + '/' + this.type + '/coins', coin);
      }*/

}