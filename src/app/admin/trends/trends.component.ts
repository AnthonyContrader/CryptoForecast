import { Component, OnInit } from '@angular/core';
import { TrendDTO } from 'src/dto/trenddto';
import { TrendService } from 'src/service/trend.service';

@Component({
  selector: 'app-trends',
  templateUrl: './trends.component.html',
  styleUrls: ['./trends.component.css']
})
export class TrendsComponent implements OnInit {

  trends: TrendDTO[];
  trendtoinsert: TrendDTO = new TrendDTO();

  constructor(private service: TrendService ) { }

  ngOnInit() {
    this.getTrends();
  }

  getTrends() {
    this.service.getAll().subscribe(trends => this.trends = trends);
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
