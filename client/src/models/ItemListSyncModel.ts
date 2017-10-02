/**
 * Interface to data items list additionally annotated by permissions.
 * Permissions define set of operations user can do on list level (like create, edit, delete, etc.)
 */
import { ItemListPaginationSyncModel } from './ItemListPaginationSyncModel';
import { ItemSyncModel } from './ItemSyncModel';

export interface ItemListSyncModel<Data> {
    /**
     * Actual data
     */
    data: Array<ItemSyncModel<Data>>;
    /**
     * Permissions
     */
    permissions: {[key: string]: boolean};

    /**
     * Pagination from server side
     */
    pagination: ItemListPaginationSyncModel;
}