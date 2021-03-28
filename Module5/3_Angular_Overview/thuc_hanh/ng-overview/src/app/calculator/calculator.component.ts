import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.scss']
})
export class CalculatorComponent implements OnInit {

  output: string;
  first: number;
  second: number;
  operator = '+';
  onFirstChange(value) {
    this.first = Number(value);
  }
  onSecondChange(value) {
    this.second = Number(value);
  }
  onSelectChange(value) {
    this.operator = value;
  }
  calculate() {
    switch (this.operator) {
      case '+':
        this.output =(String)(this.first + this.second);
        break;
      case '-':
        this.output = (String)(this.first - this.second);
        break;
      case '*':
        this.output = (String)(this.first * this.second);
        break;
      case '/':
        if(this.second === 0)
          this.output = 'Math Error : Divide by zero !!!';
        else
          this.output = (String)(this.first / this.second);
    
        break;
    }
  }

  constructor() { }

  ngOnInit(): void {
  }

}
