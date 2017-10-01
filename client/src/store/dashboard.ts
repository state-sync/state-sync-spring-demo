import { StateSync } from '@state-sync/js-client';

const initialState = {};
export default StateSync().declareArea('dashboard', initialState);

