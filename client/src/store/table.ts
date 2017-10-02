import { StateSync } from '@state-sync/js-client';
import { ItemListSyncModel } from '../models/ItemListSyncModel';
import { ItemListQuery, ItemListQueryDefault } from '../models/ItemListQuery';
import { ItemListPaginationSyncModelDefault } from '../models/ItemListPaginationSyncModel';

export interface TableItem {
    id: string;
    name: string;
    status: string;
}

export interface TableState {
    query: ItemListQuery;
    filter: string;
    items: ItemListSyncModel<TableItem>;
}

export const AREA_TABLE = 'table';

const initialState: TableState = {
    query: ItemListQueryDefault,
    filter: '',
    items: {
        data: [],
        permissions: {},
        pagination: ItemListPaginationSyncModelDefault
    }
};

export const tableReducer = StateSync().declareArea(AREA_TABLE, initialState);

