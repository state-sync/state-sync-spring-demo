import { StateSync } from '@state-sync/js-client';

export interface DebugState {
}

export const AREA_DEBUG = 'debug';

const initialState: DebugState = {
};

export const debugReducer = StateSync().declareArea(AREA_DEBUG, initialState);