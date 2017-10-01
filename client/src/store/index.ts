import { createStore, applyMiddleware, combineReducers } from 'redux';
import { composeWithDevTools } from 'redux-devtools-extension';
import { StateSync } from '@state-sync/js-client';

import { dashboardReducer, DashboardState } from './dashboard';

let reducers = combineReducers({
    dashboard : dashboardReducer,
    syncStatus: StateSync().declareStatusArea()
});

export interface State {
    dashboard: DashboardState;
}

const composeEnhancers = composeWithDevTools({
    // options like actionSanitizer, stateSanitizer
});

export let store = createStore(reducers, composeEnhancers(applyMiddleware()));
let sync = StateSync();
sync.initSync(store, 'ws://localhost:8080/schedule');
