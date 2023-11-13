import { Component } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatTooltipModule } from '@angular/material/tooltip';
import { RouterLink, RouterOutlet } from '@angular/router';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faBars, faBox, faFilter, faGear, faHome, faLocationDot, faRightFromBracket, faTruck, faUser } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.css'],
  standalone: true,
  imports: [MatSidenavModule, FontAwesomeModule, MatButtonModule, MatTooltipModule, RouterLink, RouterOutlet],
})
export class AppComponent {
  faBars = faBars;
  faBox = faBox;
  faHome = faHome;
  faFilter = faFilter;
  faTruck = faTruck;
  faLocationDot = faLocationDot;
  faGear = faGear;
  faUser = faUser;
  faRightFromBracket = faRightFromBracket;

}
