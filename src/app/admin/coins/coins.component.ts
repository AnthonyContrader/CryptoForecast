import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/service/user.service';
import { UserDTO } from 'src/dto/userdto';
import { CoinDTO } from 'src/dto/coindto';
import { CoinService } from 'src/service/coin.service';

@Component({
  selector: 'app-coins',
  templateUrl: './coins.component.html',
  styleUrls: ['./coins.component.css']
})
export class CoinsComponent implements OnInit {

  coins: CoinDTO[];
  cointoinsert: CoinDTO = new CoinDTO();

  constructor(private service: CoinService) { }

  ngOnInit() {
    this.getCoins();
  }

  getCoins() {
    this.service.getAll().subscribe(coins => this.coins = coins);
  }

  delete(coin: CoinDTO) {
    this.service.delete(coin.id).subscribe(() => this.getCoins());
  }

  update(coin: CoinDTO) {
    this.service.update(coin).subscribe(() => this.getCoins());
  }

  insert(coin: CoinDTO) {
    this.service.insert(coin).subscribe(() => this.getCoins());
  }

  clear(){
    this.cointoinsert = new CoinDTO();
  }
}
