import { Component } from '@angular/core';
import { MatSidenavModule } from '@angular/material/sidenav';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faBars, faHome, faTools, faUser, faRightFromBracket } from '@fortawesome/free-solid-svg-icons';



@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.css'],
  standalone: true,
  imports: [MatSidenavModule, FontAwesomeModule],
})
export class AppComponent {
  faBars = faBars;
  faHome = faHome;
  faTools = faTools;
  faUser = faUser;
  faRightFromBracket = faRightFromBracket;

}
