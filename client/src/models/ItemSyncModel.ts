/**
 * Interface to data item additionally annotated by permissions.
 * Permissions define set of operations user can do (like edit, delete, etc.)
 */
export interface ItemSyncModel<Data> {
    /**
     * Actual data
     */
    data: Data;
    /**
     * Permissions
     */
    permissions: {[key: string]: boolean};
}