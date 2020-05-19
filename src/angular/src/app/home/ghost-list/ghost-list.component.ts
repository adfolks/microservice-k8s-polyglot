import { Component, Input } from '@angular/core';


@Component({
  selector: 'ghost-list',
  template: `
    <mat-card  *ngFor='let it of ghosts'
          class='user' fxFlex="50" fxFlex.xs="100" >
          <div class="avatar">
            </div>
      <div class="lines">
        <h2></h2>
        <h3></h3>
        <p></p>
      </div>
    </mat-card>
  `,
  styleUrls: [
    './ghost-list.scss',
    './ghost.scss'
  ]
})
export class GhostListComponent {
  @Input() ghosts: any[];
}
