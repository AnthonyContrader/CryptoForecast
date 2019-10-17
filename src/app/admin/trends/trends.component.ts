import { Component, OnInit } from '@angular/core';
import { TrendDTO } from 'src/dto/trenddto';
import { TrendService } from 'src/service/trend.service';
import { CoinDTO } from 'src/dto/coindto';
import { CoinService } from 'src/service/coin.service';

@Component({
  selector: 'app-trends',
  templateUrl: './trends.component.html',
  styleUrls: ['./trends.component.css']
})
export class TrendsComponent implements OnInit {

  trends: TrendDTO[];
  trendtoinsert: TrendDTO = new TrendDTO();
  coins: CoinDTO[];

  constructor(private service: TrendService,  private cService: CoinService ) { }

  ngOnInit() {
    this.getTrends();
    this.getCoins();
  }

  getTrends() {
    this.service.getAll().subscribe(trends => this.trends = trends);
  }

  getCoins(){

    this.cService.getAll().subscribe(coins => this.coins =coins);

  }

  delete(trend: TrendDTO) {
    this.service.delete(trend.id).subscribe(() => this.getTrends());
  }

  update(trend: TrendDTO) {
    this.service.update(trend).subscribe(() => this.getTrends());
  }

  insert(trend: TrendDTO) {
    this.service.insert(trend).subscribe(() => this.getTrends());
  }

  clear(){
    this.trendtoinsert = new TrendDTO();
  }
}
