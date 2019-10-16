import { Injectable } from "@angular/core";
import { AbstractService } from './abstractservice';
import { SocialDTO } from 'src/dto/socialdto';
import { HttpClient } from  '@angular/common/http';









@Injectable({
    providedIn: 'root'
})

export class SocialService extends AbstractService<SocialDTO>{

    constructor(http: HttpClient){
        super(http);
        this.type = 'social' ;
    }
}