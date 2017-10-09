import * as classNames from 'classnames';
import * as React from 'react';
import { NavLink } from 'react-router-dom';
import { Badge, Nav, NavItem } from 'reactstrap';
// import SidebarFooter from '../SidebarFooter/SidebarFooter';
import SidebarForm from '../SidebarForm/SidebarForm';
import SidebarHeader from '../SidebarHeader/SidebarHeader';
import navs from './_nav';
import { BadgeDef, NavItemDef } from './NavItem';
import { ReactNode } from 'react';

let nav = navs as NavItemDef[];

class Sidebar extends React.Component {

    handleClick(e: any) {
        e.preventDefault();
        e.target.parentElement.classList.toggle('open');
    }

    activeRoute(routeName: string, props: any) {
        // return this.props.location.pathname.indexOf(routeName) > -1
        // ? 'nav-item nav-dropdown open' : 'nav-item nav-dropdown';
        return props.location.pathname.indexOf(routeName) > -1 ? 'nav-item nav-dropdown open' : 'nav-item nav-dropdown';

    }

    // todo Sidebar nav secondLevel
    // secondLevelActive(routeName) {// return this.props.location.pathname.indexOf(routeName) > -1
    // ? 'nav nav-second-level collapse in' : 'nav nav-second-level collapse';
    // }

    render() {
        const props = this.props;
        const activeRoute = this.activeRoute;
        const handleClick = this.handleClick;

        // badge addon to NavItem
        const badge = (b?: BadgeDef): ReactNode => {
            if (b) {
                const classes = classNames(b.class);
                return (<Badge className={classes} color={b.variant}>{b.text}</Badge>);
            } else {
                return '';
            }
        };

        // simple wrapper for nav-title item
        const wrapper = (item: NavItemDef): ReactNode => {
            return (item.wrapper && item.wrapper.element ?
                (React.createElement(item.wrapper.element, item.wrapper.attributes, item.name))
                : item.name );
        };

        // nav list section title
        const title = (item: NavItemDef, key: number): ReactNode => {
            const classes = classNames('nav-title', item.class);
            return (<li key={key} className={classes}>{wrapper(item)} </li>);
        };

        // nav list divider
        const divider = (item: NavItemDef, key: number): ReactNode => (<li key={key} className="divider"/>);

        // nav item with nav link
        const navItem = (item: NavItemDef, key: number): ReactNode => {
            const classes = classNames('nav-link', item.class);
            return (
                <NavItem key={key}>
                    <NavLink to={item.url} className={classes} activeClassName="active">
                        <i className={item.icon}/>{item.name}{badge(item.badge)}
                    </NavLink>
                </NavItem>
            );
        };

        // nav dropdown
        const navDropdown = (item: NavItemDef, key: number): ReactNode => {
            return (
                <li key={key} className={activeRoute(item.url, props)}>
                    <a className="nav-link nav-dropdown-toggle" href="#" onClick={handleClick}>
                        <i className={item.icon}/>{item.name}</a>
                    <ul className="nav-dropdown-items">
                        {navList(item.children)}
                    </ul>
                </li>);
        };

        // nav link
        const navLink = (item: NavItemDef, idx: number): ReactNode =>
            item.title ? title(item, idx) :
                item.divider ? divider(item, idx) :
                    item.children ? navDropdown(item, idx)
                        : navItem(item, idx);

        // nav list
        const navList = (items?: NavItemDef[]): ReactNode => {
            return items ? items.map((item, index) => navLink(item, index)) : '';
        };

        // sidebar-nav root
        return (
            <div className="sidebar">
                <SidebarHeader/>
                <SidebarForm/>
                <nav className="sidebar-nav">
                    <Nav>
                        {navList(nav)}
                    </Nav>
                </nav>
                {/*<SidebarFooter/>*/}
            </div>
        );
    }
}

export default Sidebar;
