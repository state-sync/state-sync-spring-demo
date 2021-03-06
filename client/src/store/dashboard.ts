import { StateSync } from '@state-sync/js-client';
import { LinearComponentProps } from 'react-chartjs-2';

export interface DashboardState {
    settings: {
        watch: boolean;
    };
    name?: string;
    membersOnline: number;
    chart1: LinearComponentProps;
}

export const AREA_DASHBOARD = 'dashboard';

const initialState: DashboardState = {
    settings: {
        watch: true
    },
    membersOnline: 0,
    chart1: {
        data: {
            labels: [],
            datasets: []
        }
    }
};

export const dashboardReducer = StateSync().declareArea(AREA_DASHBOARD, initialState);