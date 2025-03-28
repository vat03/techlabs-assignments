import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: false,
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'first-app';
  name = "Virat";

  getName() {
    return this.name;
  }

  disabled = "disabled"

  link = "https://www.google.com"
  image = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcTDe1OGZ6YC2jFkVQW0A0i_MiMUgcyE8BoXvJ26LhPSJYC7SUBZT-Gtn3yYeQ_xccasG8WAC_MM9sXZaRDpYjnrCQgwNS9l7spp0k1t2O0"

  data = 1;
  increamentData() {
    if (this.data < 15) {
      this.data++;
      return;
    }
    alert("Data should be less than 15")

  }

  decreamentData() {
    if (this.data > 0) {
      this.data--;
      return;
    }
    alert("Data should be greater than 0")
  }
}