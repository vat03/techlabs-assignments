import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'percentage',
  standalone: false
})
export class PercentagePipe implements PipeTransform {

  transform(value: number, totalMarks: number, decimal: number): unknown {
    return (value/totalMarks*100).toFixed(decimal)+" %";
  }

}
