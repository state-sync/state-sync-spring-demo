export interface ItemListPaginationItem {
    page: number;
    disabled: boolean;
    type: string;
    label: string;
    badge: string;
}
/**
 * Interface to paginatin data provided by server
 */
export interface ItemListPaginationSyncModel {
    /**
     * Zero base offset from beginning
     */
    offset: number;
    /**
     * Page size
     */
    size: number;
    /**
     * Total number of items
     */
    total: number;
    /**
     * Zero base index of current page
     */
    currentPage: number;
    /**
     * Total count of pages
     */
    totalPages: number;

    pages: ItemListPaginationItem[];
}

export const ItemListPaginationSyncModelDefault: ItemListPaginationSyncModel = {
    offset: 0,
    size: 0,
    total: 0,
    currentPage: 0,
    totalPages: 0,
    pages: []
};