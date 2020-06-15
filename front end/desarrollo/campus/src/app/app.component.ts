import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd, NavigationStart } from '@angular/router';

@Component({
  // tslint:disable-next-line
  selector: 'body',
  template: '<app-header *ngIf="showHead"></app-header><router-outlet></router-outlet>'
})
export class AppComponent implements OnInit {

  showHead: boolean = false;
  ubi:string;

  constructor(private router: Router) {
    // on route change to '/login', set the variable showHead to false
      router.events.forEach((event) => {
        if (event instanceof NavigationStart) {
          if (event['url'] == '/login') {
            this.showHead = false;
            this.ubi = '<router-outlet></router-outlet>'
          } else {
            // console.log("NU")
            this.ubi = '<router-outlet></router-outlet>'
            this.showHead = true;
          }
        }
      });
    }

  ngOnInit() {
    this.router.events.subscribe((evt) => {
      if (!(evt instanceof NavigationEnd)) {
        return;
      }
      window.scrollTo(0, 0);
    });
  }
}
