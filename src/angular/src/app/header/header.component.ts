import { Component, OnInit } from '@angular/core';
import Typed from 'typed.js';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    const options = {
      strings: ['science', 'entertainment', 'general',
        'health', 'business', 'sports', 'technology'],
      typeSpeed: 100,
      backSpeed: 150,
      showCursor: true,
      cursorChar: '|',
      loop: true
    };

    const typed = new Typed('#typed-element', options);
  }

}
