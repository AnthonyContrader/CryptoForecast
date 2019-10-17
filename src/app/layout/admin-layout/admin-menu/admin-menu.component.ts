import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-menu',
  templateUrl: './admin-menu.component.html',
  styleUrls: ['./admin-menu.component.css']
})
export class AdminMenuComponent implements OnInit {

  isUserCollapsed = false;
  isCoinCollapsed = false;
  isCommitCollapsed = false;
  isSocialCollapsed = false;
  isTrendCollapsed = false;
  isClientCollapsed = false;
  isAccountCollapsed = false;

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('');
  }

  userscollapse() {
    if (this.isUserCollapsed === false) {
      this.isUserCollapsed = true;
    } else { this.isUserCollapsed = false; }
  }

  coinscollapse() {
    if (this.isCoinCollapsed === false) {
      this.isCoinCollapsed = true;
    } else { this.isCoinCollapsed = false; }
  }

  commitscollapse() {
    if (this.isCommitCollapsed === false) {
      this.isCommitCollapsed = true;
    } else { this.isCommitCollapsed = false; }
  }

  socialscollapse() {
    if (this.isSocialCollapsed === false) {
      this.isSocialCollapsed = true;
    } else { this.isSocialCollapsed = false; }
  }

  trendscollapse() {
    if (this.isTrendCollapsed === false) {
      this.isTrendCollapsed = true;
    } else { this.isTrendCollapsed = false; }
  }

  accountcollapse() {
    if (this.isAccountCollapsed === false) {
      this.isAccountCollapsed = true;
    } else { this.isAccountCollapsed = false; }
  }
}
