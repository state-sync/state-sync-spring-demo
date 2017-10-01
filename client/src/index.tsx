import 'font-awesome/css/font-awesome.min.css';
import createBrowserHistory from 'history/createBrowserHistory';
import * as React from 'react';
import * as ReactDOM from 'react-dom';

import { Provider } from 'react-redux';
import { Route, Router, Switch } from 'react-router-dom';
import 'simple-line-icons/css/simple-line-icons.css';
import App from './App';
// Containers
import Full from './containers/Full';

import './index.css';
import registerServiceWorker from './registerServiceWorker';
import { store } from './store';

const browserHistory = createBrowserHistory();

ReactDOM.render((
    <Provider store={store}>
        <Router history={browserHistory}>
            <Switch>
                <Route path="/" component={Full}/>
            </Switch>
        </Router>
    </Provider>
), document.getElementById('root'));

registerServiceWorker();

ReactDOM.render(
    <App/>,
    document.getElementById('root') as HTMLElement
);
registerServiceWorker();
