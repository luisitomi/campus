import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  templateUrl: 'login.component.html'
})
export class LoginComponent implements OnInit { 

  constructor(private router: Router) { }


  ngOnInit(): void {
  }

  ir(){
    this.router.navigate(['/home']);
  }

}
