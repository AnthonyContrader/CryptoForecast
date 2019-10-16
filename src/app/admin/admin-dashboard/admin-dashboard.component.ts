import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { CoinDTO } from 'src/dto/coindto';
import { CommitDTO } from 'src/dto/commitdto';
import { SocialDTO } from 'src/dto/socialdto';

/**
 * Componente della dashboard admin. Nell'ngOnInit recupera
 * l'utente loggato per il messaggio di benvenuto.
 */
@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  user: UserDTO;   
  coin: CoinDTO;
  commit: CommitDTO;
  social: SocialDTO ;

  constructor() { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.coin = JSON.parse(localStorage.getItem('currentCoin'));
    this.commit = JSON.parse(localStorage.getItem('currentCommit'));
    this.social = JSON.parse(localStorage.getItem('currentSocial'));
  }

}
