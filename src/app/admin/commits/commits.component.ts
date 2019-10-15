import { Component, OnInit } from '@angular/core';
import { CommitDTO } from 'src/dto/commitdto';
import { CommitService } from 'src/service/commit.service';

@Component({
  selector: 'app-commits',
  templateUrl: './commits.component.html',
  styleUrls: ['./commits.component.css']
})
export class CommitsComponent implements OnInit {

  commits: CommitDTO[];
  committoinsert: CommitDTO = new CommitDTO();

  constructor(private service: CommitService) { }

  ngOnInit() {
    this.getCommits();
  }

  getCommits() {
    this.service.getAll().subscribe(commits => this.commits = commits);
  }

  delete(commit: CommitDTO) {
    this.service.delete(commit.id).subscribe(() => this.getCommits());
  }

  update(commit: CommitDTO) {
    this.service.update(commit).subscribe(() => this.getCommits());
  }

  insert(commit: CommitDTO) {
    this.service.insert(commit).subscribe(() => this.getCommits());
  }

  clear(){
    this.committoinsert = new CommitDTO();
  }
}
