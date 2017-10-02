/**
 * Interface to query part of area
 */
export interface ItemListQuery {
    /**
     * text search
     */
    search: string;
    /**
     * sort by column
     */
    sortBy: string;
    /**
     * sort by column
     */
    sortOrder: 'asc' | 'desc';
}

export const ItemListQueryDefault: ItemListQuery = {
    search: '',
    sortBy: '',
    sortOrder: 'asc'
};