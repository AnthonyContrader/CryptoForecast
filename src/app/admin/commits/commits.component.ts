import { Component, OnInit } from '@angular/core';
import { CommitDTO } from 'src/dto/commitdto';
import { CommitService } from 'src/service/commit.service';
import { CoinDTO } from 'src/dto/coindto';
import { CoinService } from 'src/service/coin.service';

@Component({
  selector: 'app-commits',
  templateUrl: './commits.component.html',
  styleUrls: ['./commits.component.css']
})
export class CommitsComponent implements OnInit {

  commits: CommitDTO[];
  committoinsert: CommitDTO = new CommitDTO();
  coins: CoinDTO[];

  constructor(private service: CommitService, private cService: CoinService) { }

  ngOnInit() {
    this.getCommits();
    this.getCoins();
  }

  getCommits() {
    this.service.getAll().subscribe(commits => this.commits = commits);
  }

  getCoins(){

    this.cService.getAll().subscribe(coins => this.coins =coins);

  }

  delete(commit: CommitDTO) {
    this.service.delete(commit.id).subscribe(() => this.getCommits());
  }

  update(commit: CommitDTO) {
    console.log(commit);
    this.service.update(commit).subscribe(() => this.getCommits());
  }

  insert(commit: CommitDTO) {
    
    this.service.insert(commit).subscribe(() => this.getCommits());
  }

  clear(){
    this.committoinsert = new CommitDTO();
  }
}
