import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { EmailService } from 'src/app/service/email.service';

@Component({
  selector: 'email',
  templateUrl: './email.component.html',
  styleUrls: ['./email.component.css']
})
export class EmailComponent implements OnInit {


  data= {
    to:"",
    subject:"",
    message:""
}

flag: boolean=false;

  constructor(private email:EmailService,private snack:MatSnackBar ) { }

  ngOnInit(): void {
  }

  doSubmitForm(){
    console.log("form submited")
    console.log(this.data);
   
    if(this.data.to=="" || this.data.subject=="" || this.data.message=="" ){
      this.snack.open("Fields Cannot Be Empty","Okay");
      return;
    }

   this.flag=true;
    this.email.sendEmail(this.data).subscribe(
      Response=>{
      console.log(Response);
      this.flag=false;
      this.snack.open("Mail Sent sucessfully...","Ok");
      },

      error=>{
        console.log(error);
        this.snack.open("An Error occured...","Ok");
        this.flag=false;
      }
      


    )
  }


}
