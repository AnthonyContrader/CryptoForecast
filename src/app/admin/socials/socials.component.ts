import { Component, OnInit } from '@angular/core';
import { SocialService } from 'src/service/social.service';
import { SocialDTO } from 'src/dto/socialdto';

@Component({
  selector: 'app-socials',
  templateUrl: './socials.component.html',
  styleUrls: ['./socials.component.css']
})
export class SocialsComponent implements OnInit {

  socials: SocialDTO[];
  socialtoinsert: SocialDTO = new SocialDTO();

  constructor(private service: SocialService) { }

  ngOnInit() {
    this.getSocials();
  }

  getSocials() {
    this.service.getAll().subscribe(socials => this.socials = socials);
  }

  delete(social: SocialDTO) {
    this.service.delete(social.id).subscribe(() => this.getSocials());
  }

  update(social: SocialDTO) {
    this.service.update(social).subscribe(() => this.getSocials());
  }

  insert(social: SocialDTO) {
    this.service.insert(social).subscribe(() => this.getSocials());
  }

  clear(){
    this.socialtoinsert = new SocialDTO();
  }
}
