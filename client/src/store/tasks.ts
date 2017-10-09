import { StateSync } from '@state-sync/js-client';
import { ItemListSyncModel } from '../models/ItemListSyncModel';
import { ItemListQuery, ItemListQueryDefault } from '../models/ItemListQuery';
import { ItemListPaginationSyncModelDefault } from '../models/ItemListPaginationSyncModel';

export interface TableItem {
    id: string;
    summary: string;
    status: string;
}
export interface NewTaskForm {
    summary: string;
    message: string;
    status: string;
}

export interface TasksState {
    newTask: NewTaskForm;
    query: ItemListQuery;
    items: ItemListSyncModel<TableItem>;
}

export const AREA_TASKS = 'tasks';

const initialState: TasksState = {
    query: ItemListQueryDefault,
    newTask : {
        summary: '',
        message: 'Add new task',
        status: 'success'
    },
    items: {
        data: [],
        permissions: {},
        pagination: ItemListPaginationSyncModelDefault
    }
};

export const tasksReducer = StateSync().declareArea(AREA_TASKS, initialState);