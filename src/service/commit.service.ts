import { Injectable } from "@angular/core";
import { AbstractService } from './abstractservice';
import { CommitDTO } from 'src/dto/commitdto';
import { HttpClient } from '@angular/common/http';








@Injectable({
    providedIn: 'root'
})

export class CommitService extends AbstractService<CommitDTO>{


    constructor(http: HttpClient){
        super(http);
        this.type = 'commit' ;
    }
}