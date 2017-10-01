import * as React from 'react';
import * as ReactDOM from 'react-dom';
import App from './App';
import registerServiceWorker from './registerServiceWorker';

import { Provider } from 'react-redux';
import { Route, Router, Switch } from 'react-router-dom';
import createBrowserHistory from 'history/createBrowserHistory';

import 'font-awesome/css/font-awesome.min.css';
import 'simple-line-icons/css/simple-line-icons.css';

// Containers
import Full from './containers/Full';
import { store } from './store';

import './index.css';

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
  <App />,
  document.getElementById('root') as HTMLElement
);
registerServiceWorker();
