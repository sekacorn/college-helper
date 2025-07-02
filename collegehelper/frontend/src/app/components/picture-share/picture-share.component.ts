import { Component } from '@angular/core';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-picture-share',
  templateUrl: './picture-share.component.html'
})
export class PictureShareComponent {
  images: string[] = [];
  constructor(private api: ApiService) { this.load(); }
  load() { this.api.getImages().subscribe(urls => this.images = urls); }
  upload(event: any) {
    this.api.uploadImage(event.target.files[0]).subscribe(() => this.load());
  }
}
