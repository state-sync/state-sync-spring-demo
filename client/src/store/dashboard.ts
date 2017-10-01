import { StateSync } from '@state-sync/js-client';

export interface DashboardState {
    watch: boolean;
}

const initialState: DashboardState = {
    watch: true
};

export const dashboardReducer = StateSync().declareArea('dashboard', initialState);

