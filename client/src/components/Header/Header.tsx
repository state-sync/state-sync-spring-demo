import * as React from 'react';
import {
  NavbarToggler,
  NavbarBrand,
} from 'reactstrap';
import { MouseEvent } from 'react';

interface Props {

}
interface State {

}
class Header extends React.Component<Props, State> {

    mobileSidebarToggle(e: MouseEvent<HTMLAnchorElement>) {
        e.preventDefault();
        document.body.classList.toggle('sidebar-mobile-show');
    }

    sidebarMinimize(e: MouseEvent<HTMLAnchorElement>) {
        e.preventDefault();
        document.body.classList.toggle('sidebar-minimized');
    }

    render() {
    return (
      <header className="app-header navbar">
        <NavbarToggler className={'d-lg-none'} onClick={this.mobileSidebarToggle}>&#9776;</NavbarToggler>
        <NavbarBrand href="#"></NavbarBrand>
        <NavbarToggler className="d-md-down-none mr-auto" onClick={this.sidebarMinimize}>&#9776;</NavbarToggler>
      </header>
    );
  }
//     sidebarToggle(e: MouseEvent<?>) {
//     e.preventDefault();
//     document.body.classList.toggle('sidebar-hidden');
// }
//
//
// asideToggle(e: MouseEvent): void {
//     e.preventDefault();
// document.body.classList.toggle('aside-menu-hidden');
// }
}

export default Header;
