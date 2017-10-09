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
    sortDirection: 'asc' | 'desc';

    /**
     * Page number
     */
    page: number;

    /**
     * Page size
     */
    pageSize: number;
}

export const ItemListQueryDefault: ItemListQuery = {
    search: '',
    sortBy: '',
    sortDirection: 'asc',
    page: 0,
    pageSize: 5
};

export const SetSort = (col: string) => (state: any) => {
    return {
        ...state,
        sortBy: col,
        sortDirection: col === state.sortBy ?
            state.sortDirection === 'asc' ? 'desc' : 'asc' :
            'asc'
    };
};