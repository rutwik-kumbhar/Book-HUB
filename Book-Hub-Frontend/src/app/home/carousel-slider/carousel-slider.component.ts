import { Component, OnInit } from '@angular/core';
import { slider } from 'src/Data/slider';

@Component({
  selector: 'app-carousel-slider',
  templateUrl: './carousel-slider.component.html',
  styleUrls: ['./carousel-slider.component.css']
})
export class CarouselSliderComponent implements OnInit {

  carouselSlider:any = slider;

  constructor(){
    this.carouselSlider = slider;
  }
  ngOnInit(): void {
     this.carouselSlider = slider;
  }

  


 

  

}
