import * as React from 'react';
import { ItemListQuery } from '../../models/ItemListQuery'

interface Props {
    query: ItemListQuery;
    forId: string;
}

export class ColSortIcon extends React.Component<Props> {
    render(): JSX.Element {
        const {query, forId} = this.props;

        if (forId === query.sortBy) {
            if (query.sortDirection === 'asc') {
                return (<i className="fa fa-sort-asc" aria-hidden="true"/>);
            } else {
                return (<i className="fa fa-sort-desc" aria-hidden="true"/>);
            }
        } else {
            return (<i/>);
        }
    }
}