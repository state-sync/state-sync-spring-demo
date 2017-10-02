import { createStore, applyMiddleware, combineReducers } from 'redux';
import { composeWithDevTools } from 'redux-devtools-extension';
import { StateSync } from '@state-sync/js-client';

import { dashboardReducer, DashboardState } from './dashboard';
import { debugReducer, DebugState } from "./debug";

let reducers = combineReducers({
    dashboard : dashboardReducer,
    debug : debugReducer,
    syncStatus: StateSync().declareStatusArea()
});

export interface State {
    dashboard: DashboardState;
    debug: DebugState;
}

const composeEnhancers = composeWithDevTools({
    // options like actionSanitizer, stateSanitizer
});

export let store = createStore(reducers, composeEnhancers(applyMiddleware()));
StateSync().initSync(store, 'ws://localhost:8080/state-sync');
