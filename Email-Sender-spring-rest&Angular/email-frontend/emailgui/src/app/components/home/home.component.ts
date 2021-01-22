import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private snack:MatSnackBar ) { }

  ngOnInit(): void {
  }

  btnClick(){

    console.log("btn clicked");
    this.snack.open("Hey welcome to app","Cancel");
  }

}
