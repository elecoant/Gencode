import { Component, ViewChild, ElementRef, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'gencode';

  @ViewChild('canvas', { static: true })
  canvas: ElementRef<HTMLCanvasElement>;
  private ctx: CanvasRenderingContext2D;

  valid: boolean = false;

  stripeWidth: number = 5;
  stripeHeight: number = 200;
  moduleWidth: number = this.stripeWidth * 7;

  leftOdd: string[] = [
    "0001101",
    "0011001",
    "0010011",
    "0111101",
    "0100011",
    "0110001",
    "0101111",
    "0111011",
    "0110111",
    "0001011"
  ];

  leftEven: string[] = [
    "0100111",
    "0110011",
    "0011011",
    "0100001",
    "0011101",
    "0111001",
    "0000101",
    "0010001",
    "0001001",
    "0010111"
  ]

  parity: boolean[][] = [
    [false, false, false, false, false, false],
    [false, false, true, false, true, true],
    [false, false, true, true, false, true],
    [false, false, true, true, true, false],
    [false, true, false, false, true, true],
    [false, true, true, false, false, true],
    [false, true, true, true, false, false],
    [false, true, false, true, false, true],
    [false, true, false, true, true, false],
    [false, true, true, false, true, false]
  ];

  ngOnInit(): void {
    this.ctx = this.canvas.nativeElement.getContext('2d');
  }

  public onlyDigits(e: KeyboardEvent): boolean {
    const key: string = e.key;
    if (key < '0' || key > '9')
      return false;

    return true;
  }

  public isValid(input: string) {
    this.valid = (input.length === 12);
  }

  public generate(input: string) {

    var inputArr: number[] = [];
    for (var i = 0; i < input.length; i++)
      inputArr.push(parseInt(input[i]));

    inputArr.push(this.getCheckSum(inputArr));

    const leftParity = this.parity[inputArr[0]];

    var modules: [string, number, number][] = [];
    modules.push(["0000000", inputArr[0], this.stripeHeight]);
    modules.push(["101", -1, this.stripeHeight + 20]);

    var i = 1;
    while (i < 7) {
      if (leftParity[i - 1])
        modules.push([this.leftEven[inputArr[i]], inputArr[i], this.stripeHeight]);
      else
      modules.push([this.leftOdd[inputArr[i]], inputArr[i], this.stripeHeight]);
      i++;
    }

    modules.push(["01010", -1, this.stripeHeight + 20]);

    while (i < inputArr.length) {
      modules.push([this.invert(this.leftOdd[inputArr[i]]), inputArr[i], this.stripeHeight]);
      i++;
    }

    modules.push(["101", -1, this.stripeHeight + 20]);
    modules.push(["0000000", -1, 0]);

    var width: number = 0;
    for (var i = 0; i < modules.length; i++)
      width += this.stripeWidth * modules[i][0].length;

    var height = this.stripeHeight + 20;

    this.canvas.nativeElement.width = width;
    this.canvas.nativeElement.height = height;

    this.drawCode(modules, 0, 0);
  }

  private getCheckSum(inputArr: number[]) {
    var odd: number = 0;
    var even: number = 0;
    for (var i = inputArr.length - 1; i > 0; i -= 2) {
      odd += inputArr[i];
      if (i - 1 >= 0)
        even += inputArr[i-1];
    }

    return (10 - ((3 * odd + even) % 10)) % 10;
  }

  private drawCode(modules: [string, number, number][], x: number, y: number) {
    var offset = x;
    var module: [string, number, number];
    for (var i = 0; i < modules.length; i++) {
      module = modules[i];
      this.drawModule(module, offset, y);
      offset += this.stripeWidth * module[0].length;
    }
  }

  private drawModule(module: [string, number, number], x: number, y:number) {
    for (var i = 0; i < module[0].length; i++) {
      if (module[0].charAt(i) === '1') 
        this.ctx.fillRect(x + i * this.stripeWidth, y, this.stripeWidth, module[2]);
    }
    if (module[1] > 0)
      this.ctx.fillText(String(module[1]), x, this.stripeHeight + 20, this.stripeWidth * module[0].length);
  }

  private invert(module: string): string {
    var res: string = '';
    for (var i = 0; i < module.length; i++) {
      module.charAt(i) === '1' ? res += '0' : res += '1'
    }
    return res;
  }
}