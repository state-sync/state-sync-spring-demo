import * as React from 'react';
import { Redirect, Route, Switch } from 'react-router-dom';
import { Container } from 'reactstrap';
import Header from '../components/Header/Header';
import Sidebar from '../components/Sidebar/Sidebar';
// import Breadcrumb from '../components/Breadcrumb/Breadcrumb';
import Aside from '../components/Aside/Aside';
import Footer from '../components/Footer/Footer';

import Dashboard from '../views/Dashboard/Dashboard';
import TasksComponent from '../views/Tasks/TasksComponent';
import TasksEditComponent from '../views/Tasks/TasksEditComponent';

class Full extends React.Component {
    render() {
        return (
            <div className="app">
                <Header/>
                <div className="app-body">
                    <Sidebar {...this.props}/>
                    <main className="main">
                        {/*<Breadcrumb/>*/}
                        <Container fluid={true}>
                            <Switch>
                                <Route path="/dashboard" component={Dashboard}/>
                                <Route path="/task/list" component={TasksComponent}/>
                                <Route path="/task/edit/:taskId" component={TasksEditComponent}/>
                                <Redirect from="/" to="/dashboard"/>
                            </Switch>
                        </Container>
                    </main>
                    <Aside/>
                </div>
                <Footer/>
            </div>
        );
    }
}

export default Full;
